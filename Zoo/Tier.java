public abstract class Tier
{
    private int alter;

    public Tier()
    {
        alter = 0;
    }

    public int getAlter ()
    {
        return alter;
    }

    public void setAlter(int alter)
    {
        this.alter = alter;
    }

    public abstract void fressen ();

    public abstract void laufen ();

}
