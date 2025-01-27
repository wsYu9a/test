package rx.l;

/* loaded from: classes5.dex */
public class d<T> extends rx.g<T> {

    /* renamed from: f */
    private final rx.b<T> f36894f;

    public d(rx.g<? super T> gVar) {
        this(gVar, true);
    }

    @Override // rx.b
    public void onCompleted() {
        this.f36894f.onCompleted();
    }

    @Override // rx.b
    public void onError(Throwable th) {
        this.f36894f.onError(th);
    }

    @Override // rx.b
    public void onNext(T t) {
        this.f36894f.onNext(t);
    }

    public d(rx.g<? super T> gVar, boolean z) {
        super(gVar, z);
        this.f36894f = new c(gVar);
    }
}
