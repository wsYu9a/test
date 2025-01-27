package com.martian.libvideoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class t {
    public static void a(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            context.getSharedPreferences("JCVD_PROGRESS", 0).edit().clear().apply();
        } else {
            context.getSharedPreferences("JCVD_PROGRESS", 0).edit().putInt(url, 0).apply();
        }
    }

    public static int b(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatActivity c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return c(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String d(LinkedHashMap<String, String> map, int index) {
        return map == null ? "" : map.size() == 1 ? g(map, index) : g(map, index);
    }

    public static String e(LinkedHashMap<String, String> map, int index) {
        int i2 = 0;
        for (String str : map.keySet()) {
            if (i2 == index) {
                return str.toString();
            }
            i2++;
        }
        return null;
    }

    public static int f(Context context, String url) {
        if (JCVideoPlayer.f10684f) {
            return context.getSharedPreferences("JCVD_PROGRESS", 0).getInt(url, 0);
        }
        return 0;
    }

    public static String g(LinkedHashMap<String, String> map, int index) {
        int i2 = 0;
        for (String str : map.keySet()) {
            if (i2 == index) {
                return map.get(str);
            }
            i2++;
        }
        return null;
    }

    public static boolean h(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void i(Context context, String url, int progress) {
        if (JCVideoPlayer.f10684f) {
            SharedPreferences.Editor edit = context.getSharedPreferences("JCVD_PROGRESS", 0).edit();
            edit.putInt(url, progress);
            edit.apply();
        }
    }

    public static Activity j(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return j(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String k(int timeMs) {
        if (timeMs <= 0 || timeMs >= 86400000) {
            return "00:00";
        }
        int i2 = timeMs / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }
}
