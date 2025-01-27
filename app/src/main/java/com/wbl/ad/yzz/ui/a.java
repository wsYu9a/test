package com.wbl.ad.yzz.ui;

import android.app.Activity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.innerconfig.d.j;
import com.wbl.ad.yzz.ui.f.f;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public abstract class a implements d {

    /* renamed from: a */
    public WeakReference<ADActivity> f33955a;

    /* renamed from: b */
    public com.wbl.ad.yzz.d.b.d.b<com.wbl.ad.yzz.d.d.a, com.wbl.ad.yzz.d.a.a> f33956b;

    /* renamed from: c */
    public com.wbl.ad.yzz.ui.f.d f33957c = new com.wbl.ad.yzz.ui.f.d();

    /* renamed from: d */
    public final j f33958d = new j();

    /* renamed from: e */
    public final f f33959e = new f();

    public static boolean a(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10199, null, Integer.valueOf(i2));
    }

    public static boolean b(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10194, null, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10193, this, activity);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a(com.wbl.ad.yzz.d.b.d.b<com.wbl.ad.yzz.d.d.a, com.wbl.ad.yzz.d.a.a> bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10196, this, bVar);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a(ADActivity aDActivity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10195, this, aDActivity);
    }

    public ADActivity getActivity() {
        return (ADActivity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9262, this, null);
    }
}
