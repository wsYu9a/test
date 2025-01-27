package xj;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;

/* loaded from: classes5.dex */
public final class a1<T, R> extends dk.b<R> {

    /* renamed from: d */
    public final qj.a<? extends T> f32017d;

    /* renamed from: e */
    public final Object f32018e;

    /* renamed from: f */
    public final wj.n<? extends hk.f<? super T, ? extends R>> f32019f;

    /* renamed from: g */
    public final AtomicReference<hk.f<? super T, ? extends R>> f32020g;

    /* renamed from: h */
    public final List<qj.g<? super R>> f32021h;

    /* renamed from: i */
    public qj.g<T> f32022i;

    /* renamed from: j */
    public qj.h f32023j;

    public class a implements a.m0<R> {

        /* renamed from: b */
        public final /* synthetic */ Object f32024b;

        /* renamed from: c */
        public final /* synthetic */ AtomicReference f32025c;

        /* renamed from: d */
        public final /* synthetic */ List f32026d;

        public a(Object obj, AtomicReference atomicReference, List list) {
            this.f32024b = obj;
            this.f32025c = atomicReference;
            this.f32026d = list;
        }

        @Override // wj.b
        public void call(qj.g<? super R> gVar) {
            synchronized (this.f32024b) {
                try {
                    if (this.f32025c.get() == null) {
                        this.f32026d.add(gVar);
                    } else {
                        ((hk.f) this.f32025c.get()).T4(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public class b implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ AtomicReference f32027b;

        public b(AtomicReference atomicReference) {
            this.f32027b = atomicReference;
        }

        @Override // wj.a
        public void call() {
            synchronized (a1.this.f32018e) {
                if (a1.this.f32023j == this.f32027b.get()) {
                    qj.g gVar = a1.this.f32022i;
                    a1.this.f32022i = null;
                    a1.this.f32023j = null;
                    a1.this.f32020g.set(null);
                    if (gVar != null) {
                        gVar.unsubscribe();
                    }
                }
            }
        }
    }

    public class c extends qj.g<R> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32029g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32029g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32029g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32029g.onError(th2);
        }

        @Override // qj.b
        public void onNext(R r10) {
            this.f32029g.onNext(r10);
        }
    }

    public a1(qj.a<? extends T> aVar, wj.n<? extends hk.f<? super T, ? extends R>> nVar) {
        this(new Object(), new AtomicReference(), new ArrayList(), aVar, nVar);
    }

    @Override // dk.b
    public void A5(wj.b<? super qj.h> bVar) {
        qj.g<T> gVar;
        synchronized (this.f32018e) {
            try {
                if (this.f32022i != null) {
                    bVar.call(this.f32023j);
                    return;
                }
                hk.f<? super T, ? extends R> call = this.f32019f.call();
                this.f32022i = ek.e.e(call);
                AtomicReference atomicReference = new AtomicReference();
                atomicReference.set(ik.f.a(new b(atomicReference)));
                this.f32023j = (qj.h) atomicReference.get();
                for (qj.g<? super R> gVar2 : this.f32021h) {
                    call.T4(new c(gVar2, gVar2));
                }
                this.f32021h.clear();
                this.f32020g.set(call);
                bVar.call(this.f32023j);
                synchronized (this.f32018e) {
                    gVar = this.f32022i;
                }
                if (gVar != null) {
                    this.f32017d.K3(gVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public a1(Object obj, AtomicReference<hk.f<? super T, ? extends R>> atomicReference, List<qj.g<? super R>> list, qj.a<? extends T> aVar, wj.n<? extends hk.f<? super T, ? extends R>> nVar) {
        super(new a(obj, atomicReference, list));
        this.f32018e = obj;
        this.f32020g = atomicReference;
        this.f32021h = list;
        this.f32017d = aVar;
        this.f32019f = nVar;
    }
}
