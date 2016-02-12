package andreic.amppostalratecalculator;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by AndreiCh on 2016-02-11.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ValidInputsTest {

    // used for assertEquals for floating point number comparisons
    @Rule
    private double delta = 0.01;

    // SOME FORMATTING AND USED STRING VALUES

    //    final String[] letter_types = new String[]{"Standard", "Non-standard and Oversize", "Select a lettermail type"};
    //    final String[] destinations = new String[]{"Canada", "USA", "International", "Select a destination"};
    //    protected static double computePostalRate(double length, double width, double depth, double weight, String type, String destination)

    @Test
    public void validInputTest1() throws Exception{
        assertEquals(MainActivity.computePostalRate(160, 100, 1, 25, "Standard", "Canada" ), 1, delta);
    }

    // TODO
    // REPLACE A BUNCH MORE OF THESE
    @Test
    public void validInputTest2() throws Exception{
        assertEquals(MainActivity.computePostalRate(0, 0, 0, 0, "Standard", "Canada"), 5.0, delta);
    }
}