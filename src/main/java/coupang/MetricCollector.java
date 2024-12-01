package coupang;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MetricCollector {
    private static final long DEFAULT_PERIOD = 1;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;
    private static final int DEFAULT_POOL_SIZE = 5;

    private List<Source> sources;
    private Sink sink;

    private ScheduledExecutorService executor;

    private long period = DEFAULT_PERIOD;

    public MetricCollector(List<Source> sources, Sink sink) {
        this.sources = new LinkedList<>(sources);
        this.sink = sink;
        this.executor = Executors.newScheduledThreadPool(DEFAULT_POOL_SIZE);
    }

    public void start() {
        System.out.println("start to collector from source");
        for (Source source : sources)
            executor.scheduleAtFixedRate(new Task(source, sink), 0, period, DEFAULT_TIME_UNIT);
    }

    public void stop() {
        executor.shutdown();
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    private static class Task implements Runnable {
        private Source source;
        private Sink sink;

        public Task(Source source, Sink sink) {
            this.source = source;
            this.sink = sink;
        }

        @Override
        public void run() {
            sink.sendMetric(source.getMetric());
        }
    }
}
