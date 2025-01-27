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
public class e implements ch<e, EnumC0680e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC0680e, ct> f24790d;

    /* renamed from: e */
    private static final long f24791e = 7501688097813630241L;

    /* renamed from: f */
    private static final dl f24792f = new dl("ImprintValue");

    /* renamed from: g */
    private static final db f24793g = new db("value", (byte) 11, 1);

    /* renamed from: h */
    private static final db f24794h = new db("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final db f24795i = new db("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends Cdo>, dp> f24796j;

    /* renamed from: k */
    private static final int f24797k = 0;

    /* renamed from: a */
    public String f24798a;

    /* renamed from: b */
    public long f24799b;

    /* renamed from: c */
    public String f24800c;

    /* renamed from: l */
    private byte f24801l;

    /* renamed from: m */
    private EnumC0680e[] f24802m;

    public static class a extends dq<e> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a */
        public void b(dg dgVar, e eVar) throws cn {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f23828b;
                if (b10 == 0) {
                    dgVar.k();
                    eVar.k();
                    return;
                }
                short s10 = l10.f23829c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            eVar.f24800c = dgVar.z();
                            eVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        eVar.f24799b = dgVar.x();
                        eVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    eVar.f24798a = dgVar.z();
                    eVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b */
        public void a(dg dgVar, e eVar) throws cn {
            eVar.k();
            dgVar.a(e.f24792f);
            if (eVar.f24798a != null && eVar.d()) {
                dgVar.a(e.f24793g);
                dgVar.a(eVar.f24798a);
                dgVar.c();
            }
            if (eVar.g()) {
                dgVar.a(e.f24794h);
                dgVar.a(eVar.f24799b);
                dgVar.c();
            }
            if (eVar.f24800c != null && eVar.j()) {
                dgVar.a(e.f24795i);
                dgVar.a(eVar.f24800c);
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

    public static class c extends dr<e> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, e eVar) throws cn {
            dm dmVar = (dm) dgVar;
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
            dmVar.a(bitSet, 3);
            if (eVar.d()) {
                dmVar.a(eVar.f24798a);
            }
            if (eVar.g()) {
                dmVar.a(eVar.f24799b);
            }
            if (eVar.j()) {
                dmVar.a(eVar.f24800c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, e eVar) throws cn {
            dm dmVar = (dm) dgVar;
            BitSet b10 = dmVar.b(3);
            if (b10.get(0)) {
                eVar.f24798a = dmVar.z();
                eVar.a(true);
            }
            if (b10.get(1)) {
                eVar.f24799b = dmVar.x();
                eVar.b(true);
            }
            if (b10.get(2)) {
                eVar.f24800c = dmVar.z();
                eVar.c(true);
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
        f24796j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0680e.class);
        enumMap.put((EnumMap) EnumC0680e.VALUE, (EnumC0680e) new ct("value", (byte) 2, new cu((byte) 11)));
        enumMap.put((EnumMap) EnumC0680e.TS, (EnumC0680e) new ct("ts", (byte) 2, new cu((byte) 10)));
        enumMap.put((EnumMap) EnumC0680e.GUID, (EnumC0680e) new ct("guid", (byte) 2, new cu((byte) 11)));
        Map<EnumC0680e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24790d = unmodifiableMap;
        ct.a(e.class, unmodifiableMap);
    }

    public e() {
        this.f24801l = (byte) 0;
        this.f24802m = new EnumC0680e[]{EnumC0680e.VALUE, EnumC0680e.TS, EnumC0680e.GUID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f24798a;
    }

    public void c() {
        this.f24798a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f24798a = null;
        b(false);
        this.f24799b = 0L;
        this.f24800c = null;
    }

    public boolean d() {
        return this.f24798a != null;
    }

    public long e() {
        return this.f24799b;
    }

    public void f() {
        this.f24801l = ce.b(this.f24801l, 0);
    }

    public boolean g() {
        return ce.a(this.f24801l, 0);
    }

    public String h() {
        return this.f24800c;
    }

    public void i() {
        this.f24800c = null;
    }

    public boolean j() {
        return this.f24800c != null;
    }

    public void k() throws cn {
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        f24796j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ImprintValue(");
        if (d()) {
            sb2.append("value:");
            String str = this.f24798a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            sb2.append(", ");
        }
        sb2.append("ts:");
        sb2.append(this.f24799b);
        sb2.append(", ");
        sb2.append("guid:");
        String str2 = this.f24800c;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        f24796j.get(dgVar.D()).b().a(dgVar, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    public enum EnumC0680e implements co {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d */
        private static final Map<String, EnumC0680e> f24806d = new HashMap();

        /* renamed from: e */
        private final short f24808e;

        /* renamed from: f */
        private final String f24809f;

        static {
            Iterator it = EnumSet.allOf(EnumC0680e.class).iterator();
            while (it.hasNext()) {
                EnumC0680e enumC0680e = (EnumC0680e) it.next();
                f24806d.put(enumC0680e.b(), enumC0680e);
            }
        }

        EnumC0680e(short s10, String str) {
            this.f24808e = s10;
            this.f24809f = str;
        }

        public static EnumC0680e a(int i10) {
            if (i10 == 1) {
                return VALUE;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0680e b(int i10) {
            EnumC0680e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f24809f;
        }

        public static EnumC0680e a(String str) {
            return f24806d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f24808e;
        }
    }

    public e a(String str) {
        this.f24798a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f24801l = ce.a(this.f24801l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24800c = null;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24798a = null;
    }

    public e b(String str) {
        this.f24800c = str;
        return this;
    }

    public e(long j10, String str) {
        this();
        this.f24799b = j10;
        b(true);
        this.f24800c = str;
    }

    public e a(long j10) {
        this.f24799b = j10;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a */
    public EnumC0680e fieldForId(int i10) {
        return EnumC0680e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public e(e eVar) {
        this.f24801l = (byte) 0;
        this.f24802m = new EnumC0680e[]{EnumC0680e.VALUE, EnumC0680e.TS, EnumC0680e.GUID};
        this.f24801l = eVar.f24801l;
        if (eVar.d()) {
            this.f24798a = eVar.f24798a;
        }
        this.f24799b = eVar.f24799b;
        if (eVar.j()) {
            this.f24800c = eVar.f24800c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24801l = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
