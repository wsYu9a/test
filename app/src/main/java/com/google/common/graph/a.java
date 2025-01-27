package com.google.common.graph;

import b5.n;
import b5.u;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.a;
import e5.z1;
import h5.a0;
import h5.s;
import h5.t;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class a<N, V> implements a0<N, V> {

    /* renamed from: e */
    public static final Object f10019e = new Object();

    /* renamed from: a */
    public final Map<N, Object> f10020a;

    /* renamed from: b */
    @CheckForNull
    public final List<f<N>> f10021b;

    /* renamed from: c */
    public int f10022c;

    /* renamed from: d */
    public int f10023d;

    /* renamed from: com.google.common.graph.a$a */
    public class C0296a extends AbstractSet<N> {

        /* renamed from: com.google.common.graph.a$a$a */
        public class C0297a extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f10025d;

            /* renamed from: e */
            public final /* synthetic */ Set f10026e;

            public C0297a(C0296a c0296a, Iterator it, Set set) {
                this.f10025d = it;
                this.f10026e = set;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (this.f10025d.hasNext()) {
                    f fVar = (f) this.f10025d.next();
                    if (this.f10026e.add(fVar.f10036a)) {
                        return fVar.f10036a;
                    }
                }
                return b();
            }
        }

        public C0296a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<N> iterator() {
            return new C0297a(this, a.this.f10021b.iterator(), new HashSet());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return a.this.f10020a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.f10020a.size();
        }
    }

    public class b extends AbstractSet<N> {

        /* renamed from: com.google.common.graph.a$b$a */
        public class C0298a extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f10028d;

            public C0298a(b bVar, Iterator it) {
                this.f10028d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (this.f10028d.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f10028d.next();
                    if (a.s(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return b();
            }
        }

        /* renamed from: com.google.common.graph.a$b$b */
        public class C0299b extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f10029d;

            public C0299b(b bVar, Iterator it) {
                this.f10029d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (this.f10029d.hasNext()) {
                    f fVar = (f) this.f10029d.next();
                    if (fVar instanceof f.C0301a) {
                        return fVar.f10036a;
                    }
                }
                return b();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<N> iterator() {
            return a.this.f10021b == null ? new C0298a(this, a.this.f10020a.entrySet().iterator()) : new C0299b(this, a.this.f10021b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return a.s(a.this.f10020a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.f10022c;
        }
    }

    public class c extends AbstractSet<N> {

        /* renamed from: com.google.common.graph.a$c$a */
        public class C0300a extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f10031d;

            public C0300a(c cVar, Iterator it) {
                this.f10031d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (this.f10031d.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f10031d.next();
                    if (a.t(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return b();
            }
        }

        public class b extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f10032d;

            public b(c cVar, Iterator it) {
                this.f10032d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (this.f10032d.hasNext()) {
                    f fVar = (f) this.f10032d.next();
                    if (fVar instanceof f.b) {
                        return fVar.f10036a;
                    }
                }
                return b();
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<N> iterator() {
            return a.this.f10021b == null ? new C0300a(this, a.this.f10020a.entrySet().iterator()) : new b(this, a.this.f10021b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return a.t(a.this.f10020a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.f10023d;
        }
    }

    public class d extends AbstractIterator<t<N>> {

        /* renamed from: d */
        public final /* synthetic */ Iterator f10033d;

        /* renamed from: e */
        public final /* synthetic */ AtomicBoolean f10034e;

        public d(a aVar, Iterator it, AtomicBoolean atomicBoolean) {
            this.f10033d = it;
            this.f10034e = atomicBoolean;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: d */
        public t<N> a() {
            while (this.f10033d.hasNext()) {
                t<N> tVar = (t) this.f10033d.next();
                if (!tVar.d().equals(tVar.e()) || !this.f10034e.getAndSet(true)) {
                    return tVar;
                }
            }
            return b();
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10035a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f10035a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10035a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class f<N> {

        /* renamed from: a */
        public final N f10036a;

        /* renamed from: com.google.common.graph.a$f$a */
        public static final class C0301a<N> extends f<N> {
            public C0301a(N n10) {
                super(n10);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof C0301a) {
                    return this.f10036a.equals(((C0301a) obj).f10036a);
                }
                return false;
            }

            public int hashCode() {
                return C0301a.class.hashCode() + this.f10036a.hashCode();
            }
        }

        public static final class b<N> extends f<N> {
            public b(N n10) {
                super(n10);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof b) {
                    return this.f10036a.equals(((b) obj).f10036a);
                }
                return false;
            }

            public int hashCode() {
                return b.class.hashCode() + this.f10036a.hashCode();
            }
        }

        public f(N n10) {
            this.f10036a = (N) u.E(n10);
        }
    }

    public static final class g {

        /* renamed from: a */
        public final Object f10037a;

        public g(Object obj) {
            this.f10037a = obj;
        }
    }

    public a(Map<N, Object> map, @CheckForNull List<f<N>> list, int i10, int i11) {
        this.f10020a = (Map) u.E(map);
        this.f10021b = list;
        this.f10022c = Graphs.b(i10);
        this.f10023d = Graphs.b(i11);
        u.g0(i10 <= map.size() && i11 <= map.size());
    }

    public static boolean s(@CheckForNull Object obj) {
        return obj == f10019e || (obj instanceof g);
    }

    public static boolean t(@CheckForNull Object obj) {
        return (obj == f10019e || obj == null) ? false : true;
    }

    public static /* synthetic */ t u(Object obj, Object obj2) {
        return t.h(obj2, obj);
    }

    public static /* synthetic */ t w(Object obj, f fVar) {
        return fVar instanceof f.b ? t.h(obj, fVar.f10036a) : t.h(fVar.f10036a, obj);
    }

    public static <N, V> a<N, V> x(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i10 = e.f10035a[elementOrder.h().ordinal()];
        if (i10 == 1) {
            arrayList = null;
        } else {
            if (i10 != 2) {
                throw new AssertionError(elementOrder.h());
            }
            arrayList = new ArrayList();
        }
        return new a<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> a<N, V> y(N n10, Iterable<t<N>> iterable, n<N, V> nVar) {
        u.E(n10);
        u.E(nVar);
        HashMap hashMap = new HashMap();
        ImmutableList.a builder = ImmutableList.builder();
        int i10 = 0;
        int i11 = 0;
        for (t<N> tVar : iterable) {
            if (tVar.d().equals(n10) && tVar.e().equals(n10)) {
                hashMap.put(n10, new g(nVar.apply(n10)));
                builder.a(new f.C0301a(n10));
                builder.a(new f.b(n10));
                i10++;
            } else if (tVar.e().equals(n10)) {
                N d10 = tVar.d();
                Object put = hashMap.put(d10, f10019e);
                if (put != null) {
                    hashMap.put(d10, new g(put));
                }
                builder.a(new f.C0301a(d10));
                i10++;
            } else {
                u.d(tVar.d().equals(n10));
                N e10 = tVar.e();
                V apply = nVar.apply(e10);
                Object put2 = hashMap.put(e10, apply);
                if (put2 != null) {
                    u.d(put2 == f10019e);
                    hashMap.put(e10, new g(apply));
                }
                builder.a(new f.b(e10));
            }
            i11++;
        }
        return new a<>(hashMap, builder.e(), i10, i11);
    }

    @Override // h5.a0
    public Set<N> a() {
        return new c();
    }

    @Override // h5.a0
    public Set<N> b() {
        return new b();
    }

    @Override // h5.a0
    public Set<N> c() {
        return this.f10021b == null ? Collections.unmodifiableSet(this.f10020a.keySet()) : new C0296a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a0
    @CheckForNull
    public V d(N n10) {
        u.E(n10);
        V v10 = (V) this.f10020a.get(n10);
        if (v10 == f10019e) {
            return null;
        }
        return v10 instanceof g ? (V) ((g) v10).f10037a : v10;
    }

    @Override // h5.a0
    @CheckForNull
    public V e(Object obj) {
        Object obj2;
        u.E(obj);
        Object obj3 = this.f10020a.get(obj);
        if (obj3 == null || obj3 == (obj2 = f10019e)) {
            obj3 = null;
        } else if (obj3 instanceof g) {
            this.f10020a.put(obj, obj2);
            obj3 = ((g) obj3).f10037a;
        } else {
            this.f10020a.remove(obj);
        }
        if (obj3 != null) {
            int i10 = this.f10023d - 1;
            this.f10023d = i10;
            Graphs.b(i10);
            List<f<N>> list = this.f10021b;
            if (list != null) {
                list.remove(new f.b(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return (V) obj3;
    }

    @Override // h5.a0
    public void f(N n10) {
        u.E(n10);
        Object obj = this.f10020a.get(n10);
        if (obj == f10019e) {
            this.f10020a.remove(n10);
        } else if (!(obj instanceof g)) {
            return;
        } else {
            this.f10020a.put(n10, ((g) obj).f10037a);
        }
        int i10 = this.f10022c - 1;
        this.f10022c = i10;
        Graphs.b(i10);
        List<f<N>> list = this.f10021b;
        if (list != null) {
            list.remove(new f.C0301a(n10));
        }
    }

    @Override // h5.a0
    public Iterator<t<N>> g(N n10) {
        u.E(n10);
        List<f<N>> list = this.f10021b;
        return new d(this, list == null ? Iterators.j(Iterators.c0(b().iterator(), new n() { // from class: h5.m

            /* renamed from: b */
            public final /* synthetic */ Object f26462b;

            public /* synthetic */ m(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                t u10;
                u10 = com.google.common.graph.a.u(n10, obj);
                return u10;
            }
        }), Iterators.c0(a().iterator(), new n() { // from class: h5.n

            /* renamed from: b */
            public final /* synthetic */ Object f26463b;

            public /* synthetic */ n(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                t h10;
                h10 = t.h(n10, obj);
                return h10;
            }
        })) : Iterators.c0(list.iterator(), new n() { // from class: h5.o

            /* renamed from: b */
            public final /* synthetic */ Object f26464b;

            public /* synthetic */ o(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                t w10;
                w10 = com.google.common.graph.a.w(n10, (a.f) obj);
                return w10;
            }
        }), new AtomicBoolean(false));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    @Override // h5.a0
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V h(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r0 = r4.f10020a
            java.lang.Object r0 = r0.put(r5, r6)
            r1 = 0
            if (r0 != 0) goto Lb
        L9:
            r0 = r1
            goto L2f
        Lb:
            boolean r2 = r0 instanceof com.google.common.graph.a.g
            if (r2 == 0) goto L20
            java.util.Map<N, java.lang.Object> r2 = r4.f10020a
            com.google.common.graph.a$g r3 = new com.google.common.graph.a$g
            r3.<init>(r6)
            r2.put(r5, r3)
            com.google.common.graph.a$g r0 = (com.google.common.graph.a.g) r0
            java.lang.Object r0 = com.google.common.graph.a.g.a(r0)
            goto L2f
        L20:
            java.lang.Object r2 = com.google.common.graph.a.f10019e
            if (r0 != r2) goto L2f
            java.util.Map<N, java.lang.Object> r0 = r4.f10020a
            com.google.common.graph.a$g r2 = new com.google.common.graph.a$g
            r2.<init>(r6)
            r0.put(r5, r2)
            goto L9
        L2f:
            if (r0 != 0) goto L46
            int r6 = r4.f10023d
            int r6 = r6 + 1
            r4.f10023d = r6
            com.google.common.graph.Graphs.d(r6)
            java.util.List<com.google.common.graph.a$f<N>> r6 = r4.f10021b
            if (r6 == 0) goto L46
            com.google.common.graph.a$f$b r2 = new com.google.common.graph.a$f$b
            r2.<init>(r5)
            r6.add(r2)
        L46:
            if (r0 != 0) goto L49
            goto L4a
        L49:
            r1 = r0
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.a.h(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // h5.a0
    public void i(N n10, V v10) {
        Map<N, Object> map = this.f10020a;
        Object obj = f10019e;
        Object put = map.put(n10, obj);
        if (put != null) {
            if (put instanceof g) {
                this.f10020a.put(n10, put);
                return;
            } else if (put == obj) {
                return;
            } else {
                this.f10020a.put(n10, new g(put));
            }
        }
        int i10 = this.f10022c + 1;
        this.f10022c = i10;
        Graphs.d(i10);
        List<f<N>> list = this.f10021b;
        if (list != null) {
            list.add(new f.C0301a(n10));
        }
    }
}
