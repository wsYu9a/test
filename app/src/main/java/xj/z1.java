package xj;

import java.util.ArrayList;
import java.util.List;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class z1<T> implements a.n0<T, qj.a<? extends T>> {

    public static final class b {

        /* renamed from: a */
        public static final z1<Object> f32910a = new z1<>();
    }

    public static final class c<T> extends qj.g<qj.a<? extends T>> {

        /* renamed from: g */
        public final ek.d<T> f32911g;

        /* renamed from: h */
        public final ik.e f32912h;

        /* renamed from: k */
        public int f32915k;

        /* renamed from: l */
        public boolean f32916l;

        /* renamed from: m */
        public boolean f32917m;

        /* renamed from: n */
        public List<Object> f32918n;

        /* renamed from: o */
        public boolean f32919o;

        /* renamed from: p */
        public c<T>.b f32920p;

        /* renamed from: q */
        public long f32921q;

        /* renamed from: i */
        public final Object f32913i = new Object();

        /* renamed from: j */
        public final NotificationLite<?> f32914j = NotificationLite.f();

        /* renamed from: r */
        public volatile boolean f32922r = false;

        public class a implements qj.c {
            public a() {
            }

            @Override // qj.c
            public void request(long j10) {
                c<T>.b bVar;
                if (c.this.f32922r) {
                    return;
                }
                if (j10 == Long.MAX_VALUE) {
                    c.this.f32922r = true;
                }
                synchronized (c.this.f32913i) {
                    try {
                        c cVar = c.this;
                        bVar = cVar.f32920p;
                        if (bVar == null) {
                            long j11 = cVar.f32921q + j10;
                            if (j11 < 0) {
                                cVar.f32922r = true;
                            } else {
                                cVar.f32921q = j11;
                            }
                        } else {
                            long j12 = bVar.f32924g + j10;
                            if (j12 < 0) {
                                c.this.f32922r = true;
                            } else {
                                c.this.f32920p.f32924g = j12;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (bVar != null) {
                    if (c.this.f32922r) {
                        bVar.j(Long.MAX_VALUE);
                    } else {
                        bVar.j(j10);
                    }
                }
            }
        }

        public final class b extends qj.g<T> {

            /* renamed from: g */
            public long f32924g = 0;

            /* renamed from: h */
            public final int f32925h;

            /* renamed from: i */
            public final long f32926i;

            public b(int i10, long j10) {
                this.f32925h = i10;
                this.f32926i = j10;
            }

            public static /* synthetic */ long i(b bVar) {
                long j10 = bVar.f32924g;
                bVar.f32924g = j10 - 1;
                return j10;
            }

            @Override // qj.g
            public void d() {
                j(this.f32926i);
            }

            public void j(long j10) {
                e(j10);
            }

            @Override // qj.b
            public void onCompleted() {
                c.this.g(this.f32925h);
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                c.this.j(th2, this.f32925h);
            }

            @Override // qj.b
            public void onNext(T t10) {
                c.this.i(t10, this.f32925h, this);
            }
        }

        public c(qj.g<? super T> gVar) {
            this.f32911g = new ek.d<>(gVar);
            ik.e eVar = new ik.e();
            this.f32912h = eVar;
            gVar.b(eVar);
            gVar.f(new a());
        }

        public void g(int i10) {
            synchronized (this.f32913i) {
                try {
                    if (i10 != this.f32915k) {
                        return;
                    }
                    this.f32916l = false;
                    if (this.f32917m) {
                        if (this.f32919o) {
                            if (this.f32918n == null) {
                                this.f32918n = new ArrayList();
                            }
                            this.f32918n.add(this.f32914j.b());
                        } else {
                            List<Object> list = this.f32918n;
                            this.f32918n = null;
                            this.f32919o = true;
                            h(list);
                            this.f32911g.onCompleted();
                            unsubscribe();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void h(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (this.f32914j.g(obj)) {
                    this.f32911g.onCompleted();
                    return;
                } else {
                    if (this.f32914j.h(obj)) {
                        this.f32911g.onError(this.f32914j.d(obj));
                        return;
                    }
                    this.f32911g.onNext(obj);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0079, code lost:
        
            if (r8.f32911g.isUnsubscribed() == false) goto L255;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
        
            r10 = r8.f32913i;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x007d, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x007e, code lost:
        
            r8.f32919o = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0080, code lost:
        
            monitor-exit(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0081, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:76:0x008c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i(T r9, int r10, xj.z1.c<T>.b r11) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f32913i
                monitor-enter(r0)
                int r1 = r8.f32915k     // Catch: java.lang.Throwable -> L9
                if (r10 == r1) goto Lc
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
                return
            L9:
                r9 = move-exception
                goto L97
            Lc:
                boolean r10 = r8.f32919o     // Catch: java.lang.Throwable -> L9
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r10 == 0) goto L32
                java.util.List<java.lang.Object> r10 = r8.f32918n     // Catch: java.lang.Throwable -> L9
                if (r10 != 0) goto L20
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9
                r10.<init>()     // Catch: java.lang.Throwable -> L9
                r8.f32918n = r10     // Catch: java.lang.Throwable -> L9
            L20:
                long r3 = xj.z1.c.b.g(r11)     // Catch: java.lang.Throwable -> L9
                int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r10 == 0) goto L2b
                xj.z1.c.b.i(r11)     // Catch: java.lang.Throwable -> L9
            L2b:
                java.util.List<java.lang.Object> r10 = r8.f32918n     // Catch: java.lang.Throwable -> L9
                r10.add(r9)     // Catch: java.lang.Throwable -> L9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
                return
            L32:
                java.util.List<java.lang.Object> r10 = r8.f32918n     // Catch: java.lang.Throwable -> L9
                r3 = 0
                r8.f32918n = r3     // Catch: java.lang.Throwable -> L9
                r4 = 1
                r8.f32919o = r4     // Catch: java.lang.Throwable -> L9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
                r0 = 1
            L3c:
                r5 = 0
                r8.h(r10)     // Catch: java.lang.Throwable -> L5b
                if (r0 == 0) goto L60
                java.lang.Object r10 = r8.f32913i     // Catch: java.lang.Throwable -> L5b
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L5b
                long r6 = xj.z1.c.b.g(r11)     // Catch: java.lang.Throwable -> L51
                int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r0 == 0) goto L53
                xj.z1.c.b.i(r11)     // Catch: java.lang.Throwable -> L51
                goto L53
            L51:
                r9 = move-exception
                goto L5e
            L53:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L51
                ek.d<T> r10 = r8.f32911g     // Catch: java.lang.Throwable -> L5b
                r10.onNext(r9)     // Catch: java.lang.Throwable -> L5b
                r0 = 0
                goto L60
            L5b:
                r9 = move-exception
                r4 = 0
                goto L8a
            L5e:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L51
                throw r9     // Catch: java.lang.Throwable -> L5b
            L60:
                java.lang.Object r10 = r8.f32913i     // Catch: java.lang.Throwable -> L5b
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L5b
                java.util.List<java.lang.Object> r6 = r8.f32918n     // Catch: java.lang.Throwable -> L6f
                r8.f32918n = r3     // Catch: java.lang.Throwable -> L6f
                if (r6 != 0) goto L72
                r8.f32919o = r5     // Catch: java.lang.Throwable -> L6f
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L6d
                goto L81
            L6d:
                r9 = move-exception
                goto L87
            L6f:
                r9 = move-exception
                r4 = 0
                goto L87
            L72:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L6f
                ek.d<T> r10 = r8.f32911g     // Catch: java.lang.Throwable -> L5b
                boolean r10 = r10.isUnsubscribed()     // Catch: java.lang.Throwable -> L5b
                if (r10 == 0) goto L85
                java.lang.Object r10 = r8.f32913i
                monitor-enter(r10)
                r8.f32919o = r5     // Catch: java.lang.Throwable -> L82
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L82
            L81:
                return
            L82:
                r9 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L82
                throw r9
            L85:
                r10 = r6
                goto L3c
            L87:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L6d
                throw r9     // Catch: java.lang.Throwable -> L89
            L89:
                r9 = move-exception
            L8a:
                if (r4 != 0) goto L96
                java.lang.Object r10 = r8.f32913i
                monitor-enter(r10)
                r8.f32919o = r5     // Catch: java.lang.Throwable -> L93
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L93
                goto L96
            L93:
                r9 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L93
                throw r9
            L96:
                throw r9
            L97:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: xj.z1.c.i(java.lang.Object, int, xj.z1$c$b):void");
        }

        public void j(Throwable th2, int i10) {
            synchronized (this.f32913i) {
                try {
                    if (i10 != this.f32915k) {
                        return;
                    }
                    if (this.f32919o) {
                        if (this.f32918n == null) {
                            this.f32918n = new ArrayList();
                        }
                        this.f32918n.add(this.f32914j.c(th2));
                    } else {
                        List<Object> list = this.f32918n;
                        this.f32918n = null;
                        this.f32919o = true;
                        h(list);
                        this.f32911g.onError(th2);
                        unsubscribe();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        /* renamed from: k */
        public void onNext(qj.a<? extends T> aVar) {
            long j10;
            synchronized (this.f32913i) {
                try {
                    int i10 = this.f32915k + 1;
                    this.f32915k = i10;
                    this.f32916l = true;
                    if (this.f32922r) {
                        j10 = Long.MAX_VALUE;
                    } else {
                        c<T>.b bVar = this.f32920p;
                        j10 = bVar == null ? this.f32921q : bVar.f32924g;
                    }
                    c<T>.b bVar2 = new b(i10, j10);
                    this.f32920p = bVar2;
                    bVar2.f32924g = j10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f32912h.b(this.f32920p);
            aVar.T4(this.f32920p);
        }

        @Override // qj.b
        public void onCompleted() {
            synchronized (this.f32913i) {
                try {
                    this.f32917m = true;
                    if (this.f32916l) {
                        return;
                    }
                    if (this.f32919o) {
                        if (this.f32918n == null) {
                            this.f32918n = new ArrayList();
                        }
                        this.f32918n.add(this.f32914j.b());
                    } else {
                        List<Object> list = this.f32918n;
                        this.f32918n = null;
                        this.f32919o = true;
                        h(list);
                        this.f32911g.onCompleted();
                        unsubscribe();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32911g.onError(th2);
            unsubscribe();
        }
    }

    public /* synthetic */ z1(a aVar) {
        this();
    }

    public static <T> z1<T> a() {
        return (z1<T>) b.f32910a;
    }

    public z1() {
    }

    @Override // wj.o
    public qj.g<? super qj.a<? extends T>> call(qj.g<? super T> gVar) {
        c cVar = new c(gVar);
        gVar.b(cVar);
        return cVar;
    }
}
