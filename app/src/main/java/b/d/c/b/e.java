package b.d.c.b;

import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes2.dex */
public class e<E> extends g<E> {

    /* renamed from: a */
    private static final String f4439a = "JsonParser";

    /* renamed from: b */
    public int f4440b;

    /* renamed from: c */
    public String f4441c;

    /* renamed from: d */
    public String f4442d;

    /* renamed from: e */
    public String f4443e;

    /* renamed from: f */
    public boolean f4444f;

    /* renamed from: g */
    public int f4445g;

    /* renamed from: h */
    private Class<E> f4446h;

    public e() {
        this.f4440b = 1;
        this.f4441c = "code";
        this.f4442d = "reason";
        this.f4443e = MiConfigSingleton.t0;
        this.f4444f = true;
        this.f4445g = Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:
    
        r7.l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a1, code lost:
    
        if (r2 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00aa, code lost:
    
        return new b.d.c.b.c(0, "数据异常");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.c.b.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected b.d.c.b.k c(java.lang.String r7) {
        /*
            r6 = this;
            com.google.gson.Gson r0 = com.martian.libcomm.utils.GsonUtils.a()     // Catch: java.lang.Exception -> Lab
            java.io.StringReader r1 = new java.io.StringReader     // Catch: java.lang.Exception -> Lab
            r1.<init>(r7)     // Catch: java.lang.Exception -> Lab
            com.google.gson.stream.a r7 = new com.google.gson.stream.a     // Catch: java.lang.Exception -> Lab
            r7.<init>(r1)     // Catch: java.lang.Exception -> Lab
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lab
            r1.<init>()     // Catch: java.lang.Exception -> Lab
            boolean r2 = r6.f4444f     // Catch: java.lang.Exception -> Lab
            r3 = 0
            if (r2 != 0) goto L41
            r7.f()     // Catch: java.lang.Exception -> Lab
        L1b:
            boolean r2 = r7.p()     // Catch: java.lang.Exception -> Lab
            if (r2 == 0) goto L38
            int r2 = r3 + 1
            int r4 = r6.f4445g     // Catch: java.lang.Exception -> Lab
            if (r3 < r4) goto L2d
            b.d.c.b.h r7 = new b.d.c.b.h     // Catch: java.lang.Exception -> Lab
            r7.<init>(r1)     // Catch: java.lang.Exception -> Lab
            return r7
        L2d:
            java.lang.Class<E> r3 = r6.f4446h     // Catch: java.lang.Exception -> Lab
            java.lang.Object r3 = r0.fromJson(r7, r3)     // Catch: java.lang.Exception -> Lab
            r1.add(r3)     // Catch: java.lang.Exception -> Lab
            r3 = r2
            goto L1b
        L38:
            r7.k()     // Catch: java.lang.Exception -> Lab
            b.d.c.b.h r7 = new b.d.c.b.h     // Catch: java.lang.Exception -> Lab
            r7.<init>(r1)     // Catch: java.lang.Exception -> Lab
            return r7
        L41:
            r7.g()     // Catch: java.lang.Exception -> Lab
            r2 = 0
        L45:
            boolean r4 = r7.p()     // Catch: java.lang.Exception -> Lab
            if (r4 == 0) goto L9e
            java.lang.String r4 = r7.w()     // Catch: java.lang.Exception -> Lab
            java.lang.String r5 = r6.f4441c     // Catch: java.lang.Exception -> Lab
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Exception -> Lab
            if (r5 == 0) goto L68
            int r4 = r7.u()     // Catch: java.lang.Exception -> Lab
            int r5 = r6.f4440b     // Catch: java.lang.Exception -> Lab
            if (r4 == r5) goto L45
            b.d.c.b.c r2 = new b.d.c.b.c     // Catch: java.lang.Exception -> Lab
            r0 = -1
            java.lang.String r1 = "网络异常"
            r2.<init>(r0, r1)     // Catch: java.lang.Exception -> Lab
            goto L9e
        L68:
            java.lang.String r5 = r6.f4443e     // Catch: java.lang.Exception -> Lab
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> Lab
            if (r4 == 0) goto L9a
            r7.f()     // Catch: java.lang.Exception -> Lab
            r2 = 0
        L74:
            boolean r4 = r7.p()     // Catch: java.lang.Exception -> Lab
            if (r4 == 0) goto L91
            int r4 = r2 + 1
            int r5 = r6.f4445g     // Catch: java.lang.Exception -> Lab
            if (r2 < r5) goto L86
            b.d.c.b.h r7 = new b.d.c.b.h     // Catch: java.lang.Exception -> Lab
            r7.<init>(r1)     // Catch: java.lang.Exception -> Lab
            return r7
        L86:
            java.lang.Class<E> r2 = r6.f4446h     // Catch: java.lang.Exception -> Lab
            java.lang.Object r2 = r0.fromJson(r7, r2)     // Catch: java.lang.Exception -> Lab
            r1.add(r2)     // Catch: java.lang.Exception -> Lab
            r2 = r4
            goto L74
        L91:
            r7.k()     // Catch: java.lang.Exception -> Lab
            b.d.c.b.h r2 = new b.d.c.b.h     // Catch: java.lang.Exception -> Lab
            r2.<init>(r1)     // Catch: java.lang.Exception -> Lab
            goto L45
        L9a:
            r7.M()     // Catch: java.lang.Exception -> Lab
            goto L45
        L9e:
            r7.l()     // Catch: java.lang.Exception -> Lab
            if (r2 != 0) goto Laa
            b.d.c.b.c r2 = new b.d.c.b.c     // Catch: java.lang.Exception -> Lab
            java.lang.String r7 = "数据异常"
            r2.<init>(r3, r7)     // Catch: java.lang.Exception -> Lab
        Laa:
            return r2
        Lab:
            r7 = move-exception
            b.d.c.b.c r0 = new b.d.c.b.c
            r1 = 1000(0x3e8, float:1.401E-42)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r7.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r3 = " -> "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.<init>(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.c.b.e.c(java.lang.String):b.d.c.b.k");
    }

    public e(Class<E> elemClass, String resultCodeKey) {
        this.f4440b = 1;
        this.f4441c = "code";
        this.f4442d = "reason";
        this.f4443e = MiConfigSingleton.t0;
        this.f4444f = true;
        this.f4445g = Integer.MAX_VALUE;
        this.f4441c = resultCodeKey;
        this.f4446h = elemClass;
    }

    public e(Class<E> elemClass, String resultCodeKey, String failureReasonKey, String dataKey, int succ_code) {
        this.f4440b = 1;
        this.f4441c = "code";
        this.f4442d = "reason";
        this.f4443e = MiConfigSingleton.t0;
        this.f4444f = true;
        this.f4445g = Integer.MAX_VALUE;
        this.f4441c = resultCodeKey;
        this.f4442d = failureReasonKey;
        this.f4443e = dataKey;
        this.f4440b = succ_code;
        this.f4446h = elemClass;
    }

    public e(Class<E> elemClass, String resultCodeKey, String failureReasonKey, String dataKey, int succ_code, boolean hasCode) {
        this.f4440b = 1;
        this.f4441c = "code";
        this.f4442d = "reason";
        this.f4443e = MiConfigSingleton.t0;
        this.f4444f = true;
        this.f4445g = Integer.MAX_VALUE;
        this.f4441c = resultCodeKey;
        this.f4442d = failureReasonKey;
        this.f4443e = dataKey;
        this.f4440b = succ_code;
        this.f4446h = elemClass;
        this.f4444f = hasCode;
    }

    public e(Class<E> elemClass, String resultCodeKey, String failureReasonKey, String dataKey, int succ_code, boolean hasCode, int maxSize) {
        this.f4440b = 1;
        this.f4441c = "code";
        this.f4442d = "reason";
        this.f4443e = MiConfigSingleton.t0;
        this.f4444f = true;
        this.f4445g = Integer.MAX_VALUE;
        this.f4441c = resultCodeKey;
        this.f4442d = failureReasonKey;
        this.f4443e = dataKey;
        this.f4440b = succ_code;
        this.f4446h = elemClass;
        this.f4444f = hasCode;
        this.f4445g = maxSize;
    }
}
