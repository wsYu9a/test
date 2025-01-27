package xj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import qj.a;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class r2<T> implements a.n0<List<T>, T> {

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32605g = false;

        /* renamed from: h */
        public List<T> f32606h = new LinkedList();

        /* renamed from: i */
        public final /* synthetic */ SingleDelayedProducer f32607i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32608j;

        public a(SingleDelayedProducer singleDelayedProducer, qj.g gVar) {
            this.f32607i = singleDelayedProducer;
            this.f32608j = gVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32605g) {
                return;
            }
            this.f32605g = true;
            try {
                ArrayList arrayList = new ArrayList(this.f32606h);
                this.f32606h = null;
                this.f32607i.setValue(arrayList);
            } catch (Throwable th2) {
                onError(th2);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32608j.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32605g) {
                return;
            }
            this.f32606h.add(t10);
        }
    }

    public static final class b {

        /* renamed from: a */
        public static final r2<Object> f32610a = new r2<>(null);
    }

    public /* synthetic */ r2(a aVar) {
        this();
    }

    public static <T> r2<T> a() {
        return (r2<T>) b.f32610a;
    }

    public r2() {
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        a aVar = new a(singleDelayedProducer, gVar);
        gVar.b(aVar);
        gVar.f(singleDelayedProducer);
        return aVar;
    }
}
