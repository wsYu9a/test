package xj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class c {

    public static class a<T> implements Iterable<T> {

        /* renamed from: b */
        public final /* synthetic */ Object f32085b;

        /* renamed from: c */
        public final /* synthetic */ qj.a f32086c;

        public a(Object obj, qj.a aVar) {
            this.f32085b = obj;
            this.f32086c = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            b bVar = new b(this.f32085b, null);
            this.f32086c.K3(bVar);
            return bVar.g();
        }
    }

    public static final class b<T> extends qj.g<T> {

        /* renamed from: g */
        public final NotificationLite<T> f32087g;

        /* renamed from: h */
        public volatile Object f32088h;

        public class a implements Iterator<T> {

            /* renamed from: b */
            public Object f32089b = null;

            public a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f32089b = b.this.f32088h;
                return !b.this.f32087g.g(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f32089b == null) {
                        this.f32089b = b.this.f32088h;
                    }
                    if (b.this.f32087g.g(this.f32089b)) {
                        throw new NoSuchElementException();
                    }
                    if (b.this.f32087g.h(this.f32089b)) {
                        throw vj.a.c(b.this.f32087g.d(this.f32089b));
                    }
                    T e10 = b.this.f32087g.e(this.f32089b);
                    this.f32089b = null;
                    return e10;
                } catch (Throwable th2) {
                    this.f32089b = null;
                    throw th2;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public /* synthetic */ b(Object obj, a aVar) {
            this(obj);
        }

        public Iterator<T> g() {
            return new a();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32088h = this.f32087g.b();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32088h = this.f32087g.c(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32088h = this.f32087g.l(t10);
        }

        public b(T t10) {
            NotificationLite<T> f10 = NotificationLite.f();
            this.f32087g = f10;
            this.f32088h = f10.l(t10);
        }
    }

    public c() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(qj.a<? extends T> aVar, T t10) {
        return new a(t10, aVar);
    }
}
