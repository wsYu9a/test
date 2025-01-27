package com.google.common.util.concurrent;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.l;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
@p5.m
/* loaded from: classes2.dex */
public final class ClosingFuture<V> {

    /* renamed from: d */
    public static final Logger f10270d = Logger.getLogger(ClosingFuture.class.getName());

    /* renamed from: a */
    public final AtomicReference<State> f10271a;

    /* renamed from: b */
    public final CloseableList f10272b;

    /* renamed from: c */
    public final com.google.common.util.concurrent.j<V> f10273c;

    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ y f10274b;

        public a(y yVar) {
            this.f10274b = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.x(this.f10274b, ClosingFuture.this);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Closeable f10276b;

        public b(Closeable closeable) {
            this.f10276b = closeable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f10276b.close();
            } catch (IOException | RuntimeException e10) {
                ClosingFuture.f10270d.log(Level.WARNING, "thrown by close()", e10);
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10277a;

        static {
            int[] iArr = new int[State.values().length];
            f10277a = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10277a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10277a[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10277a[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10277a[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10277a[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class d implements p5.x<Closeable> {

        /* renamed from: b */
        public final /* synthetic */ Executor f10279b;

        public d(Executor executor) {
            this.f10279b = executor;
        }

        @Override // p5.x
        /* renamed from: a */
        public void onSuccess(@CheckForNull Closeable closeable) {
            ClosingFuture.this.f10272b.closer.a(closeable, this.f10279b);
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
        }
    }

    public class e implements Callable<V> {

        /* renamed from: b */
        public final /* synthetic */ o f10280b;

        public e(o oVar) {
            this.f10280b = oVar;
        }

        @Override // java.util.concurrent.Callable
        @l0
        public V call() throws Exception {
            return (V) this.f10280b.call(ClosingFuture.this.f10272b.closer);
        }

        public String toString() {
            return this.f10280b.toString();
        }
    }

    public class f implements p5.e<V> {

        /* renamed from: a */
        public final /* synthetic */ m f10282a;

        public f(m mVar) {
            this.f10282a = mVar;
        }

        @Override // p5.e
        public c0<V> call() throws Exception {
            CloseableList closeableList = new CloseableList(null);
            try {
                ClosingFuture<V> call = this.f10282a.call(closeableList.closer);
                call.i(ClosingFuture.this.f10272b);
                return call.f10273c;
            } finally {
                ClosingFuture.this.f10272b.add(closeableList, com.google.common.util.concurrent.p.c());
            }
        }

        public String toString() {
            return this.f10282a.toString();
        }
    }

    public class g<U> implements p5.f<V, U> {

        /* renamed from: a */
        public final /* synthetic */ p f10284a;

        public g(p pVar) {
            this.f10284a = pVar;
        }

        @Override // p5.f
        public c0<U> apply(V v10) throws Exception {
            return ClosingFuture.this.f10272b.applyClosingFunction(this.f10284a, v10);
        }

        public String toString() {
            return this.f10284a.toString();
        }
    }

    public class h<U> implements p5.f<V, U> {

        /* renamed from: a */
        public final /* synthetic */ n f10286a;

        public h(n nVar) {
            this.f10286a = nVar;
        }

        @Override // p5.f
        public c0<U> apply(V v10) throws Exception {
            return ClosingFuture.this.f10272b.applyAsyncClosingFunction(this.f10286a, v10);
        }

        public String toString() {
            return this.f10286a.toString();
        }
    }

    public class i<U> implements n<V, U> {

        /* renamed from: a */
        public final /* synthetic */ p5.f f10288a;

        public i(p5.f fVar) {
            this.f10288a = fVar;
        }

        @Override // com.google.common.util.concurrent.ClosingFuture.n
        public ClosingFuture<U> a(v vVar, V v10) throws Exception {
            return ClosingFuture.w(this.f10288a.apply(v10));
        }
    }

    public class j<W, X> implements p5.f<X, W> {

        /* renamed from: a */
        public final /* synthetic */ p f10289a;

        public j(p pVar) {
            this.f10289a = pVar;
        }

        @Override // p5.f
        /* renamed from: a */
        public c0 apply(Throwable th2) throws Exception {
            return ClosingFuture.this.f10272b.applyClosingFunction(this.f10289a, th2);
        }

        public String toString() {
            return this.f10289a.toString();
        }
    }

    public class k<W, X> implements p5.f<X, W> {

        /* renamed from: a */
        public final /* synthetic */ n f10291a;

        public k(n nVar) {
            this.f10291a = nVar;
        }

        @Override // p5.f
        /* renamed from: a */
        public c0 apply(Throwable th2) throws Exception {
            return ClosingFuture.this.f10272b.applyAsyncClosingFunction(this.f10291a, th2);
        }

        public String toString() {
            return this.f10291a.toString();
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture closingFuture = ClosingFuture.this;
            State state = State.WILL_CLOSE;
            State state2 = State.CLOSING;
            closingFuture.o(state, state2);
            ClosingFuture.this.p();
            ClosingFuture.this.o(state2, State.CLOSED);
        }
    }

    public interface m<V> {
        ClosingFuture<V> call(v vVar) throws Exception;
    }

    public interface n<T, U> {
        ClosingFuture<U> a(v vVar, @l0 T t10) throws Exception;
    }

    public interface o<V> {
        @l0
        V call(v vVar) throws Exception;
    }

    public interface p<T, U> {
        @l0
        U a(v vVar, @l0 T t10) throws Exception;
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class q {

        /* renamed from: d */
        public static final b5.n<ClosingFuture<?>, com.google.common.util.concurrent.j<?>> f10294d = new c();

        /* renamed from: a */
        public final CloseableList f10295a;

        /* renamed from: b */
        public final boolean f10296b;

        /* renamed from: c */
        public final ImmutableList<ClosingFuture<?>> f10297c;

        public class a implements Callable<V> {

            /* renamed from: b */
            public final /* synthetic */ e f10298b;

            public a(e eVar) {
                this.f10298b = eVar;
            }

            @Override // java.util.concurrent.Callable
            @l0
            public V call() throws Exception {
                return (V) new w(q.this.f10297c, null).call(this.f10298b, q.this.f10295a);
            }

            public String toString() {
                return this.f10298b.toString();
            }
        }

        public class b implements p5.e<V> {

            /* renamed from: a */
            public final /* synthetic */ d f10300a;

            public b(d dVar) {
                this.f10300a = dVar;
            }

            @Override // p5.e
            public c0<V> call() throws Exception {
                return new w(q.this.f10297c, null).c(this.f10300a, q.this.f10295a);
            }

            public String toString() {
                return this.f10300a.toString();
            }
        }

        public class c implements b5.n<ClosingFuture<?>, com.google.common.util.concurrent.j<?>> {
            @Override // b5.n
            /* renamed from: a */
            public com.google.common.util.concurrent.j<?> apply(ClosingFuture<?> closingFuture) {
                return closingFuture.f10273c;
            }
        }

        public interface d<V> {
            ClosingFuture<V> call(v vVar, w wVar) throws Exception;
        }

        public interface e<V> {
            @l0
            V call(v vVar, w wVar) throws Exception;
        }

        public /* synthetic */ q(boolean z10, Iterable iterable, d dVar) {
            this(z10, iterable);
        }

        public <V> ClosingFuture<V> b(d<V> dVar, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().a(new b(dVar), executor), (d) null);
            closingFuture.f10272b.add(this.f10295a, com.google.common.util.concurrent.p.c());
            return closingFuture;
        }

        public final l.e<Object> c() {
            return this.f10296b ? com.google.common.util.concurrent.l.B(d()) : com.google.common.util.concurrent.l.z(d());
        }

        public <V> ClosingFuture<V> call(e<V> eVar, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().call(new a(eVar), executor), (d) null);
            closingFuture.f10272b.add(this.f10295a, com.google.common.util.concurrent.p.c());
            return closingFuture;
        }

        public final ImmutableList<com.google.common.util.concurrent.j<?>> d() {
            return e5.w.r(this.f10297c).I(f10294d).C();
        }

        public q(boolean z10, Iterable<? extends ClosingFuture<?>> iterable) {
            this.f10295a = new CloseableList(null);
            this.f10296b = z10;
            this.f10297c = ImmutableList.copyOf(iterable);
            Iterator<? extends ClosingFuture<?>> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().i(this.f10295a);
            }
        }
    }

    public static final class r<V1, V2> extends q {

        /* renamed from: e */
        public final ClosingFuture<V1> f10302e;

        /* renamed from: f */
        public final ClosingFuture<V2> f10303f;

        public class a<U> implements q.e<U> {

            /* renamed from: a */
            public final /* synthetic */ d f10304a;

            public a(d dVar) {
                this.f10304a = dVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.e
            @l0
            public U call(v vVar, w wVar) throws Exception {
                return (U) this.f10304a.a(vVar, wVar.d(r.this.f10302e), wVar.d(r.this.f10303f));
            }

            public String toString() {
                return this.f10304a.toString();
            }
        }

        public class b<U> implements q.d<U> {

            /* renamed from: a */
            public final /* synthetic */ c f10306a;

            public b(c cVar) {
                this.f10306a = cVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.d
            public ClosingFuture<U> call(v vVar, w wVar) throws Exception {
                return this.f10306a.a(vVar, wVar.d(r.this.f10302e), wVar.d(r.this.f10303f));
            }

            public String toString() {
                return this.f10306a.toString();
            }
        }

        public interface c<V1, V2, U> {
            ClosingFuture<U> a(v vVar, @l0 V1 v12, @l0 V2 v22) throws Exception;
        }

        public interface d<V1, V2, U> {
            @l0
            U a(v vVar, @l0 V1 v12, @l0 V2 v22) throws Exception;
        }

        public /* synthetic */ r(ClosingFuture closingFuture, ClosingFuture closingFuture2, d dVar) {
            this(closingFuture, closingFuture2);
        }

        public <U> ClosingFuture<U> call(d<V1, V2, U> dVar, Executor executor) {
            return call(new a(dVar), executor);
        }

        public <U> ClosingFuture<U> g(c<V1, V2, U> cVar, Executor executor) {
            return b(new b(cVar), executor);
        }

        public r(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) closingFuture, closingFuture2), null);
            this.f10302e = closingFuture;
            this.f10303f = closingFuture2;
        }
    }

    public static final class s<V1, V2, V3> extends q {

        /* renamed from: e */
        public final ClosingFuture<V1> f10308e;

        /* renamed from: f */
        public final ClosingFuture<V2> f10309f;

        /* renamed from: g */
        public final ClosingFuture<V3> f10310g;

        public class a<U> implements q.e<U> {

            /* renamed from: a */
            public final /* synthetic */ d f10311a;

            public a(d dVar) {
                this.f10311a = dVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.e
            @l0
            public U call(v vVar, w wVar) throws Exception {
                return (U) this.f10311a.a(vVar, wVar.d(s.this.f10308e), wVar.d(s.this.f10309f), wVar.d(s.this.f10310g));
            }

            public String toString() {
                return this.f10311a.toString();
            }
        }

        public class b<U> implements q.d<U> {

            /* renamed from: a */
            public final /* synthetic */ c f10313a;

            public b(c cVar) {
                this.f10313a = cVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.d
            public ClosingFuture<U> call(v vVar, w wVar) throws Exception {
                return this.f10313a.a(vVar, wVar.d(s.this.f10308e), wVar.d(s.this.f10309f), wVar.d(s.this.f10310g));
            }

            public String toString() {
                return this.f10313a.toString();
            }
        }

        public interface c<V1, V2, V3, U> {
            ClosingFuture<U> a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32) throws Exception;
        }

        public interface d<V1, V2, V3, U> {
            @l0
            U a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32) throws Exception;
        }

        public /* synthetic */ s(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3);
        }

        public <U> ClosingFuture<U> call(d<V1, V2, V3, U> dVar, Executor executor) {
            return call(new a(dVar), executor);
        }

        public <U> ClosingFuture<U> h(c<V1, V2, V3, U> cVar, Executor executor) {
            return b(new b(cVar), executor);
        }

        public s(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) closingFuture, (ClosingFuture<V3>) closingFuture2, closingFuture3), null);
            this.f10308e = closingFuture;
            this.f10309f = closingFuture2;
            this.f10310g = closingFuture3;
        }
    }

