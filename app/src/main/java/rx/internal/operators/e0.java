package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class e0<T, TOpening, TClosing> implements a.n0<List<T>, T> {

    /* renamed from: a */
    final rx.a<? extends TOpening> f35995a;

    /* renamed from: b */
    final rx.k.o<? super TOpening, ? extends rx.a<? extends TClosing>> f35996b;

    class a extends rx.g<TOpening> {

        /* renamed from: f */
        final /* synthetic */ b f35997f;

        a(b bVar) {
            this.f35997f = bVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35997f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35997f.onError(th);
        }

        @Override // rx.b
        public void onNext(TOpening topening) {
            this.f35997f.h(topening);
        }
    }

    final class b extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super List<T>> f35999f;

        /* renamed from: g */
        final List<List<T>> f36000g = new LinkedList();

        /* renamed from: h */
        boolean f36001h;

        /* renamed from: i */
        final rx.p.b f36002i;

        class a extends rx.g<TClosing> {

            /* renamed from: f */
            final /* synthetic */ List f36004f;

            a(List list) {
                this.f36004f = list;
            }

            @Override // rx.b
            public void onCompleted() {
                b.this.f36002i.d(this);
                b.this.g(this.f36004f);
            }

            @Override // rx.b
            public void onError(Throwable th) {
                b.this.onError(th);
            }

            @Override // rx.b
            public void onNext(TClosing tclosing) {
                b.this.f36002i.d(this);
                b.this.g(this.f36004f);
            }
        }

        public b(rx.g<? super List<T>> gVar) {
            this.f35999f = gVar;
            rx.p.b bVar = new rx.p.b();
            this.f36002i = bVar;
            b(bVar);
        }

        void g(List<T> list) {
            boolean z;
            synchronized (this) {
                if (this.f36001h) {
                    return;
                }
                Iterator<List<T>> it = this.f36000g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == list) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    this.f35999f.onNext(list);
                }
            }
        }

        void h(TOpening topening) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f36001h) {
                    return;
                }
                this.f36000g.add(arrayList);
                try {
                    rx.a<? extends TClosing> call = e0.this.f35996b.call(topening);
                    a aVar = new a(arrayList);
                    this.f36002i.a(aVar);
                    call.T4(aVar);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f36001h) {
                        return;
                    }
                    this.f36001h = true;
                    LinkedList linkedList = new LinkedList(this.f36000g);
                    this.f36000g.clear();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.f35999f.onNext((List) it.next());
                    }
                    this.f35999f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f35999f.onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f36001h) {
                    return;
                }
                this.f36001h = true;
                this.f36000g.clear();
                this.f35999f.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this) {
                Iterator<List<T>> it = this.f36000g.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }
    }

    public e0(rx.a<? extends TOpening> aVar, rx.k.o<? super TOpening, ? extends rx.a<? extends TClosing>> oVar) {
        this.f35995a = aVar;
        this.f35996b = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        b bVar = new b(new rx.l.d(gVar));
        a aVar = new a(bVar);
        gVar.b(aVar);
        gVar.b(bVar);
        this.f35995a.T4(aVar);
        return bVar;
    }
}
