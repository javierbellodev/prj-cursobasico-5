package basico.android.timecalc;

import org.junit.Test;

import java.util.Date;

import basico.android.timecalc.appcore.CalendarHelper;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalendarHelperUnitTest {

    Date dateStart = new Date(2013,10,10,11,11,11);
    Date dateEnd = new Date(2018,10,12,12,12,12);

    @Test
    public void Get_Correct_Year_Elapsed() {

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        long actual = helper.getYearElapsed();
        long expected = 5;

        assertEquals(expected,actual);
    }

    @Test
    public void Get_Correct_Day_Elapsed() {

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        long actual = helper.getDaysElapsed();
        long expected = 2;

        assertEquals(expected,actual);
    }

    @Test
    public void Get_Correct_Hour_Elapsed() {

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        long actual = helper.getHourElapsed();
        long expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    public void Get_Correct_Minute_Elapsed(){

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        long actual = helper.getMinuteElapsed();
        long expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    public void Get_Correct_Second_Elapsed(){

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        long actual = helper.getSecondElapsed();
        long expected = 1;

        assertEquals(expected,actual);
    }

     @Test
    public void Get_Correct_DateTimeHumanFormat_Elapsed() {

        CalendarHelper helper = new CalendarHelper(dateStart,dateEnd);

        String actual = helper.getDateTimeHumanFormat();
        String expected = "1 años, 1 días, 1 horas, 1 minutos, 1 segundos.";

        assertEquals(expected,actual);
    }


}