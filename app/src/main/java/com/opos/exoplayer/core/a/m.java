package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class m implements d {

    /* renamed from: b */
    private int f17622b = -1;

    /* renamed from: c */
    private int f17623c = -1;

    /* renamed from: d */
    private int f17624d = 0;

    /* renamed from: e */
    private ByteBuffer f17625e;

    /* renamed from: f */
    private ByteBuffer f17626f;

    /* renamed from: g */
    private boolean f17627g;

    public m() {
        ByteBuffer byteBuffer = d.f17532a;
        this.f17625e = byteBuffer;
        this.f17626f = byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.opos.exoplayer.core.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.f17624d
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L20
            if (r3 == r6) goto L21
            if (r3 != r4) goto L1a
            int r2 = r2 / 2
            goto L23
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L20:
            int r2 = r2 / r6
        L21:
            int r2 = r2 * 2
        L23:
            java.nio.ByteBuffer r3 = r7.f17625e
            int r3 = r3.capacity()
            if (r3 >= r2) goto L3a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.f17625e = r2
            goto L3f
        L3a:
            java.nio.ByteBuffer r2 = r7.f17625e
            r2.clear()
        L3f:
            int r2 = r7.f17624d
            if (r2 == r5) goto L81
            if (r2 == r6) goto L68
            if (r2 != r4) goto L62
        L47:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f17625e
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f17625e
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L47
        L62:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L68:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f17625e
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f17625e
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L68
        L81:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f17625e
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f17625e
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L81
        L9c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.f17625e
            r8.flip()
            java.nio.ByteBuffer r8 = r7.f17625e
            r7.f17626f = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.m.a(java.nio.ByteBuffer):void");
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        int i2 = this.f17624d;
        return (i2 == 0 || i2 == 2) ? false : true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i2, int i3, int i4) {
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            throw new d.a(i2, i3, i4);
        }
        if (this.f17622b == i2 && this.f17623c == i3 && this.f17624d == i4) {
            return false;
        }
        this.f17622b = i2;
        this.f17623c = i3;
        this.f17624d = i4;
        if (i4 == 2) {
            this.f17625e = d.f17532a;
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f17623c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f17622b;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.f17627g = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f17626f;
        this.f17626f = d.f17532a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.f17627g && this.f17626f == d.f17532a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f17626f = d.f17532a;
        this.f17627g = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f17625e = d.f17532a;
        this.f17622b = -1;
        this.f17623c = -1;
        this.f17624d = 0;
    }
}
