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
public class OneEight extends Fragment {


    public OneEight() {
        // Required empty public constructor
    }

    static ImageView image;
    static TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.fragment_one_eight, container, false);

        image = (ImageView) rootView.findViewById(R.id.diced8);
        text = (TextView) rootView.findViewById(R.id.textOneEight);

        return rootView;
    }

    public static void onShake() {
        int[] dice = {R.drawable.eight1,R.drawable.eight2,R.drawable.eight3,R.drawable.eight4,
                R.drawable.eight5,R.drawable.eight6,R.drawable.eight7,R.drawable.eight8};
        String[] textcon = {"Looseer!", "Nice Try","Nice","Nice","Not Bad","Not Bad", "Good", "Lucky"};
        int result = (int) (Math.random() * 8);
        spinDice();
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