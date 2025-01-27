package qj;

import ak.i;

/* loaded from: classes4.dex */
public abstract class g<T> implements b<T>, h {

    /* renamed from: f */
    public static final Long f30197f = Long.MIN_VALUE;

    /* renamed from: b */
    public final i f30198b;

    /* renamed from: c */
    public final g<?> f30199c;

    /* renamed from: d */
    public c f30200d;

    /* renamed from: e */
    public long f30201e;

    public g() {
        this(null, false);
    }

    public final void b(h hVar) {
        this.f30198b.a(hVar);
    }

    public final void c(long j10) {
        if (this.f30201e == f30197f.longValue()) {
            this.f30201e = j10;
            return;
        }
        long j11 = this.f30201e + j10;
        if (j11 < 0) {
            this.f30201e = Long.MAX_VALUE;
        } else {
            this.f30201e = j11;
        }
    }

    public final void e(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j10);
        }
        synchronized (this) {
            c cVar = this.f30200d;
            if (cVar != null) {
                cVar.request(j10);
            } else {
                c(j10);
            }
        }
    }

    public void f(c cVar) {
        long j10;
        boolean z10;
        synchronized (this) {
            try {
                j10 = this.f30201e;
                this.f30200d = cVar;
                z10 = this.f30199c != null && j10 == f30197f.longValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            this.f30199c.f(this.f30200d);
        } else if (j10 == f30197f.longValue()) {
            this.f30200d.request(Long.MAX_VALUE);
        } else {
            this.f30200d.request(j10);
        }
    }

    @Override // qj.h
    public final boolean isUnsubscribed() {
        return this.f30198b.isUnsubscribed();
    }

    @Override // qj.h
    public final void unsubscribe() {
        this.f30198b.unsubscribe();
    }

    public g(g<?> gVar) {
        this(gVar, true);
    }

    public g(g<?> gVar, boolean z10) {
        this.f30201e = f30197f.longValue();
        this.f30199c = gVar;
        this.f30198b = (!z10 || gVar == null) ? new i() : gVar.f30198b;
    }

    public void d() {
    }
}
