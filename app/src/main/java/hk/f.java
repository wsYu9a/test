package hk;

import qj.a;

/* loaded from: classes5.dex */
public abstract class f<T, R> extends qj.a<R> implements qj.b<T> {

    /* renamed from: d */
    public static final Object[] f26784d = new Object[0];

    public f(a.m0<R> m0Var) {
        super(m0Var);
    }

    @uj.b
    public boolean A5() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean B5();

    @uj.b
    public boolean C5() {
        throw new UnsupportedOperationException();
    }

    @uj.b
    public boolean D5() {
        throw new UnsupportedOperationException();
    }

    public final e<T, R> E5() {
        return getClass() == e.class ? (e) this : new e<>(this);
    }

    @uj.b
    public Throwable w5() {
        throw new UnsupportedOperationException();
    }

    @uj.b
    public T x5() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @uj.b
    public Object[] y5() {
        Object[] objArr = f26784d;
        Object[] z52 = z5(objArr);
        return z52 == objArr ? new Object[0] : z52;
    }

    @uj.b
    public T[] z5(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
