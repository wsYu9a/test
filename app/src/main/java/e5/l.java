package e5;

import com.google.common.collect.AbstractIterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class l<T> extends AbstractIterator<T> {

    /* renamed from: d */
    public final Queue<T> f25626d;

    public l(Queue<T> queue) {
        this.f25626d = (Queue) b5.u.E(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    @CheckForNull
    public T a() {
        return this.f25626d.isEmpty() ? b() : this.f25626d.remove();
    }
}
