package basico.android.timecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import basico.android.timecalc.appcore.CalendarHelper;

public class CalcMomentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvDateTime1,txvDateTime2,txvCalculatorResult;
    private SimpleDateFormat mDateTimeFormat;
    private Date dateInit,dateMoment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_moment);
        getSupportActionBar().setTitle("Capturar Momento");

        initializerActivity();
        setTextView();
        setEventButton();
    }

    private void setEventButton() {
        findViewById(R.id.btnCalculateMoment).setOnClickListener(this);
    }

    private void setTextView() {
        txvDateTime1 = findViewById(R.id.txvDateTime1);
        txvDateTime2 = findViewById(R.id.txvDateTime2);
        txvCalculatorResult = findViewById(R.id.txvCalculatorResult);

        dateInit = new Date();

        txvDateTime1.setText(mDateTimeFormat.format(dateInit.getTime()));
    }


    private void initializerActivity() {
        mDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalculateMoment:
                onCalculatorClick();
                break;
        }
    }

    private void onCalculatorClick() {
        dateMoment = new Date();

        txvDateTime2.setText(mDateTimeFormat.format(dateMoment.getTime()));

        try {

            CalendarHelper calendarHelper = new CalendarHelper(dateInit, dateMoment);
            txvCalculatorResult.setText(calendarHelper.getDateTimeHumanShortFormat());
        }
        catch (Exception ex){
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
