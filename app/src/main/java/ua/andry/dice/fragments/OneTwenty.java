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
public class OneTwenty extends Fragment {


    public OneTwenty() {
        // Required empty public constructor
    }
    static ImageView image;
    static TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_one_twenty, container, false);

        image =(ImageView) rootView.findViewById(R.id.diced20);
        text = (TextView) rootView.findViewById(R.id.textOneTwenty);

        return rootView;
    }

    public static void onShake() {
        int[] dice = {R.drawable.twenty1,R.drawable.twenty2,R.drawable.twenty3,
                R.drawable.twenty4,R.drawable.twenty5,R.drawable.twenty6,
                R.drawable.twenty7,R.drawable.twenty8,R.drawable.twenty9,
                R.drawable.twenty10,R.drawable.twenty11,R.drawable.twenty12,
                R.drawable.twenty13,R.drawable.twenty14,R.drawable.twenty15,
                R.drawable.twenty16,R.drawable.twenty17,R.drawable.twenty18,
                R.drawable.twenty19,R.drawable.twenty20,};

        String[] textcon = {"Looseer!", "Nice Try","Nice Try", "Nice", "Nice",
                "Nice", "Nice","Nice",
                "Not Bad", "Not Bad", "Not Bad","Not Bad", "Not Bad","Good", "Good","Good","Good",
                "Good","Good","Lucky"};
        int result = (int) (Math.random() * 20);
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
