package com.example.magenta.network.util;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Magenta on 2017/9/11.
 */

public class NetWorkUtil {
    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return boolean
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            //获取手机所有连接管理对象(包括对Wifi，net等连接的管理)
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            //获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            //判断NetworkInfo对象是否为空
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断WIFI网络是否连接
     *
     * @param context
     * @return boolean
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            //获取手机所有连接管理对象(包括对Wifi，net等连接的管理)
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            //获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            //判断NetworkInfo对象是否为空，并且类型是否为WIFI
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI && networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断Mobile网络是否连接
     *
     * @param context
     * @return boolean
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            //获取手机所有连接管理对象(包括对Wifi，net等连接的管理)
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            //获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            //判断NetworkInfo对象是否为空，并且类型是否为Mobile
            if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前网络连接的信息
     * --原生版本
     *
     * 没有网络：-1
     * WIFI网络：1
     * Mobile网络：0
     *
     * @param context
     * @return int
     */
    public static int getConnectedType(Context context) {
        if (context != null) {
            //获取手机所有连接管理对象(包括对Wifi，net等连接的管理)
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            //获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable() == true) {
                return networkInfo.getType();
            }
        }
        return -1;
    }

}
