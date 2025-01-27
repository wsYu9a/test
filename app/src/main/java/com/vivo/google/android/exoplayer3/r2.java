package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.vivo.google.android.exoplayer3.m0;

/* loaded from: classes4.dex */
public final class r2 implements g0 {

    /* renamed from: a */
    public final u6 f27988a;

    /* renamed from: d */
    public boolean f27991d;

    /* renamed from: e */
    public boolean f27992e;

    /* renamed from: f */
    public boolean f27993f;

    /* renamed from: g */
    public i0 f27994g;

    /* renamed from: c */
    public final n6 f27990c = new n6(4096);

    /* renamed from: b */
    public final SparseArray<a> f27989b = new SparseArray<>();

    public static final class a {

        /* renamed from: a */
        public final j2 f27995a;

        /* renamed from: b */
        public final u6 f27996b;

        /* renamed from: c */
        public final m6 f27997c = new m6(new byte[64]);

        /* renamed from: d */
        public boolean f27998d;

        /* renamed from: e */
        public boolean f27999e;

        /* renamed from: f */
        public boolean f28000f;

        /* renamed from: g */
        public int f28001g;

        /* renamed from: h */
        public long f28002h;

        public a(j2 j2Var, u6 u6Var) {
            this.f27995a = j2Var;
            this.f27996b = u6Var;
        }
    }

    public r2(u6 u6Var) {
        this.f27988a = u6Var;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.f27994g = i0Var;
        l3 l3Var = (l3) i0Var;
        l3Var.q = new m0.a(C.TIME_UNSET);
        l3Var.n.post(l3Var.l);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r14, com.vivo.google.android.exoplayer3.l0 r15) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.r2.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27988a.f28141c = C.TIME_UNSET;
        for (int i2 = 0; i2 < this.f27989b.size(); i2++) {
            a valueAt = this.f27989b.valueAt(i2);
            valueAt.f28000f = false;
            valueAt.f27995a.a();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        byte[] bArr = new byte[14];
        d0 d0Var = (d0) h0Var;
        d0Var.a(bArr, 0, 14, false);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        d0Var.a(bArr[13] & 7, false);
        d0Var.a(bArr, 0, 3, false);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }
}
