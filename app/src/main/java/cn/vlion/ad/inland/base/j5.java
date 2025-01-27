package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class j5 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f */
    public static volatile j5 f2992f;

    /* renamed from: a */
    public boolean f2993a = false;

    /* renamed from: b */
    public boolean f2994b = false;

    /* renamed from: c */
    public int f2995c = 0;

    /* renamed from: d */
    public long f2996d = 0;

    /* renamed from: e */
    public boolean f2997e = false;

    public final void a() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f2996d;
            int backgroundTickTime = VlionServiceConfigParse.getInstance().getBackgroundTickTime();
            LogVlion.e("VlionLifeCycle onActivityResumed 到前台时间差：diffTime=" + (elapsedRealtime / 1000) + " backgroundTickTime=" + backgroundTickTime);
            if (backgroundTickTime <= 0 || elapsedRealtime / 1000 <= backgroundTickTime || this.f2996d <= 0) {
                return;
            }
            LogVlion.e("VlionLifeCycle onActivityResumed sendFrontBackSdkEvent");
            VlionADEventManager.sendFrontBackSdkEvent();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f2994b = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        try {
            this.f2994b = true;
            LogVlion.e("VlionLifeCycle onActivityResumed  isFromBackToFront=" + this.f2997e);
            if (this.f2997e) {
                this.f2997e = false;
                a();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        try {
            this.f2995c++;
            if (this.f2993a) {
                return;
            }
            this.f2993a = true;
            LogVlion.e("VlionLifeCycle onActivityStarted");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        try {
            this.f2995c--;
            LogVlion.e("VlionLifeCycle onActivityStopped isResume" + this.f2994b + " isToForeground=" + this.f2993a + " count=" + this.f2995c);
            if (this.f2994b || !this.f2993a || this.f2995c > 0) {
                return;
            }
            this.f2993a = false;
            LogVlion.e("VlionLifeCycle 到后台");
            try {
                this.f2997e = true;
                this.f2996d = SystemClock.elapsedRealtime();
                LogVlion.e("VlionLifeCycle 后台时间" + this.f2996d);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
