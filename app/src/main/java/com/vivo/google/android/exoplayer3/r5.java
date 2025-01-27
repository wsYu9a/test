package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class r5 implements k5 {

    /* renamed from: a */
    public final boolean f28016a;

    /* renamed from: b */
    public final int f28017b;

    /* renamed from: c */
    public final byte[] f28018c;

    /* renamed from: d */
    public final j5[] f28019d;

    /* renamed from: e */
    public int f28020e;

    /* renamed from: f */
    public int f28021f;

    /* renamed from: g */
    public int f28022g;

    /* renamed from: h */
    public j5[] f28023h;

    public r5(boolean z, int i2) {
        this(z, i2, 0);
    }

    public r5(boolean z, int i2, int i3) {
        g1.a(i2 > 0);
        g1.a(i3 >= 0);
        this.f28016a = z;
        this.f28017b = i2;
        this.f28022g = i3;
        this.f28023h = new j5[i3 + 100];
        if (i3 > 0) {
            this.f28018c = new byte[i3 * i2];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f28023h[i4] = new j5(this.f28018c, i4 * i2);
            }
        } else {
            this.f28018c = null;
        }
        this.f28019d = new j5[1];
    }

    public synchronized j5 a() {
        j5 j5Var;
        this.f28021f++;
        int i2 = this.f28022g;
        if (i2 > 0) {
            j5[] j5VarArr = this.f28023h;
            int i3 = i2 - 1;
            this.f28022g = i3;
            j5Var = j5VarArr[i3];
            j5VarArr[i3] = null;
        } else {
            j5Var = new j5(new byte[this.f28017b], 0);
        }
        return j5Var;
    }

    public synchronized void a(int i2) {
        boolean z = i2 < this.f28020e;
        this.f28020e = i2;
        if (z) {
            e();
        }
    }

    public synchronized void a(j5 j5Var) {
        j5[] j5VarArr = this.f28019d;
        j5VarArr[0] = j5Var;
        a(j5VarArr);
    }

    public synchronized void a(j5[] j5VarArr) {
        boolean z;
        int i2 = this.f28022g;
        int length = j5VarArr.length + i2;
        j5[] j5VarArr2 = this.f28023h;
        if (length >= j5VarArr2.length) {
            this.f28023h = (j5[]) Arrays.copyOf(j5VarArr2, Math.max(j5VarArr2.length * 2, i2 + j5VarArr.length));
        }
        for (j5 j5Var : j5VarArr) {
            byte[] bArr = j5Var.f27544a;
            if (bArr != this.f28018c && bArr.length != this.f28017b) {
                z = false;
                g1.a(z);
                j5[] j5VarArr3 = this.f28023h;
                int i3 = this.f28022g;
                this.f28022g = i3 + 1;
                j5VarArr3[i3] = j5Var;
            }
            z = true;
            g1.a(z);
            j5[] j5VarArr32 = this.f28023h;
            int i32 = this.f28022g;
            this.f28022g = i32 + 1;
            j5VarArr32[i32] = j5Var;
        }
        this.f28021f -= j5VarArr.length;
        notifyAll();
    }

    public int b() {
        return this.f28017b;
    }

    public synchronized int c() {
        return this.f28021f * this.f28017b;
    }

    public synchronized void d() {
        if (this.f28016a) {
            a(0);
        }
    }

    public synchronized void e() {
        int i2 = 0;
        int max = Math.max(0, Util.ceilDivide(this.f28020e, this.f28017b) - this.f28021f);
        int i3 = this.f28022g;
        if (max >= i3) {
            return;
        }
        if (this.f28018c != null) {
            int i4 = i3 - 1;
            while (i2 <= i4) {
                j5[] j5VarArr = this.f28023h;
                j5 j5Var = j5VarArr[i2];
                byte[] bArr = j5Var.f27544a;
                byte[] bArr2 = this.f28018c;
                if (bArr == bArr2) {
                    i2++;
                } else {
                    j5 j5Var2 = j5VarArr[i4];
                    if (j5Var2.f27544a != bArr2) {
                        i4--;
                    } else {
                        j5VarArr[i2] = j5Var2;
                        j5VarArr[i4] = j5Var;
                        i4--;
                        i2++;
                    }
                }
            }
            max = Math.max(max, i2);
            if (max >= this.f28022g) {
                return;
            }
        }
        Arrays.fill(this.f28023h, max, this.f28022g, (Object) null);
        this.f28022g = max;
    }
}
