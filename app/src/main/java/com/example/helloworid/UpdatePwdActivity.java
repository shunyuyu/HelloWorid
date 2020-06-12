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
                if(!pwd.equals(pwdOK)){
                    Toast.makeText(UpdatePwdActivity.this, "两次密码不一致,请重新输入！", Toast.LENGTH_LONG).show();
                }else {
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    String phone = getIntent().getStringExtra("phone_");
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pwd_"+phone,pwd);
                    editor.apply();
                    Toast.makeText(UpdatePwdActivity.this, "修改成功！", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UpdatePwdActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}