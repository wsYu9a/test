package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class k implements d {

    /* renamed from: b */
    private int f17607b;

    /* renamed from: c */
    private int f17608c;

    /* renamed from: d */
    private int[] f17609d;

    /* renamed from: e */
    private boolean f17610e;

    /* renamed from: f */
    private int[] f17611f;

    /* renamed from: g */
    private ByteBuffer f17612g;

    /* renamed from: h */
    private ByteBuffer f17613h;

    /* renamed from: i */
    private boolean f17614i;

    public k() {
        ByteBuffer byteBuffer = d.f17532a;
        this.f17612g = byteBuffer;
        this.f17613h = byteBuffer;
        this.f17607b = -1;
        this.f17608c = -1;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f17607b * 2)) * this.f17611f.length * 2;
        if (this.f17612g.capacity() < length) {
            this.f17612g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f17612g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f17611f) {
                this.f17612g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f17607b * 2;
        }
        byteBuffer.position(limit);
        this.f17612g.flip();
        this.f17613h = this.f17612g;
    }

    public void a(int[] iArr) {
        this.f17609d = iArr;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.f17610e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i2, int i3, int i4) {
        boolean z = !Arrays.equals(this.f17609d, this.f17611f);
        int[] iArr = this.f17609d;
        this.f17611f = iArr;
        if (iArr == null) {
            this.f17610e = false;
            return z;
        }
        if (i4 != 2) {
            throw new d.a(i2, i3, i4);
        }
        if (!z && this.f17608c == i2 && this.f17607b == i3) {
            return false;
        }
        this.f17608c = i2;
        this.f17607b = i3;
        this.f17610e = i3 != iArr.length;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.f17611f;
            if (i5 >= iArr2.length) {
                return true;
            }
            int i6 = iArr2[i5];
            if (i6 >= i3) {
                throw new d.a(i2, i3, i4);
            }
            this.f17610e = (i6 != i5) | this.f17610e;
            i5++;
        }
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        int[] iArr = this.f17611f;
        return iArr == null ? this.f17607b : iArr.length;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f17608c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.f17614i = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f17613h;
        this.f17613h = d.f17532a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.f17614i && this.f17613h == d.f17532a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f17613h = d.f17532a;
        this.f17614i = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f17612g = d.f17532a;
        this.f17607b = -1;
        this.f17608c = -1;
        this.f17611f = null;
        this.f17610e = false;
    }
}
