package com.example.safecampus;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safecampus.databinding.ActivityComplainPageBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;
import java.util.TimerTask;


public class ComplainPage extends AppCompatActivity {
Button mylocationbtn;
RecyclerMessageAdapter recyclerMessageAdapter;
RecyclerView recyclerView;
ArrayList<MessageModel> list;
EditText complainmsg;
Button send;
DatabaseReference dbr;
String uid;
FirebaseAuth auth;
FirebaseUser user;
Button SOS;


private static final String CHANNEL_ID="My Channel";
private static final int NOTIFICATION_ID=100;
    Notification notification;

    @SuppressLint("MissingInflatedId")

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_complain_page);
        SensorManager sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        FallDetector fallDetector = new FallDetector(sensorManager);
        for(int i=0;i<5;i++){
            fallDetector.start();
        }


        list=new ArrayList<>();
            recyclerView = findViewById(R.id.recyclerView);
            send = findViewById(R.id.send);
            complainmsg = findViewById(R.id.complainmsg);
            mylocationbtn = findViewById(R.id.mylocbtn);
            SOS=findViewById(R.id.Send_SOS_Request);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        dbr = FirebaseDatabase.getInstance().getReference("chat");
        String email = user.getEmail();


        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.p3,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
        Bitmap largeicon=bitmapDrawable.getBitmap();
            NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);


        SOS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        notification=new Notification.Builder(ComplainPage.this).setLargeIcon(largeicon).setSmallIcon(R.drawable.p3)
                                .setContentText("Need Help......." +
                                        "Check View SOS Kindly")
                                .setSubText("New Message from "+email)
                                .setChannelId(CHANNEL_ID)
                                .build();
                        nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
                    }else{

                    }
                    nm.notify(NOTIFICATION_ID,notification);
                    Toast.makeText(ComplainPage.this, "!!!SOS sent successfully!!!", Toast.LENGTH_SHORT).show();
                }
            });


            // initialize recyclerMessageAdapter
            recyclerMessageAdapter = new RecyclerMessageAdapter(this,list);

            // set up Firebase database reference


            uid = user.getUid();


            @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mma").format(Calendar.getInstance().getTime());

            mylocationbtn.setOnClickListener(v -> {
                Intent intent = new Intent(ComplainPage.this, MapsActivity.class);
                startActivity(intent);
            });

            send.setOnClickListener(v -> {
                String msg = complainmsg.getEditableText().toString();
                dbr.child("Message").push().setValue(new MessageModel(email, msg, timeStamp)).addOnCompleteListener(task -> complainmsg.setText(""));
            });

            LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
            recyclerView.setLayoutManager(llm);
            recyclerView.setAdapter(recyclerMessageAdapter);
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