public class Wellensittich extends Vogel implements Streicheltier
{
    int alter = 10;
    public void fressen ()
    {
        System.out.println("pick, pick, pick, pick");
    }

    public void laufen ()
    {
        System.out.println("tipp, tapp. Will wieder fliegen.");
    }

    public void fliegen ()
    {
        System.out.println("Flatter, flatter, flatter, will wieder sitzen ...");
    }
    
    public int getWert()
    {
        return 10 - getAlter();
    }
}

