package com.example.magenta.network.base;

import android.app.Application;
import android.content.Context;

import com.example.magenta.network.INetworkStateChanged;

/**
 * Created by Magenta on 2017/9/11.
 */

public class MyApplication extends Application implements INetworkStateChanged {
    public static Context context;
    public static INetworkStateChanged iNetworkStateChanged;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        iNetworkStateChanged = this;
    }

    @Override
    public void onNetWorkStateChanged(int state) {
        switch (state) {
            case -1:
                MyUtil.showShortMsg(context, "无网络连接");
                break;
            case 0:
                MyUtil.showShortMsg(context, "当前网络状态：移动网络");
                break;
            case 1:
                MyUtil.showShortMsg(context, "当前网络状态：无线网络");
                break;
        }
    }
}
