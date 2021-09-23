package com.edignite.calculateoee.ui.calculateoee;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.edignite.calculateoee.R;

public class ResultActivity extends AppCompatActivity {

    private TextView av,pf,qv,oee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int workedhrs = intent.getIntExtra("EXTRA_WORKEDHRS", 0);
        int majortl = intent.getIntExtra("EXTRA_MAJORTL", 0);
        int minortl = intent.getIntExtra("EXTRA_MINORTL", 0);
        int rwtime = intent.getIntExtra("EXTRA_RWTIME", 0);

        av = findViewById(R.id.av);
        pf = findViewById(R.id.pf);
        qv = findViewById(R.id.qv);
        oee = findViewById(R.id.oee);

        double calcav = Calculations.calculateav(workedhrs,majortl);
        double calcpf = Calculations.calculatepf(minortl);
        double calcqv = Calculations.calculateqv(rwtime);

        double calcoee = calcav*calcpf*calcqv/10000;

        av.setText((int) calcav);
        pf.setText((int) calcpf);
        qv.setText((int) calcqv);
        oee.setText((int)calcoee);

    }

}