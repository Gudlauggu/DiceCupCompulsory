package com.example.gudla.dicecupcompulsory;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.gudla.dicecupcompulsory.Model.RollModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {

    private RollModel mRollModel;
    private List<Dice> mDiceList;
    private List<Integer> mDiceValues;
    private Spinner mAmountOfDice;
    private int mSpinnerValue;
    private LinearLayout mDiceLayout;
    private LinearLayout firstRow;
    private LinearLayout secondRow;
    private final int MAX_ROW_SIZE = 3;
    public static final String DICE_KEY = "DICE";
    public static final String SPINNER_KEY = "SPINNER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        mRollModel = RollModel.getInstance();
        mDiceValues = new ArrayList<>();

        Button btnRoll = findViewById(R.id.btnRoll);
        mDiceLayout = findViewById(R.id.linLDices);

        initlSpinner();
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        if (savedInstanceState != null) {
            mDiceValues = (List<Integer>) savedInstanceState.getSerializable(DICE_KEY);
            mSpinnerValue = savedInstanceState.getInt(SPINNER_KEY);
            reinstateDice(mDiceValues);
        }
    }

    private void reinstateDice(List<Integer> diceValues)
    {
        mDiceList = new ArrayList<>();
        mDiceLayout.removeAllViews();
        firstRow = new LinearLayout(this);
        firstRow.setGravity(Gravity.CENTER);
        for (int i = 0; i < MAX_ROW_SIZE; i++)
        {
            if(i < diceValues.size())
            {
                secondCreateSingleDice(firstRow, mDiceList, diceValues.get(i));
            }
        }
        mDiceLayout.addView(firstRow);

        if(diceValues.size() > MAX_ROW_SIZE)
        {
            secondRow = new LinearLayout(this);
            secondRow.setGravity(Gravity.CENTER);
            for(int i = MAX_ROW_SIZE; i < diceValues.size(); i++);
        }
        mDiceLayout.addView(secondRow);
    }


    private void initlSpinner()
    {
        mAmountOfDice = findViewById(R.id.btnSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SpinnerArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAmountOfDice.setAdapter(adapter);
        mAmountOfDice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
               int numberOfDice = Integer.parseInt(parent.getItemAtPosition(position).toString());

               if (numberOfDice != 0 && numberOfDice != mSpinnerValue)
               {
                   mSpinnerValue = numberOfDice;
                   createDice(numberOfDice);
               }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void createDice(int amountOfDice)
    {
        mDiceList = new ArrayList<>();
        mDiceLayout.removeAllViews();
        firstRow = new LinearLayout(this);
        firstRow.setGravity(Gravity.CENTER);
        for (int i = 0; i < MAX_ROW_SIZE; i++)
        {
            if(i < amountOfDice)
            {
                createSingleDice(firstRow, mDiceList);
            }
        }
        mDiceLayout.addView(firstRow);
        if(amountOfDice > MAX_ROW_SIZE)
        {
            secondRow = new LinearLayout(this);
            secondRow.setGravity(Gravity.CENTER);
            for(int i = MAX_ROW_SIZE; i < amountOfDice; i++)
            {
                createSingleDice(secondRow, mDiceList);
            }
            mDiceLayout.addView(secondRow);
        }
    }

    private void createSingleDice(LinearLayout layout, List<Dice> list)
    {
       Dice dice = new Dice(this);
       dice.setPadding(5, 5, 5, 5);
       list.add(dice);
       layout.addView(dice);
    }

    private void secondCreateSingleDice(LinearLayout layout, List<Dice> list, int value)
    {
        Dice dice = new Dice(this, value);
        dice.setPadding(5, 5, 5, 5);
        list.add(dice);
        layout.addView(dice);
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
