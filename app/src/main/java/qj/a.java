package qj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorMapNotification;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorZip;
import rx.internal.producers.SingleProducer;
import rx.internal.util.UtilityFunctions;
import xj.a1;
import xj.a2;
import xj.a3;
import xj.b1;
import xj.b2;
import xj.c1;
import xj.c2;
import xj.d1;
import xj.d2;
import xj.e1;
import xj.e2;
import xj.f2;
import xj.g1;
import xj.g2;
import xj.h1;
import xj.h2;
import xj.i1;
import xj.i2;
import xj.j1;
import xj.j2;
import xj.k1;
import xj.k2;
import xj.l1;
import xj.l2;
import xj.m1;
import xj.n1;
import xj.n2;
import xj.o1;
import xj.o2;
import xj.p1;
import xj.p2;
import xj.q0;
import xj.q1;
import xj.q2;
import xj.r0;
import xj.r1;
import xj.r2;
import xj.s0;
import xj.s1;
import xj.s2;
import xj.t0;
import xj.t1;
import xj.t2;
import xj.u0;
import xj.u1;
import xj.u2;
import xj.v0;
import xj.v1;
import xj.v2;
import xj.w0;
import xj.w1;
import xj.w2;
import xj.x0;
import xj.x1;
import xj.x2;
import xj.y0;
import xj.y1;
import xj.y2;
import xj.z0;
import xj.z1;
import xj.z2;

