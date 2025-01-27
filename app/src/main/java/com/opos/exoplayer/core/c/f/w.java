package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.List;

/* loaded from: classes4.dex */
final class w {

    /* renamed from: a */
    private final List<Format> f18291a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.c.n[] f18292b;

    public w(List<Format> list) {
        this.f18291a = list;
        this.f18292b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    public void a(long j2, com.opos.exoplayer.core.i.m mVar) {
        com.opos.exoplayer.core.f.a.c.a(j2, mVar, this.f18292b);
    }

    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        for (int i2 = 0; i2 < this.f18292b.length; i2++) {
            dVar.a();
            com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 3);
            Format format = this.f18291a.get(i2);
            String str = format.f17496f;
            com.opos.exoplayer.core.i.a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = format.f17491a;
            if (str2 == null) {
                str2 = dVar.c();
            }
            a2.a(Format.a(str2, str, (String) null, -1, format.x, format.y, format.z, (DrmInitData) null));
            this.f18292b[i2] = a2;
        }
    }
}
