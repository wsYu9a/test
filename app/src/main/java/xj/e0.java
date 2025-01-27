package xj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qj.a;

/* loaded from: classes5.dex */
public final class e0<T, TOpening, TClosing> implements a.n0<List<T>, T> {

    /* renamed from: b */
    public final qj.a<? extends TOpening> f32169b;

    /* renamed from: c */
    public final wj.o<? super TOpening, ? extends qj.a<? extends TClosing>> f32170c;

    public class a extends qj.g<TOpening> {

        /* renamed from: g */
        public final /* synthetic */ b f32171g;

        public a(b bVar) {
            this.f32171g = bVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32171g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32171g.onError(th2);
        }

        @Override // qj.b
        public void onNext(TOpening topening) {
            this.f32171g.h(topening);
        }
    }

    public final class b extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super List<T>> f32173g;

        /* renamed from: h */
        public final List<List<T>> f32174h = new LinkedList();

        /* renamed from: i */
        public boolean f32175i;

        /* renamed from: j */
        public final ik.b f32176j;

        public class a extends qj.g<TClosing> {

            /* renamed from: g */
            public final /* synthetic */ List f32178g;

            public a(List list) {
                this.f32178g = list;
            }

            @Override // qj.b
            public void onCompleted() {
                b.this.f32176j.d(this);
                b.this.g(this.f32178g);
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                b.this.onError(th2);
            }

            @Override // qj.b
            public void onNext(TClosing tclosing) {
                b.this.f32176j.d(this);
                b.this.g(this.f32178g);
            }
        }

        public b(qj.g<? super List<T>> gVar) {
            this.f32173g = gVar;
            ik.b bVar = new ik.b();
            this.f32176j = bVar;
            b(bVar);
        }

        public void g(List<T> list) {
            boolean z10;
            synchronized (this) {
                try {
                    if (this.f32175i) {
                        return;
                    }
                    Iterator<List<T>> it = this.f32174h.iterator();
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
                        this.f32173g.onNext(list);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void h(TOpening topening) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    if (this.f32175i) {
                        return;
                    }
                    this.f32174h.add(arrayList);
                    try {
                        qj.a<? extends TClosing> call = e0.this.f32170c.call(topening);
                        a aVar = new a(arrayList);
                        this.f32176j.a(aVar);
                        call.T4(aVar);
                    } catch (Throwable th2) {
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f32175i) {
                            return;
                        }
                        this.f32175i = true;
                        LinkedList linkedList = new LinkedList(this.f32174h);
                        this.f32174h.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f32173g.onNext((List) it.next());
                        }
                        this.f32173g.onCompleted();
                        unsubscribe();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                this.f32173g.onError(th3);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this) {
                try {
                    if (this.f32175i) {
                        return;
                    }
                    this.f32175i = true;
                    this.f32174h.clear();
                    this.f32173g.onError(th2);
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
                    Iterator<List<T>> it = this.f32174h.iterator();
                    while (it.hasNext()) {
                        it.next().add(t10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public e0(qj.a<? extends TOpening> aVar, wj.o<? super TOpening, ? extends qj.a<? extends TClosing>> oVar) {
        this.f32169b = aVar;
        this.f32170c = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        b bVar = new b(new ek.d(gVar));
        a aVar = new a(bVar);
        gVar.b(aVar);
        gVar.b(bVar);
        this.f32169b.T4(aVar);
        return bVar;
    }
}
