package ek;

import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public final class e {

    public static class a<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.b f25933g;

        public a(qj.b bVar) {
            this.f25933g = bVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f25933g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f25933g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f25933g.onNext(t10);
        }
    }

    public static class d<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.a f25937g;

        /* renamed from: h */
        public final /* synthetic */ wj.b f25938h;

        /* renamed from: i */
        public final /* synthetic */ wj.b f25939i;

        public d(wj.a aVar, wj.b bVar, wj.b bVar2) {
            this.f25937g = aVar;
            this.f25938h = bVar;
            this.f25939i = bVar2;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f25937g.call();
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f25938h.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25939i.call(t10);
        }
    }

    /* renamed from: ek.e$e */
    public static class C0695e<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f25940g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0695e(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f25940g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f25940g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f25940g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f25940g.onNext(t10);
        }
    }

    public e() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T> qj.g<T> a(wj.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static final <T> qj.g<T> b(wj.b<? super T> bVar, wj.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static final <T> qj.g<T> c(wj.b<? super T> bVar, wj.b<Throwable> bVar2, wj.a aVar) {
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

    public static <T> qj.g<T> d() {
        return e(ek.a.d());
    }

    public static <T> qj.g<T> e(qj.b<? super T> bVar) {
        return new a(bVar);
    }

    @uj.b
    public static <T> qj.g<T> f(qj.g<? super T> gVar) {
        return new C0695e(gVar, gVar);
    }

    public static class b<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f25934g;

        public b(wj.b bVar) {
            this.f25934g = bVar;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25934g.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public static class c<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f25935g;

        /* renamed from: h */
        public final /* synthetic */ wj.b f25936h;

        public c(wj.b bVar, wj.b bVar2) {
            this.f25935g = bVar;
            this.f25936h = bVar2;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f25935g.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f25936h.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }
}
