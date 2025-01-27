package com.aggmoread.sdk.z.d.a.a.d.b;

/* loaded from: classes.dex */
public class b {

    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f5854a;

        static {
            int[] iArr = new int[com.aggmoread.sdk.z.d.a.a.c.i.values().length];
            f5854a = iArr;
            try {
                iArr[com.aggmoread.sdk.z.d.a.a.c.i.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.SPLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.REWARD_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.FULL_SCREEN_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5854a[com.aggmoread.sdk.z.d.a.a.c.i.DRAW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ac -> B:33:0x00b3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.aggmoread.sdk.z.d.a.a.d.b.a a(com.aggmoread.sdk.z.d.a.a.d.b.d r5, com.aggmoread.sdk.z.d.a.a.d.b.e r6) {
        /*
            r4 = this;
            com.aggmoread.sdk.z.d.a.a.e.f r0 = r6.f5907c
            java.lang.Object r1 = com.aggmoread.sdk.z.d.a.a.d.b.e.c.U
            java.lang.String r0 = r0.c(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2f
            if (r1 != 0) goto Lb3
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L2f
            com.aggmoread.sdk.z.d.a.a.c.i r1 = r5.f5859e     // Catch: java.lang.Exception -> L2f
            int r1 = r1.a()     // Catch: java.lang.Exception -> L2f
            if (r1 != r0) goto L86
            int[] r0 = com.aggmoread.sdk.z.d.a.a.d.b.b.a.f5854a     // Catch: java.lang.Exception -> L2f
            com.aggmoread.sdk.z.d.a.a.c.i r1 = r5.f5859e     // Catch: java.lang.Exception -> L2f
            int r1 = r1.ordinal()     // Catch: java.lang.Exception -> L2f
            r0 = r0[r1]     // Catch: java.lang.Exception -> L2f
            switch(r0) {
                case 1: goto L81;
                case 2: goto L7c;
                case 3: goto L77;
                case 4: goto L72;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L94;
                default: goto L27;
            }     // Catch: java.lang.Exception -> L2f
        L27:
            goto Lb3
        L29:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.d(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L2f:
            r0 = move-exception
            goto Lac
        L32:
            com.aggmoread.sdk.z.d.a.a.e.f r0 = r6.f5907c     // Catch: java.lang.Exception -> L2f
            java.lang.Object r1 = com.aggmoread.sdk.z.d.a.a.d.b.e.c.S     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = "2"
            java.lang.String r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = "xxx"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2f
            r2.<init>()     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = "v1 "
            r2.append(r3)     // Catch: java.lang.Exception -> L2f
            r2.append(r0)     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = ", v2 "
            r2.append(r3)     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = r5.f5860f     // Catch: java.lang.Exception -> L2f
            r2.append(r3)     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L2f
            com.aggmoread.sdk.z.d.a.a.e.e.b(r1, r2)     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r5.f5860f     // Catch: java.lang.Exception -> L2f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L2f
            if (r1 != 0) goto Lb3
            java.lang.String r1 = r5.f5860f     // Catch: java.lang.Exception -> L2f
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto Lb3
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.e(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L72:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.h(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L77:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.f(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L7c:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.i(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L81:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.b(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L86:
            com.aggmoread.sdk.z.d.a.a.c.i r0 = r5.f5859e     // Catch: java.lang.Exception -> L2f
            int r0 = r0.a()     // Catch: java.lang.Exception -> L2f
            com.aggmoread.sdk.z.d.a.a.c.i r1 = com.aggmoread.sdk.z.d.a.a.c.i.DRAW     // Catch: java.lang.Exception -> L2f
            int r1 = r1.a()     // Catch: java.lang.Exception -> L2f
            if (r0 != r1) goto L99
        L94:
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.c(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        L99:
            com.aggmoread.sdk.z.d.a.a.c.i r0 = r5.f5859e     // Catch: java.lang.Exception -> L2f
            int r0 = r0.a()     // Catch: java.lang.Exception -> L2f
            com.aggmoread.sdk.z.d.a.a.c.i r1 = com.aggmoread.sdk.z.d.a.a.c.i.MIX_INFORMATION_FLOW     // Catch: java.lang.Exception -> L2f
            int r1 = r1.a()     // Catch: java.lang.Exception -> L2f
            if (r0 != r1) goto Lb3
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = r4.g(r5, r6)     // Catch: java.lang.Exception -> L2f
            goto Lb4
        Lac:
            java.lang.String r0 = r0.getMessage()
            com.aggmoread.sdk.z.d.a.a.e.e.a(r0)
        Lb3:
            r0 = 0
        Lb4:
            if (r0 != 0) goto Lbb
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = new com.aggmoread.sdk.z.d.a.a.d.b.a
            r0.<init>(r5, r6)
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.b.b.a(com.aggmoread.sdk.z.d.a.a.d.b.d, com.aggmoread.sdk.z.d.a.a.d.b.e):com.aggmoread.sdk.z.d.a.a.d.b.a");
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a b(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a c(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a d(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a e(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a f(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a g(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a h(d dVar, e eVar) {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.a i(d dVar, e eVar) {
        return null;
    }

    public boolean a() {
        return false;
    }
}
