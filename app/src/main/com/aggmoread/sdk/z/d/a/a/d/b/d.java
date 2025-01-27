package com.aggmoread.sdk.z.d.a.a.d.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.b;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.aggmoread.sdk.z.d.a.a.e.o;
import com.baidu.mobads.sdk.internal.am;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class d implements com.aggmoread.sdk.z.d.a.a.c.g, Cloneable {
    private static Map<String, WeakReference<Object>> H = Collections.synchronizedMap(new HashMap());
    public int A;
    public o B;
    public o C;
    public o D;
    public o E;
    public o F;
    public o G;

    /* renamed from: b */
    public Object f5856b;

    /* renamed from: c */
    public String f5857c;

    /* renamed from: d */
    public Context f5858d;

    /* renamed from: e */
    public com.aggmoread.sdk.z.d.a.a.c.i f5859e;

    /* renamed from: g */
    public com.aggmoread.sdk.z.d.a.a.c.f f5861g;

    /* renamed from: h */
    public com.aggmoread.sdk.z.d.a.a.c.f f5862h;

    /* renamed from: i */
    public String f5863i;

    /* renamed from: j */
    public ViewGroup f5864j;

    /* renamed from: k */
    public View f5865k;

    /* renamed from: l */
    public boolean f5866l;

    /* renamed from: o */
    public int f5869o;

    /* renamed from: r */
    public com.aggmoread.sdk.z.d.a.a.e.b f5872r;

    /* renamed from: s */
    public com.aggmoread.sdk.z.d.a.a.c.t.b f5873s;

    /* renamed from: t */
    public com.aggmoread.sdk.z.d.a.a.d.a.c f5874t;

    /* renamed from: u */
    public com.aggmoread.sdk.z.d.a.a.a f5875u;

    /* renamed from: z */
    public boolean f5880z;

    /* renamed from: f */
    public String f5860f = "2";

    /* renamed from: m */
    public int f5867m = 1;

    /* renamed from: n */
    public int f5868n = 5000;

    /* renamed from: p */
    public com.aggmoread.sdk.z.d.a.a.c.r.c f5870p = com.aggmoread.sdk.z.d.a.a.c.r.c.f5247f;

    /* renamed from: q */
    public com.aggmoread.sdk.z.d.a.a.c.h f5871q = com.aggmoread.sdk.z.d.a.a.c.h.f5221c;

    /* renamed from: v */
    public int f5876v = -1;

    /* renamed from: w */
    public String f5877w = null;

    /* renamed from: x */
    public String f5878x = null;

    /* renamed from: y */
    public String f5879y = "-1";

    public class a implements b.c {

        /* renamed from: a */
        final /* synthetic */ e f5881a;

        public a(e eVar) {
            this.f5881a = eVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.b.c
        public void a(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
            byte[] b10 = bVar.b();
            int a10 = b10 != null ? com.aggmoread.sdk.z.d.a.a.b.a(b10) : -1;
            int b11 = this.f5881a.f5906b.b(e.c.f5930g);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", String.format("version = %d, server version = %d", Integer.valueOf(a10), Integer.valueOf(b11)));
            if (b11 < 2 || a10 == b11) {
                return;
            }
            d.this.a(b11);
        }
    }

    public class b implements d.c {

        /* renamed from: a */
        final /* synthetic */ int f5883a;

        public b(int i10) {
            this.f5883a = i10;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, i iVar) {
            Object obj;
            if (iVar != null || i10 != 200 || bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                Map<Object, Object> c10 = com.aggmoread.sdk.z.d.a.a.b.c(new String(bArr, "UTF-8"));
                if (c10 != null) {
                    int b10 = new com.aggmoread.sdk.z.d.a.a.e.f(c10).b(c.f5890f);
                    if (b10 == -1000) {
                        com.aggmoread.sdk.z.d.a.a.e.b bVar = d.this.f5872r;
                        if (bVar != null) {
                            bVar.a((byte[]) null);
                            return;
                        }
                        return;
                    }
                    if (b10 != 1 || (obj = c10.get(c.f5891g)) == null) {
                        return;
                    }
                    d.this.b(new com.aggmoread.sdk.z.d.a.a.e.f((Map) obj).c(c.f5892h), this.f5883a);
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final Object f5885a = new Object();

        /* renamed from: b */
        public static final Object f5886b = new Object();

        /* renamed from: c */
        public static final Object f5887c = new Object();

        /* renamed from: d */
        public static final Object f5888d = new Object();

        /* renamed from: e */
        public static final Object f5889e = new Object();

        /* renamed from: f */
        public static final Object f5890f = new Object();

        /* renamed from: g */
        public static final Object f5891g = new Object();

        /* renamed from: h */
        public static final Object f5892h = new Object();
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.d$d */
    public static final class C0183d {

        /* renamed from: a */
        public static final Object f5893a = new Object();

        /* renamed from: b */
        public static final Object f5894b = new Object();

        /* renamed from: c */
        public static final Object f5895c = new Object();

        /* renamed from: d */
        public static final Object f5896d = new Object();

        /* renamed from: e */
        public static final Object f5897e = new Object();

        /* renamed from: f */
        public static final Object f5898f = new Object();

        /* renamed from: g */
        public static final Object f5899g = new Object();

        /* renamed from: h */
        public static final Object f5900h = new Object();

        /* renamed from: i */
        public static final Object f5901i = new Object();

        /* renamed from: j */
        public static final Object f5902j = new Object();

        /* renamed from: k */
        public static final Object f5903k = new Object();

        /* renamed from: l */
        public static final Object f5904l = new Object();
    }

    private static Object a(String str) {
        WeakReference<Object> weakReference = H.get(str);
        Object obj = weakReference != null ? weakReference.get() : null;
        if (obj == null) {
            synchronized (H) {
                try {
                    WeakReference<Object> weakReference2 = H.get(str);
                    if (weakReference2 != null) {
                        obj = weakReference2.get();
                    }
                    if (obj == null) {
                        obj = com.aggmoread.sdk.z.d.a.a.b.b();
                        H.put(str, new WeakReference<>(obj));
                    }
                } finally {
                }
            }
        }
        return obj;
    }

    public static void g() {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{C0183d.f5893a, C0183d.f5894b, C0183d.f5895c, C0183d.f5896d, C0183d.f5897e, C0183d.f5898f, C0183d.f5899g, C0183d.f5900h, C0183d.f5901i, C0183d.f5902j, C0183d.f5903k});
        com.aggmoread.sdk.z.d.a.a.b.c(new Object[]{c.f5885a, c.f5886b, c.f5887c, c.f5888d, c.f5889e});
        com.aggmoread.sdk.z.d.a.a.b.d(new Object[]{new Object[]{c.f5890f, c.f5891g}, new Object[]{c.f5892h}});
    }

    public Object b() {
        try {
            return super.clone();
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("cloneTmp err " + e10);
            return null;
        }
    }

    public Map<Object, Object> c() {
        com.aggmoread.sdk.z.d.a.a.e.f fVar = new com.aggmoread.sdk.z.d.a.a.e.f(com.aggmoread.sdk.z.d.a.a.e.d.b(null));
        fVar.b(C0183d.f5893a, this.f5857c);
        fVar.b(C0183d.f5894b, this.f5863i);
        fVar.b(C0183d.f5896d, this.f5859e.a());
        if (this.f5859e == com.aggmoread.sdk.z.d.a.a.c.i.SPLASH) {
            fVar.b(C0183d.f5904l, com.aggmoread.sdk.z.d.a.a.e.c.D() ? 1 : 0);
        }
        return fVar.f6092a;
    }

    @NonNull
    public Object clone() {
        d dVar = (d) super.clone();
        dVar.f5857c = UUID.randomUUID().toString();
        return dVar;
    }

    public long d() {
        return com.aggmoread.sdk.z.d.a.a.e.h.a().a("LTCl_" + this.f5863i, 0L);
    }

    public int[] e() {
        String str;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "get savedpoint");
        String a10 = com.aggmoread.sdk.z.d.a.a.e.h.a().a("sspp" + this.f5863i, (String) null);
        if (a10 != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "sspp is" + a10);
            String[] split = a10.split("\\|");
            if (split.length > 1) {
                try {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "x = " + split[0] + ",y=" + split[1]);
                    return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                str = "ss.length < 2";
            }
        } else {
            str = "saved point empty";
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", str);
        return null;
    }

    public void f() {
        com.aggmoread.sdk.z.d.a.a.e.h.a().b("LTCl_" + this.f5863i, System.currentTimeMillis());
        l.a(this.f5856b, System.currentTimeMillis());
    }

    public void a() {
        this.f5856b = a(this.f5863i);
        this.B = o.a(this.f5863i, o.c.f6123d);
        this.C = o.a(this.f5863i, o.c.f6124e);
        this.D = o.a(this.f5863i, o.c.f6125f);
        this.E = o.a(this.f5863i, o.c.f6126g);
    }

    public void b(String str, int i10) {
        if (str == null) {
            return;
        }
        try {
            String[] split = str.split("\\#");
            if (split.length < 2) {
                return;
            }
            String[] split2 = split[0].split("\\,");
            if (split2.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split2[0]);
            int parseInt2 = Integer.parseInt(split2[1]);
            int i11 = parseInt * parseInt2;
            int i12 = i11 + 1;
            if (split.length < i12) {
                return;
            }
            int[] iArr = new int[i11 + 3];
            iArr[0] = i10;
            iArr[1] = parseInt;
            iArr[2] = parseInt2;
            for (int i13 = 1; i13 < i12; i13++) {
                String[] split3 = split[i13].split("\\,");
                if (split3.length < 3) {
                    return;
                }
                iArr[i13 + 2] = Integer.parseInt(split3[2]);
            }
            byte[] a10 = com.aggmoread.sdk.z.d.a.a.b.a(iArr);
            if (a10 != null) {
                this.f5872r.a(a10);
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("err " + e10);
        }
    }

    public void a(int i10) {
        Map<Object, Object> a10 = com.aggmoread.sdk.z.d.a.a.e.d.a((Map<Object, Object>) null);
        new com.aggmoread.sdk.z.d.a.a.e.f(a10).b(c.f5888d, this.f5863i);
        try {
            byte[] bytes = com.aggmoread.sdk.z.d.a.a.b.b(a10).getBytes("UTF-8");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-type", am.f6738d);
            com.aggmoread.sdk.z.d.a.a.e.d.a(j.c(), bytes, hashMap, new b(i10));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public void a(e eVar) {
        this.F = o.a(this.f5863i, o.c.f6127h);
        this.G = o.a(this.f5863i, o.c.f6128i);
        com.aggmoread.sdk.z.d.a.a.e.b a10 = com.aggmoread.sdk.z.d.a.a.e.b.a(String.format("%s_%s", this.f5863i, com.aggmoread.sdk.z.d.a.a.e.c.q()));
        this.f5872r = a10;
        if (a10 == null) {
            return;
        }
        a10.a(new a(eVar));
    }

    public void a(i iVar, e eVar) {
        a(iVar, null, eVar, true);
    }

    public void a(i iVar, e eVar, boolean z10) {
        a(iVar, null, eVar, z10);
    }

    public void a(i iVar, Map<Object, Object> map, e eVar, boolean z10) {
        new k(this, eVar).a(8).a(iVar).a(map).b();
        if (z10) {
            this.f5861g.a(iVar);
        }
    }

    public void a(int[] iArr) {
        String str = "sspp" + this.f5863i;
        if (iArr == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "clear saved point");
            com.aggmoread.sdk.z.d.a.a.e.h.a().a(str);
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "set saved pint k=" + str + "  v= " + iArr[0] + "," + iArr[1]);
        com.aggmoread.sdk.z.d.a.a.e.h.a().b(str, String.format("%d|%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])));
    }

    public boolean a(String str, int i10) {
        com.aggmoread.sdk.z.d.a.a.a aVar = this.f5875u;
        if (aVar == null) {
            return false;
        }
        aVar.a(str);
        throw null;
    }
}
