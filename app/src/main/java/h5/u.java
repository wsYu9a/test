package h5;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class u<N> extends AbstractIterator<t<N>> {

    /* renamed from: d */
    public final l<N> f26476d;

    /* renamed from: e */
    public final Iterator<N> f26477e;

    /* renamed from: f */
    @CheckForNull
    public N f26478f;

    /* renamed from: g */
    public Iterator<N> f26479g;

    public static final class b<N> extends u<N> {
        public /* synthetic */ b(l lVar, a aVar) {
            this(lVar);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: f */
        public t<N> a() {
            while (!this.f26479g.hasNext()) {
                if (!d()) {
                    return b();
                }
            }
            N n10 = this.f26478f;
            Objects.requireNonNull(n10);
            return t.h(n10, this.f26479g.next());
        }

        public b(l<N> lVar) {
            super(lVar);
        }
    }

    public static final class c<N> extends u<N> {

        /* renamed from: h */
        @CheckForNull
        public Set<N> f26480h;

        public /* synthetic */ c(l lVar, a aVar) {
            this(lVar);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: f */
        public t<N> a() {
            do {
                Objects.requireNonNull(this.f26480h);
                while (this.f26479g.hasNext()) {
                    N next = this.f26479g.next();
                    if (!this.f26480h.contains(next)) {
                        N n10 = this.f26478f;
                        Objects.requireNonNull(n10);
                        return t.k(n10, next);
                    }
                }
                this.f26480h.add(this.f26478f);
            } while (d());
            this.f26480h = null;
            return b();
        }

        public c(l<N> lVar) {
            super(lVar);
            this.f26480h = Sets.y(lVar.m().size() + 1);
        }
    }

    public /* synthetic */ u(l lVar, a aVar) {
        this(lVar);
    }

    public static <N> u<N> e(l<N> lVar) {
        return lVar.f() ? new b(lVar) : new c(lVar);
    }

    public final boolean d() {
        b5.u.g0(!this.f26479g.hasNext());
        if (!this.f26477e.hasNext()) {
            return false;
        }
        N next = this.f26477e.next();
        this.f26478f = next;
        this.f26479g = this.f26476d.b((l<N>) next).iterator();
        return true;
    }

    public u(l<N> lVar) {
        this.f26478f = null;
        this.f26479g = ImmutableSet.of().iterator();
        this.f26476d = lVar;
        this.f26477e = lVar.m().iterator();
    }
}
