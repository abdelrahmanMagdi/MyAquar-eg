package aquar.aswany.myaquar_eg.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONObject;

import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;

public class subscribe extends AppCompatActivity {

    EditText email;
    EditText phone;


    String email1;
    String phone1;

    final String TAG = "subscribe";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");

        email = findViewById(R.id.sub_email);
        phone = findViewById(R.id.sub_phone);



    }

    private void SetData(String email, String phone)
    {
        dialog.show();
        JSONObject object = new JSONObject();
        try {

            object.put("mail", email);
            object.put("phone", phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AndroidNetworking.post(URLS.subscribe_link)
                .setPriority(Priority.LOW)
                .addJSONObjectBody(object)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        Log.d(TAG, "response" + response);
                        Toast.makeText(subscribe.this, "Thank you..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(subscribe.this,Home_Activity.class));
                        finish();

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(subscribe.this, "DataBase Error", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(subscribe.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
    }
    public void subscribe_confirm(View view) {
//        startActivity(new Intent(this,Home_Activity.class));
        email1 = email.getText().toString().trim();
        phone1 = phone.getText().toString().trim();
        SetData( email1,  phone1);
    }

}