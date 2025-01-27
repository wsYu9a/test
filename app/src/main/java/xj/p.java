package xj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qj.a;

/* loaded from: classes5.dex */
public final class p<T1, T2, D1, D2, R> implements a.m0<R> {

    /* renamed from: b */
    public final qj.a<T1> f32509b;

    /* renamed from: c */
    public final qj.a<T2> f32510c;

    /* renamed from: d */
    public final wj.o<? super T1, ? extends qj.a<D1>> f32511d;

    /* renamed from: e */
    public final wj.o<? super T2, ? extends qj.a<D2>> f32512e;

    /* renamed from: f */
    public final wj.p<? super T1, ? super qj.a<T2>, ? extends R> f32513f;

    public final class a implements qj.h {

        /* renamed from: b */
        public final ik.d f32514b;

        /* renamed from: c */
        public final qj.g<? super R> f32515c;

        /* renamed from: d */
        public final ik.b f32516d;

        /* renamed from: f */
        public int f32518f;

        /* renamed from: g */
        public int f32519g;

        /* renamed from: j */
        public boolean f32522j;

        /* renamed from: k */
        public boolean f32523k;

        /* renamed from: e */
        public final Object f32517e = new Object();

        /* renamed from: h */
        public final Map<Integer, qj.b<T2>> f32520h = new HashMap();

        /* renamed from: i */
        public final Map<Integer, T2> f32521i = new HashMap();

        /* renamed from: xj.p$a$a */
        public final class C0831a extends qj.g<D1> {

            /* renamed from: g */
            public final int f32525g;

            /* renamed from: h */
            public boolean f32526h = true;

            public C0831a(int i10) {
                this.f32525g = i10;
            }

            @Override // qj.b
            public void onCompleted() {
                qj.b<T2> remove;
                if (this.f32526h) {
                    this.f32526h = false;
                    synchronized (a.this.f32517e) {
                        remove = a.this.f32520h.remove(Integer.valueOf(this.f32525g));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    a.this.f32516d.d(this);
                }
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.c(th2);
            }

            @Override // qj.b
            public void onNext(D1 d12) {
                onCompleted();
            }
        }

        public final class b extends qj.g<T1> {
            public b() {
            }

