package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mBinding.editPhone.getText().toString();
                String pwd = mBinding.editPwd.getText().toString();
                if(phone.equals("10086")&&pwd.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("data_phone",phone);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "手机号或密码错误！", Toast.LENGTH_LONG).show();
                }
            }
        });
        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
