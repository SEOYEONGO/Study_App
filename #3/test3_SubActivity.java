package com.example.study_1;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);                // layout의 activity_sub.xml을 연결시킴.

        tv_sub=findViewById(R.id.tv_sub);                     // 저쪽에 있는 tv_sub와 이쪽의 tv_sub를 연결

        Intent intent = getIntent();                         // Intent 타입 intent변수를 선언하고 무언가 저쪽에서 값이 넘어오면 그걸 getIntent, 받겠다.
        String str = intent.getStringExtra("str");           // 인텐트의 날라온 string의 값을 (str이라는 별명을 사용하여-쏠때 받을때 동일하게) String 타입의 변수 str에 저장하겠다. 

        tv_sub.setText(str);                                 // 그래서 tv_sub의 값은 str 데이터가 돼.
    }
}
