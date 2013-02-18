

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CardTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CardTest
{
    /**
     * Default constructor for test class CardTest
     */
    public CardTest()
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
    public void viewValue()
    {
        Card card1 = new Card(2);
        assertEquals(2, card1.getValue());
    }

    @Test
    public void setValue()
    {
        Card card2 = new Card(2);
        card2.setValue(5);
        assertEquals(5, card2.getValue());
    }

    @Test
    public void setNext()
    {
        Card card1 = new Card(5);
        Card card2 = new Card();
        card1.setNext(card2);
        assertNotNull(card1.getNext());
    }
}



