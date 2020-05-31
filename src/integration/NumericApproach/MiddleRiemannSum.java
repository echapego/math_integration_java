package integration.NumericApproach;

import integration.Function;

public class MiddleRiemannSum implements NumericApproach {
    @Override
    public double method_x(Function function, double left, double right) {
        return function.f((right + left) / 2) * (right - left);
    }
}
