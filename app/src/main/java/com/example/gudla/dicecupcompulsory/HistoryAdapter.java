package com.example.gudla.dicecupcompulsory;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gudla.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder>
{

    private RollModel mRollModel = RollModel.getInstance();

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new HistoryHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
        RollEntity roll = mRollModel.getRoll(position);
        holder.bind(roll);
    }

    @Override
    public int getItemCount() {
        return mRollModel.getDiceList().size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder
    {
        TextView mRollInfo;
        LinearLayout mDiceList;
        Context mContext;
        RollEntity mRoll;

        public HistoryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_history_row, parent, false));
            mContext = parent.getContext();

            mRollInfo = itemView.findViewById(R.id.txtRollInfo);
            mDiceList = itemView.findViewById(R.id.linearDice);
        }

        public void bind(RollEntity roll) {
            mRoll = roll;
            mRollInfo.setText(roll.getTimeAsString());

            for (int currentDie : roll.getDice()) {
                int dieResource = DiceManager.getImage(currentDie);
                ImageView dieImageView = new ImageView(mContext);
                dieImageView.setImageResource(dieResource);
                mDiceList.addView(dieImageView);
            }
        }

    }
}











