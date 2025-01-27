package rx.o;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.o.g;

/* loaded from: classes5.dex */
public final class h<T> extends f<T, T> {

    /* renamed from: d */
    private final g<T> f37060d;

    /* renamed from: e */
    private final d.a f37061e;

    static class a implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f37062a;

        a(g gVar) {
            this.f37062a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f37062a.c(), this.f37062a.f37045i);
        }
    }

    class b implements rx.k.a {
        b() {
        }

        @Override // rx.k.a
        public void call() {
            h.this.F5();
        }
    }

    class c implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ Throwable f37064a;

        c(Throwable th) {
            this.f37064a = th;
        }

        @Override // rx.k.a
        public void call() {
            h.this.G5(this.f37064a);
        }
    }

    class d implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ Object f37066a;

        d(Object obj) {
            this.f37066a = obj;
        }

        @Override // rx.k.a
        public void call() {
            h.this.H5(this.f37066a);
        }
    }

    protected h(a.m0<T> m0Var, g<T> gVar, rx.n.h hVar) {
        super(m0Var);
        this.f37060d = gVar;
        this.f37061e = hVar.a();
    }

    public void F5() {
        g<T> gVar = this.f37060d;
        if (gVar.f37041e) {
            for (g.c<T> cVar : gVar.h(NotificationLite.f().b())) {
                cVar.onCompleted();
            }
        }
    }

    public void G5(Throwable th) {
        g<T> gVar = this.f37060d;
        if (gVar.f37041e) {
            for (g.c<T> cVar : gVar.h(NotificationLite.f().c(th))) {
                cVar.onError(th);
            }
        }
    }

    public void H5(T t) {
        for (g.c<T> cVar : this.f37060d.e()) {
            cVar.onNext(t);
        }
    }

    public static <T> h<T> L5(rx.n.h hVar) {
        g gVar = new g();
        a aVar = new a(gVar);
        gVar.f37043g = aVar;
        gVar.f37044h = aVar;
        return new h<>(gVar, gVar, hVar);
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f37060d.e().length > 0;
    }

    public void M5(long j2) {
        this.f37061e.e(new b(), j2, TimeUnit.MILLISECONDS);
    }

    public void N5(Throwable th, long j2) {
        this.f37061e.e(new c(th), j2, TimeUnit.MILLISECONDS);
    }

    public void O5(T t, long j2) {
        this.f37061e.e(new d(t), j2, TimeUnit.MILLISECONDS);
    }

    @Override // rx.b
    public void onCompleted() {
        M5(0L);
    }

    @Override // rx.b
    public void onError(Throwable th) {
        N5(th, 0L);
    }

    @Override // rx.b
    public void onNext(T t) {
        O5(t, 0L);
    }
}
