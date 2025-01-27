package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public abstract class w3 extends y<c4, d4, a4> implements z3 {
    public w3(String str) {
        super(new c4[2], new d4[2]);
        a(1024);
    }

    public abstract y3 a(byte[] bArr, int i2, boolean z);

    @Override // com.vivo.google.android.exoplayer3.z3
    public void a(long j2) {
    }

    public final void a(d4 d4Var) {
        super.a((w3) d4Var);
    }

    @Override // com.vivo.google.android.exoplayer3.y
    public c4 c() {
        return new c4();
    }

    @Override // com.vivo.google.android.exoplayer3.y
    public d4 d() {
        return new x3(this);
    }
}
