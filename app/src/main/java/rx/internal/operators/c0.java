package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class c0<T, TClosing> implements a.n0<List<T>, T> {

    /* renamed from: a */
    final rx.k.n<? extends rx.a<? extends TClosing>> f35923a;

    /* renamed from: b */
    final int f35924b;

    class a implements rx.k.n<rx.a<? extends TClosing>> {

        /* renamed from: a */
        final /* synthetic */ rx.a f35925a;

        a(rx.a aVar) {
            this.f35925a = aVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.a<? extends TClosing> call() {
            return this.f35925a;
        }
    }

    class b extends rx.g<TClosing> {

        /* renamed from: f */
        final /* synthetic */ c f35927f;

        b(c cVar) {
            this.f35927f = cVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35927f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35927f.onError(th);
        }

        @Override // rx.b
        public void onNext(TClosing tclosing) {
            this.f35927f.g();
        }
    }

    final class c extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super List<T>> f35929f;

        /* renamed from: g */
        List<T> f35930g;

        /* renamed from: h */
        boolean f35931h;

        public c(rx.g<? super List<T>> gVar) {
            this.f35929f = gVar;
            this.f35930g = new ArrayList(c0.this.f35924b);
        }

        void g() {
            synchronized (this) {
                if (this.f35931h) {
                    return;
                }
                List<T> list = this.f35930g;
                this.f35930g = new ArrayList(c0.this.f35924b);
                try {
                    this.f35929f.onNext(list);
                } catch (Throwable th) {
                    unsubscribe();
                    synchronized (this) {
                        if (this.f35931h) {
                            return;
                        }
                        this.f35931h = true;
                        this.f35929f.onError(th);
                    }
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f35931h) {
                        return;
                    }
                    this.f35931h = true;
                    List<T> list = this.f35930g;
                    this.f35930g = null;
                    this.f35929f.onNext(list);
                    this.f35929f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f35929f.onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f35931h) {
                    return;
                }
                this.f35931h = true;
                this.f35930g = null;
                this.f35929f.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this) {
                if (this.f35931h) {
                    return;
                }
                this.f35930g.add(t);
            }
        }
    }

    public c0(rx.k.n<? extends rx.a<? extends TClosing>> nVar, int i2) {
        this.f35923a = nVar;
        this.f35924b = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        try {
            rx.a<? extends TClosing> call = this.f35923a.call();
            c cVar = new c(new rx.l.d(gVar));
            b bVar = new b(cVar);
            gVar.b(bVar);
            gVar.b(cVar);
            call.T4(bVar);
            return cVar;
        } catch (Throwable th) {
            gVar.onError(th);
            return rx.l.e.d();
        }
    }

    public c0(rx.a<? extends TClosing> aVar, int i2) {
        this.f35923a = new a(aVar);
        this.f35924b = i2;
    }
}
