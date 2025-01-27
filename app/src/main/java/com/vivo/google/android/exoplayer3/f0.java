package com.vivo.google.android.exoplayer3;

import java.io.EOFException;

/* loaded from: classes4.dex */
public final class f0 implements n0 {
    @Override // com.vivo.google.android.exoplayer3.n0
    public int a(h0 h0Var, int i2, boolean z) {
        int b2 = ((d0) h0Var).b(i2);
        if (b2 != -1) {
            return b2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(long j2, int i2, int i3, int i4, byte[] bArr) {
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(Format format) {
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(n6 n6Var, int i2) {
        n6Var.d(n6Var.f27875b + i2);
    }
}
