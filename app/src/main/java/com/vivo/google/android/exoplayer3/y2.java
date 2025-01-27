package com.vivo.google.android.exoplayer3;

import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class y2 implements g0, m0 {

    /* renamed from: a */
    public i0 f28295a;

    /* renamed from: b */
    public n0 f28296b;

    /* renamed from: c */
    public z2 f28297c;

    /* renamed from: d */
    public int f28298d;

    /* renamed from: e */
    public int f28299e;

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        z2 z2Var = this.f28297c;
        long j3 = (j2 * z2Var.f28310c) / C.MICROS_PER_SECOND;
        long j4 = z2Var.f28311d;
        return Math.min((j3 / j4) * j4, z2Var.f28315h - j4) + z2Var.f28314g;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f28299e = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.f28295a = i0Var;
        l3 l3Var = (l3) i0Var;
        this.f28296b = l3Var.a(0, 1);
        this.f28297c = null;
        l3Var.f();
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        return g1.a(h0Var) != null;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return ((this.f28297c.f28315h / r0.f28311d) * C.MICROS_PER_SECOND) / r0.f28309b;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public int a(h0 h0Var, l0 l0Var) {
        if (this.f28297c == null) {
            z2 a2 = g1.a(h0Var);
            this.f28297c = a2;
            if (a2 == null) {
                throw new f("Unsupported or unrecognized wav header.");
            }
            int i2 = a2.f28309b;
            int i3 = a2.f28312e * i2;
            int i4 = a2.f28308a;
            this.f28296b.a(Format.createAudioSampleFormat(null, "audio/raw", null, i3 * i4, 32768, i4, i2, a2.f28313f, null, null, 0, null));
            this.f28298d = this.f28297c.f28311d;
        }
        z2 z2Var = this.f28297c;
        if (!((z2Var.f28314g == 0 || z2Var.f28315h == 0) ? false : true)) {
            h0Var.getClass();
            z2Var.getClass();
            d0 d0Var = (d0) h0Var;
            d0Var.f27270e = 0;
            n6 n6Var = new n6(8);
            while (true) {
                a3 a3 = a3.a(h0Var, n6Var);
                if (a3.f27134a == Util.getIntegerCodeForString(MiConfigSingleton.t0)) {
                    d0Var.c(8);
                    long j2 = d0Var.f27268c;
                    long j3 = a3.f27135b;
                    z2Var.f28314g = j2;
                    z2Var.f28315h = j3;
                    l3 l3Var = (l3) this.f28295a;
                    l3Var.q = this;
                    l3Var.n.post(l3Var.l);
                    break;
                }
                String str = "Ignoring unknown WAV chunk: " + a3.f27134a;
                long j4 = a3.f27135b + 8;
                if (a3.f27134a == Util.getIntegerCodeForString("RIFF")) {
                    j4 = 12;
                }
                if (j4 > 2147483647L) {
                    throw new f("Chunk is too large (~2GB+) to skip; id: " + a3.f27134a);
                }
                d0Var.c((int) j4);
            }
        }
        int a4 = this.f28296b.a(h0Var, 32768 - this.f28299e, true);
        if (a4 != -1) {
            this.f28299e += a4;
        }
        int i5 = this.f28299e;
        int i6 = this.f28298d;
        int i7 = i5 / i6;
        if (i7 > 0) {
            long j5 = ((((d0) h0Var).f27268c - i5) * C.MICROS_PER_SECOND) / this.f28297c.f28310c;
            int i8 = i7 * i6;
            int i9 = i5 - i8;
            this.f28299e = i9;
            this.f28296b.a(j5, 1, i8, i9, null);
        }
        return a4 == -1 ? -1 : 0;
    }
}
