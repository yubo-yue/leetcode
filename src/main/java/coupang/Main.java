package coupang;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Source fileSource = new FileSource();
        Source apiSource = new APISource();
        Sink mqSink = new MQSink();
        List<Source> sources = List.of(fileSource, apiSource);
        MetricCollector collectorA = new MetricCollector(sources, mqSink);
        collectorA.setPeriod(2); //2秒
        //invoke start, collector's internal thread pool will continue to work
        collectorA.start();

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
