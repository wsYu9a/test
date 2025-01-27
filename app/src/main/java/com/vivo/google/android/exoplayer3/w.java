package com.vivo.google.android.exoplayer3;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class w extends t {

    /* renamed from: b */
    public final u f28191b = new u();

    /* renamed from: c */
    public ByteBuffer f28192c;

    /* renamed from: d */
    public long f28193d;

    /* renamed from: e */
    public final int f28194e;

    public w(int i2) {
        this.f28194e = i2;
    }

    public static w c() {
        return new w(0);
    }

    public void b() {
        this.f28074a = 0;
        ByteBuffer byteBuffer = this.f28192c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final ByteBuffer d(int i2) {
        int i3 = this.f28194e;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f28192c;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i2 + ")");
    }

    public void e(int i2) {
        ByteBuffer byteBuffer = this.f28192c;
        if (byteBuffer == null) {
            this.f28192c = d(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f28192c.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            return;
        }
        ByteBuffer d2 = d(i3);
        if (position > 0) {
            this.f28192c.position(0);
            this.f28192c.limit(position);
            d2.put(this.f28192c);
        }
        this.f28192c = d2;
    }
}
