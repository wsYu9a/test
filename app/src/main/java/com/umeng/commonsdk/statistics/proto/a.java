package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
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
public class a implements ch<a, e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<e, ct> f24710e;

    /* renamed from: f */
    private static final long f24711f = 9132678615281394583L;

    /* renamed from: g */
    private static final dl f24712g = new dl("IdJournal");

    /* renamed from: h */
    private static final db f24713h = new db("domain", (byte) 11, 1);

    /* renamed from: i */
    private static final db f24714i = new db("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final db f24715j = new db("new_id", (byte) 11, 3);

    /* renamed from: k */
    private static final db f24716k = new db("ts", (byte) 10, 4);

    /* renamed from: l */
    private static final Map<Class<? extends Cdo>, dp> f24717l;

    /* renamed from: m */
    private static final int f24718m = 0;

    /* renamed from: a */
    public String f24719a;

    /* renamed from: b */
    public String f24720b;

    /* renamed from: c */
    public String f24721c;

    /* renamed from: d */
    public long f24722d;

    /* renamed from: n */
    private byte f24723n;

    /* renamed from: o */
    private e[] f24724o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    public static class C0676a extends dq<a> {
        private C0676a() {
        }

        public /* synthetic */ C0676a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, a aVar) throws cn {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f23828b;
                if (b10 == 0) {
                    break;
                }
                short s10 = l10.f23829c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            if (s10 != 4) {
                                dj.a(dgVar, b10);
                            } else if (b10 == 10) {
                                aVar.f24722d = dgVar.x();
                                aVar.d(true);
                            } else {
                                dj.a(dgVar, b10);
                            }
                        } else if (b10 == 11) {
                            aVar.f24721c = dgVar.z();
                            aVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 11) {
                        aVar.f24720b = dgVar.z();
                        aVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    aVar.f24719a = dgVar.z();
                    aVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, a aVar) throws cn {
            aVar.n();
            dgVar.a(a.f24712g);
            if (aVar.f24719a != null) {
                dgVar.a(a.f24713h);
                dgVar.a(aVar.f24719a);
                dgVar.c();
            }
            if (aVar.f24720b != null && aVar.g()) {
                dgVar.a(a.f24714i);
                dgVar.a(aVar.f24720b);
                dgVar.c();
            }
            if (aVar.f24721c != null) {
                dgVar.a(a.f24715j);
                dgVar.a(aVar.f24721c);
                dgVar.c();
            }
            dgVar.a(a.f24716k);
            dgVar.a(aVar.f24722d);
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
        public C0676a b() {
            return new C0676a();
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class c extends dr<a> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, a aVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(aVar.f24719a);
            dmVar.a(aVar.f24721c);
            dmVar.a(aVar.f24722d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (aVar.g()) {
                dmVar.a(aVar.f24720b);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, a aVar) throws cn {
            dm dmVar = (dm) dgVar;
            aVar.f24719a = dmVar.z();
            aVar.a(true);
            aVar.f24721c = dmVar.z();
            aVar.c(true);
            aVar.f24722d = dmVar.x();
            aVar.d(true);
            if (dmVar.b(1).get(0)) {
                aVar.f24720b = dmVar.z();
                aVar.b(true);
            }
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
        f24717l = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new ct("domain", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new ct("old_id", (byte) 2, new cu((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new ct("new_id", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new ct("ts", (byte) 1, new cu((byte) 10)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24710e = unmodifiableMap;
        ct.a(a.class, unmodifiableMap);
    }

    public a() {
        this.f24723n = (byte) 0;
        this.f24724o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f24719a;
    }

    public void c() {
        this.f24719a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f24719a = null;
        this.f24720b = null;
        this.f24721c = null;
        d(false);
        this.f24722d = 0L;
    }

    public boolean d() {
        return this.f24719a != null;
    }

    public String e() {
        return this.f24720b;
    }

    public void f() {
        this.f24720b = null;
    }

    public boolean g() {
        return this.f24720b != null;
    }

    public String h() {
        return this.f24721c;
    }

    public void i() {
        this.f24721c = null;
    }

    public boolean j() {
        return this.f24721c != null;
    }

    public long k() {
        return this.f24722d;
    }

    public void l() {
        this.f24723n = ce.b(this.f24723n, 0);
    }

    public boolean m() {
        return ce.a(this.f24723n, 0);
    }

    public void n() throws cn {
        if (this.f24719a == null) {
            throw new dh("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f24721c != null) {
            return;
        }
        throw new dh("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f24717l.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdJournal(");
        sb2.append("domain:");
        String str = this.f24719a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("old_id:");
            String str2 = this.f24720b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("new_id:");
        String str3 = this.f24721c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("ts:");
        sb2.append(this.f24722d);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f24717l.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e */
        private static final Map<String, e> f24729e = new HashMap();

        /* renamed from: f */
        private final short f24731f;

        /* renamed from: g */
        private final String f24732g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f24729e.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24731f = s10;
            this.f24732g = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return DOMAIN;
            }
            if (i10 == 2) {
                return OLD_ID;
            }
            if (i10 == 3) {
                return NEW_ID;
            }
            if (i10 != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f24732g;
        }

        public static e a(String str) {
            return f24729e.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f24731f;
        }
    }

    public a a(String str) {
        this.f24719a = str;
        return this;
    }

    public a b(String str) {
        this.f24720b = str;
        return this;
    }

    public a c(String str) {
        this.f24721c = str;
        return this;
    }

    public void d(boolean z10) {
        this.f24723n = ce.a(this.f24723n, 0, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24719a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f24720b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24721c = null;
    }

    public a(String str, String str2, long j10) {
        this();
        this.f24719a = str;
        this.f24721c = str2;
        this.f24722d = j10;
        d(true);
    }

    public a a(long j10) {
        this.f24722d = j10;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public a(a aVar) {
        this.f24723n = (byte) 0;
        this.f24724o = new e[]{e.OLD_ID};
        this.f24723n = aVar.f24723n;
        if (aVar.d()) {
            this.f24719a = aVar.f24719a;
        }
        if (aVar.g()) {
            this.f24720b = aVar.f24720b;
        }
        if (aVar.j()) {
            this.f24721c = aVar.f24721c;
        }
        this.f24722d = aVar.f24722d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24723n = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
