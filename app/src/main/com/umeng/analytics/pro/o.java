package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

@TargetApi(14)
/* loaded from: classes4.dex */
public class o implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static o f24070a = new o();

    /* renamed from: b */
    private final int f24071b = 3000;

    /* renamed from: c */
    private boolean f24072c = false;

    /* renamed from: d */
    private boolean f24073d = true;

    /* renamed from: e */
    private Handler f24074e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private ArrayList<p> f24075f = new ArrayList<>();

    /* renamed from: g */
    private a f24076g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!o.this.f24072c || !o.this.f24073d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            o.this.f24072c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i10 = 0; i10 < o.this.f24075f.size(); i10++) {
                ((p) o.this.f24075f.get(i10)).n();
            }
        }
    }

    private o() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f24073d = true;
        a aVar = this.f24076g;
        if (aVar != null) {
            this.f24074e.removeCallbacks(aVar);
            this.f24074e.postDelayed(this.f24076g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f24073d = false;
        this.f24072c = true;
        a aVar = this.f24076g;
        if (aVar != null) {
            this.f24074e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(p pVar) {
        if (pVar != null) {
            for (int i10 = 0; i10 < this.f24075f.size(); i10++) {
                try {
                    if (this.f24075f.get(i10) == pVar) {
                        this.f24075f.remove(i10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f24070a);
        }
    }

    public static o a() {
        return f24070a;
    }

    public synchronized void a(p pVar) {
        if (pVar != null) {
            this.f24075f.add(pVar);
        }
    }
}
