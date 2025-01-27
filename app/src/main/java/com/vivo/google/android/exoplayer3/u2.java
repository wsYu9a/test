package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.drm.DrmInitData;
import com.vivo.google.android.exoplayer3.x2;
import java.util.List;

/* loaded from: classes4.dex */
public final class u2 {

    /* renamed from: a */
    public final List<Format> f28132a;

    /* renamed from: b */
    public final n0[] f28133b;

    public u2(List<Format> list) {
        this.f28132a = list;
        this.f28133b = new n0[list.size()];
    }

    public void a(i0 i0Var, x2.d dVar) {
        for (int i2 = 0; i2 < this.f28133b.length; i2++) {
            dVar.a();
            n0 a2 = ((l3) i0Var).a(dVar.c(), 3);
            Format format = this.f28132a.get(i2);
            String str = format.sampleMimeType;
            g1.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = format.id;
            if (str2 == null) {
                str2 = dVar.b();
            }
            e0 e0Var = (e0) a2;
            e0Var.a(Format.createTextSampleFormat(str2, str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.f28133b[i2] = e0Var;
        }
    }
}
