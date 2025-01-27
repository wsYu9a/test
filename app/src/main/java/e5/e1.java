package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

@a5.b
@DoNotMock("Use Iterators.peekingIterator")
@m
/* loaded from: classes2.dex */
public interface e1<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    @d1
    E next();

    @d1
    E peek();

    @Override // java.util.Iterator
    void remove();
}
