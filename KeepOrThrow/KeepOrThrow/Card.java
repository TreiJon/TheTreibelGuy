import java.util.Random;
/**
 * Do what a card can do.
 */
public class Card
{
    private int value;
    private Card next;

    public Card(){
        value = (new Random().nextInt(13)) +2;
    }

    public Card(int value)
    {
        this.value = value;
    }

    public Card getNext(){
        return next;
    }

    public int getValue(){
        return value;
    }

    public void setNext(Card next){
        this.next = next;
    }

    public void setValue(int value){
        if(value >1 && value <15)
            this.value = value;
        else
            this.value = 0;
    }
}
