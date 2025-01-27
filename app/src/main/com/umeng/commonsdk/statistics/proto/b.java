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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements ch<b, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, ct> f24733d;

    /* renamed from: e */
    private static final long f24734e = -6496538196005191531L;

    /* renamed from: f */
    private static final dl f24735f = new dl("IdSnapshot");

    /* renamed from: g */
    private static final db f24736g = new db("identity", (byte) 11, 1);

    /* renamed from: h */
    private static final db f24737h = new db("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final db f24738i = new db("version", (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends Cdo>, dp> f24739j;

    /* renamed from: k */
    private static final int f24740k = 0;

    /* renamed from: l */
    private static final int f24741l = 1;

    /* renamed from: a */
    public String f24742a;

    /* renamed from: b */
    public long f24743b;

    /* renamed from: c */
    public int f24744c;

    /* renamed from: m */
    private byte f24745m;

    public static class a extends dq<b> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, b bVar) throws cn {
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
                        } else if (b10 == 8) {
                            bVar.f24744c = dgVar.w();
                            bVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        bVar.f24743b = dgVar.x();
                        bVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    bVar.f24742a = dgVar.z();
                    bVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (!bVar.g()) {
                throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, b bVar) throws cn {
            bVar.k();
            dgVar.a(b.f24735f);
            if (bVar.f24742a != null) {
                dgVar.a(b.f24736g);
                dgVar.a(bVar.f24742a);
                dgVar.c();
            }
            dgVar.a(b.f24737h);
            dgVar.a(bVar.f24743b);
            dgVar.c();
            dgVar.a(b.f24738i);
            dgVar.a(bVar.f24744c);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    public static class C0677b implements dp {
        private C0677b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a */
        public a b() {
            return new a();
        }

        public /* synthetic */ C0677b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class c extends dr<b> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, b bVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(bVar.f24742a);
            dmVar.a(bVar.f24743b);
            dmVar.a(bVar.f24744c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, b bVar) throws cn {
            dm dmVar = (dm) dgVar;
            bVar.f24742a = dmVar.z();
            bVar.a(true);
            bVar.f24743b = dmVar.x();
            bVar.b(true);
            bVar.f24744c = dmVar.w();
            bVar.c(true);
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
        f24739j = hashMap;
        hashMap.put(dq.class, new C0677b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new ct("identity", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new ct("ts", (byte) 1, new cu((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24733d = unmodifiableMap;
        ct.a(b.class, unmodifiableMap);
    }

    public b() {
        this.f24745m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f24742a;
    }

    public void c() {
        this.f24742a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f24742a = null;
        b(false);
        this.f24743b = 0L;
        c(false);
        this.f24744c = 0;
    }

    public boolean d() {
        return this.f24742a != null;
    }

    public long e() {
        return this.f24743b;
    }

    public void f() {
        this.f24745m = ce.b(this.f24745m, 0);
    }

    public boolean g() {
        return ce.a(this.f24745m, 0);
    }

    public int h() {
        return this.f24744c;
    }

    public void i() {
        this.f24745m = ce.b(this.f24745m, 1);
    }

    public boolean j() {
        return ce.a(this.f24745m, 1);
    }

    public void k() throws cn {
        if (this.f24742a != null) {
            return;
        }
        throw new dh("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f24739j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdSnapshot(");
        sb2.append("identity:");
        String str = this.f24742a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("ts:");
        sb2.append(this.f24743b);
        sb2.append(", ");
        sb2.append("version:");
        sb2.append(this.f24744c);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f24739j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d */
        private static final Map<String, e> f24749d = new HashMap();

        /* renamed from: e */
        private final short f24751e;

        /* renamed from: f */
        private final String f24752f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f24749d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24751e = s10;
            this.f24752f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return IDENTITY;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return VERSION;
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
            return this.f24752f;
        }

        public static e a(String str) {
            return f24749d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f24751e;
        }
    }

    public b a(String str) {
        this.f24742a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f24745m = ce.a(this.f24745m, 0, z10);
    }

    public void c(boolean z10) {
        this.f24745m = ce.a(this.f24745m, 1, z10);
    }

    public b(String str, long j10, int i10) {
        this();
        this.f24742a = str;
        this.f24743b = j10;
        b(true);
        this.f24744c = i10;
        c(true);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24742a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: b */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public b a(long j10) {
        this.f24743b = j10;
        b(true);
        return this;
    }

    public b a(int i10) {
        this.f24744c = i10;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public b(b bVar) {
        this.f24745m = (byte) 0;
        this.f24745m = bVar.f24745m;
        if (bVar.d()) {
            this.f24742a = bVar.f24742a;
        }
        this.f24743b = bVar.f24743b;
        this.f24744c = bVar.f24744c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24745m = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
