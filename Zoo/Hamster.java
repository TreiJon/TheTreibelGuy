
public class Hamster extends Tier  implements Streicheltier, Schlachtbar
{
    public void fressen ()
    {
        System.out.println("nack, nack, nack. Gib mir mehr Körner...");
    }

    public void laufen ()
    {
        System.out.println("trippeldi trapp, trippeldi trapp");
    }

    public void imRadSpielen ()
    {
        System.out.println("Huiuiui, schneller, jawohl, ... uups, ich glaub ich krieg'n Drehwurm!!!");
    }

    public int getWert()
    {
        return 15 - getAlter();
    }

    public int getGewicht()
    {
        if(getAlter() >= 1)
        {
            return 300;
        }
        else 
            return 0;
    }
}

