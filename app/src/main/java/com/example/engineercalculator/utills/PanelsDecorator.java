package com.example.engineercalculator.utills;

import android.widget.TextView;

import com.example.engineercalculator.MainActivity;

public interface PanelsDecorator {
     void setActivity(MainActivity activity);
     void bindTextView();
     void bindTextToViews(int idOfResourses);

}
