package com.example.gudla.dicecupcompulsory;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);
    }

    private class Dice extends AppCompatImageView {
        private final int MAX = 6;

        private int mValue;

        /**
         * Create new random die
         *
         * @param context
         */
        public Dice(Context context) {
            super(context);
            rollDie();
        }

        public Dice(Context context, int value) {
            super(context);
            mValue = value;
            setImage();
        }

        public int getValue() {
            return mValue;
        }

        public void rollDie() {
            Random rand = new Random();
            mValue = rand.nextInt(MAX) + 1;
            setImage();
        }

        private void setImage() {
            switch (mValue) {
                case 1: {
                    setImageResource(R.drawable.dice1);
                    break;
                }
                case 2: {
                    setImageResource(R.drawable.dice2);
                    break;
                }
                case 3: {
                    setImageResource(R.drawable.dice3);
                    break;
                }
                case 4: {
                    setImageResource(R.drawable.dice4);
                    break;
                }
                case 5: {
                    setImageResource(R.drawable.dice5);
                    break;
                }
                case 6: {
                    setImageResource(R.drawable.dice6);
                    break;
                }
            }
        }
    }
}
