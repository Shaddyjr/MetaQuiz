package com.example.android.metaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup
            mRadioGroup1,
            mRadioGroup2;
    RadioButton
            answer1,
            answer2;

    EditText
            mEditText1,
            mEditText2;

    CheckBox
            mCheckboxQ5_answer1,
            mCheckboxQ5_answer2,
            mCheckboxQ5_answer3,
            mCheckboxQ5_answer4,
            mCheckboxQ6_answer1,
            mCheckboxQ6_answer2,
            mCheckboxQ6_answer3,
            mCheckboxQ6_answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup1            = findViewById(R.id.mRadioGroup1);
        mRadioGroup2            = findViewById(R.id.mRadioGroup2);
        answer1                 = findViewById(R.id.answer1);
        answer2                 = findViewById(R.id.answer2);
        mEditText1              = findViewById(R.id.mEditText1);
        mEditText2              = findViewById(R.id.mEditText2);

        mCheckboxQ5_answer1     = findViewById(R.id.mCheckboxQ5_answer1);
        mCheckboxQ5_answer2     = findViewById(R.id.mCheckboxQ5_answer2);
        mCheckboxQ5_answer3     = findViewById(R.id.mCheckboxQ5_answer3);
        mCheckboxQ5_answer4     = findViewById(R.id.mCheckboxQ5_answer4);

        mCheckboxQ6_answer1     = findViewById(R.id.mCheckboxQ6_answer1);
        mCheckboxQ6_answer2     = findViewById(R.id.mCheckboxQ6_answer2);
        mCheckboxQ6_answer3     = findViewById(R.id.mCheckboxQ6_answer3);
        mCheckboxQ6_answer4     = findViewById(R.id.mCheckboxQ6_answer4);
    }

    public void checkQuestions(View v){
        int score = 0;
        String message = " Incorrect Questions:";

        if(check1())    score++;
        else            message += " 1";

        if(check2())    score++;
        else            message += " 2";

        if(check3())    score++;
        else            message += " 3";

        if(check4())    score++;
        else            message += " 4";

        if(check5())    score++;
        else            message += " 5";

        if(check6())    score++;
        else            message += " 6";

        if(score >= 6)  message = " " + getResources().getString(R.string.success);

        makeToast("Score: " + String.valueOf(score) + " out of 6." + message );
    }

    private boolean check1(){
        return findViewById(mRadioGroup1.getCheckedRadioButtonId()) == answer1;
    }

    private boolean check2(){
        return findViewById(mRadioGroup2.getCheckedRadioButtonId()) == answer1;
    }

    private boolean check3(){
        return mEditText1.getText().toString().toLowerCase().equals("strings.xml");
    }

    private boolean check4(){
        return mEditText2.getText().toString().toLowerCase().equals("private");
    }

    private boolean check5(){
        return !mCheckboxQ5_answer1.isChecked() && mCheckboxQ5_answer2.isChecked() && mCheckboxQ5_answer3.isChecked() && !mCheckboxQ5_answer4.isChecked();
    }

    private boolean check6(){
        return mCheckboxQ6_answer1.isChecked() && mCheckboxQ6_answer2.isChecked() && mCheckboxQ6_answer3.isChecked() && !mCheckboxQ6_answer4.isChecked();
    }

    private void makeToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}
