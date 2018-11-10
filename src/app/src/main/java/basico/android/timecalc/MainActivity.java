package basico.android.timecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoCalcTimeActivity(View view){
        gotoActivivy(new Intent(this,CalcTimeActivity.class));
    }

    public void gotoCalcMomentActivity(View view){
        gotoActivivy(new Intent(this,CalcMomentActivity.class));
    }

    private void gotoActivivy(Intent intent ){
        startActivity(intent);
    }
}
