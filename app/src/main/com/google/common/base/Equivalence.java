package com.google.common.base;

import b5.g;
import b5.n;
import b5.r;
import b5.s;
import b5.u;
import b5.v;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public abstract class Equivalence<T> {

    public static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    public static final class EquivalentToPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @CheckForNull
        private final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, @CheckForNull T t10) {
            this.equivalence = (Equivalence) u.E(equivalence);
            this.target = t10;
        }

        @Override // b5.v
        public boolean apply(@CheckForNull T t10) {
            return this.equivalence.equivalent(t10, this.target);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && r.a(this.target, equivalentToPredicate.target);
        }

        public int hashCode() {
            return r.b(this.equivalence, this.target);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 15 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".equivalentTo(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @s
        private final T reference;

        public /* synthetic */ Wrapper(Equivalence equivalence, Object obj, a aVar) {
            this(equivalence, obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        @s
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.reference);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 7 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".wrap(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private Wrapper(Equivalence<? super T> equivalence, @s T t10) {
            this.equivalence = (Equivalence) u.E(equivalence);
            this.reference = t10;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    @ForOverride
    public abstract boolean doEquivalent(T t10, T t11);

    @ForOverride
    public abstract int doHash(T t10);

    public final boolean equivalent(@CheckForNull T t10, @CheckForNull T t11) {
        if (t10 == t11) {
            return true;
        }
        if (t10 == null || t11 == null) {
            return false;
        }
        return doEquivalent(t10, t11);
    }

    public final v<T> equivalentTo(@CheckForNull T t10) {
        return new EquivalentToPredicate(this, t10);
    }

    public final int hash(@CheckForNull T t10) {
        if (t10 == null) {
            return 0;
        }
        return doHash(t10);
    }

    public final <F> Equivalence<F> onResultOf(n<? super F, ? extends T> nVar) {
        return new FunctionalEquivalence(nVar, this);
    }

    @a5.b(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(@s S s10) {
        return new Wrapper<>(s10);
    }
}
