package xj;

import java.util.concurrent.atomic.AtomicLong;
import qj.a;

/* loaded from: classes5.dex */
public final class b2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f32071b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public int f32072g = 0;

        /* renamed from: h */
        public boolean f32073h = false;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32074i;

        /* renamed from: xj.b2$a$a */
        public class C0814a implements qj.c {

            /* renamed from: b */
            public final AtomicLong f32076b = new AtomicLong(0);

            /* renamed from: c */
            public final /* synthetic */ qj.c f32077c;

            public C0814a(qj.c cVar) {
                this.f32077c = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                long j11;
                long min;
                if (j10 <= 0 || a.this.f32073h) {
                    return;
                }
                do {
                    j11 = this.f32076b.get();
                    min = Math.min(j10, b2.this.f32071b - j11);
                    if (min == 0) {
                        return;
                    }
                } while (!this.f32076b.compareAndSet(j11, j11 + min));
                this.f32077c.request(min);
            }
        }

        public a(qj.g gVar) {
            this.f32074i = gVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32074i.f(new C0814a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32073h) {
                return;
            }
            this.f32074i.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32073h) {
                return;
            }
            this.f32074i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (isUnsubscribed()) {
                return;
            }
            int i10 = this.f32072g + 1;
            this.f32072g = i10;
            if (i10 >= b2.this.f32071b) {
                this.f32073h = true;
            }
            this.f32074i.onNext(t10);
            if (this.f32073h) {
                this.f32074i.onCompleted();
                unsubscribe();
            }
        }
    }

    public b2(int i10) {
        this.f32071b = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        if (this.f32071b == 0) {
            gVar.onCompleted();
            aVar.unsubscribe();
        }
        gVar.b(aVar);
        return aVar;
    }
}
