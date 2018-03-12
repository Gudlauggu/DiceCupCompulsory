package com.example.gudla.dicecupcompulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudla on 01/03/2018.
 */

public class RollModel {

    private static RollModel instance = null;
    private List<RollEntity> mDiceList;

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
    public ArrayList<RollEntity> getDiceList()
    {
        return new ArrayList<>(mDiceList);
    }
    public void addRoll (RollEntity rollEntity)
    {
        mDiceList.add(rollEntity);
    }
    public RollEntity getRoll (int positionInList)
    {
        return mDiceList.get(positionInList);
    }
    public void clearRolls()
    {
        mDiceList.clear();
    }


}
