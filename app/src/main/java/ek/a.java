package ek;

import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public static final qj.b<Object> f25913a = new C0694a();

    public static class d<T> implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.a f25917b;

        /* renamed from: c */
        public final /* synthetic */ wj.b f25918c;

        /* renamed from: d */
        public final /* synthetic */ wj.b f25919d;

        public d(wj.a aVar, wj.b bVar, wj.b bVar2) {
            this.f25917b = aVar;
            this.f25918c = bVar;
            this.f25919d = bVar2;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f25917b.call();
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f25918c.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25919d.call(t10);
        }
    }

    public a() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T> qj.b<T> a(wj.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static final <T> qj.b<T> b(wj.b<? super T> bVar, wj.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static final <T> qj.b<T> c(wj.b<? super T> bVar, wj.b<Throwable> bVar2, wj.a aVar) {
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

    public static <T> qj.b<T> d() {
        return (qj.b<T>) f25913a;
    }

    /* renamed from: ek.a$a */
    public static class C0694a implements qj.b<Object> {
        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onCompleted() {
        }

        @Override // qj.b
        public final void onNext(Object obj) {
        }
    }

    public static class b<T> implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.b f25914b;

        public b(wj.b bVar) {
            this.f25914b = bVar;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25914b.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public static class c<T> implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.b f25915b;

        /* renamed from: c */
        public final /* synthetic */ wj.b f25916c;

        public c(wj.b bVar, wj.b bVar2) {
            this.f25915b = bVar;
            this.f25916c = bVar2;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f25915b.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25916c.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }
}
