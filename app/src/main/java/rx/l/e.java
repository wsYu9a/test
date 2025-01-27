package rx.l;

import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public final class e {

    static class a<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.b f36895f;

        a(rx.b bVar) {
            this.f36895f = bVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36895f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36895f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36895f.onNext(t);
        }
    }

    static class b<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f36896f;

        b(rx.k.b bVar) {
            this.f36896f = bVar;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f36896f.call(t);
        }
    }

    static class c<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f36897f;

        /* renamed from: g */
        final /* synthetic */ rx.k.b f36898g;

        c(rx.k.b bVar, rx.k.b bVar2) {
            this.f36897f = bVar;
            this.f36898g = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f36897f.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f36898g.call(t);
        }
    }

    static class d<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.a f36899f;

        /* renamed from: g */
        final /* synthetic */ rx.k.b f36900g;

        /* renamed from: h */
        final /* synthetic */ rx.k.b f36901h;

        d(rx.k.a aVar, rx.k.b bVar, rx.k.b bVar2) {
            this.f36899f = aVar;
            this.f36900g = bVar;
            this.f36901h = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f36899f.call();
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f36900g.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f36901h.call(t);
        }
    }

    /* renamed from: rx.l.e$e */
    static class C0886e<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36902f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0886e(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36902f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36902f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36902f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36902f.onNext(t);
        }
    }

    private e() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T> rx.g<T> a(rx.k.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static final <T> rx.g<T> b(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static final <T> rx.g<T> c(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2, rx.k.a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (aVar != null) {
            return new d(aVar, bVar2, bVar);
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }

    public static <T> rx.g<T> d() {
        return e(rx.l.a.d());
    }

    public static <T> rx.g<T> e(rx.b<? super T> bVar) {
        return new a(bVar);
    }

    @rx.j.b
    public static <T> rx.g<T> f(rx.g<? super T> gVar) {
        return new C0886e(gVar, gVar);
    }
}
