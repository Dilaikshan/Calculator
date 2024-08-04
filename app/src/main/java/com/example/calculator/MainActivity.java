package com.example.calculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //create objects for each components
    private Button btnC;
    private Button btnPlus;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnDel;
    private Button btnEqual;
    private Button btnMinus;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private TextView display1;
    private TextView display2;

    private double preValue=0;
    private double currentValue=0;

    private char currenOp=' ';






    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calculator);

        //Wiring to all components
        btnDel = (Button) findViewById(R.id.buttonDel);
        btnPlus = (Button) findViewById(R.id.plusButton);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMulti = (Button) findViewById(R.id.buttonx);
        btnDiv = (Button) findViewById(R.id.buttonSlash);
        btnC = (Button) findViewById(R.id.buttonC);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        display1 = (TextView) findViewById(R.id.display1);
        display2 = (TextView) findViewById(R.id.display2);

        btnC.setBackgroundColor(Color.RED);
        btnDel.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnC.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnPlus.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnMulti.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnMinus.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnDiv.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btnEqual.setBackgroundColor(getResources().getColor(R.color.button_special_background));
        btn1.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn2.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn3.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn4.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn5.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn6.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn7.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn8.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn9.setBackgroundColor(getResources().getColor(R.color.button_background));
        btn0.setBackgroundColor(getResources().getColor(R.color.button_background));


//       clearText();

       btnC.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               clearText();
           }
       });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentValue = (currentValue * 10 ) + 1;
                disVal();
            }
        });

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               currentValue = (currentValue * 10 ) + 2;
               disVal();
           }
       });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 3;
                disVal();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 4;
                disVal();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 5;
                disVal();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 6;
                disVal();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 7;
                disVal();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 8;
                disVal();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) + 9;
                disVal();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = (currentValue * 10 ) ;
                disVal();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tenp=(int)currentValue/10;
                currentValue=tenp;
                disVal();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentValue==0 || preValue==0)
                {
                    currenOp='+';
                    preValue = currentValue==0 ? preValue: currentValue;
                    display2.setText(Double.toString(preValue)+currenOp);
                    currentValue=0;
                } else if (currentValue!=0 && currenOp!=' ') {
                    opChange(currenOp);
                    currenOp='+';
                    disVal();
                    currentValue=0;
                } else{
                    currenOp='+';
                    preValue=preValue+currentValue;
                    currentValue=preValue;
                    disVal();
                    currentValue=0;

                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preValue==0)
                {
                    currenOp='-';
                    preValue = currentValue==0 ? preValue: currentValue;
                    display2.setText(Double.toString(preValue)+currenOp);
                    currentValue=0;
                } else if (currentValue!=0 && currenOp!=' ') {
                    opChange(currenOp);
                    currenOp='-';
                    disVal();
                    currentValue=0;
                } else{
                    currenOp='-';
                    preValue=preValue-currentValue;
                    currentValue=preValue;
                    disVal();
                    currentValue=0;

                }
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentValue==0 || preValue==0)
                {
                    currenOp='x';
                    preValue = currentValue==0 ? preValue: currentValue;
                    display2.setText(Double.toString(preValue)+currenOp);
                    currentValue=0;
                } else if (currentValue!=0 && currenOp!=' ') {
                    opChange(currenOp);
                    currenOp='x';
                    disVal();
                    currentValue=0;
                } else{
                    currenOp='x';
                    preValue=preValue*currentValue;
                    currentValue=preValue;
                    disVal();
                    currentValue=0;

                }


            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preValue==0)
                {
                    currenOp='/';
                    preValue = currentValue==0 ? preValue: currentValue;
                    display2.setText(Double.toString(preValue)+currenOp);
                    currentValue=0;
                } else if (currentValue!=0 && currenOp!=' ') {
                    opChange(currenOp);
                    currenOp='/';
                    disVal();
                    currentValue=0;
                } else{
                    currenOp='/';
                    if (currentValue==0)
                    {
                        display1.setText("Error");
                    }
                    else {
                        preValue = preValue / currentValue;
                        currentValue = preValue;
                        disVal();
                        currentValue = 0;
                    }

                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opChange(currenOp);
                disVal();
                currentValue=0;
                //clearValue();

            }
        });






    }


    //clear function
    protected void clearText()
    {
        preValue=0;
        currentValue=0;
        currenOp=' ';
        display1.setText("0");
        display2.setText("0");
    }

    //clear function
    protected void clearValue()
    {
        preValue=0;
        currentValue=0;
        currenOp=' ';

    }

    //print values
    protected void disVal()
    {

        if ((preValue % 1 == 0) && (currentValue % 1 == 0))
        {
            int pre=(int)preValue;
            int temp= (int)currentValue;
            display1.setText(Integer.toString(temp));
            display2.setText(Double.toString(pre)+currenOp);
        }else if(preValue % 1 == 0){
            int pre=(int)preValue;
            display1.setText(Double.toString(currentValue));
            display2.setText(Double.toString(pre)+currenOp);
        }else if (currentValue % 1== 0)
        {

            int temp= (int)currentValue;
            display1.setText(Integer.toString(temp));
            display2.setText(Double.toString(preValue)+currenOp);
        }else{
            display1.setText(Double.toString(currentValue));
            display2.setText(Double.toString(preValue)+currenOp);
        }

    }

    //when have operator with curent value
    protected void opChange(char op)
    {
        switch (op)
        {
            case '+':
                preValue=currentValue+preValue;
                currentValue=preValue;
                break;
            case '-':
                preValue=preValue-currentValue;
                currentValue=preValue;
                break;
            case 'x':
                preValue=currentValue*preValue;
                currentValue=preValue;
                break;
            default:
                if (currentValue==0)
                {
                    display1.setText("Error");
                }else{
                    preValue=preValue/currentValue;
                    currentValue=preValue;
                }


        }
    }


}