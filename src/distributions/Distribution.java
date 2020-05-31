package distributions;

public abstract class Distribution {

    public abstract double variance();
    public abstract double mean();
    public abstract double CDF (double x) throws NotImplementedException;
    public abstract double inverseCDF(double y) throws NotImplementedException;

}





