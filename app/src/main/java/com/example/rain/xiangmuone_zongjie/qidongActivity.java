package com.example.rain.xiangmuone_zongjie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * data 2017/8/11.
 * author:霍远东(Rain)
 * function:
 */

public class qidongActivity extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //加载启动界面
            setContentView(R.layout.activity_qidong);
            Integer time = 2000;    //设置等待时间，单位为毫秒
            Handler handler = new Handler();
            //当计时结束时，跳转至主界面
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(qidongActivity.this, MainActivity.class));
                    qidongActivity.this.finish();
                }
            }, time);
        }}

