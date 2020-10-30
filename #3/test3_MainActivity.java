package com.example.study_1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private  String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // layout의 activity_main.xml 파일과 연결.

        et_test=findViewById(R.id.et_test);             // 그쪽의 et_test와 이쪽의 et_test를 연결


        btn_move=findViewById(R.id.btn_move);           // 그쪽의 btn_move와 이쪽의 btn_move를 연결
        
        
        
        btn_move.setOnClickListener(new View.OnClickListener() {      // btn_move를 클릭했을 때 안쪽을 실행하라는 의미.
            @Override
            public void onClick(View v) {                      
                str = et_test.getText().toString();                     // String타입의 변수 str에는... 
                                                                        // 사용자가 입력하는 값을 getText()로 읽어와서, String으로 바꾼 다음, str에 저장을 해줄거야.
                
                Intent intent = new Intent(MainActivity.this, SubActivity.class);             // Intent형 변수 intent를 생성. 인텐트는 메시지 객체야.
                                                                        // 현재 있는 액티비티는 MainActivity(this를 이용해), 이동하고 싶은 액티비티는 SubActivity(class로)
                
                intent.putExtra( "str", str);                           // 우리는 인텐트에 메시지를 실어주고 싶어. 그래서 putExtra()를 이용할 것이야.
                                                                        // "str"은 별명, 실제 전달 값은 str에 들어있는 값이야.
                
                startActivity(intent);  // 액티비티 이동.                 // 이 부분이 실제로 액티비티 전환을 가능하게 해주는 구문.
            }
        });
    }
}
