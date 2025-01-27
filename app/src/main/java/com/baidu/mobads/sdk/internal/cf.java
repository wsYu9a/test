package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.am;

/* loaded from: classes2.dex */
class cf implements am.b {

    /* renamed from: a */
    final /* synthetic */ double f7020a;

    /* renamed from: b */
    final /* synthetic */ bz f7021b;

    public cf(bz bzVar, double d10) {
        this.f7021b = bzVar;
        this.f7020a = d10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        if (r9 == java.lang.Math.floor(r5.b())) goto L39;
     */
    @Override // com.baidu.mobads.sdk.internal.am.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.baidu.mobads.sdk.internal.bz r10 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r0 = new com.baidu.mobads.sdk.internal.bx
            r0.<init>(r9)
            com.baidu.mobads.sdk.internal.bz.a(r10, r0)
            double r9 = com.baidu.mobads.sdk.internal.cm.b()
            com.baidu.mobads.sdk.internal.bz r0 = r8.f7021b
            android.content.SharedPreferences r0 = com.baidu.mobads.sdk.internal.bz.f(r0)
            java.lang.String r1 = "__badApkVersion__9.3711"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)
            com.baidu.mobads.sdk.internal.bz r1 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r1 = com.baidu.mobads.sdk.internal.bz.g(r1)
            double r1 = r1.b()
            float r1 = (float) r1
            r2 = 1
            r3 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            com.baidu.mobads.sdk.internal.bz r5 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r5 = com.baidu.mobads.sdk.internal.bz.g(r5)
            double r5 = r5.b()
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 > 0) goto L58
            double r9 = java.lang.Math.floor(r9)
            com.baidu.mobads.sdk.internal.bz r5 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r5 = com.baidu.mobads.sdk.internal.bz.g(r5)
            double r5 = r5.b()
            double r5 = java.lang.Math.floor(r5)
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 != 0) goto L58
            goto L59
        L58:
            r2 = 0
        L59:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            com.baidu.mobads.sdk.internal.bz r10 = r8.f7021b
            com.baidu.mobads.sdk.internal.bt r10 = com.baidu.mobads.sdk.internal.bz.e(r10)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "try to download apk badVer="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = ", isBad="
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = ", compatible="
            r5.append(r0)
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            java.lang.String r0 = "ApkLoader"
            r10.a(r0, r9)
            double r9 = r8.f7020a
            com.baidu.mobads.sdk.internal.bz r0 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r0 = com.baidu.mobads.sdk.internal.bz.g(r0)
            double r4 = r0.b()
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 >= 0) goto Lbf
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r9 = com.baidu.mobads.sdk.internal.bz.g(r9)
            if (r9 == 0) goto Lbf
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r9 = com.baidu.mobads.sdk.internal.bz.g(r9)
            java.lang.Boolean r9 = r9.a()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lbf
            if (r2 == 0) goto Lbf
            if (r1 != 0) goto Lbf
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            com.baidu.mobads.sdk.internal.bx r10 = com.baidu.mobads.sdk.internal.bz.g(r9)
            com.baidu.mobads.sdk.internal.bz.b(r9, r10)
            goto Ld3
        Lbf:
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            boolean r9 = com.baidu.mobads.sdk.internal.bz.c(r9)
            if (r9 == 0) goto Ld3
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            com.baidu.mobads.sdk.internal.bz.a(r9, r3)
            com.baidu.mobads.sdk.internal.bz r9 = r8.f7021b
            java.lang.String r10 = "Refused to download remote for version..."
            com.baidu.mobads.sdk.internal.bz.a(r9, r3, r10)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.cf.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(String str, int i10) {
        boolean z10;
        z10 = this.f7021b.A;
        if (z10) {
            this.f7021b.A = false;
            this.f7021b.a(false, "remote update Network access failed");
        }
    }
}
