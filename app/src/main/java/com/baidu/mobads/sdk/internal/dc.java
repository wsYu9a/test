package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class dc {

    /* renamed from: a */
    public static final String f7142a = "error_message";

    /* renamed from: b */
    public static final String f7143b = "error_code";

    /* renamed from: d */
    private static volatile dc f7144d;

    /* renamed from: c */
    protected final bt f7145c = bt.a();

    private dc() {
    }

    public static dc a() {
        if (f7144d == null) {
            synchronized (dc.class) {
                try {
                    if (f7144d == null) {
                        f7144d = new dc();
                    }
                } finally {
                }
            }
        }
        return f7144d;
    }

    public String a(bp bpVar, String str) {
        if (bpVar == null) {
            return "";
        }
        return a(bpVar.b() + "", bpVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append("ErrorCode: [");
            sb2.append(str);
            sb2.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append("ErrorDesc: [");
            sb2.append(str2);
            sb2.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(" Extra: [");
            sb2.append(str3);
            sb2.append("];");
        }
        return sb2.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:9:0x0019
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L28
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L19
            if (r3 == 0) goto L1b
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L19
            com.baidu.mobads.sdk.internal.bp r5 = (com.baidu.mobads.sdk.internal.bp) r5     // Catch: java.lang.Exception -> L19
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L19
            goto L29
        L19:
            goto L28
        L1b:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L19
            if (r1 == 0) goto L28
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L19
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L19
            goto L29
        L28:
            r5 = r2
        L29:
            if (r5 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r5
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dc.a(java.util.Map):java.lang.String");
    }
}