    public static final class t<V1, V2, V3, V4> extends q {

        /* renamed from: e */
        public final ClosingFuture<V1> f10315e;

        /* renamed from: f */
        public final ClosingFuture<V2> f10316f;

        /* renamed from: g */
        public final ClosingFuture<V3> f10317g;

        /* renamed from: h */
        public final ClosingFuture<V4> f10318h;

        public class a<U> implements q.e<U> {

            /* renamed from: a */
            public final /* synthetic */ d f10319a;

            public a(d dVar) {
                this.f10319a = dVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.e
            @l0
            public U call(v vVar, w wVar) throws Exception {
                return (U) this.f10319a.a(vVar, wVar.d(t.this.f10315e), wVar.d(t.this.f10316f), wVar.d(t.this.f10317g), wVar.d(t.this.f10318h));
            }

            public String toString() {
                return this.f10319a.toString();
            }
        }

        public class b<U> implements q.d<U> {

            /* renamed from: a */
            public final /* synthetic */ c f10321a;

            public b(c cVar) {
                this.f10321a = cVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.d
            public ClosingFuture<U> call(v vVar, w wVar) throws Exception {
                return this.f10321a.a(vVar, wVar.d(t.this.f10315e), wVar.d(t.this.f10316f), wVar.d(t.this.f10317g), wVar.d(t.this.f10318h));
            }

            public String toString() {
                return this.f10321a.toString();
            }
        }

