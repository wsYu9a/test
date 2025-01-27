package xj;

import java.util.ArrayList;
import java.util.List;
import qj.a;

/* loaded from: classes5.dex */
public final class c0<T, TClosing> implements a.n0<List<T>, T> {

    /* renamed from: b */
    public final wj.n<? extends qj.a<? extends TClosing>> f32091b;

    /* renamed from: c */
    public final int f32092c;

    public class a implements wj.n<qj.a<? extends TClosing>> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32093b;

        public a(qj.a aVar) {
            this.f32093b = aVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public qj.a<? extends TClosing> call() {
            return this.f32093b;
        }
    }

    public class b extends qj.g<TClosing> {

        /* renamed from: g */
        public final /* synthetic */ c f32095g;

        public b(c cVar) {
            this.f32095g = cVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32095g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32095g.onError(th2);
        }

        @Override // qj.b
        public void onNext(TClosing tclosing) {
            this.f32095g.g();
        }
    }

    public final class c extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super List<T>> f32097g;

        /* renamed from: h */
        public List<T> f32098h;

        /* renamed from: i */
        public boolean f32099i;

        public c(qj.g<? super List<T>> gVar) {
            this.f32097g = gVar;
            this.f32098h = new ArrayList(c0.this.f32092c);
        }

        public void g() {
            synchronized (this) {
                try {
                    if (this.f32099i) {
                        return;
                    }
                    List<T> list = this.f32098h;
                    this.f32098h = new ArrayList(c0.this.f32092c);
                    try {
                        this.f32097g.onNext(list);
                    } catch (Throwable th2) {
                        unsubscribe();
                        synchronized (this) {
                            try {
                                if (this.f32099i) {
                                    return;
                                }
                                this.f32099i = true;
                                this.f32097g.onError(th2);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f32099i) {
                            return;
                        }
                        this.f32099i = true;
                        List<T> list = this.f32098h;
                        this.f32098h = null;
                        this.f32097g.onNext(list);
                        this.f32097g.onCompleted();
                        unsubscribe();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                this.f32097g.onError(th3);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this) {
                try {
                    if (this.f32099i) {
                        return;
                    }
                    this.f32099i = true;
                    this.f32098h = null;
                    this.f32097g.onError(th2);
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
                    if (this.f32099i) {
                        return;
                    }
                    this.f32098h.add(t10);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public c0(wj.n<? extends qj.a<? extends TClosing>> nVar, int i10) {
        this.f32091b = nVar;
        this.f32092c = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        try {
            qj.a<? extends TClosing> call = this.f32091b.call();
            c cVar = new c(new ek.d(gVar));
            b bVar = new b(cVar);
            gVar.b(bVar);
            gVar.b(cVar);
            call.T4(bVar);
            return cVar;
        } catch (Throwable th2) {
            gVar.onError(th2);
            return ek.e.d();
        }
    }

    public c0(qj.a<? extends TClosing> aVar, int i10) {
        this.f32091b = new a(aVar);
        this.f32092c = i10;
    }
}
