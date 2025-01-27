package rx.o;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.a;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;
import rx.o.g;

/* loaded from: classes5.dex */
public final class d<T> extends rx.o.f<T, T> {

    /* renamed from: d */
    final n<T, ?> f37000d;

    /* renamed from: e */
    final rx.o.g<T> f37001e;

    static class a implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ r f37002a;

        a(r rVar) {
            this.f37002a = rVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            cVar.g(Integer.valueOf(this.f37002a.f(0, cVar).intValue()));
        }
    }

    static class b implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ r f37003a;

        b(r rVar) {
            this.f37003a = rVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            boolean z;
            synchronized (cVar) {
                if (cVar.f37054b && !cVar.f37055c) {
                    cVar.f37054b = false;
                    boolean z2 = true;
                    cVar.f37055c = true;
                    while (true) {
                        try {
                            int intValue = ((Integer) cVar.f()).intValue();
                            int i2 = this.f37003a.f37032e;
                            if (intValue != i2) {
                                cVar.g(this.f37003a.f(Integer.valueOf(intValue), cVar));
                            }
                            try {
                                synchronized (cVar) {
                                    try {
                                        if (i2 == this.f37003a.f37032e) {
                                            cVar.f37055c = false;
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        z2 = false;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                z = z2;
                                th = th3;
                                if (!z) {
                                    synchronized (cVar) {
                                        cVar.f37055c = false;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z = false;
                        }
                    }
                }
            }
        }
    }

    static class c implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ r f37004a;

        c(r rVar) {
            this.f37004a = rVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            int i2 = (Integer) cVar.f();
            if (i2 == null) {
                i2 = 0;
            }
            this.f37004a.f(i2, cVar);
        }
    }

    /* renamed from: rx.o.d$d */
    static class C0892d implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f37005a;

        C0892d(g gVar) {
            this.f37005a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            boolean z;
            synchronized (cVar) {
                if (cVar.f37054b && !cVar.f37055c) {
                    cVar.f37054b = false;
                    boolean z2 = true;
                    cVar.f37055c = true;
                    while (true) {
                        try {
                            k.a<Object> aVar = (k.a) cVar.f();
                            k.a<Object> m = this.f37005a.m();
                            if (aVar != m) {
                                cVar.g(this.f37005a.f(aVar, cVar));
                            }
                            try {
                                synchronized (cVar) {
                                    try {
                                        if (m == this.f37005a.m()) {
                                            cVar.f37055c = false;
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        z2 = false;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                z = z2;
                                th = th3;
                                if (!z) {
                                    synchronized (cVar) {
                                        cVar.f37055c = false;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z = false;
                        }
                    }
                }
            }
        }
    }

    static class e implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f37006a;

        e(g gVar) {
            this.f37006a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            k.a<Object> aVar = (k.a) cVar.f();
            if (aVar == null) {
                aVar = this.f37006a.j();
            }
            this.f37006a.f(aVar, cVar);
        }
    }

    static final class f implements rx.k.o<Object, Object> {

        /* renamed from: a */
        final rx.d f37007a;

        public f(rx.d dVar) {
            this.f37007a = dVar;
        }

        @Override // rx.k.o
        public Object call(Object obj) {
            return new rx.n.j(this.f37007a.b(), obj);
        }
    }

    static final class g<T> implements n<T, k.a<Object>> {

        /* renamed from: a */
        final k<Object> f37008a;

        /* renamed from: b */
        final j f37009b;

        /* renamed from: c */
        final rx.k.o<Object, Object> f37010c;

        /* renamed from: d */
        final rx.k.o<Object, Object> f37011d;

        /* renamed from: e */
        final NotificationLite<T> f37012e = NotificationLite.f();

        /* renamed from: f */
        volatile boolean f37013f;

        /* renamed from: g */
        volatile k.a<Object> f37014g;

        public g(j jVar, rx.k.o<Object, Object> oVar, rx.k.o<Object, Object> oVar2) {
            k<Object> kVar = new k<>();
            this.f37008a = kVar;
            this.f37014g = kVar.f37017b;
            this.f37009b = jVar;
            this.f37010c = oVar;
            this.f37011d = oVar2;
        }

        @Override // rx.o.d.n
        public T a() {
            k.a<Object> aVar = j().f37020b;
            if (aVar == null) {
                return null;
            }
            k.a<Object> aVar2 = null;
            while (aVar != m()) {
                aVar2 = aVar;
                aVar = aVar.f37020b;
            }
            Object call = this.f37011d.call(aVar.f37019a);
            if (!this.f37012e.h(call) && !this.f37012e.g(call)) {
                return this.f37012e.e(call);
            }
            if (aVar2 == null) {
                return null;
            }
            return this.f37012e.e(this.f37011d.call(aVar2.f37019a));
        }

        @Override // rx.o.d.n
        public void b(Throwable th) {
            if (this.f37013f) {
                return;
            }
            this.f37013f = true;
            this.f37008a.a(this.f37010c.call(this.f37012e.c(th)));
            this.f37009b.c(this.f37008a);
            this.f37014g = this.f37008a.f37017b;
        }

        @Override // rx.o.d.n
        public void complete() {
            if (this.f37013f) {
                return;
            }
            this.f37013f = true;
            this.f37008a.a(this.f37010c.call(this.f37012e.b()));
            this.f37009b.c(this.f37008a);
            this.f37014g = this.f37008a.f37017b;
        }

        @Override // rx.o.d.n
        public boolean d() {
            return this.f37013f;
        }

        @Override // rx.o.d.n
        public void e(T t) {
            if (this.f37013f) {
                return;
            }
            this.f37008a.a(this.f37010c.call(this.f37012e.l(t)));
            this.f37009b.a(this.f37008a);
            this.f37014g = this.f37008a.f37017b;
        }

        @Override // rx.o.d.n
        public boolean g(g.c<? super T> cVar) {
            synchronized (cVar) {
                cVar.f37054b = false;
                if (cVar.f37055c) {
                    return false;
                }
                cVar.g(f((k.a) cVar.f(), cVar));
                return true;
            }
        }

        public void h(rx.b<? super T> bVar, k.a<Object> aVar) {
            this.f37012e.a(bVar, this.f37011d.call(aVar.f37019a));
        }

        public void i(rx.b<? super T> bVar, k.a<Object> aVar, long j2) {
            Object obj = aVar.f37019a;
            if (this.f37009b.b(obj, j2)) {
                return;
            }
            this.f37012e.a(bVar, this.f37011d.call(obj));
        }

        @Override // rx.o.d.n
        public boolean isEmpty() {
            k.a<Object> aVar = j().f37020b;
            if (aVar == null) {
                return true;
            }
            Object call = this.f37011d.call(aVar.f37019a);
            return this.f37012e.h(call) || this.f37012e.g(call);
        }

        public k.a<Object> j() {
            return this.f37008a.f37016a;
        }

        @Override // rx.o.d.n
        /* renamed from: k */
        public k.a<Object> f(k.a<Object> aVar, g.c<? super T> cVar) {
            while (aVar != m()) {
                h(cVar, aVar.f37020b);
                aVar = aVar.f37020b;
            }
            return aVar;
        }

        @Override // rx.o.d.n
        /* renamed from: l */
        public k.a<Object> c(k.a<Object> aVar, g.c<? super T> cVar, long j2) {
            while (aVar != m()) {
                i(cVar, aVar.f37020b, j2);
                aVar = aVar.f37020b;
            }
            return aVar;
        }

        public k.a<Object> m() {
            return this.f37014g;
        }

        @Override // rx.o.d.n
        public int size() {
            k.a<Object> aVar;
            Object call;
            k.a<Object> j2 = j();
            k.a<Object> aVar2 = j2.f37020b;
            int i2 = 0;
            while (true) {
                k.a<Object> aVar3 = aVar2;
                aVar = j2;
                j2 = aVar3;
                if (j2 == null) {
                    break;
                }
                i2++;
                aVar2 = j2.f37020b;
            }
            Object obj = aVar.f37019a;
            return (obj == null || (call = this.f37011d.call(obj)) == null) ? i2 : (this.f37012e.h(call) || this.f37012e.g(call)) ? i2 - 1 : i2;
        }

        @Override // rx.o.d.n
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (k.a aVar = j().f37020b; aVar != null; aVar = aVar.f37020b) {
                Object call = this.f37011d.call(aVar.f37019a);
                if (aVar.f37020b == null && (this.f37012e.h(call) || this.f37012e.g(call))) {
                    break;
                }
                arrayList.add(call);
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static final class h<T> implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final g<T> f37015a;

        public h(g<T> gVar) {
            this.f37015a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            g<T> gVar = this.f37015a;
            cVar.g(gVar.f(gVar.j(), cVar));
        }
    }

    static final class i implements j {
        i() {
        }

        @Override // rx.o.d.j
        public void a(k<Object> kVar) {
        }

        @Override // rx.o.d.j
        public boolean b(Object obj, long j2) {
            return true;
        }

        @Override // rx.o.d.j
        public void c(k<Object> kVar) {
        }
    }

    interface j {
        void a(k<Object> kVar);

        boolean b(Object obj, long j2);

        void c(k<Object> kVar);
    }

    static final class k<T> {

        /* renamed from: a */
        final a<T> f37016a;

        /* renamed from: b */
        a<T> f37017b;

        /* renamed from: c */
        int f37018c;

        static final class a<T> {

            /* renamed from: a */
            final T f37019a;

            /* renamed from: b */
            volatile a<T> f37020b;

            a(T t) {
                this.f37019a = t;
            }
        }

        k() {
            a<T> aVar = new a<>(null);
            this.f37016a = aVar;
            this.f37017b = aVar;
        }

        public void a(T t) {
            a<T> aVar = this.f37017b;
            a<T> aVar2 = new a<>(t);
            aVar.f37020b = aVar2;
            this.f37017b = aVar2;
            this.f37018c++;
        }

        public void b() {
            this.f37017b = this.f37016a;
            this.f37018c = 0;
        }

        public boolean c() {
            return this.f37018c == 0;
        }

        public T d() {
            if (this.f37016a.f37020b == null) {
                throw new IllegalStateException("Empty!");
            }
            a<T> aVar = this.f37016a.f37020b;
            this.f37016a.f37020b = aVar.f37020b;
            if (this.f37016a.f37020b == null) {
                this.f37017b = this.f37016a;
            }
            this.f37018c--;
            return aVar.f37019a;
        }

        public int e() {
            return this.f37018c;
        }
    }

    static final class l implements j {

        /* renamed from: a */
        final j f37021a;

        /* renamed from: b */
        final j f37022b;

        public l(j jVar, j jVar2) {
            this.f37021a = jVar;
            this.f37022b = jVar2;
        }

        @Override // rx.o.d.j
        public void a(k<Object> kVar) {
            this.f37021a.a(kVar);
            this.f37022b.a(kVar);
        }

        @Override // rx.o.d.j
        public boolean b(Object obj, long j2) {
            return this.f37021a.b(obj, j2) || this.f37022b.b(obj, j2);
        }

        @Override // rx.o.d.j
        public void c(k<Object> kVar) {
            this.f37021a.c(kVar);
            this.f37022b.c(kVar);
        }
    }

    static final class m implements rx.k.o<Object, Object> {
        m() {
        }

        @Override // rx.k.o
        public Object call(Object obj) {
            return ((rx.n.j) obj).b();
        }
    }

    interface n<T, I> {
        T a();

        void b(Throwable th);

        I c(I i2, g.c<? super T> cVar, long j2);

        void complete();

        boolean d();

        void e(T t);

        I f(I i2, g.c<? super T> cVar);

        boolean g(g.c<? super T> cVar);

        boolean isEmpty();

        int size();

        T[] toArray(T[] tArr);
    }

    static final class o implements j {

        /* renamed from: a */
        final int f37023a;

        public o(int i2) {
            this.f37023a = i2;
        }

        @Override // rx.o.d.j
        public void a(k<Object> kVar) {
            while (kVar.e() > this.f37023a) {
                kVar.d();
            }
        }

        @Override // rx.o.d.j
        public boolean b(Object obj, long j2) {
            return false;
        }

        @Override // rx.o.d.j
        public void c(k<Object> kVar) {
            while (kVar.e() > this.f37023a + 1) {
                kVar.d();
            }
        }
    }

    static final class p implements j {

        /* renamed from: a */
        final long f37024a;

        /* renamed from: b */
        final rx.d f37025b;

        public p(long j2, rx.d dVar) {
            this.f37024a = j2;
            this.f37025b = dVar;
        }

        @Override // rx.o.d.j
        public void a(k<Object> kVar) {
            long b2 = this.f37025b.b();
            while (!kVar.c() && b(kVar.f37016a.f37020b.f37019a, b2)) {
                kVar.d();
            }
        }

        @Override // rx.o.d.j
        public boolean b(Object obj, long j2) {
            return ((rx.n.j) obj).a() <= j2 - this.f37024a;
        }

        @Override // rx.o.d.j
        public void c(k<Object> kVar) {
            long b2 = this.f37025b.b();
            while (kVar.f37018c > 1 && b(kVar.f37016a.f37020b.f37019a, b2)) {
                kVar.d();
            }
        }
    }

    static final class q<T> implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final g<T> f37026a;

        /* renamed from: b */
        final rx.d f37027b;

        public q(g<T> gVar, rx.d dVar) {
            this.f37026a = gVar;
            this.f37027b = dVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            k.a<Object> f2;
            if (this.f37026a.f37013f) {
                g<T> gVar = this.f37026a;
                f2 = gVar.f(gVar.j(), cVar);
            } else {
                g<T> gVar2 = this.f37026a;
                f2 = gVar2.c(gVar2.j(), cVar, this.f37027b.b());
            }
            cVar.g(f2);
        }
    }

    static final class r<T> implements n<T, Integer> {

        /* renamed from: a */
        static final AtomicIntegerFieldUpdater<r> f37028a = AtomicIntegerFieldUpdater.newUpdater(r.class, com.kwad.sdk.ranger.e.TAG);

        /* renamed from: b */
        private final NotificationLite<T> f37029b = NotificationLite.f();

        /* renamed from: c */
        private final ArrayList<Object> f37030c;

        /* renamed from: d */
        private volatile boolean f37031d;

        /* renamed from: e */
        volatile int f37032e;

        public r(int i2) {
            this.f37030c = new ArrayList<>(i2);
        }

        @Override // rx.o.d.n
        public T a() {
            int i2 = this.f37032e;
            if (i2 > 0) {
                Object obj = this.f37030c.get(i2 - 1);
                if (!this.f37029b.g(obj) && !this.f37029b.h(obj)) {
                    return this.f37029b.e(obj);
                }
                if (i2 > 1) {
                    return this.f37029b.e(this.f37030c.get(i2 - 2));
                }
            }
            return null;
        }

        @Override // rx.o.d.n
        public void b(Throwable th) {
            if (this.f37031d) {
                return;
            }
            this.f37031d = true;
            this.f37030c.add(this.f37029b.c(th));
            f37028a.getAndIncrement(this);
        }

        @Override // rx.o.d.n
        public void complete() {
            if (this.f37031d) {
                return;
            }
            this.f37031d = true;
            this.f37030c.add(this.f37029b.b());
            f37028a.getAndIncrement(this);
        }

        @Override // rx.o.d.n
        public boolean d() {
            return this.f37031d;
        }

        @Override // rx.o.d.n
        public void e(T t) {
            if (this.f37031d) {
                return;
            }
            this.f37030c.add(this.f37029b.l(t));
            f37028a.getAndIncrement(this);
        }

        @Override // rx.o.d.n
        public boolean g(g.c<? super T> cVar) {
            synchronized (cVar) {
                cVar.f37054b = false;
                if (cVar.f37055c) {
                    return false;
                }
                Integer num = (Integer) cVar.f();
                if (num != null) {
                    cVar.g(Integer.valueOf(f(num, cVar).intValue()));
                    return true;
                }
                throw new IllegalStateException("failed to find lastEmittedLink for: " + cVar);
            }
        }

        public void h(rx.b<? super T> bVar, int i2) {
            this.f37029b.a(bVar, this.f37030c.get(i2));
        }

        @Override // rx.o.d.n
        /* renamed from: i */
        public Integer f(Integer num, g.c<? super T> cVar) {
            int intValue = num.intValue();
            while (intValue < this.f37032e) {
                h(cVar, intValue);
                intValue++;
            }
            return Integer.valueOf(intValue);
        }

        @Override // rx.o.d.n
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // rx.o.d.n
        /* renamed from: j */
        public Integer c(Integer num, g.c<? super T> cVar, long j2) {
            return f(num, cVar);
        }

        @Override // rx.o.d.n
        public int size() {
            int i2 = this.f37032e;
            if (i2 > 0) {
                int i3 = i2 - 1;
                Object obj = this.f37030c.get(i3);
                if (this.f37029b.g(obj) || this.f37029b.h(obj)) {
                    return i3;
                }
            }
            return i2;
        }

        @Override // rx.o.d.n
        public T[] toArray(T[] tArr) {
            int size = size();
            if (size > 0) {
                if (size > tArr.length) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 < size; i2++) {
                    tArr[i2] = this.f37030c.get(i2);
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

    d(a.m0<T> m0Var, rx.o.g<T> gVar, n<T, ?> nVar) {
        super(m0Var);
        this.f37001e = gVar;
        this.f37000d = nVar;
    }

    private boolean F5(g.c<? super T> cVar) {
        if (cVar.f37058f) {
            return true;
        }
        if (!this.f37000d.g(cVar)) {
            return false;
        }
        cVar.f37058f = true;
        cVar.g(null);
        return false;
    }

    public static <T> d<T> G5() {
        return H5(16);
    }

    public static <T> d<T> H5(int i2) {
        r rVar = new r(i2);
        rx.o.g gVar = new rx.o.g();
        gVar.f37042f = new a(rVar);
        gVar.f37043g = new b(rVar);
        gVar.f37044h = new c(rVar);
        return new d<>(gVar, gVar, rVar);
    }

    static <T> d<T> I5() {
        g gVar = new g(new i(), UtilityFunctions.c(), UtilityFunctions.c());
        return K5(gVar, new h(gVar));
    }

    public static <T> d<T> J5(int i2) {
        g gVar = new g(new o(i2), UtilityFunctions.c(), UtilityFunctions.c());
        return K5(gVar, new h(gVar));
    }

    static final <T> d<T> K5(g<T> gVar, rx.k.b<g.c<T>> bVar) {
        rx.o.g gVar2 = new rx.o.g();
        gVar2.f37042f = bVar;
        gVar2.f37043g = new C0892d(gVar);
        gVar2.f37044h = new e(gVar);
        return new d<>(gVar2, gVar2, gVar);
    }

    public static <T> d<T> L5(long j2, TimeUnit timeUnit, rx.d dVar) {
        g gVar = new g(new p(timeUnit.toMillis(j2), dVar), new f(dVar), new m());
        return K5(gVar, new q(gVar, dVar));
    }

    public static <T> d<T> M5(long j2, TimeUnit timeUnit, int i2, rx.d dVar) {
        g gVar = new g(new l(new o(i2), new p(timeUnit.toMillis(j2), dVar)), new f(dVar), new m());
        return K5(gVar, new q(gVar, dVar));
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean A5() {
        rx.o.g<T> gVar = this.f37001e;
        NotificationLite<T> notificationLite = gVar.f37045i;
        Object c2 = gVar.c();
        return (c2 == null || notificationLite.h(c2)) ? false : true;
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f37001e.e().length > 0;
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean C5() {
        rx.o.g<T> gVar = this.f37001e;
        return gVar.f37045i.h(gVar.c());
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean D5() {
        return N5();
    }

    @rx.j.b
    public boolean N5() {
        return !this.f37000d.isEmpty();
    }

    @rx.j.b
    public int O5() {
        return this.f37000d.size();
    }

    int P5() {
        return this.f37001e.f37039c.f37052e.length;
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f37001e.f37041e) {
            this.f37000d.complete();
            for (g.c<? super T> cVar : this.f37001e.h(NotificationLite.f().b())) {
                if (F5(cVar)) {
                    cVar.onCompleted();
                }
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        if (this.f37001e.f37041e) {
            this.f37000d.b(th);
            ArrayList arrayList = null;
            for (g.c<? super T> cVar : this.f37001e.h(NotificationLite.f().c(th))) {
                try {
                    if (F5(cVar)) {
                        cVar.onError(th);
                    }
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.b
    public void onNext(T t) {
        if (this.f37001e.f37041e) {
            this.f37000d.e(t);
            for (g.c<? super T> cVar : this.f37001e.e()) {
                if (F5(cVar)) {
                    cVar.onNext(t);
                }
            }
        }
    }

    @Override // rx.o.f
    @rx.j.b
    public Throwable w5() {
        rx.o.g<T> gVar = this.f37001e;
        NotificationLite<T> notificationLite = gVar.f37045i;
        Object c2 = gVar.c();
        if (notificationLite.h(c2)) {
            return notificationLite.d(c2);
        }
        return null;
    }

    @Override // rx.o.f
    public T x5() {
        return this.f37000d.a();
    }

    @Override // rx.o.f
    @rx.j.b
    public T[] z5(T[] tArr) {
        return this.f37000d.toArray(tArr);
    }
}
