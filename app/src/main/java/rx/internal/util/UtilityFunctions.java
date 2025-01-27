package rx.internal.util;

import wj.n;
import wj.o;
import wj.p;
import wj.q;
import wj.r;
import wj.s;
import wj.t;
import wj.u;
import wj.v;
import wj.w;
import wj.x;

/* loaded from: classes5.dex */
public final class UtilityFunctions {

    /* renamed from: a */
    public static final b f30550a = new b(null);

    public enum AlwaysFalse implements o<Object, Boolean> {
        INSTANCE;

        @Override // wj.o
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    public enum AlwaysTrue implements o<Object, Boolean> {
        INSTANCE;

        @Override // wj.o
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    public static class a<T> implements o<T, T> {
        @Override // wj.o
        public T call(T t10) {
            return t10;
        }
    }

    public static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements n<R>, o<T0, R>, p<T0, T1, R>, q<T0, T1, T2, R>, r<T0, T1, T2, T3, R>, s<T0, T1, T2, T3, T4, R>, t<T0, T1, T2, T3, T4, T5, R>, u<T0, T1, T2, T3, T4, T5, T6, R>, v<T0, T1, T2, T3, T4, T5, T6, T7, R>, w<T0, T1, T2, T3, T4, T5, T6, T7, T8, R>, x<R> {
        public b() {
        }

        @Override // wj.n, java.util.concurrent.Callable
        public R call() {
            return null;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // wj.o
        public R call(T0 t02) {
            return null;
        }

        @Override // wj.p
        public R call(T0 t02, T1 t12) {
            return null;
        }

        @Override // wj.q
        public R call(T0 t02, T1 t12, T2 t22) {
            return null;
        }

        @Override // wj.r
        public R call(T0 t02, T1 t12, T2 t22, T3 t32) {
            return null;
        }

        @Override // wj.s
        public R call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42) {
            return null;
        }

        @Override // wj.t
        public R call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) {
            return null;
        }

        @Override // wj.u
        public R call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
            return null;
        }

        @Override // wj.v
        public R call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
            return null;
        }

        @Override // wj.w
        public R call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72, T8 t82) {
            return null;
        }

        @Override // wj.x
        public R call(Object... objArr) {
            return null;
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
        return f30550a;
    }
}
