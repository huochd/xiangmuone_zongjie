package com.example.rain.xiangmuone_zongjie.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rain.xiangmuone_zongjie.ImageLoaderUtils;
import com.example.rain.xiangmuone_zongjie.R;


import uk.co.senab.photoview.PhotoView;


public class PhotoFragment extends Fragment {
    private String str;
    private PhotoView photoView;

    public void setString(String str){
        this.str=str;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        photoView = (PhotoView) view.findViewById(R.id.pv);
        ImageLoaderUtils.setImageView(str,getActivity(),photoView);
        return view;
    }

}
