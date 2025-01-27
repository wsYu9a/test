package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.a;

/* loaded from: classes5.dex */
public final class q<TLeft, TRight, TLeftDuration, TRightDuration, R> implements a.m0<R> {

    /* renamed from: a */
    final rx.a<TLeft> f36358a;

    /* renamed from: b */
    final rx.a<TRight> f36359b;

    /* renamed from: c */
    final rx.k.o<TLeft, rx.a<TLeftDuration>> f36360c;

    /* renamed from: d */
    final rx.k.o<TRight, rx.a<TRightDuration>> f36361d;

    /* renamed from: e */
    final rx.k.p<TLeft, TRight, R> f36362e;

    final class a {

        /* renamed from: b */
        final rx.g<? super R> f36364b;

        /* renamed from: d */
        boolean f36366d;

        /* renamed from: e */
        int f36367e;

        /* renamed from: g */
        boolean f36369g;

        /* renamed from: h */
        int f36370h;

        /* renamed from: c */
        final Object f36365c = new Object();

        /* renamed from: a */
        final rx.p.b f36363a = new rx.p.b();

        /* renamed from: f */
        final Map<Integer, TLeft> f36368f = new HashMap();

        /* renamed from: i */
        final Map<Integer, TRight> f36371i = new HashMap();

        /* renamed from: rx.internal.operators.q$a$a */
        final class C0868a extends rx.g<TLeft> {

            /* renamed from: rx.internal.operators.q$a$a$a */
            final class C0869a extends rx.g<TLeftDuration> {

                /* renamed from: f */
                final int f36374f;

                /* renamed from: g */
                boolean f36375g = true;

                public C0869a(int i2) {
                    this.f36374f = i2;
                }

                @Override // rx.b
                public void onCompleted() {
                    if (this.f36375g) {
                        this.f36375g = false;
                        C0868a.this.g(this.f36374f, this);
                    }
                }

                @Override // rx.b
                public void onError(Throwable th) {
                    C0868a.this.onError(th);
                }

                @Override // rx.b
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            C0868a() {
            }

            protected void g(int i2, rx.h hVar) {
                boolean z;
                synchronized (a.this.f36365c) {
                    z = a.this.f36368f.remove(Integer.valueOf(i2)) != null && a.this.f36368f.isEmpty() && a.this.f36366d;
                }
                if (!z) {
                    a.this.f36363a.d(hVar);
                } else {
                    a.this.f36364b.onCompleted();
                    a.this.f36364b.unsubscribe();
                }
            }

            @Override // rx.b
            public void onCompleted() {
                boolean z;
                synchronized (a.this.f36365c) {
                    a aVar = a.this;
                    z = true;
                    aVar.f36366d = true;
                    if (!aVar.f36369g && !aVar.f36368f.isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    a.this.f36363a.d(this);
                } else {
                    a.this.f36364b.onCompleted();
                    a.this.f36364b.unsubscribe();
                }
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f36364b.onError(th);
                a.this.f36364b.unsubscribe();
            }

            @Override // rx.b
            public void onNext(TLeft tleft) {
                int i2;
                a aVar;
                int i3;
                synchronized (a.this.f36365c) {
                    a aVar2 = a.this;
                    i2 = aVar2.f36367e;
                    aVar2.f36367e = i2 + 1;
                    aVar2.f36368f.put(Integer.valueOf(i2), tleft);
                    aVar = a.this;
                    i3 = aVar.f36370h;
                }
                try {
                    rx.a<TLeftDuration> call = q.this.f36360c.call(tleft);
                    C0869a c0869a = new C0869a(i2);
                    a.this.f36363a.a(c0869a);
                    call.T4(c0869a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this.f36365c) {
                        for (Map.Entry<Integer, TRight> entry : a.this.f36371i.entrySet()) {
                            if (entry.getKey().intValue() < i3) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f36364b.onNext(q.this.f36362e.call(tleft, it.next()));
                    }
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        final class b extends rx.g<TRight> {

            /* renamed from: rx.internal.operators.q$a$b$a */
            final class C0870a extends rx.g<TRightDuration> {

                /* renamed from: f */
                final int f36378f;

                /* renamed from: g */
                boolean f36379g = true;

                public C0870a(int i2) {
                    this.f36378f = i2;
                }

                @Override // rx.b
                public void onCompleted() {
                    if (this.f36379g) {
                        this.f36379g = false;
                        b.this.g(this.f36378f, this);
                    }
                }

                @Override // rx.b
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // rx.b
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            b() {
            }

            void g(int i2, rx.h hVar) {
                boolean z;
                synchronized (a.this.f36365c) {
                    z = a.this.f36371i.remove(Integer.valueOf(i2)) != null && a.this.f36371i.isEmpty() && a.this.f36369g;
                }
                if (!z) {
                    a.this.f36363a.d(hVar);
                } else {
                    a.this.f36364b.onCompleted();
                    a.this.f36364b.unsubscribe();
                }
            }

            @Override // rx.b
            public void onCompleted() {
                boolean z;
                synchronized (a.this.f36365c) {
                    a aVar = a.this;
                    z = true;
                    aVar.f36369g = true;
                    if (!aVar.f36366d && !aVar.f36371i.isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    a.this.f36363a.d(this);
                } else {
                    a.this.f36364b.onCompleted();
                    a.this.f36364b.unsubscribe();
                }
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f36364b.onError(th);
                a.this.f36364b.unsubscribe();
            }

            @Override // rx.b
            public void onNext(TRight tright) {
                int i2;
                int i3;
                synchronized (a.this.f36365c) {
                    a aVar = a.this;
                    i2 = aVar.f36370h;
                    aVar.f36370h = i2 + 1;
                    aVar.f36371i.put(Integer.valueOf(i2), tright);
                    i3 = a.this.f36367e;
                }
                a.this.f36363a.a(new rx.p.e());
                try {
                    rx.a<TRightDuration> call = q.this.f36361d.call(tright);
                    C0870a c0870a = new C0870a(i2);
                    a.this.f36363a.a(c0870a);
                    call.T4(c0870a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this.f36365c) {
                        for (Map.Entry<Integer, TLeft> entry : a.this.f36368f.entrySet()) {
                            if (entry.getKey().intValue() < i3) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f36364b.onNext(q.this.f36362e.call(it.next(), tright));
                    }
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        public a(rx.g<? super R> gVar) {
            this.f36364b = gVar;
        }

        public void a() {
            this.f36364b.b(this.f36363a);
            C0868a c0868a = new C0868a();
            b bVar = new b();
            this.f36363a.a(c0868a);
            this.f36363a.a(bVar);
            q.this.f36358a.T4(c0868a);
            q.this.f36359b.T4(bVar);
        }
    }

    public q(rx.a<TLeft> aVar, rx.a<TRight> aVar2, rx.k.o<TLeft, rx.a<TLeftDuration>> oVar, rx.k.o<TRight, rx.a<TRightDuration>> oVar2, rx.k.p<TLeft, TRight, R> pVar) {
        this.f36358a = aVar;
        this.f36359b = aVar2;
        this.f36360c = oVar;
        this.f36361d = oVar2;
        this.f36362e = pVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super R> gVar) {
        new a(new rx.l.d(gVar)).a();
    }
}
