package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class h2 implements j2 {

    /* renamed from: a */
    public final n6 f27469a;

    /* renamed from: b */
    public final String f27470b;

    /* renamed from: c */
    public String f27471c;

    /* renamed from: d */
    public n0 f27472d;

    /* renamed from: e */
    public int f27473e;

    /* renamed from: f */
    public int f27474f;

    /* renamed from: g */
    public int f27475g;

    /* renamed from: h */
    public long f27476h;

    /* renamed from: i */
    public Format f27477i;

    /* renamed from: j */
    public int f27478j;
    public long k;

    public h2(String str) {
        n6 n6Var = new n6(new byte[15]);
        this.f27469a = n6Var;
        byte[] bArr = n6Var.f27874a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f27473e = 0;
        this.f27470b = str;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        this.f27473e = 0;
        this.f27474f = 0;
        this.f27475g = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        this.k = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27471c = dVar.b();
        this.f27472d = ((l3) i0Var).a(dVar.c(), 1);
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(n6 n6Var) {
        while (n6Var.a() > 0) {
            int i2 = this.f27473e;
            boolean z = false;
            if (i2 == 0) {
                while (true) {
                    if (n6Var.a() <= 0) {
                        break;
                    }
                    int i3 = this.f27475g << 8;
                    this.f27475g = i3;
                    int l = i3 | n6Var.l();
                    this.f27475g = l;
                    if (l == 2147385345) {
                        this.f27475g = 0;
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.f27474f = 4;
                    this.f27473e = 1;
                }
            } else if (i2 == 1) {
                byte[] bArr = this.f27469a.f27874a;
                int min = Math.min(n6Var.a(), 15 - this.f27474f);
                System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, this.f27474f, min);
                n6Var.f27875b += min;
                int i4 = this.f27474f + min;
                this.f27474f = i4;
                if (i4 == 15) {
                    byte[] bArr2 = this.f27469a.f27874a;
                    if (this.f27477i == null) {
                        String str = this.f27471c;
                        String str2 = this.f27470b;
                        m6 m6Var = new m6(bArr2, bArr2.length);
                        m6Var.c(60);
                        int i5 = o.f27877a[m6Var.a(6)];
                        int i6 = o.f27878b[m6Var.a(4)];
                        int a2 = m6Var.a(5);
                        int[] iArr = o.f27879c;
                        int i7 = a2 >= iArr.length ? -1 : (iArr[a2] * 1000) / 2;
                        m6Var.c(10);
                        Format createAudioSampleFormat = Format.createAudioSampleFormat(str, "audio/vnd.dts", null, i7, -1, i5 + (m6Var.a(2) > 0 ? 1 : 0), i6, null, null, 0, str2);
                        this.f27477i = createAudioSampleFormat;
                        this.f27472d.a(createAudioSampleFormat);
                    }
                    this.f27478j = (((bArr2[5] & 2) << 12) | ((bArr2[6] & 255) << 4) | ((bArr2[7] & 240) >> 4)) + 1;
                    this.f27476h = (int) (((((((bArr2[5] & 252) >> 2) | ((bArr2[4] & 1) << 6)) + 1) * 32) * C.MICROS_PER_SECOND) / this.f27477i.sampleRate);
                    this.f27469a.d(0);
                    this.f27472d.a(this.f27469a, 15);
                    this.f27473e = 2;
                }
            } else if (i2 == 2) {
                int min2 = Math.min(n6Var.a(), this.f27478j - this.f27474f);
                this.f27472d.a(n6Var, min2);
                int i8 = this.f27474f + min2;
                this.f27474f = i8;
                int i9 = this.f27478j;
                if (i8 == i9) {
                    this.f27472d.a(this.k, 1, i9, 0, null);
                    this.k += this.f27476h;
                    this.f27473e = 0;
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }
}
