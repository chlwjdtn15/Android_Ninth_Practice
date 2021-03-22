package com.example.a8shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;

public class SecondActivity extends AppCompatActivity {

    final String FILE_NAME = "my_Prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }



    public void readData(View v){
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);


        String name = preferences.getString("username", "no_name");
        Integer age = preferences.getInt("age", 0);

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();



    }


    public void clearData(View view) {



        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.commit();


        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();



    }
}