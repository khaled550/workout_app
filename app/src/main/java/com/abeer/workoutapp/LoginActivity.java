package com.abeer.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.abeer.workoutapp.database.AppDatabase;
import com.abeer.workoutapp.databinding.ActivityLoginBinding;
import com.abeer.workoutapp.model.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding viewsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsId = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(viewsId.getRoot());

        SharedPreferences sharedpreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        int appLaunch = sharedpreferences.getInt("app", 0);
        editor.putInt("app", appLaunch+1);
        editor.apply();

        if (appLaunch == 1) {
            finish();
        }

        viewsId.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login(viewsId.emailEdit.getText().toString(), viewsId.passEdit.getText().toString());
            }
        });
        viewsId.goToRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });

    }

    private void login(String email, String pass){
        Log.i("myemail", email.toLowerCase());
        User user = AppDatabase.dbUtils(this).find(email.toLowerCase());

        try {
            if (pass.equals(user.getPass())){
                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ExercisesActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Wrong email or password2", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Wrong email or password1", Toast.LENGTH_SHORT).show();
            Log.i("myemail", e.getMessage());
        }
    }
}