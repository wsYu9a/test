package com.opos.mobad.f.a.a;

/* loaded from: classes4.dex */
public class v extends a {

    /* renamed from: a */
    private String f20641a;

    public v(String str, int i2, long j2) {
        super(str, j2);
        this.f20641a = 3 == i2 ? "sdk_bidding" : "sdk_dsp";
    }

    @Override // com.opos.mobad.f.a.a.a
    protected void a(String str, long j2, String str2, int i2, long j3, String str3) {
        com.opos.mobad.service.i.d.a().a(str, str2, i2, j3, str3, this.f20641a, j2);
    }

    @Override // com.opos.mobad.f.a.a.a
    protected void b(String str, long j2, String str2, int i2, long j3, String str3) {
        com.opos.mobad.service.i.d.a().b(str, str2, i2, j3, str3, this.f20641a, j2);
    }
}
