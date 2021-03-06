package aquar.aswany.myaquar_eg.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import dmax.dialog.SpotsDialog;

import static org.greenrobot.eventbus.ThreadMode.POSTING;

public class Register extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText pass;
    EditText phone;
    EditText job;
    String username1;
    String email1;
    String pass1;
    String phone1;
    String job1;
    final String TAG = "Register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        job = findViewById(R.id.jobTitle);

    }

    private void SetData(String username, String email, String pass, String phone, String job) {

        JSONObject object = new JSONObject();
        try {
            object.put("user_name", username);
            object.put("mail", email);
            object.put("password", pass);
            object.put("phone", phone);
            object.put("jop_title", job);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AndroidNetworking.post(URLS.Registration)
                .setPriority(Priority.LOW)
                .addJSONObjectBody(object)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "response" + response.toString());
                        Toast.makeText(Register.this, "Done..!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Home_Activity.class));
                        finish();

                    }

                    @Override
                    public void onError(ANError anError) {

                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(Register.this, "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(Register.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
    }

    public void Confirm(View view) {

        username1 = username.getText().toString().trim();
        email1 = email.getText().toString().trim();
        pass1 = pass.getText().toString().trim();
        phone1 = phone.getText().toString().trim();
        job1 = job.getText().toString().trim();

        if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(email1) ||
                TextUtils.isEmpty(pass1) || TextUtils.isEmpty(phone1) ) {
            Toast.makeText(Register.this,"All Fields Required",Toast.LENGTH_SHORT).show();
        } else {
            SetData(username1, email1, pass1, phone1, job1);
        }

    }

}
