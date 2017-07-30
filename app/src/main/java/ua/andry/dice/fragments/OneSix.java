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
public class OneSix extends Fragment {


    public OneSix() {
        // Required empty public constructor
    }


    static ImageView image;
    static TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.fragment_one_six, container, false);

        image = (ImageView) rootView.findViewById(R.id.diced6);
        text = (TextView) rootView.findViewById(R.id.textOneSix);

        return rootView;
    }

    public static void onShake(){
        int[]dice ={R.drawable.six1,R.drawable.six2,R.drawable.six3,R.drawable.six4,R.drawable.six5,
                R.drawable.six6,};
        String []textcon = {"Looseer!","Nice Try","Nice","Nice","Good","Lucky"};
        int result= (int) (Math.random() * 6);
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
