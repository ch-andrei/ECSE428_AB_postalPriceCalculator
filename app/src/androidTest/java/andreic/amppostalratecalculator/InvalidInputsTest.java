package andreic.amppostalratecalculator;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrei Chubarau and Nadine Bou Khzam on 2016-02-11.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class InvalidInputsTest {

    // used for assertEquals for floating point number comparisons
    public double delta = 0.1;

    // SOME FORMATTING AND USED STRING VALUES

    //    final String[] destinations = new String[]{"Canada", "USA", "International", "Select a destination"};
    //    protected static double computePostalRate(double length, double width, double depth, double weight, String destination)

    @Test
    public void invalidInputTest18() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(-100, 120, 10, 100, "Canada"), delta);
    }

    @Test
    public void invalidInputTest19() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(400, 120, 10, 100, "USA"), delta);
    }

    @Test
    public void invalidInputTest20() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 50, 10, 100, "International"), delta);
    }

    @Test
    public void invalidInputTest21() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 300, 10, 100, "Canada"), delta);
    }

    @Test
    public void invalidInputTest22() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 120, -0.15, 100, "USA"), delta);
    }

    @Test
    public void invalidInputTest23() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 120, 25, 100, "International"), delta);
    }

    @Test
    public void invalidInputTest24() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 120, 10, 1, "Canada"), delta);
    }

    @Test
    public void invalidInputTest25() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 120, 10, 600, "USA"), delta);
    }

    @Test
    public void invalidInputTest26() throws Exception {
        assertEquals(-2.0, MainActivity.computePostalRate(220, 120, 10, 100, "abc"), delta);
    }

    @Test
    public void invalidInputTest28() throws Exception {
        assertEquals(-1.0, MainActivity.computePostalRate(220, 120, 10, 100, null), delta);
    }
}