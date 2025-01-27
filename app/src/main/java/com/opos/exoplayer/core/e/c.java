package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.e.f;
import com.opos.exoplayer.core.e.o;
import com.opos.exoplayer.core.h.g;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class c implements e, o.c {

    /* renamed from: a */
    private final Uri f18407a;

    /* renamed from: b */
    private final g.a f18408b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.c.h f18409c;

    /* renamed from: d */
    private final int f18410d;

    /* renamed from: e */
    private final f.a f18411e;

    /* renamed from: f */
    private final String f18412f;

    /* renamed from: g */
    private final int f18413g;

    /* renamed from: h */
    private e.a f18414h;

    /* renamed from: i */
    private long f18415i;

    /* renamed from: j */
    private boolean f18416j;

    public static final class a {

        /* renamed from: a */
        private final g.a f18417a;

        /* renamed from: b */
        @Nullable
        private com.opos.exoplayer.core.c.h f18418b;

        /* renamed from: c */
        @Nullable
        private String f18419c;

        /* renamed from: d */
        private int f18420d = -1;

        /* renamed from: e */
        private int f18421e = 1048576;

        /* renamed from: f */
        private boolean f18422f;

        public a(g.a aVar) {
            this.f18417a = aVar;
        }

        public c a(Uri uri) {
            return a(uri, null, null);
        }

        public c a(Uri uri, @Nullable Handler handler, @Nullable f fVar) {
            this.f18422f = true;
            if (this.f18418b == null) {
                this.f18418b = new com.opos.exoplayer.core.c.c();
            }
            return new c(uri, this.f18417a, this.f18418b, this.f18420d, handler, fVar, this.f18419c, this.f18421e);
        }
    }

    private c(Uri uri, g.a aVar, com.opos.exoplayer.core.c.h hVar, int i2, @Nullable Handler handler, @Nullable f fVar, @Nullable String str, int i3) {
        this.f18407a = uri;
        this.f18408b = aVar;
        this.f18409c = hVar;
        this.f18410d = i2;
        this.f18411e = new f.a(handler, fVar);
        this.f18412f = str;
        this.f18413g = i3;
    }

    /* synthetic */ c(Uri uri, g.a aVar, com.opos.exoplayer.core.c.h hVar, int i2, Handler handler, f fVar, String str, int i3, AnonymousClass1 anonymousClass1) {
        this(uri, aVar, hVar, i2, handler, fVar, str, i3);
    }

    private void b(long j2, boolean z) {
        this.f18415i = j2;
        this.f18416j = z;
        this.f18414h.a(this, new k(this.f18415i, this.f18416j, false), null);
    }

    @Override // com.opos.exoplayer.core.e.e
    public d a(e.b bVar, com.opos.exoplayer.core.h.b bVar2) {
        com.opos.exoplayer.core.i.a.a(bVar.f18423a == 0);
        return new o(this.f18407a, this.f18408b.a(), this.f18409c.a(), this.f18410d, this.f18411e, this, bVar2, this.f18412f, this.f18413g);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a() {
    }

    @Override // com.opos.exoplayer.core.e.o.c
    public void a(long j2, boolean z) {
        if (j2 == C.TIME_UNSET) {
            j2 = this.f18415i;
        }
        if (this.f18415i == j2 && this.f18416j == z) {
            return;
        }
        b(j2, z);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(d dVar) {
        ((o) dVar).f();
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(com.opos.exoplayer.core.i iVar, boolean z, e.a aVar) {
        this.f18414h = aVar;
        b(C.TIME_UNSET, false);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void b() {
        this.f18414h = null;
    }
}
