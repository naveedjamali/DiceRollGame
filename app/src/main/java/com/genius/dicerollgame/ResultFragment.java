package com.genius.dicerollgame;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ResultFragment extends Fragment {

    int guessNumber = 0;
    ImageView img1, img2;
    TextView resultMessage;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           guessNumber = getArguments().getInt("guessNumber");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        resultMessage = view.findViewById(R.id.result_message_tv);

        Dice dice = mainActivity.dice;
        dice.passedGuess = guessNumber;
        dice.rollDice(img1,img2);
        if(dice.correctGuess){
            resultMessage.setText("Your guess is CORRECT");
        }else{
            resultMessage.setText("Your guess is WRONG");
        }
        mainActivity.creditsTv.setText(dice.getRemainingCredits()+"");
        return view;
    }


}