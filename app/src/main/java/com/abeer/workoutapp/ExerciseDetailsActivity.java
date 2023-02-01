package com.abeer.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.abeer.workoutapp.databinding.ActivityExerciseDetailsBinding;
import com.abeer.workoutapp.databinding.ActivityExercisesBinding;

public class ExerciseDetailsActivity extends AppCompatActivity {

    ActivityExerciseDetailsBinding viewsIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewsIds = ActivityExerciseDetailsBinding.inflate(getLayoutInflater());
        setContentView(viewsIds.getRoot());

        int pos = getIntent().getIntExtra("POS", 0);

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

        String[] exercisesDescription = new String[8];
        exercisesDescription[0] = "Stand with your feet about shoulder-width apart and slightly turned out with your weight in your heels.\n" +
                "Hinge your hips to sit your butt back and bend your knees until your thighs are parallel to the ground.\n" +
                "Drive through your heels to stand back up straight. Squeeze your butt and keep your core tight as you stand.";
        exercisesDescription[1] = "Start standing with your feet about shoulder-width apart.\n" +
                "Step backwards with your left foot, landing on the ball of your foot and bending your knees to create two 90-degree angles.\n" +
                "Push through your right heel to return to standing.\n" +
                "Repeat on the other side.";
        exercisesDescription[2] = "Lie on your side, legs extended.\n" +
                "Lift your top leg 45 degrees, then lower slowly.\n" +
                "Do 5 lifts with your toe flexed, 5 with your toe pointed, and 5 with your toe pointed toward the ceiling.\n" +
                "Repeat on the other side.";
        exercisesDescription[3] = "Lie faceup on your mat with your knees bent and feet flat on the floor. Lift your hips off the mat into a bridge.\n" +
                "Keeping your right knee bent, lift your right foot off the floor. Try to keep your hips still.\n" +
                "Hold for five seconds. Slowly lower your right foot to the ground but keep your hips lifted.\n" +
                "Lift your left foot off the ground to repeat on the other side.";
        exercisesDescription[4] = "Start in a high plank.\n" +
                "Drive your right knee out and up toward your right tricep. As you do, turn your head to watch your knee meet your arm.\n" +
                "Alternate sides as fast as you can while still maintaining a sturdy plank and keeping your torso in place.";
        exercisesDescription[5] = "Starting at the left of your space, squat slightly then jump to the right as far as you can.\n" +
                "Land on your right foot and try not to touch your left foot down.\n" +
                "Jump back across to land on your left foot.";
        exercisesDescription[6] = "Start on all fours.\n" +
                "Pull your right knee toward your chest, keeping your foot flexed.\n" +
                "Then, kick your right leg up behind you and toward the sky, then back down, keeping your knee bent and foot flexed.\n" +
                "Repeat on the other side.\n";
        exercisesDescription[7] = "Stand with your feet hip-width apart and hands behind your head and elbows wide.\n" +
                "Lift your left knee toward your left elbow while you bend your torso up and over to the left.\n" +
                "Repeat on the other side.";

        Drawable exerciseDrawable = this.getDrawable(exercisesImgs[pos]);
        viewsIds.exerciseImg.setImageDrawable(exerciseDrawable);
        viewsIds.exercisetitle.setText(exercisesTitles[pos]);
        viewsIds.exerciseDescription.setText(exercisesDescription[pos]);

    }
}
