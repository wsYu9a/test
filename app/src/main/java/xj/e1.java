package xj;

import java.util.concurrent.atomic.AtomicLong;
import qj.a;

/* loaded from: classes5.dex */
public class e1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.b<? super T> f32180b;

    public class a implements qj.c {

        /* renamed from: b */
        public final /* synthetic */ AtomicLong f32181b;

        public a(AtomicLong atomicLong) {
            this.f32181b = atomicLong;
        }

        @Override // qj.c
        public void request(long j10) {
            xj.a.a(this.f32181b, j10);
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32183g;

        /* renamed from: h */
        public final /* synthetic */ AtomicLong f32184h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, qj.g gVar2, AtomicLong atomicLong) {
            super(gVar);
            this.f32183g = gVar2;
            this.f32184h = atomicLong;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32183g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32183g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32184h.get() > 0) {
                this.f32183g.onNext(t10);
                this.f32184h.decrementAndGet();
            } else if (e1.this.f32180b != null) {
                e1.this.f32180b.call(t10);
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final e1<Object> f32186a = new e1<>((a) null);
    }

    public /* synthetic */ e1(a aVar) {
        this();
    }

    public static <T> e1<T> b() {
        return (e1<T>) c.f32186a;
    }

    public e1() {
        this((wj.b) null);
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        AtomicLong atomicLong = new AtomicLong();
        gVar.f(new a(atomicLong));
        return new b(gVar, gVar, atomicLong);
    }

    public e1(wj.b<? super T> bVar) {
        this.f32180b = bVar;
    }
}
