package xj;

import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class p1 {

    /* renamed from: a */
    public static final Object f32542a = new Object();

    public static class b implements wj.p<Object, Object, Boolean> {

        /* renamed from: b */
        public final /* synthetic */ wj.p f32543b;

        public b(wj.p pVar) {
            this.f32543b = pVar;
        }

        @Override // wj.p
        public Boolean call(Object obj, Object obj2) {
            boolean z10 = obj == p1.f32542a;
            boolean z11 = obj2 == p1.f32542a;
            return (z10 && z11) ? Boolean.TRUE : (z10 || z11) ? Boolean.FALSE : (Boolean) this.f32543b.call(obj, obj2);
        }
    }

    public p1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> qj.a<Object> b(qj.a<T> aVar) {
        return qj.a.O(aVar.D1(new a()), qj.a.n1(f32542a));
    }

    public static <T> qj.a<Boolean> c(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, wj.p<? super T, ? super T, Boolean> pVar) {
        return qj.a.s5(b(aVar), b(aVar2), new b(pVar)).b(UtilityFunctions.c());
    }

    public static class a<T> implements wj.o<T, Object> {
        @Override // wj.o
        public Object call(T t10) {
            return t10;
        }
    }
}
