package com.aggmoread.sdk.z.d.a.a.d.b;

import android.os.Build;
import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.aggmoread.sdk.z.d.a.a.e.o;
import com.baidu.mobads.sdk.internal.am;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    public com.aggmoread.sdk.z.d.a.a.e.f f6030a;

    /* renamed from: b */
    public d f6031b;

    /* renamed from: c */
    public e f6032c;

    public class a implements d.c {
        public a(k kVar) {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, i iVar) {
        }
    }

    public static class b {

        /* renamed from: a */
        public static final Object f6033a = new Object();

        /* renamed from: b */
        public static final Object f6034b = new Object();

        /* renamed from: c */
        public static final Object f6035c = new Object();

        /* renamed from: d */
        public static final Object f6036d = new Object();

        /* renamed from: e */
        public static final Object f6037e = new Object();

        /* renamed from: f */
        public static final Object f6038f = new Object();

        /* renamed from: g */
        public static final Object f6039g = new Object();

        /* renamed from: h */
        public static final Object f6040h = new Object();

        /* renamed from: i */
        public static final Object f6041i = new Object();

        /* renamed from: j */
        public static final Object f6042j = new Object();

        /* renamed from: k */
        public static final Object f6043k = new Object();

        /* renamed from: l */
        public static final Object f6044l = new Object();

        /* renamed from: m */
        public static final Object f6045m = new Object();

        /* renamed from: n */
        public static final Object f6046n = new Object();

        /* renamed from: o */
        public static final Object f6047o = new Object();

        /* renamed from: p */
        public static final Object f6048p = new Object();

        /* renamed from: q */
        public static final Object f6049q = new Object();

        /* renamed from: r */
        public static final Object f6050r = new Object();

        /* renamed from: s */
        public static final Object f6051s = new Object();

        /* renamed from: t */
        public static final Object f6052t = new Object();

        /* renamed from: u */
        public static final Object f6053u = new Object();

        /* renamed from: v */
        public static final Object f6054v = new Object();

        /* renamed from: w */
        public static final Object f6055w = new Object();

        /* renamed from: x */
        public static final Object f6056x = new Object();

        /* renamed from: y */
        public static final Object f6057y = new Object();

        /* renamed from: z */
        public static final Object f6058z = new Object();
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

    public k() {
        this.f6030a = new com.aggmoread.sdk.z.d.a.a.e.f(new HashMap());
    }

    public k a(int i10) {
        this.f6030a.b(b.f6033a, i10);
        return this;
    }

    public void b() {
        e eVar;
        com.aggmoread.sdk.z.d.a.a.e.f fVar = this.f6030a;
        Object obj = b.f6033a;
        if (3 == fVar.b(obj) && (eVar = this.f6032c) != null && eVar.a()) {
            a(10);
        }
        com.aggmoread.sdk.z.d.a.a.e.f fVar2 = this.f6030a;
        Object obj2 = b.f6034b;
        if (fVar2.c(obj2) == null) {
            this.f6030a.b(obj2, UUID.randomUUID().toString());
        }
        this.f6030a.b(b.f6041i, com.aggmoread.sdk.z.d.a.a.e.c.g());
        this.f6030a.b(b.f6037e, com.aggmoread.sdk.z.d.a.a.e.c.B());
        this.f6030a.b(b.f6045m, com.aggmoread.sdk.z.d.a.a.e.c.o());
        this.f6030a.b(b.f6058z, j.f6027q.getPackageName());
        this.f6030a.b(b.f6044l, com.aggmoread.sdk.z.d.a.a.e.c.p());
        this.f6030a.b(b.f6042j, Build.BRAND);
        this.f6030a.b(b.f6043k, Build.MODEL);
        this.f6030a.b(b.f6057y, com.aggmoread.sdk.z.d.a.a.e.c.q());
        this.f6030a.b(b.f6056x, com.aggmoread.sdk.z.d.a.a.e.c.e());
        e eVar2 = this.f6032c;
        int g10 = eVar2 == null ? 0 : eVar2.g();
        this.f6030a.b(b.G, g10);
        this.f6030a.a(b.f6036d, new Date().getTime());
        e eVar3 = this.f6032c;
        if (eVar3 != null && eVar3.h()) {
            int b10 = this.f6030a.b(obj);
            if (b10 != 0) {
                if (b10 == 3) {
                    this.f6032c.k();
                } else if (b10 == 8) {
                    this.f6032c.a(this);
                    return;
                }
            } else if (g10 != 0) {
                this.f6032c.b(this);
                return;
            }
        }
        a((String) null, false);
    }

    public k(d dVar, e eVar) {
        String str;
        this.f6031b = dVar;
        this.f6032c = eVar;
        com.aggmoread.sdk.z.d.a.a.e.f fVar = new com.aggmoread.sdk.z.d.a.a.e.f(new HashMap());
        this.f6030a = fVar;
        if (dVar != null && (str = dVar.f5857c) != null) {
            fVar.b(b.f6034b, str);
            int a10 = dVar.f5859e.a();
            com.aggmoread.sdk.z.d.a.a.c.i iVar = dVar.f5859e;
            this.f6030a.b(b.f6040h, (iVar == com.aggmoread.sdk.z.d.a.a.c.i.DRAW || iVar == com.aggmoread.sdk.z.d.a.a.c.i.MIX_INFORMATION_FLOW) ? com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW.a() : a10);
            this.f6030a.b(b.f6035c, dVar.f5863i);
        }
        if (eVar == null || eVar.f5907c == null) {
            return;
        }
        this.f6030a.b(b.A, eVar.f());
        this.f6030a.b(b.f6039g, eVar.f5907c.c(e.c.T));
    }

    public k a(i iVar) {
        this.f6030a.b(b.f6038f, iVar.a());
        this.f6030a.b(b.F, iVar.b());
        return this;
    }

    public k a(Object obj, Object obj2) {
        com.aggmoread.sdk.z.d.a.a.e.f fVar;
        double floatValue;
        if (obj2 instanceof Integer) {
            this.f6030a.b(obj, ((Integer) obj2).intValue());
        } else if (obj2 instanceof Long) {
            this.f6030a.a(obj, ((Long) obj2).longValue());
        } else {
            if (obj2 instanceof Double) {
                fVar = this.f6030a;
                floatValue = ((Double) obj2).doubleValue();
            } else if (obj2 instanceof Float) {
                fVar = this.f6030a;
                floatValue = ((Float) obj2).floatValue();
            } else if (obj2 instanceof Boolean) {
                this.f6030a.b(obj, ((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof String) {
                this.f6030a.b(obj, (String) obj2);
            }
            fVar.b(obj, floatValue);
        }
        return this;
    }

    public k a(Map<Object, Object> map) {
        if (map != null) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public static void a() {
        com.aggmoread.sdk.z.d.a.a.b.f(new Object[]{b.f6033a, b.f6034b, b.f6035c, b.f6036d, b.f6037e, b.f6038f, b.f6039g, b.f6040h, b.f6041i, b.f6042j, b.f6043k, b.f6044l, b.f6045m, b.f6046n, b.f6047o, b.f6048p, b.f6049q, b.f6050r, b.f6051s, b.f6052t, b.f6053u, b.f6054v, b.f6055w, b.f6056x, b.f6057y, b.f6058z, b.A, b.B, b.C, b.D, b.E, b.F, b.G, b.H, b.I, b.J, b.K, b.L, b.M, b.N, b.O, b.P, b.Q, b.R, b.S, b.T, b.U, b.V, b.W, b.X, b.Y, b.Z});
    }

    public void a(String str, boolean z10) {
        o oVar;
        if (TextUtils.isEmpty(str)) {
            str = com.aggmoread.sdk.z.d.a.a.b.c(this.f6030a.f6092a);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f6738d);
        try {
            com.aggmoread.sdk.z.d.a.a.e.d.a(z10 ? j.b() : j.f(), str.getBytes("UTF-8"), hashMap, new a(this));
            if (this.f6031b != null) {
                int b10 = this.f6030a.b(b.f6033a);
                if (b10 == 2) {
                    this.f6031b.F.a();
                    this.f6031b.G.a();
                    if (this.f6030a.b(b.f6051s) > 0) {
                        this.f6031b.f();
                    }
                    e eVar = this.f6032c;
                    if (eVar != null) {
                        l.b(this.f6031b.f5856b, eVar.e(), this.f6032c.b());
                        return;
                    }
                    return;
                }
                if (b10 != 3) {
                    if (b10 == 6) {
                        this.f6031b.D.a();
                        oVar = this.f6031b.E;
                        oVar.a();
                    } else if (b10 != 9) {
                        return;
                    }
                }
                this.f6031b.B.a();
                oVar = this.f6031b.C;
                oVar.a();
            }
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    public boolean a(e eVar, com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar, long j10, Object[] objArr) {
        float f10;
        float f11;
        float f12;
        a(2);
        int[] iArr = (int[]) objArr[9];
        ?? r92 = 1;
        r92 = 1;
        r92 = 1;
        if (aVar != null) {
            int width = aVar.getWidth();
            int height = aVar.getHeight();
            f11 = width <= 0 ? 0.0f : aVar.f6060a / width;
            f12 = height <= 0 ? 0.0f : aVar.f6061b / aVar.getHeight();
            this.f6030a.b(b.f6052t, f11);
            this.f6030a.b(b.f6053u, f12);
            this.f6030a.b(b.J, aVar.getWidth());
            this.f6030a.b(b.K, aVar.getHeight());
            this.f6030a.b(b.W, (int) aVar.f6060a);
            this.f6030a.b(b.X, (int) aVar.f6061b);
        } else {
            float[] fArr = (float[]) objArr[5];
            if (fArr != null) {
                this.f6030a.b(b.f6052t, fArr[0]);
                this.f6030a.b(b.f6053u, fArr[1]);
                f11 = fArr[0];
                f10 = fArr[1];
                com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "screen strategy dx = " + f11 + ", dy = " + f10);
            } else {
                com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "未取到点击坐标");
                f10 = -1.0f;
                f11 = -1.0f;
            }
            if (iArr != null) {
                this.f6030a.b(b.J, iArr[2]);
                this.f6030a.b(b.K, iArr[3]);
                this.f6030a.b(b.W, iArr[14]);
                this.f6030a.b(b.X, iArr[15]);
            }
            f12 = f10;
        }
        if (iArr != null) {
            this.f6030a.b(b.H, iArr[0]);
            this.f6030a.b(b.I, iArr[1]);
            this.f6030a.b(b.L, iArr[4]);
            this.f6030a.b(b.M, iArr[5]);
            this.f6030a.b(b.P, iArr[8]);
            this.f6030a.b(b.Q, iArr[9]);
            this.f6030a.b(b.N, iArr[6]);
            this.f6030a.b(b.O, iArr[7]);
            this.f6030a.b(b.Y, iArr[16]);
            this.f6030a.b(b.Z, iArr[17]);
            this.f6030a.b(b.S, iArr[10]);
            this.f6030a.b(b.T, iArr[11]);
            this.f6030a.b(b.U, iArr[12]);
            this.f6030a.b(b.V, iArr[13]);
        }
        Boolean bool = (Boolean) objArr[8];
        this.f6030a.b(b.R, bool != null && bool.booleanValue());
        Integer num = (Integer) objArr[4];
        int intValue = num == null ? 0 : num.intValue();
        this.f6030a.b(b.f6051s, intValue);
        if (intValue > 0) {
            if (((float[]) objArr[1]) != null) {
                this.f6030a.b(b.f6054v, r2[0]);
                this.f6030a.b(b.f6055w, r2[1]);
            }
            com.aggmoread.sdk.z.d.a.a.e.f fVar = eVar.f5907c;
            double a10 = fVar != null ? fVar.a(e.c.f5929f0, -1.0d) : -1.0d;
            com.aggmoread.sdk.z.d.a.a.e.e.a("dcsr " + a10);
            double a11 = eVar.f5908d.a(e.c.f5941q, 1.0d);
            if (a10 == -1.0d) {
                a10 = a11;
            }
            boolean z10 = a10 >= 1.0d || com.aggmoread.sdk.z.d.a.a.e.i.a(a10);
            d dVar = this.f6031b;
            if (dVar != null && dVar.f5859e == com.aggmoread.sdk.z.d.a.a.c.i.SPLASH) {
                dVar.a((int[]) null);
            }
            r92 = z10;
        } else if (f11 > 0.0f && f12 > 0.0f) {
            this.f6030a.b(b.f6054v, f11);
            this.f6030a.b(b.f6055w, f12);
        }
        this.f6030a.b(b.f6050r, (int) r92);
        if (j10 > 0) {
            this.f6030a.a(b.D, System.currentTimeMillis() - j10);
        }
        return r92;
    }
}
