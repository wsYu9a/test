package com.opos.exoplayer.core.f.e;

import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.i.u;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class b implements d {

    /* renamed from: a */
    private final com.opos.exoplayer.core.f.b[] f18706a;

    /* renamed from: b */
    private final long[] f18707b;

    public b(com.opos.exoplayer.core.f.b[] bVarArr, long[] jArr) {
        this.f18706a = bVarArr;
        this.f18707b = jArr;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j2) {
        int b2 = u.b(this.f18707b, j2, false, false);
        if (b2 < this.f18707b.length) {
            return b2;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i2) {
        com.opos.exoplayer.core.i.a.a(i2 >= 0);
        com.opos.exoplayer.core.i.a.a(i2 < this.f18707b.length);
        return this.f18707b[i2];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.f18707b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j2) {
        int a2 = u.a(this.f18707b, j2, true, false);
        if (a2 != -1) {
            com.opos.exoplayer.core.f.b[] bVarArr = this.f18706a;
            if (bVarArr[a2] != null) {
                return Collections.singletonList(bVarArr[a2]);
            }
        }
        return Collections.emptyList();
    }
}
