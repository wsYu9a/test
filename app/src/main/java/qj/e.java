package qj;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import qj.a;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OperatorZip;
import rx.internal.producers.SingleDelayedProducer;
import wj.o;
import wj.p;
import wj.q;
import wj.r;
import wj.s;
import wj.t;
import wj.u;
import wj.v;
import wj.w;
import xj.b1;
import xj.i1;
import xj.l2;
import xj.x0;
import xj.y;
import xj.y1;

@uj.b
/* loaded from: classes4.dex */
public class e<T> {

    /* renamed from: b */
    public static final fk.b f30174b = fk.d.b().c();

    /* renamed from: a */
    public final a.m0<T> f30175a;

    public class a implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ j f30176b;

        /* renamed from: qj.e$a$a */
        public class C0778a extends qj.f<T> {

            /* renamed from: c */
            public final /* synthetic */ SingleDelayedProducer f30178c;

            /* renamed from: d */
            public final /* synthetic */ qj.g f30179d;

            public C0778a(SingleDelayedProducer singleDelayedProducer, qj.g gVar) {
                this.f30178c = singleDelayedProducer;
                this.f30179d = gVar;
            }

            @Override // qj.f
            public void b(Throwable th2) {
                this.f30179d.onError(th2);
            }

            @Override // qj.f
            public void c(T t10) {
                this.f30178c.setValue(t10);
            }
        }

