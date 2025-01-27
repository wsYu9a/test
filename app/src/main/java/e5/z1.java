package e5;

import com.google.errorprone.annotations.DoNotCall;
import java.util.Iterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class z1<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
