package com.opos.exoplayer.core.f.f;

import com.opos.exoplayer.core.i.u;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class f implements com.opos.exoplayer.core.f.d {

    /* renamed from: a */
    private final c f18743a;

    /* renamed from: b */
    private final long[] f18744b;

    /* renamed from: c */
    private final Map<String, b> f18745c;

    /* renamed from: d */
    private final Map<String, d> f18746d;

    public f(c cVar, Map<String, b> map, Map<String, d> map2) {
        this.f18743a = cVar;
        this.f18746d = map2;
        this.f18745c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f18744b = cVar.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j2) {
        int b2 = u.b(this.f18744b, j2, false, false);
        if (b2 < this.f18744b.length) {
            return b2;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i2) {
        return this.f18744b[i2];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.f18744b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j2) {
        return this.f18743a.a(j2, this.f18745c, this.f18746d);
    }
}
