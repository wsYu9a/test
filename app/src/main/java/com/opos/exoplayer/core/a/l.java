package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
final class l implements d {

    /* renamed from: b */
    private static final int f17615b = Float.floatToIntBits(Float.NaN);

    /* renamed from: c */
    private int f17616c = -1;

    /* renamed from: d */
    private int f17617d = -1;

    /* renamed from: e */
    private int f17618e = 0;

    /* renamed from: f */
    private ByteBuffer f17619f;

    /* renamed from: g */
    private ByteBuffer f17620g;

    /* renamed from: h */
    private boolean f17621h;

    public l() {
        ByteBuffer byteBuffer = d.f17532a;
        this.f17619f = byteBuffer;
        this.f17620g = byteBuffer;
    }

    private static void a(int i2, ByteBuffer byteBuffer) {
        double d2 = i2;
        Double.isNaN(d2);
        int floatToIntBits = Float.floatToIntBits((float) (d2 * 4.656612875245797E-10d));
        if (floatToIntBits == f17615b) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        com.opos.exoplayer.core.i.a.b(a());
        boolean z = this.f17618e == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (!z) {
            i2 = (i2 / 3) * 4;
        }
        if (this.f17619f.capacity() < i2) {
            this.f17619f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f17619f.clear();
        }
        if (z) {
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), this.f17619f);
                position += 4;
            }
        } else {
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), this.f17619f);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f17619f.flip();
        this.f17620g = this.f17619f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return u.c(this.f17618e);
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i2, int i3, int i4) {
        if (!u.c(i4)) {
            throw new d.a(i2, i3, i4);
        }
        if (this.f17616c == i2 && this.f17617d == i3 && this.f17618e == i4) {
            return false;
        }
        this.f17616c = i2;
        this.f17617d = i3;
        this.f17618e = i4;
        return true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f17617d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 4;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f17616c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.f17621h = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f17620g;
        this.f17620g = d.f17532a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.f17621h && this.f17620g == d.f17532a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f17620g = d.f17532a;
        this.f17621h = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f17619f = d.f17532a;
        this.f17616c = -1;
        this.f17617d = -1;
        this.f17618e = 0;
    }
}
