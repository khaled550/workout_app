package com.abeer.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abeer.workoutapp.database.AppDatabase;
import com.abeer.workoutapp.databinding.ActivityUserInfoBinding;
import com.abeer.workoutapp.model.User;

public class UserInfoActivity extends AppCompatActivity {

    ActivityUserInfoBinding viewsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsId = ActivityUserInfoBinding.inflate(getLayoutInflater());
        setContentView(viewsId.getRoot());

        int id = getIntent().getIntExtra("id", 0);

        viewsId.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup(id);
            }
        });

    }

    private void signup(int id){
        User user = AppDatabase.dbUtils(this).loadAllByIds(id);
        user.setAge(viewsId.ageEdit.getText().toString());
        user.setHeight(viewsId.ageEdit.getText().toString());
        user.setWeight(viewsId.ageEdit.getText().toString());
        AppDatabase.dbUtils(this).insertAll(user);
        startActivity(new Intent(this, ExercisesActivity.class));
        finish();
    }
}
