package com.example.safecampus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PoliceComplainView extends AppCompatActivity {
    RecyclerMessageAdapter recyclerMessageAdapter;
    RecyclerView recyclerview;
    FirebaseAuth auth;
    DatabaseReference dbr;
    ArrayList<MessageModel> list;
    FirebaseUser user;
    String email;
    String msg;
    Button viewSOS;
    Button opencctv;
   // private CameraVideomanager cameraManager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_complain_view);

       /* @SuppressLint("WrongViewCast") SurfaceView surfaceView = findViewById(R.id.);
        cameraManager = new CameraVideomanager(surfaceView);*/
            opencctv=findViewById(R.id.opencctv);

        recyclerview = findViewById(R.id.recyclerview);
        viewSOS = findViewById(R.id.viewSOS);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        list = new ArrayList<>();
        recyclerMessageAdapter = new RecyclerMessageAdapter(this, list);
        dbr = FirebaseDatabase.getInstance().getReference("chat");
opencctv.setOnClickListener((v) -> {

 //startservice(userId);
        });
        viewSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserTrackingLocation.class));
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        recyclerview.setLayoutManager(llm);
        recyclerview.setAdapter(recyclerMessageAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        receiveMessage();
    }

    public void receiveMessage(){
        dbr.child("Message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot snap:snapshot.getChildren()){
                    MessageModel message=snap.getValue(MessageModel.class);
                    recyclerMessageAdapter.addMessage(message);
                }}


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}

