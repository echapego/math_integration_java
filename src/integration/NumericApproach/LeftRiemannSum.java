package integration.NumericApproach;

import integration.Function;

public class LeftRiemannSum implements NumericApproach {
    @Override
    public double method_x(Function function, double left, double right) {
        return function.f(left) * (right - left);
    }
}
