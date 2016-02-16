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
public class ValidInputsTest {

    // used for assertEquals for floating point number comparisons
    public double delta = 0.1;

    // SOME FORMATTING AND USED STRING VALUES

    //    final String[] letter_types = new String[]{"Standard", "Select a lettermail type"};
    //    final String[] destinations = new String[]{"Canada", "USA", "International", "Select a destination"};
    //    protected static double computePostalRate(double length, double width, double depth, double weight, String type, String destination)

    @Test
    public void validInputTest1() throws Exception{
        assertEquals(1, MainActivity.computePostalRate(200, 125, 3, 17, "Canada" ), delta);
    }

    @Test
    public void validInputTest2() throws Exception{
        assertEquals(1.20, MainActivity.computePostalRate(200, 125, 3, 17, "USA" ),  delta);
    }

    @Test
    public void validInputTest3() throws Exception{
        assertEquals(2.50, MainActivity.computePostalRate(200, 125, 3, 17, "International" ), delta);
    }

    @Test
    public void validInputTest4() throws Exception{
        assertEquals(1.20, MainActivity.computePostalRate(200, 125, 3, 35, "Canada" ), delta);
    }

    @Test
    public void validInputTest5() throws Exception{
        assertEquals(1.80, MainActivity.computePostalRate(200, 125, 3, 35, "USA" ), delta);
    }

    @Test
    public void validInputTest6() throws Exception{
        assertEquals(3.60, MainActivity.computePostalRate(200, 125, 3, 35, "International" ), delta);
    }

    @Test
    public void validInputTest7() throws Exception{
        assertEquals(1.80, MainActivity.computePostalRate(250, 150, 10, 70, "Canada" ), delta);
    }

    @Test
    public void validInputTest8() throws Exception{
        assertEquals(2.95, MainActivity.computePostalRate(250, 150, 10, 150, "Canada" ), delta);
    }

    @Test
    public void validInputTest9() throws Exception{
        assertEquals(4.10, MainActivity.computePostalRate(250, 150, 10, 250, "Canada" ), delta);
    }

    @Test
    public void validInputTest10() throws Exception{
        assertEquals(4.70, MainActivity.computePostalRate(250, 150, 10, 350, "Canada" ), delta);
    }

    @Test
    public void validInputTest11() throws Exception{
        assertEquals(5.05, MainActivity.computePostalRate(250, 150, 10, 450, "Canada" ), delta);
    }

    @Test
    public void validInputTest12() throws Exception{
        assertEquals(2.95, MainActivity.computePostalRate(250, 150, 10, 70, "USA" ), delta);
    }

    @Test
    public void validInputTest13() throws Exception{
        assertEquals(5.15, MainActivity.computePostalRate(250, 150, 10, 150, "USA" ), delta);
    }

    @Test
    public void validInputTest14() throws Exception{
        assertEquals(10.30, MainActivity.computePostalRate(250, 150, 10, 300, "USA" ), delta);
    }

    @Test
    public void validInputTest15() throws Exception{
        assertEquals(5.90, MainActivity.computePostalRate(250, 150, 10, 70, "International" ), delta);
    }

    @Test
    public void validInputTest16() throws Exception{
        assertEquals(10.30, MainActivity.computePostalRate(250, 150, 10, 150, "International" ),  delta);
    }

    @Test
    public void validInputTest17() throws Exception{
        assertEquals(20.60, MainActivity.computePostalRate(250, 150, 10, 300, "International" ), delta);
    }
}