package com.opos.exoplayer.core;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.e.e;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class ae {

    /* renamed from: a */
    public final y f17700a;

    /* renamed from: b */
    @Nullable
    public final Object f17701b;

    /* renamed from: c */
    public final e.b f17702c;

    /* renamed from: d */
    public final long f17703d;

    /* renamed from: e */
    public final long f17704e;

    /* renamed from: f */
    public final int f17705f;

    /* renamed from: g */
    public final boolean f17706g;

    /* renamed from: h */
    public final com.opos.exoplayer.core.g.i f17707h;

    /* renamed from: i */
    public volatile long f17708i;

    /* renamed from: j */
    public volatile long f17709j;

    public ae(y yVar, long j2, com.opos.exoplayer.core.g.i iVar) {
        this(yVar, null, new e.b(0), j2, C.TIME_UNSET, 1, false, iVar);
    }

    public ae(y yVar, @Nullable Object obj, e.b bVar, long j2, long j3, int i2, boolean z, com.opos.exoplayer.core.g.i iVar) {
        this.f17700a = yVar;
        this.f17701b = obj;
        this.f17702c = bVar;
        this.f17703d = j2;
        this.f17704e = j3;
        this.f17708i = j2;
        this.f17709j = j2;
        this.f17705f = i2;
        this.f17706g = z;
        this.f17707h = iVar;
    }

    private static void a(ae aeVar, ae aeVar2) {
        aeVar2.f17708i = aeVar.f17708i;
        aeVar2.f17709j = aeVar.f17709j;
    }

    public ae a(int i2) {
        ae aeVar = new ae(this.f17700a, this.f17701b, this.f17702c.a(i2), this.f17703d, this.f17704e, this.f17705f, this.f17706g, this.f17707h);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(e.b bVar, long j2, long j3) {
        return new ae(this.f17700a, this.f17701b, bVar, j2, bVar.a() ? j3 : -9223372036854775807L, this.f17705f, this.f17706g, this.f17707h);
    }

    public ae a(com.opos.exoplayer.core.g.i iVar) {
        ae aeVar = new ae(this.f17700a, this.f17701b, this.f17702c, this.f17703d, this.f17704e, this.f17705f, this.f17706g, iVar);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(y yVar, Object obj) {
        ae aeVar = new ae(yVar, obj, this.f17702c, this.f17703d, this.f17704e, this.f17705f, this.f17706g, this.f17707h);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(boolean z) {
        ae aeVar = new ae(this.f17700a, this.f17701b, this.f17702c, this.f17703d, this.f17704e, this.f17705f, z, this.f17707h);
        a(this, aeVar);
        return aeVar;
    }

    public ae b(int i2) {
        ae aeVar = new ae(this.f17700a, this.f17701b, this.f17702c, this.f17703d, this.f17704e, i2, this.f17706g, this.f17707h);
        a(this, aeVar);
        return aeVar;
    }
}
