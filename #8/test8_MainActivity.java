package com.example.sharedexample;

import android.content.SharedPreferences;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared= "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                        // 하나의 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = findViewById(R.id.et_save);                                   // 저쪽의 et_save와 이쪽 et_save를 연결

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);        // SharedPreferences 기능 이용 
        String value = sharedPreferences.getString("Go", "");                   // 꺼내오는 것이기 때문에 두번째 인자는 빈값으로 해야해.
        et_save.setText(value);                                                 // et_save에다가 이 value를 setText 해줄거야.

    }

    @Override
    protected void onDestroy() {                                              // 또하나의 생명 주기
        super.onDestroy();                                                    // 이 액티비티를 벗어낫을 때 액티비티가 파괴되는데 그 때 호출되는 것이 이것.
                                                                              // 나가기 전에 저장하면서 빠져나가고 후에 onCreate실행 시 저장한 내용을 불러옴.
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();        // 저장할 때는 .Editor를 불러와줘야 해. 에디터랑 저장할 녀석을 연결해줘야 해.
        String value = et_save.getText().toString();                        // 현재 EditText에 쓰여져 있는 값을 불러와서 String 형태로 빼와서 value에 저장을 해줘.
        editor.putString("Go", value);                                      // editor에다가 저장한 value 값을 송출해줘. 인자는 (별명, 전달할 값)
        editor.commit();                                                    // 실제적인 save를 완료해라.
    }                                                     
                                                                    // 근데 어떠한 오류가 나느냐... 원하는 저장 기능 (뒤로 가기 버튼 눌렀다가 다시 화면으로 왓을 떄 그전 내용 저장)
                                                                      // 그런데 화면에 에코 기능은 안되고 있음.
}
