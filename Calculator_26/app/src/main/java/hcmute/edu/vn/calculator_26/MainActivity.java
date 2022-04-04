package hcmute.edu.vn.calculator_26;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    // Declare buttons and textview
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnAdd,btnSub,btnMul,btnDevide,btnAC,btnEqual,btnDot;
    TextView showValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btn0=(Button) findViewById(R.id.btn0);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnMul=(Button) findViewById(R.id.btnMulti);
        btnSub=(Button) findViewById(R.id.btnMinus);
        btnDevide=(Button) findViewById(R.id.btnDecide);
        btnAC=(Button) findViewById(R.id.btnC);
        btnDot=(Button) findViewById(R.id.btnDot);
        btnEqual=(Button) findViewById(R.id.btnEqual);
        showValue=(TextView)  findViewById(R.id.viewsrs);

        // button 1
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                // if textview is '0' set '1'
                // if textview is not '0' set textview = textview string +'1'
                if(str.equals("0"))
                    showValue.setText("1");
                else
                    showValue.setText(str+"1");

            }
        });

        // button Delete
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            // Set textview to '0' -- normal
            public void onClick(View view) {
                showValue.setText("0");
            }
        });

        //button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString(); // get String from textview
                if(str.equals("0")) // if textview is '0' set '2'
                    showValue.setText("2");
                else   // if textview is not '0' set textview = textview string +'2'
                    showValue.setText(str+"2");
            }
        });

        // button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();// get String from textview
                if(str.equals("0")) // if textview is '0' set '3'
                    showValue.setText("3");
                else  // if textview is not '0' set textview = textview string +'3'
                    showValue.setText(str+"3");
            }
        });
          //-----------------------//
         // Button 4-0 is similar.//
        //-----------------------//

        // button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("4");
                else
                    showValue.setText(str+"4");
            }
        });

        // button 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("5");
                else
                    showValue.setText(str+"5");
            }
        });

        // button 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("6");
                else
                    showValue.setText(str+"6");
            }
        });

        //button 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("7");
                else
                    showValue.setText(str+"7");
            }
        });

        //button 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("8");
                else
                    showValue.setText(str+"8");
            }
        });

        //button 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("9");
                else
                    showValue.setText(str+"9");
            }
        });
        // button 0
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString();
                if(str.equals("0"))
                    showValue.setText("0");
                else
                    showValue.setText(str+"0");
            }
        });

        //button Dot
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= showValue.getText().toString(); // get string from textview
                if(str.indexOf(".")!=-1) // if dot is exist, check the existence of operation in expression
                    // if the expression has operation
                    if(str.indexOf("+")!=-1||str.indexOf("-")!=-1||str.indexOf("*")!=-1||str.indexOf("/")!=-1)
                        showValue.setText(showValue.getText().toString()+"."); // can add dot to 2nd operand
                    else // if not, skip
                        showValue.setText(showValue.getText().toString());
                else{
                    showValue.setText(showValue.getText().toString()+"."); // add dot to 1st operand
                }

            }
        });

        // button Addition
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=showValue.getText().toString();
                if(str.indexOf("+")!=-1)  // if the expression has operation '+'
                {
                    float sum=0;
                   String[] parts= getNumber(str,"+"); // split the string to get number 1 and number 2
                   float num1=Float.parseFloat(parts[0]);
                   float num2=Float.parseFloat(parts[1]);
                   sum=num1+num2;
                   if(sum==(int)sum) // if sum is integer then convert sum to integer number
                        showValue.setText(String.valueOf((int)sum)+"+"); // set textview to sum
                   else
                       showValue.setText(String.valueOf(sum)+"+");
                }

                // operation '-'is similar to '+'.
                else if(str.indexOf("-")!=-1){
                    float sub=0;
                    String[] parts= getNumber(str,"-");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sub=num1-num2;
                    if(sub==(int)sub)
                        showValue.setText(String.valueOf((int)sub)+"+");
                    else
                        showValue.setText(String.valueOf(sub)+"+");

                }

                // operation '*'is similar to '+'.
                else if (str.indexOf("*")!=-1){
                    float mul=0;
                    String[] parts= getNumber(str,"*");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    mul=num1*num2;
                    if(mul==(int)mul)
                        showValue.setText(String.valueOf((int)mul)+"+");
                    else
                        showValue.setText(String.valueOf(mul)+"+");
                }
                else if (str.indexOf("/")!=-1){
                    float div=0;
                    String[] parts= getNumber(str,"/"); // split the string to get number 1 and number 2
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    div=num1/num2;
                    if(num2==0){ // if num2 =0
                        if (num1==0)
                            showValue.setText("Undefined"); // result is undefined

                        else // num1 != 0
                            showValue.setText("Can't divide"); // Can't divide by zero
                    }
                    else if(div==(int)div) //if div is integer then convert div to integer number
                        showValue.setText(String.valueOf((int)div)+"+");
                    else
                        showValue.setText(String.valueOf((float)Math.round(div* 100) / 100)+"+"); // set to 2nd decimal
                }
                else
                    showValue.setText(showValue.getText().toString()+"+");
            }
        });

        // button Subtraction
        // button Subtraction is similar to button Addition
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=showValue.getText().toString();
                if(str.indexOf("+")!=-1)
                {
                    float sum=0;
                    String[] parts= getNumber(str,"+");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sum=num1+num2;
                    if(sum==(int)sum)
                        showValue.setText(String.valueOf((int)sum)+"-");
                    else
                        showValue.setText(String.valueOf(sum)+"-");
                }
                else if(str.indexOf("-")!=-1){
                    float sub=0;
                    String[] parts= getNumber(str,"-");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sub=num1-num2;
                    if(sub==(int)sub)
                        showValue.setText(String.valueOf((int)sub)+"-");
                    else
                        showValue.setText(String.valueOf(sub)+"-");
                }
                else if (str.indexOf("*")!=-1){
                    float mul=0;
                    String[] parts= getNumber(str,"*");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    mul=num1*num2;
                    if(mul==(int)mul)
                        showValue.setText(String.valueOf((int)mul)+"-");
                    else
                        showValue.setText(String.valueOf(mul)+"-");
                }
                else if (str.indexOf("/")!=-1){
                    float div=0;
                    String[] parts= getNumber(str,"/");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    div=num1/num2;
                    if(num2==0){
                        if (num1==0)
                            showValue.setText("Undefined");

                        else
                            showValue.setText("Can't divide");
                    }
                     else if(div==(int)div)
                        showValue.setText(String.valueOf((int)div)+"-");
                    else
                        showValue.setText(String.valueOf((float)Math.round(div* 100) / 100)+"-");
                }
                else
                    showValue.setText(showValue.getText().toString()+"-");
            }
        });

        // button Multiplication
        // button Multiplication is similar to button Addition
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=showValue.getText().toString();
                if(str.indexOf("+")!=-1)
                {
                    float sum=0;
                    String[] parts= getNumber(str,"+");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sum=num1+num2;
                    if(sum==(int)sum)
                        showValue.setText(String.valueOf((int)sum)+"*");
                    else
                        showValue.setText(String.valueOf(sum)+"*");
                }
                else if(str.indexOf("-")!=-1){
                    float sub=0;
                    String[] parts= getNumber(str,"-");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sub=num1-num2;
                    if(sub==(int)sub)
                        showValue.setText(String.valueOf((int)sub)+"*");
                    else
                        showValue.setText(String.valueOf(sub)+"*");
                }
                else if (str.indexOf("*")!=-1){
                    float mul=0;
                    String[] parts= getNumber(str,"*");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    mul=num1*num2;
                    if(mul==(int)mul)
                        showValue.setText(String.valueOf((int)mul)+"*");
                    else
                        showValue.setText(String.valueOf(mul)+"*");
                }
                else if (str.indexOf("/")!=-1){
                    float div=0;
                    String[] parts= getNumber(str,"/");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    div=num1/num2;
                    if(num2==0){
                        if (num1==0)
                            showValue.setText("Undefined");

                        else
                            showValue.setText("Can't divide");
                    }
                    else if(div==(int)div)
                        showValue.setText(String.valueOf((int)div)+"*");
                    else
                        showValue.setText(String.valueOf((float)Math.round(div* 100) / 100)+"*");
                }
                else
                    showValue.setText(showValue.getText().toString()+"*");
            }
        });

        // button Division
        // button Division is similar to button Addition
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=showValue.getText().toString();
                if(str.indexOf("+")!=-1)
                {
                    float sum=0;
                    String[] parts= getNumber(str,"");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sum=num1+num2;
                    if(sum==(int)sum)
                        showValue.setText(String.valueOf((int)sum)+"/");
                    else
                        showValue.setText(String.valueOf(sum)+"/");
                }
                else if(str.indexOf("-")!=-1){
                    float sub=0;
                    String[] parts= getNumber(str,"-");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    sub=num1-num2;
                    if(sub==(int)sub)
                        showValue.setText(String.valueOf((int)sub)+"/");
                    else
                        showValue.setText(String.valueOf(sub)+"/");
                }
                else if (str.indexOf("*")!=-1){
                    float mul=0;
                    String[] parts= getNumber(str,"*");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    mul=num1*num2;
                    if(mul==(int)mul)
                        showValue.setText(String.valueOf((int)mul)+"/");
                    else
                        showValue.setText(String.valueOf(mul)+"/");
                }
                else if (str.indexOf("/")!=-1){
                    float div=0;
                    String[] parts= getNumber(str,"/");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    div=num1/num2;
                    if(num2==0){
                        if (num1==0)
                            showValue.setText("Undefined");

                        else
                            showValue.setText("Can't divide");
                    }
                    else if(div==(int)div)
                        showValue.setText(String.valueOf((int)div)+"/");
                    else
                        showValue.setText(String.valueOf((float)Math.round(div* 100) / 100)+"/");
                }
                else
                    showValue.setText(showValue.getText().toString()+"/");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=showValue.getText().toString();

                float result;
                if(str.indexOf("+")!=-1){
                    String[] parts= getNumber(str,"+");
                   float num1=Float.parseFloat(parts[0]);
                   float num2=Float.parseFloat(parts[1]);
                   result=num1+num2;
                    if(result==(int)result)
                        showValue.setText(String.valueOf((int)result));
                    else
                        showValue.setText(String.valueOf((float)Math.round(result* 100) / 100));
                }
                else if(str.indexOf("-")!=-1){
                    String[] parts= getNumber(str,"-");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    result=num1-num2;
                    if(result==(int)result)
                        showValue.setText(String.valueOf((int)result));
                    else
                        showValue.setText(String.valueOf((float)Math.round(result* 100) / 100));
                }
                else if(str.indexOf("*")!=-1){
                    String[] parts= getNumber(str,"*");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    result=num1*num2;
                    if(result==(int)result)
                        showValue.setText(String.valueOf((int)result));
                    else
                        showValue.setText(String.valueOf((float)Math.round(result* 100) / 100));
                }
                else if(str.indexOf("/")!=-1){
                    String[] parts= getNumber(str,"/");
                    float num1=Float.parseFloat(parts[0]);
                    float num2=Float.parseFloat(parts[1]);
                    result=num1/num2;
                    if(num2==0){
                        if (num1==0)
                            showValue.setText("Undefined");

                        else
                            showValue.setText("Can't divide");
                    }
                    else if(result==(int)result)
                        showValue.setText(String.valueOf((int)result));
                    else
                        showValue.setText(String.valueOf((float)Math.round(result* 100) / 100));
                }
            }
        });

    }



//    // caculator function
//    public static Object doCalc(String str)  {
//        Context context = Context.enter(); //
//        context.setOptimizationLevel(-1); //
//        Scriptable scope = context.initStandardObjects();
//        Object result = context.evaluateString(scope, str, "javascript", 1, null);
//        return result;
//    }


    // get number function():

    public String[] getNumber(String str,String oprt){ // input: expression string and operation string
        String[] parts= str.split(Pattern.quote(oprt)); // split expression string by operation string into 2 string and put into an Array String
        return parts;
    }
}