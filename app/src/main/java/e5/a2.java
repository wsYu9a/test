package e5;

import com.google.errorprone.annotations.DoNotCall;
import java.util.ListIterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class a2<E> extends z1<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(@d1 E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void set(@d1 E e10) {
        throw new UnsupportedOperationException();
    }
}
