package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class h implements k {

    /* renamed from: a */
    private final ByteBuffer f7643a;

    public h(ByteBuffer byteBuffer) {
        this.f7643a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f7643a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j10, int i10) {
        ByteBuffer slice;
        synchronized (this.f7643a) {
            this.f7643a.position(0);
            int i11 = (int) j10;
            this.f7643a.limit(i10 + i11);
            this.f7643a.position(i11);
            slice = this.f7643a.slice();
        }
        jVar.a(slice);
    }
}
