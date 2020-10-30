package com.example.customnaviexample;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;                  // DrawerLayout 타입 변수 drawerLayout 변수 선언.
    private View drawerView;                             // View 타입 drawerView 변수 선언.

    @Override
    protected void onCreate(Bundle savedInstanceState) {                // 생명주기 안에서.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);                  // activity_main.xml 의 drawer_layout과 java파일의 drawerLayout 연결. 
        drawerView = (View)findViewById(R.id.drawer);                                   // activity_drawer.xml 의 drawer과 java 파일의 drawerView 연결.

        Button btn_open=(Button)findViewById(R.id.btn_open);                            // activity_main.xml 의 btn_open과 java파일의 btn_open 연결. 
        
        btn_open.setOnClickListener(new View.OnClickListener() {                                  // btn_open의 setOnClickListener (new View.onClickListener())
            @Override
            public void onClick(View v) {                                                                 // 이것은 첫화면에서 열려라 참깨 누르면 
                                                                                                         // 네비게이션 메뉴가 열려라 뭐 그런뜻이다.
                drawerLayout.openDrawer(drawerView);                                              // drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);                        // activity_drawer.xml 의 btn_close와 java파일의 btn_close 연결. 
        btn_close.setOnClickListener(new View.OnClickListener() {                                  // btn_close의 setOnClickListener
            @Override                                                                                     // close 버튼을 눌렀을 때 행동을 취해라. 
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);                                                 // drawerLayout은 listener라는 것을 등록을 해줄 것이다.
        drawerView.setOnTouchListener(new View.OnTouchListener() {                                      // setOnTouchListener (new ... 
            @Override                                                                                             // 이 부분은 이해가 좀 부족하긴 해...
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {                    // DrawerLayout.DrawerListener listener = new~~
        @Override                                                                                     // 하게되면 화면을 왼쪽/오른쪽 슬라이드 했을 때 
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {                      // 상태값을 받아서 동작하게 해주는 기능.
                                                                                                                // 원한다면 이 부분 기능 추가 가능
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}
