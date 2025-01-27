package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;

/* loaded from: classes4.dex */
public class b implements b.a {

    /* renamed from: a */
    private n f20563a;

    /* renamed from: b */
    private int f20564b;

    public b(int i2, n nVar) {
        this.f20564b = i2;
        this.f20563a = nVar;
    }

    @Override // com.opos.mobad.ad.b.a
    public void a() {
        this.f20563a.d(this.f20564b);
    }

    @Override // com.opos.mobad.ad.b.a
    public void a(int i2, String str) {
        com.opos.cmn.an.f.a.b("AdDelegateListener", "onChannelFailed =" + this.f20564b + ",code=" + i2 + ",msg=" + str);
        this.f20563a.a(this.f20564b, i2, str);
    }

    @Override // com.opos.mobad.ad.b.a
    public void b() {
        this.f20563a.e(this.f20564b);
    }
}
