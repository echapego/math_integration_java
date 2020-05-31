package distributions;

public class NormalDistribution extends ContinuousDistribution {

    private static final double PI = 3.14159265359;
    private double mu;
    private double sigma;

    public double getMu() {
        return mu;
    }
    public double getSigma() {
        return sigma;
    }

    public NormalDistribution(){
        this.mu = 0;
        this.sigma = 1;
    }

    public NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    @Override
    public double PDF(double x) {
        return 1 / (sigma * Math.sqrt(2 * PI)) * Math.exp(-0.5 * Math.pow((x - mu)/sigma, 2));
    }

    @Override
    public double generate() {
        double a1 = Math.random();
        double a2 = Math.random();

        double z1 = Math.sqrt(-2 * Math.log(a1)) * Math.cos(2 * PI * a2);
        double z2 = Math.sqrt(-2 * Math.log(a1)) * Math.sin(2 * PI * a2);

        double x1 = mu + sigma * z1;
        double x2 = mu + sigma * z2;

        return x1;
    }

    @Override
    public double variance() {
        return Math.pow(sigma, 2);
    }

    @Override
    public double mean() {
        return mu;
    }

    @Override
    public double CDF(double x) throws NotImplementedException {
        throw new NotImplementedException("Normal distribution CDF is not available.");
    }

    @Override
    public double inverseCDF(double y) throws NotImplementedException {
        throw new NotImplementedException("Normal distribution inverse CDF is not available.");
    }
}
