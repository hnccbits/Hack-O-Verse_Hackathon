package com.example.safecampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {
    Button student,staff,visitor,police;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        student=findViewById(R.id.studentbtn);
        staff=findViewById(R.id.staffbtn);
        visitor=findViewById(R.id.visitorbtn);
        police=findViewById(R.id.policebtn);
        student.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),LOGINSIGNUP.class)));
        visitor.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),LOGINSIGNUP.class)));
        staff.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),LOGINSIGNUP.class)));
        police.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),policelogin.class)));}}