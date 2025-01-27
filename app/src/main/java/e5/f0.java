package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class f0<T> extends l0 implements Iterator<T> {
    @Override // e5.l0
    /* renamed from: e */
    public abstract Iterator<T> delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @CanIgnoreReturnValue
    @d1
    public T next() {
        return delegate().next();
    }

    public void remove() {
        delegate().remove();
    }
}
