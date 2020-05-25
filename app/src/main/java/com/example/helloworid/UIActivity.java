package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener , RatingBar.OnRatingBarChangeListener {

    private TextView mTextView;
    private Button mButtonLeft, mButtonRight, mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonAndriod, mRadioButtonApple, mRadioButtonAli;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckBoxJava, mCheckBoxSQL, mCheckBoxAndroid;
    private RatingBar mRatingBar;

    private String android = "", spl = "", java = "";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏

        mTextView = findViewById(R.id.text_view);
        mButtonLeft = findViewById(R.id.button_left);
        mButtonRight = findViewById(R.id.button_right);
        mSwitch = findViewById(R.id.button_switch);
        mButtonOk = findViewById(R.id.button_ok);
        mProgressBar = findViewById(R.id.progress_bar);
        mEditText = findViewById(R.id.edit_text);
        mRadioGroup = findViewById(R.id.radio_group);
        mImageView = findViewById(R.id.image_view);
        mRadioButtonAndriod = findViewById(R.id.radio_android);
        mRadioButtonApple = findViewById(R.id.radio_apple);
        mRadioButtonAli = findViewById(R.id.radio_ali);
        mSeekBar = findViewById(R.id.seek_bar);
        mCheckBoxJava = findViewById(R.id.check_java);
        mCheckBoxAndroid = findViewById(R.id.check_android);
        mCheckBoxSQL = findViewById(R.id.check_sql);
        mRatingBar =findViewById(R.id.rating_bar);


        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mButtonOk.setOnClickListener(this);

        mSwitch.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
        mCheckBoxSQL.setOnCheckedChangeListener(this);
        mCheckBoxAndroid.setOnCheckedChangeListener(this);
        mCheckBoxJava.setOnCheckedChangeListener(this);
        mRatingBar.setOnRatingBarChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_left:
                mTextView.setText(getResources().getString(R.string.button_left));
                break;
            case R.id.button_right:
                mTextView.setText(getResources().getString(R.string.button_right));
                break;
            case R.id.button_ok:
                String s = mEditText.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.okno), Toast.LENGTH_LONG).show();

                } else {
                    int temp;
                    try {
                        temp = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        temp = 100;
                    }
                    mProgressBar.setProgress(temp);
                    mTextView.setText(s);
                    if (temp <= 30) {
                        mRadioButtonAndriod.setChecked(true);
                    } else if (temp <= 60) {
                        mRadioButtonApple.setChecked(true);
                    } else {
                        mRadioButtonAli.setChecked(true);
                    }
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.button_switch:
                mTextView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
                break;
            case R.id.check_java:
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mTextView.setText(java + spl + android);
                break;
            case R.id.check_sql:
                if (isChecked) {
                    android = getResources().getString(R.string.sql);
                } else {
                    android = "";
                }
                mTextView.setText(java + spl + android);
                break;
            case R.id.check_android:
                if (isChecked) {
                    spl = getResources().getString(R.string.andriod);
                } else {
                    spl = "";
                }
                mTextView.setText(java + spl + android);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_android:
                mImageView.setImageResource(R.drawable.android);
                break;
            case R.id.radio_apple:
                mImageView.setImageResource(R.drawable.apple);
                break;
            case R.id.radio_ali:
                mImageView.setImageResource(R.drawable.ali);
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTextView.setText(String.valueOf(progress));
        mEditText.setText(String.valueOf(progress));
        mProgressBar.setProgress(Integer.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(getApplicationContext(),rating+getResources().getString(R.string.appraise),Toast.LENGTH_SHORT).show();
    }
}
