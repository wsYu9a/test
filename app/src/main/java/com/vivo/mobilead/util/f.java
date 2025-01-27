package com.vivo.mobilead.util;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ic.SystemUtils;

/* loaded from: classes4.dex */
public class f {
    public static String a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.f f2;
        if (bVar.j() == 2 || bVar.j() == 5 || bVar.j() == 6 || bVar.U()) {
            com.vivo.ad.model.q y = bVar.y();
            if (y != null) {
                return y.d();
            }
        } else if (bVar.j() == 8) {
            com.vivo.ad.model.u H = bVar.H();
            if (H != null) {
                return H.d();
            }
        } else if (bVar.j() == 1 && (f2 = bVar.f()) != null) {
            return f2.e();
        }
        return "";
    }

    public static String b(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return "";
        }
        if (bVar.j() == 2 || bVar.j() == 5 || bVar.j() == 6 || bVar.j() == 12 || bVar.U()) {
            com.vivo.ad.model.q y = bVar.y();
            return (y == null || TextUtils.isEmpty(y.b())) ? "" : y.b();
        }
        if (bVar.j() != 8) {
            return bVar.L();
        }
        com.vivo.ad.model.u H = bVar.H();
        return (H == null || TextUtils.isEmpty(H.b())) ? "" : H.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r4, com.vivo.ad.model.b r5) {
        /*
            com.vivo.ad.model.q r0 = r5.y()
            if (r0 == 0) goto Lf
            java.lang.String r0 = r0.a()
            boolean r4 = com.vivo.mobilead.util.j.b(r4, r0)
            goto L10
        Lf:
            r4 = 0
        L10:
            int r0 = r5.j()
            r1 = 2
            r2 = 6
            r3 = 5
            if (r0 == r1) goto L47
            int r0 = r5.j()
            if (r0 == r3) goto L47
            int r0 = r5.j()
            if (r0 != r2) goto L26
            goto L47
        L26:
            int r0 = r5.j()
            r1 = 9
            if (r0 != r1) goto L34
            if (r4 == 0) goto L31
            goto L5c
        L31:
            java.lang.String r4 = "预约"
            goto L64
        L34:
            int r4 = r5.j()
            r0 = 1
            if (r4 != r0) goto L3c
            goto L5f
        L3c:
            int r4 = r5.j()
            r5 = 8
            if (r4 != r5) goto L5f
            java.lang.String r4 = "秒开"
            goto L64
        L47:
            if (r4 == 0) goto L62
            int r4 = r5.j()
            if (r4 == r3) goto L5f
            int r4 = r5.j()
            if (r4 != r2) goto L56
            goto L5f
        L56:
            com.vivo.ad.model.r r4 = r5.z()
            if (r4 != 0) goto L5f
        L5c:
            java.lang.String r4 = "打开"
            goto L64
        L5f:
            java.lang.String r4 = "查看"
            goto L64
        L62:
            java.lang.String r4 = "安装"
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.f.c(android.content.Context, com.vivo.ad.model.b):java.lang.String");
    }

    public static boolean c(com.vivo.ad.model.b bVar) {
        return (bVar == null || bVar.j() != 12 || TextUtils.isEmpty(bVar.v())) ? false : true;
    }

    public static String a(Context context, com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.q y;
        if (context == null || bVar == null) {
            return "";
        }
        if (!bVar.b0() && !bVar.Z() && !bVar.a0() && (y = bVar.y()) != null) {
            if (bVar.U()) {
                if (!j.b(context, y.e())) {
                    return "立即预约";
                }
            } else if (j.b(context, y.a())) {
                com.vivo.ad.model.r z = bVar.z();
                if (z == null || 1 != z.a()) {
                }
            } else {
                if (!SystemUtils.isVivoPhone()) {
                    String k = y.k();
                    String a2 = y.a();
                    if (!y.t() && !TextUtils.isEmpty(k) && com.vivo.mobilead.c.d.a(com.vivo.mobilead.manager.f.j().c(), a2, y.q())) {
                        return "点击安装";
                    }
                }
                return "立即下载";
            }
            return "立即打开";
        }
        return "查看详情";
    }

    public static int b(Context context, com.vivo.ad.model.b bVar) {
        if (context == null || bVar == null) {
            return -1;
        }
        if (!bVar.b0() && !bVar.Z()) {
            com.vivo.ad.model.q y = bVar.y();
            if (y == null) {
                return -1;
            }
            if (bVar.U()) {
                if (!j.b(context, y.e())) {
                    return 4;
                }
            } else {
                if (!j.b(context, y.a())) {
                    return 1;
                }
                com.vivo.ad.model.r z = bVar.z();
                if (z == null || 1 != z.a()) {
                }
            }
            return 2;
        }
        return 3;
    }
}
