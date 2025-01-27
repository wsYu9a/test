package xj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import qj.a;

/* loaded from: classes5.dex */
public final class q<TLeft, TRight, TLeftDuration, TRightDuration, R> implements a.m0<R> {

    /* renamed from: b */
    public final qj.a<TLeft> f32550b;

    /* renamed from: c */
    public final qj.a<TRight> f32551c;

    /* renamed from: d */
    public final wj.o<TLeft, qj.a<TLeftDuration>> f32552d;

    /* renamed from: e */
    public final wj.o<TRight, qj.a<TRightDuration>> f32553e;

    /* renamed from: f */
    public final wj.p<TLeft, TRight, R> f32554f;

    public final class a {

        /* renamed from: b */
        public final qj.g<? super R> f32556b;

        /* renamed from: d */
        public boolean f32558d;

        /* renamed from: e */
        public int f32559e;

        /* renamed from: g */
        public boolean f32561g;

        /* renamed from: h */
        public int f32562h;

        /* renamed from: c */
        public final Object f32557c = new Object();

        /* renamed from: a */
        public final ik.b f32555a = new ik.b();

        /* renamed from: f */
        public final Map<Integer, TLeft> f32560f = new HashMap();

        /* renamed from: i */
        public final Map<Integer, TRight> f32563i = new HashMap();

        /* renamed from: xj.q$a$a */
        public final class C0832a extends qj.g<TLeft> {

            /* renamed from: xj.q$a$a$a */
            public final class C0833a extends qj.g<TLeftDuration> {

                /* renamed from: g */
                public final int f32566g;

                /* renamed from: h */
                public boolean f32567h = true;

                public C0833a(int i10) {
                    this.f32566g = i10;
                }

                @Override // qj.b
                public void onCompleted() {
                    if (this.f32567h) {
                        this.f32567h = false;
                        C0832a.this.g(this.f32566g, this);
                    }
                }

                @Override // qj.b
                public void onError(Throwable th2) {
                    C0832a.this.onError(th2);
                }

                @Override // qj.b
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public C0832a() {
            }

