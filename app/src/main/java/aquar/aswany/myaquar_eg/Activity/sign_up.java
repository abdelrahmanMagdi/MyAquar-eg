package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import aquar.aswany.myaquar_eg.R;


public class sign_up extends AppCompatActivity {
    private EditText username , email , password , phonenumber , jobTitle;
    private  String   username1 , email1 , password1, phonenumber1 , jobTitle1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


    }
    public void reject (View view) {

        username1 = username.getText().toString();
        email1 = email.getText().toString();
        jobTitle1 = jobTitle.getText().toString();
        password1 = password.getText().toString();
        phonenumber1 = phonenumber.getText().toString();


        if (username1.isEmpty()) {
            username.setError("Enter username ");
        }
        else if (email1.isEmpty()) {
            email.setError(" Enter your email ");
        }
        else if (password1.isEmpty()||password1.length()<8) {
            password.setError("Enter the password");
        }
        else if (phonenumber1.isEmpty()||phonenumber1.length()<11) {
            phonenumber.setError("Enter your phone number");
        }
        else
            Toast.makeText(this, "done..!", Toast.LENGTH_SHORT).show();
    }
}
