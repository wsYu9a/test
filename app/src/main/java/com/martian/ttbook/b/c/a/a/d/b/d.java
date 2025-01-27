package com.martian.ttbook.b.c.a.a.d.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.am;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.a;
import com.martian.ttbook.b.c.a.a.e.c;
import com.martian.ttbook.b.c.a.a.e.k;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class d implements com.martian.ttbook.b.c.a.a.c.f, Cloneable {

    /* renamed from: a */
    private static Map<String, WeakReference<Object>> f15667a = Collections.synchronizedMap(new HashMap());
    public com.martian.ttbook.b.c.a.a.e.k A;
    public com.martian.ttbook.b.c.a.a.e.k B;

    /* renamed from: b */
    public Object f15668b;

    /* renamed from: c */
    public String f15669c;

    /* renamed from: d */
    public Context f15670d;

    /* renamed from: e */
    public com.martian.ttbook.b.c.a.a.c.h f15671e;

    /* renamed from: g */
    public com.martian.ttbook.b.c.a.a.c.e f15673g;

    /* renamed from: h */
    public com.martian.ttbook.b.c.a.a.c.e f15674h;

    /* renamed from: i */
    public String f15675i;

    /* renamed from: j */
    public ViewGroup f15676j;
    public View k;
    public boolean l;
    public int o;
    public com.martian.ttbook.b.c.a.a.e.a r;
    public com.martian.ttbook.b.c.a.a.c.q.b s;
    public com.martian.ttbook.b.c.a.a.b.a.c t;
    public com.martian.ttbook.b.c.a.a.a u;
    public com.martian.ttbook.b.c.a.a.e.k w;
    public com.martian.ttbook.b.c.a.a.e.k x;
    public com.martian.ttbook.b.c.a.a.e.k y;
    public com.martian.ttbook.b.c.a.a.e.k z;

    /* renamed from: f */
    public String f15672f = "2";
    public int m = 1;
    public int n = 5000;
    public com.martian.ttbook.b.c.a.a.c.o.c p = com.martian.ttbook.b.c.a.a.c.o.c.f15568a;
    public com.martian.ttbook.b.c.a.a.c.g q = com.martian.ttbook.b.c.a.a.c.g.f15556a;
    public int v = -1;

    class a implements a.c {

        /* renamed from: a */
        final /* synthetic */ e f15677a;

        a(e eVar) {
            this.f15677a = eVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.a.c
        public void a(com.martian.ttbook.b.c.a.a.e.a aVar) {
            byte[] h2 = aVar.h();
            int a2 = h2 != null ? com.martian.ttbook.b.c.a.a.b.a(h2) : -1;
            int g2 = this.f15677a.f15700b.g(e.c.f15717g);
            com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", String.format("version = %d, server version = %d", Integer.valueOf(a2), Integer.valueOf(g2)));
            if (a2 != g2) {
                d.this.c(g2);
            }
        }
    }

    class b implements c.InterfaceC0361c {

        /* renamed from: a */
        final /* synthetic */ int f15679a;

        b(int i2) {
            this.f15679a = i2;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, i iVar) {
            Object obj;
            if (iVar != null || i2 != 200 || bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                Map<Object, Object> p = com.martian.ttbook.b.c.a.a.b.p(new String(bArr, "UTF-8"));
                if (p != null) {
                    int g2 = new com.martian.ttbook.b.c.a.a.e.e(p).g(c.f15686f);
                    if (g2 == -1000) {
                        com.martian.ttbook.b.c.a.a.e.a aVar = d.this.r;
                        if (aVar != null) {
                            aVar.f(null);
                            return;
                        }
                        return;
                    }
                    if (g2 != 1 || (obj = p.get(c.f15687g)) == null) {
                        return;
                    }
                    d.this.k(new com.martian.ttbook.b.c.a.a.e.e((Map) obj).l(c.f15688h), this.f15679a);
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final Object f15681a = new Object();

        /* renamed from: b */
        public static final Object f15682b = new Object();

        /* renamed from: c */
        public static final Object f15683c = new Object();

        /* renamed from: d */
        public static final Object f15684d = new Object();

        /* renamed from: e */
        public static final Object f15685e = new Object();

        /* renamed from: f */
        public static final Object f15686f = new Object();

        /* renamed from: g */
        public static final Object f15687g = new Object();

        /* renamed from: h */
        public static final Object f15688h = new Object();
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.d.b.d$d */
    public static final class C0356d {

        /* renamed from: a */
        public static final Object f15689a = new Object();

        /* renamed from: b */
        public static final Object f15690b = new Object();

        /* renamed from: c */
        public static final Object f15691c = new Object();

        /* renamed from: d */
        public static final Object f15692d = new Object();

        /* renamed from: e */
        public static final Object f15693e = new Object();

        /* renamed from: f */
        public static final Object f15694f = new Object();

        /* renamed from: g */
        public static final Object f15695g = new Object();

        /* renamed from: h */
        public static final Object f15696h = new Object();

        /* renamed from: i */
        public static final Object f15697i = new Object();

        /* renamed from: j */
        public static final Object f15698j = new Object();
        public static final Object k = new Object();
        public static final Object l = new Object();
    }

    private static Object a(String str) {
        WeakReference<Object> weakReference = f15667a.get(str);
        Object obj = weakReference != null ? weakReference.get() : null;
        if (obj == null) {
            synchronized (f15667a) {
                WeakReference<Object> weakReference2 = f15667a.get(str);
                if (weakReference2 != null) {
                    obj = weakReference2.get();
                }
                if (obj == null) {
                    obj = com.martian.ttbook.b.c.a.a.b.n();
                    f15667a.put(str, new WeakReference<>(obj));
                }
            }
        }
        return obj;
    }

    public static void o() {
        com.martian.ttbook.b.c.a.a.b.f(new Object[]{C0356d.f15689a, C0356d.f15690b, C0356d.f15691c, C0356d.f15692d, C0356d.f15693e, C0356d.f15694f, C0356d.f15695g, C0356d.f15696h, C0356d.f15697i, C0356d.f15698j, C0356d.k});
        com.martian.ttbook.b.c.a.a.b.r(new Object[]{c.f15681a, c.f15682b, c.f15683c, c.f15684d, c.f15685e});
        com.martian.ttbook.b.c.a.a.b.t(new Object[]{new Object[]{c.f15686f, c.f15687g}, new Object[]{c.f15688h}});
    }

    public void b() {
        this.f15668b = a(this.f15675i);
        this.w = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15855d);
        this.x = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15856e);
        this.y = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15857f);
        this.z = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15858g);
    }

    public void c(int i2) {
        Map<Object, Object> c2 = com.martian.ttbook.b.c.a.a.e.c.c(null);
        new com.martian.ttbook.b.c.a.a.e.e(c2).j(c.f15684d, this.f15675i);
        try {
            byte[] bytes = com.martian.ttbook.b.c.a.a.b.k(c2).getBytes("UTF-8");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-type", am.f5520d);
            com.martian.ttbook.b.c.a.a.e.c.f(j.c(), bytes, hashMap, new b(i2));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    @NonNull
    protected Object clone() {
        d dVar = (d) super.clone();
        dVar.f15669c = UUID.randomUUID().toString();
        return dVar;
    }

    public void d(e eVar) {
        this.A = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15859h);
        this.B = com.martian.ttbook.b.c.a.a.e.k.b(this.f15675i, k.c.f15860i);
        com.martian.ttbook.b.c.a.a.e.a b2 = com.martian.ttbook.b.c.a.a.e.a.b(String.format("%s_%s", this.f15675i, com.martian.ttbook.b.c.a.a.e.b.v()));
        this.r = b2;
        if (b2 == null) {
            return;
        }
        b2.e(new a(eVar));
    }

    public void e(i iVar, e eVar) {
        g(iVar, null, eVar, true);
    }

    public void f(i iVar, e eVar, boolean z) {
        g(iVar, null, eVar, z);
    }

    public void g(i iVar, Map<Object, Object> map, e eVar, boolean z) {
        new k(this, eVar).a(2).b(iVar).d(map).h();
        if (z) {
            this.f15673g.a(iVar);
        }
    }

    public void h(int[] iArr) {
        String str = "sspp" + this.f15675i;
        if (iArr == null) {
            com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "clear saved point");
            com.martian.ttbook.b.c.a.a.e.f.c().f(str);
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "set saved pint k=" + str + "  v= " + iArr[0] + "," + iArr[1]);
        com.martian.ttbook.b.c.a.a.e.f.c().j(str, String.format("%d|%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])));
    }

    public boolean i(String str, int i2) {
        com.martian.ttbook.b.c.a.a.a aVar = this.u;
        if (aVar == null || !aVar.b(str)) {
            return false;
        }
        int a2 = this.u.a(str, -1);
        com.martian.ttbook.b.c.a.a.e.d.g("xxx", "e " + a2 + ",v " + i2);
        return a2 == i2;
    }

    public Map<Object, Object> j() {
        com.martian.ttbook.b.c.a.a.e.e eVar = new com.martian.ttbook.b.c.a.a.e.e(com.martian.ttbook.b.c.a.a.e.c.g(null));
        eVar.j(C0356d.f15689a, this.f15669c);
        eVar.j(C0356d.f15690b, this.f15675i);
        eVar.i(C0356d.f15692d, this.f15671e.a());
        if (this.f15671e == com.martian.ttbook.b.c.a.a.c.h.SPLASH) {
            eVar.i(C0356d.l, com.martian.ttbook.b.c.a.a.e.b.G() ? 1 : 0);
        }
        return eVar.f15826a;
    }

    public void k(String str, int i2) {
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
            int i3 = parseInt * parseInt2;
            int i4 = i3 + 1;
            if (split.length < i4) {
                return;
            }
            int[] iArr = new int[i3 + 3];
            iArr[0] = i2;
            iArr[1] = parseInt;
            iArr[2] = parseInt2;
            for (int i5 = 1; i5 < i4; i5++) {
                String[] split3 = split[i5].split("\\,");
                if (split3.length < 3) {
                    return;
                }
                iArr[i5 + 2] = Integer.parseInt(split3[2]);
            }
            byte[] j2 = com.martian.ttbook.b.c.a.a.b.j(iArr);
            if (j2 != null) {
                this.r.f(j2);
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.a("err " + e2);
        }
    }

    public long l() {
        return com.martian.ttbook.b.c.a.a.e.f.c().b("CLT_" + this.f15675i, 0L);
    }

    public int[] m() {
        String str;
        com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "get savedpoint");
        String d2 = com.martian.ttbook.b.c.a.a.e.f.c().d("sspp" + this.f15675i, null);
        if (d2 != null) {
            com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "sspp is" + d2);
            String[] split = d2.split("\\|");
            if (split.length > 1) {
                try {
                    com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "x = " + split[0] + ",y=" + split[1]);
                    return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                str = "ss.length < 2";
            }
        } else {
            str = "saved point empty";
        }
        com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", str);
        return null;
    }

    public void n() {
        com.martian.ttbook.b.c.a.a.e.f.c().i("CLT_" + this.f15675i, System.currentTimeMillis());
        l.h(this.f15668b, System.currentTimeMillis());
    }
}
