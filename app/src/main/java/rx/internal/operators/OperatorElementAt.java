package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;

/* loaded from: classes5.dex */
public final class OperatorElementAt<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final int f35791a;

    /* renamed from: b */
    private final boolean f35792b;

    /* renamed from: c */
    private final T f35793c;

    static class InnerProducer extends AtomicBoolean implements rx.c {
        private static final long serialVersionUID = 1;
        final rx.c actual;

        public InnerProducer(rx.c cVar) {
            this.actual = cVar;
        }

        @Override // rx.c
        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j2 <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.request(Long.MAX_VALUE);
        }
    }

    class a extends rx.g<T> {

        /* renamed from: f */
        private int f35794f = 0;

        /* renamed from: g */
        final /* synthetic */ rx.g f35795g;

        a(rx.g gVar) {
            this.f35795g = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35795g.f(new InnerProducer(cVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onCompleted() {
            if (this.f35794f <= OperatorElementAt.this.f35791a) {
                if (OperatorElementAt.this.f35792b) {
                    this.f35795g.onNext(OperatorElementAt.this.f35793c);
                    this.f35795g.onCompleted();
                    return;
                }
                this.f35795g.onError(new IndexOutOfBoundsException(OperatorElementAt.this.f35791a + " is out of bounds"));
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35795g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            int i2 = this.f35794f;
            this.f35794f = i2 + 1;
            if (i2 == OperatorElementAt.this.f35791a) {
                this.f35795g.onNext(t);
                this.f35795g.onCompleted();
                unsubscribe();
            }
        }
    }

    public OperatorElementAt(int i2) {
        this(i2, null, false);
    }

    public OperatorElementAt(int i2, T t) {
        this(i2, t, true);
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }

    private OperatorElementAt(int i2, T t, boolean z) {
        if (i2 >= 0) {
            this.f35791a = i2;
            this.f35793c = t;
            this.f35792b = z;
        } else {
            throw new IndexOutOfBoundsException(i2 + " is out of bounds");
        }
    }
}
