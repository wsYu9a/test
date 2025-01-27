package rx.internal.operators;

import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class p1 {

    /* renamed from: a */
    private static final Object f36350a = new Object();

    static class a<T> implements rx.k.o<T, Object> {
        a() {
        }

        @Override // rx.k.o
        public Object call(T t) {
            return t;
        }
    }

    static class b implements rx.k.p<Object, Object, Boolean> {

        /* renamed from: a */
        final /* synthetic */ rx.k.p f36351a;

        b(rx.k.p pVar) {
            this.f36351a = pVar;
        }

        @Override // rx.k.p
        public Boolean call(Object obj, Object obj2) {
            boolean z = obj == p1.f36350a;
            boolean z2 = obj2 == p1.f36350a;
            return (z && z2) ? Boolean.TRUE : (z || z2) ? Boolean.FALSE : (Boolean) this.f36351a.call(obj, obj2);
        }
    }

    private p1() {
        throw new IllegalStateException("No instances!");
    }

    static <T> rx.a<Object> b(rx.a<T> aVar) {
        return rx.a.O(aVar.D1(new a()), rx.a.n1(f36350a));
    }

    public static <T> rx.a<Boolean> c(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.k.p<? super T, ? super T, Boolean> pVar) {
        return rx.a.s5(b(aVar), b(aVar2), new b(pVar)).b(UtilityFunctions.c());
    }
}
