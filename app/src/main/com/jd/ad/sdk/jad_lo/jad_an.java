package com.jd.ad.sdk.jad_lo;

/* loaded from: classes2.dex */
public class jad_an {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (r1.waitFor() == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r2 != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        r0 = r5.jad_an();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an(java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L3f
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L3f
            if (r2 == r3) goto L48
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3f
            java.lang.Process r1 = r2.exec(r5)     // Catch: java.lang.Throwable -> L3f
            java.io.OutputStream r5 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L3f
            r5.close()     // Catch: java.lang.Throwable -> L3f
            com.jd.ad.sdk.jad_lo.jad_jt r5 = new com.jd.ad.sdk.jad_lo.jad_jt     // Catch: java.lang.Throwable -> L3f
            java.io.InputStream r2 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3f
            r3 = 0
            r5.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3f
            r5.start()     // Catch: java.lang.Throwable -> L3f
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3f
            r3 = 26
            if (r2 < r3) goto L41
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L3f
            r3 = 2
            boolean r2 = i7.a.a(r1, r3, r2)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L48
        L39:
            java.lang.String r5 = r5.jad_an()     // Catch: java.lang.Throwable -> L3f
            r0 = r5
            goto L48
        L3f:
            goto L4b
        L41:
            int r2 = r1.waitFor()     // Catch: java.lang.Throwable -> L3f
            if (r2 != 0) goto L48
            goto L39
        L48:
            if (r1 == 0) goto L50
            goto L4d
        L4b:
            if (r1 == 0) goto L50
        L4d:
            r1.destroy()
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_lo.jad_an.jad_an(java.lang.String):java.lang.String");
    }
}