        public a(j jVar) {
            this.f30176b = jVar;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
            gVar.f(singleDelayedProducer);
            C0778a c0778a = new C0778a(singleDelayedProducer, gVar);
            gVar.b(c0778a);
            this.f30176b.call(c0778a);
        }
    }

    public class b<R> implements a.m0<R> {

        /* renamed from: b */
        public final /* synthetic */ a.n0 f30181b;

        public b(a.n0 n0Var) {
            this.f30181b = n0Var;
        }

        @Override // wj.b
        public void call(qj.g<? super R> gVar) {
            try {
                qj.g gVar2 = (qj.g) e.f30174b.b(this.f30181b).call(gVar);
                try {
                    gVar2.d();
                    e.this.f30175a.call(gVar2);
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

    public static class c implements j<T> {

        /* renamed from: b */
        public final /* synthetic */ Throwable f30183b;

        public c(Throwable th2) {
            this.f30183b = th2;
        }

        @Override // wj.b
        public void call(qj.f<? super T> fVar) {
            fVar.b(this.f30183b);
        }
    }

    public static class d implements j<T> {

        /* renamed from: b */
        public final /* synthetic */ Object f30184b;

        public d(Object obj) {
            this.f30184b = obj;
        }

        @Override // wj.b
        public void call(qj.f<? super T> fVar) {
            fVar.c((Object) this.f30184b);
        }
    }

    /* renamed from: qj.e$e */
    public static class C0779e implements j<T> {

        /* renamed from: qj.e$e$a */
        public class a extends qj.f<e<? extends T>> {

            /* renamed from: c */
            public final /* synthetic */ qj.f f30186c;

            public a(qj.f fVar) {
                this.f30186c = fVar;
            }

            @Override // qj.f
            public void b(Throwable th2) {
                this.f30186c.b(th2);
            }

            @Override // qj.f
            /* renamed from: d */
            public void c(e<? extends T> eVar) {
                eVar.K(this.f30186c);
            }
        }

        public C0779e() {
        }

        @Override // wj.b
        public void call(qj.f<? super T> fVar) {
            e.this.K(new a(fVar));
        }
    }

    public interface j<T> extends wj.b<qj.f<? super T>> {
    }

    public interface k<T, R> extends o<e<T>, e<R>> {
    }

    public e(j<T> jVar) {
        this.f30175a = new a(jVar);
    }

    public static final <T> qj.a<T> A(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return qj.a.O1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6));
    }

    public static final <T> qj.a<T> B(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return qj.a.P1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7));
    }

    public static final <T> qj.a<T> C(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return qj.a.Q1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8));
    }

    public static final <T> qj.a<T> D(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return qj.a.R1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9));
    }

    public static final <T> e<T> E(e<? extends e<? extends T>> eVar) {
        return m(new C0779e());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> V(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> wVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9)}).u(new OperatorZip(wVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> W(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> vVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8)}).u(new OperatorZip(vVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> e<R> X(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> uVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7)}).u(new OperatorZip(uVar));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> e<R> Y(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> tVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6)}).u(new OperatorZip(tVar));
    }

    public static final <T1, T2, T3, T4, T5, R> e<R> Z(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, s<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> sVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5)}).u(new OperatorZip(sVar));
    }

    public static final <T1, T2, T3, T4, R> e<R> a0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3), b(eVar4)}).u(new OperatorZip(rVar));
    }

    public static <T> qj.a<T> b(e<T> eVar) {
        return qj.a.b0(eVar.f30175a);
    }

    public static final <T1, T2, T3, R> e<R> b0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        return t(new qj.a[]{b(eVar), b(eVar2), b(eVar3)}).u(new OperatorZip(qVar));
    }

    public static final <T1, T2, R> e<R> c0(e<? extends T1> eVar, e<? extends T2> eVar2, p<? super T1, ? super T2, ? extends R> pVar) {
        return t(new qj.a[]{b(eVar), b(eVar2)}).u(new OperatorZip(pVar));
    }

    public static final <T> qj.a<T> d(e<? extends T> eVar, e<? extends T> eVar2) {
        return qj.a.O(b(eVar), b(eVar2));
    }

    public static final <T> qj.a<T> e(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return qj.a.P(b(eVar), b(eVar2), b(eVar3));
    }

    public static final <T> qj.a<T> f(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return qj.a.Q(b(eVar), b(eVar2), b(eVar3), b(eVar4));
    }

    public static final <T> qj.a<T> g(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return qj.a.R(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5));
    }

    public static final <T> qj.a<T> h(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return qj.a.S(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6));
    }

    public static final <T> qj.a<T> i(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return qj.a.T(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7));
    }

    public static final <T> qj.a<T> j(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return qj.a.U(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8));
    }

    public static final <T> qj.a<T> k(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return qj.a.V(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5), b(eVar6), b(eVar7), b(eVar8), b(eVar9));
    }

    public static final <T> e<T> m(j<T> jVar) {
        return new e<>(jVar);
    }

    public static final <T> e<T> n(Throwable th2) {
        return m(new c(th2));
    }

    public static final <T> e<T> q(Future<? extends T> future) {
        return new e<>(y.a(future));
    }

    public static final <T> e<T> r(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        return new e<>(y.b(future, j10, timeUnit));
    }

    public static final <T> e<T> s(Future<? extends T> future, qj.d dVar) {
        return new e(y.a(future)).O(dVar);
    }

    public static final <T> e<T> t(T t10) {
        return m(new d(t10));
    }

    public static final <T> qj.a<T> w(e<? extends T> eVar, e<? extends T> eVar2) {
        return qj.a.K1(b(eVar), b(eVar2));
    }

    public static final <T> qj.a<T> x(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return qj.a.L1(b(eVar), b(eVar2), b(eVar3));
    }

    public static final <T> qj.a<T> y(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return qj.a.M1(b(eVar), b(eVar2), b(eVar3), b(eVar4));
    }

    public static final <T> qj.a<T> z(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return qj.a.N1(b(eVar), b(eVar2), b(eVar3), b(eVar4), b(eVar5));
    }

    public final qj.a<T> F(e<? extends T> eVar) {
        return w(this, eVar);
    }

    public final e<qj.a<T>> G() {
        return t(b(this));
    }

    public final e<T> H(qj.d dVar) {
        return (e<T>) u(new b1(dVar));
    }

    public final e<T> I(o<Throwable, ? extends T> oVar) {
        return (e<T>) u(new i1(oVar));
    }

    public final qj.h J() {
        return L(new f());
    }

    public final qj.h K(qj.f<? super T> fVar) {
        i iVar = new i(fVar);
        fVar.a(iVar);
        L(iVar);
        return iVar;
    }

    public final qj.h L(qj.g<? super T> gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (this.f30175a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        gVar.d();
        if (!(gVar instanceof ek.b)) {
            gVar = new ek.b(gVar);
        }
        try {
            this.f30175a.call(gVar);
            return f30174b.d(gVar);
        } catch (Throwable th2) {
            vj.a.e(th2);
            try {
                gVar.onError(f30174b.c(th2));
                return ik.f.b();
            } catch (OnErrorNotImplementedException e10) {
                throw e10;
            } catch (Throwable th3) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                f30174b.c(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final qj.h M(wj.b<? super T> bVar) {
        if (bVar != null) {
            return L(new g(bVar));
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final qj.h N(wj.b<? super T> bVar, wj.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (bVar2 != null) {
            return L(new h(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final e<T> O(qj.d dVar) {
        return (e<T>) G().u(new y1(dVar));
    }

    public final e<T> P(long j10, TimeUnit timeUnit) {
        return S(j10, timeUnit, null, gk.f.a());
    }

    public final e<T> Q(long j10, TimeUnit timeUnit, qj.d dVar) {
        return S(j10, timeUnit, null, dVar);
    }

    public final e<T> R(long j10, TimeUnit timeUnit, e<? extends T> eVar) {
        return S(j10, timeUnit, eVar, gk.f.a());
    }

    public final e<T> S(long j10, TimeUnit timeUnit, e<? extends T> eVar, qj.d dVar) {
        if (eVar == null) {
            eVar = n(new TimeoutException());
        }
        return (e<T>) u(new l2(j10, timeUnit, b(eVar), dVar));
    }

    public final qj.a<T> T() {
        return b(this);
    }

    public final void U(qj.g<? super T> gVar) {
        try {
            gVar.d();
            this.f30175a.call(gVar);
            f30174b.d(gVar);
        } catch (Throwable th2) {
            vj.a.e(th2);
            try {
                gVar.onError(f30174b.c(th2));
            } catch (OnErrorNotImplementedException e10) {
                throw e10;
            } catch (Throwable th3) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                f30174b.c(runtimeException);
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

    public final qj.a<T> l(e<? extends T> eVar) {
        return d(this, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> o(o<? super T, ? extends e<? extends R>> oVar) {
        return E(v(oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> qj.a<R> p(o<? super T, ? extends qj.a<? extends R>> oVar) {
        return qj.a.I1(b(v(oVar)));
    }

    public final <R> e<R> u(a.n0<? extends R, ? super T> n0Var) {
        return new e<>(new b(n0Var));
    }

    public final <R> e<R> v(o<? super T, ? extends R> oVar) {
        return u(new x0(oVar));
    }

    public e(a.m0<T> m0Var) {
        this.f30175a = m0Var;
    }

    public class f extends qj.g<T> {
        public f() {
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

    public class g extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f30189g;

        public g(wj.b bVar) {
            this.f30189g = bVar;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30189g.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public class h extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ wj.b f30191g;

        /* renamed from: h */
        public final /* synthetic */ wj.b f30192h;

        public h(wj.b bVar, wj.b bVar2) {
            this.f30191g = bVar;
            this.f30192h = bVar2;
        }

        @Override // qj.b
        public final void onError(Throwable th2) {
            this.f30191g.call(th2);
        }

        @Override // qj.b
        public final void onNext(T t10) {
            this.f30192h.call(t10);
        }

        @Override // qj.b
        public final void onCompleted() {
        }
    }

    public class i extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.f f30194g;

        public i(qj.f fVar) {
            this.f30194g = fVar;
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30194g.b(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f30194g.c(t10);
        }

        @Override // qj.b
        public void onCompleted() {
        }
    }
}
