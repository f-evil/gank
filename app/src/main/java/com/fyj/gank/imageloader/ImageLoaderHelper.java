package com.fyj.gank.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.fyj.gank.GankApp;
import com.fyj.gank.R;

/**
 * 图片加载器配置中心
 * 便于后期替换加载类库
 * Created by Fyj on 2016/6/13.
 */
public class ImageLoaderHelper {

    private RequestManager mRequestManager;

    private static class SingletonInstance{
        private static final ImageLoaderHelper INSTANCE=new ImageLoaderHelper();
    }

    public static ImageLoaderHelper getInstance(){
        return SingletonInstance.INSTANCE;
    }

    private ImageLoaderHelper(){
        mRequestManager = Glide.with(GankApp.getAppContext());
    }

    public void loadImgHead(String url,ImageView img){
        mRequestManager
                .load(url)
                .error(R.mipmap.icon_bg_hf_ho_load)
                .placeholder(R.mipmap.icon_bg_hf_ho_load)
                .into(img);
    }

    public void loadImgAd(String url,ImageView img){
        mRequestManager
                .load(url)
                .error(R.mipmap.icon_bg_hf_ver_load)
                .placeholder(R.mipmap.icon_bg_hf_ver_load)
                .into(img);
    }

}
