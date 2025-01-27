package com.opos.exoplayer.core.c;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a */
    public static final m f18328a = new m(0, 0);

    /* renamed from: b */
    public final long f18329b;

    /* renamed from: c */
    public final long f18330c;

    public m(long j2, long j3) {
        this.f18329b = j2;
        this.f18330c = j3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            m mVar = (m) obj;
            if (this.f18329b != mVar.f18329b || this.f18330c != mVar.f18330c) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (((int) this.f18329b) * 31) + ((int) this.f18330c);
    }

    public String toString() {
        return "[timeUs=" + this.f18329b + ", position=" + this.f18330c + "]";
    }
}
