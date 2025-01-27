package com.wbl.ad.yzz.help.n;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.comm.pi.ACTD;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class k implements ACTD {

    /* renamed from: c */
    public static String f32739c = "GdtWblActivityProxy";

    /* renamed from: a */
    public ACTD f32740a;

    /* renamed from: b */
    public WeakReference<Activity> f32741b;

    public void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12872, this, activity);
    }

    public void a(ACTD actd) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12871, this, actd);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i2, int i3, Intent intent) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12866, this, Integer.valueOf(i2), Integer.valueOf(i3), intent);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12865, this, bundle);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12868, this, null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12867, this, bundle);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12894, this, configuration);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12893, this, null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12896, this, null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12895, this, null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12890, this, null);
    }
}
