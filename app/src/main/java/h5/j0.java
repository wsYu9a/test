package h5;

import com.google.common.collect.AbstractIterator;
import e5.z1;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class j0<E> extends AbstractSet<E> {

    /* renamed from: b */
    public final Map<E, ?> f26458b;

    /* renamed from: c */
    public final Object f26459c;

    public class a extends AbstractIterator<E> {

        /* renamed from: d */
        public final /* synthetic */ Iterator f26460d;

        public a(Iterator it) {
            this.f26460d = it;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public E a() {
            while (this.f26460d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f26460d.next();
                if (j0.this.f26459c.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            return b();
        }
    }

    public j0(Map<E, ?> map, Object obj) {
        this.f26458b = (Map) b5.u.E(map);
        this.f26459c = b5.u.E(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b */
    public z1<E> iterator() {
        return new a(this.f26458b.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return this.f26459c.equals(this.f26458b.get(obj));
    }
}
