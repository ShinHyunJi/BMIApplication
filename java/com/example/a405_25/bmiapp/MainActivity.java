package com.example.a405_25.bmiapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = MainActivity.this;

        final EditText height=findViewById(R.id.height);
        final EditText weight=findViewById(R.id.weight);
        final TextView res = findViewById(R.id.res);

        //순서오류
        //String sHeight = height.getText().toString();
        //double fHeight = Double.parseDouble(sHeight);              //String을 소수(float)타입으로 변환
        //TextView res = findViewById(R.id.res);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"테스트성공!",Toast.LENGTH_LONG).show();

                String sHeight = height.getText().toString();
                String sWeight = weight.getText().toString();
                double dHeight = Double.parseDouble(sHeight);
                double dWeight = Double.parseDouble(sWeight);

                String result = "";             //지역변수 초기화

                double bmi = dWeight/((dHeight*dHeight)/10000);
                Log.d("bmi :",bmi+"");


                if(bmi > 40){
                    result = "고도 비만";

                }else if(bmi >= 35 || bmi <= 39.9 ){
                    result = "중등도 비만";

                }else if(bmi >= 30 || bmi <= 34.9) {
                    result = "경도 비만";
                }else if(bmi >= 18.5 || bmi <= 24.9) {
                    result = "정상";
                }
                res.setText(result);                                                      //class가 필요없다는 의미 파악! 값을 유지하고 있을 필요없음

            }
        });


    }
}
