package com.google.common.base;

import b5.g;
import b5.n;
import b5.u;
import b5.z;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@DoNotMock("Use Optional.of(value) or Optional.absent()")
@g
/* loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public class a implements Iterable<T> {

        /* renamed from: b */
        public final /* synthetic */ Iterable f9111b;

        /* renamed from: com.google.common.base.Optional$a$a */
        public class C0258a extends AbstractIterator<T> {

            /* renamed from: d */
            public final Iterator<? extends Optional<? extends T>> f9112d;

            public C0258a() {
                this.f9112d = (Iterator) u.E(a.this.f9111b.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            @CheckForNull
            public T a() {
                while (this.f9112d.hasNext()) {
                    Optional<? extends T> next = this.f9112d.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f9111b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0258a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@CheckForNull T t10) {
        return t10 == null ? absent() : new Present(t10);
    }

    public static <T> Optional<T> of(T t10) {
        return new Present(u.E(t10));
    }

    @a5.a
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        u.E(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @a5.a
    public abstract T or(z<? extends T> zVar);

    public abstract T or(T t10);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(n<? super T, V> nVar);
}
