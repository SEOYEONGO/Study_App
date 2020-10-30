package com.example.study_1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;

    ImageView test;                     // ImageView를 위한 test 변수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test=findViewById(R.id.et_test);


        btn_move=findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra( "str", str);
                startActivity(intent);  // 액티비티 이동.
            }
        });

        test = (ImageView)findViewById(R.id.test);                  // 저쪽의 test와 이쪽의 test를 연결함.
        test.setOnClickListener(new View.OnClickListener() {        // test를 클릭을 햇을 때 동작이 일어나게 해야해.
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LBBUK", Toast.LENGTH_SHORT).show();                    // Toast기능
            }                                                                                                    // 원하는 글자를 송출하게 할 것임.
                                                                                                                 // 짧게 뜨게 할 것이야.
        });
    }}
