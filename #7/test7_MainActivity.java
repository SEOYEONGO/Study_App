package com.example.naviexample;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import androidx.core.view.GravityCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);                                              // FloatingActionButton은 버튼을 띄우는 기능...
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)                   // Snackbar는 Toast랑 비슷하지만 더 이후에 나온 텍스트를 화면에 띄워주는 기능
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);                                     // DrawerLayout은...
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed(){                                                                   // onBackPressed는...물리적또는 가상적 뒤로가기 버튼을 눌렀을 때
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);                         // drawer_layout을 찾아주고,
        if (drawer.isDrawerOpen(GravityCompat.START)){                                                      // 그것이 열려있다면
            drawer.closeDrawer(GravityCompat.START);                                                            // 닫아줘라.
        }else{                                                                                              // 그렇지 않으면
            super.onBackPressed();                                                                                  // 뒤로 가라
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                                               // onCreateOptionsMenu는...시작할 때 옵션메뉴를 생성을 해주는데
        // Inflate the menu; this adds items to the action bar if it is present.                            
        getMenuInflater().inflate(R.menu.main, menu);                                                                 // 템플릿에서 미리 만든 것을 가져와라.
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {                                   //onOptionsItemSelectedsms...  settings라는 것을 선택을 했을 때 실행되는 것들..
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatment
        if (id == R.id.action_settings){
            return true;                                                // 아무것도 구현 안되어 있음
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){                                         // onNavigationItemSelected의 각각의 버튼 클릭 시 실행 되는 것들...
        // Handle navigation view item clicks here.                                                 // 아근데 여기 부분 내 pc에서 오류나ㅏㅏ...
        int id = item.getItemId();

        if (id == R.id.nav_gallery){
            // Handle the camera action
       // }else if (id == R.id.nav_camera){                                             // 보려면 내가 res/drawble에다가 따로 추가 해줘야해. activity_main_drawer.xml도 손대야 

        }else if (id == R.id.nav_slideshow){

        }

        // }else if (id == R.id.nav_manage){

       // }else if (id == R.id.nav_share){

       // }else if (id == R.id.send){

      //  }

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);                                                                // drawerLayout을 아예 닫아 버리겠다.
        return true;
    }
}
