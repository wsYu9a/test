package com.vivo.google.android.exoplayer3;

import android.util.Pair;
import com.vivo.google.android.exoplayer3.x2;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class f2 implements j2 {
    public static final byte[] r = {73, 68, 51};

    /* renamed from: a */
    public final boolean f27406a;

    /* renamed from: b */
    public final m6 f27407b = new m6(new byte[7]);

    /* renamed from: c */
    public final n6 f27408c = new n6(Arrays.copyOf(r, 10));

    /* renamed from: d */
    public final String f27409d;

    /* renamed from: e */
    public String f27410e;

    /* renamed from: f */
    public n0 f27411f;

    /* renamed from: g */
    public n0 f27412g;

    /* renamed from: h */
    public int f27413h;

    /* renamed from: i */
    public int f27414i;

    /* renamed from: j */
    public int f27415j;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public n0 p;
    public long q;

    public f2(boolean z, String str) {
        c();
        this.f27406a = z;
        this.f27409d = str;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        c();
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        this.o = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27410e = dVar.b();
        l3 l3Var = (l3) i0Var;
        this.f27411f = l3Var.a(dVar.c(), 1);
        if (!this.f27406a) {
            this.f27412g = new f0();
            return;
        }
        dVar.a();
        n0 a2 = l3Var.a(dVar.c(), 4);
        this.f27412g = a2;
        a2.a(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(n6 n6Var) {
        int i2;
        while (n6Var.a() > 0) {
            int i3 = this.f27413h;
            if (i3 == 0) {
                byte[] bArr = n6Var.f27874a;
                int i4 = n6Var.f27875b;
                int i5 = n6Var.f27876c;
                while (true) {
                    if (i4 >= i5) {
                        n6Var.d(i4);
                        break;
                    }
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    int i8 = this.f27415j;
                    if (i8 != 512 || i7 < 240 || i7 == 255) {
                        int i9 = i7 | i8;
                        if (i9 != 329) {
                            if (i9 == 511) {
                                this.f27415j = 512;
                            } else if (i9 == 836) {
                                i2 = 1024;
                            } else {
                                if (i9 == 1075) {
                                    this.f27413h = 1;
                                    this.f27414i = r.length;
                                    this.n = 0;
                                    this.f27408c.d(0);
                                    n6Var.d(i6);
                                    break;
                                }
                                if (i8 != 256) {
                                    this.f27415j = 256;
                                    i4 = i6 - 1;
                                }
                            }
                            i4 = i6;
                        } else {
                            i2 = 768;
                        }
                        this.f27415j = i2;
                        i4 = i6;
                    } else {
                        this.k = (i7 & 1) == 0;
                        this.f27413h = 2;
                        this.f27414i = 0;
                        n6Var.d(i6);
                    }
                }
            } else if (i3 != 1) {
                if (i3 == 2) {
                    if (a(n6Var, this.f27407b.f27770a, this.k ? 7 : 5)) {
                        this.f27407b.b(0);
                        if (this.l) {
                            this.f27407b.c(10);
                        } else {
                            int a2 = this.f27407b.a(2) + 1;
                            if (a2 != 2) {
                                String str = "Detected audio object type: " + a2 + ", but assuming AAC LC.";
                                a2 = 2;
                            }
                            int a3 = this.f27407b.a(4);
                            this.f27407b.c(1);
                            byte[] bArr2 = {(byte) (((a2 << 3) & 248) | ((a3 >> 1) & 7)), (byte) (((a3 << 7) & 128) | ((this.f27407b.a(3) << 3) & 120))};
                            Pair<Integer, Integer> a4 = f6.a(bArr2);
                            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f27410e, "audio/mp4a-latm", null, -1, -1, ((Integer) a4.second).intValue(), ((Integer) a4.first).intValue(), Collections.singletonList(bArr2), null, 0, this.f27409d);
                            this.m = 1024000000 / createAudioSampleFormat.sampleRate;
                            this.f27411f.a(createAudioSampleFormat);
                            this.l = true;
                        }
                        this.f27407b.c(4);
                        int a5 = (this.f27407b.a(13) - 2) - 5;
                        if (this.k) {
                            a5 -= 2;
                        }
                        n0 n0Var = this.f27411f;
                        long j2 = this.m;
                        this.f27413h = 3;
                        this.f27414i = 0;
                        this.p = n0Var;
                        this.q = j2;
                        this.n = a5;
                    }
                } else if (i3 == 3) {
                    int min = Math.min(n6Var.a(), this.n - this.f27414i);
                    this.p.a(n6Var, min);
                    int i10 = this.f27414i + min;
                    this.f27414i = i10;
                    int i11 = this.n;
                    if (i10 == i11) {
                        this.p.a(this.o, 1, i11, 0, null);
                        this.o += this.q;
                        c();
                    }
                }
            } else if (a(n6Var, this.f27408c.f27874a, 10)) {
                this.f27412g.a(this.f27408c, 10);
                this.f27408c.d(6);
                n0 n0Var2 = this.f27412g;
                int k = this.f27408c.k() + 10;
                this.f27413h = 3;
                this.f27414i = 10;
                this.p = n0Var2;
                this.q = 0L;
                this.n = k;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }

    public final void c() {
        this.f27413h = 0;
        this.f27414i = 0;
        this.f27415j = 256;
    }

    public final boolean a(n6 n6Var, byte[] bArr, int i2) {
        int min = Math.min(n6Var.a(), i2 - this.f27414i);
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, this.f27414i, min);
        n6Var.f27875b += min;
        int i3 = this.f27414i + min;
        this.f27414i = i3;
        return i3 == i2;
    }
}
