package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText email,pass;
    String Email,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.getEmail);
        pass=findViewById(R.id.getPassword);
        Email=email.getText().toString() ;
        Pass=pass.getText().toString();
    }

    public void signUP(View view) {

        startActivity(new Intent(this,Register.class));
    }


    public void skip(View view) {
        Toast.makeText(this, "Skiped..!", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {

            Toast.makeText(this, "Done..!", Toast.LENGTH_SHORT).show();
        }

    }

