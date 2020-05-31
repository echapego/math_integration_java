package integration.NumericApproach;

import integration.Function;
import integration.IdenticalUpperAndLowerLimitsException;
import integration.Integrator;

public class NumericIntegrator <T extends NumericApproach> implements Integrator {
    private T approach;
    private static final double eps = 10e-6;

    public NumericIntegrator (T approach) {
        this.approach = approach;
    }

    @Override
    public double integrate(Function integrand, double a, double b){

        if (Double.isInfinite(a) || Double.isInfinite(b)){
            throw new IllegalArgumentException("Numeric approach is not working with infinity limits");
        }
        if (a == b){
            throw new IdenticalUpperAndLowerLimitsException();
        }
        double previousResult, currentResult = 0;
        double h;
        int n = 2;
        do {
            previousResult = currentResult;
            currentResult = 0;
            h = (b - a) / n;
            for (double left = a; left <= b; left += h) {
                double right = left + h;
                currentResult += approach.getArea(integrand, left, right);
            }
            n *= 2;
        } while (Math.abs(currentResult - previousResult ) > eps);
        return currentResult;
    }
}
