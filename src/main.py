import json
from datetime import datetime
import time
import random

from tasks import process_job_request

with open('products.json', 'r') as f:
    products = json.load(f)

with open('proxies.json', 'r') as f:
    proxies = json.load(f)

f_joblog = open('joblog.jl', 'a+')
f_profiles = open('profiles.txt', 'a+')
f_results = open('results.jl', 'a+')

proxy_idx = profile_idx = 0
for product in products:
    payload = {
        'product_id': product['product_id'],
        'store_id': product['store_id'],
    }
    attempt = 0
    while True:
        # Random sleep between 55 and 60 seconds
        time.sleep(random.randint(55, 60))

        attempt = attempt + 1

        if proxy_idx == len(proxies): proxy_idx = 0
        payload['proxy'] = proxies[proxy_idx]
        proxy_idx = proxy_idx + 1

        # Uncomment this if profiles are needed
        # if profile_idx == len(profiles): profile_idx = 0
        # payload['profile_id'] = profiles[profile_idx]
        # profile_idx = profile_idx + 1

        status, details, extras = process_job_request(payload=payload)
        job_status = None

        if status:
            if (not details['error']) or details['error'] == 266900002:
                job_status = 'SUCCESS'
            elif details['error'] == 90309999:
                job_status = 'BLOCKED'
            else:
                job_status = 'SUSPICIOUS_ERROR'
        else:
            job_status = details['code']

        # store job payload and status immediately after each attempt
        joblog = payload.copy()
        joblog['status'] = job_status
        joblog['timestamp'] = str(datetime.now())
        f_joblog.write(json.dumps(joblog) + '\n')
        f_joblog.flush()  # Force the data to be written to the file immediately

        # store profile_id's only if job is not BLOCKED
        if job_status != 'BLOCKED':
            f_profiles.write(extras['profile_id'] + '\n')

        # store result immediately if the job is successful
        if job_status == 'SUCCESS':
            result = payload.copy()
            result['result'] = details
            f_results.write(json.dumps(result) + '\n')
            f_results.flush()  # Ensure that the result is written immediately
            break

        # break after trying the same url for x times
        if attempt == 4:
            break

f_joblog.close()
f_profiles.close()
f_results.close()
