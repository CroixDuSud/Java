package objetDistant;

import javax.ejb.Stateless;

@Stateless
public class Calcul implements CalculRemote 
{
    @Override
    public double racine3(double a) 
    {
        return Math.pow(a, 1/3.);
    }

    @Override
    public double racine2(double a) 
    {
        return Math.pow(a, 1/2.);
    }

    @Override
    public double carre(double a) 
    {
        return a * a;
    }
}
