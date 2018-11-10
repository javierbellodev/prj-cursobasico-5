package basico.android.timecalc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import basico.android.timecalc.appcore.CalendarHelper;

public class CalcTimeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvDateTimeStart,txvDateTimeEnd,txvCalculatorResult;
    private DatePickerDialog startDatePicker, endDatePicker;
    private TimePickerDialog startTimePicker, endTimePicker;

    private SimpleDateFormat mDateTimeFormat;

    private Calendar mCalendarStartDateTime;
    private Calendar mCalendarEndDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_time);
        getSupportActionBar().setTitle("Diferencia entre fechas");

        initializerActivity();

        setEventButton();
        setTextView();
        setEventListenerPicker();
    }

    private void setTextView() {
        txvDateTimeStart = findViewById(R.id.txvDateTimeStart);
        txvDateTimeEnd = findViewById(R.id.txvDateTimeEnd);
        txvCalculatorResult = findViewById(R.id.txvCalculatorResult);
    }

    private void initializerActivity() {
        mCalendarStartDateTime = Calendar.getInstance();
        mCalendarEndDateTime = Calendar.getInstance();

        mDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    }

    private void setEventListenerPicker() {
        startDatePicker = new DatePickerDialog(this,mStartDatePickerListener,
                mCalendarStartDateTime.get(Calendar.YEAR),
                mCalendarStartDateTime.get(Calendar.MONTH),
                mCalendarStartDateTime.get(Calendar.DATE)
                );

        startTimePicker = new TimePickerDialog(this,mStartTimePickerListener,
                mCalendarStartDateTime.get(Calendar.HOUR_OF_DAY),
                mCalendarStartDateTime.get(Calendar.MINUTE),
                false
        );

        endDatePicker = new DatePickerDialog(this,mEndDatePickerListener,
                mCalendarStartDateTime.get(Calendar.YEAR),
                mCalendarStartDateTime.get(Calendar.MONTH),
                mCalendarStartDateTime.get(Calendar.DATE)
                );

        endTimePicker = new TimePickerDialog(this,mEndTimePickerListener,
                mCalendarStartDateTime.get(Calendar.HOUR_OF_DAY),
                mCalendarStartDateTime.get(Calendar.MINUTE),
                false
        );
    }

    private void setEventButton() {
        findViewById(R.id.btnDateStart).setOnClickListener(this);
        findViewById(R.id.btnTimeStart).setOnClickListener(this);
        findViewById(R.id.btnDateEnd).setOnClickListener(this);
        findViewById(R.id.btnTimeEnd).setOnClickListener(this);
        findViewById(R.id.btnCalculator).setOnClickListener(this);
    }

    private void refreshDisplayDateTimeStart(){
        txvDateTimeStart.setText(mDateTimeFormat.format(mCalendarStartDateTime.getTime()));
    }

    private DatePickerDialog.OnDateSetListener mStartDatePickerListener
    = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendarStartDateTime.set(Calendar.YEAR, year);
            mCalendarStartDateTime.set(Calendar.MONTH,month);
            mCalendarStartDateTime.set(Calendar.DATE,dayOfMonth);

            refreshDisplayDateTimeStart();
        }
    };

    private TimePickerDialog.OnTimeSetListener mStartTimePickerListener
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendarStartDateTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            mCalendarStartDateTime.set(Calendar.MINUTE,minute);
            mCalendarStartDateTime.set(Calendar.SECOND,0);

            refreshDisplayDateTimeStart();
        }
    };

    private void refreshDisplayDateTimeEnd(){
        txvDateTimeEnd.setText(mDateTimeFormat.format(mCalendarEndDateTime.getTime()));
    }

    private DatePickerDialog.OnDateSetListener mEndDatePickerListener
    = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendarEndDateTime.set(Calendar.YEAR, year);
            mCalendarEndDateTime.set(Calendar.MONTH,month);
            mCalendarEndDateTime.set(Calendar.DATE,dayOfMonth);
            refreshDisplayDateTimeEnd();
        }
    };

    private TimePickerDialog.OnTimeSetListener mEndTimePickerListener
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendarEndDateTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            mCalendarEndDateTime.set(Calendar.MINUTE,minute);
            mCalendarEndDateTime.set(Calendar.SECOND, 0);

            refreshDisplayDateTimeEnd();
        }
    };

    private void onCalculatorClick() {

         try {

             CalendarHelper calendarHelper = new CalendarHelper(mCalendarStartDateTime.getTime(), mCalendarEndDateTime.getTime());
             txvCalculatorResult.setText(calendarHelper.getDateTimeHumanFormat());
         }
         catch (Exception ex){
             Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
         }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDateStart:
                startDatePicker.show();
                break;
            case R.id.btnTimeStart:
                startTimePicker.show();
                break;
            case R.id.btnDateEnd:
                endDatePicker.show();
                break;
            case R.id.btnTimeEnd:
                endTimePicker.show();
                break;
            case R.id.btnCalculator:
                onCalculatorClick();
        }
    }

}
