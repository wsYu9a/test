package com.wbl.ad.yzz.ms.e;

import android.app.Activity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.f.k.b;
import com.wbl.ad.yzz.ms.f.k.e;
import com.wbl.ad.yzz.ms.f.k.g;
import com.wbl.ad.yzz.ms.f.k.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class b<Loader extends com.wbl.ad.yzz.ms.f.k.b, LoaderListener extends e> implements g<Loader> {

    /* renamed from: a */
    public Activity f33129a;

    /* renamed from: b */
    public g f33130b;

    /* renamed from: c */
    public com.wbl.ad.yzz.ms.f.i.b f33131c;

    /* renamed from: d */
    public Loader f33132d;

    /* renamed from: e */
    public LoaderListener f33133e;

    public b(Loader loader, com.wbl.ad.yzz.ms.f.i.b bVar) {
        new HashMap();
        this.f33132d = loader;
        this.f33131c = bVar;
        this.f33129a = loader.getActivity();
        this.f33133e = (LoaderListener) i.a(this, loader.g());
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g
    public void a(g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12039, this, gVar);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g
    public void a(Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12034, this, map);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g
    public Loader b() {
        return (Loader) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12033, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.f
    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12036, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g
    public com.wbl.ad.yzz.ms.f.i.b d() {
        return (com.wbl.ad.yzz.ms.f.i.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12035, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g, com.wbl.ad.yzz.ms.f.k.f
    public Activity getActivity() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12062, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.g
    public g next() {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12061, this, null);
    }
}
