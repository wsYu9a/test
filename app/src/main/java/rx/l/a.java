package rx.l;

import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    private static final rx.b<Object> f36875a = new C0885a();

    /* renamed from: rx.l.a$a */
    static class C0885a implements rx.b<Object> {
        C0885a() {
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.b
        public final void onNext(Object obj) {
        }
    }

    static class b<T> implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f36876a;

        b(rx.k.b bVar) {
            this.f36876a = bVar;
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
            this.f36876a.call(t);
        }
    }

    static class c<T> implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f36877a;

        /* renamed from: b */
        final /* synthetic */ rx.k.b f36878b;

        c(rx.k.b bVar, rx.k.b bVar2) {
            this.f36877a = bVar;
            this.f36878b = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f36877a.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f36878b.call(t);
        }
    }

    static class d<T> implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.a f36879a;

        /* renamed from: b */
        final /* synthetic */ rx.k.b f36880b;

        /* renamed from: c */
        final /* synthetic */ rx.k.b f36881c;

        d(rx.k.a aVar, rx.k.b bVar, rx.k.b bVar2) {
            this.f36879a = aVar;
            this.f36880b = bVar;
            this.f36881c = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f36879a.call();
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f36880b.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f36881c.call(t);
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T> rx.b<T> a(rx.k.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static final <T> rx.b<T> b(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static final <T> rx.b<T> c(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2, rx.k.a aVar) {
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

    public static <T> rx.b<T> d() {
        return (rx.b<T>) f36875a;
    }
}
