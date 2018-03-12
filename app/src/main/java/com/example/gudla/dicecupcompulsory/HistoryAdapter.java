package com.example.gudla.dicecupcompulsory;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gudla.
 */

public class HistoryAdapter extends BaseAdapter{

    private ArrayList<RollEntity> mRollEntityHistory;
    private final Activity context;

    public HistoryAdapter(Activity context, ArrayList<RollEntity> rollEntityHistory)
    {
        this.context = context;
        this.mRollEntityHistory = rollEntityHistory;
    }

    @Override
    public int getCount()
    {
        return mRollEntityHistory.size()+1;
    }

    @Override
    public Object getItem (int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View rowView = view;
        //reuse the views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_history_row, null);
            //configure the ViewHolder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtTimeStamp = rowView.findViewById(R.id.txtTimeStamp);
            viewHolder.txtDiceRolls = rowView.findViewById(R.id.txtDiceRolls);
            viewHolder.txtResultHis = rowView.findViewById(R.id.txtResultHis);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        if (pos == 0) {
            holder.txtTimeStamp.setText("Time Stamp");
            holder.txtDiceRolls.setText("Dice Rolls");
            holder.txtResultHis.setText("Result");
        } else {
            pos--;
            RollEntity entity = mRollEntityHistory.get(pos);
            holder.txtTimeStamp.setText(entity.getTimeAsString());
            String rolls = "";
            rolls = rolls + entity.getDice().get(0);
            for (int i = 1; i < entity.getDice().size(); i++) {
                rolls = rolls + ", " + entity.getDice().get(i);
            }
            holder.txtDiceRolls.setText(rolls);
            holder.txtResultHis.setText(entity.getSum() + "");
        }

        return rowView;
    }

    //Create the ViewHolder
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    static class ViewHolder
    {
        TextView txtDiceRolls, txtResultHis, txtTimeStamp;
    }
}











