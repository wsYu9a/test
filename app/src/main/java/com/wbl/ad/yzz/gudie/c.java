package com.wbl.ad.yzz.gudie;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.w;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a */
    public boolean f32535a;

    /* renamed from: b */
    public List<com.wbl.ad.yzz.network.b.b.d> f32536b = new ArrayList();

    /* renamed from: c */
    public final int f32537c = 4;

    public interface a {
        void a(int i2, @f.b.a.d String str);

        void a(@f.b.a.d com.wbl.ad.yzz.adapter.d.b bVar);
    }

    public static final class b implements a.InterfaceC0770a {

        /* renamed from: a */
        public final /* synthetic */ a f32538a;

        public b(a aVar) {
            this.f32538a = aVar;
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13325, this, Integer.valueOf(i2), str);
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13328, this, list);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gudie.c$c */
    public static final class C0737c implements d.b0<w> {
        public C0737c() {
        }

        public void a(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13327, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13322, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13321, this, str, wVar);
        }
    }

    public static final /* synthetic */ List a(c cVar) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13324, null, cVar);
    }

    public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13318, this, context, dVar, aVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13317, this, dVar);
    }

    public final boolean a(k kVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13320, this, kVar);
    }

    public final void b(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13319, this, dVar);
    }

    public final boolean b(k kVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13314, this, kVar);
    }
}
