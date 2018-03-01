package com.example.gudla.dicecupcompulsory.BLL;

import com.example.gudla.dicecupcompulsory.R;

/**
 * Created by gudla on 01/03/2018.
 */

public class DiceManager {

    public static int getImage(int dieNumber) {
        switch (dieNumber) {
            case 1: {
                return R.drawable.dice1;
            }
            case 2: {
                return R.drawable.dice2;
            }
            case 3: {
                return R.drawable.dice3;
            }
            case 4: {
                return R.drawable.dice4;
            }
            case 5: {
                return R.drawable.dice5;
            }
            case 6: {
                return R.drawable.dice6;
            }
            default:
                return 0;
        }
    }
}
