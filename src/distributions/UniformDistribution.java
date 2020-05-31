package distributions;

public class UniformDistribution extends ContinuousDistribution {

    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public UniformDistribution (double a, double b) {
        if (a == b) {
            throw new IllegalArgumentException("Parameters of uniform distribution can't be equal.");
        } else {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    public double PDF(double x) {
        if (x >= a && x <= b) {
            return 1 / (b - a);
        }
        return 0;
    }

    @Override
    public double generate() {
        double a = Math.random();
        return inverseCDF(a);
    }

    @Override
    public double variance() {
        return Math.pow(b - a, 2) / 12;
    }

    @Override
    public double mean() {
        return (a + b) / 2;
    }

    @Override
    public double CDF(double x) {
        if (x < a) {
            return 0;
        } else if (x >= a && x <= b) {
            return (x - a) / (b - a);
        } else {
            return 1;
        }
    }

    @Override
    public double inverseCDF(double y) {
        return a + y * (b - a);
    }
}
