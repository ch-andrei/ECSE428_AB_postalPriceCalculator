package andreic.amppostalratecalculator;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by AndreiCh on 2016-02-11.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class InvalidInputsTest {

    // SOME FORMATTING AND USED STRING VALUES

    //    final String[] letter_types = new String[]{"Standard", "Non-standard and Oversize", "Select a lettermail type"};
    //    final String[] destinations = new String[]{"Canada", "USA", "International", "Select a destination"};
    //    protected static double computePostalRate(double length, double width, double depth, double weight, String type, String destination)

    @Test
    public void invalidInputTest1() throws Exception {
        assertEquals(MainActivity.computePostalRate(0, -2, 0, 100000, null), -1, 0.1);
    }

    @Test
    public void invalidInputTest2() throws Exception {
        assertEquals(MainActivity.computePostalRate(0, 123213213, -5, 12, "asdadsad"), -1, 0.1);
    }

    @Test
    public void invalidInputTest3() throws Exception {
        assertEquals(MainActivity.computePostalRate(0, 123213213, -5, 12, ""), -1, 0.1);
    }

    // TODO
    // MORE TESTS
}