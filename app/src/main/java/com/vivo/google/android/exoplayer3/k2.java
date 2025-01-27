package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class k2 implements j2 {
    public static final double[] n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a */
    public String f27560a;

    /* renamed from: b */
    public n0 f27561b;

    /* renamed from: c */
    public boolean f27562c;

    /* renamed from: d */
    public long f27563d;

    /* renamed from: e */
    public final boolean[] f27564e = new boolean[4];

    /* renamed from: f */
    public final a f27565f = new a(128);

    /* renamed from: g */
    public boolean f27566g;

    /* renamed from: h */
    public long f27567h;

    /* renamed from: i */
    public long f27568i;

    /* renamed from: j */
    public boolean f27569j;
    public boolean k;
    public long l;
    public long m;

    public static final class a {

        /* renamed from: a */
        public boolean f27570a;

        /* renamed from: b */
        public int f27571b;

        /* renamed from: c */
        public int f27572c;

        /* renamed from: d */
        public byte[] f27573d;

        public a(int i2) {
            this.f27573d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f27570a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f27573d;
                int length = bArr2.length;
                int i5 = this.f27571b + i4;
                if (length < i5) {
                    this.f27573d = Arrays.copyOf(bArr2, i5 * 2);
                }
                System.arraycopy(bArr, i2, this.f27573d, this.f27571b, i4);
                this.f27571b += i4;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        boolean z2 = j2 != C.TIME_UNSET;
        this.f27569j = z2;
        if (z2) {
            this.f27568i = j2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27560a = dVar.b();
        this.f27561b = ((l3) i0Var).a(dVar.c(), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
    @Override // com.vivo.google.android.exoplayer3.j2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.n6 r26) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.k2.a(com.vivo.google.android.exoplayer3.n6):void");
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        l6.a(this.f27564e);
        a aVar = this.f27565f;
        aVar.f27570a = false;
        aVar.f27571b = 0;
        aVar.f27572c = 0;
        this.f27569j = false;
        this.f27566g = false;
        this.f27567h = 0L;
    }
}
