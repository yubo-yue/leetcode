package coupang;

public class APISource implements Source {
    @Override
    public Metric getMetric() {
        System.out.println("get metric from API source");
        return Metric.defaultMetric();
    }
}