            public void g(int i10, qj.h hVar) {
                boolean z10;
                synchronized (a.this.f32557c) {
                    try {
                        z10 = a.this.f32560f.remove(Integer.valueOf(i10)) != null && a.this.f32560f.isEmpty() && a.this.f32558d;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (!z10) {
                    a.this.f32555a.d(hVar);
                } else {
                    a.this.f32556b.onCompleted();
                    a.this.f32556b.unsubscribe();
                }
            }

            @Override // qj.b
            public void onCompleted() {
                boolean z10;
                synchronized (a.this.f32557c) {
                    try {
                        a aVar = a.this;
                        z10 = true;
                        aVar.f32558d = true;
                        if (!aVar.f32561g && !aVar.f32560f.isEmpty()) {
                            z10 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (!z10) {
                    a.this.f32555a.d(this);
                } else {
                    a.this.f32556b.onCompleted();
                    a.this.f32556b.unsubscribe();
                }
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f32556b.onError(th2);
                a.this.f32556b.unsubscribe();
            }

            @Override // qj.b
            public void onNext(TLeft tleft) {
                int i10;
                a aVar;
                int i11;
                synchronized (a.this.f32557c) {
                    a aVar2 = a.this;
                    i10 = aVar2.f32559e;
                    aVar2.f32559e = i10 + 1;
                    aVar2.f32560f.put(Integer.valueOf(i10), tleft);
                    aVar = a.this;
                    i11 = aVar.f32562h;
                }
                try {
                    qj.a<TLeftDuration> call = q.this.f32552d.call(tleft);
                    C0833a c0833a = new C0833a(i10);
                    a.this.f32555a.a(c0833a);
                    call.T4(c0833a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this.f32557c) {
                        try {
                            for (Map.Entry<Integer, TRight> entry : a.this.f32563i.entrySet()) {
                                if (entry.getKey().intValue() < i11) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f32556b.onNext(q.this.f32554f.call(tleft, it.next()));
                    }
                } catch (Throwable th3) {
                    onError(th3);
                }
            }
        }

        public final class b extends qj.g<TRight> {

            /* renamed from: xj.q$a$b$a */
            public final class C0834a extends qj.g<TRightDuration> {

                /* renamed from: g */
                public final int f32570g;

                /* renamed from: h */
                public boolean f32571h = true;

                public C0834a(int i10) {
                    this.f32570g = i10;
                }

                @Override // qj.b
                public void onCompleted() {
                    if (this.f32571h) {
                        this.f32571h = false;
                        b.this.g(this.f32570g, this);
                    }
                }

                @Override // qj.b
                public void onError(Throwable th2) {
                    b.this.onError(th2);
                }

                @Override // qj.b
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            public void g(int i10, qj.h hVar) {
                boolean z10;
                synchronized (a.this.f32557c) {
                    try {
                        z10 = a.this.f32563i.remove(Integer.valueOf(i10)) != null && a.this.f32563i.isEmpty() && a.this.f32561g;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (!z10) {
                    a.this.f32555a.d(hVar);
                } else {
                    a.this.f32556b.onCompleted();
                    a.this.f32556b.unsubscribe();
                }
            }

            @Override // qj.b
            public void onCompleted() {
                boolean z10;
                synchronized (a.this.f32557c) {
                    try {
                        a aVar = a.this;
                        z10 = true;
                        aVar.f32561g = true;
                        if (!aVar.f32558d && !aVar.f32563i.isEmpty()) {
                            z10 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (!z10) {
                    a.this.f32555a.d(this);
                } else {
                    a.this.f32556b.onCompleted();
                    a.this.f32556b.unsubscribe();
                }
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f32556b.onError(th2);
                a.this.f32556b.unsubscribe();
            }

            @Override // qj.b
            public void onNext(TRight tright) {
                int i10;
                int i11;
                synchronized (a.this.f32557c) {
                    a aVar = a.this;
                    i10 = aVar.f32562h;
                    aVar.f32562h = i10 + 1;
                    aVar.f32563i.put(Integer.valueOf(i10), tright);
                    i11 = a.this.f32559e;
                }
                a.this.f32555a.a(new ik.e());
                try {
                    qj.a<TRightDuration> call = q.this.f32553e.call(tright);
                    C0834a c0834a = new C0834a(i10);
                    a.this.f32555a.a(c0834a);
                    call.T4(c0834a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this.f32557c) {
                        try {
                            for (Map.Entry<Integer, TLeft> entry : a.this.f32560f.entrySet()) {
                                if (entry.getKey().intValue() < i11) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f32556b.onNext(q.this.f32554f.call(it.next(), tright));
                    }
                } catch (Throwable th3) {
                    onError(th3);
                }
            }
        }

        public a(qj.g<? super R> gVar) {
            this.f32556b = gVar;
        }

        public void a() {
            this.f32556b.b(this.f32555a);
            C0832a c0832a = new C0832a();
            b bVar = new b();
            this.f32555a.a(c0832a);
            this.f32555a.a(bVar);
            q.this.f32550b.T4(c0832a);
            q.this.f32551c.T4(bVar);
        }
    }

    public q(qj.a<TLeft> aVar, qj.a<TRight> aVar2, wj.o<TLeft, qj.a<TLeftDuration>> oVar, wj.o<TRight, qj.a<TRightDuration>> oVar2, wj.p<TLeft, TRight, R> pVar) {
        this.f32550b = aVar;
        this.f32551c = aVar2;
        this.f32552d = oVar;
        this.f32553e = oVar2;
        this.f32554f = pVar;
    }

    @Override // wj.b
    public void call(qj.g<? super R> gVar) {
        new a(new ek.d(gVar)).a();
    }
}
