import java.util.Random;
public class Dice
{
    private boolean[] field;
    private boolean shit;
    private int money;
    private double dices;
    public Dice()
    {
        field = new boolean[6];
        shit = false;
        money = 0;
        dices = 0;
        for(boolean b: field)
        {
            b = false;
        }
        print();
    }

    public void print()
    {
        System.out.print('\f');
        int i = 0;
        for(boolean a: field)
        {
            i++;
            if(!a)
                System.out.println(i);
            else
                System.out.println("x");
        }
    }

    public void test()
    {
        dices = 0;
        double x = 0;
        int y = 0;
        for(int i = 1; i <= 100;i++)
        {
            for(int e = 0; e < field.length; e++)
            {
                field[e] = false;
            }
            while(!shit)
            {
                dice();
                x++;
            }
            shit = false;
        }
        System.out.println(x/100);
        //         System.out.println((x/dices));
    }

    public void printInfo()
    {
        if(!shit)
        {
            int i = 1;
            System.out.print('\f');
            for(boolean b: field)
            {
                System.out.println(i+": "+b);
                i++;
            }

        }
    }

    public int money()
    {
        money = 0;
        if(!shit)
        {
            for(boolean b: field)
            {
                if(b == true)
                {
                    money += 1;
                }
            }
        }
        return money;
    }

    public void dice()
    {
        if(!shit)
        {
            int r = new Random().nextInt(6);
            if(field[r] == false)
            {
                print();
                field[r] = true;
            }
            else
            {
                print();
                end();
            }
            dices++;
        }
    }

    public void end()
    {
        System.out.println("Du hast verloren. Alle Gewinne sind weg! :(");
        shit = true;
        money = 0;
    }
}