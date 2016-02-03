package com.rzk.uiux;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class PermissionRequestActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener{
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_request);

        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }

        if(client==null){
            client=new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need location access to determine your location", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    protected void onStart() {
        client.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        client.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
