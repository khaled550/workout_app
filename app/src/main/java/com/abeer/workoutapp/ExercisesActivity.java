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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsId = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(viewsId.getRoot());

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Exercise1", R.drawable.app_icon));
        exercises.add(new Exercise("Exercise2", R.drawable.app_icon));

        exercisesAdapter = new ExercisesAdapter(this, exercises);
        mLayoutManager = new GridLayoutManager(this , 2);
        viewsId.exercisesRecyclerList.setLayoutManager(mLayoutManager);
        viewsId.exercisesRecyclerList.setAdapter(exercisesAdapter);
        viewsId.exercisesRecyclerList.addOnItemTouchListener(new RecyclerTouchListener(this
                , viewsId.exercisesRecyclerList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                /*Intent intent = new Intent(this, MovieDetails.class)
                        .putExtra("MOVIE_POSITION",position);
                startActivity(intent);*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}