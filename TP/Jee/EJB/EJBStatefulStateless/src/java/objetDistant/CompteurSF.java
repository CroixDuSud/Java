package objetDistant;

import javax.ejb.Stateful;

@Stateful
public class CompteurSF implements CompteurSFRemote
{
    private int cpt;

    public int getCpt()
    {
        return cpt;
    }

    public void setCpt(int a)
    {
        cpt = a;
    }
}