            @Override // qj.b
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this.f32517e) {
                    try {
                        a aVar = a.this;
                        aVar.f32522j = true;
                        if (aVar.f32523k) {
                            arrayList = new ArrayList(a.this.f32520h.values());
                            a.this.f32520h.clear();
                            a.this.f32521i.clear();
                        } else {
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.b(th2);
            }

            @Override // qj.b
            public void onNext(T1 t12) {
                int i10;
                ArrayList arrayList;
                try {
                    hk.c F5 = hk.c.F5();
                    ek.c cVar = new ek.c(F5);
                    synchronized (a.this.f32517e) {
                        a aVar = a.this;
                        i10 = aVar.f32518f;
                        aVar.f32518f = i10 + 1;
                        aVar.f32520h.put(Integer.valueOf(i10), cVar);
                    }
                    qj.a b02 = qj.a.b0(new b(F5, a.this.f32514b));
                    qj.a<D1> call = p.this.f32511d.call(t12);
                    C0831a c0831a = a.this.new C0831a(i10);
                    a.this.f32516d.a(c0831a);
                    call.T4(c0831a);
                    R call2 = p.this.f32513f.call(t12, b02);
                    synchronized (a.this.f32517e) {
                        arrayList = new ArrayList(a.this.f32521i.values());
                    }
                    a.this.f32515c.onNext(call2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cVar.onNext(it.next());
                    }
                } catch (Throwable th2) {
                    onError(th2);
                }
            }
        }

        public final class c extends qj.g<D2> {

            /* renamed from: g */
            public final int f32529g;

            /* renamed from: h */
            public boolean f32530h = true;

            public c(int i10) {
                this.f32529g = i10;
            }

            @Override // qj.b
            public void onCompleted() {
                if (this.f32530h) {
                    this.f32530h = false;
                    synchronized (a.this.f32517e) {
                        a.this.f32521i.remove(Integer.valueOf(this.f32529g));
                    }
                    a.this.f32516d.d(this);
                }
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.c(th2);
            }

            @Override // qj.b
            public void onNext(D2 d22) {
                onCompleted();
            }
        }

        public final class d extends qj.g<T2> {
            public d() {
            }

            @Override // qj.b
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this.f32517e) {
                    try {
                        a aVar = a.this;
                        aVar.f32523k = true;
                        if (aVar.f32522j) {
                            arrayList = new ArrayList(a.this.f32520h.values());
                            a.this.f32520h.clear();
                            a.this.f32521i.clear();
                        } else {
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.b(th2);
            }

            @Override // qj.b
            public void onNext(T2 t22) {
                int i10;
                ArrayList arrayList;
                try {
                    synchronized (a.this.f32517e) {
                        a aVar = a.this;
                        i10 = aVar.f32519g;
                        aVar.f32519g = i10 + 1;
                        aVar.f32521i.put(Integer.valueOf(i10), t22);
                    }
                    qj.a<D2> call = p.this.f32512e.call(t22);
                    c cVar = a.this.new c(i10);
                    a.this.f32516d.a(cVar);
                    call.T4(cVar);
                    synchronized (a.this.f32517e) {
                        arrayList = new ArrayList(a.this.f32520h.values());
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((qj.b) it.next()).onNext(t22);
                    }
                } catch (Throwable th2) {
                    onError(th2);
                }
            }
        }

        public a(qj.g<? super R> gVar) {
            this.f32515c = gVar;
            ik.b bVar = new ik.b();
            this.f32516d = bVar;
            this.f32514b = new ik.d(bVar);
        }

        public void a(List<qj.b<T2>> list) {
            if (list != null) {
                Iterator<qj.b<T2>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted();
                }
                this.f32515c.onCompleted();
                this.f32514b.unsubscribe();
            }
        }

        public void b(Throwable th2) {
            ArrayList arrayList;
            synchronized (this.f32517e) {
                arrayList = new ArrayList(this.f32520h.values());
                this.f32520h.clear();
                this.f32521i.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((qj.b) it.next()).onError(th2);
            }
            this.f32515c.onError(th2);
            this.f32514b.unsubscribe();
        }

        public void c(Throwable th2) {
            synchronized (this.f32517e) {
                this.f32520h.clear();
                this.f32521i.clear();
            }
            this.f32515c.onError(th2);
            this.f32514b.unsubscribe();
        }

        public void d() {
            b bVar = new b();
            d dVar = new d();
            this.f32516d.a(bVar);
            this.f32516d.a(dVar);
            p.this.f32509b.T4(bVar);
            p.this.f32510c.T4(dVar);
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f32514b.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f32514b.unsubscribe();
        }
    }

    public static final class b<T> implements a.m0<T> {

        /* renamed from: b */
        public final ik.d f32533b;

        /* renamed from: c */
        public final qj.a<T> f32534c;

        public final class a extends qj.g<T> {

            /* renamed from: g */
            public final qj.g<? super T> f32535g;

            /* renamed from: h */
            public final qj.h f32536h;

            public a(qj.g<? super T> gVar, qj.h hVar) {
                super(gVar);
                this.f32535g = gVar;
                this.f32536h = hVar;
            }

            @Override // qj.b
            public void onCompleted() {
                this.f32535g.onCompleted();
                this.f32536h.unsubscribe();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                this.f32535g.onError(th2);
                this.f32536h.unsubscribe();
            }

            @Override // qj.b
            public void onNext(T t10) {
                this.f32535g.onNext(t10);
            }
        }

        public b(qj.a<T> aVar, ik.d dVar) {
            this.f32533b = dVar;
            this.f32534c = aVar;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            qj.h a10 = this.f32533b.a();
            a aVar = new a(gVar, a10);
            aVar.b(a10);
            this.f32534c.T4(aVar);
        }
    }

    public p(qj.a<T1> aVar, qj.a<T2> aVar2, wj.o<? super T1, ? extends qj.a<D1>> oVar, wj.o<? super T2, ? extends qj.a<D2>> oVar2, wj.p<? super T1, ? super qj.a<T2>, ? extends R> pVar) {
        this.f32509b = aVar;
        this.f32510c = aVar2;
        this.f32511d = oVar;
        this.f32512e = oVar2;
        this.f32513f = pVar;
    }

    @Override // wj.b
    public void call(qj.g<? super R> gVar) {
        a aVar = new a(new ek.d(gVar));
        gVar.b(aVar);
        aVar.d();
    }
}
