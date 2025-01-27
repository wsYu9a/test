package rx.o;

import rx.a;

/* loaded from: classes5.dex */
public class e<T, R> extends f<T, R> {

    /* renamed from: d */
    private final rx.l.c<T> f37033d;

    /* renamed from: e */
    private final f<T, R> f37034e;

    class a implements a.m0<R> {

        /* renamed from: a */
        final /* synthetic */ f f37035a;

        a(f fVar) {
            this.f37035a = fVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            this.f37035a.T4(gVar);
        }
    }

    public e(f<T, R> fVar) {
        super(new a(fVar));
        this.f37034e = fVar;
        this.f37033d = new rx.l.c<>(fVar);
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean A5() {
        return this.f37034e.A5();
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f37034e.B5();
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean C5() {
        return this.f37034e.C5();
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean D5() {
        return this.f37034e.D5();
    }

    @Override // rx.b
    public void onCompleted() {
        this.f37033d.onCompleted();
    }

    @Override // rx.b
    public void onError(Throwable th) {
        this.f37033d.onError(th);
    }

    @Override // rx.b
    public void onNext(T t) {
        this.f37033d.onNext(t);
    }

    @Override // rx.o.f
    @rx.j.b
    public Throwable w5() {
        return this.f37034e.w5();
    }

    @Override // rx.o.f
    @rx.j.b
    public T x5() {
        return this.f37034e.x5();
    }

    @Override // rx.o.f
    @rx.j.b
    public Object[] y5() {
        return this.f37034e.y5();
    }

    @Override // rx.o.f
    @rx.j.b
    public T[] z5(T[] tArr) {
        return this.f37034e.z5(tArr);
    }
}
