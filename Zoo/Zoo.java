import java.util.*;

public class Zoo
{
    private HashSet<Tier> tiere;

    public Zoo()
    {
        tiere = new HashSet<Tier>();
    }

    public void grundbestandErzeugen()
    {
        tiere.add(new Hund());
        tiere.add(new Hund());
        tiere.add(new Hamster());
        tiere.add(new Adler());
        tiere.add(new Adler());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
    }

    public void alleTiereFüttern()
    {
        for(Tier t: tiere)
        {
            t.fressen();
        }
    }

    public int getZahlDerTiere()
    {
        return tiere.size();
    }

    public void addHund()
    {
        tiere.add(new Hund());
    }

    public void addHamster()
    {
        tiere.add(new Hamster());
    }

    public void addAdler()
    {
        tiere.add(new Adler());
    }

    public void addWellensittich()
    {
        tiere.add(new Wellensittich());
    }

    // Hmm, wie kann die Methode funktionieren?
    public void addTier(Tier t)
    {
        tiere.add(t);
    }
}
