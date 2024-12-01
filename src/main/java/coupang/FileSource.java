package coupang;

public class FileSource implements Source {
    @Override
    public Metric getMetric() {
        System.out.println("parse metric from file source");
        return Metric.defaultMetric();
    }
}
