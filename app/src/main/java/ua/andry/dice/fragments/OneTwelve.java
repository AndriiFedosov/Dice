package ua.andry.dice.fragments;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import ua.andry.dice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneTwelve extends Fragment {


    public OneTwelve() {
    }

    static ImageView image;
    static TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_one_twelve, container, false);

        image =(ImageView) rootView.findViewById(R.id.diced12);
        text = (TextView) rootView.findViewById(R.id.textOneTwelve);

        return rootView;
    }

    public static void onShake() {
        int[] dice = {R.drawable.twelve1,R.drawable.twelve2,R.drawable.twelve3,R.drawable.twelve4,
                R.drawable.twelve5,R.drawable.twelve6,R.drawable.twelve7,R.drawable.twelve8,
                R.drawable.twelve9,R.drawable.twelve10,R.drawable.twelve11,R.drawable.twelve12};

        String[] textcon = {"Looseer!", "Nice Try","Nice Try", "Nice", "Nice", "Not Bad", "Nice", "Not Bad", "Not Bad","Good","Good", "Lucky"};
        int result = (int) (Math.random() * 12);
        image.setImageResource(dice[result]);
        spinDice();

        text.setText(textcon[result]);
    }

    static void spinDice() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(image, "rotationY", 0.0f, 360f);
        animation.setDuration((int)(Math.random()*500));
        animation.setRepeatCount((int)(Math.random()*7));
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
    }
}
