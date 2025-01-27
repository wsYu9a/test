package com.martian.ttbook.b.c.a.a.d.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.c;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public com.martian.ttbook.b.c.a.a.e.e f15782a;

    /* renamed from: b */
    public d f15783b;

    /* renamed from: c */
    public e f15784c;

    class a implements c.InterfaceC0361c {
        a(k kVar) {
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, i iVar) {
        }
    }

    public static class b {

        /* renamed from: a */
        public static final Object f15785a = new Object();

        /* renamed from: b */
        public static final Object f15786b = new Object();

        /* renamed from: c */
        public static final Object f15787c = new Object();

        /* renamed from: d */
        public static final Object f15788d = new Object();

        /* renamed from: e */
        public static final Object f15789e = new Object();

        /* renamed from: f */
        public static final Object f15790f = new Object();

        /* renamed from: g */
        public static final Object f15791g = new Object();

        /* renamed from: h */
        public static final Object f15792h = new Object();

        /* renamed from: i */
        public static final Object f15793i = new Object();

        /* renamed from: j */
        public static final Object f15794j = new Object();
        public static final Object k = new Object();
        public static final Object l = new Object();
        public static final Object m = new Object();
        public static final Object n = new Object();
        public static final Object o = new Object();
        public static final Object p = new Object();
        public static final Object q = new Object();
        public static final Object r = new Object();
        public static final Object s = new Object();
        public static final Object t = new Object();
        public static final Object u = new Object();
        public static final Object v = new Object();
        public static final Object w = new Object();
        public static final Object x = new Object();
        public static final Object y = new Object();
        public static final Object z = new Object();
        public static final Object A = new Object();
        public static final Object B = new Object();
        public static final Object C = new Object();
        public static final Object D = new Object();
        public static final Object E = new Object();
        public static final Object F = new Object();
        public static final Object G = new Object();
        public static final Object H = new Object();
        public static final Object I = new Object();
        public static final Object J = new Object();
        public static final Object K = new Object();
        public static final Object L = new Object();
        public static final Object M = new Object();
        public static final Object N = new Object();
        public static final Object O = new Object();
        public static final Object P = new Object();
        public static final Object Q = new Object();
        public static final Object R = new Object();
        public static final Object S = new Object();
        public static final Object T = new Object();
        public static final Object U = new Object();
        public static final Object V = new Object();
        public static final Object W = new Object();
        public static final Object X = new Object();
        public static final Object Y = new Object();
        public static final Object Z = new Object();
    }

    public k(d dVar, e eVar) {
        String str;
        this.f15783b = dVar;
        this.f15784c = eVar;
        com.martian.ttbook.b.c.a.a.e.e eVar2 = new com.martian.ttbook.b.c.a.a.e.e(new HashMap());
        this.f15782a = eVar2;
        if (dVar != null && (str = dVar.f15669c) != null) {
            eVar2.j(b.f15786b, str);
            this.f15782a.i(b.f15792h, dVar.f15671e.a());
            this.f15782a.j(b.f15787c, dVar.f15675i);
        }
        if (eVar == null || eVar.f15701c == null) {
            return;
        }
        this.f15782a.i(b.A, eVar.f());
        this.f15782a.j(b.f15791g, eVar.f15701c.l(e.c.Q));
    }

    public static void e() {
        com.martian.ttbook.b.c.a.a.b.x(new Object[]{b.f15785a, b.f15786b, b.f15787c, b.f15788d, b.f15789e, b.f15790f, b.f15791g, b.f15792h, b.f15793i, b.f15794j, b.k, b.l, b.m, b.n, b.o, b.p, b.q, b.r, b.s, b.t, b.u, b.v, b.w, b.x, b.y, b.z, b.A, b.B, b.C, b.D, b.E, b.F, b.G, b.H, b.I, b.J, b.K, b.L, b.M, b.N, b.O, b.P, b.Q, b.R, b.S, b.T, b.U, b.V, b.W, b.X, b.Y, b.Z});
    }

    public k a(int i2) {
        this.f15782a.i(b.f15785a, i2);
        return this;
    }

    public k b(i iVar) {
        this.f15782a.i(b.f15790f, iVar.a());
        this.f15782a.j(b.F, iVar.b());
        return this;
    }

    public k c(Object obj, Object obj2) {
        com.martian.ttbook.b.c.a.a.e.e eVar;
        double floatValue;
        if (obj2 instanceof Integer) {
            this.f15782a.i(obj, ((Integer) obj2).intValue());
        } else if (obj2 instanceof Long) {
            this.f15782a.e(obj, ((Long) obj2).longValue());
        } else {
            if (obj2 instanceof Double) {
                eVar = this.f15782a;
                floatValue = ((Double) obj2).doubleValue();
            } else if (obj2 instanceof Float) {
                eVar = this.f15782a;
                floatValue = ((Float) obj2).floatValue();
            } else if (obj2 instanceof Boolean) {
                this.f15782a.k(obj, ((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof String) {
                this.f15782a.j(obj, (String) obj2);
            }
            eVar.h(obj, floatValue);
        }
        return this;
    }

    public k d(Map<Object, Object> map) {
        if (map != null) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                c(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public void f(String str, boolean z) {
        com.martian.ttbook.b.c.a.a.e.k kVar;
        if (TextUtils.isEmpty(str)) {
            str = com.martian.ttbook.b.c.a.a.b.o(this.f15782a.f15826a);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f5520d);
        try {
            com.martian.ttbook.b.c.a.a.e.c.f(z ? j.b() : j.f(), str.getBytes("UTF-8"), hashMap, new a(this));
            if (this.f15783b != null) {
                int g2 = this.f15782a.g(b.f15785a);
                if (g2 == 4) {
                    this.f15783b.w.d();
                    kVar = this.f15783b.x;
                } else {
                    if (g2 != 5) {
                        if (g2 != 6) {
                            return;
                        }
                        this.f15783b.A.d();
                        this.f15783b.B.d();
                        if (this.f15782a.g(b.s) > 0) {
                            this.f15783b.n();
                        }
                        e eVar = this.f15784c;
                        if (eVar != null) {
                            l.s(this.f15783b.f15668b, eVar.e(), this.f15784c.b());
                            return;
                        }
                        return;
                    }
                    this.f15783b.y.d();
                    kVar = this.f15783b.z;
                }
                kVar.d();
            }
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public boolean g(e eVar, com.martian.ttbook.b.c.a.a.d.b.m.a aVar, long j2, Object[] objArr) {
        float f2;
        float f3;
        a(6);
        int[] iArr = (int[]) objArr[8];
        ?? r8 = 1;
        r8 = true;
        boolean z = true;
        r8 = 1;
        r8 = 1;
        if (aVar != null) {
            int width = aVar.getWidth();
            int height = aVar.getHeight();
            f3 = width <= 0 ? 0.0f : aVar.f15796a / width;
            f2 = height <= 0 ? 0.0f : aVar.f15797b / aVar.getHeight();
            this.f15782a.h(b.t, f3);
            this.f15782a.h(b.u, f2);
            this.f15782a.i(b.J, aVar.getWidth());
            this.f15782a.i(b.K, aVar.getHeight());
            this.f15782a.i(b.W, (int) aVar.f15796a);
            this.f15782a.i(b.X, (int) aVar.f15797b);
        } else {
            float[] fArr = (float[]) objArr[0];
            if (fArr != null) {
                this.f15782a.h(b.t, fArr[0]);
                this.f15782a.h(b.u, fArr[1]);
                float f4 = fArr[0];
                float f5 = fArr[1];
                com.martian.ttbook.b.c.a.a.e.d.g("xxx", "screen strategy dx = " + f4 + ", dy = " + f5);
                f2 = f5;
                f3 = f4;
            } else {
                com.martian.ttbook.b.c.a.a.e.d.g("xxx", "未取到点击坐标");
                f2 = -1.0f;
                f3 = -1.0f;
            }
            if (iArr != null) {
                this.f15782a.i(b.J, iArr[2]);
                this.f15782a.i(b.K, iArr[3]);
                this.f15782a.i(b.W, iArr[14]);
                this.f15782a.i(b.X, iArr[15]);
            }
        }
        if (iArr != null) {
            this.f15782a.i(b.H, iArr[0]);
            this.f15782a.i(b.I, iArr[1]);
            this.f15782a.i(b.L, iArr[4]);
            this.f15782a.i(b.M, iArr[5]);
            this.f15782a.i(b.P, iArr[8]);
            this.f15782a.i(b.Q, iArr[9]);
            this.f15782a.i(b.N, iArr[6]);
            this.f15782a.i(b.O, iArr[7]);
            this.f15782a.i(b.Y, iArr[16]);
            this.f15782a.i(b.Z, iArr[17]);
            this.f15782a.i(b.S, iArr[10]);
            this.f15782a.i(b.T, iArr[11]);
            this.f15782a.i(b.U, iArr[12]);
            this.f15782a.i(b.V, iArr[13]);
        }
        Boolean bool = (Boolean) objArr[9];
        this.f15782a.k(b.R, bool != null && bool.booleanValue());
        Integer num = (Integer) objArr[2];
        int intValue = num == null ? 0 : num.intValue();
        this.f15782a.i(b.s, intValue);
        if (intValue > 0) {
            if (((float[]) objArr[3]) != null) {
                this.f15782a.h(b.v, r1[0]);
                this.f15782a.h(b.w, r1[1]);
            }
            double b2 = eVar.f15702d.b(e.c.o, 1.0d);
            if (b2 < 1.0d && !com.martian.ttbook.b.c.a.a.e.g.b(b2)) {
                z = false;
            }
            d dVar = this.f15783b;
            r8 = z;
            if (dVar != null) {
                r8 = z;
                if (dVar.f15671e == com.martian.ttbook.b.c.a.a.c.h.SPLASH) {
                    dVar.h(null);
                    r8 = z;
                }
            }
        } else if (f3 > 0.0f && f2 > 0.0f) {
            this.f15782a.h(b.v, f3);
            this.f15782a.h(b.w, f2);
        }
        this.f15782a.i(b.r, r8);
        if (j2 > 0) {
            this.f15782a.e(b.D, System.currentTimeMillis() - j2);
        }
        return r8;
    }

    public void h() {
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15782a;
        Object obj = b.f15786b;
        if (eVar.l(obj) == null) {
            this.f15782a.j(obj, UUID.randomUUID().toString());
        }
        this.f15782a.j(b.f15793i, com.martian.ttbook.b.c.a.a.e.b.q());
        this.f15782a.k(b.f15789e, com.martian.ttbook.b.c.a.a.e.b.E());
        this.f15782a.j(b.m, com.martian.ttbook.b.c.a.a.e.b.t());
        this.f15782a.j(b.z, j.q.getPackageName());
        this.f15782a.j(b.l, com.martian.ttbook.b.c.a.a.e.b.u());
        this.f15782a.j(b.f15794j, Build.BRAND);
        this.f15782a.j(b.k, Build.MODEL);
        this.f15782a.j(b.y, com.martian.ttbook.b.c.a.a.e.b.v());
        this.f15782a.j(b.x, com.martian.ttbook.b.c.a.a.e.b.p());
        com.martian.ttbook.b.c.a.a.e.e eVar2 = this.f15782a;
        Object obj2 = b.G;
        e eVar3 = this.f15784c;
        eVar2.i(obj2, eVar3 == null ? 0 : eVar3.f15704f);
        this.f15782a.e(b.f15788d, new Date().getTime());
        e eVar4 = this.f15784c;
        if (eVar4 != null && eVar4.f15708j) {
            int g2 = this.f15782a.g(b.f15785a);
            if (g2 == 2) {
                this.f15784c.a(this);
                return;
            } else if (g2 == 3) {
                this.f15784c.d(this);
                return;
            } else if (g2 == 4) {
                this.f15784c.j();
            }
        }
        f(null, false);
    }
}
