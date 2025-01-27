package com.google.common.base;

import b5.e;
import b5.g;
import b5.n;
import b5.r;
import b5.s;
import b5.u;
import b5.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@g
/* loaded from: classes2.dex */
public final class Predicates {

    public static class AndPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends v<? super T>> components;

        public /* synthetic */ AndPredicate(List list, a aVar) {
            this(list);
        }

        @Override // b5.v
        public boolean apply(@s T t10) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (!this.components.get(i10).apply(t10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.w("and", this.components);
        }

        private AndPredicate(List<? extends v<? super T>> list) {
            this.components = list;
        }
    }

    public static class CompositionPredicate<A, B> implements v<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        final n<A, ? extends B> f9114f;

        /* renamed from: p */
        final v<B> f9115p;

        public /* synthetic */ CompositionPredicate(v vVar, n nVar, a aVar) {
            this(vVar, nVar);
        }

        @Override // b5.v
        public boolean apply(@s A a10) {
            return this.f9115p.apply(this.f9114f.apply(a10));
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f9114f.equals(compositionPredicate.f9114f) && this.f9115p.equals(compositionPredicate.f9115p);
        }

        public int hashCode() {
            return this.f9114f.hashCode() ^ this.f9115p.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.f9115p);
            String valueOf2 = String.valueOf(this.f9114f);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private CompositionPredicate(v<B> vVar, n<A, ? extends B> nVar) {
            this.f9115p = (v) u.E(vVar);
            this.f9114f = (n) u.E(nVar);
        }
    }

    @a5.c
    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        public ContainsPatternFromStringPredicate(String str) {
            super(b.b(str));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            String pattern = this.pattern.pattern();
            StringBuilder sb2 = new StringBuilder(String.valueOf(pattern).length() + 28);
            sb2.append("Predicates.containsPattern(");
            sb2.append(pattern);
            sb2.append(")");
            return sb2.toString();
        }
    }

    @a5.c
    public static class ContainsPatternPredicate implements v<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final e pattern;

        public ContainsPatternPredicate(e eVar) {
            this.pattern = (e) u.E(eVar);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
            return r.a(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) && this.pattern.flags() == containsPatternPredicate.pattern.flags();
        }

        public int hashCode() {
            return r.b(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public String toString() {
            String bVar = com.google.common.base.a.c(this.pattern).f("pattern", this.pattern.pattern()).d("pattern.flags", this.pattern.flags()).toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(bVar).length() + 21);
            sb2.append("Predicates.contains(");
            sb2.append(bVar);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // b5.v
        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).b();
        }
    }

    public static class InPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public /* synthetic */ InPredicate(Collection collection, a aVar) {
            this(collection);
        }

        @Override // b5.v
        public boolean apply(@s T t10) {
            try {
                return this.target.contains(t10);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 15);
            sb2.append("Predicates.in(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) u.E(collection);
        }
    }

    @a5.c
    public static class InstanceOfPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ InstanceOfPredicate(Class cls, a aVar) {
            this(cls);
        }

        @Override // b5.v
        public boolean apply(@s T t10) {
            return this.clazz.isInstance(t10);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            String name = this.clazz.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 23);
            sb2.append("Predicates.instanceOf(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        private InstanceOfPredicate(Class<?> cls) {
            this.clazz = (Class) u.E(cls);
        }
    }

    public static class IsEqualToPredicate implements v<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        public /* synthetic */ IsEqualToPredicate(Object obj, a aVar) {
            this(obj);
        }

        @Override // b5.v
        public boolean apply(@CheckForNull Object obj) {
            return this.target.equals(obj);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Predicates.equalTo(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private IsEqualToPredicate(Object obj) {
            this.target = obj;
        }

        public <T> v<T> withNarrowedType() {
            return this;
        }
    }

    public static class NotPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        final v<T> predicate;

        public NotPredicate(v<T> vVar) {
            this.predicate = (v) u.E(vVar);
        }

        @Override // b5.v
        public boolean apply(@s T t10) {
            return !this.predicate.apply(t10);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
            sb2.append("Predicates.not(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public enum ObjectPredicate implements v<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$1 */
        public enum AnonymousClass1 extends ObjectPredicate {
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$2 */
        public enum AnonymousClass2 extends ObjectPredicate {
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$3 */
        public enum AnonymousClass3 extends ObjectPredicate {
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$4 */
        public enum AnonymousClass4 extends ObjectPredicate {
            @Override // b5.v
            public boolean apply(@CheckForNull Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        /* synthetic */ ObjectPredicate(a aVar) {
            this();
        }

        public <T> v<T> withNarrowedType() {
            return this;
        }
    }

    public static class OrPredicate<T> implements v<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends v<? super T>> components;

        public /* synthetic */ OrPredicate(List list, a aVar) {
            this(list);
        }

        @Override // b5.v
        public boolean apply(@s T t10) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (this.components.get(i10).apply(t10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.w("or", this.components);
        }

        private OrPredicate(List<? extends v<? super T>> list) {
            this.components = list;
        }
    }

    @a5.c
    public static class SubtypeOfPredicate implements v<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ SubtypeOfPredicate(Class cls, a aVar) {
            this(cls);
        }

        @Override // b5.v
        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.clazz == ((SubtypeOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            String name = this.clazz.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 22);
            sb2.append("Predicates.subtypeOf(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        private SubtypeOfPredicate(Class<?> cls) {
            this.clazz = (Class) u.E(cls);
        }

        @Override // b5.v
        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }
    }

    @a5.b(serializable = true)
    public static <T> v<T> b() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @a5.b(serializable = true)
    public static <T> v<T> c() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> v<T> d(v<? super T> vVar, v<? super T> vVar2) {
        return new AndPredicate(g((v) u.E(vVar), (v) u.E(vVar2)));
    }

    public static <T> v<T> e(Iterable<? extends v<? super T>> iterable) {
        return new AndPredicate(k(iterable));
    }

    @SafeVarargs
    public static <T> v<T> f(v<? super T>... vVarArr) {
        return new AndPredicate(l(vVarArr));
    }

    public static <T> List<v<? super T>> g(v<? super T> vVar, v<? super T> vVar2) {
        return Arrays.asList(vVar, vVar2);
    }

    public static <A, B> v<A> h(v<B> vVar, n<A, ? extends B> nVar) {
        return new CompositionPredicate(vVar, nVar);
    }

    @a5.c("java.util.regex.Pattern")
    public static v<CharSequence> i(Pattern pattern) {
        return new ContainsPatternPredicate(new JdkPattern(pattern));
    }

    @a5.c
    public static v<CharSequence> j(String str) {
        return new ContainsPatternFromStringPredicate(str);
    }

    public static <T> List<T> k(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(u.E(it.next()));
        }
        return arrayList;
    }

    public static <T> List<T> l(T... tArr) {
        return k(Arrays.asList(tArr));
    }

    public static <T> v<T> m(@s T t10) {
        return t10 == null ? p() : new IsEqualToPredicate(t10).withNarrowedType();
    }

    public static <T> v<T> n(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    @a5.c
    public static <T> v<T> o(Class<?> cls) {
        return new InstanceOfPredicate(cls);
    }

    @a5.b(serializable = true)
    public static <T> v<T> p() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> v<T> q(v<T> vVar) {
        return new NotPredicate(vVar);
    }

    @a5.b(serializable = true)
    public static <T> v<T> r() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> v<T> s(v<? super T> vVar, v<? super T> vVar2) {
        return new OrPredicate(g((v) u.E(vVar), (v) u.E(vVar2)));
    }

    public static <T> v<T> t(Iterable<? extends v<? super T>> iterable) {
        return new OrPredicate(k(iterable));
    }

    @SafeVarargs
    public static <T> v<T> u(v<? super T>... vVarArr) {
        return new OrPredicate(l(vVarArr));
    }

    @a5.a
    @a5.c
    public static v<Class<?>> v(Class<?> cls) {
        return new SubtypeOfPredicate(cls);
    }

    public static String w(String str, Iterable<?> iterable) {
        StringBuilder sb2 = new StringBuilder("Predicates.");
        sb2.append(str);
        sb2.append('(');
        boolean z10 = true;
        for (Object obj : iterable) {
            if (!z10) {
                sb2.append(',');
            }
            sb2.append(obj);
            z10 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
