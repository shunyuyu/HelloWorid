package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworid.databinding.ActivityRegisterBinding;
import com.example.helloworid.databinding.ActivityResetPwdBinding;

/**
 * @author xushunyu
 */
public class ResetPwdActivity extends AppCompatActivity {

    private ActivityResetPwdBinding mBinding;
    String name, sex = "", phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityResetPwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonResetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = mBinding.editPhone.getText().toString();
                name = mBinding.editName.getText().toString();
                String toast;
                if (name.equals("")) {
                    toast = "请填写昵称！";
                } else if (sex.equals("")) {
                    toast = "请选择性别！";
                } else if (phone.equals("")) {
                    toast = "请填写手机号码！";
                } else if (phone.length() != 11) {
                    toast = "请输入正确的手机号码！";
                } else {
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    String error = "0";
                    String spName = sp.getString("name_"+phone,error);
                    String spSex = sp.getString("sex_"+phone,error);
                    String spPhone = sp.getString("phone_" + phone, error);
                    if (!spName.equals(name)||!spPhone.equals(phone)||!spSex.equals(sex)) {
                        toast = "信息部匹配，无法重置密码";
                    }else {
                        Intent intent = new Intent(ResetPwdActivity.this,UpdatePwdActivity.class);
                        intent.putExtra("phone_",phone);
                        startActivity(intent);
                        toast ="请填写新密码";
                    }
                }
                Toast.makeText(ResetPwdActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                } else {
                    sex = mBinding.radioWomen.getText().toString();
                }

            }
        });
    }
}