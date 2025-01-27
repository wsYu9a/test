package rx;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.a;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.b1;
import rx.internal.operators.i1;
import rx.internal.operators.l2;
import rx.internal.operators.x0;
import rx.internal.operators.y;
import rx.internal.operators.y1;
import rx.internal.producers.SingleDelayedProducer;
import rx.k.o;
import rx.k.p;
import rx.k.q;
import rx.k.r;
import rx.k.s;
import rx.k.t;
import rx.k.u;
import rx.k.v;
import rx.k.w;

@rx.j.b
/* loaded from: classes5.dex */
public class e<T> {

    /* renamed from: a */
    private static final rx.m.b f35736a = rx.m.d.b().c();

    /* renamed from: b */
    final a.m0<T> f35737b;

    class a implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ j f35738a;

        /* renamed from: rx.e$a$a */
        class C0844a extends rx.f<T> {

            /* renamed from: b */
            final /* synthetic */ SingleDelayedProducer f35740b;

            /* renamed from: c */
            final /* synthetic */ rx.g f35741c;

            C0844a(SingleDelayedProducer singleDelayedProducer, rx.g gVar) {
                this.f35740b = singleDelayedProducer;
                this.f35741c = gVar;
            }

            @Override // rx.f
            public void b(Throwable th) {
                this.f35741c.onError(th);
            }

            @Override // rx.f
            public void c(T t) {
                this.f35740b.setValue(t);
            }
        }

