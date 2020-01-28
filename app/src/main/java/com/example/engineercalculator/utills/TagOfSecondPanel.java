package com.example.engineercalculator.utills;

public class TagOfSecondPanel {
    private TypeOfButton typeOfButton;
    private String text;

    public TagOfSecondPanel(TypeOfButton typeOfButton, String text) {
        this.typeOfButton = typeOfButton;
        this.text = text;
    }
    public TypeOfButton getTypeOfButton() {
        return typeOfButton;
    }

    public void setTypeOfButton(TypeOfButton typeOfButton) {
        this.typeOfButton = typeOfButton;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public enum TypeOfButton{}
}
