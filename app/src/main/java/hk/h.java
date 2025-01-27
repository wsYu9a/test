package hk;

import hk.g;
import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class h<T> extends f<T, T> {

    /* renamed from: e */
    public final g<T> f26808e;

    /* renamed from: f */
    public final d.a f26809f;

    public static class a implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26810b;

        public a(g gVar) {
            this.f26810b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f26810b.c(), this.f26810b.f26793h);
        }
    }

    public class b implements wj.a {
        public b() {
        }

        @Override // wj.a
        public void call() {
            h.this.F5();
        }
    }

    public class c implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ Throwable f26812b;

        public c(Throwable th2) {
            this.f26812b = th2;
        }

        @Override // wj.a
        public void call() {
            h.this.G5(this.f26812b);
        }
    }

    public class d implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ Object f26814b;

        public d(Object obj) {
            this.f26814b = obj;
        }

        @Override // wj.a
        public void call() {
            h.this.H5(this.f26814b);
        }
    }

    public h(a.m0<T> m0Var, g<T> gVar, gk.h hVar) {
        super(m0Var);
        this.f26808e = gVar;
        this.f26809f = hVar.a();
    }

    public void G5(Throwable th2) {
        g<T> gVar = this.f26808e;
        if (gVar.f26789d) {
            for (g.c<T> cVar : gVar.h(NotificationLite.f().c(th2))) {
                cVar.onError(th2);
            }
        }
    }

    public static <T> h<T> L5(gk.h hVar) {
        g gVar = new g();
        a aVar = new a(gVar);
        gVar.f26791f = aVar;
        gVar.f26792g = aVar;
        return new h<>(gVar, gVar, hVar);
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26808e.e().length > 0;
    }

    public final void F5() {
        g<T> gVar = this.f26808e;
        if (gVar.f26789d) {
            for (g.c<T> cVar : gVar.h(NotificationLite.f().b())) {
                cVar.onCompleted();
            }
        }
    }

    public final void H5(T t10) {
        for (g.c<T> cVar : this.f26808e.e()) {
            cVar.onNext(t10);
        }
    }

    public void M5(long j10) {
        this.f26809f.c(new b(), j10, TimeUnit.MILLISECONDS);
    }

    public void N5(Throwable th2, long j10) {
        this.f26809f.c(new c(th2), j10, TimeUnit.MILLISECONDS);
    }

    public void O5(T t10, long j10) {
        this.f26809f.c(new d(t10), j10, TimeUnit.MILLISECONDS);
    }

    @Override // qj.b
    public void onCompleted() {
        M5(0L);
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        N5(th2, 0L);
    }

    @Override // qj.b
    public void onNext(T t10) {
        O5(t10, 0L);
    }
}
