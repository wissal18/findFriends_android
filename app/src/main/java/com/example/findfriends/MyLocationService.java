package com.example.findfriends;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationRequest;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

public class MyLocationService extends Service {
    String numero;

    public MyLocationService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @RequiresApi(api = 31)
    @Override
    @SuppressLint("MissingPermission")
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("tag", "içi");
        numero = intent.getStringExtra("numero");
        sendSms(null);
        //recuperer la position gps
        FusedLocationProviderClient mclient = LocationServices.getFusedLocationProviderClient(this);

        mclient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

            }
        });
       // LocationRequest request = LocationRequest.Builder.setIntervalMillis(100);

     /*   mclient.requestLocationUpdates(request, new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull @NotNull LocationResult locationResult) {
                Location location = locationResult.getLastLocation();
               //if (location != null) {
                    sendSms(location);
                //}
            }
        }, null);

*/
        return super.onStartCommand(intent, flags, startId);
    }
    private void sendSms(Location location) {

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(
                numero,
                null,
                "findFriends : ma position est : #151#-34",
                null,
                null);
    }
}
