package com.example.engineercalculator.utills.onclicllisteners;

import android.view.View;
import android.widget.EditText;

import com.example.engineercalculator.CalcViewModel;
import com.example.engineercalculator.utills.TagOfSecondPanel;
import com.example.engineercalculator.utills.TagOfSecondPanel.TypeOfButton;
public class SecondaryPanelOnClickListener implements View.OnClickListener {
    private CalcViewModel calcViewModel;
    private EditText equation;

    public SecondaryPanelOnClickListener(CalcViewModel calcViewModel) {
        this.calcViewModel = calcViewModel;
    }

    public void setEquation(EditText equation) {
        this.equation = equation;
    }

    @Override
    public void onClick(View view) {
        TypeOfButton typeOfButton=((TagOfSecondPanel)view.getTag()).getTypeOfButton();
        switch (typeOfButton)
        {
            //TO-DO implement reaction on second panel's buttons clicks
        }
    }
}
