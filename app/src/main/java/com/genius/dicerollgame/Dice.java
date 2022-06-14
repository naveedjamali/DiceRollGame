package com.genius.dicerollgame;

import android.widget.ImageView;

import java.util.Random;

class Dice {

    int credits = 20;

    void rollDice(ImageView img1, ImageView img2) {

        Random random = new Random();

        int dice1Result = random.nextInt() % 7;
        while (dice1Result < 1) {
            dice1Result = random.nextInt() % 7;
        }

        int dice2Result = random.nextInt() % 7;
        while (dice2Result < 1) {
            dice2Result = random.nextInt() % 7;
        }

        int img1ResourceId = 0;
        switch (dice1Result) {
            case 1:
                img1ResourceId = R.drawable.dice1img;
                break;
            case 2:
                img1ResourceId = R.drawable.dice2img;
                break;
            case 3:
                img1ResourceId = R.drawable.dice3img;
                break;
            case 4:
                img1ResourceId = R.drawable.dice4img;
                break;
            case 5:
                img1ResourceId = R.drawable.dice5img;
                break;
            case 6:
                img1ResourceId = R.drawable.dice6img;
                break;
        } int img2ResourceId = 0;
        switch (dice2Result) {
            case 1:
                img2ResourceId = R.drawable.dice1img;
                break;
            case 2:
                img2ResourceId = R.drawable.dice2img;
                break;
            case 3:
                img2ResourceId = R.drawable.dice3img;
                break;
            case 4:
                img2ResourceId = R.drawable.dice4img;
                break;
            case 5:
                img2ResourceId = R.drawable.dice5img;
                break;
            case 6:
                img2ResourceId = R.drawable.dice6img;
                break;
        }

        img1.setImageResource(img1ResourceId);
        img2.setImageResource(img2ResourceId);


    }

    int getRemainingCredits() {
        return this.credits;
    }

    void addCredits(int crd) {
        this.credits += crd;
    }

    void deduct(int crd) {
        this.credits -= crd;
    }
}