package com.example.gudla.dicecupcompulsory.Model;

import com.example.gudla.dicecupcompulsory.BE.Roll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudla on 01/03/2018.
 */

public class RollModel {

    private static RollModel instance = null;
    private List<Roll> mDiceList;

    public static RollModel getInstance()
    {
        if (instance == null)
        {
            instance = new RollModel();
        }
        return instance;
    }

    private RollModel()
    {
        this.mDiceList = new ArrayList<>();
    }
    public ArrayList<Roll> getDiceList()
    {
        return new ArrayList<>(mDiceList);
    }
    public void addRoll (Roll roll)
    {
        mDiceList.add(roll);
    }
    public Roll getRoll (int positionInList)
    {
        return mDiceList.get(positionInList);
    }
    public void clearRolls()
    {
        mDiceList.clear();
    }


}
