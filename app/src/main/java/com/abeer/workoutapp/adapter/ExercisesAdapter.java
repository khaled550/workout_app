package com.abeer.workoutapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abeer.workoutapp.R;
import com.abeer.workoutapp.model.Exercise;

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    Context context;
    private List<Exercise> exercises;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView exerciseImg;
        public TextView exerciseTitle;

        public ViewHolder(View view) {
            super(view);
            exerciseImg = (ImageView) view.findViewById(R.id.exerciseImg);
            exerciseTitle = (TextView) view.findViewById(R.id.exerciseTitle);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public ExercisesAdapter(Context context, List<Exercise> moviesList) {
        this.exercises = moviesList;
        this.context = context;
    }

    @Override
    public ExercisesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemStepView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_list_item, parent, false);

        return new ViewHolder(itemStepView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        Drawable exerciseDrawable = context.getDrawable(exercise.getImgPath());
        holder.exerciseImg.setImageDrawable(exerciseDrawable);
        holder.exerciseTitle.setText(exercise.getTitle());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}