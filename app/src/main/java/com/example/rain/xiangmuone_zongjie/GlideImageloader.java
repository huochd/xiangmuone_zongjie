package com.example.rain.xiangmuone_zongjie;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * data 2017/8/9.
 * author:霍远东(Rain)
 * function:
 */

public class GlideImageloader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }


}
