package coupang;

public class Metric {
    private String name;
    private String val;

    public Metric(String name, String val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "name='" + name + '\'' +
                ", val='" + val + '\'' +
                '}';
    }

    public static Metric defaultMetric() {
        return new Metric("DefaultNmae", "DefaultValue");
    }
}
