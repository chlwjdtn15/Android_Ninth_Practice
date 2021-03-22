package com.example.a8shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    final String FILE_NAME = "my_Prefs";
    EditText userNameET;
    EditText userAgeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        userAgeET = findViewById(R.id.age_ET);
        userNameET = findViewById(R.id.name_ET);




    }

    public void saveData(View view) {

        String name = userNameET.getText().toString();
        String ageStr =userAgeET.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString("username", name);

        int age = Integer.valueOf(ageStr);

        editor.putInt("age", age);
        editor.commit();

        userNameET.setText("");
        userAgeET.setText("");

        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();



    }


    public void openSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }
}