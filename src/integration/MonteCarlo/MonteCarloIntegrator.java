package integration.MonteCarlo;

import distributions.ContinuousDistribution;
import integration.Function;
import integration.Integrator;

public class MonteCarloIntegrator implements Integrator {

    @Override
    public double integrate(Function integrand, double a, double b) {
        int n = 10000;
        ContinuousDistribution distribution = MonteCarloHelper.getDistribution(a, b);

        double result = 0;
        for (int i = 0; i < n; i++) {
            double ksi = distribution.generate();
            result += integrand.f(ksi) / distribution.PDF(ksi);
        }
        return result / n;
    }
}
