package com.example.webviewexample;

import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.naver.com";                     // String url에다가 네이버의 주소를 집어넣어.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);                                       // 저쪽의 webView와 이쪽의 webView를 연결.
        webView.getSettings().setJavaScriptEnabled(true);                           // webView를 부가 설정. 자바스크립트 허용.
        webView.loadUrl(url);                                                         // 특정 url을 틀어라.
        webView.setWebChromeClient(new WebChromeClient());                  // 웹뷰 환경을 구글 크롬 환경에 맞춰서. 쾌적하게 돌리기 위해.
        webView.setWebViewClient(new WebViewClientClass());               // 
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {                       // 뒤로 가기 버튼을 눌렀을 때 원래의 화면으로 돌아가기 위한 설정을 해준다.
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {                // keycode가 뒤로가기 버튼이고 웹뷰가 뒤로 갈 수 있으면
            webView.goBack();                                                         // 웹뷰를 뒤로 가게 해라.
            return true;                                                        
        }

        return super.onKeyDown(keyCode, event);
    }


    private class WebViewClientClass extends WebViewClient {                                    // 이너 클래스를 만들어줘.  // 오타 주의!_!
        @Override       
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);                                                                    // view를 받아서 url연결.
            return true;
        }
    }
}
