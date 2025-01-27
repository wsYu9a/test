package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;
import qj.c;
import qj.g;

/* loaded from: classes5.dex */
public final class OperatorElementAt<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f30462b;

    /* renamed from: c */
    public final boolean f30463c;

    /* renamed from: d */
    public final T f30464d;

    public static class InnerProducer extends AtomicBoolean implements c {
        private static final long serialVersionUID = 1;
        final c actual;

        public InnerProducer(c cVar) {
            this.actual = cVar;
        }

        @Override // qj.c
        public void request(long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j10 <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.request(Long.MAX_VALUE);
        }
    }

    public class a extends g<T> {

        /* renamed from: g */
        public int f30465g = 0;

        /* renamed from: h */
        public final /* synthetic */ g f30466h;

        public a(g gVar) {
            this.f30466h = gVar;
        }

        @Override // qj.g
        public void f(c cVar) {
            this.f30466h.f(new InnerProducer(cVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onCompleted() {
            if (this.f30465g <= OperatorElementAt.this.f30462b) {
                if (OperatorElementAt.this.f30463c) {
                    this.f30466h.onNext(OperatorElementAt.this.f30464d);
                    this.f30466h.onCompleted();
                    return;
                }
                this.f30466h.onError(new IndexOutOfBoundsException(OperatorElementAt.this.f30462b + " is out of bounds"));
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30466h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            int i10 = this.f30465g;
            this.f30465g = i10 + 1;
            if (i10 == OperatorElementAt.this.f30462b) {
                this.f30466h.onNext(t10);
                this.f30466h.onCompleted();
                unsubscribe();
            }
        }
    }

    public OperatorElementAt(int i10) {
        this(i10, null, false);
    }

    public OperatorElementAt(int i10, T t10) {
        this(i10, t10, true);
    }

    @Override // wj.o
    public g<? super T> call(g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }

    public OperatorElementAt(int i10, T t10, boolean z10) {
        if (i10 >= 0) {
            this.f30462b = i10;
            this.f30464d = t10;
            this.f30463c = z10;
        } else {
            throw new IndexOutOfBoundsException(i10 + " is out of bounds");
        }
    }
}
