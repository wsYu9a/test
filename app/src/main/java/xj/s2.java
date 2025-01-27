package xj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import qj.a;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class s2<T> implements a.n0<List<T>, T> {

    /* renamed from: d */
    public static Comparator f32623d = new c(null);

    /* renamed from: b */
    public final Comparator<? super T> f32624b;

    /* renamed from: c */
    public final int f32625c;

    public class a implements Comparator<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.p f32626b;

        public a(wj.p pVar) {
            this.f32626b = pVar;
        }

        @Override // java.util.Comparator
        public int compare(T t10, T t11) {
            return ((Integer) this.f32626b.call(t10, t11)).intValue();
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public List<T> f32628g;

        /* renamed from: h */
        public boolean f32629h;

        /* renamed from: i */
        public final /* synthetic */ SingleDelayedProducer f32630i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32631j;

        public b(SingleDelayedProducer singleDelayedProducer, qj.g gVar) {
            this.f32630i = singleDelayedProducer;
            this.f32631j = gVar;
            this.f32628g = new ArrayList(s2.this.f32625c);
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32629h) {
                return;
            }
            this.f32629h = true;
            List<T> list = this.f32628g;
            this.f32628g = null;
            try {
                Collections.sort(list, s2.this.f32624b);
                this.f32630i.setValue(list);
            } catch (Throwable th2) {
                onError(th2);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32631j.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32629h) {
                return;
            }
            this.f32628g.add(t10);
        }
    }

    public static class c implements Comparator<Object> {
        public c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public s2(int i10) {
        this.f32624b = f32623d;
        this.f32625c = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        b bVar = new b(singleDelayedProducer, gVar);
        gVar.b(bVar);
        gVar.f(singleDelayedProducer);
        return bVar;
    }

    public s2(wj.p<? super T, ? super T, Integer> pVar, int i10) {
        this.f32625c = i10;
        this.f32624b = new a(pVar);
    }
}
