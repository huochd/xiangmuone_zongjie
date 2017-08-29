package com.example.rain.xiangmuone_zongjie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.rain.xiangmuone_zongjie.GlideImageloader;
import com.example.rain.xiangmuone_zongjie.MyBaseAdapter;
import com.example.rain.xiangmuone_zongjie.MyBean;
import com.example.rain.xiangmuone_zongjie.PhotoActivity;
import com.example.rain.xiangmuone_zongjie.R;
import com.example.rain.xiangmuone_zongjie.xlistview.XListView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.example.rain.xiangmuone_zongjie.R.id.ll;


/**
 * data 2017/8/9.
 * author:霍远东(Rain)
 * function:
 */
public class Fragment1 extends Fragment implements XListView.IXListViewListener {
    private XListView xListView;
    private View view;
    private List<MyBean.ResultBean.DataBean> list;
    private String path;
    private MyBaseAdapter myBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1, container, false);
        x.view().inject(getActivity());
        xListView = (XListView) view.findViewById(R.id.xlistview);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(this);

        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                list = new ArrayList<MyBean.ResultBean.DataBean>();
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(result, MyBean.class);
                list = myBean.result.data;
                myBaseAdapter = new MyBaseAdapter(getActivity(), list);


                View view1 = View.inflate(getActivity(), R.layout.header, null);

                xListView.addHeaderView(view1);

                xListView.setAdapter(myBaseAdapter);
                xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intt = new Intent();
                        intt.putExtra("url", list.get(position).url);
                        intt.setClass(getActivity(), WebActivity.class);
                        startActivity(intt);
                    }
                });
                Banner banner = (Banner) view.findViewById(R.id.banner);
                FrameLayout ll = (FrameLayout) view.findViewById(R.id.ll);
                banner.setImageLoader(new GlideImageloader());
                final List<String> img = new ArrayList<>();
                MyBean.ResultBean.DataBean imgs = list.get(0);
                img.add(imgs.thumbnail_pic_s);
                img.add(imgs.thumbnail_pic_s02);
                img.add(imgs.thumbnail_pic_s03);
                banner.setImages(img);
                banner.start();
                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent inn = new Intent();
                        String[] imgg = new String[img.size()];
                        Toast.makeText(getContext(), "imgg:" + imgg, Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < img.size(); i++) {
                            imgg[i] = img.get(i);
                        }
                        inn.putExtra("img", imgg);
                        inn.setClass(getActivity(), PhotoActivity.class);
                        startActivity(inn);
                    }
                });
            }

            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
        return view;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            myBaseAdapter.notifyDataSetChanged();
            close();
        }
    };


    int a = 15;

    public void setpath(String str) {
        this.path = str;
    }

    @Override
    public void onRefresh() {
        a -= 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("000000000000000:" + a);


                list.add(0, list.get(a));

                handler.sendEmptyMessage(0);

            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
    }

    public void close() {
        xListView.stopRefresh();
        getCurrentTime();
    }

    private String getCurrentTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }


}
