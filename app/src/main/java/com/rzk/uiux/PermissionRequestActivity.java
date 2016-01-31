package com.rzk.uiux;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.widget.Toast;

public class PermissionRequestActivity extends AppCompatActivity {
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_request);

        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
