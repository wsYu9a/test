package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a */
    int f6095a;

    /* renamed from: b */
    b f6096b;

    /* renamed from: c */
    int[] f6097c;

    /* renamed from: i */
    private boolean f6103i;
    private f k;

    /* renamed from: j */
    private boolean f6104j = false;
    private final c l = new c();

    /* renamed from: d */
    int f6098d = 0;

    /* renamed from: e */
    int f6099e = 1;

    /* renamed from: f */
    int f6100f = 2;

    /* renamed from: g */
    int f6101g = 3;

    /* renamed from: h */
    int f6102h = 4;

    public a() {
        c();
    }

    private int e(int i2) {
        if (this.f6095a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.f6097c.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public final void a() {
        if (this.f6104j) {
            this.f6104j = false;
            b bVar = this.f6096b;
            InputStream inputStream = bVar.f6107a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.k = null;
            this.f6096b = null;
            c cVar = this.l;
            cVar.f6110b = 0;
            cVar.f6111c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0221, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0108, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i2) {
        return this.f6097c[e(i2) + 4];
    }

    public final String d(int i2) {
        int e2 = e(i2);
        int[] iArr = this.f6097c;
        if (iArr[e2 + 3] != 3) {
            return "";
        }
        return this.k.a(iArr[e2 + 2]);
    }

    private void c() {
        this.f6097c = null;
        this.f6095a = -1;
    }

    public final String a(int i2) {
        int i3 = this.f6097c[e(i2) + 1];
        return i3 == -1 ? "" : this.k.a(i3);
    }

    public final int b(int i2) {
        return this.f6097c[e(i2) + 3];
    }
}
