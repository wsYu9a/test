package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class z1<T> implements a.n0<T, rx.a<? extends T>> {

    private static final class b {

        /* renamed from: a */
        static final z1<Object> f36694a = new z1<>();

        private b() {
        }
    }

    private static final class c<T> extends rx.g<rx.a<? extends T>> {

        /* renamed from: f */
        final rx.l.d<T> f36695f;

        /* renamed from: g */
        final rx.p.e f36696g;

        /* renamed from: j */
        int f36699j;
        boolean k;
        boolean l;
        List<Object> m;
        boolean n;
        c<T>.b o;
        long p;

        /* renamed from: h */
        final Object f36697h = new Object();

        /* renamed from: i */
        final NotificationLite<?> f36698i = NotificationLite.f();
        volatile boolean q = false;

        class a implements rx.c {
            a() {
            }

            @Override // rx.c
            public void request(long j2) {
                c<T>.b bVar;
                if (c.this.q) {
                    return;
                }
                if (j2 == Long.MAX_VALUE) {
                    c.this.q = true;
                }
                synchronized (c.this.f36697h) {
                    c cVar = c.this;
                    bVar = cVar.o;
                    if (bVar == null) {
                        long j3 = cVar.p + j2;
                        if (j3 < 0) {
                            cVar.q = true;
                        } else {
                            cVar.p = j3;
                        }
                    } else {
                        long j4 = ((b) bVar).f36701f + j2;
                        if (j4 < 0) {
                            c.this.q = true;
                        } else {
                            ((b) c.this.o).f36701f = j4;
                        }
                    }
                }
                if (bVar != null) {
                    if (c.this.q) {
                        bVar.j(Long.MAX_VALUE);
                    } else {
                        bVar.j(j2);
                    }
                }
            }
        }

        final class b extends rx.g<T> {

            /* renamed from: f */
            private long f36701f = 0;

            /* renamed from: g */
            private final int f36702g;

            /* renamed from: h */
            private final long f36703h;

            public b(int i2, long j2) {
                this.f36702g = i2;
                this.f36703h = j2;
            }

            static /* synthetic */ long i(b bVar) {
                long j2 = bVar.f36701f;
                bVar.f36701f = j2 - 1;
                return j2;
            }

            @Override // rx.g
            public void d() {
                j(this.f36703h);
            }

            public void j(long j2) {
                e(j2);
            }

            @Override // rx.b
            public void onCompleted() {
                c.this.g(this.f36702g);
            }

            @Override // rx.b
            public void onError(Throwable th) {
                c.this.j(th, this.f36702g);
            }

            @Override // rx.b
            public void onNext(T t) {
                c.this.i(t, this.f36702g, this);
            }
        }

        public c(rx.g<? super T> gVar) {
            this.f36695f = new rx.l.d<>(gVar);
            rx.p.e eVar = new rx.p.e();
            this.f36696g = eVar;
            gVar.b(eVar);
            gVar.f(new a());
        }

        void g(int i2) {
            synchronized (this.f36697h) {
                if (i2 != this.f36699j) {
                    return;
                }
                this.k = false;
                if (this.l) {
                    if (this.n) {
                        if (this.m == null) {
                            this.m = new ArrayList();
                        }
                        this.m.add(this.f36698i.b());
                    } else {
                        List<Object> list = this.m;
                        this.m = null;
                        this.n = true;
                        h(list);
                        this.f36695f.onCompleted();
                        unsubscribe();
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void h(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (this.f36698i.g(obj)) {
                    this.f36695f.onCompleted();
                    return;
                } else {
                    if (this.f36698i.h(obj)) {
                        this.f36695f.onError(this.f36698i.d(obj));
                        return;
                    }
                    this.f36695f.onNext(obj);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x006c, code lost:
        
            if (r8.f36695f.isUnsubscribed() == false) goto L157;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x006e, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0061, code lost:
        
            r8.n = false;
         */
        /* JADX WARN: Removed duplicated region for block: B:78:0x008a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void i(T r9, int r10, rx.internal.operators.z1.c<T>.b r11) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f36697h
                monitor-enter(r0)
                int r1 = r8.f36699j     // Catch: java.lang.Throwable -> L95
                if (r10 == r1) goto L9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
                return
            L9:
                boolean r10 = r8.n     // Catch: java.lang.Throwable -> L95
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r10 == 0) goto L2f
                java.util.List<java.lang.Object> r10 = r8.m     // Catch: java.lang.Throwable -> L95
                if (r10 != 0) goto L1d
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L95
                r10.<init>()     // Catch: java.lang.Throwable -> L95
                r8.m = r10     // Catch: java.lang.Throwable -> L95
            L1d:
                long r3 = rx.internal.operators.z1.c.b.g(r11)     // Catch: java.lang.Throwable -> L95
                int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r10 == 0) goto L28
                rx.internal.operators.z1.c.b.i(r11)     // Catch: java.lang.Throwable -> L95
            L28:
                java.util.List<java.lang.Object> r10 = r8.m     // Catch: java.lang.Throwable -> L95
                r10.add(r9)     // Catch: java.lang.Throwable -> L95
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
                return
            L2f:
                java.util.List<java.lang.Object> r10 = r8.m     // Catch: java.lang.Throwable -> L95
                r3 = 0
                r8.m = r3     // Catch: java.lang.Throwable -> L95
                r4 = 1
                r8.n = r4     // Catch: java.lang.Throwable -> L95
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
                r0 = 1
            L39:
                r5 = 0
                r8.h(r10)     // Catch: java.lang.Throwable -> L86
                if (r0 == 0) goto L58
                java.lang.Object r10 = r8.f36697h     // Catch: java.lang.Throwable -> L86
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L86
                long r6 = rx.internal.operators.z1.c.b.g(r11)     // Catch: java.lang.Throwable -> L55
                int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r0 == 0) goto L4d
                rx.internal.operators.z1.c.b.i(r11)     // Catch: java.lang.Throwable -> L55
            L4d:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L55
                rx.l.d<T> r10 = r8.f36695f     // Catch: java.lang.Throwable -> L86
                r10.onNext(r9)     // Catch: java.lang.Throwable -> L86
                r0 = 0
                goto L58
            L55:
                r9 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L55
                throw r9     // Catch: java.lang.Throwable -> L86
            L58:
                java.lang.Object r10 = r8.f36697h     // Catch: java.lang.Throwable -> L86
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L86
                java.util.List<java.lang.Object> r6 = r8.m     // Catch: java.lang.Throwable -> L7e
                r8.m = r3     // Catch: java.lang.Throwable -> L7e
                if (r6 != 0) goto L65
                r8.n = r5     // Catch: java.lang.Throwable -> L7e
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
                goto L6f
            L65:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
                rx.l.d<T> r10 = r8.f36695f     // Catch: java.lang.Throwable -> L86
                boolean r10 = r10.isUnsubscribed()     // Catch: java.lang.Throwable -> L86
                if (r10 == 0) goto L7c
                r4 = 0
            L6f:
                if (r4 != 0) goto L7b
                java.lang.Object r9 = r8.f36697h
                monitor-enter(r9)
                r8.n = r5     // Catch: java.lang.Throwable -> L78
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L78
                goto L7b
            L78:
                r10 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L78
                throw r10
            L7b:
                return
            L7c:
                r10 = r6
                goto L39
            L7e:
                r9 = move-exception
                r4 = 0
            L80:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
                throw r9     // Catch: java.lang.Throwable -> L82
            L82:
                r9 = move-exception
                goto L88
            L84:
                r9 = move-exception
                goto L80
            L86:
                r9 = move-exception
                r4 = 0
            L88:
                if (r4 != 0) goto L94
                java.lang.Object r10 = r8.f36697h
                monitor-enter(r10)
                r8.n = r5     // Catch: java.lang.Throwable -> L91
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L91
                goto L94
            L91:
                r9 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L91
                throw r9
            L94:
                throw r9
            L95:
                r9 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
                goto L99
            L98:
                throw r9
            L99:
                goto L98
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.z1.c.i(java.lang.Object, int, rx.internal.operators.z1$c$b):void");
        }

        void j(Throwable th, int i2) {
            synchronized (this.f36697h) {
                if (i2 != this.f36699j) {
                    return;
                }
                if (this.n) {
                    if (this.m == null) {
                        this.m = new ArrayList();
                    }
                    this.m.add(this.f36698i.c(th));
                } else {
                    List<Object> list = this.m;
                    this.m = null;
                    this.n = true;
                    h(list);
                    this.f36695f.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.b
        /* renamed from: k */
        public void onNext(rx.a<? extends T> aVar) {
            long j2;
            synchronized (this.f36697h) {
                int i2 = this.f36699j + 1;
                this.f36699j = i2;
                this.k = true;
                if (this.q) {
                    j2 = Long.MAX_VALUE;
                } else {
                    c<T>.b bVar = this.o;
                    j2 = bVar == null ? this.p : ((b) bVar).f36701f;
                }
                c<T>.b bVar2 = new b(i2, j2);
                this.o = bVar2;
                ((b) bVar2).f36701f = j2;
            }
            this.f36696g.b(this.o);
            aVar.T4(this.o);
        }

        @Override // rx.b
        public void onCompleted() {
            synchronized (this.f36697h) {
                this.l = true;
                if (this.k) {
                    return;
                }
                if (this.n) {
                    if (this.m == null) {
                        this.m = new ArrayList();
                    }
                    this.m.add(this.f36698i.b());
                } else {
                    List<Object> list = this.m;
                    this.m = null;
                    this.n = true;
                    h(list);
                    this.f36695f.onCompleted();
                    unsubscribe();
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36695f.onError(th);
            unsubscribe();
        }
    }

    /* synthetic */ z1(a aVar) {
        this();
    }

    public static <T> z1<T> a() {
        return (z1<T>) b.f36694a;
    }

    private z1() {
    }

    @Override // rx.k.o
    public rx.g<? super rx.a<? extends T>> call(rx.g<? super T> gVar) {
        c cVar = new c(gVar);
        gVar.b(cVar);
        return cVar;
    }
}
