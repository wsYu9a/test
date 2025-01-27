package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class j0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32321b;

    /* renamed from: c */
    public final TimeUnit f32322c;

    /* renamed from: d */
    public final qj.d f32323d;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final b<T> f32324g;

        /* renamed from: h */
        public final qj.g<?> f32325h;

        /* renamed from: i */
        public final /* synthetic */ ik.e f32326i;

        /* renamed from: j */
        public final /* synthetic */ d.a f32327j;

        /* renamed from: k */
        public final /* synthetic */ ek.d f32328k;

        /* renamed from: xj.j0$a$a */
        public class C0823a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ int f32330b;

            public C0823a(int i10) {
                this.f32330b = i10;
            }

            @Override // wj.a
            public void call() {
                a aVar = a.this;
                aVar.f32324g.b(this.f32330b, aVar.f32328k, aVar.f32325h);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, ik.e eVar, d.a aVar, ek.d dVar) {
            super(gVar);
            this.f32326i = eVar;
            this.f32327j = aVar;
            this.f32328k = dVar;
            this.f32324g = new b<>();
            this.f32325h = this;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32324g.c(this.f32328k, this);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32328k.onError(th2);
            unsubscribe();
            this.f32324g.a();
        }

        @Override // qj.b
        public void onNext(T t10) {
            int d10 = this.f32324g.d(t10);
            ik.e eVar = this.f32326i;
            d.a aVar = this.f32327j;
            C0823a c0823a = new C0823a(d10);
            j0 j0Var = j0.this;
            eVar.b(aVar.c(c0823a, j0Var.f32321b, j0Var.f32322c));
        }
    }

    public static final class b<T> {

        /* renamed from: a */
        public int f32332a;

        /* renamed from: b */
        public T f32333b;

        /* renamed from: c */
        public boolean f32334c;

        /* renamed from: d */
        public boolean f32335d;

        /* renamed from: e */
        public boolean f32336e;

        public synchronized void a() {
            this.f32332a++;
            this.f32333b = null;
            this.f32334c = false;
        }

        public void b(int i10, qj.g<T> gVar, qj.g<?> gVar2) {
            synchronized (this) {
                if (!this.f32336e && this.f32334c && i10 == this.f32332a) {
                    T t10 = this.f32333b;
                    this.f32333b = null;
                    this.f32334c = false;
                    this.f32336e = true;
                    try {
                        gVar.onNext(t10);
                        synchronized (this) {
                            try {
                                if (this.f32335d) {
                                    gVar.onCompleted();
                                } else {
                                    this.f32336e = false;
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th2) {
                        gVar2.onError(th2);
                    }
                }
            }
        }

        public void c(qj.g<T> gVar, qj.g<?> gVar2) {
            synchronized (this) {
                try {
                    if (this.f32336e) {
                        this.f32335d = true;
                        return;
                    }
                    T t10 = this.f32333b;
                    boolean z10 = this.f32334c;
                    this.f32333b = null;
                    this.f32334c = false;
                    this.f32336e = true;
                    if (z10) {
                        try {
                            gVar.onNext(t10);
                        } catch (Throwable th2) {
                            gVar2.onError(th2);
                            return;
                        }
                    }
                    gVar.onCompleted();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public synchronized int d(T t10) {
            int i10;
            this.f32333b = t10;
            this.f32334c = true;
            i10 = this.f32332a + 1;
            this.f32332a = i10;
            return i10;
        }
    }

    public j0(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32321b = j10;
        this.f32322c = timeUnit;
        this.f32323d = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32323d.a();
        ek.d dVar = new ek.d(gVar);
        ik.e eVar = new ik.e();
        dVar.b(a10);
        dVar.b(eVar);
        return new a(gVar, eVar, a10, dVar);
    }
}
