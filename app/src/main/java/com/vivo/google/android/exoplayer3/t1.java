package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import java.io.EOFException;

/* loaded from: classes4.dex */
public final class t1 {

    /* renamed from: i */
    public static final int f28084i = Util.getIntegerCodeForString("OggS");

    /* renamed from: a */
    public int f28085a;

    /* renamed from: b */
    public int f28086b;

    /* renamed from: c */
    public long f28087c;

    /* renamed from: d */
    public int f28088d;

    /* renamed from: e */
    public int f28089e;

    /* renamed from: f */
    public int f28090f;

    /* renamed from: g */
    public final int[] f28091g = new int[255];

    /* renamed from: h */
    public final n6 f28092h = new n6(255);

    public void a() {
        this.f28085a = 0;
        this.f28086b = 0;
        this.f28087c = 0L;
        this.f28088d = 0;
        this.f28089e = 0;
        this.f28090f = 0;
    }

    public boolean a(h0 h0Var, boolean z) {
        this.f28092h.r();
        a();
        d0 d0Var = (d0) h0Var;
        long j2 = d0Var.f27267b;
        if (!(j2 == -1 || j2 - (d0Var.f27268c + ((long) d0Var.f27270e)) >= 27) || !d0Var.a(this.f28092h.f27874a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.f28092h.m() != f28084i) {
            if (z) {
                return false;
            }
            throw new f("expected OggS capture pattern at begin of page");
        }
        int l = this.f28092h.l();
        this.f28085a = l;
        if (l != 0) {
            if (z) {
                return false;
            }
            throw new f("unsupported bit stream revision");
        }
        this.f28086b = this.f28092h.l();
        n6 n6Var = this.f28092h;
        byte[] bArr = n6Var.f27874a;
        int i2 = n6Var.f27875b + 1;
        n6Var.f27875b = i2;
        long j3 = bArr[r4] & 255;
        int i3 = i2 + 1;
        n6Var.f27875b = i3;
        long j4 = j3 | ((bArr[i2] & 255) << 8);
        int i4 = i3 + 1;
        n6Var.f27875b = i4;
        long j5 = j4 | ((bArr[i3] & 255) << 16);
        int i5 = i4 + 1;
        n6Var.f27875b = i5;
        long j6 = j5 | ((bArr[i4] & 255) << 24);
        int i6 = i5 + 1;
        n6Var.f27875b = i6;
        long j7 = j6 | ((bArr[i5] & 255) << 32);
        int i7 = i6 + 1;
        n6Var.f27875b = i7;
        long j8 = j7 | ((bArr[i6] & 255) << 40);
        int i8 = i7 + 1;
        n6Var.f27875b = i8;
        n6Var.f27875b = i8 + 1;
        this.f28087c = ((bArr[i8] & 255) << 56) | j8 | ((bArr[i7] & 255) << 48);
        n6Var.f();
        this.f28092h.f();
        this.f28092h.f();
        int l2 = this.f28092h.l();
        this.f28088d = l2;
        this.f28089e = l2 + 27;
        this.f28092h.r();
        d0Var.a(this.f28092h.f27874a, 0, this.f28088d, false);
        for (int i9 = 0; i9 < this.f28088d; i9++) {
            this.f28091g[i9] = this.f28092h.l();
            this.f28090f += this.f28091g[i9];
        }
        return true;
    }
}
