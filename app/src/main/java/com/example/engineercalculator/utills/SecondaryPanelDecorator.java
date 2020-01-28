package com.example.engineercalculator.utills;

import android.widget.EditText;
import android.widget.TextView;

import com.example.engineercalculator.CalcViewModel;
import com.example.engineercalculator.MainActivity;
import com.example.engineercalculator.R;
import com.example.engineercalculator.utills.onclicllisteners.SecondaryPanelOnClickListener;

public class SecondaryPanelDecorator implements PanelsDecorator {
    private final int[] idsOfSecondPanel=new int[]{
            R.id.switch_state, R.id.radian, R.id.square_root,
            R.id.sin, R.id.cos, R.id.tan,
            R.id.ln, R.id.log, R.id.one_divide_byx,
            R.id.epowerx, R.id.square, R.id.xpowerofy,
            R.id.module, R.id.pi, R.id.e
    };
    private TextView[] secondaryButtonsArray;
    private MainActivity activity;
    private static SecondaryPanelDecorator instatnce;
    private CalcViewModel calcViewModel;
    private SecondaryPanelDecorator secPanelDecorator;
    private SecondaryPanelOnClickListener onClickListener;


    public static SecondaryPanelDecorator getInstance(MainActivity activity)
    {
        if(instatnce==null)
        {
            instatnce=new SecondaryPanelDecorator();
        }

        return instatnce;
    }

    @Override
    public void setActivity(MainActivity activity)
    {
        this.activity=activity;
        secondaryButtonsArray =null;
        if(activity==null)
            onClickListener.setEquation(null);
        else
            onClickListener.setEquation((EditText) activity.findViewById(R.id.equation));

    }

    @Override
    public void bindTextView()
    {

        secondaryButtonsArray = new TextView[idsOfSecondPanel.length];
        for (int i = 0; i < idsOfSecondPanel.length; i++) {
            secondaryButtonsArray[i] = activity.findViewById(idsOfSecondPanel[i]);
            secondaryButtonsArray[i].setOnClickListener(onClickListener);
        }
    }


    @Override
    public void bindTextToViews(int idOfResourses) {
        String[] arrayOfTexts = activity.getResources().getStringArray(idOfResourses);
        for (int i = 0; i < arrayOfTexts.length; i++) {
            secondaryButtonsArray[i].setText(arrayOfTexts[i]);
            }
        }
        private void createOnClickListener(CalcViewModel calcViewModel)
        {
            if(onClickListener==null)
                onClickListener=new SecondaryPanelOnClickListener(calcViewModel);
        }


}
