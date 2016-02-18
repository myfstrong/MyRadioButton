package com.myfstrong.myradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioBtn_Yes;
    private RadioButton radioBtn_No;

    private Button btn_Submit;
    private Button btn_GroupSubmit;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioBtn_Yes = (RadioButton)findViewById(R.id.radioBtn_Yes);
        radioBtn_No = (RadioButton)findViewById(R.id.radioBtn_No);

        btn_Submit = (Button)findViewById(R.id.btn_Submit);
        btn_GroupSubmit = (Button)findViewById(R.id.btn_GroupSubmit);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        //实例1：通过RadioButton和Button实现RadioButton内容的提交
/*        radioBtn_Yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,isChecked+"",Toast.LENGTH_SHORT).show();
            }
        });

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!radioBtn_Yes.isChecked()) {
                    Toast.makeText(MainActivity.this, "未选中", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, radioBtn_Yes.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        //实例2：通过RadioGroup和Button实现RadioButton内容的提交
/*        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton currentRadioBtn = (RadioButton)findViewById(checkedId);
                Toast.makeText(MainActivity.this,currentRadioBtn.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });*/

        btn_GroupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentRadioBtnId = radioGroup.getCheckedRadioButtonId();

                if(currentRadioBtnId > 0) {
                    RadioButton currentRadioBtn = (RadioButton)findViewById(currentRadioBtnId);
                    Toast.makeText(MainActivity.this,currentRadioBtn.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"什么都没选中",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
