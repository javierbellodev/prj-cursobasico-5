package basico.android.timecalc.appcore;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalendarHelper {

    private Date dateTimeStart,dateTimeEnd;
    private long year = 0;
    private long day = 0;
    private long hour = 0;
    private long minute = 0;
    private long second = 0;

    public CalendarHelper(Date dateTimeStart, Date dateTimeEnd) {
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd =  dateTimeEnd;

        PerformCalculate();
    }

    private void PerformCalculate() {

        long dateDiff =  (dateTimeEnd.getTime() - dateTimeStart.getTime());

        day = TimeUnit.MILLISECONDS.toDays(dateDiff);
        dateDiff = dateDiff - TimeUnit.DAYS.toMillis(day);

        hour = TimeUnit.MILLISECONDS.toHours(dateDiff);
        dateDiff = dateDiff - TimeUnit.HOURS.toMillis(hour);

        minute = TimeUnit.MILLISECONDS.toMinutes(dateDiff);
        dateDiff = dateDiff - TimeUnit.MINUTES.toMillis(minute);

        second = TimeUnit.MILLISECONDS.toSeconds(dateDiff);

        //obtento los años contenido en los dias calculado, le resto los dias de dicho año
        if(day >= 365){
            year = day / 365;
            day = (day - (365 * year) - 1);
        }
    }

    public String getDateTimeHumanFormat() {
        return new String(year + " años, "+ day +" días, "+ hour +" horas, "+ minute +" minutos, "+ second +" segundos.");
    }

    public String getDateTimeHumanShortFormat() {

        if(year > 0)
            return new String(year + " años");

        if(day > 0)
            return new String(day + " días");

        if(hour > 0)
            return new String(hour + " horas");

        if(minute > 0)
            return new String(minute + " minute");

        if(second > 0)
            return new String(second + " segundos");

        return new String("");
    }


    public long getYearElapsed() {
        return year;
    }

    public long getDaysElapsed() {
        return day;
    }

    public long getHourElapsed() {
        return hour;
    }

    public long getMinuteElapsed() {
        return  minute;
    }

    public long getSecondElapsed() {
        return  second;
    }
}
