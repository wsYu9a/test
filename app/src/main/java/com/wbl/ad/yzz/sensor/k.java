package com.wbl.ad.yzz.sensor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.text.SimpleDateFormat;
import java.util.Locale;

@TargetApi(14)
/* loaded from: classes5.dex */
public class k implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f */
    public static final SimpleDateFormat f33819f = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /* renamed from: a */
    public Integer f33820a = 0;

    /* renamed from: b */
    public final Object f33821b = new Object();

    /* renamed from: c */
    public final SensorsDataMiniAPI f33822c;

    /* renamed from: d */
    public final f f33823d;

    /* renamed from: e */
    public final e f33824e;

    public k(SensorsDataMiniAPI sensorsDataMiniAPI, f fVar, e eVar) {
        this.f33822c = sensorsDataMiniAPI;
        this.f33823d = fVar;
        this.f33824e = eVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10712, this, activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10711, this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10706, this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10705, this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10708, this, activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10707, this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9774, this, activity);
    }
}
