package distributions;

public class ExponentialDistribution extends ContinuousDistribution {

    private double lambda;

    public ExponentialDistribution() {
        this.lambda = 1;
    }

    public ExponentialDistribution( double lambda ){
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }

    @Override
    public double PDF(double x) {
        return lambda * Math.exp(-lambda * x );
    }

    @Override
    public double generate() {
        double a = Math.random();
        return inverseCDF(a);
    }

    @Override
    public double variance() {
        return 1 / Math.pow(lambda, 2);
    }

    @Override
    public double mean() {
        return 1 / lambda;
    }

    @Override
    public double CDF(double x) {
        return 1 - Math.exp(-lambda * x);
    }

    @Override
    public double inverseCDF(double y) {
        return -Math.log(1 - y) / lambda;
    }
}
