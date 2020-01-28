package com.example.engineercalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalcViewModel extends ViewModel {
    private CalculatorExecutioner executioner;



    private MutableLiveData<SecondPanelState> secondPanelState;

    public CalcViewModel() {
        this.secondPanelState=new MutableLiveData<>();
        this.executioner = new CalculatorExecutioner();
    }
    public LiveData<SecondPanelState> getInstanceOfSecondPanelState()
    {
        if(secondPanelState==null)
        {secondPanelState=new MutableLiveData<>();
        secondPanelState.setValue(SecondPanelState.First);
        }
        return secondPanelState;
    }

    public void switchSecondPanelState() {
        if (secondPanelState.getValue()==SecondPanelState.First)
        {
            secondPanelState.setValue(SecondPanelState.Second);
        }
        else
            secondPanelState.setValue(SecondPanelState.First);
    }

    public enum SecondPanelState{First,Second}
}
