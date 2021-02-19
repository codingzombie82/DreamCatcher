package com.changzakso.dreamcatcher.utils;

import android.util.Log;

import com.changzakso.dreamcatcher.BuildConfig;

public class CzLog {
    private static boolean enabled = BuildConfig.DEBUG;

    public static void d(String tag, String text) {
        if (!enabled) return;

        Log.d(tag, text);
    }

    public static void d(String text) {
        if (!enabled) return;

        Log.d("tag", text);
    }

    public static void d(String tag, Class<?> cls, String text) {
        if (!enabled) return;

        Log.d(tag, cls.getName() + "." + text);
    }


    public static void e(String tag, String text) {
        if (!enabled) return;

        Log.e(tag, text);
    }
}
