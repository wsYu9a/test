package e5;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class n0<E> extends y<E> implements Set<E> {
    @Override // e5.y, e5.l0
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        return Sets.g(this, obj);
    }

    public int standardHashCode() {
        return Sets.k(this);
    }

    @Override // e5.y
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.I(this, (Collection) b5.u.E(collection));
    }
}
