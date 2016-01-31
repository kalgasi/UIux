package com.rzk.uiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openActivityPermission(View view) {
        Intent intent = new Intent(this, PermissionRequestActivity.class);
        startActivity(intent);
    }

    public void openForm1(View view) {
        Intent intent = new Intent(this, Form1Activity.class);
        startActivity(intent);
    }
}
