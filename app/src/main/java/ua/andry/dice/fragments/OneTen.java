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
public class OneTen extends Fragment {


    public OneTen() {
        // Required empty public constructor
    }
    static ImageView image;
    static TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.fragment_one_ten, container, false);

        image = (ImageView) rootView.findViewById(R.id.diced10);
        text = (TextView) rootView.findViewById(R.id.textOneTen);

        return rootView;
    }

    public static void onShake() {
        int[] dice = {R.drawable.ten1,R.drawable.ten2,R.drawable.ten3,R.drawable.ten4,R.drawable.ten5,R.drawable.ten6,
                R.drawable.ten7,R.drawable.ten8 ,R.drawable.ten9,R.drawable.ten10};
        String[] textcon = {"Looseer!", "Nice Try","Nice","Nice","Not Bad","Nice","Not Bad","Not Bad", "Good", "Lucky"};
        int result = (int) (Math.random() * 10);

        image.setImageResource(dice[result]);
        spinDice();

        text.setText(textcon[result]);
    }
    static final Random sRandom = new Random();
    static int lastAngle = -1;

    static void spinDice() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(image, "rotationY", 0.0f, 360f);
        animation.setDuration((int)(Math.random()*500));
        animation.setRepeatCount((int)(Math.random()*7));
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
    }
}