        a(j jVar) {
            this.f35738a = jVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
            gVar.f(singleDelayedProducer);
            C0844a c0844a = new C0844a(singleDelayedProducer, gVar);
            gVar.b(c0844a);
            this.f35738a.call(c0844a);
        }
    }

    class b<R> implements a.m0<R> {

        /* renamed from: a */
        final /* synthetic */ a.n0 f35743a;

        b(a.n0 n0Var) {
            this.f35743a = n0Var;
        }

        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            try {
                rx.g gVar2 = (rx.g) e.f35736a.b(this.f35743a).call(gVar);
                try {
                    gVar2.d();
                    e.this.f35737b.call(gVar2);
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

    static class c implements j<T> {

        /* renamed from: a */
        final /* synthetic */ Throwable f35745a;

        c(Throwable th) {
            this.f35745a = th;
        }

        @Override // rx.k.b
        public void call(rx.f<? super T> fVar) {
            fVar.b(this.f35745a);
        }
    }

    static class d implements j<T> {

        /* renamed from: a */
        final /* synthetic */ Object f35746a;

        d(Object obj) {
            this.f35746a = obj;
        }

        @Override // rx.k.b
        public void call(rx.f<? super T> fVar) {
            fVar.c((Object) this.f35746a);
        }
    }

    /* renamed from: rx.e$e */
    static class C0845e implements j<T> {

        /* renamed from: rx.e$e$a */
        class a extends rx.f<e<? extends T>> {

            /* renamed from: b */
            final /* synthetic */ rx.f f35748b;

            a(rx.f fVar) {
                this.f35748b = fVar;
            }

            @Override // rx.f
            public void b(Throwable th) {
                this.f35748b.b(th);
            }

            @Override // rx.f
            /* renamed from: d */
            public void c(e<? extends T> eVar) {
                eVar.K(this.f35748b);
            }
        }

        C0845e() {
        }

        @Override // rx.k.b
        public void call(rx.f<? super T> fVar) {
            e.this.K(new a(fVar));
        }
    }

    class f extends rx.g<T> {
        f() {
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

    class g extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f35751f;

        g(rx.k.b bVar) {
            this.f35751f = bVar;
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
            this.f35751f.call(t);
        }
    }

    class h extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.k.b f35753f;

        /* renamed from: g */
        final /* synthetic */ rx.k.b f35754g;

        h(rx.k.b bVar, rx.k.b bVar2) {
            this.f35753f = bVar;
            this.f35754g = bVar2;
        }

        @Override // rx.b
        public final void onCompleted() {
        }

        @Override // rx.b
        public final void onError(Throwable th) {
            this.f35753f.call(th);
        }

        @Override // rx.b
        public final void onNext(T t) {
            this.f35754g.call(t);
        }
    }

    class i extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.f f35756f;

        i(rx.f fVar) {
            this.f35756f = fVar;
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35756f.b(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35756f.c(t);
        }
    }

    public interface j<T> extends rx.k.b<rx.f<? super T>> {
    }

    public interface k<T, R> extends o<e<T>, e<R>> {
    }

    protected e(j<T> jVar) {
        this.f35737b = new a(jVar);
    }

    public static final <T> rx.a<T> A(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return rx.a.O1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6));
    }

    public static final <T> rx.a<T> B(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return rx.a.P1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7));
    }

    public static final <T> rx.a<T> C(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return rx.a.Q1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8));
    }

    public static final <T> rx.a<T> D(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return rx.a.R1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9));
    }

    public static final <T> e<T> E(e<? extends e<? extends T>> eVar) {
        return m(new C0845e());
    }

    private final e<rx.a<T>> G() {
        return t(b(this));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> V(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9)}).u(new OperatorZip(wVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> W(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8)}).u(new OperatorZip(vVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> e<R> X(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7)}).u(new OperatorZip(uVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> e<R> Y(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6)}).u(new OperatorZip(tVar));
    }

    public static final <T1, T2, T3, T4, T5, R> e<R> Z(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5)}).u(new OperatorZip(sVar));
    }

    public static final <T1, T2, T3, T4, R> e<R> a0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4)}).u(new OperatorZip(rVar));
    }

    private static <T> rx.a<T> b(e<T> eVar) {
        return rx.a.b0(eVar.f35737b);
    }

    public static final <T1, T2, T3, R> e<R> b0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return t(new rx.a[]{b(eVar), b(eVar2), b(eVar3)}).u(new OperatorZip(qVar));
    }

    public static final <T1, T2, R> e<R> c0(e<? extends T1> eVar, e<? extends T2> eVar2, p<? super T1, ? super T2, ? extends R> pVar) {
        return t(new rx.a[]{b(eVar), b(eVar2)}).u(new OperatorZip(pVar));
    }

    public static final <T> rx.a<T> d(e<? extends T> eVar, e<? extends T> eVar2) {
        return rx.a.O(b(eVar), b(eVar2));
    }

    public static final <T> rx.a<T> e(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return rx.a.P(b(eVar), b(eVar2), b(eVar3));
    }

    public static final <T> rx.a<T> f(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return rx.a.Q(b(eVar), b(eVar2), b(eVar3), b(eVar4));
    }

    public static final <T> rx.a<T> g(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return rx.a.R(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5));
    }

    public static final <T> rx.a<T> h(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return rx.a.S(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6));
    }

    public static final <T> rx.a<T> i(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return rx.a.T(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7));
    }

    public static final <T> rx.a<T> j(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return rx.a.U(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8));
    }

    public static final <T> rx.a<T> k(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return rx.a.V(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9));
    }

    public static final <T> e<T> m(j<T> jVar) {
        return new e<>(jVar);
    }

    public static final <T> e<T> n(Throwable th) {
        return m(new c(th));
    }

    public static final <T> e<T> q(Future<? extends T> future) {
        return new e<>(y.a(future));
    }

    public static final <T> e<T> r(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return new e<>(y.b(future, j2, timeUnit));
    }

    public static final <T> e<T> s(Future<? extends T> future, rx.d dVar) {
        return new e(y.a(future)).O(dVar);
    }

    public static final <T> e<T> t(T t) {
        return m(new d(t));
    }

    private final <R> e<R> u(a.n0<? extends R, ? super T> n0Var) {
        return new e<>(new b(n0Var));
    }

    public static final <T> rx.a<T> w(e<? extends T> eVar, e<? extends T> eVar2) {
        return rx.a.K1(b(eVar), b(eVar2));
    }

    public static final <T> rx.a<T> x(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return rx.a.L1(b(eVar), b(eVar2), b(eVar3));
    }

    public static final <T> rx.a<T> y(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return rx.a.M1(b(eVar), b(eVar2), b(eVar3), b(eVar4));
    }

    public static final <T> rx.a<T> z(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return rx.a.N1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5));
    }

    public final rx.a<T> F(e<? extends T> eVar) {
        return w(this, eVar);
    }

    public final e<T> H(rx.d dVar) {
        return (e<T>) u(new b1(dVar));
    }

    public final e<T> I(o<Throwable, ? extends T> oVar) {
        return (e<T>) u(new i1(oVar));
    }

    public final rx.h J() {
        return L(new f());
    }

    public final rx.h K(rx.f<? super T> fVar) {
        i iVar = new i(fVar);
        fVar.a(iVar);
        L(iVar);
        return iVar;
    }

    public final rx.h L(rx.g<? super T> gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (this.f35737b == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        gVar.d();
        if (!(gVar instanceof rx.l.b)) {
            gVar = new rx.l.b(gVar);
        }
        try {
            this.f35737b.call(gVar);
            return f35736a.d(gVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                gVar.onError(f35736a.c(th));
                return rx.p.f.b();
            } catch (OnErrorNotImplementedException e2) {
                throw e2;
            } catch (Throwable th2) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                f35736a.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final rx.h M(rx.k.b<? super T> bVar) {
        if (bVar != null) {
            return L(new g(bVar));
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final rx.h N(rx.k.b<? super T> bVar, rx.k.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (bVar2 != null) {
            return L(new h(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final e<T> O(rx.d dVar) {
        return (e<T>) G().u(new y1(dVar));
    }

    public final e<T> P(long j2, TimeUnit timeUnit) {
        return S(j2, timeUnit, null, rx.n.f.a());
    }

    public final e<T> Q(long j2, TimeUnit timeUnit, rx.d dVar) {
        return S(j2, timeUnit, null, dVar);
    }

    public final e<T> R(long j2, TimeUnit timeUnit, e<? extends T> eVar) {
        return S(j2, timeUnit, eVar, rx.n.f.a());
    }

    public final e<T> S(long j2, TimeUnit timeUnit, e<? extends T> eVar, rx.d dVar) {
        if (eVar == null) {
            eVar = n(new TimeoutException());
        }
        return (e<T>) u(new l2(j2, timeUnit, b(eVar), dVar));
    }

    public final rx.a<T> T() {
        return b(this);
    }

    public final void U(rx.g<? super T> gVar) {
        try {
            gVar.d();
            this.f35737b.call(gVar);
            f35736a.d(gVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                gVar.onError(f35736a.c(th));
            } catch (OnErrorNotImplementedException e2) {
                throw e2;
            } catch (Throwable th2) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                f35736a.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public <R> e<R> c(k<? super T, ? extends R> kVar) {
        return (e) kVar.call(this);
    }

    public final <T2, R> e<R> d0(e<? extends T2> eVar, p<? super T, ? super T2, ? extends R> pVar) {
        return c0(this, eVar, pVar);
    }

    public final rx.a<T> l(e<? extends T> eVar) {
        return d(this, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> o(o<? super T, ? extends e<? extends R>> oVar) {
        return E(v(oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> rx.a<R> p(o<? super T, ? extends rx.a<? extends R>> oVar) {
        return rx.a.I1(b(v(oVar)));
    }

    public final <R> e<R> v(o<? super T, ? extends R> oVar) {
        return u(new x0(oVar));
    }

    private e(a.m0<T> m0Var) {
        this.f35737b = m0Var;
    }
}
