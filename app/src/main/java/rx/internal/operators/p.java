package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.a;

/* loaded from: classes5.dex */
public final class p<T1, T2, D1, D2, R> implements a.m0<R> {

    /* renamed from: a */
    protected final rx.a<T1> f36318a;

    /* renamed from: b */
    protected final rx.a<T2> f36319b;

    /* renamed from: c */
    protected final rx.k.o<? super T1, ? extends rx.a<D1>> f36320c;

    /* renamed from: d */
    protected final rx.k.o<? super T2, ? extends rx.a<D2>> f36321d;

    /* renamed from: e */
    protected final rx.k.p<? super T1, ? super rx.a<T2>, ? extends R> f36322e;

    final class a implements rx.h {

        /* renamed from: a */
        final rx.p.d f36323a;

        /* renamed from: b */
        final rx.g<? super R> f36324b;

        /* renamed from: c */
        final rx.p.b f36325c;

        /* renamed from: e */
        int f36327e;

        /* renamed from: f */
        int f36328f;

        /* renamed from: i */
        boolean f36331i;

        /* renamed from: j */
        boolean f36332j;

        /* renamed from: d */
        final Object f36326d = new Object();

        /* renamed from: g */
        final Map<Integer, rx.b<T2>> f36329g = new HashMap();

        /* renamed from: h */
        final Map<Integer, T2> f36330h = new HashMap();

        /* renamed from: rx.internal.operators.p$a$a */
        final class C0867a extends rx.g<D1> {

            /* renamed from: f */
            final int f36333f;

            /* renamed from: g */
            boolean f36334g = true;

            public C0867a(int i2) {
                this.f36333f = i2;
            }

