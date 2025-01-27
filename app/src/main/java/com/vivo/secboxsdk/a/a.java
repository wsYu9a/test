package com.vivo.secboxsdk.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a {
    public static String a(Map<String, String> map) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = (String) arrayList.get(i2);
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str)) {
                str = URLEncoder.encode(str, "utf-8");
            }
            if (!TextUtils.isEmpty(str2)) {
                str2 = URLEncoder.encode(str2, "utf-8");
            }
            if (i2 == arrayList.size() - 1) {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
            } else {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        return URLEncoder.encode(sb.toString(), "utf-8");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
    
        if (r1 == null) goto L104;
     */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> a(java.lang.String r8) {
        /*
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto Lc
            return r0
        Lc:
            java.lang.String r1 = "?"
            boolean r1 = r8.contains(r1)
            r2 = 1
            r3 = 0
            r4 = 2
            if (r1 == 0) goto L25
            java.lang.String r1 = "[?]"
            java.lang.String[] r8 = r8.split(r1, r4)
            if (r8 == 0) goto L25
            int r1 = r8.length
            if (r4 != r1) goto L25
            r8 = r8[r2]
            goto L26
        L25:
            r8 = r3
        L26:
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L9d
            java.util.Scanner r1 = new java.util.Scanner     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r8 = "&"
            r1.useDelimiter(r8)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
        L36:
            boolean r8 = r1.hasNext()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            if (r8 == 0) goto L93
            java.lang.String r8 = r1.next()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            java.lang.String r5 = "="
            java.lang.String[] r8 = r8.split(r5, r4)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            int r5 = r8.length     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            r6 = -1000(0xfffffffffffffc18, float:NaN)
            if (r5 > r4) goto L68
            r5 = 0
            r5 = r8[r5]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            int r7 = r8.length     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            if (r7 != r2) goto L54
            java.lang.String r8 = ""
            goto L56
        L54:
            r8 = r8[r2]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
        L56:
            boolean r7 = r0.containsKey(r5)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            if (r7 != 0) goto L60
            r0.put(r5, r8)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            goto L36
        L60:
            com.vivo.secboxsdk.SecBoxCipherException r8 = new com.vivo.secboxsdk.SecBoxCipherException     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            java.lang.String r0 = "contain same key"
            r8.<init>(r0, r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            throw r8     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
        L68:
            com.vivo.secboxsdk.SecBoxCipherException r8 = new com.vivo.secboxsdk.SecBoxCipherException     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            java.lang.String r0 = "bad parameter"
            r8.<init>(r0, r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            throw r8     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
        L70:
            r8 = move-exception
            r3 = r1
            goto L97
        L73:
            r8 = move-exception
            goto L79
        L75:
            r8 = move-exception
            goto L97
        L77:
            r8 = move-exception
            r1 = r3
        L79:
            java.lang.String r0 = "secbox"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            java.lang.String r4 = "parseRequestParam"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L70
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L70
            r2.append(r8)     // Catch: java.lang.Throwable -> L70
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L70
            com.vivo.secboxsdk.a.b.b(r0, r8)     // Catch: java.lang.Throwable -> L70
            r0 = r3
            if (r1 == 0) goto L9d
        L93:
            r1.close()
            goto L9d
        L97:
            if (r3 == 0) goto L9c
            r3.close()
        L9c:
            throw r8
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.secboxsdk.a.a.a(java.lang.String):java.util.Map");
    }
}
