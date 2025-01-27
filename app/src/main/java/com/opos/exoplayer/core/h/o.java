package com.opos.exoplayer.core.h;

import com.opos.exoplayer.core.h.q;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;

/* loaded from: classes4.dex */
public final class o extends q.a {

    /* renamed from: a */
    private final String f18969a;

    /* renamed from: b */
    private final t<? super g> f18970b;

    /* renamed from: c */
    private final int f18971c;

    /* renamed from: d */
    private final int f18972d;

    /* renamed from: e */
    private final boolean f18973e;

    public o(String str, t<? super g> tVar) {
        this(str, tVar, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, false);
    }

    public o(String str, t<? super g> tVar, int i2, int i3, boolean z) {
        this.f18969a = str;
        this.f18970b = tVar;
        this.f18971c = i2;
        this.f18972d = i3;
        this.f18973e = z;
    }

    @Override // com.opos.exoplayer.core.h.q.a
    /* renamed from: a */
    public n b(q.f fVar) {
        return new n(this.f18969a, null, this.f18970b, this.f18971c, this.f18972d, this.f18973e, fVar);
    }
}