            @Override // rx.b
            public void onCompleted() {
                rx.b<T2> remove;
                if (this.f36334g) {
                    this.f36334g = false;
                    synchronized (a.this.f36326d) {
                        remove = a.this.f36329g.remove(Integer.valueOf(this.f36333f));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    a.this.f36325c.d(this);
                }
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.c(th);
            }

            @Override // rx.b
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        final class b extends rx.g<T1> {
            b() {
            }

            @Override // rx.b
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this.f36326d) {
                    a aVar = a.this;
                    aVar.f36331i = true;
                    if (aVar.f36332j) {
                        arrayList = new ArrayList(a.this.f36329g.values());
                        a.this.f36329g.clear();
                        a.this.f36330h.clear();
                    } else {
                        arrayList = null;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.b
            public void onNext(T1 t1) {
                int i2;
                ArrayList arrayList;
                try {
                    rx.o.c F5 = rx.o.c.F5();
                    rx.l.c cVar = new rx.l.c(F5);
                    synchronized (a.this.f36326d) {
                        a aVar = a.this;
                        i2 = aVar.f36327e;
                        aVar.f36327e = i2 + 1;
                        aVar.f36329g.put(Integer.valueOf(i2), cVar);
                    }
                    rx.a b0 = rx.a.b0(new b(F5, a.this.f36323a));
                    rx.a<D1> call = p.this.f36320c.call(t1);
                    C0867a c0867a = a.this.new C0867a(i2);
                    a.this.f36325c.a(c0867a);
                    call.T4(c0867a);
                    R call2 = p.this.f36322e.call(t1, b0);
                    synchronized (a.this.f36326d) {
                        arrayList = new ArrayList(a.this.f36330h.values());
                    }
                    a.this.f36324b.onNext(call2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cVar.onNext(it.next());
                    }
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        final class c extends rx.g<D2> {

            /* renamed from: f */
            final int f36337f;

            /* renamed from: g */
            boolean f36338g = true;

            public c(int i2) {
                this.f36337f = i2;
            }

            @Override // rx.b
            public void onCompleted() {
                if (this.f36338g) {
                    this.f36338g = false;
                    synchronized (a.this.f36326d) {
                        a.this.f36330h.remove(Integer.valueOf(this.f36337f));
                    }
                    a.this.f36325c.d(this);
                }
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.c(th);
            }

            @Override // rx.b
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        final class d extends rx.g<T2> {
            d() {
            }

            @Override // rx.b
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this.f36326d) {
                    a aVar = a.this;
                    aVar.f36332j = true;
                    if (aVar.f36331i) {
                        arrayList = new ArrayList(a.this.f36329g.values());
                        a.this.f36329g.clear();
                        a.this.f36330h.clear();
                    } else {
                        arrayList = null;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.b
            public void onNext(T2 t2) {
                int i2;
                ArrayList arrayList;
                try {
                    synchronized (a.this.f36326d) {
                        a aVar = a.this;
                        i2 = aVar.f36328f;
                        aVar.f36328f = i2 + 1;
                        aVar.f36330h.put(Integer.valueOf(i2), t2);
                    }
                    rx.a<D2> call = p.this.f36321d.call(t2);
                    c cVar = a.this.new c(i2);
                    a.this.f36325c.a(cVar);
                    call.T4(cVar);
                    synchronized (a.this.f36326d) {
                        arrayList = new ArrayList(a.this.f36329g.values());
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((rx.b) it.next()).onNext(t2);
                    }
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        public a(rx.g<? super R> gVar) {
            this.f36324b = gVar;
            rx.p.b bVar = new rx.p.b();
            this.f36325c = bVar;
            this.f36323a = new rx.p.d(bVar);
        }

        void a(List<rx.b<T2>> list) {
            if (list != null) {
                Iterator<rx.b<T2>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted();
                }
                this.f36324b.onCompleted();
                this.f36323a.unsubscribe();
            }
        }

        void b(Throwable th) {
            ArrayList arrayList;
            synchronized (this.f36326d) {
                arrayList = new ArrayList(this.f36329g.values());
                this.f36329g.clear();
                this.f36330h.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((rx.b) it.next()).onError(th);
            }
            this.f36324b.onError(th);
            this.f36323a.unsubscribe();
        }

        void c(Throwable th) {
            synchronized (this.f36326d) {
                this.f36329g.clear();
                this.f36330h.clear();
            }
            this.f36324b.onError(th);
            this.f36323a.unsubscribe();
        }

        public void d() {
            b bVar = new b();
            d dVar = new d();
            this.f36325c.a(bVar);
            this.f36325c.a(dVar);
            p.this.f36318a.T4(bVar);
            p.this.f36319b.T4(dVar);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36323a.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36323a.unsubscribe();
        }
    }

    static final class b<T> implements a.m0<T> {

        /* renamed from: a */
        final rx.p.d f36341a;

        /* renamed from: b */
        final rx.a<T> f36342b;

        final class a extends rx.g<T> {

            /* renamed from: f */
            final rx.g<? super T> f36343f;

            /* renamed from: g */
            private final rx.h f36344g;

            public a(rx.g<? super T> gVar, rx.h hVar) {
                super(gVar);
                this.f36343f = gVar;
                this.f36344g = hVar;
            }

            @Override // rx.b
            public void onCompleted() {
                this.f36343f.onCompleted();
                this.f36344g.unsubscribe();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                this.f36343f.onError(th);
                this.f36344g.unsubscribe();
            }

            @Override // rx.b
            public void onNext(T t) {
                this.f36343f.onNext(t);
            }
        }

        public b(rx.a<T> aVar, rx.p.d dVar) {
            this.f36341a = dVar;
            this.f36342b = aVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            rx.h a2 = this.f36341a.a();
            a aVar = new a(gVar, a2);
            aVar.b(a2);
            this.f36342b.T4(aVar);
        }
    }

    public p(rx.a<T1> aVar, rx.a<T2> aVar2, rx.k.o<? super T1, ? extends rx.a<D1>> oVar, rx.k.o<? super T2, ? extends rx.a<D2>> oVar2, rx.k.p<? super T1, ? super rx.a<T2>, ? extends R> pVar) {
        this.f36318a = aVar;
        this.f36319b = aVar2;
        this.f36320c = oVar;
        this.f36321d = oVar2;
        this.f36322e = pVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super R> gVar) {
        a aVar = new a(new rx.l.d(gVar));
        gVar.b(aVar);
        aVar.d();
    }
}
