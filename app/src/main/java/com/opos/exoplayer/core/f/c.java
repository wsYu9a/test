package com.opos.exoplayer.core.f;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class c extends com.opos.exoplayer.core.b.g<h, i, f> implements e {

    /* renamed from: a */
    private final String f18683a;

    protected c(String str) {
        super(new h[2], new i[2]);
        this.f18683a = str;
        a(1024);
    }

    protected abstract d a(byte[] bArr, int i2, boolean z);

    @Override // com.opos.exoplayer.core.b.g
    public final f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.f17739b;
            iVar.a(hVar.f17740c, a(byteBuffer.array(), byteBuffer.limit(), z), hVar.f18759d);
            iVar.c(Integer.MIN_VALUE);
            return null;
        } catch (f e2) {
            return e2;
        }
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j2) {
    }

    @Override // com.opos.exoplayer.core.b.g
    public final void a(i iVar) {
        super.a((c) iVar);
    }

    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: b */
    public final f a(Throwable th) {
        return new f("Unexpected decode error", th);
    }

    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: i */
    public final h g() {
        return new h();
    }

    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: j */
    public final i h() {
        return new l(this);
    }
}
