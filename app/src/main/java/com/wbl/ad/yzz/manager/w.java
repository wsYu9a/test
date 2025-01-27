package com.wbl.ad.yzz.manager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a */
    @f.b.a.d
    public static String f32996a = "";

    /* renamed from: b */
    public static int f32997b;

    /* renamed from: c */
    public static boolean f32998c;

    /* renamed from: d */
    public static boolean f32999d;

    /* renamed from: g */
    public static WeakReference<Activity> f33002g;

    /* renamed from: h */
    @f.b.a.d
    public static final w f33003h = new w();

    /* renamed from: e */
    public static Handler f33000e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    public static a f33001f = new a();

    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: com.wbl.ad.yzz.manager.w$a$a */
        public static final class RunnableC0758a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Activity f33004a;

            public RunnableC0758a(Activity activity) {
                this.f33004a = activity;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12644, this, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12643, this, activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12670, this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12669, this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12672, this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12671, this, activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12666, this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12665, this, activity);
        }
    }

    public static final /* synthetic */ Handler d(w wVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12657, null, wVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12660, this, null);
    }

    public final void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12659, this, activity);
    }

    public final void a(Application application) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12622, this, application);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12621, this, Boolean.valueOf(z));
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12624, this, null);
    }

    public final void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12623, this, Boolean.valueOf(z));
    }

    public final Activity c() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12618, this, null);
    }

    public final boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12617, this, null);
    }

    public final String e() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12620, this, null);
    }

    public final boolean f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12619, this, null);
    }

    public final boolean g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12614, this, null);
    }
}
