package com.example.magenta.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.example.magenta.network.base.MyApplication;
import com.example.magenta.network.util.NetWorkUtil;

/**
 * Created by Magenta on 2017/9/11.
 */

public class NetworkBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION))
            MyApplication.iNetworkStateChanged.onNetWorkStateChanged(NetWorkUtil.getConnectedType(context));
    }
}
