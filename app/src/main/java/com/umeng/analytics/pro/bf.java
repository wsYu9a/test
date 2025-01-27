package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class bf<T extends bf<?, ?>, F extends bc> implements av<T, F> {

    /* renamed from: c */
    private static final Map<Class<? extends cc>, cd> f25730c;

    /* renamed from: a */
    protected Object f25731a;

    /* renamed from: b */
    protected F f25732b;

    private static class a extends ce<bf> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.f25732b = null;
            bfVar.f25731a = null;
            buVar.j();
            bp l = buVar.l();
            Object a2 = bfVar.a(buVar, l);
            bfVar.f25731a = a2;
            if (a2 != null) {
                bfVar.f25732b = (F) bfVar.a(l.f25781c);
            }
            buVar.m();
            buVar.l();
            buVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.d());
            buVar.a(bfVar.c(bfVar.f25732b));
            bfVar.a(buVar);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public a b() {
            return new a();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class c extends cf<bf> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.f25732b = null;
            bfVar.f25731a = null;
            short v = buVar.v();
            Object a2 = bfVar.a(buVar, v);
            bfVar.f25731a = a2;
            if (a2 != null) {
                bfVar.f25732b = (F) bfVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.f25732b.a());
            bfVar.b(buVar);
        }
    }

    private static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public c b() {
            return new c();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f25730c = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
    }

    protected bf() {
        this.f25732b = null;
        this.f25731a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof av ? ((av) obj).deepCopy() : obj instanceof ByteBuffer ? aw.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(bu buVar, bp bpVar) throws bb;

    protected abstract Object a(bu buVar, short s) throws bb;

    protected abstract void a(bu buVar) throws bb;

    public Object b() {
        return this.f25731a;
    }

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract void b(bu buVar) throws bb;

    protected abstract bp c(F f2);

    public boolean c() {
        return this.f25732b != null;
    }

    @Override // com.umeng.analytics.pro.av
    public final void clear() {
        this.f25732b = null;
        this.f25731a = null;
    }

    protected abstract bz d();

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f25730c.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).f25779a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                aw.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f25730c.get(buVar.D()).b().a(buVar, this);
    }

    public boolean b(F f2) {
        return this.f25732b == f2;
    }

    public boolean b(int i2) {
        return b((bf<T, F>) a((short) i2));
    }

    protected bf(F f2, Object obj) {
        a((bf<T, F>) f2, obj);
    }

    protected bf(bf<T, F> bfVar) {
        if (bfVar.getClass().equals(getClass())) {
            this.f25732b = bfVar.f25732b;
            this.f25731a = a(bfVar.f25731a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f25732b;
    }

    public Object a(F f2) {
        if (f2 == this.f25732b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f25732b);
    }

    public Object a(int i2) {
        return a((bf<T, F>) a((short) i2));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.f25732b = f2;
        this.f25731a = obj;
    }

    public void a(int i2, Object obj) {
        a((bf<T, F>) a((short) i2), obj);
    }
}
