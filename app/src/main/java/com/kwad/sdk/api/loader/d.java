package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d Zq;
    private Thread.UncaughtExceptionHandler Zr;
    private int Zs;
    private long Zu;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean Zt = new AtomicBoolean();

    private d(Context context) {
        this.mContext = context;
    }

    public static d an(Context context) {
        if (Zq == null) {
            synchronized (d.class) {
                if (Zq == null) {
                    Zq = new d(context);
                }
            }
        }
        return Zq;
    }

    public final void aS(int i2) {
        this.Zu = System.currentTimeMillis();
        this.Zs = i2;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.Zt.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.Zr = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.Zu + ",mMaxDuration:" + this.Zs + ",mIsCancel:" + this.Zt.get());
            }
            if (!this.Zt.get() && this.Zu > 0 && System.currentTimeMillis() - this.Zu <= this.Zs) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.a("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    t.a(context, g.ZA, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.Zr;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.Zr;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.Zr != null) {
                    this.Zr.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
