package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorMapNotification;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.a1;
import rx.internal.operators.a2;
import rx.internal.operators.a3;
import rx.internal.operators.b1;
import rx.internal.operators.b2;
import rx.internal.operators.c1;
import rx.internal.operators.c2;
import rx.internal.operators.d1;
import rx.internal.operators.d2;
import rx.internal.operators.e1;
import rx.internal.operators.e2;
import rx.internal.operators.f2;
import rx.internal.operators.g1;
import rx.internal.operators.g2;
import rx.internal.operators.h1;
import rx.internal.operators.h2;
import rx.internal.operators.i1;
import rx.internal.operators.i2;
import rx.internal.operators.j1;
import rx.internal.operators.j2;
import rx.internal.operators.k1;
import rx.internal.operators.k2;
import rx.internal.operators.l1;
import rx.internal.operators.l2;
import rx.internal.operators.m1;
import rx.internal.operators.n1;
import rx.internal.operators.n2;
import rx.internal.operators.o1;
import rx.internal.operators.o2;
import rx.internal.operators.p1;
import rx.internal.operators.p2;
import rx.internal.operators.q0;
import rx.internal.operators.q1;
import rx.internal.operators.q2;
import rx.internal.operators.r0;
import rx.internal.operators.r1;
import rx.internal.operators.r2;
import rx.internal.operators.s0;
import rx.internal.operators.s1;
import rx.internal.operators.s2;
import rx.internal.operators.t0;
import rx.internal.operators.t1;
import rx.internal.operators.t2;
import rx.internal.operators.u0;
import rx.internal.operators.u1;
import rx.internal.operators.u2;
import rx.internal.operators.v0;
import rx.internal.operators.v1;
import rx.internal.operators.v2;
import rx.internal.operators.w0;
import rx.internal.operators.w1;
import rx.internal.operators.w2;
import rx.internal.operators.x0;
import rx.internal.operators.x1;
import rx.internal.operators.x2;
import rx.internal.operators.y0;
import rx.internal.operators.y1;
import rx.internal.operators.y2;
import rx.internal.operators.z0;
import rx.internal.operators.z1;
import rx.internal.operators.z2;
import rx.internal.producers.SingleProducer;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public class a<T> {

    /* renamed from: a */
    private static final rx.m.b f35644a = rx.m.d.b().c();

    /* renamed from: b */
    final m0<T> f35645b;

    /* renamed from: rx.a$a */
    class C0833a implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f35646a;

        C0833a(rx.k.b bVar) {
            this.f35646a = bVar;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35646a.call(t);
        }
    }

    static class a0 implements rx.k.o<List<? extends a<?>>, a<?>[]> {
        a0() {
        }

        @Override // rx.k.o
        public a<?>[] call(List<? extends a<?>> list) {
            return (a[]) list.toArray(new a[list.size()]);
        }
    }

    class b implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.a f35648a;

        b(rx.k.a aVar) {
            this.f35648a = aVar;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f35648a.call();
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35648a.call();
        }

        @Override // rx.b
        public final void onNext(T t) {
        }
    }

    class b0<R> implements rx.k.p<R, T, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.c f35650a;

        b0(rx.k.c cVar) {
            this.f35650a = cVar;
        }

        @Override // rx.k.p
        public final R call(R r, T t) {
            this.f35650a.call(r, t);
            return r;
        }
    }

    class c implements rx.k.o<T, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Class f35652a;

        c(Class cls) {
            this.f35652a = cls;
        }

        @Override // rx.k.o
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((c) obj);
        }

        @Override // rx.k.o
        public final Boolean call(T t) {
            return Boolean.valueOf(this.f35652a.isInstance(t));
        }
    }

    class c0 implements rx.k.o<T, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Object f35654a;

        c0(Object obj) {
            this.f35654a = obj;
        }

        @Override // rx.k.o
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((c0) obj);
        }

        @Override // rx.k.o
        public final Boolean call(T t) {
            Object obj = this.f35654a;
            return Boolean.valueOf(obj == null ? t == null : obj.equals(t));
        }
    }

    class d implements rx.k.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f35656a;

        /* renamed from: rx.a$d$a */
        class C0834a implements rx.k.o<Notification<?>, Void> {
            C0834a() {
            }

            @Override // rx.k.o
            public Void call(Notification<?> notification) {
                return null;
            }
        }

        d(rx.k.o oVar) {
            this.f35656a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f35656a.call(aVar.D1(new C0834a()));
        }
    }

    class d0 implements m0<T> {

        /* renamed from: a */
        final /* synthetic */ Object f35659a;

        d0(Object obj) {
            this.f35659a = obj;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            gVar.f(new SingleProducer(gVar, this.f35659a));
        }
    }

    class e implements rx.k.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f35661a;

        /* renamed from: rx.a$e$a */
        class C0835a implements rx.k.o<Notification<?>, Void> {
            C0835a() {
            }

            @Override // rx.k.o
            public Void call(Notification<?> notification) {
                return null;
            }
        }

        e(rx.k.o oVar) {
            this.f35661a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f35661a.call(aVar.D1(new C0835a()));
        }
    }

    class e0 implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.a f35664a;

        e0(rx.k.a aVar) {
            this.f35664a = aVar;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f35664a.call();
        }

        @Override // rx.b
        public final void onError(Throwable th) {
        }

        @Override // rx.b
        public final void onNext(T t) {
        }
    }

    class f implements rx.k.n<rx.o.f<? super T, ? extends T>> {
        f() {
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return rx.o.d.G5();
        }
    }

    class f0 implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f35667a;

        f0(rx.k.b bVar) {
            this.f35667a = bVar;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f35667a.call(Notification.b());
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35667a.call(Notification.d(th));
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35667a.call(Notification.e(t));
        }
    }

    class g implements rx.k.n<rx.o.f<T, T>> {
        g() {
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return rx.o.d.G5();
        }
    }

    class g0 implements rx.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f35670a;

        g0(rx.k.b bVar) {
            this.f35670a = bVar;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35670a.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
        }
    }

    class h implements rx.k.n<rx.o.f<T, T>> {

        /* renamed from: a */
        final /* synthetic */ int f35672a;

        h(int i2) {
            this.f35672a = i2;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return rx.o.d.J5(this.f35672a);
        }
    }

    private static final class h0 {

        /* renamed from: a */
        static final rx.k.p<Integer, Object, Integer> f35674a = new C0836a();

        /* renamed from: rx.a$h0$a */
        static class C0836a implements rx.k.p<Integer, Object, Integer> {
            C0836a() {
            }

            @Override // rx.k.p
            public final Integer call(Integer num, Object obj) {
                return Integer.valueOf(num.intValue() + 1);
            }
        }

        private h0() {
        }
    }

    class i implements rx.k.n<rx.o.f<T, T>> {

        /* renamed from: a */
        final /* synthetic */ long f35675a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f35676b;

        /* renamed from: c */
        final /* synthetic */ int f35677c;

        /* renamed from: d */
        final /* synthetic */ rx.d f35678d;

        i(long j2, TimeUnit timeUnit, int i2, rx.d dVar) {
            this.f35675a = j2;
            this.f35676b = timeUnit;
            this.f35677c = i2;
            this.f35678d = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return rx.o.d.M5(this.f35675a, this.f35676b, this.f35677c, this.f35678d);
        }
    }

    private static final class i0 {

        /* renamed from: a */
        static final rx.k.p<Long, Object, Long> f35680a = new C0837a();

        /* renamed from: rx.a$i0$a */
        static class C0837a implements rx.k.p<Long, Object, Long> {
            C0837a() {
            }

            @Override // rx.k.p
            public final Long call(Long l, Object obj) {
                return Long.valueOf(l.longValue() + 1);
            }
        }

        private i0() {
        }
    }

    class j implements rx.k.n<rx.o.f<T, T>> {

        /* renamed from: a */
        final /* synthetic */ int f35681a;

        /* renamed from: b */
        final /* synthetic */ rx.d f35682b;

        j(int i2, rx.d dVar) {
            this.f35681a = i2;
            this.f35682b = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return k1.a(rx.o.d.J5(this.f35681a), this.f35682b);
        }
    }

    private static final class j0 {

        /* renamed from: a */
        static final a<Object> f35684a = a.b0(new C0838a());

        /* renamed from: rx.a$j0$a */
        static class C0838a implements m0<Object> {
            C0838a() {
            }

            @Override // rx.k.b
            public void call(rx.g<? super Object> gVar) {
                gVar.onCompleted();
            }
        }

        private j0() {
        }
    }

    class k<R> implements m0<R> {

        /* renamed from: a */
        final /* synthetic */ n0 f35685a;

        k(n0 n0Var) {
            this.f35685a = n0Var;
        }

        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            try {
                rx.g gVar2 = (rx.g) a.f35644a.b(this.f35685a).call(gVar);
                try {
                    gVar2.d();
                    a.this.f35645b.call(gVar2);
                } catch (Throwable th) {
                    if (th instanceof OnErrorNotImplementedException) {
                        throw th;
                    }
                    gVar2.onError(th);
                }
            } catch (Throwable th2) {
                if (th2 instanceof OnErrorNotImplementedException) {
                    throw th2;
                }
                gVar.onError(th2);
            }
        }
    }

    private static class k0 {

        /* renamed from: a */
        static final rx.internal.operators.a0<?> f35687a = new rx.internal.operators.a0<>(UtilityFunctions.b(), true);

        private k0() {
        }
    }

    class l implements rx.k.n<rx.o.f<T, T>> {

        /* renamed from: a */
        final /* synthetic */ long f35688a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f35689b;

        /* renamed from: c */
        final /* synthetic */ rx.d f35690c;

        l(long j2, TimeUnit timeUnit, rx.d dVar) {
            this.f35688a = j2;
            this.f35689b = timeUnit;
            this.f35690c = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return rx.o.d.L5(this.f35688a, this.f35689b, this.f35690c);
        }
    }

    private static class l0<T> extends a<T> {

        /* renamed from: rx.a$l0$a */
        class C0839a implements m0<T> {
            C0839a() {
            }

            @Override // rx.k.b
            public void call(rx.g<? super T> gVar) {
            }
        }

        private static class b {

            /* renamed from: a */
            static final l0<?> f35692a = new l0<>();

            private b() {
            }
        }

        l0() {
            super(new C0839a());
        }

        static <T> l0<T> w5() {
            return (l0<T>) b.f35692a;
        }
    }

    class m implements rx.k.n<rx.o.f<T, T>> {

        /* renamed from: a */
        final /* synthetic */ rx.d f35693a;

        m(rx.d dVar) {
            this.f35693a = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public final rx.o.f<T, T> call() {
            return k1.a(rx.o.d.G5(), this.f35693a);
        }
    }

    public interface m0<T> extends rx.k.b<rx.g<? super T>> {
    }

    class n implements rx.k.n<rx.o.f<? super T, ? extends T>> {

        /* renamed from: a */
        final /* synthetic */ int f35695a;

        n(int i2) {
            this.f35695a = i2;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return rx.o.d.J5(this.f35695a);
        }
    }

    public interface n0<R, T> extends rx.k.o<rx.g<? super R>, rx.g<? super T>> {
    }

    class o implements rx.k.n<rx.o.f<? super T, ? extends T>> {

        /* renamed from: a */
        final /* synthetic */ long f35697a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f35698b;

        /* renamed from: c */
        final /* synthetic */ int f35699c;

        /* renamed from: d */
        final /* synthetic */ rx.d f35700d;

        o(long j2, TimeUnit timeUnit, int i2, rx.d dVar) {
            this.f35697a = j2;
            this.f35698b = timeUnit;
            this.f35699c = i2;
            this.f35700d = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return rx.o.d.M5(this.f35697a, this.f35698b, this.f35699c, this.f35700d);
        }
    }

    private static class o0<T> extends a<T> {

        /* renamed from: rx.a$o0$a */
        class C0840a implements m0<T> {

            /* renamed from: a */
            final /* synthetic */ Throwable f35702a;

            C0840a(Throwable th) {
                this.f35702a = th;
            }

            @Override // rx.k.b
            public void call(rx.g<? super T> gVar) {
                gVar.onError(this.f35702a);
            }
        }

        public o0(Throwable th) {
            super(new C0840a(th));
        }
    }

    class p implements rx.k.n<rx.o.f<? super T, ? extends T>> {

        /* renamed from: a */
        final /* synthetic */ int f35703a;

        /* renamed from: b */
        final /* synthetic */ rx.d f35704b;

        p(int i2, rx.d dVar) {
            this.f35703a = i2;
            this.f35704b = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return k1.a(rx.o.d.J5(this.f35703a), this.f35704b);
        }
    }

    public interface p0<T, R> extends rx.k.o<a<T>, a<R>> {
    }

    class q implements rx.k.n<rx.o.f<? super T, ? extends T>> {

        /* renamed from: a */
        final /* synthetic */ long f35706a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f35707b;

        /* renamed from: c */
        final /* synthetic */ rx.d f35708c;

        q(long j2, TimeUnit timeUnit, rx.d dVar) {
            this.f35706a = j2;
            this.f35707b = timeUnit;
            this.f35708c = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return rx.o.d.L5(this.f35706a, this.f35707b, this.f35708c);
        }
    }

    class r implements rx.k.n<rx.o.f<? super T, ? extends T>> {

        /* renamed from: a */
        final /* synthetic */ rx.d f35710a;

        r(rx.d dVar) {
            this.f35710a = dVar;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public rx.o.f<? super T, ? extends T> call() {
            return k1.a(rx.o.d.G5(), this.f35710a);
        }
    }

    class s implements rx.k.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f35712a;

        /* renamed from: rx.a$s$a */
        class C0841a implements rx.k.o<Notification<?>, Throwable> {
            C0841a() {
            }

            @Override // rx.k.o
            public Throwable call(Notification<?> notification) {
                return notification.g();
            }
        }

        s(rx.k.o oVar) {
            this.f35712a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f35712a.call(aVar.D1(new C0841a()));
        }
    }

    class t implements rx.k.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f35715a;

        /* renamed from: rx.a$t$a */
        class C0842a implements rx.k.o<Notification<?>, Throwable> {
            C0842a() {
            }

            @Override // rx.k.o
            public Throwable call(Notification<?> notification) {
                return notification.g();
            }
        }

        t(rx.k.o oVar) {
            this.f35715a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f35715a.call(aVar.D1(new C0842a()));
        }
    }

    class u extends rx.g<T> {
        u() {
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
        }
    }

    static class v implements rx.k.p<T, T, Boolean> {
        v() {
        }

        @Override // rx.k.p
        public final Boolean call(T t, T t2) {
            if (t == null) {
                return Boolean.valueOf(t2 == null);
            }
            return Boolean.valueOf(t.equals(t2));
        }
    }

    class w extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f35719f;

        w(rx.k.b bVar) {
            this.f35719f = bVar;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35719f.call(t);
        }
    }

    class x extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f35721f;

        /* renamed from: g */
        final /* synthetic */ rx.k.b f35722g;

        x(rx.k.b bVar, rx.k.b bVar2) {
            this.f35721f = bVar;
            this.f35722g = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35721f.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35722g.call(t);
        }
    }

    class y extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.a f35724f;

        /* renamed from: g */
        final /* synthetic */ rx.k.b f35725g;

        /* renamed from: h */
        final /* synthetic */ rx.k.b f35726h;

        y(rx.k.a aVar, rx.k.b bVar, rx.k.b bVar2) {
            this.f35724f = aVar;
            this.f35725g = bVar;
            this.f35726h = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
            this.f35724f.call();
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35725g.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35726h.call(t);
        }
    }

    class z extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.b f35728f;

        z(rx.b bVar) {
            this.f35728f = bVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35728f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35728f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35728f.onNext(t);
        }
    }

    protected a(m0<T> m0Var) {
        this.f35645b = m0Var;
    }

    @Deprecated
    public static final a<Long> A4(long j2, long j3, TimeUnit timeUnit, rx.d dVar) {
        return i1(j2, j3, timeUnit, dVar);
    }

    public static final a<Long> B4(long j2, TimeUnit timeUnit) {
        return C4(j2, timeUnit, rx.n.f.a());
    }

    public static final a<Long> C4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return b0(new rx.internal.operators.w(j2, timeUnit, dVar));
    }

    public static final <T, R> a<R> D(List<? extends a<? extends T>> list, rx.k.x<? extends R> xVar) {
        return b0(new rx.internal.operators.k(list, xVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a<R> E(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, a<? extends T9> aVar9, rx.k.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9), rx.k.z.n(wVar));
    }

    public static final <T> a<T> E0() {
        return (a<T>) j0.f35684a;
    }

    private final <R> a<R> E1(rx.k.o<? super T, ? extends R> oVar, rx.k.o<? super Throwable, ? extends R> oVar2, rx.k.n<? extends R> nVar) {
        return B1(new OperatorMapNotification(oVar, oVar2, nVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> a<R> F(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, rx.k.v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8), rx.k.z.m(vVar));
    }

    public static final <T> a<T> F0(Throwable th) {
        return new o0(th);
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> a<R> G(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, rx.k.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7), rx.k.z.l(uVar));
    }

    public static final <T> a<T> G1(Iterable<? extends a<? extends T>> iterable) {
        return I1(Y0(iterable));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> a<R> H(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, rx.k.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6), rx.k.z.k(tVar));
    }

    public static final <T> a<T> H1(Iterable<? extends a<? extends T>> iterable, int i2) {
        return J1(Y0(iterable), i2);
    }

    public static final <T1, T2, T3, T4, T5, R> a<R> I(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, rx.k.s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5), rx.k.z.j(sVar));
    }

    public static final <T> a<T> I1(a<? extends a<? extends T>> aVar) {
        return aVar.getClass() == rx.internal.util.g.class ? ((rx.internal.util.g) aVar).z5(UtilityFunctions.c()) : (a<T>) aVar.B1(OperatorMerge.a(false));
    }

    public static final <T1, T2, T3, T4, R> a<R> J(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, rx.k.r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4), rx.k.z.i(rVar));
    }

    @rx.j.b
    public static final <T> a<T> J1(a<? extends a<? extends T>> aVar, int i2) {
        return aVar.getClass() == rx.internal.util.g.class ? ((rx.internal.util.g) aVar).z5(UtilityFunctions.c()) : (a<T>) aVar.B1(OperatorMerge.b(false, i2));
    }

    public static final <T1, T2, T3, R> a<R> K(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, rx.k.q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3), rx.k.z.h(qVar));
    }

    public static final <T> a<T> K1(a<? extends T> aVar, a<? extends T> aVar2) {
        return I1(Y0(Arrays.asList(aVar, aVar2)));
    }

    public static final <T1, T2, R> a<R> L(a<? extends T1> aVar, a<? extends T2> aVar2, rx.k.p<? super T1, ? super T2, ? extends R> pVar) {
        return D(Arrays.asList(aVar, aVar2), rx.k.z.g(pVar));
    }

    public static final <T> a<T> L1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3)));
    }

    public static final <T> a<T> M1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4)));
    }

    public static final <T> a<T> N(a<? extends a<? extends T>> aVar) {
        return (a<T>) aVar.B1(rx.internal.operators.h0.a());
    }

    public static final <T> a<T> N1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5)));
    }

    public static final <T> a<T> O(a<? extends T> aVar, a<? extends T> aVar2) {
        return N(o1(aVar, aVar2));
    }

    public static final <T> a<T> O1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6)));
    }

    public static final <T> a<T> P(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return N(p1(aVar, aVar2, aVar3));
    }

    public static final <T> a<T> P1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7)));
    }

    public static final <T> a<T> Q(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return N(q1(aVar, aVar2, aVar3, aVar4));
    }

    public static final <T> a<T> Q1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8)));
    }

    public static final <T> a<T> R(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return N(r1(aVar, aVar2, aVar3, aVar4, aVar5));
    }

    public static final <T> a<T> R1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9)));
    }

    public static final <T> a<T> R3(a<? extends a<? extends T>> aVar) {
        return (a<T>) aVar.B1(z1.a());
    }

    public static final <T> a<T> S(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return N(s1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6));
    }

    public static final <T> a<T> S1(a<? extends T>[] aVarArr) {
        return I1(c1(aVarArr));
    }

    public static final <T> a<T> T(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return N(t1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7));
    }

    @rx.j.b
    public static final <T> a<T> T1(a<? extends T>[] aVarArr, int i2) {
        return J1(c1(aVarArr), i2);
    }

    public static final <T> a<T> U(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return N(u1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8));
    }

    public static final <T> a<T> U1(a<? extends a<? extends T>> aVar) {
        return (a<T>) aVar.B1(OperatorMerge.a(true));
    }

    public static final <T> a<T> V(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return N(v1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9));
    }

    @rx.j.b
    public static final <T> a<T> V1(a<? extends a<? extends T>> aVar, int i2) {
        return (a<T>) aVar.B1(OperatorMerge.b(true, i2));
    }

    public static final <T, Resource> a<T> V4(rx.k.n<Resource> nVar, rx.k.o<? super Resource, ? extends a<? extends T>> oVar, rx.k.b<? super Resource> bVar) {
        return W4(nVar, oVar, bVar, false);
    }

    public static final <T> a<T> W1(a<? extends T> aVar, a<? extends T> aVar2) {
        return U1(o1(aVar, aVar2));
    }

    @rx.j.b
    public static final <T, Resource> a<T> W4(rx.k.n<Resource> nVar, rx.k.o<? super Resource, ? extends a<? extends T>> oVar, rx.k.b<? super Resource> bVar, boolean z2) {
        return b0(new OnSubscribeUsing(nVar, oVar, bVar, z2));
    }

    public static final <T> a<T> X1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return U1(p1(aVar, aVar2, aVar3));
    }

    public static final <T> a<T> Y0(Iterable<? extends T> iterable) {
        return b0(new rx.internal.operators.o(iterable));
    }

    public static final <T> a<T> Y1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return U1(q1(aVar, aVar2, aVar3, aVar4));
    }

    public static final <T> a<T> Z0(Future<? extends T> future) {
        return b0(rx.internal.operators.y.a(future));
    }

    public static final <T> a<T> Z1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return U1(r1(aVar, aVar2, aVar3, aVar4, aVar5));
    }

    public static final <T> a<T> a1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return b0(rx.internal.operators.y.b(future, j2, timeUnit));
    }

    public static final <T> a<T> a2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return U1(s1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6));
    }

    public static final <T> a<T> b0(m0<T> m0Var) {
        return new a<>(f35644a.a(m0Var));
    }

    public static final <T> a<T> b1(Future<? extends T> future, rx.d dVar) {
        return b0(rx.internal.operators.y.a(future)).O3(dVar);
    }

    public static final <T> a<T> b2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return U1(t1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7));
    }

    public static final <T> a<T> c(Iterable<? extends a<? extends T>> iterable) {
        return b0(rx.internal.operators.h.b(iterable));
    }

    public static final <T> a<T> c1(T[] tArr) {
        return Y0(Arrays.asList(tArr));
    }

    public static final <T> a<T> c2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return U1(u1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8));
    }

    public static final <T> a<T> d(a<? extends T> aVar, a<? extends T> aVar2) {
        return b0(rx.internal.operators.h.c(aVar, aVar2));
    }

    public static final <T> a<T> d2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return U1(v1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9));
    }

    public static final <T> a<T> e(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return b0(rx.internal.operators.h.d(aVar, aVar2, aVar3));
    }

    public static final <T> a<T> f(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return b0(rx.internal.operators.h.e(aVar, aVar2, aVar3, aVar4));
    }

    public static final <T> a<T> g(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return b0(rx.internal.operators.h.f(aVar, aVar2, aVar3, aVar4, aVar5));
    }

    public static final <T> a<T> g0(rx.k.n<a<T>> nVar) {
        return b0(new rx.internal.operators.l(nVar));
    }

    public static final <T> a<T> g2() {
        return l0.w5();
    }

    public static final <T> a<T> h(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return b0(rx.internal.operators.h.g(aVar, aVar2, aVar3, aVar4, aVar5, aVar6));
    }

    public static final a<Long> h1(long j2, long j3, TimeUnit timeUnit) {
        return i1(j2, j3, timeUnit, rx.n.f.a());
    }

    public static final <T> a<Boolean> h3(a<? extends T> aVar, a<? extends T> aVar2) {
        return i3(aVar, aVar2, new v());
    }

    public static final <T> a<T> i(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return b0(rx.internal.operators.h.h(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7));
    }

    public static final a<Long> i1(long j2, long j3, TimeUnit timeUnit, rx.d dVar) {
        return b0(new rx.internal.operators.x(j2, j3, timeUnit, dVar));
    }

    public static final <T> a<Boolean> i3(a<? extends T> aVar, a<? extends T> aVar2, rx.k.p<? super T, ? super T, Boolean> pVar) {
        return p1.c(aVar, aVar2, pVar);
    }

    public static final <T> a<T> j(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return b0(rx.internal.operators.h.i(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8));
    }

    public static final a<Long> j1(long j2, TimeUnit timeUnit) {
        return i1(j2, j2, timeUnit, rx.n.f.a());
    }

    public static final <T> a<T> k(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return b0(rx.internal.operators.h.j(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9));
    }

    public static final a<Long> k1(long j2, TimeUnit timeUnit, rx.d dVar) {
        return i1(j2, j2, timeUnit, dVar);
    }

    public static final <R> a<R> k5(Iterable<? extends a<?>> iterable, rx.k.x<? extends R> xVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends a<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return n1(arrayList.toArray(new a[arrayList.size()])).B1(new OperatorZip(xVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a<R> l5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, a<? extends T9> aVar9, rx.k.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9}).B1(new OperatorZip(wVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> a<R> m5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, rx.k.v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8}).B1(new OperatorZip(vVar));
    }

    public static final <T> a<T> n1(T t2) {
        return rx.internal.util.g.x5(t2);
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> a<R> n5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, rx.k.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7}).B1(new OperatorZip(uVar));
    }

    public static final <T> a<T> o1(T t2, T t3) {
        return Y0(Arrays.asList(t2, t3));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> a<R> o5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, rx.k.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6}).B1(new OperatorZip(tVar));
    }

    public static final <T> a<T> p1(T t2, T t3, T t4) {
        return Y0(Arrays.asList(t2, t3, t4));
    }

    public static final <T1, T2, T3, T4, T5, R> a<R> p5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, rx.k.s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5}).B1(new OperatorZip(sVar));
    }

    public static final <T> a<T> q1(T t2, T t3, T t4, T t5) {
        return Y0(Arrays.asList(t2, t3, t4, t5));
    }

    public static final <T1, T2, T3, T4, R> a<R> q5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, rx.k.r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4}).B1(new OperatorZip(rVar));
    }

    public static final <T> a<T> r1(T t2, T t3, T t4, T t5, T t6) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6));
    }

    public static final <T1, T2, T3, R> a<R> r5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, rx.k.q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return n1(new a[]{aVar, aVar2, aVar3}).B1(new OperatorZip(qVar));
    }

    public static final <T> a<T> s1(T t2, T t3, T t4, T t5, T t6, T t7) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6, t7));
    }

    public static final <T1, T2, R> a<R> s5(a<? extends T1> aVar, a<? extends T2> aVar2, rx.k.p<? super T1, ? super T2, ? extends R> pVar) {
        return n1(new a[]{aVar, aVar2}).B1(new OperatorZip(pVar));
    }

    public static final <T> a<T> t1(T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6, t7, t8));
    }

    public static final <R> a<R> t5(a<? extends a<?>> aVar, rx.k.x<? extends R> xVar) {
        return aVar.G4().D1(new a0()).B1(new OperatorZip(xVar));
    }

    public static final <T> a<T> u1(T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6, t7, t8, t9));
    }

    public static final <T> a<T> v1(T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6, t7, t8, t9, t10));
    }

    public static final <T> a<T> w1(T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        return Y0(Arrays.asList(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
    }

    public static final a<Integer> x2(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i3 == 0) {
            return E0();
        }
        if (i2 <= (Integer.MAX_VALUE - i3) + 1) {
            return i3 == 1 ? n1(Integer.valueOf(i2)) : b0(new rx.internal.operators.s(i2, (i3 - 1) + i2));
        }
        throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
    }

    public static final a<Integer> y2(int i2, int i3, rx.d dVar) {
        return x2(i2, i3).O3(dVar);
    }

    @Deprecated
    public static final a<Long> z4(long j2, long j3, TimeUnit timeUnit) {
        return i1(j2, j3, timeUnit, rx.n.f.a());
    }

    public final a<T> A(int i2) {
        return b0(new rx.internal.operators.j(this, i2));
    }

    public final a<T> A0(rx.k.a aVar) {
        return (a<T>) B1(new rx.internal.operators.p0(new b(aVar)));
    }

    public final a<T> A1(T t2, rx.k.o<? super T, Boolean> oVar) {
        return H0(oVar).W3(1).n3(t2);
    }

    public final a<T> A2(rx.k.p<T, T, T> pVar) {
        return g3(pVar).x1();
    }

    public final a<T> A3(T t2, T t3, T t4) {
        return O(p1(t2, t3, t4), this);
    }

    public final <R> a<R> B(Class<R> cls) {
        return B1(new rx.internal.operators.g0(cls));
    }

    public final a<T> B0(rx.k.a aVar) {
        return (a<T>) B1(new s0(aVar));
    }

    public final <R> a<R> B1(n0<? extends R, ? super T> n0Var) {
        return new a<>(new k(n0Var));
    }

    public final a<T> B2() {
        return rx.internal.operators.t.e(this);
    }

    public final a<T> B3(T t2, T t3, T t4, T t5) {
        return O(q1(t2, t3, t4, t5), this);
    }

    public final <R> a<R> C(rx.k.n<R> nVar, rx.k.c<R, ? super T> cVar) {
        return B1(new o1((rx.k.n) nVar, (rx.k.p) new b0(cVar))).x1();
    }

    public final a<T> C0(int i2) {
        return (a<T>) B1(new OperatorElementAt(i2));
    }

    public final a<T> C1(int i2) {
        return S3(i2);
    }

    public final a<T> C2(long j2) {
        return rx.internal.operators.t.f(this, j2);
    }

    public final a<T> C3(T t2, T t3, T t4, T t5, T t6) {
        return O(r1(t2, t3, t4, t5, t6), this);
    }

    public final a<T> D0(int i2, T t2) {
        return (a<T>) B1(new OperatorElementAt(i2, t2));
    }

    public final <R> a<R> D1(rx.k.o<? super T, ? extends R> oVar) {
        return B1(new x0(oVar));
    }

    public final a<T> D2(long j2, rx.d dVar) {
        return rx.internal.operators.t.g(this, j2, dVar);
    }

    public final a<T> D3(T t2, T t3, T t4, T t5, T t6, T t7) {
        return O(s1(t2, t3, t4, t5, t6, t7), this);
    }

    public final a<rx.n.j<T>> D4() {
        return E4(rx.n.f.c());
    }

    public final a<T> E2(rx.d dVar) {
        return rx.internal.operators.t.h(this, dVar);
    }

    public final a<T> E3(T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return O(t1(t2, t3, t4, t5, t6, t7, t8), this);
    }

    public final a<rx.n.j<T>> E4(rx.d dVar) {
        return (a<rx.n.j<T>>) B1(new o2(dVar));
    }

    public final a<Notification<T>> F1() {
        return (a<Notification<T>>) B1(z0.a());
    }

    public final a<T> F2(rx.k.o<? super a<? extends Void>, ? extends a<?>> oVar) {
        return rx.internal.operators.t.i(this, new e(oVar));
    }

    public final a<T> F3(T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return O(u1(t2, t3, t4, t5, t6, t7, t8, t9), this);
    }

    public final rx.observables.a<T> F4() {
        return rx.observables.a.g(this);
    }

    public final a<Boolean> G0(rx.k.o<? super T, Boolean> oVar) {
        return B1(new rx.internal.operators.a0(oVar, false));
    }

    public final a<T> G2(rx.k.o<? super a<? extends Void>, ? extends a<?>> oVar, rx.d dVar) {
        return rx.internal.operators.t.j(this, new d(oVar), dVar);
    }

    public final a<T> G3(T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return O(v1(t2, t3, t4, t5, t6, t7, t8, t9, t10), this);
    }

    public final a<List<T>> G4() {
        return (a<List<T>>) B1(r2.a());
    }

    public final a<T> H0(rx.k.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new t0(oVar));
    }

    public final <R> a<R> H2(rx.k.o<? super a<T>, ? extends a<R>> oVar) {
        return b0(new rx.internal.operators.r(this, new g(), oVar));
    }

    public final a<T> H3(a<T> aVar) {
        return O(aVar, this);
    }

    public final <K> a<Map<K, T>> H4(rx.k.o<? super T, ? extends K> oVar) {
        return (a<Map<K, T>>) B1(new p2(oVar, UtilityFunctions.c()));
    }

    public final a<T> I0(rx.k.a aVar) {
        return (a<T>) B1(new u0(aVar));
    }

    public final <R> a<R> I2(rx.k.o<? super a<T>, ? extends a<R>> oVar, int i2) {
        return b0(new rx.internal.operators.r(this, new h(i2), oVar));
    }

    public final rx.h I3() {
        return K3(new u());
    }

    public final <K, V> a<Map<K, V>> I4(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2) {
        return (a<Map<K, V>>) B1(new p2(oVar, oVar2));
    }

    public final a<T> J0() {
        return S3(1).l3();
    }

    public final <R> a<R> J2(rx.k.o<? super a<T>, ? extends a<R>> oVar, int i2, long j2, TimeUnit timeUnit) {
        return K2(oVar, i2, j2, timeUnit, rx.n.f.a());
    }

    public final rx.h J3(rx.b<? super T> bVar) {
        return bVar instanceof rx.g ? K3((rx.g) bVar) : K3(new z(bVar));
    }

    public final <K, V> a<Map<K, V>> J4(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, V>> nVar) {
        return (a<Map<K, V>>) B1(new p2(oVar, oVar2, nVar));
    }

    public final a<T> K0(rx.k.o<? super T, Boolean> oVar) {
        return V3(oVar).l3();
    }

    public final <R> a<R> K2(rx.k.o<? super a<T>, ? extends a<R>> oVar, int i2, long j2, TimeUnit timeUnit, rx.d dVar) {
        if (i2 >= 0) {
            return b0(new rx.internal.operators.r(this, new i(j2, timeUnit, i2, dVar), oVar));
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final rx.h K3(rx.g<? super T> gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (this.f35645b == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        gVar.d();
        if (!(gVar instanceof rx.l.b)) {
            gVar = new rx.l.b(gVar);
        }
        try {
            rx.m.b bVar = f35644a;
            bVar.e(this, this.f35645b).call(gVar);
            return bVar.d(gVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                gVar.onError(f35644a.c(th));
                return rx.p.f.e();
            } catch (OnErrorNotImplementedException e2) {
                throw e2;
            } catch (Throwable th2) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                f35644a.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final <K> a<Map<K, Collection<T>>> K4(rx.k.o<? super T, ? extends K> oVar) {
        return (a<Map<K, Collection<T>>>) B1(new q2(oVar, UtilityFunctions.c()));
    }

    public final a<T> L0(T t2) {
        return S3(1).n3(t2);
    }

    public final <R> a<R> L2(rx.k.o<? super a<T>, ? extends a<R>> oVar, int i2, rx.d dVar) {
        return b0(new rx.internal.operators.r(this, new j(i2, dVar), oVar));
    }

    public final rx.h L3(rx.k.b<? super T> bVar) {
        if (bVar != null) {
            return K3(new w(bVar));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final <K, V> a<Map<K, Collection<V>>> L4(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2));
    }

    public <R> a<R> M(p0<? super T, ? extends R> p0Var) {
        return (a) p0Var.call(this);
    }

    public final a<T> M0(T t2, rx.k.o<? super T, Boolean> oVar) {
        return V3(oVar).n3(t2);
    }

    public final <R> a<R> M2(rx.k.o<? super a<T>, ? extends a<R>> oVar, long j2, TimeUnit timeUnit) {
        return N2(oVar, j2, timeUnit, rx.n.f.a());
    }

    public final rx.h M3(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return K3(new x(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final <K, V> a<Map<K, Collection<V>>> M4(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, Collection<V>>> nVar) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> N0(rx.k.o<? super T, ? extends a<? extends R>> oVar) {
        return getClass() == rx.internal.util.g.class ? ((rx.internal.util.g) this).z5(oVar) : I1(D1(oVar));
    }

    public final <R> a<R> N2(rx.k.o<? super a<T>, ? extends a<R>> oVar, long j2, TimeUnit timeUnit, rx.d dVar) {
        return b0(new rx.internal.operators.r(this, new l(j2, timeUnit, dVar), oVar));
    }

    public final rx.h N3(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2, rx.k.a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (aVar != null) {
            return K3(new y(aVar, bVar2, bVar));
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }

    public final <K, V> a<Map<K, Collection<V>>> N4(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, Collection<V>>> nVar, rx.k.o<? super K, ? extends Collection<V>> oVar3) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2, nVar, oVar3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @rx.j.a
    public final <R> a<R> O0(rx.k.o<? super T, ? extends a<? extends R>> oVar, int i2) {
        return getClass() == rx.internal.util.g.class ? ((rx.internal.util.g) this).z5(oVar) : J1(D1(oVar), i2);
    }

    public final <R> a<R> O2(rx.k.o<? super a<T>, ? extends a<R>> oVar, rx.d dVar) {
        return b0(new rx.internal.operators.r(this, new m(dVar), oVar));
    }

    public final a<T> O3(rx.d dVar) {
        return this instanceof rx.internal.util.g ? ((rx.internal.util.g) this).A5(dVar) : (a<T>) f2().B1(new y1(dVar));
    }

    @rx.j.b
    public rx.e<T> O4() {
        return new rx.e<>(rx.internal.operators.v.a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> P0(rx.k.o<? super T, ? extends a<? extends R>> oVar, rx.k.o<? super Throwable, ? extends a<? extends R>> oVar2, rx.k.n<? extends a<? extends R>> nVar) {
        return I1(E1(oVar, oVar2, nVar));
    }

    public final rx.observables.b<T> P2() {
        return new a1(this, new f());
    }

    @rx.j.b
    public final a<T> P3(a<? extends T> aVar) {
        return (a<T>) B1(new a2(aVar));
    }

    public final a<List<T>> P4() {
        return (a<List<T>>) B1(new s2(10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @rx.j.a
    public final <R> a<R> Q0(rx.k.o<? super T, ? extends a<? extends R>> oVar, rx.k.o<? super Throwable, ? extends a<? extends R>> oVar2, rx.k.n<? extends a<? extends R>> nVar, int i2) {
        return J1(E1(oVar, oVar2, nVar), i2);
    }

    public final rx.observables.b<T> Q2(int i2) {
        return new a1(this, new n(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> Q3(rx.k.o<? super T, ? extends a<? extends R>> oVar) {
        return R3(D1(oVar));
    }

    @rx.j.b
    public final a<List<T>> Q4(int i2) {
        return (a<List<T>>) B1(new s2(i2));
    }

    public final <U, R> a<R> R0(rx.k.o<? super T, ? extends a<? extends U>> oVar, rx.k.p<? super T, ? super U, ? extends R> pVar) {
        return I1(B1(new y0(oVar, pVar)));
    }

    public final rx.observables.b<T> R2(int i2, long j2, TimeUnit timeUnit) {
        return S2(i2, j2, timeUnit, rx.n.f.a());
    }

    public final a<List<T>> R4(rx.k.p<? super T, ? super T, Integer> pVar) {
        return (a<List<T>>) B1(new s2(pVar, 10));
    }

    @rx.j.a
    public final <U, R> a<R> S0(rx.k.o<? super T, ? extends a<? extends U>> oVar, rx.k.p<? super T, ? super U, ? extends R> pVar, int i2) {
        return J1(B1(new y0(oVar, pVar)), i2);
    }

    public final rx.observables.b<T> S2(int i2, long j2, TimeUnit timeUnit, rx.d dVar) {
        if (i2 >= 0) {
            return new a1(this, new o(j2, timeUnit, i2, dVar));
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final a<T> S3(int i2) {
        return (a<T>) B1(new b2(i2));
    }

    @rx.j.b
    public final a<List<T>> S4(rx.k.p<? super T, ? super T, Integer> pVar, int i2) {
        return (a<List<T>>) B1(new s2(pVar, i2));
    }

    public final <R> a<R> T0(rx.k.o<? super T, ? extends Iterable<? extends R>> oVar) {
        return I1(D1(y0.a(oVar)));
    }

    public final rx.observables.b<T> T2(int i2, rx.d dVar) {
        return new a1(this, new p(i2, dVar));
    }

    public final a<T> T3(long j2, TimeUnit timeUnit) {
        return U3(j2, timeUnit, rx.n.f.a());
    }

    public final rx.h T4(rx.g<? super T> gVar) {
        try {
            gVar.d();
            rx.m.b bVar = f35644a;
            bVar.e(this, this.f35645b).call(gVar);
            return bVar.d(gVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                gVar.onError(f35644a.c(th));
                return rx.p.f.e();
            } catch (OnErrorNotImplementedException e2) {
                throw e2;
            } catch (Throwable th2) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                f35644a.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final <U, R> a<R> U0(rx.k.o<? super T, ? extends Iterable<? extends U>> oVar, rx.k.p<? super T, ? super U, ? extends R> pVar) {
        return R0(y0.a(oVar), pVar);
    }

    public final rx.observables.b<T> U2(long j2, TimeUnit timeUnit) {
        return V2(j2, timeUnit, rx.n.f.a());
    }

    public final a<T> U3(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new f2(j2, timeUnit, dVar));
    }

    public final a<T> U4(rx.d dVar) {
        return (a<T>) B1(new t2(dVar));
    }

    public final void V0(rx.k.b<? super T> bVar) {
        L3(bVar);
    }

    public final rx.observables.b<T> V2(long j2, TimeUnit timeUnit, rx.d dVar) {
        return new a1(this, new q(j2, timeUnit, dVar));
    }

    public final a<T> V3(rx.k.o<? super T, Boolean> oVar) {
        return H0(oVar).S3(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> W(rx.k.o<? super T, ? extends a<? extends R>> oVar) {
        return N(D1(oVar));
    }

    public final void W0(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2) {
        M3(bVar, bVar2);
    }

    public final rx.observables.b<T> W2(rx.d dVar) {
        return new a1(this, new r(dVar));
    }

    public final a<T> W3(int i2) {
        return i2 == 0 ? g1() : i2 == 1 ? (a<T>) B1(d2.a()) : (a<T>) B1(new c2(i2));
    }

    public final a<T> X(a<? extends T> aVar) {
        return O(this, aVar);
    }

    public final void X0(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2, rx.k.a aVar) {
        N3(bVar, bVar2, aVar);
    }

    public final a<T> X2() {
        return rx.internal.operators.t.k(this);
    }

    public final a<T> X3(int i2, long j2, TimeUnit timeUnit) {
        return Y3(i2, j2, timeUnit, rx.n.f.a());
    }

    public final a<a<T>> X4(int i2) {
        return Y4(i2, i2);
    }

    public final a<Boolean> Y(Object obj) {
        return G0(new c0(obj));
    }

    public final a<T> Y2(long j2) {
        return rx.internal.operators.t.l(this, j2);
    }

    public final a<T> Y3(int i2, long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new e2(i2, j2, timeUnit, dVar));
    }

    public final a<a<T>> Y4(int i2, int i3) {
        return (a<a<T>>) B1(new w2(i2, i3));
    }

    public final a<Integer> Z() {
        return z2(0, h0.f35674a);
    }

    public final a<T> Z2(rx.k.p<Integer, Throwable, Boolean> pVar) {
        return (a<T>) f2().B1(new l1(pVar));
    }

    public final a<T> Z3(long j2, TimeUnit timeUnit) {
        return a4(j2, timeUnit, rx.n.f.a());
    }

    public final a<a<T>> Z4(long j2, long j3, TimeUnit timeUnit) {
        return a5(j2, j3, timeUnit, Integer.MAX_VALUE, rx.n.f.a());
    }

    public final a<Long> a0() {
        return z2(0L, i0.f35680a);
    }

    public final a<T> a3(rx.k.o<? super a<? extends Throwable>, ? extends a<?>> oVar) {
        return rx.internal.operators.t.m(this, new s(oVar));
    }

    public final a<T> a4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new e2(j2, timeUnit, dVar));
    }

    public final a<a<T>> a5(long j2, long j3, TimeUnit timeUnit, int i2, rx.d dVar) {
        return (a<a<T>>) B1(new y2(j2, j3, timeUnit, i2, dVar));
    }

    public final a<Boolean> b(rx.k.o<? super T, Boolean> oVar) {
        return B1(new rx.internal.operators.z(oVar));
    }

    public final a<T> b3(rx.k.o<? super a<? extends Throwable>, ? extends a<?>> oVar, rx.d dVar) {
        return rx.internal.operators.t.n(this, new t(oVar), dVar);
    }

    public final a<List<T>> b4(int i2) {
        return W3(i2).G4();
    }

    public final a<a<T>> b5(long j2, long j3, TimeUnit timeUnit, rx.d dVar) {
        return a5(j2, j3, timeUnit, Integer.MAX_VALUE, dVar);
    }

    public final a<T> c0(long j2, TimeUnit timeUnit) {
        return d0(j2, timeUnit, rx.n.f.a());
    }

    public final a<T> c3(long j2, TimeUnit timeUnit) {
        return d3(j2, timeUnit, rx.n.f.a());
    }

    public final a<List<T>> c4(int i2, long j2, TimeUnit timeUnit) {
        return X3(i2, j2, timeUnit).G4();
    }

    public final a<a<T>> c5(long j2, TimeUnit timeUnit) {
        return b5(j2, j2, timeUnit, rx.n.f.a());
    }

    public final a<T> d0(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new rx.internal.operators.j0(j2, timeUnit, dVar));
    }

    public final <K> a<rx.observables.c<K, T>> d1(rx.k.o<? super T, ? extends K> oVar) {
        return (a<rx.observables.c<K, T>>) B1(new v0(oVar));
    }

    public final a<T> d3(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new n1(j2, timeUnit, dVar));
    }

    public final a<List<T>> d4(int i2, long j2, TimeUnit timeUnit, rx.d dVar) {
        return Y3(i2, j2, timeUnit, dVar).G4();
    }

    public final a<a<T>> d5(long j2, TimeUnit timeUnit, int i2) {
        return e5(j2, timeUnit, i2, rx.n.f.a());
    }

    public final <U> a<T> e0(rx.k.o<? super T, ? extends a<U>> oVar) {
        return (a<T>) B1(new rx.internal.operators.i0(oVar));
    }

    public final <K, R> a<rx.observables.c<K, R>> e1(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends R> oVar2) {
        return B1(new v0(oVar, oVar2));
    }

    public final a<T> e2(a<? extends T> aVar) {
        return K1(this, aVar);
    }

    public final <U> a<T> e3(a<U> aVar) {
        return (a<T>) B1(new m1(aVar));
    }

    public final a<List<T>> e4(long j2, TimeUnit timeUnit) {
        return Z3(j2, timeUnit).G4();
    }

    public final a<a<T>> e5(long j2, TimeUnit timeUnit, int i2, rx.d dVar) {
        return a5(j2, j2, timeUnit, i2, dVar);
    }

    public final a<T> f0(T t2) {
        return P3(b0(new d0(t2)));
    }

    public final <T2, D1, D2, R> a<R> f1(a<T2> aVar, rx.k.o<? super T, ? extends a<D1>> oVar, rx.k.o<? super T2, ? extends a<D2>> oVar2, rx.k.p<? super T, ? super a<T2>, ? extends R> pVar) {
        return b0(new rx.internal.operators.p(this, aVar, oVar, oVar2, pVar));
    }

    public final a<a<T>> f2() {
        return n1(this);
    }

    public final <R> a<R> f3(R r2, rx.k.p<R, ? super T, R> pVar) {
        return B1(new o1(r2, pVar));
    }

    public final a<List<T>> f4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return a4(j2, timeUnit, dVar).G4();
    }

    public final a<a<T>> f5(long j2, TimeUnit timeUnit, rx.d dVar) {
        return e5(j2, timeUnit, Integer.MAX_VALUE, dVar);
    }

    public final a<T> g1() {
        return (a<T>) B1(w0.a());
    }

    public final a<T> g3(rx.k.p<T, T, T> pVar) {
        return (a<T>) B1(new o1(pVar));
    }

    public final <E> a<T> g4(a<? extends E> aVar) {
        return (a<T>) B1(new g2(aVar));
    }

    public final <U> a<a<T>> g5(a<U> aVar) {
        return (a<a<T>>) B1(new u2(aVar));
    }

    public final a<T> h0(long j2, TimeUnit timeUnit) {
        return i0(j2, timeUnit, rx.n.f.a());
    }

    public final a<T> h2(rx.d dVar) {
        return this instanceof rx.internal.util.g ? ((rx.internal.util.g) this).A5(dVar) : (a<T>) B1(new b1(dVar));
    }

    @rx.j.b
    public final a<T> h4(rx.k.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new h2(oVar));
    }

    public final <TOpening, TClosing> a<a<T>> h5(a<? extends TOpening> aVar, rx.k.o<? super TOpening, ? extends a<? extends TClosing>> oVar) {
        return (a<a<T>>) B1(new x2(aVar, oVar));
    }

    public final a<T> i0(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new rx.internal.operators.k0(this, j2, timeUnit, dVar));
    }

    public final <R> a<R> i2(Class<R> cls) {
        return H0(new c(cls)).B(cls);
    }

    public final a<T> i4(rx.k.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new i2(oVar));
    }

    public final <TClosing> a<a<T>> i5(rx.k.n<? extends a<? extends TClosing>> nVar) {
        return (a<a<T>>) B1(new v2(nVar));
    }

    public final <U, V> a<T> j0(rx.k.n<? extends a<U>> nVar, rx.k.o<? super T, ? extends a<V>> oVar) {
        return (a<T>) n0(nVar).B1(new rx.internal.operators.l0(this, oVar));
    }

    @Deprecated
    @rx.j.b
    public final a<T> j2() {
        return k2(rx.internal.util.e.f36784c);
    }

    public final a<T> j3() {
        return (a<T>) B1(q1.a());
    }

    public final a<T> j4(long j2, TimeUnit timeUnit) {
        return k4(j2, timeUnit, rx.n.f.a());
    }

    @rx.j.b
    public final <U, R> a<R> j5(a<? extends U> aVar, rx.k.p<? super T, ? super U, ? extends R> pVar) {
        return B1(new z2(aVar, pVar));
    }

    public final <U> a<T> k0(rx.k.o<? super T, ? extends a<U>> oVar) {
        return (a<T>) B1(new rx.internal.operators.l0(this, oVar));
    }

    @Deprecated
    @rx.j.b
    public final a<T> k2(int i2) {
        return (a<T>) B1(new c1(i2));
    }

    public final a<T> k3() {
        return w2().B5();
    }

    public final a<T> k4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new j2(j2, timeUnit, dVar));
    }

    public final a<T> l(a<? extends T> aVar) {
        return d(this, aVar);
    }

    public final a<T> l0(long j2, TimeUnit timeUnit) {
        return m0(j2, timeUnit, rx.n.f.a());
    }

    public final a<Boolean> l1() {
        return B1(k0.f35687a);
    }

    public final a<T> l2() {
        return (a<T>) B1(d1.a());
    }

    public final a<T> l3() {
        return (a<T>) B1(r1.a());
    }

    public final a<T> l4(long j2, TimeUnit timeUnit) {
        return c3(j2, timeUnit);
    }

    public final a<T> m() {
        return (a<T>) B1(rx.internal.operators.b0.a());
    }

    public final a<T> m0(long j2, TimeUnit timeUnit, rx.d dVar) {
        return b0(new rx.internal.operators.m(this, j2, timeUnit, dVar));
    }

    public final <TRight, TLeftDuration, TRightDuration, R> a<R> m1(a<TRight> aVar, rx.k.o<T, a<TLeftDuration>> oVar, rx.k.o<TRight, a<TRightDuration>> oVar2, rx.k.p<T, TRight, R> pVar) {
        return b0(new rx.internal.operators.q(this, aVar, oVar, oVar2, pVar));
    }

    @rx.j.a
    public final a<T> m2(long j2) {
        return (a<T>) B1(new d1(j2));
    }

    public final a<T> m3(rx.k.o<? super T, Boolean> oVar) {
        return H0(oVar).l3();
    }

    public final a<T> m4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return d3(j2, timeUnit, dVar);
    }

    public final a<List<T>> n(int i2) {
        return o(i2, i2);
    }

    public final <U> a<T> n0(rx.k.n<? extends a<U>> nVar) {
        return b0(new rx.internal.operators.n(this, nVar));
    }

    @rx.j.a
    public final a<T> n2(long j2, rx.k.a aVar) {
        return (a<T>) B1(new d1(j2, aVar));
    }

    public final a<T> n3(T t2) {
        return (a<T>) B1(new r1(t2));
    }

    public final a<T> n4(long j2, TimeUnit timeUnit) {
        return c0(j2, timeUnit);
    }

    public final a<List<T>> o(int i2, int i3) {
        return (a<List<T>>) B1(new rx.internal.operators.d0(i2, i3));
    }

    public final <T2> a<T2> o0() {
        return (a<T2>) B1(rx.internal.operators.m0.a());
    }

    public final a<T> o2() {
        return (a<T>) B1(e1.b());
    }

    public final a<T> o3(T t2, rx.k.o<? super T, Boolean> oVar) {
        return H0(oVar).n3(t2);
    }

    public final a<T> o4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return d0(j2, timeUnit, dVar);
    }

    public final a<List<T>> p(long j2, long j3, TimeUnit timeUnit) {
        return q(j2, j3, timeUnit, rx.n.f.a());
    }

    public final a<T> p0() {
        return (a<T>) B1(rx.internal.operators.n0.a());
    }

    @rx.j.b
    public final a<T> p2(rx.k.b<? super T> bVar) {
        return (a<T>) B1(new e1(bVar));
    }

    public final a<T> p3(int i2) {
        return (a<T>) B1(new s1(i2));
    }

    public final a<rx.n.i<T>> p4() {
        return q4(rx.n.f.c());
    }

    public final a<List<T>> q(long j2, long j3, TimeUnit timeUnit, rx.d dVar) {
        return (a<List<T>>) B1(new rx.internal.operators.f0(j2, j3, timeUnit, Integer.MAX_VALUE, dVar));
    }

    public final <U> a<T> q0(rx.k.o<? super T, ? extends U> oVar) {
        return (a<T>) B1(new rx.internal.operators.n0(oVar));
    }

    @rx.j.b
    public final a<T> q2() {
        return (a<T>) B1(OperatorOnBackpressureLatest.a());
    }

    public final a<T> q3(long j2, TimeUnit timeUnit) {
        return r3(j2, timeUnit, rx.n.f.a());
    }

    public final a<rx.n.i<T>> q4(rx.d dVar) {
        return (a<rx.n.i<T>>) B1(new k2(dVar));
    }

    public final a<List<T>> r(long j2, TimeUnit timeUnit) {
        return t(j2, timeUnit, Integer.MAX_VALUE, rx.n.f.a());
    }

    public final a<T> r0() {
        return (a<T>) B1(rx.internal.operators.o0.a());
    }

    public final a<T> r2(a<? extends T> aVar) {
        return (a<T>) B1(new h1(aVar));
    }

    public final a<T> r3(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new v1(j2, timeUnit, dVar));
    }

    public final a<T> r4(long j2, TimeUnit timeUnit) {
        return t4(j2, timeUnit, null, rx.n.f.a());
    }

    public final a<List<T>> s(long j2, TimeUnit timeUnit, int i2) {
        return (a<List<T>>) B1(new rx.internal.operators.f0(j2, j2, timeUnit, i2, rx.n.f.a()));
    }

    public final <U> a<T> s0(rx.k.o<? super T, ? extends U> oVar) {
        return (a<T>) B1(new rx.internal.operators.o0(oVar));
    }

    public final a<T> s2(rx.k.o<Throwable, ? extends a<? extends T>> oVar) {
        return (a<T>) B1(new g1(oVar));
    }

    public final a<T> s3(int i2) {
        return (a<T>) B1(new t1(i2));
    }

    public final a<T> s4(long j2, TimeUnit timeUnit, a<? extends T> aVar) {
        return t4(j2, timeUnit, aVar, rx.n.f.a());
    }

    public final a<List<T>> t(long j2, TimeUnit timeUnit, int i2, rx.d dVar) {
        return (a<List<T>>) B1(new rx.internal.operators.f0(j2, j2, timeUnit, i2, dVar));
    }

    public final a<T> t0(rx.k.a aVar) {
        return (a<T>) B1(new rx.internal.operators.p0(new e0(aVar)));
    }

    public final a<T> t2(rx.k.o<Throwable, ? extends T> oVar) {
        return (a<T>) B1(new i1(oVar));
    }

    public final a<T> t3(long j2, TimeUnit timeUnit) {
        return u3(j2, timeUnit, rx.n.f.a());
    }

    public final a<T> t4(long j2, TimeUnit timeUnit, a<? extends T> aVar, rx.d dVar) {
        return (a<T>) B1(new l2(j2, timeUnit, aVar, dVar));
    }

    public final a<List<T>> u(long j2, TimeUnit timeUnit, rx.d dVar) {
        return q(j2, j2, timeUnit, dVar);
    }

    public final a<T> u0(rx.b<? super T> bVar) {
        return (a<T>) B1(new rx.internal.operators.p0(bVar));
    }

    public final a<T> u2(a<? extends T> aVar) {
        return (a<T>) B1(new j1(aVar));
    }

    public final a<T> u3(long j2, TimeUnit timeUnit, rx.d dVar) {
        return (a<T>) B1(new u1(j2, timeUnit, dVar));
    }

    public final a<T> u4(long j2, TimeUnit timeUnit, rx.d dVar) {
        return t4(j2, timeUnit, null, dVar);
    }

    public final <T2, R> a<R> u5(Iterable<? extends T2> iterable, rx.k.p<? super T, ? super T2, ? extends R> pVar) {
        return B1(new a3(iterable, pVar));
    }

    public final <B> a<List<T>> v(a<B> aVar) {
        return w(aVar, 16);
    }

    public final a<T> v0(rx.k.b<Notification<? super T>> bVar) {
        return (a<T>) B1(new rx.internal.operators.p0(new f0(bVar)));
    }

    public final <R> a<R> v2(rx.k.o<? super a<T>, ? extends a<R>> oVar) {
        return OperatorPublish.C5(this, oVar);
    }

    public final <U> a<T> v3(a<U> aVar) {
        return (a<T>) B1(new w1(aVar));
    }

    public final <U, V> a<T> v4(rx.k.n<? extends a<U>> nVar, rx.k.o<? super T, ? extends a<V>> oVar) {
        return w4(nVar, oVar, null);
    }

    public final <T2, R> a<R> v5(a<? extends T2> aVar, rx.k.p<? super T, ? super T2, ? extends R> pVar) {
        return s5(this, aVar, pVar);
    }

    public final <B> a<List<T>> w(a<B> aVar, int i2) {
        return (a<List<T>>) B1(new rx.internal.operators.c0(aVar, i2));
    }

    public final a<T> w0(rx.k.b<Throwable> bVar) {
        return (a<T>) B1(new rx.internal.operators.p0(new g0(bVar)));
    }

    public final rx.observables.b<T> w2() {
        return OperatorPublish.D5(this);
    }

    public final a<T> w3(rx.k.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new x1(x1.b(oVar)));
    }

    public final <U, V> a<T> w4(rx.k.n<? extends a<U>> nVar, rx.k.o<? super T, ? extends a<V>> oVar, a<? extends T> aVar) {
        if (oVar != null) {
            return (a<T>) B1(new n2(nVar, oVar, aVar));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    public final <TOpening, TClosing> a<List<T>> x(a<? extends TOpening> aVar, rx.k.o<? super TOpening, ? extends a<? extends TClosing>> oVar) {
        return (a<List<T>>) B1(new rx.internal.operators.e0(aVar, oVar));
    }

    public final a<T> x0(rx.k.b<? super T> bVar) {
        return (a<T>) B1(new rx.internal.operators.p0(new C0833a(bVar)));
    }

    public final a<T> x1() {
        return W3(1).l3();
    }

    public final a<T> x3(Iterable<T> iterable) {
        return O(Y0(iterable), this);
    }

    public final <V> a<T> x4(rx.k.o<? super T, ? extends a<V>> oVar) {
        return w4(null, oVar, null);
    }

    public final <TClosing> a<List<T>> y(rx.k.n<? extends a<? extends TClosing>> nVar) {
        return (a<List<T>>) B1(new rx.internal.operators.c0(nVar, 16));
    }

    @rx.j.a
    public final a<T> y0(rx.k.b<Long> bVar) {
        return (a<T>) B1(new q0(bVar));
    }

    public final a<T> y1(rx.k.o<? super T, Boolean> oVar) {
        return H0(oVar).W3(1).l3();
    }

    public final a<T> y3(T t2) {
        return O(n1(t2), this);
    }

    public final <V> a<T> y4(rx.k.o<? super T, ? extends a<V>> oVar, a<? extends T> aVar) {
        return w4(null, oVar, aVar);
    }

    public final a<T> z() {
        return b0(new rx.internal.operators.j(this));
    }

    public final a<T> z0(rx.k.a aVar) {
        return (a<T>) B1(new r0(aVar));
    }

    public final a<T> z1(T t2) {
        return W3(1).n3(t2);
    }

    public final <R> a<R> z2(R r2, rx.k.p<R, ? super T, R> pVar) {
        return f3(r2, pVar).W3(1);
    }

    public final a<T> z3(T t2, T t3) {
        return O(o1(t2, t3), this);
    }
}
