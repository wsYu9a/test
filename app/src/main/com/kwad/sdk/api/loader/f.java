package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f apN;
    private Thread.UncaughtExceptionHandler apO;
    private int apP;
    private long apR;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean apQ = new AtomicBoolean();

    private f(Context context) {
        this.mContext = context;
    }

    public static f aP(Context context) {
        if (apN == null) {
            synchronized (f.class) {
                try {
                    if (apN == null) {
                        apN = new f(context);
                    }
                } finally {
                }
            }
        }
        return apN;
    }

    public final void bX(int i10) {
        this.apR = System.currentTimeMillis();
        this.apP = i10;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.apQ.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.apO = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.apR + ",mMaxDuration:" + this.apP + ",mIsCancel:" + this.apQ.get());
            }
            if (!this.apQ.get() && this.apR > 0 && System.currentTimeMillis() - this.apR <= this.apP) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.f("filterStack", th2);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    b.a(context, i.apX, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.apO;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Throwable th3) {
            try {
                th3.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.apO;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th2);
                }
            } catch (Throwable th4) {
                if (this.apO != null) {
                    this.apO.uncaughtException(thread, th2);
                }
                throw th4;
            }
        }
    }
}
