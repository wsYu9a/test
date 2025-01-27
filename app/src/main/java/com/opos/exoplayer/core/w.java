package com.opos.exoplayer.core;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a */
    public static final w f19279a;

    /* renamed from: b */
    public static final w f19280b;

    /* renamed from: c */
    public static final w f19281c;

    /* renamed from: d */
    public static final w f19282d;

    /* renamed from: e */
    public static final w f19283e;

    /* renamed from: f */
    public final long f19284f;

    /* renamed from: g */
    public final long f19285g;

    static {
        w wVar = new w(0L, 0L);
        f19279a = wVar;
        f19280b = new w(Long.MAX_VALUE, Long.MAX_VALUE);
        f19281c = new w(Long.MAX_VALUE, 0L);
        f19282d = new w(0L, Long.MAX_VALUE);
        f19283e = wVar;
    }

    public w(long j2, long j3) {
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        com.opos.exoplayer.core.i.a.a(j3 >= 0);
        this.f19284f = j2;
        this.f19285g = j3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || w.class != obj.getClass()) {
                return false;
            }
            w wVar = (w) obj;
            if (this.f19284f != wVar.f19284f || this.f19285g != wVar.f19285g) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (((int) this.f19284f) * 31) + ((int) this.f19285g);
    }
}
