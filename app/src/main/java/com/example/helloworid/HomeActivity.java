package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.helloworid.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent = getIntent();
        String phone = intent.getStringExtra("data_phone");
        mBinding.textPhone.setText(phone);

        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
        String userName = sp.getString("name_"+phone,"0");
        String userSex = sp.getString("sex_"+phone,"0");
        String userSms = sp.getString("sms_"+phone,"0").equals("1")?"接受":"不接受";
        mBinding.textName.setText(userName);
        mBinding.textSex.setText(userSex);
        String temp =mBinding.textSms.getText().toString()+"是否接受推送:"+userSms;
        mBinding.textSms.setText(temp);
    }
}
