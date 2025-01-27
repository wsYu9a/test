package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class da {

    /* renamed from: a */
    public static final String f5773a = "error_message";

    /* renamed from: b */
    public static final String f5774b = "error_code";

    /* renamed from: d */
    private static volatile da f5775d;

    /* renamed from: c */
    protected final bq f5776c = bq.a();

    private da() {
    }

    public static da a() {
        if (f5775d == null) {
            synchronized (da.class) {
                if (f5775d == null) {
                    f5775d = new da();
                }
            }
        }
        return f5775d;
    }

    public String a(bm bmVar, String str) {
        if (bmVar == null) {
            return "";
        }
        return a(bmVar.b() + "", bmVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:9:0x0026
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002a  */
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
            if (r5 == 0) goto L26
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.bm r5 = (com.baidu.mobads.sdk.internal.bm) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L27
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L26
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L27
        L26:
            r5 = r2
        L27:
            if (r5 != 0) goto L2a
            goto L2b
        L2a:
            r2 = r5
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.da.a(java.util.Map):java.lang.String");
    }
}
