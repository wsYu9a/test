package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class bu implements ch<bu, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k */
    public static final Map<e, ct> f23631k;

    /* renamed from: l */
    private static final long f23632l = 420342210744516016L;

    /* renamed from: m */
    private static final dl f23633m = new dl("UMEnvelope");

    /* renamed from: n */
    private static final db f23634n = new db("version", (byte) 11, 1);

    /* renamed from: o */
    private static final db f23635o = new db("address", (byte) 11, 2);

    /* renamed from: p */
    private static final db f23636p = new db(com.umeng.ccg.a.f24247x, (byte) 11, 3);

    /* renamed from: q */
    private static final db f23637q = new db("serial_num", (byte) 8, 4);

    /* renamed from: r */
    private static final db f23638r = new db("ts_secs", (byte) 8, 5);

    /* renamed from: s */
    private static final db f23639s = new db(com.sigmob.sdk.videocache.sourcestorage.a.f20681d, (byte) 8, 6);

    /* renamed from: t */
    private static final db f23640t = new db("entity", (byte) 11, 7);

    /* renamed from: u */
    private static final db f23641u = new db("guid", (byte) 11, 8);

    /* renamed from: v */
    private static final db f23642v = new db("checksum", (byte) 11, 9);

    /* renamed from: w */
    private static final db f23643w = new db("codex", (byte) 8, 10);

    /* renamed from: x */
    private static final Map<Class<? extends Cdo>, dp> f23644x;

    /* renamed from: y */
    private static final int f23645y = 0;

    /* renamed from: z */
    private static final int f23646z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a */
    public String f23647a;

    /* renamed from: b */
    public String f23648b;

    /* renamed from: c */
    public String f23649c;

    /* renamed from: d */
    public int f23650d;

    /* renamed from: e */
    public int f23651e;

    /* renamed from: f */
    public int f23652f;

    /* renamed from: g */
    public ByteBuffer f23653g;

    /* renamed from: h */
    public String f23654h;

    /* renamed from: i */
    public String f23655i;

    /* renamed from: j */
    public int f23656j;

    public static class a extends dq<bu> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, bu buVar) throws cn {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f23828b;
                if (b10 == 0) {
                    dgVar.k();
                    if (!buVar.m()) {
                        throw new dh("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!buVar.p()) {
                        throw new dh("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (buVar.s()) {
                        buVar.G();
                        return;
                    }
                    throw new dh("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (l10.f23829c) {
                    case 1:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23647a = dgVar.z();
                            buVar.a(true);
                            break;
                        }
                    case 2:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23648b = dgVar.z();
                            buVar.b(true);
                            break;
                        }
                    case 3:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23649c = dgVar.z();
                            buVar.c(true);
                            break;
                        }
                    case 4:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23650d = dgVar.w();
                            buVar.d(true);
                            break;
                        }
                    case 5:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23651e = dgVar.w();
                            buVar.e(true);
                            break;
                        }
                    case 6:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23652f = dgVar.w();
                            buVar.f(true);
                            break;
                        }
                    case 7:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23653g = dgVar.A();
                            buVar.g(true);
                            break;
                        }
                    case 8:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23654h = dgVar.z();
                            buVar.h(true);
                            break;
                        }
                    case 9:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23655i = dgVar.z();
                            buVar.i(true);
                            break;
                        }
                    case 10:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f23656j = dgVar.w();
                            buVar.j(true);
                            break;
                        }
                    default:
                        dj.a(dgVar, b10);
                        break;
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, bu buVar) throws cn {
            buVar.G();
            dgVar.a(bu.f23633m);
            if (buVar.f23647a != null) {
                dgVar.a(bu.f23634n);
                dgVar.a(buVar.f23647a);
                dgVar.c();
            }
            if (buVar.f23648b != null) {
                dgVar.a(bu.f23635o);
                dgVar.a(buVar.f23648b);
                dgVar.c();
            }
            if (buVar.f23649c != null) {
                dgVar.a(bu.f23636p);
                dgVar.a(buVar.f23649c);
                dgVar.c();
            }
            dgVar.a(bu.f23637q);
            dgVar.a(buVar.f23650d);
            dgVar.c();
            dgVar.a(bu.f23638r);
            dgVar.a(buVar.f23651e);
            dgVar.c();
            dgVar.a(bu.f23639s);
            dgVar.a(buVar.f23652f);
            dgVar.c();
            if (buVar.f23653g != null) {
                dgVar.a(bu.f23640t);
                dgVar.a(buVar.f23653g);
                dgVar.c();
            }
            if (buVar.f23654h != null) {
                dgVar.a(bu.f23641u);
                dgVar.a(buVar.f23654h);
                dgVar.c();
            }
            if (buVar.f23655i != null) {
                dgVar.a(bu.f23642v);
                dgVar.a(buVar.f23655i);
                dgVar.c();
            }
            if (buVar.F()) {
                dgVar.a(bu.f23643w);
                dgVar.a(buVar.f23656j);
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

    public static class c extends dr<bu> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, bu buVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(buVar.f23647a);
            dmVar.a(buVar.f23648b);
            dmVar.a(buVar.f23649c);
            dmVar.a(buVar.f23650d);
            dmVar.a(buVar.f23651e);
            dmVar.a(buVar.f23652f);
            dmVar.a(buVar.f23653g);
            dmVar.a(buVar.f23654h);
            dmVar.a(buVar.f23655i);
            BitSet bitSet = new BitSet();
            if (buVar.F()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (buVar.F()) {
                dmVar.a(buVar.f23656j);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, bu buVar) throws cn {
            dm dmVar = (dm) dgVar;
            buVar.f23647a = dmVar.z();
            buVar.a(true);
            buVar.f23648b = dmVar.z();
            buVar.b(true);
            buVar.f23649c = dmVar.z();
            buVar.c(true);
            buVar.f23650d = dmVar.w();
            buVar.d(true);
            buVar.f23651e = dmVar.w();
            buVar.e(true);
            buVar.f23652f = dmVar.w();
            buVar.f(true);
            buVar.f23653g = dmVar.A();
            buVar.g(true);
            buVar.f23654h = dmVar.z();
            buVar.h(true);
            buVar.f23655i = dmVar.z();
            buVar.i(true);
            if (dmVar.b(1).get(0)) {
                buVar.f23656j = dmVar.w();
                buVar.j(true);
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
        f23644x = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new ct("address", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new ct(com.umeng.ccg.a.f24247x, (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new ct("serial_num", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new ct("ts_secs", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new ct(com.sigmob.sdk.videocache.sourcestorage.a.f20681d, (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new ct("entity", (byte) 1, new cu((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new ct("guid", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new ct("codex", (byte) 2, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f23631k = unmodifiableMap;
        ct.a(bu.class, unmodifiableMap);
    }

    public bu() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f23655i;
    }

    public void B() {
        this.f23655i = null;
    }

    public boolean C() {
        return this.f23655i != null;
    }

    public int D() {
        return this.f23656j;
    }

    public void E() {
        this.C = ce.b(this.C, 3);
    }

    public boolean F() {
        return ce.a(this.C, 3);
    }

    public void G() throws cn {
        if (this.f23647a == null) {
            throw new dh("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f23648b == null) {
            throw new dh("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f23649c == null) {
            throw new dh("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f23653g == null) {
            throw new dh("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f23654h == null) {
            throw new dh("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f23655i != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public bu deepCopy() {
        return new bu(this);
    }

    public String b() {
        return this.f23647a;
    }

    public void c() {
        this.f23647a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f23647a = null;
        this.f23648b = null;
        this.f23649c = null;
        d(false);
        this.f23650d = 0;
        e(false);
        this.f23651e = 0;
        f(false);
        this.f23652f = 0;
        this.f23653g = null;
        this.f23654h = null;
        this.f23655i = null;
        j(false);
        this.f23656j = 0;
    }

    public boolean d() {
        return this.f23647a != null;
    }

    public String e() {
        return this.f23648b;
    }

    public void f() {
        this.f23648b = null;
    }

    public boolean g() {
        return this.f23648b != null;
    }

    public String h() {
        return this.f23649c;
    }

    public void i() {
        this.f23649c = null;
    }

    public boolean j() {
        return this.f23649c != null;
    }

    public int k() {
        return this.f23650d;
    }

    public void l() {
        this.C = ce.b(this.C, 0);
    }

    public boolean m() {
        return ce.a(this.C, 0);
    }

    public int n() {
        return this.f23651e;
    }

    public void o() {
        this.C = ce.b(this.C, 1);
    }

    public boolean p() {
        return ce.a(this.C, 1);
    }

    public int q() {
        return this.f23652f;
    }

    public void r() {
        this.C = ce.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f23644x.get(dgVar.D()).b().b(dgVar, this);
    }

    public boolean s() {
        return ce.a(this.C, 2);
    }

    public byte[] t() {
        a(ci.c(this.f23653g));
        ByteBuffer byteBuffer = this.f23653g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("UMEnvelope(");
        sb2.append("version:");
        String str = this.f23647a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("address:");
        String str2 = this.f23648b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("signature:");
        String str3 = this.f23649c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("serial_num:");
        sb2.append(this.f23650d);
        sb2.append(", ");
        sb2.append("ts_secs:");
        sb2.append(this.f23651e);
        sb2.append(", ");
        sb2.append("length:");
        sb2.append(this.f23652f);
        sb2.append(", ");
        sb2.append("entity:");
        ByteBuffer byteBuffer = this.f23653g;
        if (byteBuffer == null) {
            sb2.append("null");
        } else {
            ci.a(byteBuffer, sb2);
        }
        sb2.append(", ");
        sb2.append("guid:");
        String str4 = this.f23654h;
        if (str4 == null) {
            sb2.append("null");
        } else {
            sb2.append(str4);
        }
        sb2.append(", ");
        sb2.append("checksum:");
        String str5 = this.f23655i;
        if (str5 == null) {
            sb2.append("null");
        } else {
            sb2.append(str5);
        }
        if (F()) {
            sb2.append(", ");
            sb2.append("codex:");
            sb2.append(this.f23656j);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public ByteBuffer u() {
        return this.f23653g;
    }

    public void v() {
        this.f23653g = null;
    }

    public boolean w() {
        return this.f23653g != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f23644x.get(dgVar.D()).b().a(dgVar, this);
    }

    public String x() {
        return this.f23654h;
    }

    public void y() {
        this.f23654h = null;
    }

    public boolean z() {
        return this.f23654h != null;
    }

    public enum e implements co {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, com.umeng.ccg.a.f24247x),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, com.sigmob.sdk.videocache.sourcestorage.a.f20681d),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* renamed from: k */
        private static final Map<String, e> f23667k = new HashMap();

        /* renamed from: l */
        private final short f23669l;

        /* renamed from: m */
        private final String f23670m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f23667k.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f23669l = s10;
            this.f23670m = str;
        }

        public static e a(int i10) {
            switch (i10) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f23670m;
        }

        public static e a(String str) {
            return f23667k.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f23669l;
        }
    }

    public bu a(String str) {
        this.f23647a = str;
        return this;
    }

    public bu b(String str) {
        this.f23648b = str;
        return this;
    }

    public bu c(String str) {
        this.f23649c = str;
        return this;
    }

    public void d(boolean z10) {
        this.C = ce.a(this.C, 0, z10);
    }

    public void e(boolean z10) {
        this.C = ce.a(this.C, 1, z10);
    }

    public void f(boolean z10) {
        this.C = ce.a(this.C, 2, z10);
    }

    public void g(boolean z10) {
        if (z10) {
            return;
        }
        this.f23653g = null;
    }

    public void h(boolean z10) {
        if (z10) {
            return;
        }
        this.f23654h = null;
    }

    public void i(boolean z10) {
        if (z10) {
            return;
        }
        this.f23655i = null;
    }

    public void j(boolean z10) {
        this.C = ce.a(this.C, 3, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f23647a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f23648b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f23649c = null;
    }

    public bu d(String str) {
        this.f23654h = str;
        return this;
    }

    public bu e(String str) {
        this.f23655i = str;
        return this;
    }

    public bu(String str, String str2, String str3, int i10, int i11, int i12, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f23647a = str;
        this.f23648b = str2;
        this.f23649c = str3;
        this.f23650d = i10;
        d(true);
        this.f23651e = i11;
        e(true);
        this.f23652f = i12;
        f(true);
        this.f23653g = byteBuffer;
        this.f23654h = str4;
        this.f23655i = str5;
    }

    public bu a(int i10) {
        this.f23650d = i10;
        d(true);
        return this;
    }

    public bu b(int i10) {
        this.f23651e = i10;
        e(true);
        return this;
    }

    public bu c(int i10) {
        this.f23652f = i10;
        f(true);
        return this;
    }

    public bu d(int i10) {
        this.f23656j = i10;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: e */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public bu a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bu a(ByteBuffer byteBuffer) {
        this.f23653g = byteBuffer;
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
            this.C = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public bu(bu buVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = buVar.C;
        if (buVar.d()) {
            this.f23647a = buVar.f23647a;
        }
        if (buVar.g()) {
            this.f23648b = buVar.f23648b;
        }
        if (buVar.j()) {
            this.f23649c = buVar.f23649c;
        }
        this.f23650d = buVar.f23650d;
        this.f23651e = buVar.f23651e;
        this.f23652f = buVar.f23652f;
        if (buVar.w()) {
            this.f23653g = ci.d(buVar.f23653g);
        }
        if (buVar.z()) {
            this.f23654h = buVar.f23654h;
        }
        if (buVar.C()) {
            this.f23655i = buVar.f23655i;
        }
        this.f23656j = buVar.f23656j;
    }
}
