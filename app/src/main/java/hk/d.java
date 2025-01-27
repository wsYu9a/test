package hk;

import hk.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.a;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class d<T> extends hk.f<T, T> {

    /* renamed from: e */
    public final n<T, ?> f26748e;

    /* renamed from: f */
    public final hk.g<T> f26749f;

    public static class a implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ r f26750b;

        public a(r rVar) {
            this.f26750b = rVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            Integer c10 = this.f26750b.c(0, cVar);
            c10.intValue();
            cVar.g(c10);
        }
    }

    public static class b implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ r f26751b;

        public b(r rVar) {
            this.f26751b = rVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            boolean z10;
            synchronized (cVar) {
                if (cVar.f26802c && !cVar.f26803d) {
                    cVar.f26802c = false;
                    boolean z11 = true;
                    cVar.f26803d = true;
                    while (true) {
                        try {
                            Integer num = (Integer) cVar.f();
                            int intValue = num.intValue();
                            int i10 = this.f26751b.f26780d;
                            if (intValue != i10) {
                                cVar.g(this.f26751b.c(num, cVar));
                            }
                            try {
                                synchronized (cVar) {
                                    try {
                                        if (i10 == this.f26751b.f26780d) {
                                            cVar.f26803d = false;
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z10 = false;
                        }
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            z10 = z11;
                            th = th5;
                            if (z10) {
                                throw th;
                            }
                            synchronized (cVar) {
                                cVar.f26803d = false;
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public static class c implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ r f26752b;

        public c(r rVar) {
            this.f26752b = rVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            int i10 = (Integer) cVar.f();
            if (i10 == null) {
                i10 = 0;
            }
            this.f26752b.c(i10, cVar);
        }
    }

    /* renamed from: hk.d$d */
    public static class C0711d implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26753b;

        public C0711d(g gVar) {
            this.f26753b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            boolean z10;
            synchronized (cVar) {
                if (cVar.f26802c && !cVar.f26803d) {
                    cVar.f26802c = false;
                    boolean z11 = true;
                    cVar.f26803d = true;
                    while (true) {
                        try {
                            k.a<Object> aVar = (k.a) cVar.f();
                            k.a<Object> k10 = this.f26753b.k();
                            if (aVar != k10) {
                                cVar.g(this.f26753b.c(aVar, cVar));
                            }
                            try {
                                synchronized (cVar) {
                                    try {
                                        if (k10 == this.f26753b.k()) {
                                            cVar.f26803d = false;
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z10 = false;
                        }
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            z10 = z11;
                            th = th5;
                            if (z10) {
                                throw th;
                            }
                            synchronized (cVar) {
                                cVar.f26803d = false;
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public static class e implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26754b;

        public e(g gVar) {
            this.f26754b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            k.a<Object> aVar = (k.a) cVar.f();
            if (aVar == null) {
                aVar = this.f26754b.h();
            }
            this.f26754b.c(aVar, cVar);
        }
    }

    public static final class f implements wj.o<Object, Object> {

        /* renamed from: b */
        public final qj.d f26755b;

        public f(qj.d dVar) {
            this.f26755b = dVar;
        }

        @Override // wj.o
        public Object call(Object obj) {
            return new gk.j(this.f26755b.b(), obj);
        }
    }

    public static final class g<T> implements n<T, k.a<Object>> {

        /* renamed from: a */
        public final k<Object> f26756a;

        /* renamed from: b */
        public final j f26757b;

        /* renamed from: c */
        public final wj.o<Object, Object> f26758c;

        /* renamed from: d */
        public final wj.o<Object, Object> f26759d;

        /* renamed from: e */
        public final NotificationLite<T> f26760e = NotificationLite.f();

        /* renamed from: f */
        public volatile boolean f26761f;

        /* renamed from: g */
        public volatile k.a<Object> f26762g;

        public g(j jVar, wj.o<Object, Object> oVar, wj.o<Object, Object> oVar2) {
            k<Object> kVar = new k<>();
            this.f26756a = kVar;
            this.f26762g = kVar.f26765b;
            this.f26757b = jVar;
            this.f26758c = oVar;
            this.f26759d = oVar2;
        }

        @Override // hk.d.n
        public T a() {
            k.a<Object> aVar = h().f26768b;
            if (aVar == null) {
                return null;
            }
            k.a<Object> aVar2 = null;
            while (aVar != k()) {
                aVar2 = aVar;
                aVar = aVar.f26768b;
            }
            Object call = this.f26759d.call(aVar.f26767a);
            if (!this.f26760e.h(call) && !this.f26760e.g(call)) {
                return this.f26760e.e(call);
            }
            if (aVar2 == null) {
                return null;
            }
            return this.f26760e.e(this.f26759d.call(aVar2.f26767a));
        }

        @Override // hk.d.n
        public void complete() {
            if (this.f26761f) {
                return;
            }
            this.f26761f = true;
            this.f26756a.a(this.f26758c.call(this.f26760e.b()));
            this.f26757b.c(this.f26756a);
            this.f26762g = this.f26756a.f26765b;
        }

        @Override // hk.d.n
        public boolean d(g.c<? super T> cVar) {
            synchronized (cVar) {
                try {
                    cVar.f26802c = false;
                    if (cVar.f26803d) {
                        return false;
                    }
                    cVar.g(c((k.a) cVar.f(), cVar));
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // hk.d.n
        public boolean e() {
            return this.f26761f;
        }

        @Override // hk.d.n
        public void error(Throwable th2) {
            if (this.f26761f) {
                return;
            }
            this.f26761f = true;
            this.f26756a.a(this.f26758c.call(this.f26760e.c(th2)));
            this.f26757b.c(this.f26756a);
            this.f26762g = this.f26756a.f26765b;
        }

        public void f(qj.b<? super T> bVar, k.a<Object> aVar) {
            this.f26760e.a(bVar, this.f26759d.call(aVar.f26767a));
        }

        public void g(qj.b<? super T> bVar, k.a<Object> aVar, long j10) {
            Object obj = aVar.f26767a;
            if (this.f26757b.a(obj, j10)) {
                return;
            }
            this.f26760e.a(bVar, this.f26759d.call(obj));
        }

        public k.a<Object> h() {
            return this.f26756a.f26764a;
        }

        @Override // hk.d.n
        /* renamed from: i */
        public k.a<Object> c(k.a<Object> aVar, g.c<? super T> cVar) {
            while (aVar != k()) {
                f(cVar, aVar.f26768b);
                aVar = aVar.f26768b;
            }
            return aVar;
        }

        @Override // hk.d.n
        public boolean isEmpty() {
            k.a<Object> aVar = h().f26768b;
            if (aVar == null) {
                return true;
            }
            Object call = this.f26759d.call(aVar.f26767a);
            return this.f26760e.h(call) || this.f26760e.g(call);
        }

        @Override // hk.d.n
        /* renamed from: j */
        public k.a<Object> b(k.a<Object> aVar, g.c<? super T> cVar, long j10) {
            while (aVar != k()) {
                g(cVar, aVar.f26768b, j10);
                aVar = aVar.f26768b;
            }
            return aVar;
        }

        public k.a<Object> k() {
            return this.f26762g;
        }

        @Override // hk.d.n
        public void next(T t10) {
            if (this.f26761f) {
                return;
            }
            this.f26756a.a(this.f26758c.call(this.f26760e.l(t10)));
            this.f26757b.b(this.f26756a);
            this.f26762g = this.f26756a.f26765b;
        }

        @Override // hk.d.n
        public int size() {
            k.a<Object> aVar;
            Object call;
            k.a<Object> h10 = h();
            k.a<Object> aVar2 = h10.f26768b;
            int i10 = 0;
            while (true) {
                k.a<Object> aVar3 = aVar2;
                aVar = h10;
                h10 = aVar3;
                if (h10 == null) {
                    break;
                }
                i10++;
                aVar2 = h10.f26768b;
            }
            Object obj = aVar.f26767a;
            return (obj == null || (call = this.f26759d.call(obj)) == null) ? i10 : (this.f26760e.h(call) || this.f26760e.g(call)) ? i10 - 1 : i10;
        }

        @Override // hk.d.n
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (k.a aVar = h().f26768b; aVar != null; aVar = aVar.f26768b) {
                Object call = this.f26759d.call(aVar.f26767a);
                if (aVar.f26768b == null && (this.f26760e.h(call) || this.f26760e.g(call))) {
                    break;
                }
                arrayList.add(call);
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    public static final class h<T> implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final g<T> f26763b;

        public h(g<T> gVar) {
            this.f26763b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            g<T> gVar = this.f26763b;
            cVar.g(gVar.c(gVar.h(), cVar));
        }
    }

    public interface j {
        boolean a(Object obj, long j10);

        void b(k<Object> kVar);

        void c(k<Object> kVar);
    }

    public static final class k<T> {

        /* renamed from: a */
        public final a<T> f26764a;

        /* renamed from: b */
        public a<T> f26765b;

        /* renamed from: c */
        public int f26766c;

        public static final class a<T> {

            /* renamed from: a */
            public final T f26767a;

            /* renamed from: b */
            public volatile a<T> f26768b;

            public a(T t10) {
                this.f26767a = t10;
            }
        }

        public k() {
            a<T> aVar = new a<>(null);
            this.f26764a = aVar;
            this.f26765b = aVar;
        }

        public void a(T t10) {
            a<T> aVar = this.f26765b;
            a<T> aVar2 = new a<>(t10);
            aVar.f26768b = aVar2;
            this.f26765b = aVar2;
            this.f26766c++;
        }

        public void b() {
            this.f26765b = this.f26764a;
            this.f26766c = 0;
        }

        public boolean c() {
            return this.f26766c == 0;
        }

        public T d() {
            if (this.f26764a.f26768b == null) {
                throw new IllegalStateException("Empty!");
            }
            a<T> aVar = this.f26764a.f26768b;
            this.f26764a.f26768b = aVar.f26768b;
            if (this.f26764a.f26768b == null) {
                this.f26765b = this.f26764a;
            }
            this.f26766c--;
            return aVar.f26767a;
        }

        public int e() {
            return this.f26766c;
        }
    }

    public static final class l implements j {

        /* renamed from: a */
        public final j f26769a;

        /* renamed from: b */
        public final j f26770b;

        public l(j jVar, j jVar2) {
            this.f26769a = jVar;
            this.f26770b = jVar2;
        }

        @Override // hk.d.j
        public boolean a(Object obj, long j10) {
            return this.f26769a.a(obj, j10) || this.f26770b.a(obj, j10);
        }

        @Override // hk.d.j
        public void b(k<Object> kVar) {
            this.f26769a.b(kVar);
            this.f26770b.b(kVar);
        }

        @Override // hk.d.j
        public void c(k<Object> kVar) {
            this.f26769a.c(kVar);
            this.f26770b.c(kVar);
        }
    }

    public static final class m implements wj.o<Object, Object> {
        @Override // wj.o
        public Object call(Object obj) {
            return ((gk.j) obj).b();
        }
    }

    public interface n<T, I> {
        T a();

        I b(I i10, g.c<? super T> cVar, long j10);

        I c(I i10, g.c<? super T> cVar);

        void complete();

        boolean d(g.c<? super T> cVar);

        boolean e();

        void error(Throwable th2);

        boolean isEmpty();

        void next(T t10);

        int size();

        T[] toArray(T[] tArr);
    }

    public static final class o implements j {

        /* renamed from: a */
        public final int f26771a;

        public o(int i10) {
            this.f26771a = i10;
        }

        @Override // hk.d.j
        public boolean a(Object obj, long j10) {
            return false;
        }

        @Override // hk.d.j
        public void b(k<Object> kVar) {
            while (kVar.e() > this.f26771a) {
                kVar.d();
            }
        }

        @Override // hk.d.j
        public void c(k<Object> kVar) {
            while (kVar.e() > this.f26771a + 1) {
                kVar.d();
            }
        }
    }

    public static final class p implements j {

        /* renamed from: a */
        public final long f26772a;

        /* renamed from: b */
        public final qj.d f26773b;

        public p(long j10, qj.d dVar) {
            this.f26772a = j10;
            this.f26773b = dVar;
        }

        @Override // hk.d.j
        public boolean a(Object obj, long j10) {
            return ((gk.j) obj).a() <= j10 - this.f26772a;
        }

        @Override // hk.d.j
        public void b(k<Object> kVar) {
            long b10 = this.f26773b.b();
            while (!kVar.c() && a(kVar.f26764a.f26768b.f26767a, b10)) {
                kVar.d();
            }
        }

        @Override // hk.d.j
        public void c(k<Object> kVar) {
            long b10 = this.f26773b.b();
            while (kVar.f26766c > 1 && a(kVar.f26764a.f26768b.f26767a, b10)) {
                kVar.d();
            }
        }
    }

    public static final class q<T> implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final g<T> f26774b;

        /* renamed from: c */
        public final qj.d f26775c;

        public q(g<T> gVar, qj.d dVar) {
            this.f26774b = gVar;
            this.f26775c = dVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            k.a<Object> c10;
            if (this.f26774b.f26761f) {
                g<T> gVar = this.f26774b;
                c10 = gVar.c(gVar.h(), cVar);
            } else {
                g<T> gVar2 = this.f26774b;
                c10 = gVar2.b(gVar2.h(), cVar, this.f26775c.b());
            }
            cVar.g(c10);
        }
    }

    public static final class r<T> implements n<T, Integer> {

        /* renamed from: e */
        public static final AtomicIntegerFieldUpdater<r> f26776e = AtomicIntegerFieldUpdater.newUpdater(r.class, "d");

        /* renamed from: a */
        public final NotificationLite<T> f26777a = NotificationLite.f();

        /* renamed from: b */
        public final ArrayList<Object> f26778b;

        /* renamed from: c */
        public volatile boolean f26779c;

        /* renamed from: d */
        public volatile int f26780d;

        public r(int i10) {
            this.f26778b = new ArrayList<>(i10);
        }

        @Override // hk.d.n
        public T a() {
            int i10 = this.f26780d;
            if (i10 > 0) {
                Object obj = this.f26778b.get(i10 - 1);
                if (!this.f26777a.g(obj) && !this.f26777a.h(obj)) {
                    return this.f26777a.e(obj);
                }
                if (i10 > 1) {
                    return this.f26777a.e(this.f26778b.get(i10 - 2));
                }
            }
            return null;
        }

        @Override // hk.d.n
        public void complete() {
            if (this.f26779c) {
                return;
            }
            this.f26779c = true;
            this.f26778b.add(this.f26777a.b());
            f26776e.getAndIncrement(this);
        }

        @Override // hk.d.n
        public boolean d(g.c<? super T> cVar) {
            synchronized (cVar) {
                try {
                    cVar.f26802c = false;
                    if (cVar.f26803d) {
                        return false;
                    }
                    Integer num = (Integer) cVar.f();
                    if (num != null) {
                        Integer c10 = c(num, cVar);
                        c10.intValue();
                        cVar.g(c10);
                        return true;
                    }
                    throw new IllegalStateException("failed to find lastEmittedLink for: " + cVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // hk.d.n
        public boolean e() {
            return this.f26779c;
        }

        @Override // hk.d.n
        public void error(Throwable th2) {
            if (this.f26779c) {
                return;
            }
            this.f26779c = true;
            this.f26778b.add(this.f26777a.c(th2));
            f26776e.getAndIncrement(this);
        }

        public void f(qj.b<? super T> bVar, int i10) {
            this.f26777a.a(bVar, this.f26778b.get(i10));
        }

        @Override // hk.d.n
        /* renamed from: g */
        public Integer c(Integer num, g.c<? super T> cVar) {
            int intValue = num.intValue();
            while (intValue < this.f26780d) {
                f(cVar, intValue);
                intValue++;
            }
            return Integer.valueOf(intValue);
        }

        @Override // hk.d.n
        /* renamed from: h */
        public Integer b(Integer num, g.c<? super T> cVar, long j10) {
            return c(num, cVar);
        }

        @Override // hk.d.n
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // hk.d.n
        public void next(T t10) {
            if (this.f26779c) {
                return;
            }
            this.f26778b.add(this.f26777a.l(t10));
            f26776e.getAndIncrement(this);
        }

        @Override // hk.d.n
        public int size() {
            int i10 = this.f26780d;
            if (i10 > 0) {
                int i11 = i10 - 1;
                Object obj = this.f26778b.get(i11);
                if (this.f26777a.g(obj) || this.f26777a.h(obj)) {
                    return i11;
                }
            }
            return i10;
        }

        @Override // hk.d.n
        public T[] toArray(T[] tArr) {
            int size = size();
            if (size > 0) {
                if (size > tArr.length) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i10 = 0; i10 < size; i10++) {
                    tArr[i10] = this.f26778b.get(i10);
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
    }

    public d(a.m0<T> m0Var, hk.g<T> gVar, n<T, ?> nVar) {
        super(m0Var);
        this.f26749f = gVar;
        this.f26748e = nVar;
    }

    public static <T> d<T> G5() {
        return H5(16);
    }

    public static <T> d<T> H5(int i10) {
        r rVar = new r(i10);
        hk.g gVar = new hk.g();
        gVar.f26790e = new a(rVar);
        gVar.f26791f = new b(rVar);
        gVar.f26792g = new c(rVar);
        return new d<>(gVar, gVar, rVar);
    }

    public static <T> d<T> I5() {
        g gVar = new g(new i(), UtilityFunctions.c(), UtilityFunctions.c());
        return K5(gVar, new h(gVar));
    }

    public static <T> d<T> J5(int i10) {
        g gVar = new g(new o(i10), UtilityFunctions.c(), UtilityFunctions.c());
        return K5(gVar, new h(gVar));
    }

    public static final <T> d<T> K5(g<T> gVar, wj.b<g.c<T>> bVar) {
        hk.g gVar2 = new hk.g();
        gVar2.f26790e = bVar;
        gVar2.f26791f = new C0711d(gVar);
        gVar2.f26792g = new e(gVar);
        return new d<>(gVar2, gVar2, gVar);
    }

    public static <T> d<T> L5(long j10, TimeUnit timeUnit, qj.d dVar) {
        g gVar = new g(new p(timeUnit.toMillis(j10), dVar), new f(dVar), new m());
        return K5(gVar, new q(gVar, dVar));
    }

    public static <T> d<T> M5(long j10, TimeUnit timeUnit, int i10, qj.d dVar) {
        g gVar = new g(new l(new o(i10), new p(timeUnit.toMillis(j10), dVar)), new f(dVar), new m());
        return K5(gVar, new q(gVar, dVar));
    }

    @Override // hk.f
    @uj.b
    public boolean A5() {
        hk.g<T> gVar = this.f26749f;
        NotificationLite<T> notificationLite = gVar.f26793h;
        Object c10 = gVar.c();
        return (c10 == null || notificationLite.h(c10)) ? false : true;
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26749f.e().length > 0;
    }

    @Override // hk.f
    @uj.b
    public boolean C5() {
        hk.g<T> gVar = this.f26749f;
        return gVar.f26793h.h(gVar.c());
    }

    @Override // hk.f
    @uj.b
    public boolean D5() {
        return N5();
    }

    public final boolean F5(g.c<? super T> cVar) {
        if (cVar.f26806g) {
            return true;
        }
        if (!this.f26748e.d(cVar)) {
            return false;
        }
        cVar.f26806g = true;
        cVar.g(null);
        return false;
    }

    @uj.b
    public boolean N5() {
        return !this.f26748e.isEmpty();
    }

    @uj.b
    public int O5() {
        return this.f26748e.size();
    }

    public int P5() {
        return this.f26749f.f26787b.f26800b.length;
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f26749f.f26789d) {
            this.f26748e.complete();
            for (g.c<? super T> cVar : this.f26749f.h(NotificationLite.f().b())) {
                if (F5(cVar)) {
                    cVar.onCompleted();
                }
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        if (this.f26749f.f26789d) {
            this.f26748e.error(th2);
            ArrayList arrayList = null;
            for (g.c<? super T> cVar : this.f26749f.h(NotificationLite.f().c(th2))) {
                try {
                    if (F5(cVar)) {
                        cVar.onError(th2);
                    }
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th3);
                }
            }
            vj.a.d(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qj.b
    public void onNext(T t10) {
        if (this.f26749f.f26789d) {
            this.f26748e.next(t10);
            for (g.c<? super T> cVar : this.f26749f.e()) {
                if (F5(cVar)) {
                    cVar.onNext(t10);
                }
            }
        }
    }

    @Override // hk.f
    @uj.b
    public Throwable w5() {
        hk.g<T> gVar = this.f26749f;
        NotificationLite<T> notificationLite = gVar.f26793h;
        Object c10 = gVar.c();
        if (notificationLite.h(c10)) {
            return notificationLite.d(c10);
        }
        return null;
    }

    @Override // hk.f
    public T x5() {
        return this.f26748e.a();
    }

    @Override // hk.f
    @uj.b
    public T[] z5(T[] tArr) {
        return this.f26748e.toArray(tArr);
    }

    public static final class i implements j {
        @Override // hk.d.j
        public boolean a(Object obj, long j10) {
            return true;
        }

        @Override // hk.d.j
        public void b(k<Object> kVar) {
        }

        @Override // hk.d.j
        public void c(k<Object> kVar) {
        }
    }
}
