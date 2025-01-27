package com.opos.exoplayer.core;

import com.opos.exoplayer.core.e.e;

/* loaded from: classes4.dex */
final class ac {

    /* renamed from: a */
    public final e.b f17683a;

    /* renamed from: b */
    public final long f17684b;

    /* renamed from: c */
    public final long f17685c;

    /* renamed from: d */
    public final long f17686d;

    /* renamed from: e */
    public final long f17687e;

    /* renamed from: f */
    public final boolean f17688f;

    /* renamed from: g */
    public final boolean f17689g;

    ac(e.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this.f17683a = bVar;
        this.f17684b = j2;
        this.f17685c = j3;
        this.f17686d = j4;
        this.f17687e = j5;
        this.f17688f = z;
        this.f17689g = z2;
    }

    public ac a(int i2) {
        return new ac(this.f17683a.a(i2), this.f17684b, this.f17685c, this.f17686d, this.f17687e, this.f17688f, this.f17689g);
    }

    public ac a(long j2) {
        return new ac(this.f17683a, j2, this.f17685c, this.f17686d, this.f17687e, this.f17688f, this.f17689g);
    }
}
