package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class d implements av<d, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f26437d;

    /* renamed from: e */
    private static final long f26438e = 2846460275012375038L;

    /* renamed from: f */
    private static final bz f26439f = new bz("Imprint");

    /* renamed from: g */
    private static final bp f26440g = new bp("property", (byte) 13, 1);

    /* renamed from: h */
    private static final bp f26441h = new bp("version", (byte) 8, 2);

    /* renamed from: i */
    private static final bp f26442i = new bp("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f26443j;
    private static final int k = 0;

    /* renamed from: a */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f26444a;

    /* renamed from: b */
    public int f26445b;

    /* renamed from: c */
    public String f26446c;
    private byte l;

    private static class a extends ce<d> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, d dVar) throws bb {
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
                            bx.a(buVar, b2);
                        } else if (b2 == 11) {
                            dVar.f26446c = buVar.z();
                            dVar.c(true);
                        } else {
                            bx.a(buVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f26445b = buVar.w();
                        dVar.b(true);
                    } else {
                        bx.a(buVar, b2);
                    }
                } else if (b2 == 13) {
                    br n = buVar.n();
                    dVar.f26444a = new HashMap(n.f25786c * 2);
                    for (int i2 = 0; i2 < n.f25786c; i2++) {
                        String z = buVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(buVar);
                        dVar.f26444a.put(z, eVar);
                    }
                    buVar.o();
                    dVar.a(true);
                } else {
                    bx.a(buVar, b2);
                }
                buVar.m();
            }
            buVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, d dVar) throws bb {
            dVar.l();
            buVar.a(d.f26439f);
            if (dVar.f26444a != null) {
                buVar.a(d.f26440g);
                buVar.a(new br((byte) 11, (byte) 12, dVar.f26444a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26444a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            buVar.a(d.f26441h);
            buVar.a(dVar.f26445b);
            buVar.c();
            if (dVar.f26446c != null) {
                buVar.a(d.f26442i);
                buVar.a(dVar.f26446c);
                buVar.c();
            }
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

    private static class c extends cf<d> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(dVar.f26444a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26444a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            caVar.a(dVar.f26445b);
            caVar.a(dVar.f26446c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            dVar.f26444a = new HashMap(brVar.f25786c * 2);
            for (int i2 = 0; i2 < brVar.f25786c; i2++) {
                String z = caVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(caVar);
                dVar.f26444a.put(z, eVar);
            }
            dVar.a(true);
            dVar.f26445b = caVar.w();
            dVar.b(true);
            dVar.f26446c = caVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    private static class C0549d implements cd {
        private C0549d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public c b() {
            return new c();
        }

        /* synthetic */ C0549d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f26443j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new C0549d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bh("property", (byte) 1, new bk((byte) 13, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 1, new bi((byte) 11)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f26437d = unmodifiableMap;
        bh.a(d.class, unmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f26444a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f26444a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f26444a = null;
        b(false);
        this.f26445b = 0;
        this.f26446c = null;
    }

    public void d() {
        this.f26444a = null;
    }

    public boolean e() {
        return this.f26444a != null;
    }

    public int f() {
        return this.f26445b;
    }

    public void g() {
        this.l = as.b(this.l, 0);
    }

    public boolean h() {
        return as.a(this.l, 0);
    }

    public String i() {
        return this.f26446c;
    }

    public void j() {
        this.f26446c = null;
    }

    public boolean k() {
        return this.f26446c != null;
    }

    public void l() throws bb {
        if (this.f26444a == null) {
            throw new bv("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f26446c != null) {
            return;
        }
        throw new bv("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f26443j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f26444a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f26445b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f26446c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f26443j.get(buVar.D()).b().a(buVar, this);
    }

    public enum e implements bc {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f26450d = new HashMap();

        /* renamed from: e */
        private final short f26452e;

        /* renamed from: f */
        private final String f26453f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26450d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26452e = s;
            this.f26453f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return PROPERTY;
            }
            if (i2 == 2) {
                return VERSION;
            }
            if (i2 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f26453f;
        }

        public static e a(String str) {
            return f26450d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f26452e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f26444a == null) {
            this.f26444a = new HashMap();
        }
        this.f26444a.put(str, eVar);
    }

    public void b(boolean z) {
        this.l = as.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26446c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f26444a = map;
        this.f26445b = i2;
        b(true);
        this.f26446c = str;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f26444a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26444a = null;
    }

    public d a(int i2) {
        this.f26445b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26444a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f26444a = hashMap;
        }
        this.f26445b = dVar.f26445b;
        if (dVar.k()) {
            this.f26446c = dVar.f26446c;
        }
    }

    public d a(String str) {
        this.f26446c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
