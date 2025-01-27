package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class bt {
    private static final Handler aVH = new Handler(Looper.getMainLooper());
    private static long ms = 400;

    public static void a(Runnable runnable, Object obj, long j10) {
        Handler handler = aVH;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j10);
    }

    public static void b(Runnable runnable) {
        aVH.postAtFrontOfQueue(runnable);
    }

    public static void c(Runnable runnable) {
        aVH.removeCallbacks(runnable);
    }

    public static boolean ho(String str) {
        return TextUtils.isEmpty(str) || str.contains(" ") || !URLUtil.isNetworkUrl(str);
    }

    public static void postOnUiThread(Runnable runnable) {
        aVH.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aVH.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j10) {
        aVH.postDelayed(runnable, j10);
    }

    public static String t(Throwable th2) {
        try {
            String stackTraceString = Log.getStackTraceString(th2);
            return TextUtils.isEmpty(stackTraceString) ? th2.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j10) {
        VibrationEffect createOneShot;
        if (vibrator != null) {
            try {
                if (ar.ar(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        createOneShot = VibrationEffect.createOneShot(j10, -1);
                        vibrator.vibrate(createOneShot);
                    } else {
                        vibrator.vibrate(j10);
                    }
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || ar.ar(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, ms);
    }
}
