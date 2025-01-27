package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class br {

    /* renamed from: a */
    public static final String f9137a = "weapon.set";

    /* renamed from: e */
    private static String f9141e;

    /* renamed from: b */
    private static String f9138b = c.b("Y29tLmt3YWkud2VhcG9u", 2);

    /* renamed from: c */
    private static String f9139c = c.b(f9139c, 2);

    /* renamed from: c */
    private static String f9139c = c.b(f9139c, 2);

    /* renamed from: d */
    private static String f9140d = c.b(f9140d, 2);

    /* renamed from: d */
    private static String f9140d = c.b(f9140d, 2);

    private br() {
    }

    public static synchronized String a(Context context) {
        synchronized (br.class) {
            if (!TextUtils.isEmpty(f9141e)) {
                return f9141e;
            }
            String c2 = c(context);
            f9141e = c2;
            return c2;
        }
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context, String str) {
        c(context, str);
        d(context, str);
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext());
    }

    private static String c(Context context) {
        String e2 = e(context);
        if (!TextUtils.isEmpty(e2)) {
            return e2;
        }
        String d2 = d(context);
        if (!TextUtils.isEmpty(d2)) {
            b(context, d2);
        }
        return d2;
    }

    private static void c(Context context, String str) {
        try {
            if (b(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, f9139c, str);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                Settings.System.putString(contentResolver, f9137a, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0002, B:8:0x001f, B:11:0x002e, B:16:0x004a, B:18:0x0050, B:20:0x005a, B:25:0x0046, B:26:0x0026, B:27:0x001b), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0026 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0002, B:8:0x001f, B:11:0x002e, B:16:0x004a, B:18:0x0050, B:20:0x005a, B:25:0x0046, B:26:0x0026, B:27:0x001b), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "re_po_rt"
            com.kuaishou.weapon.p0.h r1 = com.kuaishou.weapon.p0.h.a(r5, r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.e(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.e(r3)     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L1b
            if (r1 == 0) goto L19
            goto L1b
        L19:
            r3 = r0
            goto L1f
        L1b:
            java.lang.String r3 = com.kuaishou.weapon.p0.bg.f(r5)     // Catch: java.lang.Throwable -> L93
        L1f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L93
            if (r4 != 0) goto L26
            goto L2e
        L26:
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L93
        L2e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.Throwable -> L93
            r4.append(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = com.kuaishou.weapon.p0.br.f9138b     // Catch: java.lang.Throwable -> L93
            r4.append(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L46
            if (r1 == 0) goto L44
            goto L46
        L44:
            r1 = r0
            goto L4a
        L46:
            java.lang.String r1 = com.kuaishou.weapon.p0.bg.c(r5)     // Catch: java.lang.Throwable -> L93
        L4a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L58
            java.lang.String r2 = "RISK"
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L5a
        L58:
            java.lang.String r1 = "0"
        L5a:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L93
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuffer r1 = r2.reverse()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = com.kuaishou.weapon.p0.f.a(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r3.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> L93
            r3.append(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> L93
            r3.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L93
            com.kuaishou.weapon.p0.bm r2 = new com.kuaishou.weapon.p0.bm     // Catch: java.lang.Throwable -> L93
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L93
            java.lang.String r5 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r5 = r2.a(r1, r5)     // Catch: java.lang.Throwable -> L93
            return r5
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.br.d(android.content.Context):java.lang.String");
    }

    private static void d(Context context, String str) {
        de.a(context).c(str);
    }

    private static String e(Context context) {
        String a2 = a(context, f9139c);
        String f2 = f(context);
        if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, f2)) {
            return a2;
        }
        if (!TextUtils.isEmpty(a2)) {
            d(context, a2);
            return a2;
        }
        if (TextUtils.isEmpty(f2)) {
            return "";
        }
        c(context, f2);
        return f2;
    }

    private static String f(Context context) {
        try {
            return de.a(context).d();
        } catch (Exception unused) {
            return "";
        }
    }
}
