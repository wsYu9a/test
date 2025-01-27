package rx;

import rx.internal.util.i;

/* loaded from: classes5.dex */
public abstract class g<T> implements b<T>, h {

    /* renamed from: a */
    private static final Long f35763a = Long.MIN_VALUE;

    /* renamed from: b */
    private final i f35764b;

    /* renamed from: c */
    private final g<?> f35765c;

    /* renamed from: d */
    private c f35766d;

    /* renamed from: e */
    private long f35767e;

    protected g() {
        this(null, false);
    }

    private void c(long j2) {
        if (this.f35767e == f35763a.longValue()) {
            this.f35767e = j2;
            return;
        }
        long j3 = this.f35767e + j2;
        if (j3 < 0) {
            this.f35767e = Long.MAX_VALUE;
        } else {
            this.f35767e = j3;
        }
    }

    public final void b(h hVar) {
        this.f35764b.a(hVar);
    }

    public void d() {
    }

    protected final void e(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j2);
        }
        synchronized (this) {
            c cVar = this.f35766d;
            if (cVar != null) {
                cVar.request(j2);
            } else {
                c(j2);
            }
        }
    }

    public void f(c cVar) {
        long j2;
        boolean z;
        synchronized (this) {
            j2 = this.f35767e;
            this.f35766d = cVar;
            z = this.f35765c != null && j2 == f35763a.longValue();
        }
        if (z) {
            this.f35765c.f(this.f35766d);
        } else if (j2 == f35763a.longValue()) {
            this.f35766d.request(Long.MAX_VALUE);
        } else {
            this.f35766d.request(j2);
        }
    }

    @Override // rx.h
    public final boolean isUnsubscribed() {
        return this.f35764b.isUnsubscribed();
    }

    @Override // rx.h
    public final void unsubscribe() {
        this.f35764b.unsubscribe();
    }

    protected g(g<?> gVar) {
        this(gVar, true);
    }

    protected g(g<?> gVar, boolean z) {
        this.f35767e = f35763a.longValue();
        this.f35765c = gVar;
        this.f35764b = (!z || gVar == null) ? new i() : gVar.f35764b;
    }
}
