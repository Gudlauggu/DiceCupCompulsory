package com.example.gudla.dicecupcompulsory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by gudla on 01/03/2018.
 */

public class RollEntity implements Serializable{

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    public List<Integer> getDice()
    {
        return mDice;
    }

    private Date mDate;

    private List<Integer> mDice;

    public RollEntity()
    {
        mDate = new Date();
        mDice = new ArrayList<>();
    }

    public String getTimeAsString() {
        return SIMPLE_DATE_FORMAT.format(mDate);
    }

    public void addDice(int die)
    {
        mDice.add(die);
    }

    public int getSum()
    {
        int sum = 0;
        for (int dieValue: mDice) {
            sum += dieValue;
        }
        return sum;
    }

}
