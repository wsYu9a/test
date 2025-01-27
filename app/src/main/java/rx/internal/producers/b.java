package rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import rx.c;
import rx.g;

/* loaded from: classes5.dex */
public final class b<T> implements c, rx.b<T> {

    /* renamed from: a */
    static final c f36721a = new a();

    /* renamed from: b */
    final g<? super T> f36722b;

    /* renamed from: c */
    boolean f36723c;

    /* renamed from: d */
    List<T> f36724d;

    /* renamed from: e */
    c f36725e;

    /* renamed from: f */
    long f36726f;

    /* renamed from: g */
    long f36727g;

    /* renamed from: h */
    c f36728h;

    /* renamed from: i */
    Object f36729i;

    /* renamed from: j */
    volatile boolean f36730j;

    static class a implements c {
        a() {
        }

        @Override // rx.c
        public void request(long j2) {
        }
    }

    public b(g<? super T> gVar) {
        this.f36722b = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0002, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a() {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.b.a():void");
    }

    public void b(c cVar) {
        synchronized (this) {
            if (this.f36723c) {
                if (cVar == null) {
                    cVar = f36721a;
                }
                this.f36728h = cVar;
                return;
            }
            this.f36723c = true;
            try {
                this.f36725e = cVar;
                long j2 = this.f36726f;
                if (cVar != null && j2 != 0) {
                    cVar.request(j2);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36723c = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.b
    public void onCompleted() {
        synchronized (this) {
            if (this.f36723c) {
                this.f36729i = Boolean.TRUE;
            } else {
                this.f36723c = true;
                this.f36722b.onCompleted();
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.f36723c) {
                this.f36729i = th;
                z = false;
            } else {
                this.f36723c = true;
                z = true;
            }
        }
        if (z) {
            this.f36722b.onError(th);
        } else {
            this.f36730j = true;
        }
    }

    @Override // rx.b
    public void onNext(T t) {
        synchronized (this) {
            if (this.f36723c) {
                List list = this.f36724d;
                if (list == null) {
                    list = new ArrayList(4);
                    this.f36724d = list;
                }
                list.add(t);
                return;
            }
            try {
                this.f36722b.onNext(t);
                long j2 = this.f36726f;
                if (j2 != Long.MAX_VALUE) {
                    this.f36726f = j2 - 1;
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36723c = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.c
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.f36723c) {
                this.f36727g += j2;
                return;
            }
            this.f36723c = true;
            try {
                long j3 = this.f36726f + j2;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
                this.f36726f = j3;
                c cVar = this.f36725e;
                if (cVar != null) {
                    cVar.request(j2);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36723c = false;
                    throw th;
                }
            }
        }
    }
}
