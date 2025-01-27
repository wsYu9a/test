package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class c {

    static class a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ Object f35917a;

        /* renamed from: b */
        final /* synthetic */ rx.a f35918b;

        a(Object obj, rx.a aVar) {
            this.f35917a = obj;
            this.f35918b = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            b bVar = new b(this.f35917a, null);
            this.f35918b.K3(bVar);
            return bVar.g();
        }
    }

    private static final class b<T> extends rx.g<T> {

        /* renamed from: f */
        final NotificationLite<T> f35919f;

        /* renamed from: g */
        volatile Object f35920g;

        class a implements Iterator<T> {

            /* renamed from: a */
            private Object f35921a = null;

            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f35921a = b.this.f35920g;
                return !b.this.f35919f.g(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f35921a == null) {
                        this.f35921a = b.this.f35920g;
                    }
                    if (b.this.f35919f.g(this.f35921a)) {
                        throw new NoSuchElementException();
                    }
                    if (b.this.f35919f.h(this.f35921a)) {
                        throw rx.exceptions.a.c(b.this.f35919f.d(this.f35921a));
                    }
                    return b.this.f35919f.e(this.f35921a);
                } finally {
                    this.f35921a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        /* synthetic */ b(Object obj, a aVar) {
            this(obj);
        }

        public Iterator<T> g() {
            return new a();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35920g = this.f35919f.b();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35920g = this.f35919f.c(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35920g = this.f35919f.l(t);
        }

        private b(T t) {
            NotificationLite<T> f2 = NotificationLite.f();
            this.f35919f = f2;
            this.f35920g = f2.l(t);
        }
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.a<? extends T> aVar, T t) {
        return new a(t, aVar);
    }
}
