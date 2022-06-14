package com.genius.dicerollgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Dice dice = new Dice();
    TextView creditsTv;
    Button rollAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        creditsTv = (TextView) findViewById(R.id.credits_label);
        rollAgainBtn = (Button) findViewById(R.id.roll_again_btn);
        setGuessFragment();
        rollAgainBtn.setOnClickListener(v -> setGuessFragment());
    }

    private void setGuessFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView3, GuessFragment.class, null)
                .commit();
    }
}

