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
        assertEquals(MainActivity.computePostalRate(200, 125, 3, 17, "Standard", "Canada"), 1, delta);
    }

    public void validInputTest2() throws Exception{
        assertEquals(MainActivity.computePostalRate(200,125, 3, 17, "Standard", "USA", 1.20, delta));
    }

    public void validInputTest3() throws Exception{
        assertEquals(MainActivity.computePostalRate(200, 125, 3, 17, "Standard", "International" ), 2.50, delta);
    }

    public void validInputTest4() throws Exception{
        assertEquals(MainActivity.computePostalRate(200, 125, 3, 35, "Standard", "Canada" ), 1.20, delta);
    }

    public void validInputTest5() throws Exception{
        assertEquals(MainActivity.computePostalRate(200, 125, 3, 35, "Standard", "USA" ), 1.80, delta);
    }

    public void validInputTest6() throws Exception{
        assertEquals(MainActivity.computePostalRate(200, 125, 3, 35, "Standard", "International" ), 3.60, delta);
    }

    public void validInputTest7() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 70, "Non-standard and Oversize", "Canada" ), 1.80, delta);
    }

    public void validInputTest8() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 150, "Non-standard and Oversize", "Canada" ), 2.95, delta);
    }

    public void validInputTest9() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 250, "Non-standard and Oversize", "Canada" ), 4.10, delta);
    }

    public void validInputTest10() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 350, "Non-standard and Oversize", "Canada" ), 4.70, delta);
    }

    public void validInputTest11() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 450, "Non-standard and Oversize", "Canada" ), 5.05, delta);
    }

    public void validInputTest12() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 70, "Non-standard and Oversize", "USA" ), 2.95, delta);
    }

    public void validInputTest13() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 150, "Non-standard and Oversize", "USA" ), 5.15, delta);
    }

    public void validInputTest14() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 300, "Non-standard and Oversize", "USA" ), 10.30, delta);
    }

    public void validInputTest15() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 70, "Non-standard and Oversize", "International" ), 5.90, delta);
    }

    public void validInputTest16() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 150, "Non-standard and Oversize", "International" ), 10.30, delta);
    }

    public void validInputTest17() throws Exception{
        assertEquals(MainActivity.computePostalRate(250, 150, 10, 300, "Non-standard and Oversize", "International" ), 20.60, delta);
    }

}