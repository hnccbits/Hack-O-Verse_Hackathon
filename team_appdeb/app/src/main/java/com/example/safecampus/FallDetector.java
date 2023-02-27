package com.example.safecampus;

import java.util.Timer;
import java.util.TimerTask;

import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FallDetector implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Timer timer;
    private long lastUpdate = 0;
    private float lastX, lastY, lastZ;
    private static final int SHAKE_THRESHOLD = 10; // adjust this value to change the sensitivity
    DatabaseReference dbr=FirebaseDatabase.getInstance().getReference("Emergency Response");
FirebaseAuth auth=FirebaseAuth.getInstance();
FirebaseUser user=auth.getCurrentUser();

    String email= user.getEmail();

    public FallDetector(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        timer = new Timer();
    }

    public void start() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stop() {
        sensorManager.unregisterListener(this);
        timer.cancel();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long currentTime = System.currentTimeMillis();
        long diffTime = currentTime - lastUpdate;
        if (diffTime > 100) {
            lastUpdate = currentTime;
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float speed = Math.abs(x + y + z - lastX - lastY - lastZ) / diffTime * 10000;
            if (speed > SHAKE_THRESHOLD) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // code to execute if a fall is detected
                        dbr.child("Help").push().setValue(email.concat(" HELP ME ITS URGENT"));


                    }
                }, 10000); // delay of 1 second to allow time for the user to recover
            }
            lastX = x;
            lastY = y;
            lastZ = z;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not used
    }
}

