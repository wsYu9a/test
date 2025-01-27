package com.opos.exoplayer.core.f.b;

import com.opos.exoplayer.core.i.m;
import java.util.List;

/* loaded from: classes4.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a */
    private final b f18626a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        m mVar = new m(list.get(0));
        this.f18626a = new b(mVar.h(), mVar.h());
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public c a(byte[] bArr, int i2, boolean z) {
        if (z) {
            this.f18626a.a();
        }
        return new c(this.f18626a.a(bArr, i2));
    }
}
