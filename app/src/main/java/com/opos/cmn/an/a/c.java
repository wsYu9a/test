package com.opos.cmn.an.a;

import com.baidu.mobads.sdk.internal.bu;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r10) {
        /*
            java.lang.String r0 = "md5File"
            java.lang.String r1 = "Md5Tool"
            java.lang.String r2 = ""
            if (r10 == 0) goto L8f
            boolean r3 = r10.isFile()
            if (r3 == 0) goto L8f
            boolean r3 = r10.exists()
            if (r3 == 0) goto L8f
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]
            r4 = 0
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r6.<init>(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
        L24:
            int r4 = r6.read(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7 = -1
            r8 = 0
            if (r7 == r4) goto L30
            r5.update(r3, r8, r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L24
        L30:
            byte[] r3 = r5.digest()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r4 = r3.length     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L35:
            if (r8 >= r4) goto L69
            r5 = r3[r8]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r5 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r7 = r5.length()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r9 = 1
            if (r7 != r9) goto L57
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7.<init>()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            java.lang.String r9 = "0"
            r7.append(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7.append(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L57:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7.<init>()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7.append(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7.append(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r8 = r8 + 1
            goto L35
        L69:
            r6.close()     // Catch: java.io.IOException -> L6d
            goto L8f
        L6d:
            r3 = move-exception
            com.opos.cmn.an.f.a.c(r1, r0, r3)
            goto L8f
        L72:
            r10 = move-exception
            r4 = r6
            goto L84
        L75:
            r3 = move-exception
            r4 = r6
            goto L7b
        L78:
            r10 = move-exception
            goto L84
        L7a:
            r3 = move-exception
        L7b:
            com.opos.cmn.an.f.a.c(r1, r0, r3)     // Catch: java.lang.Throwable -> L78
            if (r4 == 0) goto L8f
            r4.close()     // Catch: java.io.IOException -> L6d
            goto L8f
        L84:
            if (r4 == 0) goto L8e
            r4.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r2 = move-exception
            com.opos.cmn.an.f.a.c(r1, r0, r2)
        L8e:
            throw r10
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "md5File file="
            r0.append(r3)
            if (r10 == 0) goto La0
            java.lang.String r10 = r10.getAbsolutePath()
            goto La2
        La0:
            java.lang.String r10 = "null"
        La2:
            r0.append(r10)
            java.lang.String r10 = ",md5="
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            com.opos.cmn.an.f.a.b(r1, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.a.c.a(java.io.File):java.lang.String");
    }

    public static String a(String str) {
        String a2 = !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
        StringBuilder sb = new StringBuilder();
        sb.append("md5 before=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",md5 after=");
        sb.append(a2);
        com.opos.cmn.an.f.a.b("Md5Tool", sb.toString());
        return a2;
    }

    public static String a(byte[] bArr) {
        String str = "";
        if (bArr != null) {
            try {
                for (byte b2 : MessageDigest.getInstance(bu.f5659a).digest(bArr)) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str = str + hexString;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("md5 before=");
        sb.append(bArr != null ? new String(bArr) : "null");
        sb.append(",md5 after=");
        sb.append(str);
        com.opos.cmn.an.f.a.b("Md5Tool", sb.toString());
        return str;
    }

    public static String b(String str) {
        String a2 = !com.opos.cmn.an.c.a.a(str) ? a(new File(str)) : "";
        StringBuilder sb = new StringBuilder();
        sb.append("md5File file=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",md5=");
        sb.append(a2);
        com.opos.cmn.an.f.a.b("Md5Tool", sb.toString());
        return a2;
    }
}
