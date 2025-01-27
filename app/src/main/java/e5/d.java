package e5;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class d<T> extends z1<T> {

    /* renamed from: b */
    @CheckForNull
    public T f25610b;

    public d(@CheckForNull T t10) {
        this.f25610b = t10;
    }

    @CheckForNull
    public abstract T a(T t10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25610b != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t10 = this.f25610b;
        if (t10 == null) {
            throw new NoSuchElementException();
        }
        this.f25610b = a(t10);
        return t10;
    }
}