/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: c */
    public static final fk.b f30082c = fk.d.b().c();

    /* renamed from: b */
    public final m0<T> f30083b;

    public static class a0 implements wj.o<List<? extends a<?>>, a<?>[]> {
        @Override // wj.o
        public a<?>[] call(List<? extends a<?>> list) {
            return (a[]) list.toArray(new a[list.size()]);
        }
    }

    public class b0<R> implements wj.p<R, T, R> {

        /* renamed from: b */
        public final /* synthetic */ wj.c f30088b;

        public b0(wj.c cVar) {
            this.f30088b = cVar;
        }

        @Override // wj.p
        public final R call(R r10, T t10) {
            this.f30088b.call(r10, t10);
            return r10;
        }
    }

    public class c implements wj.o<T, Boolean> {

        /* renamed from: b */
        public final /* synthetic */ Class f30090b;

        public c(Class cls) {
            this.f30090b = cls;
        }

        @Override // wj.o
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((c) obj);
        }

        @Override // wj.o
        public final Boolean call(T t10) {
            return Boolean.valueOf(this.f30090b.isInstance(t10));
        }
    }

    public class c0 implements wj.o<T, Boolean> {

        /* renamed from: b */
        public final /* synthetic */ Object f30092b;

        public c0(Object obj) {
            this.f30092b = obj;
        }

        @Override // wj.o
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((c0) obj);
        }

        @Override // wj.o
        public final Boolean call(T t10) {
            Object obj = this.f30092b;
            return Boolean.valueOf(obj == null ? t10 == null : obj.equals(t10));
        }
    }

    public class d implements wj.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f30094b;

        /* renamed from: qj.a$d$a */
        public class C0768a implements wj.o<Notification<?>, Void> {
            public C0768a() {
            }

            @Override // wj.o
            public Void call(Notification<?> notification) {
                return null;
            }
        }

        public d(wj.o oVar) {
            this.f30094b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f30094b.call(aVar.D1(new C0768a()));
        }
    }

    public class d0 implements m0<T> {

        /* renamed from: b */
        public final /* synthetic */ Object f30097b;

        public d0(Object obj) {
            this.f30097b = obj;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            gVar.f(new SingleProducer(gVar, this.f30097b));
        }
    }

    public class e implements wj.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f30099b;

        /* renamed from: qj.a$e$a */
        public class C0769a implements wj.o<Notification<?>, Void> {
            public C0769a() {
            }

            @Override // wj.o
            public Void call(Notification<?> notification) {
                return null;
            }
        }

        public e(wj.o oVar) {
            this.f30099b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f30099b.call(aVar.D1(new C0769a()));
        }
    }

    public class f implements wj.n<hk.f<? super T, ? extends T>> {
        public f() {
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return hk.d.G5();
        }
    }

    public class f0 implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.b f30105b;

        public f0(wj.b bVar) {
            this.f30105b = bVar;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f30105b.call(Notification.b());
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30105b.call(Notification.d(th2));
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30105b.call(Notification.e(t10));
        }
    }

    public class g implements wj.n<hk.f<T, T>> {
        public g() {
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return hk.d.G5();
        }
    }

    public class h implements wj.n<hk.f<T, T>> {

        /* renamed from: b */
        public final /* synthetic */ int f30110b;

        public h(int i10) {
            this.f30110b = i10;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return hk.d.J5(this.f30110b);
        }
    }

    public static final class h0 {

        /* renamed from: a */
        public static final wj.p<Integer, Object, Integer> f30112a = new C0770a();

        /* renamed from: qj.a$h0$a */
        public static class C0770a implements wj.p<Integer, Object, Integer> {
            @Override // wj.p
            public final Integer call(Integer num, Object obj) {
                return Integer.valueOf(num.intValue() + 1);
            }
        }
    }

    public class i implements wj.n<hk.f<T, T>> {

        /* renamed from: b */
        public final /* synthetic */ long f30113b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f30114c;

        /* renamed from: d */
        public final /* synthetic */ int f30115d;

        /* renamed from: e */
        public final /* synthetic */ qj.d f30116e;

        public i(long j10, TimeUnit timeUnit, int i10, qj.d dVar) {
            this.f30113b = j10;
            this.f30114c = timeUnit;
            this.f30115d = i10;
            this.f30116e = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return hk.d.M5(this.f30113b, this.f30114c, this.f30115d, this.f30116e);
        }
    }

    public static final class i0 {

        /* renamed from: a */
        public static final wj.p<Long, Object, Long> f30118a = new C0771a();

        /* renamed from: qj.a$i0$a */
        public static class C0771a implements wj.p<Long, Object, Long> {
            @Override // wj.p
            public final Long call(Long l10, Object obj) {
                return Long.valueOf(l10.longValue() + 1);
            }
        }
    }

    public class j implements wj.n<hk.f<T, T>> {

        /* renamed from: b */
        public final /* synthetic */ int f30119b;

        /* renamed from: c */
        public final /* synthetic */ qj.d f30120c;

        public j(int i10, qj.d dVar) {
            this.f30119b = i10;
            this.f30120c = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return k1.a(hk.d.J5(this.f30119b), this.f30120c);
        }
    }

    public static final class j0 {

        /* renamed from: a */
        public static final a<Object> f30122a = a.b0(new C0772a());

        /* renamed from: qj.a$j0$a */
        public static class C0772a implements m0<Object> {
            @Override // wj.b
            public void call(qj.g<? super Object> gVar) {
                gVar.onCompleted();
            }
        }
    }

    public class k<R> implements m0<R> {

        /* renamed from: b */
        public final /* synthetic */ n0 f30123b;

        public k(n0 n0Var) {
            this.f30123b = n0Var;
        }

        @Override // wj.b
        public void call(qj.g<? super R> gVar) {
            try {
                qj.g gVar2 = (qj.g) a.f30082c.b(this.f30123b).call(gVar);
                try {
                    gVar2.d();
                    a.this.f30083b.call(gVar2);
                } catch (Throwable th2) {
                    if (th2 instanceof OnErrorNotImplementedException) {
                        throw th2;
                    }
                    gVar2.onError(th2);
                }
            } catch (Throwable th3) {
                if (th3 instanceof OnErrorNotImplementedException) {
                    throw th3;
                }
                gVar.onError(th3);
            }
        }
    }

    public static class k0 {

        /* renamed from: a */
        public static final xj.a0<?> f30125a = new xj.a0<>(UtilityFunctions.b(), true);
    }

    public class l implements wj.n<hk.f<T, T>> {

        /* renamed from: b */
        public final /* synthetic */ long f30126b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f30127c;

        /* renamed from: d */
        public final /* synthetic */ qj.d f30128d;

        public l(long j10, TimeUnit timeUnit, qj.d dVar) {
            this.f30126b = j10;
            this.f30127c = timeUnit;
            this.f30128d = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return hk.d.L5(this.f30126b, this.f30127c, this.f30128d);
        }
    }

    public static class l0<T> extends a<T> {

        /* renamed from: qj.a$l0$a */
        public class C0773a implements m0<T> {
            @Override // wj.b
            public void call(qj.g<? super T> gVar) {
            }
        }

        public static class b {

            /* renamed from: a */
            public static final l0<?> f30130a = new l0<>();
        }

        public l0() {
            super(new C0773a());
        }

        public static <T> l0<T> w5() {
            return (l0<T>) b.f30130a;
        }
    }

    public class m implements wj.n<hk.f<T, T>> {

        /* renamed from: b */
        public final /* synthetic */ qj.d f30131b;

        public m(qj.d dVar) {
            this.f30131b = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public final hk.f<T, T> call() {
            return k1.a(hk.d.G5(), this.f30131b);
        }
    }

    public interface m0<T> extends wj.b<qj.g<? super T>> {
    }

    public class n implements wj.n<hk.f<? super T, ? extends T>> {

        /* renamed from: b */
        public final /* synthetic */ int f30133b;

        public n(int i10) {
            this.f30133b = i10;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return hk.d.J5(this.f30133b);
        }
    }

    public interface n0<R, T> extends wj.o<qj.g<? super R>, qj.g<? super T>> {
    }

    public class o implements wj.n<hk.f<? super T, ? extends T>> {

        /* renamed from: b */
        public final /* synthetic */ long f30135b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f30136c;

        /* renamed from: d */
        public final /* synthetic */ int f30137d;

        /* renamed from: e */
        public final /* synthetic */ qj.d f30138e;

        public o(long j10, TimeUnit timeUnit, int i10, qj.d dVar) {
            this.f30135b = j10;
            this.f30136c = timeUnit;
            this.f30137d = i10;
            this.f30138e = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return hk.d.M5(this.f30135b, this.f30136c, this.f30137d, this.f30138e);
        }
    }

    public static class o0<T> extends a<T> {

        /* renamed from: qj.a$o0$a */
        public class C0774a implements m0<T> {

            /* renamed from: b */
            public final /* synthetic */ Throwable f30140b;

            public C0774a(Throwable th2) {
                this.f30140b = th2;
            }

            @Override // wj.b
            public void call(qj.g<? super T> gVar) {
                gVar.onError(this.f30140b);
            }
        }

        public o0(Throwable th2) {
            super(new C0774a(th2));
        }
    }

    public class p implements wj.n<hk.f<? super T, ? extends T>> {

        /* renamed from: b */
        public final /* synthetic */ int f30141b;

        /* renamed from: c */
        public final /* synthetic */ qj.d f30142c;

        public p(int i10, qj.d dVar) {
            this.f30141b = i10;
            this.f30142c = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return k1.a(hk.d.J5(this.f30141b), this.f30142c);
        }
    }

    public interface p0<T, R> extends wj.o<a<T>, a<R>> {
    }

    public class q implements wj.n<hk.f<? super T, ? extends T>> {

        /* renamed from: b */
        public final /* synthetic */ long f30144b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f30145c;

        /* renamed from: d */
        public final /* synthetic */ qj.d f30146d;

        public q(long j10, TimeUnit timeUnit, qj.d dVar) {
            this.f30144b = j10;
            this.f30145c = timeUnit;
            this.f30146d = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return hk.d.L5(this.f30144b, this.f30145c, this.f30146d);
        }
    }

    public class r implements wj.n<hk.f<? super T, ? extends T>> {

        /* renamed from: b */
        public final /* synthetic */ qj.d f30148b;

        public r(qj.d dVar) {
            this.f30148b = dVar;
        }

        @Override // wj.n, java.util.concurrent.Callable
        public hk.f<? super T, ? extends T> call() {
            return k1.a(hk.d.G5(), this.f30148b);
        }
    }

    public class s implements wj.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f30150b;

        /* renamed from: qj.a$s$a */
        public class C0775a implements wj.o<Notification<?>, Throwable> {
            public C0775a() {
            }

            @Override // wj.o
            public Throwable call(Notification<?> notification) {
                return notification.g();
            }
        }

        public s(wj.o oVar) {
            this.f30150b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f30150b.call(aVar.D1(new C0775a()));
        }
    }

    public class t implements wj.o<a<? extends Notification<?>>, a<?>> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f30153b;

        /* renamed from: qj.a$t$a */
        public class C0776a implements wj.o<Notification<?>, Throwable> {
            public C0776a() {
            }

            @Override // wj.o
            public Throwable call(Notification<?> notification) {
                return notification.g();
            }
        }

        public t(wj.o oVar) {
            this.f30153b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.o
        public a<?> call(a<? extends Notification<?>> aVar) {
            return (a) this.f30153b.call(aVar.D1(new C0776a()));
        }
    }

    public static class v implements wj.p<T, T, Boolean> {
        @Override // wj.p
        public final Boolean call(T t10, T t11) {
            if (t10 == null) {
                return Boolean.valueOf(t11 == null);
            }
            return Boolean.valueOf(t10.equals(t11));
        }
    }

    public class y extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.a f30162g;

        /* renamed from: h */
        public final /* synthetic */ wj.b f30163h;

        /* renamed from: i */
        public final /* synthetic */ wj.b f30164i;

        public y(wj.a aVar, wj.b bVar, wj.b bVar2) {
            this.f30162g = aVar;
            this.f30163h = bVar;
            this.f30164i = bVar2;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f30162g.call();
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30163h.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30164i.call(t10);
        }
    }

    public class z extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.b f30166g;

        public z(qj.b bVar) {
            this.f30166g = bVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f30166g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30166g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f30166g.onNext(t10);
        }
    }

    public a(m0<T> m0Var) {
        this.f30083b = m0Var;
    }

    @Deprecated
    public static final a<Long> A4(long j10, long j11, TimeUnit timeUnit, qj.d dVar) {
        return i1(j10, j11, timeUnit, dVar);
    }

    public static final a<Long> B4(long j10, TimeUnit timeUnit) {
        return C4(j10, timeUnit, gk.f.a());
    }

    public static final a<Long> C4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return b0(new xj.w(j10, timeUnit, dVar));
    }

    public static final <T, R> a<R> D(List<? extends a<? extends T>> list, wj.x<? extends R> xVar) {
        return b0(new xj.k(list, xVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a<R> E(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, a<? extends T9> aVar9, wj.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9), wj.z.n(wVar));
    }

    public static final <T> a<T> E0() {
        return (a<T>) j0.f30122a;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> a<R> F(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, wj.v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8), wj.z.m(vVar));
    }

    public static final <T> a<T> F0(Throwable th2) {
        return new o0(th2);
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> a<R> G(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, wj.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7), wj.z.l(uVar));
    }

    public static final <T> a<T> G1(Iterable<? extends a<? extends T>> iterable) {
        return I1(Y0(iterable));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> a<R> H(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, wj.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6), wj.z.k(tVar));
    }

    public static final <T> a<T> H1(Iterable<? extends a<? extends T>> iterable, int i10) {
        return J1(Y0(iterable), i10);
    }

    public static final <T1, T2, T3, T4, T5, R> a<R> I(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, wj.s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5), wj.z.j(sVar));
    }

    public static final <T> a<T> I1(a<? extends a<? extends T>> aVar) {
        return aVar.getClass() == ak.g.class ? ((ak.g) aVar).z5(UtilityFunctions.c()) : (a<T>) aVar.B1(OperatorMerge.a(false));
    }

    public static final <T1, T2, T3, T4, R> a<R> J(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, wj.r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3, aVar4), wj.z.i(rVar));
    }

    @uj.b
    public static final <T> a<T> J1(a<? extends a<? extends T>> aVar, int i10) {
        return aVar.getClass() == ak.g.class ? ((ak.g) aVar).z5(UtilityFunctions.c()) : (a<T>) aVar.B1(OperatorMerge.b(false, i10));
    }

    public static final <T1, T2, T3, R> a<R> K(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, wj.q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return D(Arrays.asList(aVar, aVar2, aVar3), wj.z.h(qVar));
    }

    public static final <T> a<T> K1(a<? extends T> aVar, a<? extends T> aVar2) {
        return I1(Y0(Arrays.asList(aVar, aVar2)));
    }

    public static final <T1, T2, R> a<R> L(a<? extends T1> aVar, a<? extends T2> aVar2, wj.p<? super T1, ? super T2, ? extends R> pVar) {
        return D(Arrays.asList(aVar, aVar2), wj.z.g(pVar));
    }

    public static final <T> a<T> L1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3)));
    }

    public static final <T> a<T> M1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return I1(Y0(Arrays.asList(aVar, aVar2, aVar3, aVar4)));
    }

    public static final <T> a<T> N(a<? extends a<? extends T>> aVar) {
        return (a<T>) aVar.B1(xj.h0.a());
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

    @uj.b
    public static final <T> a<T> T1(a<? extends T>[] aVarArr, int i10) {
        return J1(c1(aVarArr), i10);
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

    @uj.b
    public static final <T> a<T> V1(a<? extends a<? extends T>> aVar, int i10) {
        return (a<T>) aVar.B1(OperatorMerge.b(true, i10));
    }

    public static final <T, Resource> a<T> V4(wj.n<Resource> nVar, wj.o<? super Resource, ? extends a<? extends T>> oVar, wj.b<? super Resource> bVar) {
        return W4(nVar, oVar, bVar, false);
    }

    public static final <T> a<T> W1(a<? extends T> aVar, a<? extends T> aVar2) {
        return U1(o1(aVar, aVar2));
    }

    @uj.b
    public static final <T, Resource> a<T> W4(wj.n<Resource> nVar, wj.o<? super Resource, ? extends a<? extends T>> oVar, wj.b<? super Resource> bVar, boolean z10) {
        return b0(new OnSubscribeUsing(nVar, oVar, bVar, z10));
    }

    public static final <T> a<T> X1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return U1(p1(aVar, aVar2, aVar3));
    }

    public static final <T> a<T> Y0(Iterable<? extends T> iterable) {
        return b0(new xj.o(iterable));
    }

    public static final <T> a<T> Y1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return U1(q1(aVar, aVar2, aVar3, aVar4));
    }

    public static final <T> a<T> Z0(Future<? extends T> future) {
        return b0(xj.y.a(future));
    }

    public static final <T> a<T> Z1(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return U1(r1(aVar, aVar2, aVar3, aVar4, aVar5));
    }

    public static final <T> a<T> a1(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        return b0(xj.y.b(future, j10, timeUnit));
    }

    public static final <T> a<T> a2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return U1(s1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6));
    }

    public static final <T> a<T> b0(m0<T> m0Var) {
        return new a<>(f30082c.a(m0Var));
    }

    public static final <T> a<T> b1(Future<? extends T> future, qj.d dVar) {
        return b0(xj.y.a(future)).O3(dVar);
    }

    public static final <T> a<T> b2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return U1(t1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7));
    }

    public static final <T> a<T> c(Iterable<? extends a<? extends T>> iterable) {
        return b0(xj.h.b(iterable));
    }

    public static final <T> a<T> c1(T[] tArr) {
        return Y0(Arrays.asList(tArr));
    }

    public static final <T> a<T> c2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return U1(u1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8));
    }

    public static final <T> a<T> d(a<? extends T> aVar, a<? extends T> aVar2) {
        return b0(xj.h.c(aVar, aVar2));
    }

    public static final <T> a<T> d2(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return U1(v1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9));
    }

    public static final <T> a<T> e(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3) {
        return b0(xj.h.d(aVar, aVar2, aVar3));
    }

    public static final <T> a<T> f(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4) {
        return b0(xj.h.e(aVar, aVar2, aVar3, aVar4));
    }

    public static final <T> a<T> g(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5) {
        return b0(xj.h.f(aVar, aVar2, aVar3, aVar4, aVar5));
    }

    public static final <T> a<T> g0(wj.n<a<T>> nVar) {
        return b0(new xj.l(nVar));
    }

    public static final <T> a<T> g2() {
        return l0.w5();
    }

    public static final <T> a<T> h(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6) {
        return b0(xj.h.g(aVar, aVar2, aVar3, aVar4, aVar5, aVar6));
    }

    public static final a<Long> h1(long j10, long j11, TimeUnit timeUnit) {
        return i1(j10, j11, timeUnit, gk.f.a());
    }

    public static final <T> a<Boolean> h3(a<? extends T> aVar, a<? extends T> aVar2) {
        return i3(aVar, aVar2, new v());
    }

    public static final <T> a<T> i(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7) {
        return b0(xj.h.h(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7));
    }

    public static final a<Long> i1(long j10, long j11, TimeUnit timeUnit, qj.d dVar) {
        return b0(new xj.x(j10, j11, timeUnit, dVar));
    }

    public static final <T> a<Boolean> i3(a<? extends T> aVar, a<? extends T> aVar2, wj.p<? super T, ? super T, Boolean> pVar) {
        return p1.c(aVar, aVar2, pVar);
    }

    public static final <T> a<T> j(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8) {
        return b0(xj.h.i(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8));
    }

    public static final a<Long> j1(long j10, TimeUnit timeUnit) {
        return i1(j10, j10, timeUnit, gk.f.a());
    }

    public static final <T> a<T> k(a<? extends T> aVar, a<? extends T> aVar2, a<? extends T> aVar3, a<? extends T> aVar4, a<? extends T> aVar5, a<? extends T> aVar6, a<? extends T> aVar7, a<? extends T> aVar8, a<? extends T> aVar9) {
        return b0(xj.h.j(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9));
    }

    public static final a<Long> k1(long j10, TimeUnit timeUnit, qj.d dVar) {
        return i1(j10, j10, timeUnit, dVar);
    }

    public static final <R> a<R> k5(Iterable<? extends a<?>> iterable, wj.x<? extends R> xVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends a<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return n1(arrayList.toArray(new a[arrayList.size()])).B1(new OperatorZip(xVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a<R> l5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, a<? extends T9> aVar9, wj.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9}).B1(new OperatorZip(wVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> a<R> m5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, wj.v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8}).B1(new OperatorZip(vVar));
    }

    public static final <T> a<T> n1(T t10) {
        return ak.g.x5(t10);
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> a<R> n5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, wj.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7}).B1(new OperatorZip(uVar));
    }

    public static final <T> a<T> o1(T t10, T t11) {
        return Y0(Arrays.asList(t10, t11));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> a<R> o5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, wj.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6}).B1(new OperatorZip(tVar));
    }

    public static final <T> a<T> p1(T t10, T t11, T t12) {
        return Y0(Arrays.asList(t10, t11, t12));
    }

    public static final <T1, T2, T3, T4, T5, R> a<R> p5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, wj.s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4, aVar5}).B1(new OperatorZip(sVar));
    }

    public static final <T> a<T> q1(T t10, T t11, T t12, T t13) {
        return Y0(Arrays.asList(t10, t11, t12, t13));
    }

    public static final <T1, T2, T3, T4, R> a<R> q5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, wj.r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return n1(new a[]{aVar, aVar2, aVar3, aVar4}).B1(new OperatorZip(rVar));
    }

    public static final <T> a<T> r1(T t10, T t11, T t12, T t13, T t14) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14));
    }

    public static final <T1, T2, T3, R> a<R> r5(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, wj.q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return n1(new a[]{aVar, aVar2, aVar3}).B1(new OperatorZip(qVar));
    }

    public static final <T> a<T> s1(T t10, T t11, T t12, T t13, T t14, T t15) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14, t15));
    }

    public static final <T1, T2, R> a<R> s5(a<? extends T1> aVar, a<? extends T2> aVar2, wj.p<? super T1, ? super T2, ? extends R> pVar) {
        return n1(new a[]{aVar, aVar2}).B1(new OperatorZip(pVar));
    }

    public static final <T> a<T> t1(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14, t15, t16));
    }

    public static final <R> a<R> t5(a<? extends a<?>> aVar, wj.x<? extends R> xVar) {
        return aVar.G4().D1(new a0()).B1(new OperatorZip(xVar));
    }

    public static final <T> a<T> u1(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14, t15, t16, t17));
    }

    public static final <T> a<T> v1(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14, t15, t16, t17, t18));
    }

    public static final <T> a<T> w1(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        return Y0(Arrays.asList(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19));
    }

    public static final a<Integer> x2(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i11 == 0) {
            return E0();
        }
        if (i10 <= Integer.MIN_VALUE - i11) {
            return i11 == 1 ? n1(Integer.valueOf(i10)) : b0(new xj.s(i10, (i11 - 1) + i10));
        }
        throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
    }

    public static final a<Integer> y2(int i10, int i11, qj.d dVar) {
        return x2(i10, i11).O3(dVar);
    }

    @Deprecated
    public static final a<Long> z4(long j10, long j11, TimeUnit timeUnit) {
        return i1(j10, j11, timeUnit, gk.f.a());
    }

    public final a<T> A(int i10) {
        return b0(new xj.j(this, i10));
    }

    public final a<T> A0(wj.a aVar) {
        return (a<T>) B1(new xj.p0(new b(aVar)));
    }

    public final a<T> A1(T t10, wj.o<? super T, Boolean> oVar) {
        return H0(oVar).W3(1).n3(t10);
    }

    public final a<T> A2(wj.p<T, T, T> pVar) {
        return g3(pVar).x1();
    }

    public final a<T> A3(T t10, T t11, T t12) {
        return O(p1(t10, t11, t12), this);
    }

    public final <R> a<R> B(Class<R> cls) {
        return B1(new xj.g0(cls));
    }

    public final a<T> B0(wj.a aVar) {
        return (a<T>) B1(new s0(aVar));
    }

    public final <R> a<R> B1(n0<? extends R, ? super T> n0Var) {
        return new a<>(new k(n0Var));
    }

    public final a<T> B2() {
        return xj.t.e(this);
    }

    public final a<T> B3(T t10, T t11, T t12, T t13) {
        return O(q1(t10, t11, t12, t13), this);
    }

    public final <R> a<R> C(wj.n<R> nVar, wj.c<R, ? super T> cVar) {
        return B1(new o1((wj.n) nVar, (wj.p) new b0(cVar))).x1();
    }

    public final a<T> C0(int i10) {
        return (a<T>) B1(new OperatorElementAt(i10));
    }

    public final a<T> C1(int i10) {
        return S3(i10);
    }

    public final a<T> C2(long j10) {
        return xj.t.f(this, j10);
    }

    public final a<T> C3(T t10, T t11, T t12, T t13, T t14) {
        return O(r1(t10, t11, t12, t13, t14), this);
    }

    public final a<T> D0(int i10, T t10) {
        return (a<T>) B1(new OperatorElementAt(i10, t10));
    }

    public final <R> a<R> D1(wj.o<? super T, ? extends R> oVar) {
        return B1(new x0(oVar));
    }

    public final a<T> D2(long j10, qj.d dVar) {
        return xj.t.g(this, j10, dVar);
    }

    public final a<T> D3(T t10, T t11, T t12, T t13, T t14, T t15) {
        return O(s1(t10, t11, t12, t13, t14, t15), this);
    }

    public final a<gk.j<T>> D4() {
        return E4(gk.f.c());
    }

    public final <R> a<R> E1(wj.o<? super T, ? extends R> oVar, wj.o<? super Throwable, ? extends R> oVar2, wj.n<? extends R> nVar) {
        return B1(new OperatorMapNotification(oVar, oVar2, nVar));
    }

    public final a<T> E2(qj.d dVar) {
        return xj.t.h(this, dVar);
    }

    public final a<T> E3(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        return O(t1(t10, t11, t12, t13, t14, t15, t16), this);
    }

    public final a<gk.j<T>> E4(qj.d dVar) {
        return (a<gk.j<T>>) B1(new o2(dVar));
    }

    public final a<Notification<T>> F1() {
        return (a<Notification<T>>) B1(z0.a());
    }

    public final a<T> F2(wj.o<? super a<? extends Void>, ? extends a<?>> oVar) {
        return xj.t.i(this, new e(oVar));
    }

    public final a<T> F3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        return O(u1(t10, t11, t12, t13, t14, t15, t16, t17), this);
    }

    public final dk.a<T> F4() {
        return dk.a.g(this);
    }

    public final a<Boolean> G0(wj.o<? super T, Boolean> oVar) {
        return B1(new xj.a0(oVar, false));
    }

    public final a<T> G2(wj.o<? super a<? extends Void>, ? extends a<?>> oVar, qj.d dVar) {
        return xj.t.j(this, new d(oVar), dVar);
    }

    public final a<T> G3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        return O(v1(t10, t11, t12, t13, t14, t15, t16, t17, t18), this);
    }

    public final a<List<T>> G4() {
        return (a<List<T>>) B1(r2.a());
    }

    public final a<T> H0(wj.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new t0(oVar));
    }

    public final dk.b<T> H2() {
        return new a1(this, new f());
    }

    public final a<T> H3(a<T> aVar) {
        return O(aVar, this);
    }

    public final <K> a<Map<K, T>> H4(wj.o<? super T, ? extends K> oVar) {
        return (a<Map<K, T>>) B1(new p2(oVar, UtilityFunctions.c()));
    }

    public final a<T> I0(wj.a aVar) {
        return (a<T>) B1(new u0(aVar));
    }

    public final dk.b<T> I2(int i10) {
        return new a1(this, new n(i10));
    }

    public final qj.h I3() {
        return K3(new u());
    }

    public final <K, V> a<Map<K, V>> I4(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2) {
        return (a<Map<K, V>>) B1(new p2(oVar, oVar2));
    }

    public final a<T> J0() {
        return S3(1).l3();
    }

    public final dk.b<T> J2(int i10, long j10, TimeUnit timeUnit) {
        return K2(i10, j10, timeUnit, gk.f.a());
    }

    public final qj.h J3(qj.b<? super T> bVar) {
        return bVar instanceof qj.g ? K3((qj.g) bVar) : K3(new z(bVar));
    }

    public final <K, V> a<Map<K, V>> J4(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, V>> nVar) {
        return (a<Map<K, V>>) B1(new p2(oVar, oVar2, nVar));
    }

    public final a<T> K0(wj.o<? super T, Boolean> oVar) {
        return V3(oVar).l3();
    }

    public final dk.b<T> K2(int i10, long j10, TimeUnit timeUnit, qj.d dVar) {
        if (i10 >= 0) {
            return new a1(this, new o(j10, timeUnit, i10, dVar));
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final qj.h K3(qj.g<? super T> gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (this.f30083b == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        gVar.d();
        if (!(gVar instanceof ek.b)) {
            gVar = new ek.b(gVar);
        }
        try {
            fk.b bVar = f30082c;
            bVar.e(this, this.f30083b).call(gVar);
            return bVar.d(gVar);
        } catch (Throwable th2) {
            vj.a.e(th2);
            try {
                gVar.onError(f30082c.c(th2));
                return ik.f.e();
            } catch (OnErrorNotImplementedException e10) {
                throw e10;
            } catch (Throwable th3) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                f30082c.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final <K> a<Map<K, Collection<T>>> K4(wj.o<? super T, ? extends K> oVar) {
        return (a<Map<K, Collection<T>>>) B1(new q2(oVar, UtilityFunctions.c()));
    }

    public final a<T> L0(T t10) {
        return S3(1).n3(t10);
    }

    public final dk.b<T> L2(int i10, qj.d dVar) {
        return new a1(this, new p(i10, dVar));
    }

    public final qj.h L3(wj.b<? super T> bVar) {
        if (bVar != null) {
            return K3(new w(bVar));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final <K, V> a<Map<K, Collection<V>>> L4(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2));
    }

    public <R> a<R> M(p0<? super T, ? extends R> p0Var) {
        return (a) p0Var.call(this);
    }

    public final a<T> M0(T t10, wj.o<? super T, Boolean> oVar) {
        return V3(oVar).n3(t10);
    }

    public final dk.b<T> M2(long j10, TimeUnit timeUnit) {
        return N2(j10, timeUnit, gk.f.a());
    }

    public final qj.h M3(wj.b<? super T> bVar, wj.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return K3(new x(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final <K, V> a<Map<K, Collection<V>>> M4(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, Collection<V>>> nVar) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> N0(wj.o<? super T, ? extends a<? extends R>> oVar) {
        return getClass() == ak.g.class ? ((ak.g) this).z5(oVar) : I1(D1(oVar));
    }

    public final dk.b<T> N2(long j10, TimeUnit timeUnit, qj.d dVar) {
        return new a1(this, new q(j10, timeUnit, dVar));
    }

    public final qj.h N3(wj.b<? super T> bVar, wj.b<Throwable> bVar2, wj.a aVar) {
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

    public final <K, V> a<Map<K, Collection<V>>> N4(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, Collection<V>>> nVar, wj.o<? super K, ? extends Collection<V>> oVar3) {
        return (a<Map<K, Collection<V>>>) B1(new q2(oVar, oVar2, nVar, oVar3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @uj.a
    public final <R> a<R> O0(wj.o<? super T, ? extends a<? extends R>> oVar, int i10) {
        return getClass() == ak.g.class ? ((ak.g) this).z5(oVar) : J1(D1(oVar), i10);
    }

    public final dk.b<T> O2(qj.d dVar) {
        return new a1(this, new r(dVar));
    }

    public final a<T> O3(qj.d dVar) {
        return this instanceof ak.g ? ((ak.g) this).A5(dVar) : (a<T>) f2().B1(new y1(dVar));
    }

    @uj.b
    public qj.e<T> O4() {
        return new qj.e<>(xj.v.a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> P0(wj.o<? super T, ? extends a<? extends R>> oVar, wj.o<? super Throwable, ? extends a<? extends R>> oVar2, wj.n<? extends a<? extends R>> nVar) {
        return I1(E1(oVar, oVar2, nVar));
    }

    public final <R> a<R> P2(wj.o<? super a<T>, ? extends a<R>> oVar) {
        return b0(new xj.r(this, new g(), oVar));
    }

    @uj.b
    public final a<T> P3(a<? extends T> aVar) {
        return (a<T>) B1(new a2(aVar));
    }

    public final a<List<T>> P4() {
        return (a<List<T>>) B1(new s2(10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @uj.a
    public final <R> a<R> Q0(wj.o<? super T, ? extends a<? extends R>> oVar, wj.o<? super Throwable, ? extends a<? extends R>> oVar2, wj.n<? extends a<? extends R>> nVar, int i10) {
        return J1(E1(oVar, oVar2, nVar), i10);
    }

    public final <R> a<R> Q2(wj.o<? super a<T>, ? extends a<R>> oVar, int i10) {
        return b0(new xj.r(this, new h(i10), oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> Q3(wj.o<? super T, ? extends a<? extends R>> oVar) {
        return R3(D1(oVar));
    }

    @uj.b
    public final a<List<T>> Q4(int i10) {
        return (a<List<T>>) B1(new s2(i10));
    }

    public final <U, R> a<R> R0(wj.o<? super T, ? extends a<? extends U>> oVar, wj.p<? super T, ? super U, ? extends R> pVar) {
        return I1(B1(new y0(oVar, pVar)));
    }

    public final <R> a<R> R2(wj.o<? super a<T>, ? extends a<R>> oVar, int i10, long j10, TimeUnit timeUnit) {
        return S2(oVar, i10, j10, timeUnit, gk.f.a());
    }

    public final a<List<T>> R4(wj.p<? super T, ? super T, Integer> pVar) {
        return (a<List<T>>) B1(new s2(pVar, 10));
    }

    @uj.a
    public final <U, R> a<R> S0(wj.o<? super T, ? extends a<? extends U>> oVar, wj.p<? super T, ? super U, ? extends R> pVar, int i10) {
        return J1(B1(new y0(oVar, pVar)), i10);
    }

    public final <R> a<R> S2(wj.o<? super a<T>, ? extends a<R>> oVar, int i10, long j10, TimeUnit timeUnit, qj.d dVar) {
        if (i10 >= 0) {
            return b0(new xj.r(this, new i(j10, timeUnit, i10, dVar), oVar));
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final a<T> S3(int i10) {
        return (a<T>) B1(new b2(i10));
    }

    @uj.b
    public final a<List<T>> S4(wj.p<? super T, ? super T, Integer> pVar, int i10) {
        return (a<List<T>>) B1(new s2(pVar, i10));
    }

    public final <R> a<R> T0(wj.o<? super T, ? extends Iterable<? extends R>> oVar) {
        return I1(D1(y0.a(oVar)));
    }

    public final <R> a<R> T2(wj.o<? super a<T>, ? extends a<R>> oVar, int i10, qj.d dVar) {
        return b0(new xj.r(this, new j(i10, dVar), oVar));
    }

    public final a<T> T3(long j10, TimeUnit timeUnit) {
        return U3(j10, timeUnit, gk.f.a());
    }

    public final qj.h T4(qj.g<? super T> gVar) {
        try {
            gVar.d();
            fk.b bVar = f30082c;
            bVar.e(this, this.f30083b).call(gVar);
            return bVar.d(gVar);
        } catch (Throwable th2) {
            vj.a.e(th2);
            try {
                gVar.onError(f30082c.c(th2));
                return ik.f.e();
            } catch (OnErrorNotImplementedException e10) {
                throw e10;
            } catch (Throwable th3) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                f30082c.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final <U, R> a<R> U0(wj.o<? super T, ? extends Iterable<? extends U>> oVar, wj.p<? super T, ? super U, ? extends R> pVar) {
        return R0(y0.a(oVar), pVar);
    }

    public final <R> a<R> U2(wj.o<? super a<T>, ? extends a<R>> oVar, long j10, TimeUnit timeUnit) {
        return V2(oVar, j10, timeUnit, gk.f.a());
    }

    public final a<T> U3(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new f2(j10, timeUnit, dVar));
    }

    public final a<T> U4(qj.d dVar) {
        return (a<T>) B1(new t2(dVar));
    }

    public final void V0(wj.b<? super T> bVar) {
        L3(bVar);
    }

    public final <R> a<R> V2(wj.o<? super a<T>, ? extends a<R>> oVar, long j10, TimeUnit timeUnit, qj.d dVar) {
        return b0(new xj.r(this, new l(j10, timeUnit, dVar), oVar));
    }

    public final a<T> V3(wj.o<? super T, Boolean> oVar) {
        return H0(oVar).S3(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> a<R> W(wj.o<? super T, ? extends a<? extends R>> oVar) {
        return N(D1(oVar));
    }

    public final void W0(wj.b<? super T> bVar, wj.b<Throwable> bVar2) {
        M3(bVar, bVar2);
    }

    public final <R> a<R> W2(wj.o<? super a<T>, ? extends a<R>> oVar, qj.d dVar) {
        return b0(new xj.r(this, new m(dVar), oVar));
    }

    public final a<T> W3(int i10) {
        return i10 == 0 ? g1() : i10 == 1 ? (a<T>) B1(d2.a()) : (a<T>) B1(new c2(i10));
    }

    public final a<T> X(a<? extends T> aVar) {
        return O(this, aVar);
    }

    public final void X0(wj.b<? super T> bVar, wj.b<Throwable> bVar2, wj.a aVar) {
        N3(bVar, bVar2, aVar);
    }

    public final a<T> X2() {
        return xj.t.k(this);
    }

    public final a<T> X3(int i10, long j10, TimeUnit timeUnit) {
        return Y3(i10, j10, timeUnit, gk.f.a());
    }

    public final a<a<T>> X4(int i10) {
        return Y4(i10, i10);
    }

    public final a<Boolean> Y(Object obj) {
        return G0(new c0(obj));
    }

    public final a<T> Y2(long j10) {
        return xj.t.l(this, j10);
    }

    public final a<T> Y3(int i10, long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new e2(i10, j10, timeUnit, dVar));
    }

    public final a<a<T>> Y4(int i10, int i11) {
        return (a<a<T>>) B1(new w2(i10, i11));
    }

    public final a<Integer> Z() {
        return z2(0, h0.f30112a);
    }

    public final a<T> Z2(wj.p<Integer, Throwable, Boolean> pVar) {
        return (a<T>) f2().B1(new l1(pVar));
    }

    public final a<T> Z3(long j10, TimeUnit timeUnit) {
        return a4(j10, timeUnit, gk.f.a());
    }

    public final a<a<T>> Z4(long j10, long j11, TimeUnit timeUnit) {
        return a5(j10, j11, timeUnit, Integer.MAX_VALUE, gk.f.a());
    }

    public final a<Long> a0() {
        return z2(0L, i0.f30118a);
    }

    public final a<T> a3(wj.o<? super a<? extends Throwable>, ? extends a<?>> oVar) {
        return xj.t.m(this, new s(oVar));
    }

    public final a<T> a4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new e2(j10, timeUnit, dVar));
    }

    public final a<a<T>> a5(long j10, long j11, TimeUnit timeUnit, int i10, qj.d dVar) {
        return (a<a<T>>) B1(new y2(j10, j11, timeUnit, i10, dVar));
    }

    public final a<Boolean> b(wj.o<? super T, Boolean> oVar) {
        return B1(new xj.z(oVar));
    }

    public final a<T> b3(wj.o<? super a<? extends Throwable>, ? extends a<?>> oVar, qj.d dVar) {
        return xj.t.n(this, new t(oVar), dVar);
    }

    public final a<List<T>> b4(int i10) {
        return W3(i10).G4();
    }

    public final a<a<T>> b5(long j10, long j11, TimeUnit timeUnit, qj.d dVar) {
        return a5(j10, j11, timeUnit, Integer.MAX_VALUE, dVar);
    }

    public final a<T> c0(long j10, TimeUnit timeUnit) {
        return d0(j10, timeUnit, gk.f.a());
    }

    public final a<T> c3(long j10, TimeUnit timeUnit) {
        return d3(j10, timeUnit, gk.f.a());
    }

    public final a<List<T>> c4(int i10, long j10, TimeUnit timeUnit) {
        return X3(i10, j10, timeUnit).G4();
    }

    public final a<a<T>> c5(long j10, TimeUnit timeUnit) {
        return b5(j10, j10, timeUnit, gk.f.a());
    }

    public final a<T> d0(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new xj.j0(j10, timeUnit, dVar));
    }

    public final <K> a<dk.c<K, T>> d1(wj.o<? super T, ? extends K> oVar) {
        return (a<dk.c<K, T>>) B1(new v0(oVar));
    }

    public final a<T> d3(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new n1(j10, timeUnit, dVar));
    }

    public final a<List<T>> d4(int i10, long j10, TimeUnit timeUnit, qj.d dVar) {
        return Y3(i10, j10, timeUnit, dVar).G4();
    }

    public final a<a<T>> d5(long j10, TimeUnit timeUnit, int i10) {
        return e5(j10, timeUnit, i10, gk.f.a());
    }

    public final <U> a<T> e0(wj.o<? super T, ? extends a<U>> oVar) {
        return (a<T>) B1(new xj.i0(oVar));
    }

    public final <K, R> a<dk.c<K, R>> e1(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends R> oVar2) {
        return B1(new v0(oVar, oVar2));
    }

    public final a<T> e2(a<? extends T> aVar) {
        return K1(this, aVar);
    }

    public final <U> a<T> e3(a<U> aVar) {
        return (a<T>) B1(new m1(aVar));
    }

    public final a<List<T>> e4(long j10, TimeUnit timeUnit) {
        return Z3(j10, timeUnit).G4();
    }

    public final a<a<T>> e5(long j10, TimeUnit timeUnit, int i10, qj.d dVar) {
        return a5(j10, j10, timeUnit, i10, dVar);
    }

    public final a<T> f0(T t10) {
        return P3(b0(new d0(t10)));
    }

    public final <T2, D1, D2, R> a<R> f1(a<T2> aVar, wj.o<? super T, ? extends a<D1>> oVar, wj.o<? super T2, ? extends a<D2>> oVar2, wj.p<? super T, ? super a<T2>, ? extends R> pVar) {
        return b0(new xj.p(this, aVar, oVar, oVar2, pVar));
    }

    public final a<a<T>> f2() {
        return n1(this);
    }

    public final <R> a<R> f3(R r10, wj.p<R, ? super T, R> pVar) {
        return B1(new o1(r10, pVar));
    }

    public final a<List<T>> f4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return a4(j10, timeUnit, dVar).G4();
    }

    public final a<a<T>> f5(long j10, TimeUnit timeUnit, qj.d dVar) {
        return e5(j10, timeUnit, Integer.MAX_VALUE, dVar);
    }

    public final a<T> g1() {
        return (a<T>) B1(w0.a());
    }

    public final a<T> g3(wj.p<T, T, T> pVar) {
        return (a<T>) B1(new o1(pVar));
    }

    public final <E> a<T> g4(a<? extends E> aVar) {
        return (a<T>) B1(new g2(aVar));
    }

    public final <U> a<a<T>> g5(a<U> aVar) {
        return (a<a<T>>) B1(new u2(aVar));
    }

    public final a<T> h0(long j10, TimeUnit timeUnit) {
        return i0(j10, timeUnit, gk.f.a());
    }

    public final a<T> h2(qj.d dVar) {
        return this instanceof ak.g ? ((ak.g) this).A5(dVar) : (a<T>) B1(new b1(dVar));
    }

    @uj.b
    public final a<T> h4(wj.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new h2(oVar));
    }

    public final <TOpening, TClosing> a<a<T>> h5(a<? extends TOpening> aVar, wj.o<? super TOpening, ? extends a<? extends TClosing>> oVar) {
        return (a<a<T>>) B1(new x2(aVar, oVar));
    }

    public final a<T> i0(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new xj.k0(this, j10, timeUnit, dVar));
    }

    public final <R> a<R> i2(Class<R> cls) {
        return H0(new c(cls)).B(cls);
    }

    public final a<T> i4(wj.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new i2(oVar));
    }

    public final <TClosing> a<a<T>> i5(wj.n<? extends a<? extends TClosing>> nVar) {
        return (a<a<T>>) B1(new v2(nVar));
    }

    public final <U, V> a<T> j0(wj.n<? extends a<U>> nVar, wj.o<? super T, ? extends a<V>> oVar) {
        return (a<T>) n0(nVar).B1(new xj.l0(this, oVar));
    }

    @uj.b
    @Deprecated
    public final a<T> j2() {
        return k2(ak.e.f246h);
    }

    public final a<T> j3() {
        return (a<T>) B1(q1.a());
    }

    public final a<T> j4(long j10, TimeUnit timeUnit) {
        return k4(j10, timeUnit, gk.f.a());
    }

    @uj.b
    public final <U, R> a<R> j5(a<? extends U> aVar, wj.p<? super T, ? super U, ? extends R> pVar) {
        return B1(new z2(aVar, pVar));
    }

    public final <U> a<T> k0(wj.o<? super T, ? extends a<U>> oVar) {
        return (a<T>) B1(new xj.l0(this, oVar));
    }

    @uj.b
    @Deprecated
    public final a<T> k2(int i10) {
        return (a<T>) B1(new c1(i10));
    }

    public final a<T> k3() {
        return v2().B5();
    }

    public final a<T> k4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new j2(j10, timeUnit, dVar));
    }

    public final a<T> l(a<? extends T> aVar) {
        return d(this, aVar);
    }

    public final a<T> l0(long j10, TimeUnit timeUnit) {
        return m0(j10, timeUnit, gk.f.a());
    }

    public final a<Boolean> l1() {
        return B1(k0.f30125a);
    }

    public final a<T> l2() {
        return (a<T>) B1(d1.a());
    }

    public final a<T> l3() {
        return (a<T>) B1(r1.a());
    }

    public final a<T> l4(long j10, TimeUnit timeUnit) {
        return c3(j10, timeUnit);
    }

    public final a<T> m() {
        return (a<T>) B1(xj.b0.a());
    }

    public final a<T> m0(long j10, TimeUnit timeUnit, qj.d dVar) {
        return b0(new xj.m(this, j10, timeUnit, dVar));
    }

    public final <TRight, TLeftDuration, TRightDuration, R> a<R> m1(a<TRight> aVar, wj.o<T, a<TLeftDuration>> oVar, wj.o<TRight, a<TRightDuration>> oVar2, wj.p<T, TRight, R> pVar) {
        return b0(new xj.q(this, aVar, oVar, oVar2, pVar));
    }

    @uj.a
    public final a<T> m2(long j10) {
        return (a<T>) B1(new d1(j10));
    }

    public final a<T> m3(wj.o<? super T, Boolean> oVar) {
        return H0(oVar).l3();
    }

    public final a<T> m4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return d3(j10, timeUnit, dVar);
    }

    public final a<List<T>> n(int i10) {
        return o(i10, i10);
    }

    public final <U> a<T> n0(wj.n<? extends a<U>> nVar) {
        return b0(new xj.n(this, nVar));
    }

    @uj.a
    public final a<T> n2(long j10, wj.a aVar) {
        return (a<T>) B1(new d1(j10, aVar));
    }

    public final a<T> n3(T t10) {
        return (a<T>) B1(new r1(t10));
    }

    public final a<T> n4(long j10, TimeUnit timeUnit) {
        return c0(j10, timeUnit);
    }

    public final a<List<T>> o(int i10, int i11) {
        return (a<List<T>>) B1(new xj.d0(i10, i11));
    }

    public final <T2> a<T2> o0() {
        return (a<T2>) B1(xj.m0.a());
    }

    public final a<T> o2() {
        return (a<T>) B1(e1.b());
    }

    public final a<T> o3(T t10, wj.o<? super T, Boolean> oVar) {
        return H0(oVar).n3(t10);
    }

    public final a<T> o4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return d0(j10, timeUnit, dVar);
    }

    public final a<List<T>> p(long j10, long j11, TimeUnit timeUnit) {
        return q(j10, j11, timeUnit, gk.f.a());
    }

    public final a<T> p0() {
        return (a<T>) B1(xj.n0.a());
    }

    @uj.b
    public final a<T> p2(wj.b<? super T> bVar) {
        return (a<T>) B1(new e1(bVar));
    }

    public final a<T> p3(int i10) {
        return (a<T>) B1(new s1(i10));
    }

    public final a<gk.i<T>> p4() {
        return q4(gk.f.c());
    }

    public final a<List<T>> q(long j10, long j11, TimeUnit timeUnit, qj.d dVar) {
        return (a<List<T>>) B1(new xj.f0(j10, j11, timeUnit, Integer.MAX_VALUE, dVar));
    }

    public final <U> a<T> q0(wj.o<? super T, ? extends U> oVar) {
        return (a<T>) B1(new xj.n0(oVar));
    }

    @uj.b
    public final a<T> q2() {
        return (a<T>) B1(OperatorOnBackpressureLatest.a());
    }

    public final a<T> q3(long j10, TimeUnit timeUnit) {
        return r3(j10, timeUnit, gk.f.a());
    }

    public final a<gk.i<T>> q4(qj.d dVar) {
        return (a<gk.i<T>>) B1(new k2(dVar));
    }

    public final a<List<T>> r(long j10, TimeUnit timeUnit) {
        return t(j10, timeUnit, Integer.MAX_VALUE, gk.f.a());
    }

    public final a<T> r0() {
        return (a<T>) B1(xj.o0.a());
    }

    public final a<T> r2(a<? extends T> aVar) {
        return (a<T>) B1(new h1(aVar));
    }

    public final a<T> r3(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new v1(j10, timeUnit, dVar));
    }

    public final a<T> r4(long j10, TimeUnit timeUnit) {
        return t4(j10, timeUnit, null, gk.f.a());
    }

    public final a<List<T>> s(long j10, TimeUnit timeUnit, int i10) {
        return (a<List<T>>) B1(new xj.f0(j10, j10, timeUnit, i10, gk.f.a()));
    }

    public final <U> a<T> s0(wj.o<? super T, ? extends U> oVar) {
        return (a<T>) B1(new xj.o0(oVar));
    }

    public final a<T> s2(wj.o<Throwable, ? extends a<? extends T>> oVar) {
        return (a<T>) B1(new g1(oVar));
    }

    public final a<T> s3(int i10) {
        return (a<T>) B1(new t1(i10));
    }

    public final a<T> s4(long j10, TimeUnit timeUnit, a<? extends T> aVar) {
        return t4(j10, timeUnit, aVar, gk.f.a());
    }

    public final a<List<T>> t(long j10, TimeUnit timeUnit, int i10, qj.d dVar) {
        return (a<List<T>>) B1(new xj.f0(j10, j10, timeUnit, i10, dVar));
    }

    public final a<T> t0(wj.a aVar) {
        return (a<T>) B1(new xj.p0(new e0(aVar)));
    }

    public final a<T> t2(wj.o<Throwable, ? extends T> oVar) {
        return (a<T>) B1(new i1(oVar));
    }

    public final a<T> t3(long j10, TimeUnit timeUnit) {
        return u3(j10, timeUnit, gk.f.a());
    }

    public final a<T> t4(long j10, TimeUnit timeUnit, a<? extends T> aVar, qj.d dVar) {
        return (a<T>) B1(new l2(j10, timeUnit, aVar, dVar));
    }

    public final a<List<T>> u(long j10, TimeUnit timeUnit, qj.d dVar) {
        return q(j10, j10, timeUnit, dVar);
    }

    public final a<T> u0(qj.b<? super T> bVar) {
        return (a<T>) B1(new xj.p0(bVar));
    }

    public final a<T> u2(a<? extends T> aVar) {
        return (a<T>) B1(new j1(aVar));
    }

    public final a<T> u3(long j10, TimeUnit timeUnit, qj.d dVar) {
        return (a<T>) B1(new u1(j10, timeUnit, dVar));
    }

    public final a<T> u4(long j10, TimeUnit timeUnit, qj.d dVar) {
        return t4(j10, timeUnit, null, dVar);
    }

    public final <T2, R> a<R> u5(Iterable<? extends T2> iterable, wj.p<? super T, ? super T2, ? extends R> pVar) {
        return B1(new a3(iterable, pVar));
    }

    public final <B> a<List<T>> v(a<B> aVar) {
        return w(aVar, 16);
    }

    public final a<T> v0(wj.b<Notification<? super T>> bVar) {
        return (a<T>) B1(new xj.p0(new f0(bVar)));
    }

    public final dk.b<T> v2() {
        return OperatorPublish.C5(this);
    }

    public final <U> a<T> v3(a<U> aVar) {
        return (a<T>) B1(new w1(aVar));
    }

    public final <U, V> a<T> v4(wj.n<? extends a<U>> nVar, wj.o<? super T, ? extends a<V>> oVar) {
        return w4(nVar, oVar, null);
    }

    public final <T2, R> a<R> v5(a<? extends T2> aVar, wj.p<? super T, ? super T2, ? extends R> pVar) {
        return s5(this, aVar, pVar);
    }

    public final <B> a<List<T>> w(a<B> aVar, int i10) {
        return (a<List<T>>) B1(new xj.c0(aVar, i10));
    }

    public final a<T> w0(wj.b<Throwable> bVar) {
        return (a<T>) B1(new xj.p0(new g0(bVar)));
    }

    public final <R> a<R> w2(wj.o<? super a<T>, ? extends a<R>> oVar) {
        return OperatorPublish.D5(this, oVar);
    }

    public final a<T> w3(wj.o<? super T, Boolean> oVar) {
        return (a<T>) B1(new x1(x1.b(oVar)));
    }

    public final <U, V> a<T> w4(wj.n<? extends a<U>> nVar, wj.o<? super T, ? extends a<V>> oVar, a<? extends T> aVar) {
        if (oVar != null) {
            return (a<T>) B1(new n2(nVar, oVar, aVar));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    public final <TOpening, TClosing> a<List<T>> x(a<? extends TOpening> aVar, wj.o<? super TOpening, ? extends a<? extends TClosing>> oVar) {
        return (a<List<T>>) B1(new xj.e0(aVar, oVar));
    }

    public final a<T> x0(wj.b<? super T> bVar) {
        return (a<T>) B1(new xj.p0(new C0767a(bVar)));
    }

    public final a<T> x1() {
        return W3(1).l3();
    }

    public final a<T> x3(Iterable<T> iterable) {
        return O(Y0(iterable), this);
    }

    public final <V> a<T> x4(wj.o<? super T, ? extends a<V>> oVar) {
        return w4(null, oVar, null);
    }

    public final <TClosing> a<List<T>> y(wj.n<? extends a<? extends TClosing>> nVar) {
        return (a<List<T>>) B1(new xj.c0(nVar, 16));
    }

    @uj.a
    public final a<T> y0(wj.b<Long> bVar) {
        return (a<T>) B1(new q0(bVar));
    }

    public final a<T> y1(wj.o<? super T, Boolean> oVar) {
        return H0(oVar).W3(1).l3();
    }

    public final a<T> y3(T t10) {
        return O(n1(t10), this);
    }

    public final <V> a<T> y4(wj.o<? super T, ? extends a<V>> oVar, a<? extends T> aVar) {
        return w4(null, oVar, aVar);
    }

    public final a<T> z() {
        return b0(new xj.j(this));
    }

    public final a<T> z0(wj.a aVar) {
        return (a<T>) B1(new r0(aVar));
    }

    public final a<T> z1(T t10) {
        return W3(1).n3(t10);
    }

    public final <R> a<R> z2(R r10, wj.p<R, ? super T, R> pVar) {
        return f3(r10, pVar).W3(1);
    }

    public final a<T> z3(T t10, T t11) {
        return O(o1(t10, t11), this);
    }

    /* renamed from: qj.a$a */
    public class C0767a implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.b f30084b;

        public C0767a(wj.b bVar) {
            this.f30084b = bVar;
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30084b.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
        }
    }

    public class g0 implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.b f30108b;

        public g0(wj.b bVar) {
            this.f30108b = bVar;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30108b.call(th2);
        }

        @Override // qj.b
        public final void onCompleted() {
        }

        @Override // qj.b
        public final void onNext(T t10) {
        }
    }

    public class u extends qj.g<T> {
        public u() {
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onCompleted() {
        }

        @Override // qj.b
        public final void onNext(T t10) {
        }
    }

    public class w extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f30157g;

        public w(wj.b bVar) {
            this.f30157g = bVar;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30157g.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public class x extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f30159g;

        /* renamed from: h */
        public final /* synthetic */ wj.b f30160h;

        public x(wj.b bVar, wj.b bVar2) {
            this.f30159g = bVar;
            this.f30160h = bVar2;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30159g.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30160h.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public class b implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.a f30086b;

        public b(wj.a aVar) {
            this.f30086b = aVar;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f30086b.call();
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30086b.call();
        }

        @Override // qj.b
        public final void onNext(T t10) {
        }
    }

    public class e0 implements qj.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.a f30102b;

        public e0(wj.a aVar) {
            this.f30102b = aVar;
        }

        @Override // qj.b
        public final void onCompleted() {
            this.f30102b.call();
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
        }

        @Override // qj.b
        public final void onNext(T t10) {
        }
    }
}
