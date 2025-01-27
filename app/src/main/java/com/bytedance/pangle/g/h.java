package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class h implements k {

    /* renamed from: a */
    private final ByteBuffer f6141a;

    h(ByteBuffer byteBuffer) {
        this.f6141a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f6141a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j2, int i2) {
        ByteBuffer slice;
        synchronized (this.f6141a) {
            this.f6141a.position(0);
            int i3 = (int) j2;
            this.f6141a.limit(i2 + i3);
            this.f6141a.position(i3);
            slice = this.f6141a.slice();
        }
        jVar.a(slice);
    }
}
