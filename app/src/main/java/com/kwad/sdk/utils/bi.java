package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.io.Closeable;

/* loaded from: classes2.dex */
public final class bi {
    private static final Handler aBx = new Handler(Looper.getMainLooper());
    private static long ka = 400;

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, ka);
    }

    public static void a(Runnable runnable, Object obj, long j2) {
        Handler handler = aBx;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j2);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || al.al(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void b(Runnable runnable) {
        aBx.removeCallbacks(runnable);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        aBx.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aBx.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j2) {
        aBx.postDelayed(runnable, j2);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j2) {
        if (vibrator != null) {
            try {
                if (al.al(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j2, -1));
                    } else {
                        vibrator.vibrate(j2);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }
}
