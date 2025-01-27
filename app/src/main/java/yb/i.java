package yb;

/* loaded from: classes3.dex */
public class i<E> extends m<E> {
    public i(String str, String str2, int i10, Class<E> cls) {
        super(str2 + str, i10, cls);
    }

    public boolean m(E e10) {
        boolean c10;
        synchronized (e10.getClass()) {
            c10 = c(e10);
        }
        return c10;
    }

    public boolean n(E e10) {
        boolean h10;
        synchronized (e10.getClass()) {
            h10 = h(e10);
        }
        return h10;
    }

    public boolean o(E e10) {
        boolean z10;
        synchronized (e10.getClass()) {
            z10 = e(e10) != -1;
        }
        return z10;
    }
}
