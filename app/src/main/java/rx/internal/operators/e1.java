package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.a;

/* loaded from: classes5.dex */
public class e1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.b<? super T> f36006a;

    class a implements rx.c {

        /* renamed from: a */
        final /* synthetic */ AtomicLong f36007a;

        a(AtomicLong atomicLong) {
            this.f36007a = atomicLong;
        }

        @Override // rx.c
        public void request(long j2) {
            rx.internal.operators.a.a(this.f36007a, j2);
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36009f;

        /* renamed from: g */
        final /* synthetic */ AtomicLong f36010g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, rx.g gVar2, AtomicLong atomicLong) {
            super(gVar);
            this.f36009f = gVar2;
            this.f36010g = atomicLong;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36009f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36009f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36010g.get() > 0) {
                this.f36009f.onNext(t);
                this.f36010g.decrementAndGet();
            } else if (e1.this.f36006a != null) {
                e1.this.f36006a.call(t);
            }
        }
    }

    private static final class c {

        /* renamed from: a */
        static final e1<Object> f36012a = new e1<>((a) null);

        private c() {
        }
    }

    /* synthetic */ e1(a aVar) {
        this();
    }

    public static <T> e1<T> b() {
        return (e1<T>) c.f36012a;
    }

    private e1() {
        this((rx.k.b) null);
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        AtomicLong atomicLong = new AtomicLong();
        gVar.f(new a(atomicLong));
        return new b(gVar, gVar, atomicLong);
    }

    public e1(rx.k.b<? super T> bVar) {
        this.f36006a = bVar;
    }
}
