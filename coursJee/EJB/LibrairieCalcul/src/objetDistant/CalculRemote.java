package objetDistant;

import javax.ejb.Remote;

@Remote
public interface CalculRemote 
{
    public double racine3(double a);
    public double racine2(double a);
    public double carre(double a);
}
