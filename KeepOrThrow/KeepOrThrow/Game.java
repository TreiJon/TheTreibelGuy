// System.out.print('\f')
public class Game
{
    Stack stackS;
    Stack stackK;
    Stack stackT;

    public Game(int numberOfCards)
    {
        System.out.print('\f');
        this.stackS = new Stack();
        this.stackK = new Stack();
        this.stackT = new Stack();
        System.out.println("Let's get ready");
        for(int i = 1; i<= numberOfCards;i++)
        {
            stackS.add(new Card());
        }
    }

    public void look()
    {
        if(stackS.getTop() != null)
        {
            System.out.print('\f');
            System.out.println(stackS.getTop().getValue());
        }
        {
            System.out.print('\f');
            System.out.println("Ihr Stapel ist leer!");
        }
    }

    public void remove()
    {
        if(stackS.getTop() != null)
        {
            stackS.remove();
        }
        {
            System.out.print('\f');
            System.out.println("Ihr Stapel ist leer!");
        }

    }

    public void ablegen()
    {
        if(stackS.getTop() != null)
        {
            Card temp = stackS.getTop();
            stackS.remove();
            stackK.add(temp);
        }
        {
            System.out.print('\f');
            System.out.println("Ihr Stapel ist leer!");
        }
    }

    public void counter()
    {
        System.out.print('\f');
        System.out.println("Sie haben bereits "+ stackK.count() +" Karte(n) auf ihrem Keep-Stapel");
        if(stackK.count() != 0)
        {
            System.out.println("Die letzte Karte, die sie auf ihren Keep-Stapel gelgt haben war "+ stackK.getTop().getValue());
        }

    }
}
