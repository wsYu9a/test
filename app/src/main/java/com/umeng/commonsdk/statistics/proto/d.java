package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dd;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class d implements ch<d, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, ct> f24771d;

    /* renamed from: e */
    private static final long f24772e = 2846460275012375038L;

    /* renamed from: f */
    private static final dl f24773f = new dl("Imprint");

    /* renamed from: g */
    private static final db f24774g = new db(b7.e.f1381l, (byte) 13, 1);

    /* renamed from: h */
    private static final db f24775h = new db("version", (byte) 8, 2);

    /* renamed from: i */
    private static final db f24776i = new db("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends Cdo>, dp> f24777j;

    /* renamed from: k */
    private static final int f24778k = 0;

    /* renamed from: a */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f24779a;

    /* renamed from: b */
    public int f24780b;

    /* renamed from: c */
    public String f24781c;

    /* renamed from: l */
    private byte f24782l;

    public static class a extends dq<d> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, d dVar) throws cn {
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
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            dVar.f24781c = dgVar.z();
                            dVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 8) {
                        dVar.f24780b = dgVar.w();
                        dVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    dVar.f24779a = new HashMap(n10.f23834c * 2);
                    for (int i10 = 0; i10 < n10.f23834c; i10++) {
                        String z10 = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(dgVar);
                        dVar.f24779a.put(z10, eVar);
                    }
                    dgVar.o();
                    dVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, d dVar) throws cn {
            dVar.l();
            dgVar.a(d.f24773f);
            if (dVar.f24779a != null) {
                dgVar.a(d.f24774g);
                dgVar.a(new dd((byte) 11, (byte) 12, dVar.f24779a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24779a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            dgVar.a(d.f24775h);
            dgVar.a(dVar.f24780b);
            dgVar.c();
            if (dVar.f24781c != null) {
                dgVar.a(d.f24776i);
                dgVar.a(dVar.f24781c);
                dgVar.c();
            }
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

    public static class c extends dr<d> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, d dVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(dVar.f24779a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24779a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            dmVar.a(dVar.f24780b);
            dmVar.a(dVar.f24781c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, d dVar) throws cn {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            dVar.f24779a = new HashMap(ddVar.f23834c * 2);
            for (int i10 = 0; i10 < ddVar.f23834c; i10++) {
                String z10 = dmVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(dmVar);
                dVar.f24779a.put(z10, eVar);
            }
            dVar.a(true);
            dVar.f24780b = dmVar.w();
            dVar.b(true);
            dVar.f24781c = dmVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    public static class C0679d implements dp {
        private C0679d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a */
        public c b() {
            return new c();
        }

        public /* synthetic */ C0679d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f24777j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new C0679d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new ct(b7.e.f1381l, (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 1, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24771d = unmodifiableMap;
        ct.a(d.class, unmodifiableMap);
    }

    public d() {
        this.f24782l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f24779a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f24779a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f24779a = null;
        b(false);
        this.f24780b = 0;
        this.f24781c = null;
    }

    public void d() {
        this.f24779a = null;
    }

    public boolean e() {
        return this.f24779a != null;
    }

    public int f() {
        return this.f24780b;
    }

    public void g() {
        this.f24782l = ce.b(this.f24782l, 0);
    }

    public boolean h() {
        return ce.a(this.f24782l, 0);
    }

    public String i() {
        return this.f24781c;
    }

    public void j() {
        this.f24781c = null;
    }

    public boolean k() {
        return this.f24781c != null;
    }

    public void l() throws cn {
        if (this.f24779a == null) {
            throw new dh("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f24781c != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f24777j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Imprint(");
        sb2.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f24779a;
        if (map == null) {
            sb2.append("null");
        } else {
            sb2.append(map);
        }
        sb2.append(", ");
        sb2.append("version:");
        sb2.append(this.f24780b);
        sb2.append(", ");
        sb2.append("checksum:");
        String str = this.f24781c;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f24777j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        PROPERTY(1, b7.e.f1381l),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f24786d = new HashMap();

        /* renamed from: e */
        private final short f24788e;

        /* renamed from: f */
        private final String f24789f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f24786d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24788e = s10;
            this.f24789f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return PROPERTY;
            }
            if (i10 == 2) {
                return VERSION;
            }
            if (i10 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f24789f;
        }

        public static e a(String str) {
            return f24786d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f24788e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f24779a == null) {
            this.f24779a = new HashMap();
        }
        this.f24779a.put(str, eVar);
    }

    public void b(boolean z10) {
        this.f24782l = ce.a(this.f24782l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24781c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i10, String str) {
        this();
        this.f24779a = map;
        this.f24780b = i10;
        b(true);
        this.f24781c = str;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: b */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f24779a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24779a = null;
    }

    public d a(int i10) {
        this.f24780b = i10;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f24782l = (byte) 0;
        this.f24782l = dVar.f24782l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24779a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f24779a = hashMap;
        }
        this.f24780b = dVar.f24780b;
        if (dVar.k()) {
            this.f24781c = dVar.f24781c;
        }
    }

    public d a(String str) {
        this.f24781c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24782l = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
