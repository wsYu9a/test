package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class d0<T> implements a.n0<List<T>, T> {

    /* renamed from: a */
    final int f35955a;

    /* renamed from: b */
    final int f35956b;

    class a extends rx.g<T> {

        /* renamed from: f */
        List<T> f35957f;

        /* renamed from: g */
        final /* synthetic */ rx.g f35958g;

        /* renamed from: rx.internal.operators.d0$a$a */
        class C0851a implements rx.c {

            /* renamed from: a */
            private volatile boolean f35960a = false;

            /* renamed from: b */
            final /* synthetic */ rx.c f35961b;

            C0851a(rx.c cVar) {
                this.f35961b = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                if (this.f35960a) {
                    return;
                }
                int i2 = d0.this.f35955a;
                if (j2 < Long.MAX_VALUE / i2) {
                    this.f35961b.request(j2 * i2);
                } else {
                    this.f35960a = true;
                    this.f35961b.request(Long.MAX_VALUE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f35958g = gVar2;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35958g.f(new C0851a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            List<T> list = this.f35957f;
            this.f35957f = null;
            if (list != null) {
                try {
                    this.f35958g.onNext(list);
                } catch (Throwable th) {
                    onError(th);
                    return;
                }
            }
            this.f35958g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35957f = null;
            this.f35958g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f35957f == null) {
                this.f35957f = new ArrayList(d0.this.f35955a);
            }
            this.f35957f.add(t);
            if (this.f35957f.size() == d0.this.f35955a) {
                List<T> list = this.f35957f;
                this.f35957f = null;
                this.f35958g.onNext(list);
            }
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final List<List<T>> f35963f;

        /* renamed from: g */
        int f35964g;

        /* renamed from: h */
        final /* synthetic */ rx.g f35965h;

        class a implements rx.c {

            /* renamed from: a */
            private volatile boolean f35967a = true;

            /* renamed from: b */
            private volatile boolean f35968b = false;

            /* renamed from: c */
            final /* synthetic */ rx.c f35969c;

            a(rx.c cVar) {
                this.f35969c = cVar;
            }

            private void a() {
                this.f35968b = true;
                this.f35969c.request(Long.MAX_VALUE);
            }

            @Override // rx.c
            public void request(long j2) {
                if (j2 == 0) {
                    return;
                }
                if (j2 < 0) {
                    throw new IllegalArgumentException("request a negative number: " + j2);
                }
                if (this.f35968b) {
                    return;
                }
                if (j2 == Long.MAX_VALUE) {
                    a();
                    return;
                }
                if (!this.f35967a) {
                    int i2 = d0.this.f35956b;
                    if (j2 >= Long.MAX_VALUE / i2) {
                        a();
                        return;
                    } else {
                        this.f35969c.request(i2 * j2);
                        return;
                    }
                }
                this.f35967a = false;
                long j3 = j2 - 1;
                d0 d0Var = d0.this;
                int i3 = d0Var.f35955a;
                int i4 = d0Var.f35956b;
                if (j3 >= (Long.MAX_VALUE - i3) / i4) {
                    a();
                } else {
                    this.f35969c.request(i3 + (i4 * j3));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f35965h = gVar2;
            this.f35963f = new LinkedList();
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35965h.f(new a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                Iterator<List<T>> it = this.f35963f.iterator();
                while (it.hasNext()) {
                    this.f35965h.onNext(it.next());
                }
                this.f35965h.onCompleted();
            } catch (Throwable th) {
                onError(th);
            } finally {
                this.f35963f.clear();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35963f.clear();
            this.f35965h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            int i2 = this.f35964g;
            this.f35964g = i2 + 1;
            if (i2 % d0.this.f35956b == 0) {
                this.f35963f.add(new ArrayList(d0.this.f35955a));
            }
            Iterator<List<T>> it = this.f35963f.iterator();
            while (it.hasNext()) {
                List<T> next = it.next();
                next.add(t);
                if (next.size() == d0.this.f35955a) {
                    it.remove();
                    this.f35965h.onNext(next);
                }
            }
        }
    }

    public d0(int i2, int i3) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("skip must be greater than 0");
        }
        this.f35955a = i2;
        this.f35956b = i3;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        return this.f35955a == this.f35956b ? new a(gVar, gVar) : new b(gVar, gVar);
    }
}
