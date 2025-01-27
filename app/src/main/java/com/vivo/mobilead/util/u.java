package com.vivo.mobilead.util;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ic.SystemUtils;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.unified.base.view.j;

/* loaded from: classes4.dex */
public class u {

    static class a implements j.d {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30777a;

        a(com.vivo.ad.model.b bVar) {
            this.f30777a = bVar;
        }

        @Override // com.vivo.mobilead.unified.base.view.j.d
        public void a() {
            com.vivo.mobilead.c.b.e().a(this.f30777a);
            k0.b(this.f30777a, 0, "");
        }

        @Override // com.vivo.mobilead.unified.base.view.j.d
        public void cancel() {
        }
    }

    public interface b {
        boolean a(com.vivo.ad.model.b bVar, boolean z);
    }

    private static int a(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        return i2 == 4 ? 3 : -1;
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, String str, String str2, BackUrlInfo backUrlInfo, int i2, int i3) {
        return a(context, bVar, z, z2, -1, -1, str, str2, backUrlInfo, i2, i3, null);
    }

    private static int b(Context context, com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, int i4, int i5) {
        return a(context, bVar, i2, i3, str, str2, backUrlInfo, true, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(android.content.Context r16, com.vivo.ad.model.b r17, int r18, int r19, java.lang.String r20, java.lang.String r21, com.vivo.mobilead.model.BackUrlInfo r22, int r23, int r24) {
        /*
            com.vivo.ad.model.g r1 = r17.g()
            r2 = 1
            r5 = 0
            java.lang.String r6 = ""
            if (r1 == 0) goto L95
            com.vivo.mobilead.manager.g r3 = com.vivo.mobilead.manager.g.a(r16)
            java.lang.String r0 = r17.S()
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L8e
            boolean r0 = r3.a()
            if (r0 != 0) goto L27
            r2 = 3
            java.lang.String r6 = "目标应用未安装"
            r10 = 3
        L22:
            r7 = r16
            r11 = r6
            goto L99
        L27:
            java.lang.String r0 = r1.f26892a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L34
            r2 = 2
            java.lang.String r6 = "找不到跳转目标"
            r10 = 2
            goto L22
        L34:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L67
            r4 = 29
            if (r0 != r4) goto L64
            android.content.pm.PackageManager r0 = r16.getPackageManager()     // Catch: java.lang.Exception -> L67
            java.lang.String r4 = "com.tencent.mm"
            android.content.Intent r0 = r0.getLaunchIntentForPackage(r4)     // Catch: java.lang.Exception -> L67
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> L67
            java.lang.String r7 = "android.intent.action.MAIN"
            r4.<init>(r7)     // Catch: java.lang.Exception -> L67
            java.lang.String r7 = "android.intent.category.LAUNCHER"
            r4.addCategory(r7)     // Catch: java.lang.Exception -> L67
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r4.addFlags(r7)     // Catch: java.lang.Exception -> L67
            android.content.ComponentName r0 = r0.getComponent()     // Catch: java.lang.Exception -> L67
            r4.setComponent(r0)     // Catch: java.lang.Exception -> L67
            r7 = r16
            r7.startActivity(r4)     // Catch: java.lang.Exception -> L62
            goto L73
        L62:
            r0 = move-exception
            goto L6a
        L64:
            r7 = r16
            goto L73
        L67:
            r0 = move-exception
            r7 = r16
        L6a:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r4 = "JumpUtil"
            com.vivo.mobilead.util.x0.b(r4, r0)
        L73:
            boolean r0 = r3.a(r1)
            if (r0 != 0) goto L7f
            r2 = 4
            java.lang.String r6 = "跳转失败，出现异常"
            r11 = r6
            r10 = 4
            goto L99
        L7f:
            r4 = 0
            r3 = r17
            r7 = r20
            r8 = r18
            r9 = r19
            r10 = r21
            com.vivo.mobilead.util.k0.b(r3, r4, r5, r6, r7, r8, r9, r10)
            return r2
        L8e:
            r7 = r16
            java.lang.String r6 = "SDK不支持跳转"
            r11 = r6
            r10 = 1
            goto L99
        L95:
            r7 = r16
            r11 = r6
            r10 = 0
        L99:
            if (r10 == 0) goto Lbb
            r9 = 1
            r8 = r17
            r12 = r20
            r13 = r18
            r14 = r19
            r15 = r21
            com.vivo.mobilead.util.k0.b(r8, r9, r10, r11, r12, r13, r14, r15)
            int r12 = a(r18)
            r9 = 0
            r7 = r16
            r10 = r22
            r11 = r20
            r13 = r23
            r14 = r24
            com.vivo.mobilead.util.j.a(r7, r8, r9, r10, r11, r12, r13, r14)
        Lbb:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.u.c(android.content.Context, com.vivo.ad.model.b, int, int, java.lang.String, java.lang.String, com.vivo.mobilead.model.BackUrlInfo, int, int):int");
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, String str, String str2, BackUrlInfo backUrlInfo, int i2, int i3, b bVar2) {
        return a(context, bVar, z, z2, -1, -1, str, str2, backUrlInfo, i2, i3, bVar2);
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, int i4, int i5) {
        return a(context, bVar, z, z2, i2, i3, str, str2, backUrlInfo, i4, i5, null);
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, int i4, int i5, b bVar2) {
        x0.a("JumpUtil", "start dealClick" + z2);
        if (bVar == null) {
            return -1;
        }
        int j2 = bVar.j();
        if (j2 != 1) {
            if (j2 != 2 && j2 != 5 && j2 != 6) {
                switch (j2) {
                    case 8:
                        return a(context, bVar, i2, i3, str, str2, backUrlInfo, -1, i4);
                    case 9:
                        return a(context, bVar, i2, str, i4, i5);
                    case 10:
                        return a(context, bVar, z2, i4, i5, i2, backUrlInfo, str);
                    case 11:
                        return c(context, bVar, i2, i3, str, str2, backUrlInfo, i4, i5);
                    case 12:
                        break;
                    default:
                        return -1;
                }
            }
            return a(context, bVar, z, z2, i2, i3, str, str2, backUrlInfo, -1, i4, i5, bVar2);
        }
        return b(context, bVar, i2, i3, str, str2, backUrlInfo, i4, i5);
    }

    private static int a(Context context, com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, BackUrlInfo backUrlInfo, String str) {
        l a2 = j.a(context, bVar, backUrlInfo, i2);
        if (a2.f30720b) {
            k0.a(bVar, 3, 1, "", str);
            return 1;
        }
        k0.a(bVar, 3, 2, a2.f30719a, str);
        j.a(context, bVar, z, backUrlInfo, str, a(i4), i2, i3);
        return 0;
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, int i2, String str, int i3, int i4) {
        com.vivo.ad.model.q y = bVar.y();
        com.vivo.ad.model.r z = bVar.z();
        int i5 = 1;
        if (y != null && j.b(context, y.e())) {
            j.a(context, y.e(), bVar, str, String.valueOf(i4), String.valueOf(i3));
        } else {
            if (z != null && z.a() == 1) {
                l b2 = j.b(context, bVar, (BackUrlInfo) null, i3);
                if (b2 != null && b2.f30720b) {
                    k0.a(bVar, 2, 1, "", str);
                    i5 = 3;
                } else {
                    k0.a(bVar, 2, 2, b2.f30719a, str);
                }
            }
            i5 = -1;
        }
        if (i5 != -1 || TextUtils.isEmpty(bVar.v())) {
            return i5;
        }
        j.a(context, bVar, false, null, str, a(i2), i3, i4);
        return 0;
    }

    private static int a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, int i4, int i5, int i6, b bVar2) {
        com.vivo.ad.model.r z3 = bVar.z();
        if (SystemUtils.isVivoPhone()) {
            if (z3 != null && 1 == z3.a()) {
                l b2 = j.b(context, bVar, backUrlInfo, i5);
                if (b2.f30720b) {
                    k0.a(bVar, 0, 0, "", str, i2, i3, str2);
                    return 1;
                }
                k0.a(bVar, 1, b2.f30721c, b2.f30719a, str, i2, i3, str2);
                return a(context, bVar, z, str, backUrlInfo, a(i2), i4, i5, i6, bVar2);
            }
            return a(context, bVar, z, str, backUrlInfo, a(i2), i4, i5, i6, bVar2);
        }
        if (z3 != null && 1 == z3.a()) {
            l b3 = j.b(context, bVar, backUrlInfo, i5);
            if (b3.f30720b) {
                k0.a(bVar, 0, 0, "", str, i2, i3, str2);
                return 1;
            }
            k0.a(bVar, 1, b3.f30721c, b3.f30719a, str, i2, i3, str2);
            return a(context, bVar, str, i6, i5, a(i2), 1, backUrlInfo, z, bVar2, z2);
        }
        return a(context, bVar, str, i6, i5, a(i2), 1, backUrlInfo, z, bVar2, z2);
    }

    private static int a(Context context, com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, boolean z, int i4, int i5) {
        com.vivo.ad.model.r z2 = bVar.z();
        if (z2 != null && 1 == z2.a()) {
            l b2 = j.b(context, bVar, backUrlInfo, i4);
            if (b2.f30720b) {
                k0.a(bVar, 0, 0, "", str, i2, i3, str2);
                return 1;
            }
            k0.a(bVar, 1, b2.f30721c, b2.f30719a, str, i2, i3, str2);
            j.a(context, bVar, false, backUrlInfo, str, a(i2), i4, i5);
        } else {
            j.a(context, bVar, false, backUrlInfo, str, a(i2), i4, i5);
        }
        return 0;
    }

    private static int a(Context context, com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, BackUrlInfo backUrlInfo, int i4, int i5) {
        com.vivo.ad.model.r z = bVar.z();
        if (z != null && 1 == z.a()) {
            l b2 = j.b(context, bVar, backUrlInfo, i5);
            if (b2.f30720b) {
                k0.a(bVar, 0, 0, "", str, i2, i3, str2);
                return 1;
            }
            k0.a(bVar, 1, b2.f30721c, b2.f30719a, str, i2, i3, str2);
            return a(context, bVar, i2, i3, str, str2, i4, i5);
        }
        return a(context, bVar, i2, i3, str, str2, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(android.content.Context r7, com.vivo.ad.model.b r8, int r9, int r10, java.lang.String r11, java.lang.String r12, int r13, int r14) {
        /*
            com.vivo.ad.model.v r0 = r8.I()
            r6 = 1
            if (r0 == 0) goto L42
            int r1 = r0.a()
            if (r6 != r1) goto L42
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L36
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L36
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> L36
            java.lang.String r0 = r0.b()     // Catch: java.lang.Exception -> L36
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L36
            r1.setData(r0)     // Catch: java.lang.Exception -> L36
            com.vivo.mobilead.util.j.a(r1, r8)     // Catch: java.lang.Exception -> L36
            r7.startActivity(r1)     // Catch: java.lang.Exception -> L36
            r1 = 0
            r0 = r8
            r2 = r11
            r3 = r9
            r4 = r10
            r5 = r12
            com.vivo.mobilead.util.k0.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L36
            java.lang.String r0 = ""
            goto L45
        L36:
            r1 = 1
            r0 = r8
            r2 = r11
            r3 = r9
            r4 = r10
            r5 = r12
            com.vivo.mobilead.util.k0.a(r0, r1, r2, r3, r4, r5)
            java.lang.String r0 = "3006001"
            goto L44
        L42:
            java.lang.String r0 = "3006000"
        L44:
            r6 = r13
        L45:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L52
            java.lang.String r1 = java.lang.String.valueOf(r14)
            com.vivo.mobilead.util.w.f(r8, r0, r1)
        L52:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.u.a(android.content.Context, com.vivo.ad.model.b, int, int, java.lang.String, java.lang.String, int, int):int");
    }

    private static int a(Context context, com.vivo.ad.model.b bVar, boolean z, String str, BackUrlInfo backUrlInfo, int i2, int i3, int i4, int i5, b bVar2) {
        int j2 = bVar.j();
        com.vivo.ad.model.q y = bVar.y();
        if (j.b(context, y == null ? "" : y.a())) {
            if (y == null) {
                return i3;
            }
            j.a(context, y.a(), bVar, str, String.valueOf(i5), String.valueOf(i4));
            w.b(bVar, "3005002", String.valueOf(i4));
            return 1;
        }
        boolean z2 = j2 == 5 || j2 == 6;
        if (bVar2 != null && bVar2.a(bVar, z)) {
            return 0;
        }
        if (j2 != 2 && !z) {
            j.a(context, bVar, false, backUrlInfo, str, i2, i4, i5);
            return 0;
        }
        if (bVar.y() != null && bVar.y().m() == 1 && z2) {
            j.a(context, bVar, false, backUrlInfo, str, i2, i4, i5);
            return 0;
        }
        j.a(context, bVar, z, str, i4);
        return 2;
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, String str, int i2, int i3, int i4, int i5, BackUrlInfo backUrlInfo, boolean z) {
        return a(context, bVar, str, i2, i3, i4, i5, backUrlInfo, false, (b) null, z);
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, String str, int i2, int i3, int i4, int i5, BackUrlInfo backUrlInfo, boolean z, b bVar2, boolean z2) {
        if (bVar == null || bVar.y() == null) {
            return i5;
        }
        com.vivo.ad.model.q y = bVar.y();
        String a2 = y.a();
        if (j.b(context, a2)) {
            j.a(context, a2, bVar, str, String.valueOf(i2), String.valueOf(i3));
            return 1;
        }
        if (bVar2 != null && bVar2.a(bVar, z)) {
            return 0;
        }
        if (y.t()) {
            if (j.b(context, bVar, a2, str)) {
                return 1;
            }
            return a(context, bVar, backUrlInfo, str, i4, i5, i3, i2, z2);
        }
        return a(context, bVar, backUrlInfo, str, i4, i5, i3, i2, z2);
    }

    public static int a(Context context, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3, int i4, int i5, boolean z) {
        if (bVar == null || bVar.y() == null) {
            return i3;
        }
        com.vivo.ad.model.q y = bVar.y();
        String k = y.k();
        String a2 = y.a();
        if (TextUtils.isEmpty(k)) {
            j.a(context, bVar, false, backUrlInfo, str, i2, i4, i5);
            return 0;
        }
        boolean a3 = com.vivo.mobilead.c.d.a(com.vivo.mobilead.manager.f.j().c(), a2, y.q());
        if (z || com.vivo.mobilead.c.b.e().a(a2) || a3) {
            if (a3) {
                com.vivo.mobilead.c.b.e().b(bVar);
            } else if (!com.vivo.mobilead.c.b.e().b(a2)) {
                com.vivo.mobilead.c.b.e().a(bVar);
            } else {
                com.vivo.mobilead.unified.base.view.j jVar = new com.vivo.mobilead.unified.base.view.j(context);
                jVar.a(y.b());
                jVar.b();
                jVar.a(new a(bVar));
            }
        }
        return i3;
    }
}
