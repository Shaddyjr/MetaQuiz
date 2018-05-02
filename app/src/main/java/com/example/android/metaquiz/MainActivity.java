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

    RadioGroup q1,q2;
    RadioButton a1,a2;

    EditText q3,q4;

    CheckBox q5_1,q5_2,q5_3,q5_4,q6_1,q6_2,q6_3,q6_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        a1 = findViewById(R.id.q1_3);
        a2 = findViewById(R.id.q2_4);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);

        q5_1 = findViewById(R.id.q5_1);
        q5_2 = findViewById(R.id.q5_2);
        q5_3 = findViewById(R.id.q5_3);
        q5_4 = findViewById(R.id.q5_4);

        q6_1 = findViewById(R.id.q6_1);
        q6_2 = findViewById(R.id.q6_2);
        q6_3 = findViewById(R.id.q6_3);
        q6_4 = findViewById(R.id.q6_4);
    }

    public void checkQuestions(View v){
        if (check1() && check2() && check3() && check4() && check5() && check6()) makeToast(getResources().getString(R.string.success));
    }

    private boolean check1(){
        if( findViewById(q1.getCheckedRadioButtonId())==a1) return true;
        makeToast("Question #1 was incorrect");
        return false;
    }

    private boolean check2(){
        if( findViewById(q2.getCheckedRadioButtonId())==a2) return true;
        makeToast("Question #2 was incorrect");
        return false;
    }
    private boolean check3(){
        if(q3.getText().toString().toLowerCase().equals("strings.xml")) return true;
        makeToast("Question #3 was incorrect");
        return false;
    }
    private boolean check4(){
        if(q4.getText().toString().toLowerCase().equals("private")) return true;
        makeToast("Question #4 was incorrect");
        return false;
    }
    private boolean check5(){
        if(!q5_1.isChecked() && q5_2.isChecked() && q5_3.isChecked() && !q5_4.isChecked()) return true;
        makeToast("Question #5 was incorrect");
        return false;
    }
    private boolean check6(){
        if(q6_1.isChecked() && q6_2.isChecked() && q6_3.isChecked() && !q6_4.isChecked()) return true;
        makeToast("Question #6 was incorrect");
        return false;
    }
    private void makeToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
