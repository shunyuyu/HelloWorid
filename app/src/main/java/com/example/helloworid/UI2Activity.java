package com.example.helloworid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

import com.example.helloworid.databinding.ActivityUI2Binding;

public class UI2Activity extends AppCompatActivity {
    private ActivityUI2Binding mUI2Binding;
    private String android = "", spl = "", java = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUI2Binding=ActivityUI2Binding.inflate(getLayoutInflater());
        setContentView(mUI2Binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏

        mUI2Binding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUI2Binding.textView.setText(getText(R.string.button_left));
            }
        });
        mUI2Binding.buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUI2Binding.textView.setText(getText(R.string.button_right));
            }
        });
        mUI2Binding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mUI2Binding.editText.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.okno), Toast.LENGTH_LONG).show();

                } else {
                    int temp;
                    try {
                        temp = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        temp = 100;
                    }
                    mUI2Binding.progressBar.setProgress(temp);
                    mUI2Binding.textView.setText(s);
                    if (temp <= 30) {
                        mUI2Binding.radioAndroid.setChecked(true);
                    } else if (temp <= 60) {
                        mUI2Binding.radioApple.setChecked(true);
                    } else {
                        mUI2Binding.radioAli.setChecked(true);
                    }
                }
            }
        });
        mUI2Binding.buttonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mUI2Binding.textView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
            }
        });
        mUI2Binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_android:
                        mUI2Binding.imageView.setImageResource(R.drawable.android);
                        break;
                    case R.id.radio_apple:
                        mUI2Binding.imageView.setImageResource(R.drawable.apple);
                        break;
                    case R.id.radio_ali:
                        mUI2Binding.imageView.setImageResource(R.drawable.ali);
                    default:
                        break;
                }
            }
        });
        mUI2Binding.checkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    android = getResources().getString(R.string.andriod);
                } else {
                    android = "";
                }
                mUI2Binding.textView.setText(java + spl + android);
            }
        });
        mUI2Binding.checkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mUI2Binding.textView.setText(java + spl + android);
            }
        });
        mUI2Binding.checkSql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spl = getResources().getString(R.string.sql);
                } else {
                    spl = "";
                }
                mUI2Binding.textView.setText(java + spl + android);
            }
        });
        mUI2Binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mUI2Binding.textView.setText(String.valueOf(progress));
                mUI2Binding.editText.setText(String.valueOf(progress));
                mUI2Binding.progressBar.setProgress(Integer.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mUI2Binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),rating+getResources().getString(R.string.appraise),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
