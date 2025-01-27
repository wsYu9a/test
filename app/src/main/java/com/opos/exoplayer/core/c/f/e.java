package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class e implements u.c {

    /* renamed from: a */
    private final int f18113a;

    /* renamed from: b */
    private final List<Format> f18114b;

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, Collections.emptyList());
    }

    public e(int i2, List<Format> list) {
        this.f18113a = i2;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.a(null, "application/cea-608", 0, null));
        }
        this.f18114b = list;
    }

    private w a(u.b bVar) {
        String str;
        int i2;
        if (a(32)) {
            return new w(this.f18114b);
        }
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(bVar.f18280d);
        List<Format> list = this.f18114b;
        while (mVar.b() > 0) {
            int g2 = mVar.g();
            int g3 = mVar.g();
            int d2 = mVar.d();
            if (g2 == 134) {
                list = new ArrayList<>();
                int g4 = mVar.g();
                for (int i3 = 0; i3 < (g4 & 31); i3++) {
                    String e2 = mVar.e(3);
                    int g5 = mVar.g();
                    if ((g5 & 128) != 0) {
                        i2 = g5 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    list.add(Format.a((String) null, str, (String) null, -1, 0, e2, i2, (DrmInitData) null));
                    mVar.d(2);
                }
            }
            mVar.c(d2 + g3);
        }
        return new w(list);
    }

    private boolean a(int i2) {
        return (i2 & this.f18113a) != 0;
    }

    @Override // com.opos.exoplayer.core.c.f.u.c
    public SparseArray<u> a() {
        return new SparseArray<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0033, code lost:
    
        if (r4 != 135) goto L111;
     */
    @Override // com.opos.exoplayer.core.c.f.u.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.exoplayer.core.c.f.u a(int r4, com.opos.exoplayer.core.c.f.u.b r5) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.e.a(int, com.opos.exoplayer.core.c.f.u$b):com.opos.exoplayer.core.c.f.u");
    }
}
