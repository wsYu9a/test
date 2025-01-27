package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c */
    g f6253c;

    /* renamed from: i */
    private final h f6259i;

    /* renamed from: j */
    private final byte[] f6260j;
    private int[] l;
    private boolean n;
    private int o;
    private int[] p;
    private int q;

    /* renamed from: a */
    HashMap<Integer, Integer> f6251a = new HashMap<>();

    /* renamed from: b */
    boolean f6252b = false;
    private boolean k = false;
    private final a m = new a();

    /* renamed from: d */
    int f6254d = 0;

    /* renamed from: e */
    int f6255e = 1;

    /* renamed from: f */
    int f6256f = 2;

    /* renamed from: g */
    int f6257g = 3;

    /* renamed from: h */
    int f6258h = 4;

    static final class a {

        /* renamed from: a */
        int[] f6261a = new int[32];

        /* renamed from: b */
        int f6262b;

        /* renamed from: c */
        int f6263c;

        public final void a() {
            b();
            int i2 = this.f6262b;
            int[] iArr = this.f6261a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f6262b = i2 + 2;
            this.f6263c++;
        }

        final void b() {
            int[] iArr = this.f6261a;
            int length = iArr.length;
            int i2 = this.f6262b;
            int i3 = length - i2;
            if (i3 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f6261a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f6259i = hVar;
        this.f6260j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0297, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            this.f6253c = null;
            this.l = null;
            a aVar = this.m;
            aVar.f6262b = 0;
            aVar.f6263c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f6253c == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            d();
            return this.o;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }
}
