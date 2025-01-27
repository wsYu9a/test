package com.opos.exoplayer.core.f.h;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class h implements com.opos.exoplayer.core.f.d {

    /* renamed from: a */
    private final List<com.opos.exoplayer.core.f.b> f18806a;

    public h(List<com.opos.exoplayer.core.f.b> list) {
        this.f18806a = Collections.unmodifiableList(list);
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i2) {
        com.opos.exoplayer.core.i.a.a(i2 == 0);
        return 0L;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j2) {
        return j2 >= 0 ? this.f18806a : Collections.emptyList();
    }
}
