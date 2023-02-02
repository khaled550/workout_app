package com.abeer.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abeer.workoutapp.adapter.ExercisesAdapter;
import com.abeer.workoutapp.adapter.RecyclerTouchListener;
import com.abeer.workoutapp.databinding.ActivityExercisesBinding;
import com.abeer.workoutapp.model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity {

    ActivityExercisesBinding viewsId;
    private ExercisesAdapter exercisesAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    List<String> exercisesTitles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsId = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(viewsId.getRoot());

        String[] exercisesTitles = new String[8];
        exercisesTitles[0] = ("Squats");
        exercisesTitles[1] = ("Reverse Lunges");
        exercisesTitles[2] = ("Lateral Leg Raises");
        exercisesTitles[3] = ("Marching Glute Bridge");
        exercisesTitles[4] = ("Spider-Man Mountain Climbers");
        exercisesTitles[5] = ("Skater Hops");
        exercisesTitles[6] = ("Donkey Kicks");
        exercisesTitles[7] = ("Standing Oblique Crunches");
        int[] exercisesImgs = new int[8];
        exercisesImgs[0] = R.drawable.squat;
        exercisesImgs[1] = R.drawable.elevated_lunge;
        exercisesImgs[2] = R.drawable.side_plank;
        exercisesImgs[3] = R.drawable.bridge;
        exercisesImgs[4] = R.drawable.mountain;
        exercisesImgs[5] = R.drawable.skater;
        exercisesImgs[6] = R.drawable.donkey_kick;
        exercisesImgs[7] = R.drawable.standing;

        List<Exercise> exercises = new ArrayList<>();
        for (int i = 0; i < exercisesTitles.length; i++) {
            exercises.add(new Exercise(exercisesTitles[i], exercisesImgs[i]));
        }

        exercisesAdapter = new ExercisesAdapter(this, exercises);
        mLayoutManager = new GridLayoutManager(this , 2);
        viewsId.exercisesRecyclerList.setLayoutManager(mLayoutManager);
        viewsId.exercisesRecyclerList.setAdapter(exercisesAdapter);
        viewsId.exercisesRecyclerList.addOnItemTouchListener(
                new RecyclerTouchListener(
                this
                , viewsId.exercisesRecyclerList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(ExercisesActivity.this, ExerciseDetailsActivity.class)
                        .putExtra("POS", position));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        viewsId.contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this, ContactActivity.class));
            }
        });

        viewsId.aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this, AboutActivity.class));
            }
        });

    }
}