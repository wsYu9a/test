package com.wbl.ad.yzz.gudie;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.w;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public boolean f32405a;

    /* renamed from: b */
    public long f32406b;

    /* renamed from: c */
    public final long f32407c = 1800000;

    /* renamed from: d */
    public List<com.wbl.ad.yzz.adapter.d.b> f32408d = new ArrayList();

    /* renamed from: e */
    public com.wbl.ad.yzz.network.c.a f32409e;

    /* renamed from: com.wbl.ad.yzz.gudie.a$a */
    public static final class C0729a implements a.InterfaceC0770a {
        public C0729a() {
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14082, this, Integer.valueOf(i2), str);
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14081, this, list);
        }
    }

    public static final class b implements d.b0<w> {

        /* renamed from: b */
        public final /* synthetic */ Context f32412b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32413c;

        public b(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f32412b = context;
            this.f32413c = dVar;
        }

        public void a(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14084, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14083, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14110, this, str, wVar);
        }
    }

    public static final /* synthetic */ List a(a aVar) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14109, null, aVar);
    }

    public final List<com.wbl.ad.yzz.adapter.d.b> a() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14105, this, null);
    }

    public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, List<com.wbl.ad.yzz.network.b.b.d> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14108, this, context, dVar, list);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14107, this, dVar);
    }

    public final void b(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14102, this, dVar);
    }
}
