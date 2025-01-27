package xj;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class v1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32759b;

    /* renamed from: c */
    public final TimeUnit f32760c;

    /* renamed from: d */
    public final qj.d f32761d;

    public class a implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ AtomicBoolean f32762b;

        public a(AtomicBoolean atomicBoolean) {
            this.f32762b = atomicBoolean;
        }

        @Override // wj.a
        public void call() {
            this.f32762b.set(true);
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f32764g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32765h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, AtomicBoolean atomicBoolean, qj.g gVar2) {
            super(gVar);
            this.f32764g = atomicBoolean;
            this.f32765h = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                this.f32765h.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                this.f32765h.onError(th2);
            } finally {
                unsubscribe();
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32764g.get()) {
                this.f32765h.onNext(t10);
            }
        }
    }

    public v1(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32759b = j10;
        this.f32760c = timeUnit;
        this.f32761d = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32761d.a();
        gVar.b(a10);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a10.c(new a(atomicBoolean), this.f32759b, this.f32760c);
        return new b(gVar, atomicBoolean, gVar);
    }
}
