package com.vivo.ad;

import android.content.Context;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.x0;
import java.lang.Thread;

/* loaded from: classes4.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static volatile CrashHandler sInstance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    public static CrashHandler getInstance() {
        if (sInstance == null) {
            synchronized (CrashHandler.class) {
                if (sInstance == null) {
                    sInstance = new CrashHandler();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        this.mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.mContext = context.getApplicationContext();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            k0.a(th);
            x0.c(TAG, "error info = " + th.toString());
        } catch (Exception e2) {
            x0.b(TAG, "upload failed " + e2);
        }
        th.printStackTrace();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            x0.a(TAG, "if system don't kill crash process");
        }
    }
}
