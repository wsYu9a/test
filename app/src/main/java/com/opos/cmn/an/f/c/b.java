package com.opos.cmn.an.f.c;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.opos.cmn.an.f.a.b.d;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f16475a = b("ZGVidWcuY29tLm9wb3MuY21uLmxvZw==");

    /* renamed from: b */
    private static String f16476b = "localId";

    /* renamed from: c */
    private static volatile String f16477c = "";

    private static String a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j2));
        } catch (Exception unused) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x0028
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 >= r2) goto L2d
            if (r3 == 0) goto L28
            boolean r0 = com.opos.cmn.an.f.a.f.a(r3)     // Catch: java.lang.Exception -> L28
            if (r0 == 0) goto L21
            b.c.a.b.f r0 = b.c.a.b.f.f4313d     // Catch: java.lang.Exception -> L28
            java.util.Map r3 = r0.a(r3)     // Catch: java.lang.Exception -> L28
            if (r3 == 0) goto L28
            java.lang.String r0 = com.opos.cmn.an.f.c.b.f16476b     // Catch: java.lang.Exception -> L28
            java.lang.Object r3 = r3.get(r0)     // Catch: java.lang.Exception -> L28
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L28
            goto L29
        L21:
            b.c.a.b.f r0 = b.c.a.b.f.f4313d     // Catch: java.lang.Exception -> L28
            java.lang.String r3 = r0.b(r3)     // Catch: java.lang.Exception -> L28
            goto L29
        L28:
            r3 = r1
        L29:
            if (r3 != 0) goto L2c
            goto L2d
        L2c:
            r1 = r3
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.c.b.a(android.content.Context):java.lang.String");
    }

    public static String a(d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(dVar.f16423a);
        sb.append("][");
        sb.append(a(dVar.f16429g));
        sb.append("][");
        sb.append(Process.myPid());
        sb.append("][");
        sb.append(dVar.f16428f);
        sb.append(":");
        sb.append(dVar.f16427e);
        sb.append("]:");
        if (dVar.f16430h == 2) {
            Object[] objArr = (Object[]) dVar.f16424b;
            int length = objArr.length;
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    sb.append(objArr[i2]);
                    if (i2 < length - 1) {
                        sb.append(",");
                    }
                }
            }
        } else {
            sb.append(dVar.f16424b);
        }
        if (dVar.f16425c != null) {
            sb.append("\n");
            sb.append(Log.getStackTraceString(dVar.f16425c));
        }
        return sb.toString();
    }

    public static String a(String str) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return "";
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, EnvironmentCompat.MEDIA_UNKNOWN);
            return str2 != null ? str2 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a() {
        String a2 = a(f16475a);
        return !TextUtils.isEmpty(a2) && a2.contentEquals("true");
    }

    public static String b(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
    }

    public static boolean b() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String c() {
        if (TextUtils.isEmpty(f16477c)) {
            f16477c = d();
            if (TextUtils.isEmpty(f16477c)) {
                f16477c = e();
            }
            if (TextUtils.isEmpty(f16477c)) {
                f16477c = f();
            }
        }
        return f16477c;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String e() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r1 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String f() {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L4f
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r3.<init>()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r4 = "/cmdline"
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
            if (r2 != 0) goto L39
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
        L39:
            r1.close()     // Catch: java.lang.Exception -> L4f
            goto L4f
        L3d:
            goto L4c
        L3f:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L45
        L44:
            r1 = move-exception
        L45:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.lang.Exception -> L4a
        L4a:
            throw r1
        L4b:
            r1 = r0
        L4c:
            if (r1 == 0) goto L4f
            goto L39
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.c.b.f():java.lang.String");
    }
}
