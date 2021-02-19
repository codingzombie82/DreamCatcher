package com.changzakso.dreamcatcher.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.File;

public class NetworkChecker {
    public static final String TAG = NetworkChecker.class.getSimpleName();
    private volatile static NetworkChecker instance;

    public static NetworkChecker getInstance() {
        if (instance == null) {
            synchronized (NetworkChecker.class) {
                if (instance == null) {
                    instance = new NetworkChecker();
                }
            }
        }
        return instance;
    }

    /**
     * 네트워크 연결 여부를 반환한다.
     * @param context 컨텍스트
     * @return 네트워크 연결여부
     */
    public boolean isConnected(Context context) {
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();

            if (info != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
