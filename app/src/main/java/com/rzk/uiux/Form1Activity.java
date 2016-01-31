package com.rzk.uiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Form1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
    }

    public void openForm2(View view) {
        Intent intent = new Intent(this, Form2Activity.class);
        startActivity(intent);
        finish();
    }
}
