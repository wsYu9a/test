package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class e {

    /* renamed from: a */
    private final f f18037a = new f();

    /* renamed from: b */
    private final m f18038b = new m(new byte[65025], 0);

    /* renamed from: c */
    private int f18039c = -1;

    /* renamed from: d */
    private int f18040d;

    /* renamed from: e */
    private boolean f18041e;

    e() {
    }

    private int a(int i2) {
        int i3;
        int i4 = 0;
        this.f18040d = 0;
        do {
            int i5 = this.f18040d;
            int i6 = i5 + i2;
            f fVar = this.f18037a;
            if (i6 >= fVar.f18048g) {
                break;
            }
            int[] iArr = fVar.f18051j;
            this.f18040d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public void a() {
        this.f18037a.a();
        this.f18038b.a();
        this.f18039c = -1;
        this.f18041e = false;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        int i2;
        com.opos.exoplayer.core.i.a.b(fVar != null);
        if (this.f18041e) {
            this.f18041e = false;
            this.f18038b.a();
        }
        while (!this.f18041e) {
            if (this.f18039c < 0) {
                if (!this.f18037a.a(fVar, true)) {
                    return false;
                }
                f fVar2 = this.f18037a;
                int i3 = fVar2.f18049h;
                if ((fVar2.f18043b & 1) == 1 && this.f18038b.c() == 0) {
                    i3 += a(0);
                    i2 = this.f18040d + 0;
                } else {
                    i2 = 0;
                }
                fVar.b(i3);
                this.f18039c = i2;
            }
            int a2 = a(this.f18039c);
            int i4 = this.f18039c + this.f18040d;
            if (a2 > 0) {
                if (this.f18038b.e() < this.f18038b.c() + a2) {
                    m mVar = this.f18038b;
                    mVar.f19048a = Arrays.copyOf(mVar.f19048a, mVar.c() + a2);
                }
                m mVar2 = this.f18038b;
                fVar.b(mVar2.f19048a, mVar2.c(), a2);
                m mVar3 = this.f18038b;
                mVar3.b(a2 + mVar3.c());
                this.f18041e = this.f18037a.f18051j[i4 + (-1)] != 255;
            }
            if (i4 == this.f18037a.f18048g) {
                i4 = -1;
            }
            this.f18039c = i4;
        }
        return true;
    }

    public f b() {
        return this.f18037a;
    }

    public m c() {
        return this.f18038b;
    }

    public void d() {
        m mVar = this.f18038b;
        byte[] bArr = mVar.f19048a;
        if (bArr.length == 65025) {
            return;
        }
        mVar.f19048a = Arrays.copyOf(bArr, Math.max(65025, mVar.c()));
    }
}
