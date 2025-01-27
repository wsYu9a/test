package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: classes5.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x015e, code lost:
    
        if (r1 == null) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0160, code lost:
    
        r11 = r0;
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0139, code lost:
    
        if (r1 == null) goto L258;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0152 A[Catch: IOException -> 0x014e, TryCatch #9 {IOException -> 0x014e, blocks: (B:38:0x014a, B:24:0x0152, B:26:0x0157), top: B:37:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0157 A[Catch: IOException -> 0x014e, TRY_LEAVE, TryCatch #9 {IOException -> 0x014e, blocks: (B:38:0x014a, B:24:0x0152, B:26:0x0157), top: B:37:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d A[Catch: IOException -> 0x0129, TryCatch #11 {IOException -> 0x0129, blocks: (B:54:0x0125, B:45:0x012d, B:47:0x0132), top: B:53:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0132 A[Catch: IOException -> 0x0129, TRY_LEAVE, TryCatch #11 {IOException -> 0x0129, blocks: (B:54:0x0125, B:45:0x012d, B:47:0x0132), top: B:53:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f A[Catch: IOException -> 0x017b, TryCatch #20 {IOException -> 0x017b, blocks: (B:72:0x0177, B:60:0x017f, B:62:0x0184), top: B:71:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184 A[Catch: IOException -> 0x017b, TRY_LEAVE, TryCatch #20 {IOException -> 0x017b, blocks: (B:72:0x0177, B:60:0x017f, B:62:0x0184), top: B:71:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v26, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yxcorp.kuaishou.addfp.android.b.e a(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a():java.lang.String");
    }

    public static String a(int i2, String str) {
        String a2;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        sb.append(split[1]);
        sb.append(split[2]);
        if (i2 == 0) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[0], str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i2 == 1) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[1], str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i2 == 2) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[2], str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            a2 = "";
        }
        return a2 == null ? "" : a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #2 {all -> 0x009f, blocks: (B:31:0x00a9, B:35:0x00b1), top: B:30:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7 A[Catch: all -> 0x00ce, TRY_LEAVE, TryCatch #1 {all -> 0x00ce, blocks: (B:3:0x0004, B:6:0x0019, B:8:0x0025, B:11:0x005c, B:13:0x0062, B:18:0x0069, B:20:0x0073, B:23:0x0083, B:25:0x0089, B:26:0x009f, B:41:0x00c1, B:43:0x00c7, B:49:0x0079, B:55:0x003e, B:57:0x004a, B:59:0x0058), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r11) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = "KWE_N"
            java.lang.String r2 = a(r11, r0)     // Catch: java.lang.Throwable -> Lce
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r4 = "Lm91a2R0ZnQ="
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            r7 = 2
            r8 = 1
            r9 = 0
            java.lang.String r10 = ""
            if (r3 == 0) goto L3e
            java.lang.String[] r3 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lce
            r3[r9] = r6     // Catch: java.lang.Throwable -> Lce
            r3[r8] = r5     // Catch: java.lang.Throwable -> Lce
            boolean r3 = com.yxcorp.kuaishou.addfp.android.b.g.a(r11, r3)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L3b
            com.yxcorp.kuaishou.addfp.android.a.d r3 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r10 = r3.a(r4)     // Catch: java.lang.Throwable -> Lce
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r3 != 0) goto L5b
            android.content.ContentResolver r3 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L5b
            android.provider.Settings.System.putString(r3, r0, r10)     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L3b:
            java.lang.String r0 = "KWE_PN"
            goto L5c
        L3e:
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lce
            r0[r9] = r6     // Catch: java.lang.Throwable -> Lce
            r0[r8] = r5     // Catch: java.lang.Throwable -> Lce
            boolean r0 = com.yxcorp.kuaishou.addfp.android.b.g.a(r11, r0)     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto L5b
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r10 = r0.a(r4)     // Catch: java.lang.Throwable -> Lce
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto L5b
            com.yxcorp.kuaishou.addfp.android.a.d.a(r11, r2)     // Catch: java.lang.Throwable -> Lce
        L5b:
            r0 = r1
        L5c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L69
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L69
            goto Ld4
        L69:
            com.yxcorp.kuaishou.addfp.android.a.d r1 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Lce
            java.util.LinkedHashMap r1 = r1.b(r2)     // Catch: java.lang.Throwable -> Lce
            if (r1 == 0) goto L79
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Lce
            if (r2 != 0) goto L81
        L79:
            com.yxcorp.kuaishou.addfp.android.a.d r11 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Lce
            java.util.LinkedHashMap r1 = r11.b(r10)     // Catch: java.lang.Throwable -> Lce
        L81:
            if (r1 == 0) goto Lcc
            int r11 = r1.size()     // Catch: java.lang.Throwable -> Lce
            if (r11 <= 0) goto Lcc
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lce
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Throwable -> Lce
            r11.<init>(r2)     // Catch: java.lang.Throwable -> Lce
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Lce
            java.util.ListIterator r11 = r11.listIterator(r1)     // Catch: java.lang.Throwable -> Lce
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lce
            r1.<init>()     // Catch: java.lang.Throwable -> Lce
        L9f:
            boolean r2 = r11.hasPrevious()     // Catch: java.lang.Throwable -> Lce
            if (r2 == 0) goto Lc1
            r2 = 10
            if (r9 >= r2) goto Lc1
            java.lang.Object r2 = r11.previous()     // Catch: java.lang.Throwable -> L9f
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto Lbe
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> L9f
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> L9f
        Lbe:
            int r9 = r9 + 1
            goto L9f
        Lc1:
            int r11 = r1.length()     // Catch: java.lang.Throwable -> Lce
            if (r11 <= 0) goto Lcc
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Throwable -> Lce
            return r11
        Lcc:
            r1 = r0
            goto Ld4
        Lce:
            r11 = move-exception
            r11.printStackTrace()
            java.lang.String r1 = "KWE_PE"
        Ld4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
