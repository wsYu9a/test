package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes4.dex */
public final class s implements k {

    /* renamed from: d */
    public r f28027d;

    /* renamed from: g */
    public ByteBuffer f28030g;

    /* renamed from: h */
    public ShortBuffer f28031h;

    /* renamed from: i */
    public ByteBuffer f28032i;

    /* renamed from: j */
    public long f28033j;
    public long k;
    public boolean l;

    /* renamed from: e */
    public float f28028e = 1.0f;

    /* renamed from: f */
    public float f28029f = 1.0f;

    /* renamed from: b */
    public int f28025b = -1;

    /* renamed from: c */
    public int f28026c = -1;

    public s() {
        ByteBuffer byteBuffer = k.f27548a;
        this.f28030g = byteBuffer;
        this.f28031h = byteBuffer.asShortBuffer();
        this.f28032i = byteBuffer;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f28032i;
        this.f28032i = k.f27548a;
        return byteBuffer;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f28033j += remaining;
            r rVar = this.f28027d;
            rVar.getClass();
            int remaining2 = asShortBuffer.remaining();
            int i2 = rVar.f27977b;
            int i3 = remaining2 / i2;
            rVar.a(i3);
            asShortBuffer.get(rVar.f27983h, rVar.q * rVar.f27977b, ((i2 * i3) * 2) / 2);
            rVar.q += i3;
            rVar.a();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i4 = this.f28027d.r * this.f28025b * 2;
        if (i4 > 0) {
            if (this.f28030g.capacity() < i4) {
                ByteBuffer order = ByteBuffer.allocateDirect(i4).order(ByteOrder.nativeOrder());
                this.f28030g = order;
                this.f28031h = order.asShortBuffer();
            } else {
                this.f28030g.clear();
                this.f28031h.clear();
            }
            r rVar2 = this.f28027d;
            ShortBuffer shortBuffer = this.f28031h;
            rVar2.getClass();
            int min = Math.min(shortBuffer.remaining() / rVar2.f27977b, rVar2.r);
            shortBuffer.put(rVar2.f27985j, 0, rVar2.f27977b * min);
            int i5 = rVar2.r - min;
            rVar2.r = i5;
            short[] sArr = rVar2.f27985j;
            int i6 = rVar2.f27977b;
            System.arraycopy(sArr, min * i6, sArr, 0, i5 * i6);
            this.k += i4;
            this.f28030g.limit(i4);
            this.f28032i = this.f28030g;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean a(int i2, int i3, int i4) {
        if (i4 != 2) {
            throw new k.a(i2, i3, i4);
        }
        if (this.f28026c == i2 && this.f28025b == i3) {
            return false;
        }
        this.f28026c = i2;
        this.f28025b = i3;
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean b() {
        return Math.abs(this.f28028e - 1.0f) >= 0.01f || Math.abs(this.f28029f - 1.0f) >= 0.01f;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public int c() {
        return 2;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void d() {
        int i2;
        r rVar = this.f28027d;
        int i3 = rVar.q;
        float f2 = rVar.o;
        float f3 = rVar.p;
        int i4 = rVar.r + ((int) ((((i3 / (f2 / f3)) + rVar.s) / f3) + 0.5f));
        rVar.a((rVar.f27980e * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = rVar.f27980e * 2;
            int i6 = rVar.f27977b;
            if (i5 >= i2 * i6) {
                break;
            }
            rVar.f27983h[(i6 * i3) + i5] = 0;
            i5++;
        }
        rVar.q += i2;
        rVar.a();
        if (rVar.r > i4) {
            rVar.r = i4;
        }
        rVar.q = 0;
        rVar.t = 0;
        rVar.s = 0;
        this.l = true;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public int e() {
        return this.f28025b;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void f() {
        this.f28027d = null;
        ByteBuffer byteBuffer = k.f27548a;
        this.f28030g = byteBuffer;
        this.f28031h = byteBuffer.asShortBuffer();
        this.f28032i = byteBuffer;
        this.f28025b = -1;
        this.f28026c = -1;
        this.f28033j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void flush() {
        r rVar = new r(this.f28026c, this.f28025b);
        this.f28027d = rVar;
        rVar.o = this.f28028e;
        rVar.p = this.f28029f;
        this.f28032i = k.f27548a;
        this.f28033j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean isEnded() {
        r rVar;
        return this.l && ((rVar = this.f28027d) == null || rVar.r == 0);
    }
}
