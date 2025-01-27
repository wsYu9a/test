package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
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
public class c implements ch<c, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, ct> f24753d;

    /* renamed from: e */
    private static final long f24754e = -5764118265293965743L;

    /* renamed from: f */
    private static final dl f24755f = new dl("IdTracking");

    /* renamed from: g */
    private static final db f24756g = new db("snapshots", (byte) 13, 1);

    /* renamed from: h */
    private static final db f24757h = new db("journals", (byte) 15, 2);

    /* renamed from: i */
    private static final db f24758i = new db("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends Cdo>, dp> f24759j;

    /* renamed from: a */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f24760a;

    /* renamed from: b */
    public List<com.umeng.commonsdk.statistics.proto.a> f24761b;

    /* renamed from: c */
    public String f24762c;

    /* renamed from: k */
    private e[] f24763k;

    public static class a extends dq<c> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, c cVar) throws cn {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f23828b;
                if (b10 == 0) {
                    dgVar.k();
                    cVar.n();
                    return;
                }
                short s10 = l10.f23829c;
                int i10 = 0;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            cVar.f24762c = dgVar.z();
                            cVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 15) {
                        dc p10 = dgVar.p();
                        cVar.f24761b = new ArrayList(p10.f23831b);
                        while (i10 < p10.f23831b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(dgVar);
                            cVar.f24761b.add(aVar);
                            i10++;
                        }
                        dgVar.q();
                        cVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    cVar.f24760a = new HashMap(n10.f23834c * 2);
                    while (i10 < n10.f23834c) {
                        String z10 = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(dgVar);
                        cVar.f24760a.put(z10, bVar);
                        i10++;
                    }
                    dgVar.o();
                    cVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, c cVar) throws cn {
            cVar.n();
            dgVar.a(c.f24755f);
            if (cVar.f24760a != null) {
                dgVar.a(c.f24756g);
                dgVar.a(new dd((byte) 11, (byte) 12, cVar.f24760a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24760a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            if (cVar.f24761b != null && cVar.j()) {
                dgVar.a(c.f24757h);
                dgVar.a(new dc((byte) 12, cVar.f24761b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f24761b.iterator();
                while (it.hasNext()) {
                    it.next().write(dgVar);
                }
                dgVar.f();
                dgVar.c();
            }
            if (cVar.f24762c != null && cVar.m()) {
                dgVar.a(c.f24758i);
                dgVar.a(cVar.f24762c);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    public static class C0678c extends dr<c> {
        private C0678c() {
        }

        public /* synthetic */ C0678c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, c cVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(cVar.f24760a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24760a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (cVar.j()) {
                dmVar.a(cVar.f24761b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f24761b.iterator();
                while (it.hasNext()) {
                    it.next().write(dmVar);
                }
            }
            if (cVar.m()) {
                dmVar.a(cVar.f24762c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, c cVar) throws cn {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            cVar.f24760a = new HashMap(ddVar.f23834c * 2);
            for (int i10 = 0; i10 < ddVar.f23834c; i10++) {
                String z10 = dmVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(dmVar);
                cVar.f24760a.put(z10, bVar);
            }
            cVar.a(true);
            BitSet b10 = dmVar.b(2);
            if (b10.get(0)) {
                dc dcVar = new dc((byte) 12, dmVar.w());
                cVar.f24761b = new ArrayList(dcVar.f23831b);
                for (int i11 = 0; i11 < dcVar.f23831b; i11++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(dmVar);
                    cVar.f24761b.add(aVar);
                }
                cVar.b(true);
            }
            if (b10.get(1)) {
                cVar.f24762c = dmVar.z();
                cVar.c(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a */
        public C0678c b() {
            return new C0678c();
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f24759j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new ct("snapshots", (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new ct("journals", (byte) 2, new cv((byte) 15, new cy((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 2, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24753d = unmodifiableMap;
        ct.a(c.class, unmodifiableMap);
    }

    public c() {
        this.f24763k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f24760a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f24760a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f24760a = null;
        this.f24761b = null;
        this.f24762c = null;
    }

    public void d() {
        this.f24760a = null;
    }

    public boolean e() {
        return this.f24760a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f24761b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f24761b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f24761b;
    }

    public void i() {
        this.f24761b = null;
    }

    public boolean j() {
        return this.f24761b != null;
    }

    public String k() {
        return this.f24762c;
    }

    public void l() {
        this.f24762c = null;
    }

    public boolean m() {
        return this.f24762c != null;
    }

    public void n() throws cn {
        if (this.f24760a != null) {
            return;
        }
        throw new dh("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f24759j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdTracking(");
        sb2.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f24760a;
        if (map == null) {
            sb2.append("null");
        } else {
            sb2.append(map);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f24761b;
            if (list == null) {
                sb2.append("null");
            } else {
                sb2.append(list);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("checksum:");
            String str = this.f24762c;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f24759j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f24767d = new HashMap();

        /* renamed from: e */
        private final short f24769e;

        /* renamed from: f */
        private final String f24770f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f24767d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24769e = s10;
            this.f24770f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return SNAPSHOTS;
            }
            if (i10 == 2) {
                return JOURNALS;
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
            return this.f24770f;
        }

        public static e a(String str) {
            return f24767d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f24769e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f24760a == null) {
            this.f24760a = new HashMap();
        }
        this.f24760a.put(str, bVar);
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f24761b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24762c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f24760a = map;
    }

    public c(c cVar) {
        this.f24763k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24760a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f24760a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f24761b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f24761b = arrayList;
        }
        if (cVar.m()) {
            this.f24762c = cVar.f24762c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f24760a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24760a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f24761b == null) {
            this.f24761b = new ArrayList();
        }
        this.f24761b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f24761b = list;
        return this;
    }

    public c a(String str) {
        this.f24762c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
