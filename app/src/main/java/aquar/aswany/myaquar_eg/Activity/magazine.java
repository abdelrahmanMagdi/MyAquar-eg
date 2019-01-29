package aquar.aswany.myaquar_eg.Activity;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import aquar.aswany.myaquar_eg.R;
import dmax.dialog.SpotsDialog;

import android.webkit.WebView;

public class magazine extends AppCompatActivity {

      AlertDialog dialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magzene);

        dialog1= new SpotsDialog.Builder().setContext(magazine.this).setTheme(R.style.Custom).build();
        dialog1.setMessage("Please wait.....");
         dialog1.show();
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.aquar.me");
        dialog1.dismiss();

    }
}
