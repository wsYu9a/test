package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a */
    int f7597a;

    /* renamed from: b */
    b f7598b;

    /* renamed from: c */
    int[] f7599c;

    /* renamed from: i */
    private boolean f7605i;

    /* renamed from: k */
    private f f7607k;

    /* renamed from: j */
    private boolean f7606j = false;

    /* renamed from: l */
    private final c f7608l = new c();

    /* renamed from: d */
    int f7600d = 0;

    /* renamed from: e */
    int f7601e = 1;

    /* renamed from: f */
    int f7602f = 2;

    /* renamed from: g */
    int f7603g = 3;

    /* renamed from: h */
    int f7604h = 4;

    public a() {
        c();
    }

    private int e(int i10) {
        if (this.f7597a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i11 = i10 * 5;
        if (i11 < this.f7599c.length) {
            return i11;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i10 + ").");
    }

    public final void a() {
        if (this.f7606j) {
            this.f7606j = false;
            b bVar = this.f7598b;
            InputStream inputStream = bVar.f7609a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.f7607k = null;
            this.f7598b = null;
            c cVar = this.f7608l;
            cVar.f7612b = 0;
            cVar.f7613c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0223, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i10) {
        return this.f7599c[e(i10) + 4];
    }

    public final String d(int i10) {
        int e10 = e(i10);
        int[] iArr = this.f7599c;
        if (iArr[e10 + 3] != 3) {
            return "";
        }
        return this.f7607k.a(iArr[e10 + 2]);
    }

    private void c() {
        this.f7599c = null;
        this.f7597a = -1;
    }

    public final String a(int i10) {
        int i11 = this.f7599c[e(i10) + 1];
        return i11 == -1 ? "" : this.f7607k.a(i11);
    }

    public final int b(int i10) {
        return this.f7599c[e(i10) + 3];
    }
}
