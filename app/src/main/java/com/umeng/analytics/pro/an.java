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
public class an implements av<an, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bh> k;
    private static final long l = 420342210744516016L;
    private static final bz m = new bz("UMEnvelope");
    private static final bp n = new bp("version", (byte) 11, 1);
    private static final bp o = new bp("address", (byte) 11, 2);
    private static final bp p = new bp("signature", (byte) 11, 3);
    private static final bp q = new bp("serial_num", (byte) 8, 4);
    private static final bp r = new bp("ts_secs", (byte) 8, 5);
    private static final bp s = new bp("length", (byte) 8, 6);
    private static final bp t = new bp("entity", (byte) 11, 7);
    private static final bp u = new bp("guid", (byte) 11, 8);
    private static final bp v = new bp("checksum", (byte) 11, 9);
    private static final bp w = new bp("codex", (byte) 8, 10);
    private static final Map<Class<? extends cc>, cd> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a */
    public String f25661a;

    /* renamed from: b */
    public String f25662b;

    /* renamed from: c */
    public String f25663c;

    /* renamed from: d */
    public int f25664d;

    /* renamed from: e */
    public int f25665e;

    /* renamed from: f */
    public int f25666f;

    /* renamed from: g */
    public ByteBuffer f25667g;

    /* renamed from: h */
    public String f25668h;

    /* renamed from: i */
    public String f25669i;

    /* renamed from: j */
    public int f25670j;

    private static class a extends ce<an> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, an anVar) throws bb {
            buVar.j();
            while (true) {
                bp l = buVar.l();
                byte b2 = l.f25780b;
                if (b2 == 0) {
                    buVar.k();
                    if (!anVar.m()) {
                        throw new bv("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!anVar.p()) {
                        throw new bv("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (anVar.s()) {
                        anVar.G();
                        return;
                    }
                    throw new bv("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f25781c) {
                    case 1:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25661a = buVar.z();
                            anVar.a(true);
                            break;
                        }
                    case 2:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25662b = buVar.z();
                            anVar.b(true);
                            break;
                        }
                    case 3:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25663c = buVar.z();
                            anVar.c(true);
                            break;
                        }
                    case 4:
                        if (b2 != 8) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25664d = buVar.w();
                            anVar.d(true);
                            break;
                        }
                    case 5:
                        if (b2 != 8) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25665e = buVar.w();
                            anVar.e(true);
                            break;
                        }
                    case 6:
                        if (b2 != 8) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25666f = buVar.w();
                            anVar.f(true);
                            break;
                        }
                    case 7:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25667g = buVar.A();
                            anVar.g(true);
                            break;
                        }
                    case 8:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25668h = buVar.z();
                            anVar.h(true);
                            break;
                        }
                    case 9:
                        if (b2 != 11) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25669i = buVar.z();
                            anVar.i(true);
                            break;
                        }
                    case 10:
                        if (b2 != 8) {
                            bx.a(buVar, b2);
                            break;
                        } else {
                            anVar.f25670j = buVar.w();
                            anVar.j(true);
                            break;
                        }
                    default:
                        bx.a(buVar, b2);
                        break;
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, an anVar) throws bb {
            anVar.G();
            buVar.a(an.m);
            if (anVar.f25661a != null) {
                buVar.a(an.n);
                buVar.a(anVar.f25661a);
                buVar.c();
            }
            if (anVar.f25662b != null) {
                buVar.a(an.o);
                buVar.a(anVar.f25662b);
                buVar.c();
            }
            if (anVar.f25663c != null) {
                buVar.a(an.p);
                buVar.a(anVar.f25663c);
                buVar.c();
            }
            buVar.a(an.q);
            buVar.a(anVar.f25664d);
            buVar.c();
            buVar.a(an.r);
            buVar.a(anVar.f25665e);
            buVar.c();
            buVar.a(an.s);
            buVar.a(anVar.f25666f);
            buVar.c();
            if (anVar.f25667g != null) {
                buVar.a(an.t);
                buVar.a(anVar.f25667g);
                buVar.c();
            }
            if (anVar.f25668h != null) {
                buVar.a(an.u);
                buVar.a(anVar.f25668h);
                buVar.c();
            }
            if (anVar.f25669i != null) {
                buVar.a(an.v);
                buVar.a(anVar.f25669i);
                buVar.c();
            }
            if (anVar.F()) {
                buVar.a(an.w);
                buVar.a(anVar.f25670j);
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

    private static class c extends cf<an> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(anVar.f25661a);
            caVar.a(anVar.f25662b);
            caVar.a(anVar.f25663c);
            caVar.a(anVar.f25664d);
            caVar.a(anVar.f25665e);
            caVar.a(anVar.f25666f);
            caVar.a(anVar.f25667g);
            caVar.a(anVar.f25668h);
            caVar.a(anVar.f25669i);
            BitSet bitSet = new BitSet();
            if (anVar.F()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (anVar.F()) {
                caVar.a(anVar.f25670j);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            anVar.f25661a = caVar.z();
            anVar.a(true);
            anVar.f25662b = caVar.z();
            anVar.b(true);
            anVar.f25663c = caVar.z();
            anVar.c(true);
            anVar.f25664d = caVar.w();
            anVar.d(true);
            anVar.f25665e = caVar.w();
            anVar.e(true);
            anVar.f25666f = caVar.w();
            anVar.f(true);
            anVar.f25667g = caVar.A();
            anVar.g(true);
            anVar.f25668h = caVar.z();
            anVar.h(true);
            anVar.f25669i = caVar.z();
            anVar.i(true);
            if (caVar.b(1).get(0)) {
                anVar.f25670j = caVar.w();
                anVar.j(true);
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
        x = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new bh("address", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new bh("signature", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new bh("serial_num", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new bh("ts_secs", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new bh("length", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new bh("entity", (byte) 1, new bi((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new bh("guid", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new bh("codex", (byte) 2, new bi((byte) 8)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = unmodifiableMap;
        bh.a(an.class, unmodifiableMap);
    }

    public an() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f25669i;
    }

    public void B() {
        this.f25669i = null;
    }

    public boolean C() {
        return this.f25669i != null;
    }

    public int D() {
        return this.f25670j;
    }

    public void E() {
        this.C = as.b(this.C, 3);
    }

    public boolean F() {
        return as.a(this.C, 3);
    }

    public void G() throws bb {
        if (this.f25661a == null) {
            throw new bv("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f25662b == null) {
            throw new bv("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f25663c == null) {
            throw new bv("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f25667g == null) {
            throw new bv("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f25668h == null) {
            throw new bv("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f25669i != null) {
            return;
        }
        throw new bv("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public an deepCopy() {
        return new an(this);
    }

    public String b() {
        return this.f25661a;
    }

    public void c() {
        this.f25661a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f25661a = null;
        this.f25662b = null;
        this.f25663c = null;
        d(false);
        this.f25664d = 0;
        e(false);
        this.f25665e = 0;
        f(false);
        this.f25666f = 0;
        this.f25667g = null;
        this.f25668h = null;
        this.f25669i = null;
        j(false);
        this.f25670j = 0;
    }

    public boolean d() {
        return this.f25661a != null;
    }

    public String e() {
        return this.f25662b;
    }

    public void f() {
        this.f25662b = null;
    }

    public boolean g() {
        return this.f25662b != null;
    }

    public String h() {
        return this.f25663c;
    }

    public void i() {
        this.f25663c = null;
    }

    public boolean j() {
        return this.f25663c != null;
    }

    public int k() {
        return this.f25664d;
    }

    public void l() {
        this.C = as.b(this.C, 0);
    }

    public boolean m() {
        return as.a(this.C, 0);
    }

    public int n() {
        return this.f25665e;
    }

    public void o() {
        this.C = as.b(this.C, 1);
    }

    public boolean p() {
        return as.a(this.C, 1);
    }

    public int q() {
        return this.f25666f;
    }

    public void r() {
        this.C = as.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        x.get(buVar.D()).b().b(buVar, this);
    }

    public boolean s() {
        return as.a(this.C, 2);
    }

    public byte[] t() {
        a(aw.c(this.f25667g));
        ByteBuffer byteBuffer = this.f25667g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f25661a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f25662b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f25663c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f25664d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f25665e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f25666f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f25667g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            aw.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f25668h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f25669i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f25670j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f25667g;
    }

    public void v() {
        this.f25667g = null;
    }

    public boolean w() {
        return this.f25667g != null;
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        x.get(buVar.D()).b().a(buVar, this);
    }

    public String x() {
        return this.f25668h;
    }

    public void y() {
        this.f25668h = null;
    }

    public boolean z() {
        return this.f25668h != null;
    }

    public enum e implements bc {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i2) {
            switch (i2) {
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

        public static e b(int i2) {
            e a2 = a(i2);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.m;
        }

        public static e a(String str) {
            return k.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.l;
        }
    }

    public an a(String str) {
        this.f25661a = str;
        return this;
    }

    public an b(String str) {
        this.f25662b = str;
        return this;
    }

    public an c(String str) {
        this.f25663c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = as.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = as.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = as.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f25667g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f25668h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f25669i = null;
    }

    public void j(boolean z2) {
        this.C = as.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f25661a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f25662b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f25663c = null;
    }

    public an d(String str) {
        this.f25668h = str;
        return this;
    }

    public an e(String str) {
        this.f25669i = str;
        return this;
    }

    public an(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f25661a = str;
        this.f25662b = str2;
        this.f25663c = str3;
        this.f25664d = i2;
        d(true);
        this.f25665e = i3;
        e(true);
        this.f25666f = i4;
        f(true);
        this.f25667g = byteBuffer;
        this.f25668h = str4;
        this.f25669i = str5;
    }

    public an a(int i2) {
        this.f25664d = i2;
        d(true);
        return this;
    }

    public an b(int i2) {
        this.f25665e = i2;
        e(true);
        return this;
    }

    public an c(int i2) {
        this.f25666f = i2;
        f(true);
        return this;
    }

    public an d(int i2) {
        this.f25670j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: e */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public an a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public an a(ByteBuffer byteBuffer) {
        this.f25667g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public an(an anVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = anVar.C;
        if (anVar.d()) {
            this.f25661a = anVar.f25661a;
        }
        if (anVar.g()) {
            this.f25662b = anVar.f25662b;
        }
        if (anVar.j()) {
            this.f25663c = anVar.f25663c;
        }
        this.f25664d = anVar.f25664d;
        this.f25665e = anVar.f25665e;
        this.f25666f = anVar.f25666f;
        if (anVar.w()) {
            this.f25667g = aw.d(anVar.f25667g);
        }
        if (anVar.z()) {
            this.f25668h = anVar.f25668h;
        }
        if (anVar.C()) {
            this.f25669i = anVar.f25669i;
        }
        this.f25670j = anVar.f25670j;
    }
}
