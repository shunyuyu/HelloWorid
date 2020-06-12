package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

    public static final String EXIT_HOME = "exit_home";
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
        intent.putExtra(EXIT_HOME,"您已退出账号");
        setResult(RESULT_OK,intent);
    }

    /**
     * 对外提供公开的静态的启动Activity的方法
     * @param activity 启动方的上下文
     * @param userName  用户昵称
     * @param pwd   用户密码
     * @param userSex   用户性别
     * @param phone 用户手机号
     * @param userSms 用户是否接受消息推送
     * @param resultCode  请求代码
     */
    public static void actionStart(Activity activity,String userName,String pwd,String userSex,
                                   String phone,String userSms,int resultCode)
    {
        Intent intent = new Intent(activity,HomeActivity.class);
        Bundle bundle= new Bundle();
        UserInfo userInfo = new UserInfo(userName,pwd,userSex,phone,userSms);
        bundle.putSerializable("userInfo",userInfo);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent,resultCode);
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
