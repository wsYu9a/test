package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c implements av<c, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f26420d;

    /* renamed from: e */
    private static final long f26421e = -5764118265293965743L;

    /* renamed from: f */
    private static final bz f26422f = new bz("IdTracking");

    /* renamed from: g */
    private static final bp f26423g = new bp("snapshots", (byte) 13, 1);

    /* renamed from: h */
    private static final bp f26424h = new bp("journals", (byte) 15, 2);

    /* renamed from: i */
    private static final bp f26425i = new bp("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f26426j;

    /* renamed from: a */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f26427a;

    /* renamed from: b */
    public List<com.umeng.commonsdk.statistics.proto.a> f26428b;

    /* renamed from: c */
    public String f26429c;
    private e[] k;

    private static class a extends ce<c> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, c cVar) throws bb {
            buVar.j();
            while (true) {
                bp l = buVar.l();
                byte b2 = l.f25780b;
                if (b2 == 0) {
                    buVar.k();
                    cVar.n();
                    return;
                }
                short s = l.f25781c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b2);
                        } else if (b2 == 11) {
                            cVar.f26429c = buVar.z();
                            cVar.c(true);
                        } else {
                            bx.a(buVar, b2);
                        }
                    } else if (b2 == 15) {
                        bq p = buVar.p();
                        cVar.f26428b = new ArrayList(p.f25783b);
                        while (i2 < p.f25783b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(buVar);
                            cVar.f26428b.add(aVar);
                            i2++;
                        }
                        buVar.q();
                        cVar.b(true);
                    } else {
                        bx.a(buVar, b2);
                    }
                } else if (b2 == 13) {
                    br n = buVar.n();
                    cVar.f26427a = new HashMap(n.f25786c * 2);
                    while (i2 < n.f25786c) {
                        String z = buVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(buVar);
                        cVar.f26427a.put(z, bVar);
                        i2++;
                    }
                    buVar.o();
                    cVar.a(true);
                } else {
                    bx.a(buVar, b2);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, c cVar) throws bb {
            cVar.n();
            buVar.a(c.f26422f);
            if (cVar.f26427a != null) {
                buVar.a(c.f26423g);
                buVar.a(new br((byte) 11, (byte) 12, cVar.f26427a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26427a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            if (cVar.f26428b != null && cVar.j()) {
                buVar.a(c.f26424h);
                buVar.a(new bq((byte) 12, cVar.f26428b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26428b.iterator();
                while (it.hasNext()) {
                    it.next().write(buVar);
                }
                buVar.f();
                buVar.c();
            }
            if (cVar.f26429c != null && cVar.m()) {
                buVar.a(c.f26425i);
                buVar.a(cVar.f26429c);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    private static class C0548c extends cf<c> {
        private C0548c() {
        }

        /* synthetic */ C0548c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(cVar.f26427a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26427a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            caVar.a(bitSet, 2);
            if (cVar.j()) {
                caVar.a(cVar.f26428b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26428b.iterator();
                while (it.hasNext()) {
                    it.next().write(caVar);
                }
            }
            if (cVar.m()) {
                caVar.a(cVar.f26429c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            cVar.f26427a = new HashMap(brVar.f25786c * 2);
            for (int i2 = 0; i2 < brVar.f25786c; i2++) {
                String z = caVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(caVar);
                cVar.f26427a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b2 = caVar.b(2);
            if (b2.get(0)) {
                bq bqVar = new bq((byte) 12, caVar.w());
                cVar.f26428b = new ArrayList(bqVar.f25783b);
                for (int i3 = 0; i3 < bqVar.f25783b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(caVar);
                    cVar.f26428b.add(aVar);
                }
                cVar.b(true);
            }
            if (b2.get(1)) {
                cVar.f26429c = caVar.z();
                cVar.c(true);
            }
        }
    }

    private static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public C0548c b() {
            return new C0548c();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f26426j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new bh("snapshots", (byte) 1, new bk((byte) 13, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new bh("journals", (byte) 2, new bj((byte) 15, new bm((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 2, new bi((byte) 11)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f26420d = unmodifiableMap;
        bh.a(c.class, unmodifiableMap);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f26427a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f26427a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f26427a = null;
        this.f26428b = null;
        this.f26429c = null;
    }

    public void d() {
        this.f26427a = null;
    }

    public boolean e() {
        return this.f26427a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f26428b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f26428b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f26428b;
    }

    public void i() {
        this.f26428b = null;
    }

    public boolean j() {
        return this.f26428b != null;
    }

    public String k() {
        return this.f26429c;
    }

    public void l() {
        this.f26429c = null;
    }

    public boolean m() {
        return this.f26429c != null;
    }

    public void n() throws bb {
        if (this.f26427a != null) {
            return;
        }
        throw new bv("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f26426j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f26427a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f26428b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f26429c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f26426j.get(buVar.D()).b().a(buVar, this);
    }

    public enum e implements bc {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f26433d = new HashMap();

        /* renamed from: e */
        private final short f26435e;

        /* renamed from: f */
        private final String f26436f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26433d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26435e = s;
            this.f26436f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return SNAPSHOTS;
            }
            if (i2 == 2) {
                return JOURNALS;
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
            return this.f26436f;
        }

        public static e a(String str) {
            return f26433d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f26435e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f26427a == null) {
            this.f26427a = new HashMap();
        }
        this.f26427a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f26428b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26429c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f26427a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26427a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f26427a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26428b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f26428b = arrayList;
        }
        if (cVar.m()) {
            this.f26429c = cVar.f26429c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f26427a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26427a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f26428b == null) {
            this.f26428b = new ArrayList();
        }
        this.f26428b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f26428b = list;
        return this;
    }

    public c a(String str) {
        this.f26429c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
