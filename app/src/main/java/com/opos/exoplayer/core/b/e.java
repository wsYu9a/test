package com.opos.exoplayer.core.b;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: a */
    public final b f17738a = new b();

    /* renamed from: b */
    public ByteBuffer f17739b;

    /* renamed from: c */
    public long f17740c;

    /* renamed from: d */
    private final int f17741d;

    public e(int i2) {
        this.f17741d = i2;
    }

    public static e e() {
        return new e(0);
    }

    private ByteBuffer f(int i2) {
        int i3 = this.f17741d;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f17739b;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i2 + ")");
    }

    @Override // com.opos.exoplayer.core.b.a
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.f17739b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void e(int i2) {
        ByteBuffer f2;
        ByteBuffer byteBuffer = this.f17739b;
        if (byteBuffer == null) {
            f2 = f(i2);
        } else {
            int capacity = byteBuffer.capacity();
            int position = this.f17739b.position();
            int i3 = i2 + position;
            if (capacity >= i3) {
                return;
            }
            f2 = f(i3);
            if (position > 0) {
                this.f17739b.position(0);
                this.f17739b.limit(position);
                f2.put(this.f17739b);
            }
        }
        this.f17739b = f2;
    }

    public final boolean f() {
        return this.f17739b == null && this.f17741d == 0;
    }

    public final boolean g() {
        return d(1073741824);
    }

    public final void h() {
        this.f17739b.flip();
    }
}
