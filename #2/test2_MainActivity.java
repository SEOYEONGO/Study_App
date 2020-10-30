package com.example.study_1;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText et_id;       // 여기 추가
    Button btn_test;      // 여기 추가    // alt+enter-> import 자동으로 돼

    @Override
    protected void onCreate(Bundle savedInstanceState) {      // onCreate : 어플을 처음 실행하게 되면 이쪽을 실행한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_id=findViewById(R.id.et_id);         // 동적으로 뭔가 하기 위해 추가. findViewById : 특정 id를 이쪽으로 가져와서 속성을 부여해라.
        btn_test=findViewById(R.id.btn_test);   // 리소스.id.btn_test  // 끝에는 세미콜론을 잘 닫아줘.

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       // 버튼을 클릭하면 어떤 동작이 실행되게 해.
                et_id.setText("미스고");         // 버튼을 클릭하면 "미스고"라는 텍스트가 띄워져.  : et.id.setText("미스고");
            }
        });
    }
}
