package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;

/* loaded from: classes5.dex */
public class v<T> implements e.j<T> {

    /* renamed from: a */
    private final rx.a<T> f36521a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36522f = false;

        /* renamed from: g */
        private boolean f36523g = false;

        /* renamed from: h */
        private T f36524h = null;

        /* renamed from: i */
        final /* synthetic */ rx.f f36525i;

        a(rx.f fVar) {
            this.f36525i = fVar;
        }

        @Override // rx.g
        public void d() {
            e(2L);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36522f) {
                return;
            }
            if (this.f36523g) {
                this.f36525i.c(this.f36524h);
            } else {
                this.f36525i.b(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36525i.b(th);
            unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            if (!this.f36523g) {
                this.f36523g = true;
                this.f36524h = t;
            } else {
                this.f36522f = true;
                this.f36525i.b(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
            }
        }
    }

    public v(rx.a<T> aVar) {
        this.f36521a = aVar;
    }

    public static <T> v<T> a(rx.a<T> aVar) {
        return new v<>(aVar);
    }

    @Override // rx.k.b
    public void call(rx.f<? super T> fVar) {
        a aVar = new a(fVar);
        fVar.a(aVar);
        this.f36521a.T4(aVar);
    }
}
