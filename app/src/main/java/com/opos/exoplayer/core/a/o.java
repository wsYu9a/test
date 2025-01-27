package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
final class o implements d {

    /* renamed from: b */
    private boolean f17638b;

    /* renamed from: c */
    private int f17639c;

    /* renamed from: d */
    private int f17640d;

    /* renamed from: e */
    private int f17641e;

    /* renamed from: f */
    private int f17642f;

    /* renamed from: g */
    private int f17643g;

    /* renamed from: h */
    private ByteBuffer f17644h;

    /* renamed from: i */
    private ByteBuffer f17645i;

    /* renamed from: j */
    private byte[] f17646j;
    private int k;
    private boolean l;

    public o() {
        ByteBuffer byteBuffer = d.f17532a;
        this.f17644h = byteBuffer;
        this.f17645i = byteBuffer;
        this.f17641e = -1;
    }

    public void a(int i2, int i3) {
        this.f17639c = i2;
        this.f17640d = i3;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int min = Math.min(i2, this.f17643g);
        this.f17643g -= min;
        byteBuffer.position(position + min);
        if (this.f17643g > 0) {
            return;
        }
        int i3 = i2 - min;
        int length = (this.k + i3) - this.f17646j.length;
        if (this.f17644h.capacity() < length) {
            this.f17644h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f17644h.clear();
        }
        int a2 = u.a(length, 0, this.k);
        this.f17644h.put(this.f17646j, 0, a2);
        int a3 = u.a(length - a2, 0, i3);
        byteBuffer.limit(byteBuffer.position() + a3);
        this.f17644h.put(byteBuffer);
        byteBuffer.limit(limit);
        int i4 = i3 - a3;
        int i5 = this.k - a2;
        this.k = i5;
        byte[] bArr = this.f17646j;
        System.arraycopy(bArr, a2, bArr, 0, i5);
        byteBuffer.get(this.f17646j, this.k, i4);
        this.k = i4 + this.k;
        this.f17644h.flip();
        this.f17645i = this.f17644h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.f17638b;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i2, int i3, int i4) {
        if (i4 != 2) {
            throw new d.a(i2, i3, i4);
        }
        this.f17641e = i3;
        this.f17642f = i2;
        int i5 = this.f17640d;
        this.f17646j = new byte[i5 * i3 * 2];
        this.k = 0;
        int i6 = this.f17639c;
        this.f17643g = i3 * i6 * 2;
        boolean z = this.f17638b;
        boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
        this.f17638b = z2;
        return z != z2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f17641e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f17642f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.l = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f17645i;
        this.f17645i = d.f17532a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.l && this.f17645i == d.f17532a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f17645i = d.f17532a;
        this.l = false;
        this.f17643g = 0;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f17644h = d.f17532a;
        this.f17641e = -1;
        this.f17642f = -1;
        this.f17646j = null;
    }
}
