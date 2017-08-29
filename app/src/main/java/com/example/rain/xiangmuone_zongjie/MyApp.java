package com.example.rain.xiangmuone_zongjie;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

import org.xutils.x;


/**
 * data 2017/8/9.
 * author:霍远东(Rain)
 * function:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("1106036236", "mjFCi0oxXZKZEWJs");
        x.Ext.init(this);
    }
}
