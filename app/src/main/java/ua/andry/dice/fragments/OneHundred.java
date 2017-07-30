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
public class OneHundred extends Fragment {


    public OneHundred() {
        // Required empty public constructor
    }

    static ImageView image1;
    static ImageView image2;
    static TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.fragment_one_hundred, container, false);

        image2 = (ImageView) rootView.findViewById(R.id.diced100);
        image1 = (ImageView) rootView.findViewById(R.id.diced1);
        text = (TextView) rootView.findViewById(R.id.textOneHundred);

        return rootView;
    }

    public static void onShake() {
        int[] dice1 = {R.drawable.ten1,R.drawable.ten2,R.drawable.ten3,R.drawable.ten4,R.drawable.ten5,R.drawable.ten6,
                R.drawable.ten7,R.drawable.ten8 ,R.drawable.ten9,R.drawable.ten10};
        int[] dice100 = {R.drawable.hundred10,R.drawable.hundred20,R.drawable.hundred30,
                R.drawable.hundred40,R.drawable.hundred50,R.drawable.hundred60,
                R.drawable.hundred70,R.drawable.hundred80,R.drawable.hundred90,
                R.drawable.hundred100};
        String[] textcon = {"Looseer!", "Nice Try","Nice","Nice","Not Bad","Nice","Not Bad","Not Bad", "Good", "Lucky"};
        int result1 = (int) (Math.random() * 10);
        int result2 = (int) (Math.random() * 10);
        image2.setImageResource(dice100[result2]);
        image1.setImageResource(dice1[result1]);
        spinDice1();
        spinDice();
        text.setText(textcon[result1]);
    }

    static void spinDice1() {
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(image1, "rotationY", 0.0f, 360f);
        animation1.setDuration((int)(Math.random()*500));
        animation1.setRepeatCount((int)(Math.random()*7));
        animation1.setInterpolator(new AccelerateDecelerateInterpolator());
        animation1.start();
    }
    static void spinDice() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(image2, "rotationY", 0.0f, 360f);
        animation.setDuration((int)(Math.random()*500));
        animation.setRepeatCount((int)(Math.random()*7));
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
    }
}
