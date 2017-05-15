package com.example.cosain.cres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alertMessage(View view) {
        Intent intent = new Intent(this, Alert.class);
        startActivity(intent);

    }
    public void contact(View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);

    }
    public void list(View view) {
        Intent intent = new Intent(this, List.class);
        startActivity(intent);

    }
}
