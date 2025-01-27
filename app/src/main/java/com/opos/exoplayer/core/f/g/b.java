package com.opos.exoplayer.core.f.g;

import com.opos.exoplayer.core.f.d;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class b implements d {

    /* renamed from: a */
    public static final b f18757a = new b();

    /* renamed from: b */
    private final List<com.opos.exoplayer.core.f.b> f18758b;

    private b() {
        this.f18758b = Collections.emptyList();
    }

    public b(com.opos.exoplayer.core.f.b bVar) {
        this.f18758b = Collections.singletonList(bVar);
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
        return j2 >= 0 ? this.f18758b : Collections.emptyList();
    }
}
