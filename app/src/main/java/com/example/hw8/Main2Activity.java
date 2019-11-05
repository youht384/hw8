package com.example.hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class Main2Activity extends AppCompatActivity {
    private Double HEIGHT,WEIGHT,BMI_V;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        HEIGHT=Double.parseDouble(intent.getStringExtra("Height"));
        WEIGHT=Double.parseDouble(intent.getStringExtra("Weight"));
        BMI_V=WEIGHT/((HEIGHT*HEIGHT)/10000);
        BigDecimal BD = new BigDecimal(BMI_V);
        Double ValueT2D = BD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        TextView bmi_v_text=(TextView)findViewById(R.id.Bmi_v_text);
        bmi_v_text.setText(getString(R.string.BMI_V_TEXT)+ValueT2D);
        TextView result_text = (TextView)findViewById(R.id.Result_TEXT);
        if (ValueT2D < 18.5)
            result_text.setText(getString(R.string.Result_TEXT)+"過輕");
        else if (ValueT2D < 24 && ValueT2D >18.5)
            result_text.setText(getString(R.string.Result_TEXT)+"正常");
         else
            result_text.setText(getString(R.string.Result_TEXT)+"過重");

        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
