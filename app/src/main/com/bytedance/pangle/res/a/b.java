package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c */
    g f7760c;

    /* renamed from: i */
    private final h f7766i;

    /* renamed from: j */
    private final byte[] f7767j;

    /* renamed from: l */
    private int[] f7769l;

    /* renamed from: n */
    private boolean f7771n;

    /* renamed from: o */
    private int f7772o;

    /* renamed from: p */
    private int[] f7773p;

    /* renamed from: q */
    private int f7774q;

    /* renamed from: a */
    HashMap<Integer, Integer> f7758a = new HashMap<>();

    /* renamed from: b */
    boolean f7759b = false;

    /* renamed from: k */
    private boolean f7768k = false;

    /* renamed from: m */
    private final a f7770m = new a();

    /* renamed from: d */
    int f7761d = 0;

    /* renamed from: e */
    int f7762e = 1;

    /* renamed from: f */
    int f7763f = 2;

    /* renamed from: g */
    int f7764g = 3;

    /* renamed from: h */
    int f7765h = 4;

    public static final class a {

        /* renamed from: a */
        int[] f7775a = new int[32];

        /* renamed from: b */
        int f7776b;

        /* renamed from: c */
        int f7777c;

        public final void a() {
            b();
            int i10 = this.f7776b;
            int[] iArr = this.f7775a;
            iArr[i10] = 0;
            iArr[i10 + 1] = 0;
            this.f7776b = i10 + 2;
            this.f7777c++;
        }

        public final void b() {
            int[] iArr = this.f7775a;
            int length = iArr.length;
            int i10 = this.f7776b;
            int i11 = length - i10;
            if (i11 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i11) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            this.f7775a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f7766i = hVar;
        this.f7767j = bArr;
        c();
    }

    private void c() {
        this.f7772o = -1;
        this.f7773p = null;
        this.f7774q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0290, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r8 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r8 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.f7768k) {
            this.f7768k = false;
            this.f7760c = null;
            this.f7769l = null;
            a aVar = this.f7770m;
            aVar.f7776b = 0;
            aVar.f7777c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f7760c == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            d();
            return this.f7772o;
        } catch (IOException e10) {
            a();
            throw e10;
        }
    }
}
