package com.example.safecampus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class policelogin extends AppCompatActivity {
    EditText userEmail,password;
    Button login,signup;
    FirebaseAuth auth;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policelogin);
        userEmail=findViewById(R.id.useremail);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        auth= FirebaseAuth.getInstance();
        login.setOnClickListener(v -> {
            String e=userEmail.getEditableText().toString();
            String p=password.getEditableText().toString();
            auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    startActivity(new Intent(policelogin.this,PoliceComplainView.class));
                    finish();
                }
                else{
                    Toast.makeText(policelogin.this, "Enter correct Email or Password", Toast.LENGTH_SHORT).show();
                }
            });

        });
        signup.setOnClickListener(v -> {
            String e=userEmail.getEditableText().toString();
            String p=password.getEditableText().toString();
            auth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(policelogin.this, "Account is created successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(policelogin.this, "Already signed up", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}