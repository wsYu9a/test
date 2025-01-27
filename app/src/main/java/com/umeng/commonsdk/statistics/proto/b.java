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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public class b implements av<b, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f26403d;

    /* renamed from: e */
    private static final long f26404e = -6496538196005191531L;

    /* renamed from: f */
    private static final bz f26405f = new bz("IdSnapshot");

    /* renamed from: g */
    private static final bp f26406g = new bp(HTTP.IDENTITY_CODING, (byte) 11, 1);

    /* renamed from: h */
    private static final bp f26407h = new bp("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final bp f26408i = new bp("version", (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f26409j;
    private static final int k = 0;
    private static final int l = 1;

    /* renamed from: a */
    public String f26410a;

    /* renamed from: b */
    public long f26411b;

    /* renamed from: c */
    public int f26412c;
    private byte m;

    private static class a extends ce<b> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, b bVar) throws bb {
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
                        } else if (b2 == 8) {
                            bVar.f26412c = buVar.w();
                            bVar.c(true);
                        } else {
                            bx.a(buVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f26411b = buVar.x();
                        bVar.b(true);
                    } else {
                        bx.a(buVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.f26410a = buVar.z();
                    bVar.a(true);
                } else {
                    bx.a(buVar, b2);
                }
                buVar.m();
            }
            buVar.k();
            if (!bVar.g()) {
                throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, b bVar) throws bb {
            bVar.k();
            buVar.a(b.f26405f);
            if (bVar.f26410a != null) {
                buVar.a(b.f26406g);
                buVar.a(bVar.f26410a);
                buVar.c();
            }
            buVar.a(b.f26407h);
            buVar.a(bVar.f26411b);
            buVar.c();
            buVar.a(b.f26408i);
            buVar.a(bVar.f26412c);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    private static class C0547b implements cd {
        private C0547b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public a b() {
            return new a();
        }

        /* synthetic */ C0547b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class c extends cf<b> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(bVar.f26410a);
            caVar.a(bVar.f26411b);
            caVar.a(bVar.f26412c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            bVar.f26410a = caVar.z();
            bVar.a(true);
            bVar.f26411b = caVar.x();
            bVar.b(true);
            bVar.f26412c = caVar.w();
            bVar.c(true);
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
        f26409j = hashMap;
        hashMap.put(ce.class, new C0547b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bh(HTTP.IDENTITY_CODING, (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bh("ts", (byte) 1, new bi((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 8)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f26403d = unmodifiableMap;
        bh.a(b.class, unmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f26410a;
    }

    public void c() {
        this.f26410a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f26410a = null;
        b(false);
        this.f26411b = 0L;
        c(false);
        this.f26412c = 0;
    }

    public boolean d() {
        return this.f26410a != null;
    }

    public long e() {
        return this.f26411b;
    }

    public void f() {
        this.m = as.b(this.m, 0);
    }

    public boolean g() {
        return as.a(this.m, 0);
    }

    public int h() {
        return this.f26412c;
    }

    public void i() {
        this.m = as.b(this.m, 1);
    }

    public boolean j() {
        return as.a(this.m, 1);
    }

    public void k() throws bb {
        if (this.f26410a != null) {
            return;
        }
        throw new bv("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f26409j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f26410a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f26411b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f26412c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f26409j.get(buVar.D()).b().a(buVar, this);
    }

    public enum e implements bc {
        IDENTITY(1, HTTP.IDENTITY_CODING),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d */
        private static final Map<String, e> f26416d = new HashMap();

        /* renamed from: e */
        private final short f26418e;

        /* renamed from: f */
        private final String f26419f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26416d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26418e = s;
            this.f26419f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return IDENTITY;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return VERSION;
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
            return this.f26419f;
        }

        public static e a(String str) {
            return f26416d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f26418e;
        }
    }

    public b a(String str) {
        this.f26410a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = as.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = as.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.f26410a = str;
        this.f26411b = j2;
        b(true);
        this.f26412c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26410a = null;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f26411b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f26412c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f26410a = bVar.f26410a;
        }
        this.f26411b = bVar.f26411b;
        this.f26412c = bVar.f26412c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
