package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import aquar.aswany.myaquar_eg.R;

public class contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void call_us(View view) {
        Intent contact = new Intent(Intent.ACTION_DIAL);
        contact.setData(Uri.parse("tel:01033113330"));
        startActivity(contact);
    }

    public void email_us(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "info@myaquar-eg.com" });
        startActivity(Intent.createChooser(intent, ""));
    }
}