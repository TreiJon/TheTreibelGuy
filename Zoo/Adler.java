
public class Adler extends Vogel implements Schlachtbar
{

    public void fressen ()
    {
        System.out.println("hack hack...");
    }

    public void laufen ()
    {
        System.out.println("trippeldi trapp will wieder fliegen");
    }

    
    public void fliegen ()
    {
        System.out.println("Gleitend und majestätisch schwebe ich dahin...");
    }
    
    public int getGewicht()
    {
        return 5000;
    }
}

