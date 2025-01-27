package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements av<a, e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<e, bh> f26385e;

    /* renamed from: f */
    private static final long f26386f = 9132678615281394583L;

    /* renamed from: g */
    private static final bz f26387g = new bz("IdJournal");

    /* renamed from: h */
    private static final bp f26388h = new bp("domain", (byte) 11, 1);

    /* renamed from: i */
    private static final bp f26389i = new bp("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final bp f26390j = new bp("new_id", (byte) 11, 3);
    private static final bp k = new bp("ts", (byte) 10, 4);
    private static final Map<Class<? extends cc>, cd> l;
    private static final int m = 0;

    /* renamed from: a */
    public String f26391a;

    /* renamed from: b */
    public String f26392b;

    /* renamed from: c */
    public String f26393c;

    /* renamed from: d */
    public long f26394d;
    private byte n;
    private e[] o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    private static class C0546a extends ce<a> {
        private C0546a() {
        }

        /* synthetic */ C0546a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, a aVar) throws bb {
            buVar.j();
            while (true) {
                bp l = buVar.l();
                byte b2 = l.f25780b;
                if (b2 == 0) {
                    break;
                }
                short s = l.f25781c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                bx.a(buVar, b2);
                            } else if (b2 == 10) {
                                aVar.f26394d = buVar.x();
                                aVar.d(true);
                            } else {
                                bx.a(buVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f26393c = buVar.z();
                            aVar.c(true);
                        } else {
                            bx.a(buVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f26392b = buVar.z();
                        aVar.b(true);
                    } else {
                        bx.a(buVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.f26391a = buVar.z();
                    aVar.a(true);
                } else {
                    bx.a(buVar, b2);
                }
                buVar.m();
            }
            buVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, a aVar) throws bb {
            aVar.n();
            buVar.a(a.f26387g);
            if (aVar.f26391a != null) {
                buVar.a(a.f26388h);
                buVar.a(aVar.f26391a);
                buVar.c();
            }
            if (aVar.f26392b != null && aVar.g()) {
                buVar.a(a.f26389i);
                buVar.a(aVar.f26392b);
                buVar.c();
            }
            if (aVar.f26393c != null) {
                buVar.a(a.f26390j);
                buVar.a(aVar.f26393c);
                buVar.c();
            }
            buVar.a(a.k);
            buVar.a(aVar.f26394d);
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
        public C0546a b() {
            return new C0546a();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class c extends cf<a> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(aVar.f26391a);
            caVar.a(aVar.f26393c);
            caVar.a(aVar.f26394d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (aVar.g()) {
                caVar.a(aVar.f26392b);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            aVar.f26391a = caVar.z();
            aVar.a(true);
            aVar.f26393c = caVar.z();
            aVar.c(true);
            aVar.f26394d = caVar.x();
            aVar.d(true);
            if (caVar.b(1).get(0)) {
                aVar.f26392b = caVar.z();
                aVar.b(true);
            }
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
        l = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new bh("domain", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new bh("old_id", (byte) 2, new bi((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new bh("new_id", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bh("ts", (byte) 1, new bi((byte) 10)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f26385e = unmodifiableMap;
        bh.a(a.class, unmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f26391a;
    }

    public void c() {
        this.f26391a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f26391a = null;
        this.f26392b = null;
        this.f26393c = null;
        d(false);
        this.f26394d = 0L;
    }

    public boolean d() {
        return this.f26391a != null;
    }

    public String e() {
        return this.f26392b;
    }

    public void f() {
        this.f26392b = null;
    }

    public boolean g() {
        return this.f26392b != null;
    }

    public String h() {
        return this.f26393c;
    }

    public void i() {
        this.f26393c = null;
    }

    public boolean j() {
        return this.f26393c != null;
    }

    public long k() {
        return this.f26394d;
    }

    public void l() {
        this.n = as.b(this.n, 0);
    }

    public boolean m() {
        return as.a(this.n, 0);
    }

    public void n() throws bb {
        if (this.f26391a == null) {
            throw new bv("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f26393c != null) {
            return;
        }
        throw new bv("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        l.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f26391a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f26392b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f26393c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f26394d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        l.get(buVar.D()).b().a(buVar, this);
    }

    public enum e implements bc {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e */
        private static final Map<String, e> f26399e = new HashMap();

        /* renamed from: f */
        private final short f26401f;

        /* renamed from: g */
        private final String f26402g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26399e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26401f = s;
            this.f26402g = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return DOMAIN;
            }
            if (i2 == 2) {
                return OLD_ID;
            }
            if (i2 == 3) {
                return NEW_ID;
            }
            if (i2 != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i2) {
            e a2 = a(i2);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f26402g;
        }

        public static e a(String str) {
            return f26399e.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f26401f;
        }
    }

    public a a(String str) {
        this.f26391a = str;
        return this;
    }

    public a b(String str) {
        this.f26392b = str;
        return this;
    }

    public a c(String str) {
        this.f26393c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = as.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26391a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f26392b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26393c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f26391a = str;
        this.f26393c = str2;
        this.f26394d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f26394d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f26391a = aVar.f26391a;
        }
        if (aVar.g()) {
            this.f26392b = aVar.f26392b;
        }
        if (aVar.j()) {
            this.f26393c = aVar.f26393c;
        }
        this.f26394d = aVar.f26394d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
