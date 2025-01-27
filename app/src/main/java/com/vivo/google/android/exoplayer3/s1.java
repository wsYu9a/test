package com.vivo.google.android.exoplayer3;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class s1 {

    /* renamed from: a */
    public final t1 f28039a = new t1();

    /* renamed from: b */
    public final n6 f28040b = new n6(new byte[65025], 0);

    /* renamed from: c */
    public int f28041c = -1;

    /* renamed from: d */
    public int f28042d;

    /* renamed from: e */
    public boolean f28043e;

    public final int a(int i2) {
        int i3;
        int i4 = 0;
        this.f28042d = 0;
        do {
            int i5 = this.f28042d;
            int i6 = i2 + i5;
            t1 t1Var = this.f28039a;
            if (i6 >= t1Var.f28088d) {
                break;
            }
            int[] iArr = t1Var.f28091g;
            this.f28042d = i5 + 1;
            i3 = iArr[i6];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public boolean a(h0 h0Var) {
        int i2;
        g1.b(h0Var != null);
        if (this.f28043e) {
            this.f28043e = false;
            this.f28040b.r();
        }
        while (!this.f28043e) {
            if (this.f28041c < 0) {
                if (!this.f28039a.a(h0Var, true)) {
                    return false;
                }
                t1 t1Var = this.f28039a;
                int i3 = t1Var.f28089e;
                if ((t1Var.f28086b & 1) == 1 && this.f28040b.f27876c == 0) {
                    i3 += a(0);
                    i2 = this.f28042d + 0;
                } else {
                    i2 = 0;
                }
                ((d0) h0Var).c(i3);
                this.f28041c = i2;
            }
            int a2 = a(this.f28041c);
            int i4 = this.f28041c + this.f28042d;
            if (a2 > 0) {
                int b2 = this.f28040b.b();
                n6 n6Var = this.f28040b;
                int i5 = n6Var.f27876c + a2;
                if (b2 < i5) {
                    n6Var.f27874a = Arrays.copyOf(n6Var.f27874a, i5);
                }
                n6 n6Var2 = this.f28040b;
                ((d0) h0Var).b(n6Var2.f27874a, n6Var2.f27876c, a2, false);
                n6 n6Var3 = this.f28040b;
                n6Var3.c(n6Var3.f27876c + a2);
                this.f28043e = this.f28039a.f28091g[i4 + (-1)] != 255;
            }
            if (i4 == this.f28039a.f28088d) {
                i4 = -1;
            }
            this.f28041c = i4;
        }
        return true;
    }
}
