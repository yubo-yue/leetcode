package coupang;

public class MQSink implements Sink {
    @Override
    public void sendMetric(Metric m) {
        System.out.println("send metric to message queue");
    }
}
