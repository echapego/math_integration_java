package distributions;

public class GeometricDistribution extends DiscreteDistribution {

    private double p;

    @Override
    public double PMF(int x) {
        return Math.pow((1 - p), x) * p;
    }

    @Override
    public double CDF(double x) {
        return 1 - Math.pow((1 - p), x + 1);
    }

    @Override
    public double inverseCDF(double y) {
        return 0;
    }

    @Override
    public double variance() {
        return (1 - p) / Math.pow(p, 2);
    }

    @Override
    public double mean() {
        return (1 - p) / p;
    }

    public GeometricDistribution (double p) {
        this.p = p;
    }
}