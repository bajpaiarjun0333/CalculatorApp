package sample;
//Aim is to create a simple calculator app having basic functionality like add subtract multiply and divide

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller implements EventHandler<KeyEvent>{
    //We will make instances of all the buttons here and then compare all the ,buttons as to which is clicked by using
    //the switch case statement.
    String calString[]=new String[30];
    @FXML
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    int i=0;
    int key=0;

    @FXML
    TextArea resultColumn;

    String textAreaString="";
    @FXML
    FlowPane keyBoard;
    @FXML
    BorderPane mainLayout;

    @FXML
    public void initialize(){
        mainLayout.setOnKeyReleased(this::handle);
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
           String entered=event.getCode().toString().substring(5);
        System.out.println(entered);
    }

    @FXML
    public void btnPressed(javafx.event.ActionEvent e){
        //using switch case
        Button btn=(Button)e.getSource();
        System.out.println(btn.getId());
        String button_press;
//        if(enter!=null){
//            button_press=enter;
//        }else {
//            button_press=btn.getId();
//        }

        switch(btn.getId()){
            case "one":
                calString[i]="1";
                textAreaString=textAreaString+"1";
                i++;
                break;
            case "two":
                calString[i]="2";
                textAreaString=textAreaString+"2";
                i++;
                break;
            case "three":
                calString[i]="3";
                textAreaString=textAreaString+"3";
                i++;
                break;
            case "four":
                calString[i]="4";
                textAreaString=textAreaString+"4";
                i++;
                break;
            case "five":
                calString[i]="5";
                textAreaString=textAreaString+"5";
                i++;
                break;
            case "six":
                calString[i]="6";
                textAreaString=textAreaString+"6";
                i++;
                break;
            case "seven":
                calString[i]="7";
                textAreaString=textAreaString+"7";
                i++;
                break;
            case "eight":
                calString[i]="8";
                textAreaString=textAreaString+"8";
                i++;
                break;
            case "nine":
                calString[i]="9";
                textAreaString=textAreaString+"9";
                i++;
                break;
            case "zero":
                calString[i]="0";
                textAreaString=textAreaString+"0";
                i++;
                break;
            case "addButton":
                calString[i]="+";
                textAreaString=textAreaString+"+";
                i++;
                break;
            case "subtractButton":
                calString[i]="-";
                textAreaString=textAreaString+"-";
                i++;
                break;
            case "divideButton":
                calString[i]="/";
                textAreaString=textAreaString+"/";
                i++;
                break;
            case "multiplyButton":
                calString[i]="*";
                textAreaString=textAreaString+"*";
                i++;
                break;
            case "equal":
                processCalString();
                break;
            case "clear":
                textAreaString="";
                calString=new String[30];
                i=0;
                break;
        }
        resultColumn.setText(textAreaString);
        System.out.println(textAreaString);
    }
    public void processCalString(){
        String splitcalString[] = new String[30];
        splitcalString=calString;
        int length=splitcalString.length;
        double num1,num2;
        String result="0.0";
        for (int j=0;j<i;j++){

            //System.out.println(splitcalString[i]);
            switch (splitcalString[j]){
                case "+":
                    num1=Double.parseDouble(splitcalString[j-1]);
                    num2=Double.parseDouble(splitcalString[j+1]);

                    splitcalString[j+1]=Double.toString(num1+num2);
                    break;
                case "-":
                    num1=Double.parseDouble(splitcalString[j-1]);
                    num2=Double.parseDouble(splitcalString[j+1]);
                    splitcalString[j+1]=Double.toString(num1-num2);
                    break;
                case "*":
                    num1=Double.parseDouble(splitcalString[j-1]);
                    num2=Double.parseDouble(splitcalString[j+1]);
                    splitcalString[j+1]=Double.toString(num1*num2);
                    break;
                case "/":
                     num1=Double.parseDouble(splitcalString[j-1]);
                     num2=Double.parseDouble(splitcalString[j+1]);
                    System.out.println(num1+"   "+num2);
                    splitcalString[j+1]=Double.toString(num1/num2);
                    break;

            }
            result=splitcalString[j];

        }
        resultColumn.setFont(Font.font(30.0));
        textAreaString=textAreaString+"="+result;

        resultColumn.setText(textAreaString);
        return;

    }
}
