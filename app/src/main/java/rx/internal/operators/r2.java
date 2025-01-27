package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.a;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class r2<T> implements a.n0<List<T>, T> {

    class a extends rx.g<T> {

        /* renamed from: f */
        boolean f36412f = false;

        /* renamed from: g */
        List<T> f36413g = new LinkedList();

        /* renamed from: h */
        final /* synthetic */ SingleDelayedProducer f36414h;

        /* renamed from: i */
        final /* synthetic */ rx.g f36415i;

        a(SingleDelayedProducer singleDelayedProducer, rx.g gVar) {
            this.f36414h = singleDelayedProducer;
            this.f36415i = gVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36412f) {
                return;
            }
            this.f36412f = true;
            try {
                ArrayList arrayList = new ArrayList(this.f36413g);
                this.f36413g = null;
                this.f36414h.setValue(arrayList);
            } catch (Throwable th) {
                onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36415i.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36412f) {
                return;
            }
            this.f36413g.add(t);
        }
    }

    private static final class b {

        /* renamed from: a */
        static final r2<Object> f36417a = new r2<>(null);

        private b() {
        }
    }

    /* synthetic */ r2(a aVar) {
        this();
    }

    public static <T> r2<T> a() {
        return (r2<T>) b.f36417a;
    }

    private r2() {
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        a aVar = new a(singleDelayedProducer, gVar);
        gVar.b(aVar);
        gVar.f(singleDelayedProducer);
        return aVar;
    }
}
