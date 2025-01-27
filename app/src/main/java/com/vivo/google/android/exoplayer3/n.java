package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class n implements k {

    /* renamed from: b */
    public int f27841b;

    /* renamed from: c */
    public int f27842c;

    /* renamed from: d */
    public int[] f27843d;

    /* renamed from: e */
    public boolean f27844e;

    /* renamed from: f */
    public int[] f27845f;

    /* renamed from: g */
    public ByteBuffer f27846g;

    /* renamed from: h */
    public ByteBuffer f27847h;

    /* renamed from: i */
    public boolean f27848i;

    public n() {
        ByteBuffer byteBuffer = k.f27548a;
        this.f27846g = byteBuffer;
        this.f27847h = byteBuffer;
        this.f27841b = -1;
        this.f27842c = -1;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f27847h;
        this.f27847h = k.f27548a;
        return byteBuffer;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f27841b * 2)) * this.f27845f.length * 2;
        if (this.f27846g.capacity() < length) {
            this.f27846g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f27846g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f27845f) {
                this.f27846g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f27841b * 2;
        }
        byteBuffer.position(limit);
        this.f27846g.flip();
        this.f27847h = this.f27846g;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean a(int i2, int i3, int i4) {
        boolean z = !Arrays.equals(this.f27843d, this.f27845f);
        int[] iArr = this.f27843d;
        this.f27845f = iArr;
        if (iArr == null) {
            this.f27844e = false;
            return z;
        }
        if (i4 != 2) {
            throw new k.a(i2, i3, i4);
        }
        if (!z && this.f27842c == i2 && this.f27841b == i3) {
            return false;
        }
        this.f27842c = i2;
        this.f27841b = i3;
        this.f27844e = i3 != iArr.length;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.f27845f;
            if (i5 >= iArr2.length) {
                return true;
            }
            int i6 = iArr2[i5];
            if (i6 >= i3) {
                throw new k.a(i2, i3, i4);
            }
            this.f27844e = (i6 != i5) | this.f27844e;
            i5++;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean b() {
        return this.f27844e;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public int c() {
        return 2;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void d() {
        this.f27848i = true;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public int e() {
        int[] iArr = this.f27845f;
        return iArr == null ? this.f27841b : iArr.length;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void f() {
        flush();
        this.f27846g = k.f27548a;
        this.f27841b = -1;
        this.f27842c = -1;
        this.f27845f = null;
        this.f27844e = false;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public void flush() {
        this.f27847h = k.f27548a;
        this.f27848i = false;
    }

    @Override // com.vivo.google.android.exoplayer3.k
    public boolean isEnded() {
        return this.f27848i && this.f27847h == k.f27548a;
    }
}
