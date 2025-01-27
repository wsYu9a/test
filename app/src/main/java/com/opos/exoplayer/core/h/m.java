package com.opos.exoplayer.core.h;

import android.content.Context;
import com.opos.exoplayer.core.h.g;

/* loaded from: classes4.dex */
public final class m implements g.a {

    /* renamed from: a */
    private final Context f18957a;

    /* renamed from: b */
    private final t<? super g> f18958b;

    /* renamed from: c */
    private final g.a f18959c;

    public m(Context context, t<? super g> tVar, g.a aVar) {
        this.f18957a = context.getApplicationContext();
        this.f18958b = tVar;
        this.f18959c = aVar;
    }

    public m(Context context, String str) {
        this(context, str, (t<? super g>) null);
    }

    public m(Context context, String str, t<? super g> tVar) {
        this(context, tVar, new o(str, tVar));
    }

    @Override // com.opos.exoplayer.core.h.g.a
    /* renamed from: b */
    public l a() {
        return new l(this.f18957a, this.f18958b, this.f18959c.a());
    }
}
