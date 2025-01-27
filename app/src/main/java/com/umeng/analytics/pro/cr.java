package com.umeng.analytics.pro;

import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.cr;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class cr<T extends cr<?, ?>, F extends co> implements ch<T, F> {

    /* renamed from: c */
    private static final Map<Class<? extends Cdo>, dp> f23756c;

    /* renamed from: a */
    protected Object f23757a;

    /* renamed from: b */
    protected F f23758b;

    public static class a extends dq<cr> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, cr crVar) throws cn {
            crVar.f23758b = null;
            crVar.f23757a = null;
            dgVar.j();
            db l10 = dgVar.l();
            Object a10 = crVar.a(dgVar, l10);
            crVar.f23757a = a10;
            if (a10 != null) {
                crVar.f23758b = (F) crVar.a(l10.f23829c);
            }
            dgVar.m();
            dgVar.l();
            dgVar.k();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, cr crVar) throws cn {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.d());
            dgVar.a(crVar.c(crVar.f23758b));
            crVar.a(dgVar);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a */
        public a b() {
            return new a();
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class c extends dr<cr> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, cr crVar) throws cn {
            crVar.f23758b = null;
            crVar.f23757a = null;
            short v10 = dgVar.v();
            Object a10 = crVar.a(dgVar, v10);
            crVar.f23757a = a10;
            if (a10 != null) {
                crVar.f23758b = (F) crVar.a(v10);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, cr crVar) throws cn {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.f23758b.a());
            crVar.b(dgVar);
        }
    }

    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a */
        public c b() {
            return new c();
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f23756c = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
    }

    public cr() {
        this.f23758b = null;
        this.f23757a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof ch ? ((ch) obj).deepCopy() : obj instanceof ByteBuffer ? ci.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s10);

    public abstract Object a(dg dgVar, db dbVar) throws cn;

    public abstract Object a(dg dgVar, short s10) throws cn;

    public abstract void a(dg dgVar) throws cn;

    public Object b() {
        return this.f23757a;
    }

    public abstract void b(F f10, Object obj) throws ClassCastException;

    public abstract void b(dg dgVar) throws cn;

    public abstract db c(F f10);

    public boolean c() {
        return this.f23758b != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public final void clear() {
        this.f23758b = null;
        this.f23757a = null;
    }

    public abstract dl d();

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f23756c.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(getClass().getSimpleName());
        sb2.append(" ");
        if (a() != null) {
            Object b10 = b();
            sb2.append(c(a()).f23827a);
            sb2.append(":");
            if (b10 instanceof ByteBuffer) {
                ci.a((ByteBuffer) b10, sb2);
            } else {
                sb2.append(b10.toString());
            }
        }
        sb2.append(">");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f23756c.get(dgVar.D()).b().a(dgVar, this);
    }

    public boolean b(F f10) {
        return this.f23758b == f10;
    }

    public boolean b(int i10) {
        return b((cr<T, F>) a((short) i10));
    }

    public cr(F f10, Object obj) {
        a((cr<T, F>) f10, obj);
    }

    public cr(cr<T, F> crVar) {
        if (crVar.getClass().equals(getClass())) {
            this.f23758b = crVar.f23758b;
            this.f23757a = a(crVar.f23757a);
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
        return this.f23758b;
    }

    public Object a(F f10) {
        if (f10 == this.f23758b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f10 + " because union's set field is " + this.f23758b);
    }

    public Object a(int i10) {
        return a((cr<T, F>) a((short) i10));
    }

    public void a(F f10, Object obj) {
        b(f10, obj);
        this.f23758b = f10;
        this.f23757a = obj;
    }

    public void a(int i10, Object obj) {
        a((cr<T, F>) a((short) i10), obj);
    }
}
