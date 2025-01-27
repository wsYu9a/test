package xj;

import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class o1<R, T> implements a.n0<R, T> {

    /* renamed from: d */
    public static final Object f32493d = new Object();

    /* renamed from: b */
    public final wj.n<R> f32494b;

    /* renamed from: c */
    public final wj.p<R, ? super T, R> f32495c;

    public class a implements wj.n<R> {

        /* renamed from: b */
        public final /* synthetic */ Object f32496b;

        public a(Object obj) {
            this.f32496b = obj;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public R call() {
            return (R) this.f32496b;
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final R f32497g;

        /* renamed from: h */
        public R f32498h;

        /* renamed from: i */
        public boolean f32499i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32500j;

        public class a implements qj.c {

            /* renamed from: b */
            public final AtomicBoolean f32502b = new AtomicBoolean();

            /* renamed from: c */
            public final AtomicBoolean f32503c = new AtomicBoolean();

            /* renamed from: d */
            public final /* synthetic */ qj.c f32504d;

            public a(qj.c cVar) {
                this.f32504d = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                if (!this.f32502b.compareAndSet(false, true)) {
                    if (j10 <= 1 || !this.f32503c.compareAndSet(true, false) || j10 == Long.MAX_VALUE) {
                        this.f32504d.request(j10);
                        return;
                    } else {
                        this.f32504d.request(j10 - 1);
                        return;
                    }
                }
                if (b.this.f32497g == o1.f32493d || j10 == Long.MAX_VALUE) {
                    this.f32504d.request(j10);
                } else if (j10 != 1) {
                    this.f32504d.request(j10 - 1);
                } else {
                    this.f32503c.set(true);
                    this.f32504d.request(1L);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32500j = gVar2;
            R r10 = (R) o1.this.f32494b.call();
            this.f32497g = r10;
            this.f32498h = r10;
            this.f32499i = false;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32500j.f(new a(cVar));
        }

        public final void h(qj.g<? super R> gVar) {
            if (this.f32499i) {
                return;
            }
            this.f32499i = true;
            if (this.f32497g != o1.f32493d) {
                gVar.onNext(this.f32497g);
            }
        }

        @Override // qj.b
        public void onCompleted() {
            h(this.f32500j);
            this.f32500j.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32500j.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            h(this.f32500j);
            if (this.f32498h == o1.f32493d) {
                this.f32498h = t10;
            } else {
                try {
                    this.f32498h = (R) o1.this.f32495c.call(this.f32498h, t10);
                } catch (Throwable th2) {
                    vj.a.e(th2);
                    this.f32500j.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
                    return;
                }
            }
            this.f32500j.onNext(this.f32498h);
        }
    }

    public o1(R r10, wj.p<R, ? super T, R> pVar) {
        this((wj.n) new a(r10), (wj.p) pVar);
    }

    public o1(wj.n<R> nVar, wj.p<R, ? super T, R> pVar) {
        this.f32494b = nVar;
        this.f32495c = pVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super R> gVar) {
        return new b(gVar, gVar);
    }

    public o1(wj.p<R, ? super T, R> pVar) {
        this(f32493d, pVar);
    }
}
