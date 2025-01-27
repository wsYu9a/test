package xj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class f0<T> implements a.n0<List<T>, T> {

    /* renamed from: b */
    public final long f32200b;

    /* renamed from: c */
    public final long f32201c;

    /* renamed from: d */
    public final TimeUnit f32202d;

    /* renamed from: e */
    public final int f32203e;

    /* renamed from: f */
    public final qj.d f32204f;

    public final class a extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super List<T>> f32205g;

        /* renamed from: h */
        public final d.a f32206h;

        /* renamed from: i */
        public List<T> f32207i = new ArrayList();

        /* renamed from: j */
        public boolean f32208j;

        /* renamed from: xj.f0$a$a */
        public class C0816a implements wj.a {
            public C0816a() {
            }

            @Override // wj.a
            public void call() {
                a.this.g();
            }
        }

        public a(qj.g<? super List<T>> gVar, d.a aVar) {
            this.f32205g = gVar;
            this.f32206h = aVar;
        }

        public void g() {
            synchronized (this) {
                try {
                    if (this.f32208j) {
                        return;
                    }
                    List<T> list = this.f32207i;
                    this.f32207i = new ArrayList();
                    try {
                        this.f32205g.onNext(list);
                    } catch (Throwable th2) {
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public void h() {
            d.a aVar = this.f32206h;
            C0816a c0816a = new C0816a();
            f0 f0Var = f0.this;
            long j10 = f0Var.f32200b;
            aVar.d(c0816a, j10, j10, f0Var.f32202d);
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                this.f32206h.unsubscribe();
                synchronized (this) {
                    try {
                        if (this.f32208j) {
                            return;
                        }
                        this.f32208j = true;
                        List<T> list = this.f32207i;
                        this.f32207i = null;
                        this.f32205g.onNext(list);
                        this.f32205g.onCompleted();
                        unsubscribe();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                this.f32205g.onError(th3);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this) {
                try {
                    if (this.f32208j) {
                        return;
                    }
                    this.f32208j = true;
                    this.f32207i = null;
                    this.f32205g.onError(th2);
                    unsubscribe();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            List<T> list;
            synchronized (this) {
                try {
                    if (this.f32208j) {
                        return;
                    }
                    this.f32207i.add(t10);
                    if (this.f32207i.size() == f0.this.f32203e) {
                        list = this.f32207i;
                        this.f32207i = new ArrayList();
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        this.f32205g.onNext(list);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final class b extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super List<T>> f32211g;

        /* renamed from: h */
        public final d.a f32212h;

        /* renamed from: i */
        public final List<List<T>> f32213i = new LinkedList();

        /* renamed from: j */
        public boolean f32214j;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                b.this.i();
            }
        }

        /* renamed from: xj.f0$b$b */
        public class C0817b implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ List f32217b;

            public C0817b(List list) {
                this.f32217b = list;
            }

            @Override // wj.a
            public void call() {
                b.this.g(this.f32217b);
            }
        }

        public b(qj.g<? super List<T>> gVar, d.a aVar) {
            this.f32211g = gVar;
            this.f32212h = aVar;
        }

        public void g(List<T> list) {
            boolean z10;
            synchronized (this) {
                try {
                    if (this.f32214j) {
                        return;
                    }
                    Iterator<List<T>> it = this.f32213i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = false;
                            break;
                        } else if (it.next() == list) {
                            it.remove();
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        try {
                            this.f32211g.onNext(list);
                        } catch (Throwable th2) {
                            onError(th2);
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public void h() {
            d.a aVar = this.f32212h;
            a aVar2 = new a();
            f0 f0Var = f0.this;
            long j10 = f0Var.f32201c;
            aVar.d(aVar2, j10, j10, f0Var.f32202d);
        }

        public void i() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    if (this.f32214j) {
                        return;
                    }
                    this.f32213i.add(arrayList);
                    d.a aVar = this.f32212h;
                    C0817b c0817b = new C0817b(arrayList);
                    f0 f0Var = f0.this;
                    aVar.c(c0817b, f0Var.f32200b, f0Var.f32202d);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f32214j) {
                            return;
                        }
                        this.f32214j = true;
                        LinkedList linkedList = new LinkedList(this.f32213i);
                        this.f32213i.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f32211g.onNext((List) it.next());
                        }
                        this.f32211g.onCompleted();
                        unsubscribe();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                this.f32211g.onError(th3);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this) {
                try {
                    if (this.f32214j) {
                        return;
                    }
                    this.f32214j = true;
                    this.f32213i.clear();
                    this.f32211g.onError(th2);
                    unsubscribe();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            synchronized (this) {
                try {
                    if (this.f32214j) {
                        return;
                    }
                    Iterator<List<T>> it = this.f32213i.iterator();
                    LinkedList linkedList = null;
                    while (it.hasNext()) {
                        List<T> next = it.next();
                        next.add(t10);
                        if (next.size() == f0.this.f32203e) {
                            it.remove();
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(next);
                        }
                    }
                    if (linkedList != null) {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            this.f32211g.onNext((List) it2.next());
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public f0(long j10, long j11, TimeUnit timeUnit, int i10, qj.d dVar) {
        this.f32200b = j10;
        this.f32201c = j11;
        this.f32202d = timeUnit;
        this.f32203e = i10;
        this.f32204f = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        d.a a10 = this.f32204f.a();
        ek.d dVar = new ek.d(gVar);
        if (this.f32200b == this.f32201c) {
            a aVar = new a(dVar, a10);
            aVar.b(a10);
            gVar.b(aVar);
            aVar.h();
            return aVar;
        }
        b bVar = new b(dVar, a10);
        bVar.b(a10);
        gVar.b(bVar);
        bVar.i();
        bVar.h();
        return bVar;
    }
}
