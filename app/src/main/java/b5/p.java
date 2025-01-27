package b5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a */
    public final String f1263a;

    public class a extends p {

        /* renamed from: b */
        public final /* synthetic */ String f1264b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p pVar, String str) {
            super(pVar, null);
            this.f1264b = str;
        }

        @Override // b5.p
        public p q() {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // b5.p
        public CharSequence r(@CheckForNull Object obj) {
            return obj == null ? this.f1264b : p.this.r(obj);
        }

        @Override // b5.p
        public p s(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public class b extends p {
        public b(p pVar) {
            super(pVar, null);
        }

        @Override // b5.p
        public <A extends Appendable> A d(A a10, Iterator<? extends Object> it) throws IOException {
            u.F(a10, "appendable");
            u.F(it, "parts");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next != null) {
                    a10.append(p.this.r(next));
                    break;
                }
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                if (next2 != null) {
                    a10.append(p.this.f1263a);
                    a10.append(p.this.r(next2));
                }
            }
            return a10;
        }

        @Override // b5.p
        public p s(String str) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // b5.p
        public d u(String str) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    public class c extends AbstractList<Object> {

        /* renamed from: b */
        public final /* synthetic */ Object[] f1267b;

        /* renamed from: c */
        public final /* synthetic */ Object f1268c;

        /* renamed from: d */
        public final /* synthetic */ Object f1269d;

        public c(Object[] objArr, Object obj, Object obj2) {
            this.f1267b = objArr;
            this.f1268c = obj;
            this.f1269d = obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        @CheckForNull
        public Object get(int i10) {
            return i10 != 0 ? i10 != 1 ? this.f1267b[i10 - 2] : this.f1269d : this.f1268c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1267b.length + 2;
        }
    }

    public static final class d {

        /* renamed from: a */
        public final p f1270a;

        /* renamed from: b */
        public final String f1271b;

        public /* synthetic */ d(p pVar, String str, a aVar) {
            this(pVar, str);
        }

        @CanIgnoreReturnValue
        @a5.a
        public <A extends Appendable> A a(A a10, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) b(a10, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @a5.a
        public <A extends Appendable> A b(A a10, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            u.E(a10);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a10.append(this.f1270a.r(next.getKey()));
                a10.append(this.f1271b);
                a10.append(this.f1270a.r(next.getValue()));
                while (it.hasNext()) {
                    a10.append(this.f1270a.f1263a);
                    Map.Entry<?, ?> next2 = it.next();
                    a10.append(this.f1270a.r(next2.getKey()));
                    a10.append(this.f1271b);
                    a10.append(this.f1270a.r(next2.getValue()));
                }
            }
            return a10;
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A c(A a10, Map<?, ?> map) throws IOException {
            return (A) a(a10, map.entrySet());
        }

        @CanIgnoreReturnValue
        @a5.a
        public StringBuilder d(StringBuilder sb2, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return e(sb2, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @a5.a
        public StringBuilder e(StringBuilder sb2, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                b(sb2, it);
                return sb2;
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @CanIgnoreReturnValue
        public StringBuilder f(StringBuilder sb2, Map<?, ?> map) {
            return d(sb2, map.entrySet());
        }

        @a5.a
        public String g(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return h(iterable.iterator());
        }

        @a5.a
        public String h(Iterator<? extends Map.Entry<?, ?>> it) {
            return e(new StringBuilder(), it).toString();
        }

        public String i(Map<?, ?> map) {
            return g(map.entrySet());
        }

        public d j(String str) {
            return new d(this.f1270a.s(str), this.f1271b);
        }

        public d(p pVar, String str) {
            this.f1270a = pVar;
            this.f1271b = (String) u.E(str);
        }
    }

    public /* synthetic */ p(p pVar, a aVar) {
        this(pVar);
    }

    public static Iterable<Object> j(@CheckForNull Object obj, @CheckForNull Object obj2, Object[] objArr) {
        u.E(objArr);
        return new c(objArr, obj, obj2);
    }

    public static p o(char c10) {
        return new p(String.valueOf(c10));
    }

    public static p p(String str) {
        return new p(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A b(A a10, Iterable<? extends Object> iterable) throws IOException {
        return (A) d(a10, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A c(A a10, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return (A) b(a10, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A d(A a10, Iterator<? extends Object> it) throws IOException {
        u.E(a10);
        if (it.hasNext()) {
            a10.append(r(it.next()));
            while (it.hasNext()) {
                a10.append(this.f1263a);
                a10.append(r(it.next()));
            }
        }
        return a10;
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A e(A a10, Object[] objArr) throws IOException {
        return (A) b(a10, Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder f(StringBuilder sb2, Iterable<? extends Object> iterable) {
        return h(sb2, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder g(StringBuilder sb2, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return f(sb2, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder h(StringBuilder sb2, Iterator<? extends Object> it) {
        try {
            d(sb2, it);
            return sb2;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder i(StringBuilder sb2, Object[] objArr) {
        return f(sb2, Arrays.asList(objArr));
    }

    public final String k(Iterable<? extends Object> iterable) {
        return m(iterable.iterator());
    }

    public final String l(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return k(j(obj, obj2, objArr));
    }

    public final String m(Iterator<? extends Object> it) {
        return h(new StringBuilder(), it).toString();
    }

    public final String n(Object[] objArr) {
        return k(Arrays.asList(objArr));
    }

    public p q() {
        return new b(this);
    }

    public CharSequence r(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public p s(String str) {
        u.E(str);
        return new a(this, str);
    }

    public d t(char c10) {
        return u(String.valueOf(c10));
    }

    public d u(String str) {
        return new d(this, str, null);
    }

    public p(String str) {
        this.f1263a = (String) u.E(str);
    }

    public p(p pVar) {
        this.f1263a = pVar.f1263a;
    }
}
