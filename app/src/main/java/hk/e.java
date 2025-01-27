package hk;

import qj.a;

/* loaded from: classes5.dex */
public class e<T, R> extends f<T, R> {

    /* renamed from: e */
    public final ek.c<T> f26781e;

    /* renamed from: f */
    public final f<T, R> f26782f;

    public class a implements a.m0<R> {

        /* renamed from: b */
        public final /* synthetic */ f f26783b;

        public a(f fVar) {
            this.f26783b = fVar;
        }

        @Override // wj.b
        public void call(qj.g<? super R> gVar) {
            this.f26783b.T4(gVar);
        }
    }

    public e(f<T, R> fVar) {
        super(new a(fVar));
        this.f26782f = fVar;
        this.f26781e = new ek.c<>(fVar);
    }

    @Override // hk.f
    @uj.b
    public boolean A5() {
        return this.f26782f.A5();
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26782f.B5();
    }

    @Override // hk.f
    @uj.b
    public boolean C5() {
        return this.f26782f.C5();
    }

    @Override // hk.f
    @uj.b
    public boolean D5() {
        return this.f26782f.D5();
    }

    @Override // qj.b
    public void onCompleted() {
        this.f26781e.onCompleted();
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        this.f26781e.onError(th2);
    }

    @Override // qj.b
    public void onNext(T t10) {
        this.f26781e.onNext(t10);
    }

    @Override // hk.f
    @uj.b
    public Throwable w5() {
        return this.f26782f.w5();
    }

    @Override // hk.f
    @uj.b
    public T x5() {
        return this.f26782f.x5();
    }

    @Override // hk.f
    @uj.b
    public Object[] y5() {
        return this.f26782f.y5();
    }

    @Override // hk.f
    @uj.b
    public T[] z5(T[] tArr) {
        return this.f26782f.z5(tArr);
    }
}
