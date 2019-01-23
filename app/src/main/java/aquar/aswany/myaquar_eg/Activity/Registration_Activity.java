package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import aquar.aswany.myaquar_eg.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Registration_Activity extends AppCompatActivity {
    @BindView(R.id.username)
    public EditText username;
    @BindView(R.id.email)
    public EditText email;
    @BindView(R.id.password)
    public EditText password;
    @BindView(R.id.phone)
    public EditText phonenumber;
    @BindView(R.id.jobTitle)
    public EditText jobTitle;



    private String username1, email1, password1, phonenumber1, jobTitle1;
    private HashMap<String, String> MapData;
    @BindView(R.id.Confirm_BTN)
    public Button Confirm_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Confirm_BTN)
    public void Confirm() {

        if (username.getText().toString().isEmpty()) {
            username.setError("Enter username ");
        } else if (email.getText().toString().isEmpty()) {
            email.setError(" Enter your email ");
        } else if (password.getText().toString().isEmpty() || password.getText().toString().length() < 8) {
            password.setError("Enter the password");
        } else if (phonenumber.getText().toString().isEmpty() || phonenumber.getText().toString().length() < 11) {
            phonenumber.setError("Enter your phone number");
        } else {

            username1 = username.getText().toString();
            email1 = email.getText().toString();
            jobTitle1 = jobTitle.getText().toString();
            password1 = password.getText().toString();
            phonenumber1 = phonenumber.getText().toString();
            Toast.makeText(this, "done..!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Registration_Activity.this, Home_Activity.class));
            finish();
            //MapData.put("username", username1);
//            MapData.put("email", email1);
//            MapData.put("password", password1);
//            MapData.put("phonenumber", phonenumber1);
//            MapData.put("jobtitle", jobTitle1);
//            JSONObject jsonObject = new JSONObject();
//            try {
//                jsonObject.put("map", MapData);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
