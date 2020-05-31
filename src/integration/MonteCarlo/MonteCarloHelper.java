package integration.MonteCarlo;

import distributions.*;
import integration.IdenticalUpperAndLowerLimitsException;
import integration.NotSupportedLimitsException;

public class MonteCarloHelper {

    public static ContinuousDistribution getDistribution (double a, double b) {
        if (a == b) {
            throw new IdenticalUpperAndLowerLimitsException();
        }
        if (a > b) {
            throw new IllegalArgumentException("a is supposed to be less than b");
        }

        if (a == 0 && b == Double.POSITIVE_INFINITY) {
            return new ExponentialDistribution();
        } else if (a == Double.NEGATIVE_INFINITY && b == Double.POSITIVE_INFINITY) {
            return new NormalDistribution();
        } else if (Double.isFinite(a) && Double.isFinite(b)){
            return new distributions.UniformDistribution(a, b);
        } else {
            throw new NotSupportedLimitsException("These limits are not supported. " +
                    "Consider splitting into the following parts: " +
                    "[finite a; finite b] or [0; +inf]");
        }
    }
}
