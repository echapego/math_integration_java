package distributions;

public abstract class ContinuousDistribution extends Distribution {

    public abstract double PDF(double x);
    public abstract double generate();

}
