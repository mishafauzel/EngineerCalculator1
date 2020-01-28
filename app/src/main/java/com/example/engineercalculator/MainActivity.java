package com.example.engineercalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.engineercalculator.utills.FirstPanelDecorator;
import com.example.engineercalculator.utills.PanelsDecorator;
import com.example.engineercalculator.utills.SecondaryPanelDecorator;

public class MainActivity extends AppCompatActivity  implements Observer<CalcViewModel.SecondPanelState> {
    EditText equation;
    CalcViewModel calcViewModel;
    PanelsDecorator[] decorators=new PanelsDecorator[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation=this.findViewById(R.id.equation);
        calcViewModel= ViewModelProviders.of(this).get(CalcViewModel.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            equation.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            equation.setTextIsSelectable(true);
        }
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            decorators=new PanelsDecorator[2];
            decorators[1]=SecondaryPanelDecorator.getInstance(this);
            ((SecondaryPanelDecorator)decorators[1]).setCalcViewModel(calcViewModel);
            subscribeOnObservable();

        }
        decorators[0]= FirstPanelDecorator.getInstance();

        for (PanelsDecorator decorator :
                decorators) {
            decorator.bindTextView();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (PanelsDecorator decorator :
                decorators) {
            decorator.setActivity(null);
        };
    }

    public void switchState(View view)
    {
        calcViewModel.switchSecondPanelState();
    }
    public void onNumberClicked(View view)
    {
        equation.getText().insert(equation.getSelectionStart(),view.getTag().toString());
    }
    public void subscribeOnObservable()
    {
        calcViewModel.getInstanceOfSecondPanelState().observe(this,this);
    }








    @Override
    public void onChanged(CalcViewModel.SecondPanelState secondPanelState) {
        int idOfText=R.array.second_panel_first_state;
        if(secondPanelState== CalcViewModel.SecondPanelState.Second)
            idOfText=R.array.second_panel_second_state;

        ((SecondaryPanelDecorator)decorators[1]).bindTextToViews(idOfText);



    }
}
