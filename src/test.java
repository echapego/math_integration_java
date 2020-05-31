import integration.Function;
import integration.IdenticalUpperAndLowerLimitsException;
import integration.MonteCarlo.MonteCarloIntegrator;
import integration.NotSupportedLimitsException;
import integration.NumericApproach.*;
import integration.MonteCarlo.*;

public class test {

    public static void main(String[] args) {

        /*Test on working set*/
        Function integrand;
        NumericIntegrator<LeftRiemannSum> approachLeft = new NumericIntegrator<>(new LeftRiemannSum());
        NumericIntegrator<RightRiemannSum> approachRight = new NumericIntegrator<>(new RightRiemannSum());
        NumericIntegrator<MiddleRiemannSum> approachMiddle = new NumericIntegrator<>(new MiddleRiemannSum());
        NumericIntegrator<TrapezoidalRule> approachTrapezoidal = new NumericIntegrator<>(new TrapezoidalRule());
        MonteCarloIntegrator monteCarloIntegrator = new MonteCarloIntegrator();
        double a, b;

        System.out.println("int(x^2dx, x = 0..2) = 2.(6)");
        integrand = (x) -> x * x;
        a = 0;
        b = 2;

        double result = monteCarloIntegrator.integrate(integrand, a, b);
        System.out.println("Monte Carlo result: " + result);

        System.out.print("Left rectangles result: ");
        result = approachLeft.integrate(integrand, a, b);
        System.out.println(result);

        System.out.print("Right rectangles result: ");
        result = approachRight.integrate(integrand, a, b);
        System.out.println(result);

        System.out.print("Middle rectangles result: ");
        result = approachMiddle.integrate(integrand, a, b);
        System.out.println(result);

        System.out.print("Trapezoidal result: ");
        result = approachTrapezoidal.integrate(integrand, a, b);
        System.out.println(result);

        /*b = +inf test*/
        System.out.println();
        System.out.println("int(exp(-x^2)dx, x = 0..+inf) = 0.88622");
        integrand = (x)->Math.exp(-x * x);
        a = 0;
        b = Double.POSITIVE_INFINITY;

        result = monteCarloIntegrator.integrate(integrand, a, b);
        System.out.println("Monte Carlo result: " + result);

        try {
            System.out.print("Trapezoidal result: ");
            result = approachTrapezoidal.integrate(integrand, a, b);
            System.out.println(result);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

        /*a == b test*/

        System.out.println();
        System.out.println("int(xdx, x = 1..1) = 0");
        integrand = (x) -> x;
        a = b = 1;

        try {
            System.out.print("Monte Carlo result: ");
            result = monteCarloIntegrator.integrate(integrand, a, b);
        } catch (IdenticalUpperAndLowerLimitsException e){
            result = 0;
            System.out.println(result);
        }

        try {
            System.out.print("Right rectangles result: ");
            result = approachRight.integrate(integrand, a, b);
            System.out.println(result);
        } catch (IdenticalUpperAndLowerLimitsException e){
            result = 0;
            System.out.println(result);
        }

        /*a = -inf test*/
        System.out.println();
        System.out.println("int(exp(x)dx, x=-inf..0) = 1");
        integrand = (x)->Math.exp(x);
        a = Double.NEGATIVE_INFINITY;
        b = 0;

        try{
            System.out.print("Monte Carlo result: ");
            result = monteCarloIntegrator.integrate(integrand, a, b);
            System.out.println(result);
        } catch (NotSupportedLimitsException e){
            System.out.println(e.toString());
        }
        try{
            System.out.print("Left rectangles result: ");
            result = approachLeft.integrate(integrand, a, b);
            System.out.println(result);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}
