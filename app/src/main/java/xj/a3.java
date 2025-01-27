package xj;

import java.util.Iterator;
import qj.a;

/* loaded from: classes5.dex */
public final class a3<T1, T2, R> implements a.n0<R, T1> {

    /* renamed from: b */
    public final Iterable<? extends T2> f32039b;

    /* renamed from: c */
    public final wj.p<? super T1, ? super T2, ? extends R> f32040c;

    public class a extends qj.g<T1> {

        /* renamed from: g */
        public boolean f32041g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32042h;

        /* renamed from: i */
        public final /* synthetic */ Iterator f32043i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2, Iterator it) {
            super(gVar);
            this.f32042h = gVar2;
            this.f32043i = it;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32041g) {
                return;
            }
            this.f32041g = true;
            this.f32042h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32042h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T1 t12) {
            try {
                this.f32042h.onNext(a3.this.f32040c.call(t12, (Object) this.f32043i.next()));
                if (this.f32043i.hasNext()) {
                    return;
                }
                onCompleted();
            } catch (Throwable th2) {
                onError(th2);
            }
        }
    }

    public a3(Iterable<? extends T2> iterable, wj.p<? super T1, ? super T2, ? extends R> pVar) {
        this.f32039b = iterable;
        this.f32040c = pVar;
    }

    @Override // wj.o
    public qj.g<? super T1> call(qj.g<? super R> gVar) {
        Iterator<? extends T2> it = this.f32039b.iterator();
        try {
            if (!it.hasNext()) {
                gVar.onCompleted();
                return ek.e.d();
            }
        } catch (Throwable th2) {
            gVar.onError(th2);
        }
        return new a(gVar, gVar, it);
    }
}
