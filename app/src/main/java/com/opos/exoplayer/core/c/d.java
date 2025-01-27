package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import java.io.EOFException;

/* loaded from: classes4.dex */
public final class d implements n {
    @Override // com.opos.exoplayer.core.c.n
    public int a(f fVar, int i2, boolean z) {
        int a2 = fVar.a(i2);
        if (a2 != -1) {
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j2, int i2, int i3, int i4, n.a aVar) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(com.opos.exoplayer.core.i.m mVar, int i2) {
        mVar.d(i2);
    }
}
