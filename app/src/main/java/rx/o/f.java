package rx.o;

import rx.a;

/* loaded from: classes5.dex */
public abstract class f<T, R> extends rx.a<R> implements rx.b<T> {

    /* renamed from: c */
    private static final Object[] f37036c = new Object[0];

    protected f(a.m0<R> m0Var) {
        super(m0Var);
    }

    @rx.j.b
    public boolean A5() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean B5();

    @rx.j.b
    public boolean C5() {
        throw new UnsupportedOperationException();
    }

    @rx.j.b
    public boolean D5() {
        throw new UnsupportedOperationException();
    }

    public final e<T, R> E5() {
        return getClass() == e.class ? (e) this : new e<>(this);
    }

    @rx.j.b
    public Throwable w5() {
        throw new UnsupportedOperationException();
    }

    @rx.j.b
    public T x5() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @rx.j.b
    public Object[] y5() {
        Object[] objArr = f37036c;
        Object[] z5 = z5(objArr);
        return z5 == objArr ? new Object[0] : z5;
    }

    @rx.j.b
    public T[] z5(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
