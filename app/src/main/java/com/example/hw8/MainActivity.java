package com.example.hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText H_edittext = (EditText) findViewById(R.id.height);
        final EditText W_edittext = (EditText) findViewById(R.id.weight);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(H_edittext.getText().toString().matches("")
                        || W_edittext.getText().toString().matches("")){
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("Height", H_edittext.getText().toString());
                    intent.putExtra("Weight", W_edittext.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
