package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class i2 implements j2 {

    /* renamed from: a */
    public final List<x2.a> f27502a;

    /* renamed from: b */
    public final n0[] f27503b;

    /* renamed from: c */
    public boolean f27504c;

    /* renamed from: d */
    public int f27505d;

    /* renamed from: e */
    public int f27506e;

    /* renamed from: f */
    public long f27507f;

    public i2(List<x2.a> list) {
        this.f27502a = list;
        this.f27503b = new n0[list.size()];
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        this.f27504c = false;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        if (z) {
            this.f27504c = true;
            this.f27507f = j2;
            this.f27506e = 0;
            this.f27505d = 2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        for (int i2 = 0; i2 < this.f27503b.length; i2++) {
            x2.a aVar = this.f27502a.get(i2);
            dVar.a();
            e0 e0Var = (e0) ((l3) i0Var).a(dVar.c(), 3);
            e0Var.a(Format.createImageSampleFormat(dVar.b(), "application/dvbsubs", null, -1, Collections.singletonList(aVar.f28263b), aVar.f28262a, null));
            this.f27503b[i2] = e0Var;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(n6 n6Var) {
        if (this.f27504c) {
            if (this.f27505d != 2 || a(n6Var, 32)) {
                if (this.f27505d != 1 || a(n6Var, 0)) {
                    int i2 = n6Var.f27875b;
                    int a2 = n6Var.a();
                    for (n0 n0Var : this.f27503b) {
                        n6Var.d(i2);
                        n0Var.a(n6Var, a2);
                    }
                    this.f27506e += a2;
                }
            }
        }
    }

    public final boolean a(n6 n6Var, int i2) {
        if (n6Var.a() == 0) {
            return false;
        }
        if (n6Var.l() != i2) {
            this.f27504c = false;
        }
        this.f27505d--;
        return this.f27504c;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
        if (this.f27504c) {
            for (n0 n0Var : this.f27503b) {
                n0Var.a(this.f27507f, 1, this.f27506e, 0, null);
            }
            this.f27504c = false;
        }
    }
}
