package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworid.databinding.ActivityMainBinding;
import com.example.helloworid.databinding.ActivityUpdatePwdBinding;

/**
 * @author xushunyu
 */
public class UpdatePwdActivity extends AppCompatActivity {

    private ActivityUpdatePwdBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonUpdatePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = mBinding.editPassword.getText().toString().trim();
                String pwdOK = mBinding.editPasswordOk.getText().toString().trim();
                String toast;
                if(pwd.length()==6){
                    if(!pwd.equals(pwdOK)){
                        toast="两次密码不一致,请重新输入！";
                    }else {
                        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                        String phone = getIntent().getStringExtra("phone_");
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("pwd_"+phone,pwd).apply();
                        Intent intent = new Intent(UpdatePwdActivity.this,MainActivity.class);
                        startActivity(intent);
                        toast ="修改成功！";
                    }
                } else {
                    toast="密码必须是六位！";
                }

                Toast.makeText(UpdatePwdActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        });
    }
}