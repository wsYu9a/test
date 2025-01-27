package ek;

/* loaded from: classes5.dex */
public class d<T> extends qj.g<T> {

    /* renamed from: g */
    public final qj.b<T> f25932g;

    public d(qj.g<? super T> gVar) {
        this(gVar, true);
    }

    @Override // qj.b
    public void onCompleted() {
        this.f25932g.onCompleted();
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        this.f25932g.onError(th2);
    }

    @Override // qj.b
    public void onNext(T t10) {
        this.f25932g.onNext(t10);
    }

    public d(qj.g<? super T> gVar, boolean z10) {
        super(gVar, z10);
        this.f25932g = new c(gVar);
    }
}
