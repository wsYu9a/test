package rx.internal.util;

import rx.k.n;
import rx.k.o;
import rx.k.p;
import rx.k.q;
import rx.k.r;
import rx.k.s;
import rx.k.t;
import rx.k.u;
import rx.k.v;
import rx.k.w;
import rx.k.x;

/* loaded from: classes5.dex */
public final class UtilityFunctions {

    /* renamed from: a */
    private static final b f36755a = new b(null);

    private enum AlwaysFalse implements o<Object, Boolean> {
        INSTANCE;

        @Override // rx.k.o
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    private enum AlwaysTrue implements o<Object, Boolean> {
        INSTANCE;

        @Override // rx.k.o
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    static class a<T> implements o<T, T> {
        a() {
        }

        @Override // rx.k.o
        public T call(T t) {
            return t;
        }
    }

    private static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements n<R>, o<T0, R>, p<T0, T1, R>, q<T0, T1, T2, R>, r<T0, T1, T2, T3, R>, s<T0, T1, T2, T3, T4, R>, t<T0, T1, T2, T3, T4, T5, R>, u<T0, T1, T2, T3, T4, T5, T6, R>, v<T0, T1, T2, T3, T4, T5, T6, T7, R>, w<T0, T1, T2, T3, T4, T5, T6, T7, T8, R>, x<R> {
        private b() {
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public R call() {
            return null;
        }

        @Override // rx.k.o
        public R call(T0 t0) {
            return null;
        }

        @Override // rx.k.p
        public R call(T0 t0, T1 t1) {
            return null;
        }

        @Override // rx.k.q
        public R call(T0 t0, T1 t1, T2 t2) {
            return null;
        }

        @Override // rx.k.r
        public R call(T0 t0, T1 t1, T2 t2, T3 t3) {
            return null;
        }

        @Override // rx.k.s
        public R call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
            return null;
        }

        @Override // rx.k.t
        public R call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
            return null;
        }

        @Override // rx.k.u
        public R call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
            return null;
        }

        @Override // rx.k.v
        public R call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
            return null;
        }

        @Override // rx.k.w
        public R call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
            return null;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            return null;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static <T> o<? super T, Boolean> a() {
        return AlwaysFalse.INSTANCE;
    }

    public static <T> o<? super T, Boolean> b() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> o<T, T> c() {
        return new a();
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d() {
        return f36755a;
    }
}
