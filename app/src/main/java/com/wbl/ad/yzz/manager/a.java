package com.wbl.ad.yzz.manager;

import android.app.Activity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.d0;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import java.util.List;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public static int f32873a;

    /* renamed from: b */
    public static com.wbl.ad.yzz.network.c.a f32874b;

    /* renamed from: c */
    public static List<? extends com.wbl.ad.yzz.bean.b> f32875c;

    /* renamed from: d */
    public static String f32876d;

    /* renamed from: e */
    @f.b.a.d
    public static final a f32877e = new a();

    /* renamed from: com.wbl.ad.yzz.manager.a$a */
    public static final class C0753a implements d.b0<d0> {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32878a;

        /* renamed from: b */
        public final /* synthetic */ Activity f32879b;

        public C0753a(com.wbl.ad.yzz.innerconfig.d.d dVar, Activity activity) {
            this.f32878a = dVar;
            this.f32879b = activity;
        }

        public void a(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13273, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13276, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13275, this, str, d0Var);
        }
    }

    public static final class b implements a.InterfaceC0770a {
        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13270, this, Integer.valueOf(i2), str);
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13269, this, list);
        }
    }

    public static final class c implements d.b0<com.wbl.ad.yzz.network.b.b.k> {
        public void a(String str, com.wbl.ad.yzz.network.b.b.k kVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13272, this, str, kVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13271, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.k kVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13266, this, str, kVar);
        }
    }

    public final List<com.wbl.ad.yzz.bean.b> a() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13268, this, null);
    }

    public final void a(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13267, this, activity, dVar);
    }

    public final void a(Activity activity, String str, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12334, this, activity, str, dVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12333, this, dVar);
    }

    public final void a(List<com.wbl.ad.yzz.network.b.b.d> list, com.wbl.ad.yzz.innerconfig.d.d dVar, Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12336, this, list, dVar, activity);
    }

    public final void b(List<com.wbl.ad.yzz.network.b.b.d> list, com.wbl.ad.yzz.innerconfig.d.d dVar, Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12335, this, list, dVar, activity);
    }
}
