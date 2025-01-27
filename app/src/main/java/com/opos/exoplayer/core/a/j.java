package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes4.dex */
public final class j implements d {

    /* renamed from: b */
    private int f17598b;

    /* renamed from: e */
    private n f17601e;

    /* renamed from: i */
    private ByteBuffer f17605i;

    /* renamed from: j */
    private ShortBuffer f17606j;
    private ByteBuffer k;
    private long l;
    private long m;
    private boolean n;

    /* renamed from: f */
    private float f17602f = 1.0f;

    /* renamed from: g */
    private float f17603g = 1.0f;

    /* renamed from: c */
    private int f17599c = -1;

    /* renamed from: d */
    private int f17600d = -1;

    /* renamed from: h */
    private int f17604h = -1;

    public j() {
        ByteBuffer byteBuffer = d.f17532a;
        this.f17605i = byteBuffer;
        this.f17606j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.f17598b = -1;
    }

    public float a(float f2) {
        float a2 = u.a(f2, 0.1f, 8.0f);
        this.f17602f = a2;
        return a2;
    }

    public long a(long j2) {
        long j3 = this.m;
        if (j3 >= 1024) {
            int i2 = this.f17604h;
            int i3 = this.f17600d;
            long j4 = this.l;
            return i2 == i3 ? u.d(j2, j4, j3) : u.d(j2, i2 * j4, i3 * j3);
        }
        double d2 = this.f17602f;
        double d3 = j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (long) (d2 * d3);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.l += remaining;
            this.f17601e.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b2 = this.f17601e.b() * this.f17599c * 2;
        if (b2 > 0) {
            if (this.f17605i.capacity() < b2) {
                ByteBuffer order = ByteBuffer.allocateDirect(b2).order(ByteOrder.nativeOrder());
                this.f17605i = order;
                this.f17606j = order.asShortBuffer();
            } else {
                this.f17605i.clear();
                this.f17606j.clear();
            }
            this.f17601e.b(this.f17606j);
            this.m += b2;
            this.f17605i.limit(b2);
            this.k = this.f17605i;
        }
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return Math.abs(this.f17602f - 1.0f) >= 0.01f || Math.abs(this.f17603g - 1.0f) >= 0.01f || this.f17604h != this.f17600d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i2, int i3, int i4) {
        if (i4 != 2) {
            throw new d.a(i2, i3, i4);
        }
        int i5 = this.f17598b;
        if (i5 == -1) {
            i5 = i2;
        }
        if (this.f17600d == i2 && this.f17599c == i3 && this.f17604h == i5) {
            return false;
        }
        this.f17600d = i2;
        this.f17599c = i3;
        this.f17604h = i5;
        return true;
    }

    public float b(float f2) {
        this.f17603g = u.a(f2, 0.1f, 8.0f);
        return f2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f17599c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f17604h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.f17601e.a();
        this.n = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.k;
        this.k = d.f17532a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        n nVar;
        return this.n && ((nVar = this.f17601e) == null || nVar.b() == 0);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f17601e = new n(this.f17600d, this.f17599c, this.f17602f, this.f17603g, this.f17604h);
        this.k = d.f17532a;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        this.f17601e = null;
        ByteBuffer byteBuffer = d.f17532a;
        this.f17605i = byteBuffer;
        this.f17606j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.f17599c = -1;
        this.f17600d = -1;
        this.f17604h = -1;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
        this.f17598b = -1;
    }
}
