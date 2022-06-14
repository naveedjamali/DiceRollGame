package com.genius.dicerollgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuessFragment extends Fragment {

    public GuessFragment() {
        // Required empty public constructor
    }


    public static GuessFragment newInstance(String param1, String param2) {
        GuessFragment fragment = new GuessFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guess, container, false);

        EditText et = (EditText) view.findViewById(R.id.editText);
        Button rollDiceBtn = (Button) view.findViewById(R.id.rollDice);

        rollDiceBtn.setOnClickListener(v -> {
            if (et.getText().length() > 0) {
                int num = Integer.parseInt(et.getText().toString());

                if (num < 2 || num > 12) {
                    // Since two must produce 2 to 12 value, therefore values below 2 to above 12 are invalid.

                    Toast.makeText(view.getContext(), "Number must be between 2 to 12", Toast.LENGTH_SHORT).show();
                    et.setText("");
                } else {

                    Bundle args = new Bundle();
                    args.putInt("guessNumber", num);

                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView3, ResultFragment.class, args)
                            .commit();
                }
            }
        });
        return view;
    }
}