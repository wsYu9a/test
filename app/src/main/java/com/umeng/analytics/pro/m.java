package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static m f25953a = new m();

    /* renamed from: b */
    private final int f25954b = 3000;

    /* renamed from: c */
    private boolean f25955c = false;

    /* renamed from: d */
    private boolean f25956d = true;

    /* renamed from: e */
    private Handler f25957e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private ArrayList<n> f25958f = new ArrayList<>();

    /* renamed from: g */
    private a f25959g = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f25955c || !m.this.f25956d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f25955c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < m.this.f25958f.size(); i2++) {
                ((n) m.this.f25958f.get(i2)).n();
            }
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f25956d = true;
        a aVar = this.f25959g;
        if (aVar != null) {
            this.f25957e.removeCallbacks(aVar);
            this.f25957e.postDelayed(this.f25959g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f25956d = false;
        this.f25955c = true;
        a aVar = this.f25959g;
        if (aVar != null) {
            this.f25957e.removeCallbacks(aVar);
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

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i2 = 0; i2 < this.f25958f.size(); i2++) {
                if (this.f25958f.get(i2) == nVar) {
                    this.f25958f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f25953a);
        }
    }

    public static m a() {
        return f25953a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f25958f.add(nVar);
        }
    }
}
