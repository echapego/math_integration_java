package integration.NumericApproach;

import integration.Function;

public class RightRiemannSum implements NumericApproach {
    @Override
    public double getArea(Function function, double left, double right) {
        return function.f(right) * (right - left);
    }
}
