package com.example.engineercalculator.utills;

import android.widget.EditText;
import android.widget.TextView;

import com.example.engineercalculator.MainActivity;
import com.example.engineercalculator.R;

public class FirstPanelDecorator implements PanelsDecorator{
    private int[] idsOfButtons=new int[]{
            R.id.delete_button, R.id.branches,R.id.percent,R.id.divide,
            R.id.number7,R.id.number8,R.id.number8,R.id.multiply,
            R.id.number6,R.id.number5,R.id.number4,R.id.minus,
            R.id.number3,R.id.number2,R.id.number1,R.id.plus,
            R.id.changeSign,R.id.number0,R.id.dot,R.id.equals

    };
    MainActivity activity;
    EditText equation;
    TextView[] textViews;
    private static FirstPanelDecorator instance;
    public static FirstPanelDecorator getInstance()
    {
        return new FirstPanelDecorator();
    }
    @Override
    public void setActivity(MainActivity activity) {
        this.activity=activity;
        textViews=null;
        if(activity!=null)

        else


    }

    @Override
    public void bindTextView() {
        textViews=new TextView[idsOfButtons.length];
        for(int i = 0 ; i < idsOfButtons.length; i++) {
            textViews[i]=activity.findViewById(idsOfButtons[i]);
        }
    }

    @Override
    public void bindTextToViews(int idOfResourses) {

    }
}
