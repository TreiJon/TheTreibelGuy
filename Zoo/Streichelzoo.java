import java.util.*;

public class Streichelzoo
{
    private HashSet<Streicheltier> tiere;
    
    public int getGesamtWert()
    {
        int preis = 0;
        
        for(Streicheltier s: tiere)
        {
            preis =+ s.getWert();
        }
        return preis;
    }
}
