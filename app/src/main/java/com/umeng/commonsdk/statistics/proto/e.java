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
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.vivo.ic.dm.Downloads;
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
public class e implements av<e, EnumC0550e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC0550e, bh> f26454d;

    /* renamed from: e */
    private static final long f26455e = 7501688097813630241L;

    /* renamed from: f */
    private static final bz f26456f = new bz("ImprintValue");

    /* renamed from: g */
    private static final bp f26457g = new bp(Downloads.RequestHeaders.COLUMN_VALUE, (byte) 11, 1);

    /* renamed from: h */
    private static final bp f26458h = new bp("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final bp f26459i = new bp("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f26460j;
    private static final int k = 0;

    /* renamed from: a */
    public String f26461a;

    /* renamed from: b */
    public long f26462b;

    /* renamed from: c */
    public String f26463c;
    private byte l;
    private EnumC0550e[] m;

    private static class a extends ce<e> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, e eVar) throws bb {
            buVar.j();
            while (true) {
                bp l = buVar.l();
                byte b2 = l.f25780b;
                if (b2 == 0) {
                    buVar.k();
                    eVar.k();
                    return;
                }
                short s = l.f25781c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b2);
                        } else if (b2 == 11) {
                            eVar.f26463c = buVar.z();
                            eVar.c(true);
                        } else {
                            bx.a(buVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f26462b = buVar.x();
                        eVar.b(true);
                    } else {
                        bx.a(buVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.f26461a = buVar.z();
                    eVar.a(true);
                } else {
                    bx.a(buVar, b2);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, e eVar) throws bb {
            eVar.k();
            buVar.a(e.f26456f);
            if (eVar.f26461a != null && eVar.d()) {
                buVar.a(e.f26457g);
                buVar.a(eVar.f26461a);
                buVar.c();
            }
            if (eVar.g()) {
                buVar.a(e.f26458h);
                buVar.a(eVar.f26462b);
                buVar.c();
            }
            if (eVar.f26463c != null && eVar.j()) {
                buVar.a(e.f26459i);
                buVar.a(eVar.f26463c);
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

    private static class c extends cf<e> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            caVar.a(bitSet, 3);
            if (eVar.d()) {
                caVar.a(eVar.f26461a);
            }
            if (eVar.g()) {
                caVar.a(eVar.f26462b);
            }
            if (eVar.j()) {
                caVar.a(eVar.f26463c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet b2 = caVar.b(3);
            if (b2.get(0)) {
                eVar.f26461a = caVar.z();
                eVar.a(true);
            }
            if (b2.get(1)) {
                eVar.f26462b = caVar.x();
                eVar.b(true);
            }
            if (b2.get(2)) {
                eVar.f26463c = caVar.z();
                eVar.c(true);
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
        f26460j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0550e.class);
        enumMap.put((EnumMap) EnumC0550e.VALUE, (EnumC0550e) new bh(Downloads.RequestHeaders.COLUMN_VALUE, (byte) 2, new bi((byte) 11)));
        enumMap.put((EnumMap) EnumC0550e.TS, (EnumC0550e) new bh("ts", (byte) 2, new bi((byte) 10)));
        enumMap.put((EnumMap) EnumC0550e.GUID, (EnumC0550e) new bh("guid", (byte) 2, new bi((byte) 11)));
        Map<EnumC0550e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f26454d = unmodifiableMap;
        bh.a(e.class, unmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0550e[]{EnumC0550e.VALUE, EnumC0550e.TS, EnumC0550e.GUID};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f26461a;
    }

    public void c() {
        this.f26461a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f26461a = null;
        b(false);
        this.f26462b = 0L;
        this.f26463c = null;
    }

    public boolean d() {
        return this.f26461a != null;
    }

    public long e() {
        return this.f26462b;
    }

    public void f() {
        this.l = as.b(this.l, 0);
    }

    public boolean g() {
        return as.a(this.l, 0);
    }

    public String h() {
        return this.f26463c;
    }

    public void i() {
        this.f26463c = null;
    }

    public boolean j() {
        return this.f26463c != null;
    }

    public void k() throws bb {
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f26460j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f26461a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f26462b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f26463c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f26460j.get(buVar.D()).b().a(buVar, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    public enum EnumC0550e implements bc {
        VALUE(1, Downloads.RequestHeaders.COLUMN_VALUE),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d */
        private static final Map<String, EnumC0550e> f26467d = new HashMap();

        /* renamed from: e */
        private final short f26469e;

        /* renamed from: f */
        private final String f26470f;

        static {
            Iterator it = EnumSet.allOf(EnumC0550e.class).iterator();
            while (it.hasNext()) {
                EnumC0550e enumC0550e = (EnumC0550e) it.next();
                f26467d.put(enumC0550e.b(), enumC0550e);
            }
        }

        EnumC0550e(short s, String str) {
            this.f26469e = s;
            this.f26470f = str;
        }

        public static EnumC0550e a(int i2) {
            if (i2 == 1) {
                return VALUE;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0550e b(int i2) {
            EnumC0550e a2 = a(i2);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f26470f;
        }

        public static EnumC0550e a(String str) {
            return f26467d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f26469e;
        }
    }

    public e a(String str) {
        this.f26461a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = as.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26463c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26461a = null;
    }

    public e b(String str) {
        this.f26463c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f26462b = j2;
        b(true);
        this.f26463c = str;
    }

    public e a(long j2) {
        this.f26462b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public EnumC0550e fieldForId(int i2) {
        return EnumC0550e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0550e[]{EnumC0550e.VALUE, EnumC0550e.TS, EnumC0550e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f26461a = eVar.f26461a;
        }
        this.f26462b = eVar.f26462b;
        if (eVar.j()) {
            this.f26463c = eVar.f26463c;
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
