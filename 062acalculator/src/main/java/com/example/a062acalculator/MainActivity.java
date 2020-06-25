package com.example.a062acalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    TextView textView;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnId = {R.id.Btn0,R.id.Btn1,R.id.Btn2,R.id.Btn3,R.id.Btn4,R.id.Btn5,R.id.Btn6,R.id.Btn7,R.id.Btn8,R.id.Btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("나아진 계산기 - 박정선");

        editText1 = findViewById(R.id.Edit1);
        editText2 = findViewById(R.id.Edit2);
        buttonAdd = findViewById(R.id.BtnAdd);
        buttonSub = findViewById(R.id.BtnSub);
        buttonMul = findViewById(R.id.BtnMul);
        buttonDiv = findViewById(R.id.BtnDiv);
        textView = findViewById(R.id.Tresult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textView.setText("계산결과 : " + result);
            }
        });

        for(int i = 0; i<numBtnId.length; ++i){
            numButtons[i] = findViewById(numBtnId[i]);
            final int index = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(editText1.isFocused()){
                        num1 = editText1.getText().toString() +
                                numButtons[index].getText().toString();
                        editText1.setText(num1);
                    }else if(editText2.isFocused()){
                        num2 = editText2.getText().toString() +
                                numButtons[index].getText().toString();;
                        editText2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "에디트 1, 2를 먼저 선택하세요.",
                                Toast.LENGTH_LONG).show();//어쩌구저쩌구
                        //이러쿵저러쿵
                        //왔다리갔다리
                        //요리조리
                        //영차영차
                        //끼룩끼룩
                        //안녕하세요 교수님
                    }
                }
            });
        }
    }
}
