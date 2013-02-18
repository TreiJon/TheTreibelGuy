
/**
 * Stack of cards
 */
public class Stack
{
    private Card top;

    public Stack(){
        this.top = null;
    }

    public boolean isEmpty(){
        if(top!=null)
            return false;
        else
            return true;
    }

    public Card getTop()
    {
        if (top != null)
        return top;
        return null;
    }

    public int getWertTop()
    {
        return top.getValue();
    }
    // anschauen, ablegen
    public void remove()
    {
        if (top != null)
        {
            Card temp = top.getNext();
            top.setNext(null);
            top = temp;
        }
    }

    public void add(Card c)
    {
        c.setNext(top);
        top = c;
    }

    public int count()
    {
        int count = 0;
        Card temp = top;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}

