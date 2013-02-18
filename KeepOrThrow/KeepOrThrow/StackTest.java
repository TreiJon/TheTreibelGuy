

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StackTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StackTest
{
    private Stack stack1;

    /**
     * Default constructor for test class StackTest
     */
    public StackTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        stack1 = new Stack();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void checkEmptiness()
    {
        Stack stack1 = new Stack();
        assertEquals(true, stack1.isEmpty());
    }


//     @Test
//     public void pop()
//     {
//         Stack stack1 = new Stack();
//         assertNull(stack1.remove());
//         Card card1 = new Card(5);
//         stack1.add(card1);
//         assertEquals(card1, stack1.pop());
//         assertNull(stack1.peek());
//     }


    @Test
    public void add()
    {
        Card card1 = new Card(5);
        stack1.add(card1);
        assertEquals(card1, stack1.getTop());
    }

//     @Test
//     public void remove()
//     {
//         Card card1 = new Card(5);
//         Card card2 = new Card(6);
//         stack1.add(card1);
//         stack1.add(card2);
//         assertEquals(card1, stack1.remove());
//     }

    @Test
    public void count()
    {
        Card card1 = new Card(5);
        Card card2 = new Card(6);
        Card card3 = new Card(7);
        Card card4 = new Card(8);
        stack1.add(card1);
        stack1.add(card2);
        stack1.add(card3);
        stack1.add(card4);
        assertEquals(4, stack1.count());
    }
}









