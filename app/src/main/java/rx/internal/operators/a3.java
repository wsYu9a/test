package rx.internal.operators;

import java.util.Iterator;
import rx.a;

/* loaded from: classes5.dex */
public final class a3<T1, T2, R> implements a.n0<R, T1> {

    /* renamed from: a */
    final Iterable<? extends T2> f35878a;

    /* renamed from: b */
    final rx.k.p<? super T1, ? super T2, ? extends R> f35879b;

    class a extends rx.g<T1> {

        /* renamed from: f */
        boolean f35880f;

        /* renamed from: g */
        final /* synthetic */ rx.g f35881g;

        /* renamed from: h */
        final /* synthetic */ Iterator f35882h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2, Iterator it) {
            super(gVar);
            this.f35881g = gVar2;
            this.f35882h = it;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f35880f) {
                return;
            }
            this.f35880f = true;
            this.f35881g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35881g.onError(th);
        }

        @Override // rx.b
        public void onNext(T1 t1) {
            try {
                this.f35881g.onNext(a3.this.f35879b.call(t1, (Object) this.f35882h.next()));
                if (this.f35882h.hasNext()) {
                    return;
                }
                onCompleted();
            } catch (Throwable th) {
                onError(th);
            }
        }
    }

    public a3(Iterable<? extends T2> iterable, rx.k.p<? super T1, ? super T2, ? extends R> pVar) {
        this.f35878a = iterable;
        this.f35879b = pVar;
    }

    @Override // rx.k.o
    public rx.g<? super T1> call(rx.g<? super R> gVar) {
        Iterator<? extends T2> it = this.f35878a.iterator();
        try {
            if (!it.hasNext()) {
                gVar.onCompleted();
                return rx.l.e.d();
            }
        } catch (Throwable th) {
            gVar.onError(th);
        }
        return new a(gVar, gVar, it);
    }
}
