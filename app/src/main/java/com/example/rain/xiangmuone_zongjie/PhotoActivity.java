package com.example.rain.xiangmuone_zongjie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rain.xiangmuone_zongjie.fragment.PhotoFragment;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.M;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Soul elegy on 2017/8/20.
 */

public class PhotoActivity extends AppCompatActivity {
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=59954023");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoactivity);
        initView();
        String[] img = getIntent().getStringArrayExtra("img");
        List<Fragment> fragments = new ArrayList<Fragment>();
        for(int i =0;i<img.length;i++){
            PhotoFragment fragment = new PhotoFragment();
            fragment.setString(img[i]);
            fragments.add(fragment);
        }
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments));
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
