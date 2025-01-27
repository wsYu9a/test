package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.a;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class s2<T> implements a.n0<List<T>, T> {

    /* renamed from: a */
    private static Comparator f36430a = new c(null);

    /* renamed from: b */
    private final Comparator<? super T> f36431b;

    /* renamed from: c */
    private final int f36432c;

    class a implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.p f36433a;

        a(rx.k.p pVar) {
            this.f36433a = pVar;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.f36433a.call(t, t2)).intValue();
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        List<T> f36435f;

        /* renamed from: g */
        boolean f36436g;

        /* renamed from: h */
        final /* synthetic */ SingleDelayedProducer f36437h;

        /* renamed from: i */
        final /* synthetic */ rx.g f36438i;

        b(SingleDelayedProducer singleDelayedProducer, rx.g gVar) {
            this.f36437h = singleDelayedProducer;
            this.f36438i = gVar;
            this.f36435f = new ArrayList(s2.this.f36432c);
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36436g) {
                return;
            }
            this.f36436g = true;
            List<T> list = this.f36435f;
            this.f36435f = null;
            try {
                Collections.sort(list, s2.this.f36431b);
                this.f36437h.setValue(list);
            } catch (Throwable th) {
                onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36438i.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36436g) {
                return;
            }
            this.f36435f.add(t);
        }
    }

    private static class c implements Comparator<Object> {
        private c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public s2(int i2) {
        this.f36431b = f36430a;
        this.f36432c = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        b bVar = new b(singleDelayedProducer, gVar);
        gVar.b(bVar);
        gVar.f(singleDelayedProducer);
        return bVar;
    }

    public s2(rx.k.p<? super T, ? super T, Integer> pVar, int i2) {
        this.f36432c = i2;
        this.f36431b = new a(pVar);
    }
}
