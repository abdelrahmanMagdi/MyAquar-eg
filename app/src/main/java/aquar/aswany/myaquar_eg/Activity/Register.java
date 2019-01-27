package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import aquar.aswany.myaquar_eg.R;

public class Register extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText pass;
    EditText phone;
    EditText job;
    String   username1 ;
    String email1 ;
    String pass1;
    String phone1 ;
    String job1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        job=findViewById(R.id.jobTitle);

    }

    public void Confirm(View view) {
        Toast.makeText(this,"Done..!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Home_Activity.class));
    }
}