        public interface c<V1, V2, V3, V4, U> {
            ClosingFuture<U> a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32, @l0 V4 v42) throws Exception;
        }

        public interface d<V1, V2, V3, V4, U> {
            @l0
            U a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32, @l0 V4 v42) throws Exception;
        }

        public /* synthetic */ t(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4);
        }

        public <U> ClosingFuture<U> call(d<V1, V2, V3, V4, U> dVar, Executor executor) {
            return call(new a(dVar), executor);
        }

        public <U> ClosingFuture<U> i(c<V1, V2, V3, V4, U> cVar, Executor executor) {
            return b(new b(cVar), executor);
        }

        public t(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) closingFuture, (ClosingFuture<V4>) closingFuture2, (ClosingFuture<V4>) closingFuture3, closingFuture4), null);
            this.f10315e = closingFuture;
            this.f10316f = closingFuture2;
            this.f10317g = closingFuture3;
            this.f10318h = closingFuture4;
        }
    }

    public static final class u<V1, V2, V3, V4, V5> extends q {

        /* renamed from: e */
        public final ClosingFuture<V1> f10323e;

        /* renamed from: f */
        public final ClosingFuture<V2> f10324f;

        /* renamed from: g */
        public final ClosingFuture<V3> f10325g;

        /* renamed from: h */
        public final ClosingFuture<V4> f10326h;

        /* renamed from: i */
        public final ClosingFuture<V5> f10327i;

        public class a<U> implements q.e<U> {

            /* renamed from: a */
            public final /* synthetic */ d f10328a;

            public a(d dVar) {
                this.f10328a = dVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.e
            @l0
            public U call(v vVar, w wVar) throws Exception {
                return (U) this.f10328a.a(vVar, wVar.d(u.this.f10323e), wVar.d(u.this.f10324f), wVar.d(u.this.f10325g), wVar.d(u.this.f10326h), wVar.d(u.this.f10327i));
            }

            public String toString() {
                return this.f10328a.toString();
            }
        }

        public class b<U> implements q.d<U> {

            /* renamed from: a */
            public final /* synthetic */ c f10330a;

            public b(c cVar) {
                this.f10330a = cVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.q.d
            public ClosingFuture<U> call(v vVar, w wVar) throws Exception {
                return this.f10330a.a(vVar, wVar.d(u.this.f10323e), wVar.d(u.this.f10324f), wVar.d(u.this.f10325g), wVar.d(u.this.f10326h), wVar.d(u.this.f10327i));
            }

            public String toString() {
                return this.f10330a.toString();
            }
        }

        public interface c<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32, @l0 V4 v42, @l0 V5 v52) throws Exception;
        }

        public interface d<V1, V2, V3, V4, V5, U> {
            @l0
            U a(v vVar, @l0 V1 v12, @l0 V2 v22, @l0 V3 v32, @l0 V4 v42, @l0 V5 v52) throws Exception;
        }

        public /* synthetic */ u(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, ClosingFuture closingFuture5, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5);
        }

        public <U> ClosingFuture<U> call(d<V1, V2, V3, V4, V5, U> dVar, Executor executor) {
            return call(new a(dVar), executor);
        }

        public <U> ClosingFuture<U> j(c<V1, V2, V3, V4, V5, U> cVar, Executor executor) {
            return b(new b(cVar), executor);
        }

        public u(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) closingFuture, (ClosingFuture<V5>) closingFuture2, (ClosingFuture<V5>) closingFuture3, (ClosingFuture<V5>) closingFuture4, closingFuture5), null);
            this.f10323e = closingFuture;
            this.f10324f = closingFuture2;
            this.f10325g = closingFuture3;
            this.f10326h = closingFuture4;
            this.f10327i = closingFuture5;
        }
    }

    public static final class v {

        /* renamed from: a */
        @RetainedWith
        public final CloseableList f10332a;

        public v(CloseableList closeableList) {
            this.f10332a = closeableList;
        }

        @CanIgnoreReturnValue
        @l0
        public <C extends Closeable> C a(@l0 C c10, Executor executor) {
            b5.u.E(executor);
            if (c10 != null) {
                this.f10332a.add(c10, executor);
            }
            return c10;
        }
    }

    public static final class w {

        /* renamed from: a */
        public final ImmutableList<ClosingFuture<?>> f10333a;

        /* renamed from: b */
        public volatile boolean f10334b;

        public /* synthetic */ w(ImmutableList immutableList, d dVar) {
            this(immutableList);
        }

        @l0
        public <V> V call(q.e<V> eVar, CloseableList closeableList) throws Exception {
            this.f10334b = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                return eVar.call(closeableList2.closer, this);
            } finally {
                closeableList.add(closeableList2, com.google.common.util.concurrent.p.c());
                this.f10334b = false;
            }
        }

        public final <V> com.google.common.util.concurrent.j<V> c(q.d<V> dVar, CloseableList closeableList) throws Exception {
            this.f10334b = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                ClosingFuture<V> call = dVar.call(closeableList2.closer, this);
                call.i(closeableList);
                return call.f10273c;
            } finally {
                closeableList.add(closeableList2, com.google.common.util.concurrent.p.c());
                this.f10334b = false;
            }
        }

        @l0
        public final <D> D d(ClosingFuture<D> closingFuture) throws ExecutionException {
            b5.u.g0(this.f10334b);
            b5.u.d(this.f10333a.contains(closingFuture));
            return (D) com.google.common.util.concurrent.l.h(closingFuture.f10273c);
        }

        public w(ImmutableList<ClosingFuture<?>> immutableList) {
            this.f10333a = (ImmutableList) b5.u.E(immutableList);
        }
    }

    public static final class x<V> {

        /* renamed from: a */
        public final ClosingFuture<? extends V> f10335a;

        public x(ClosingFuture<? extends V> closingFuture) {
            this.f10335a = (ClosingFuture) b5.u.E(closingFuture);
        }

        public void a() {
            this.f10335a.p();
        }

        @l0
        public V b() throws ExecutionException {
            return (V) com.google.common.util.concurrent.l.h(this.f10335a.f10273c);
        }
    }

    public interface y<V> {
        void a(x<V> xVar);
    }

    public /* synthetic */ ClosingFuture(c0 c0Var, d dVar) {
        this(c0Var);
    }

    public static <V> ClosingFuture<V> A(m<V> mVar, Executor executor) {
        return new ClosingFuture<>(mVar, executor);
    }

    public static q D(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return E(Lists.c(closingFuture, closingFutureArr));
    }

    public static q E(Iterable<? extends ClosingFuture<?>> iterable) {
        return new q(false, iterable, null);
    }

    public static <V1, V2> r<V1, V2> F(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new r<>(closingFuture, closingFuture2, null);
    }

    public static <V1, V2, V3> s<V1, V2, V3> G(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new s<>(closingFuture, closingFuture2, closingFuture3, null);
    }

    public static <V1, V2, V3, V4> t<V1, V2, V3, V4> H(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new t<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, null);
    }

    public static <V1, V2, V3, V4, V5> u<V1, V2, V3, V4, V5> I(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new u<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, null);
    }

    public static q J(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return K(e5.w.z(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).d(closingFutureArr));
    }

    public static q K(Iterable<? extends ClosingFuture<?>> iterable) {
        return new q(true, iterable, null);
    }

    public static <V, U> n<V, U> M(p5.f<V, U> fVar) {
        b5.u.E(fVar);
        return new i(fVar);
    }

    public static void q(@CheckForNull Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new b(closeable));
        } catch (RejectedExecutionException e10) {
            Logger logger = f10270d;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e10);
            }
            q(closeable, com.google.common.util.concurrent.p.c());
        }
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> t(c0<C> c0Var, Executor executor) {
        b5.u.E(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(com.google.common.util.concurrent.l.q(c0Var));
        com.google.common.util.concurrent.l.a(c0Var, new d(executor), com.google.common.util.concurrent.p.c());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> w(c0<V> c0Var) {
        return new ClosingFuture<>(c0Var);
    }

    public static <C, V extends C> void x(y<C> yVar, ClosingFuture<V> closingFuture) {
        yVar.a(new x<>(closingFuture));
    }

    public static <V> ClosingFuture<V> z(o<V> oVar, Executor executor) {
        return new ClosingFuture<>(oVar, executor);
    }

    public <U> ClosingFuture<U> B(p<? super V, U> pVar, Executor executor) {
        b5.u.E(pVar);
        return s(this.f10273c.t(new g(pVar), executor));
    }

    public <U> ClosingFuture<U> C(n<? super V, U> nVar, Executor executor) {
        b5.u.E(nVar);
        return s(this.f10273c.t(new h(nVar), executor));
    }

    @a5.d
    public CountDownLatch L() {
        return this.f10272b.whenClosedCountDown();
    }

    public void finalize() {
        if (this.f10271a.get().equals(State.OPEN)) {
            f10270d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            u();
        }
    }

    public final void i(CloseableList closeableList) {
        o(State.OPEN, State.SUBSUMED);
        closeableList.add(this.f10272b, com.google.common.util.concurrent.p.c());
    }

    @CanIgnoreReturnValue
    public boolean j(boolean z10) {
        f10270d.log(Level.FINER, "cancelling {0}", this);
        boolean cancel = this.f10273c.cancel(z10);
        if (cancel) {
            p();
        }
        return cancel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> k(Class<X> cls, p<? super X, ? extends V> pVar, Executor executor) {
        return n(cls, pVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> l(Class<X> cls, n<? super X, ? extends V> nVar, Executor executor) {
        return m(cls, nVar, executor);
    }

    public final <X extends Throwable, W extends V> ClosingFuture<V> m(Class<X> cls, n<? super X, W> nVar, Executor executor) {
        b5.u.E(nVar);
        return (ClosingFuture<V>) s(this.f10273c.p(cls, new k(nVar), executor));
    }

    public final <X extends Throwable, W extends V> ClosingFuture<V> n(Class<X> cls, p<? super X, W> pVar, Executor executor) {
        b5.u.E(pVar);
        return (ClosingFuture<V>) s(this.f10273c.p(cls, new j(pVar), executor));
    }

    public final void o(State state, State state2) {
        b5.u.B0(r(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    public final void p() {
        f10270d.log(Level.FINER, "closing {0}", this);
        this.f10272b.close();
    }

    public final boolean r(State state, State state2) {
        return k0.e.a(this.f10271a, state, state2);
    }

    public final <U> ClosingFuture<U> s(com.google.common.util.concurrent.j<U> jVar) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(jVar);
        i(closingFuture.f10272b);
        return closingFuture;
    }

    public String toString() {
        return com.google.common.base.a.c(this).f("state", this.f10271a.get()).s(this.f10273c).toString();
    }

    public com.google.common.util.concurrent.j<V> u() {
        if (!r(State.OPEN, State.WILL_CLOSE)) {
            switch (c.f10277a[this.f10271a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        f10270d.log(Level.FINER, "will close {0}", this);
        this.f10273c.addListener(new l(), com.google.common.util.concurrent.p.c());
        return this.f10273c;
    }

    public void v(y<? super V> yVar, Executor executor) {
        b5.u.E(yVar);
        if (r(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            this.f10273c.addListener(new a(yVar), executor);
            return;
        }
        int i10 = c.f10277a[this.f10271a.get().ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        if (i10 == 2) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new AssertionError(this.f10271a);
        }
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
    }

    public c0<?> y() {
        return com.google.common.util.concurrent.l.q(this.f10273c.s(Functions.b(null), com.google.common.util.concurrent.p.c()));
    }

    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final v closer;

        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new v(this);
        }

        public void add(@CheckForNull Closeable closeable, Executor executor) {
            b5.u.E(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        ClosingFuture.q(closeable, executor);
                    } else {
                        put(closeable, executor);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public <V, U> com.google.common.util.concurrent.j<U> applyAsyncClosingFunction(n<V, U> nVar, @l0 V v10) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> a10 = nVar.a(closeableList.closer, v10);
                a10.i(closeableList);
                return a10.f10273c;
            } finally {
                add(closeableList, com.google.common.util.concurrent.p.c());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <V, U> c0<U> applyClosingFunction(p<? super V, U> pVar, @l0 V v10) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return com.google.common.util.concurrent.l.m(pVar.a(closeableList.closer, v10));
            } finally {
                add(closeableList, com.google.common.util.concurrent.p.c());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                        ClosingFuture.q(entry.getKey(), entry.getValue());
                    }
                    clear();
                    if (this.whenClosed != null) {
                        this.whenClosed.countDown();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return new CountDownLatch(0);
                    }
                    b5.u.g0(this.whenClosed == null);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.whenClosed = countDownLatch;
                    return countDownLatch;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public /* synthetic */ CloseableList(d dVar) {
            this();
        }
    }

    public ClosingFuture(c0<V> c0Var) {
        this.f10271a = new AtomicReference<>(State.OPEN);
        this.f10272b = new CloseableList(null);
        this.f10273c = com.google.common.util.concurrent.j.r(c0Var);
    }

    public ClosingFuture(o<V> oVar, Executor executor) {
        this.f10271a = new AtomicReference<>(State.OPEN);
        this.f10272b = new CloseableList(null);
        b5.u.E(oVar);
        TrustedListenableFutureTask w10 = TrustedListenableFutureTask.w(new e(oVar));
        executor.execute(w10);
        this.f10273c = w10;
    }

    public ClosingFuture(m<V> mVar, Executor executor) {
        this.f10271a = new AtomicReference<>(State.OPEN);
        this.f10272b = new CloseableList(null);
        b5.u.E(mVar);
        TrustedListenableFutureTask x10 = TrustedListenableFutureTask.x(new f(mVar));
        executor.execute(x10);
        this.f10273c = x10;
    }
}
