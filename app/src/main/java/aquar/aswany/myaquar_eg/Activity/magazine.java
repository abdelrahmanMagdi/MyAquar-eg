package aquar.aswany.myaquar_eg.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import aquar.aswany.myaquar_eg.R;
import android.webkit.WebView;

public class magazine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magzene);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.aquar.me");


    }
}
