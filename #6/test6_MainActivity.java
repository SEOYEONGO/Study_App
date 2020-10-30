package com.example.listexample01;                                // 새로운 프로젝트를 만든 것이야

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView list;            

    @Override
    protected void onCreate(Bundle savedInstanceState) {                 // onCreate의 생명주기로 가서
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                         // 메인 activity 의 시작 지점으로 가.

        list = (ListView)findViewById(R.id.list);                           // 저쪽의 list와 이쪽의 list를 연결시켜 주었어.

        List<String> data = new ArrayList<>();                              // ListView에 데이터 저장하기 위해, List 타입을 선언해주고.
                                                                            // String타입으로 넣을 것이다. data를.  ArrayList는 <String>형태로 배열을 넣겠다 뭐 이런 뜻...

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
                                                               // ListView랑 List를 연결해주는, 다리역할을 해주는 Adapter가 있어야 해.
                                                               // ArrayAdapter<String> adapter... 인자를 적어줘야 하는데, this, 안드로이드 기본 제공 listView UI를 가져다 쓸거야.
                                                                                                            // 인자로 data를 마지막에 넣어줘. 
        list.setAdapter(adapter);                               // 그런 다음 listview에 다가 다리역할하는 놈을 셋팅해줄거야.
                                                                // list.setAdapter(adapter)하면 리스트와 리스트뷰가 연결이 되었어.
        data.add("미스고");
        data.add("LBBUK");
        data.add("안드로이드");
        adapter.notifyDataSetChanged();                                     // notifyDataSetChanged()를 해야 데이터가 저장 완료돼.
                                                                              // 빌드해서 확인해봐. *^^*

    }
}
