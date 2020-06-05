package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworid.databinding.ActivityHomeBinding;

import java.time.Instant;
import java.util.Objects;

/**
 * @author xushunyu
 */
public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent = getIntent();
        UserInfo info = (UserInfo) intent.getSerializableExtra("userInfo");
        String phone = Objects.requireNonNull(info).getPhone();
        String userName = info.getUserName();
        String userSex = info.getSex();
        String userSms = info.getSms();

        mBinding.textPhone.setText(phone);
        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
        mBinding.textName.setText(userName);
        mBinding.textSex.setText(userSex);
        String temp = mBinding.textSms.getText().toString() + "是否接受推送:" + userSms;
        mBinding.textSms.setText(temp);
    }

    /**
     * 拦截系统返回键
     */
    @Override
    public void onBackPressed() {
        exit();
    }

    private void exit() {
        long time = 2000;
        if (System.currentTimeMillis() - exitTime > time) {
            exitTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "快速点击两下，可退出当前账号", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }
}
