package com.abeer.workoutapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abeer.workoutapp.database.AppDatabase;
import com.abeer.workoutapp.databinding.ActivityLoginBinding;
import com.abeer.workoutapp.databinding.ActivitySignupBinding;
import com.abeer.workoutapp.model.User;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding viewsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsId = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(viewsId.getRoot());
        AppDatabase.createDatabase(this);

        viewsId.goToRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });

        viewsId.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
    }

    private void signup(){
        User user = new User(
                viewsId.nameEdit.getText().toString(),
                viewsId.emailEdit.getText().toString().toLowerCase(),
                viewsId.passEdit.getText().toString()
        );
        /*User user = new User(
                "Test",
                "Test",
                "Test");*/
        long id = AppDatabase.dbUtils(this).insertAll(user)[0];
        startActivity(new Intent(SignupActivity.this, UserInfoActivity.class).putExtra("id", (int)id));
    }
}
