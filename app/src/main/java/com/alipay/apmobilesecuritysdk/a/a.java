package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public Context f6433a;

    /* renamed from: b */
    public com.alipay.apmobilesecuritysdk.b.a f6434b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* renamed from: c */
    public int f6435c = 4;

    public a(Context context) {
        this.f6433a = context;
    }

    public static String b(Context context) {
        try {
            String b10 = i.b();
            if (!t3.a.c(b10)) {
                return b10;
            }
            c b11 = d.b(context);
            if (b11 != null) {
                i.a(b11);
                String str = b11.f6443a;
                if (t3.a.f(str)) {
                    return str;
                }
            }
            b b12 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b12 == null) {
                return "";
            }
            i.a(b12);
            String str2 = b12.f6440a;
            return t3.a.f(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bd, code lost:
    
        if (t3.a.c(b(r9.f6433a)) != false) goto L213;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0203 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00c2, B:15:0x01e9, B:17:0x0203, B:19:0x020b, B:21:0x0211, B:23:0x0217, B:25:0x021d, B:31:0x00da, B:33:0x00f2, B:38:0x00ff, B:39:0x010f, B:40:0x0116, B:45:0x0128, B:47:0x0178, B:49:0x0182, B:50:0x018a, B:52:0x0197, B:54:0x01a1, B:55:0x01a9, B:56:0x01a5, B:57:0x0186, B:59:0x0056, B:61:0x0064, B:64:0x0072, B:66:0x0078, B:69:0x0083, B:72:0x008c, B:75:0x0099, B:79:0x00a6, B:82:0x00b3), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x020b A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00c2, B:15:0x01e9, B:17:0x0203, B:19:0x020b, B:21:0x0211, B:23:0x0217, B:25:0x021d, B:31:0x00da, B:33:0x00f2, B:38:0x00ff, B:39:0x010f, B:40:0x0116, B:45:0x0128, B:47:0x0178, B:49:0x0182, B:50:0x018a, B:52:0x0197, B:54:0x01a1, B:55:0x01a9, B:56:0x01a5, B:57:0x0186, B:59:0x0056, B:61:0x0064, B:64:0x0072, B:66:0x0078, B:69:0x0083, B:72:0x008c, B:75:0x0099, B:79:0x00a6, B:82:0x00b3), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00c2, B:15:0x01e9, B:17:0x0203, B:19:0x020b, B:21:0x0211, B:23:0x0217, B:25:0x021d, B:31:0x00da, B:33:0x00f2, B:38:0x00ff, B:39:0x010f, B:40:0x0116, B:45:0x0128, B:47:0x0178, B:49:0x0182, B:50:0x018a, B:52:0x0197, B:54:0x01a1, B:55:0x01a9, B:56:0x01a5, B:57:0x0186, B:59:0x0056, B:61:0x0064, B:64:0x0072, B:66:0x0078, B:69:0x0083, B:72:0x008c, B:75:0x0099, B:79:0x00a6, B:82:0x00b3), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }

    public static String a(Context context) {
        String b10 = b(context);
        return t3.a.c(b10) ? h.f(context) : b10;
    }

    private o2.c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b b10;
        b c10;
        String str4 = "";
        try {
            Context context = this.f6433a;
            o2.d dVar = new o2.d();
            String b11 = t3.a.b(map, "appName", "");
            String b12 = t3.a.b(map, "sessionId", "");
            String b13 = t3.a.b(map, "rpcVersion", "");
            String a10 = a(context, b11);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d10 = h.d(context);
            if (t3.a.f(b12)) {
                dVar.f29020c = b12;
            } else {
                dVar.f29020c = a10;
            }
            dVar.f29021d = securityToken;
            dVar.f29022e = d10;
            dVar.f29018a = "android";
            c c11 = d.c(context);
            if (c11 != null) {
                str2 = c11.f6443a;
                str = c11.f6445c;
            } else {
                str = "";
                str2 = str;
            }
            if (t3.a.c(str2) && (c10 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c10.f6440a;
                str = c10.f6442c;
            }
            c b14 = d.b();
            if (b14 != null) {
                str4 = b14.f6443a;
                str3 = b14.f6445c;
            } else {
                str3 = "";
            }
            if (t3.a.c(str4) && (b10 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b10.f6440a;
                str3 = b10.f6442c;
            }
            dVar.f29025h = str2;
            dVar.f29024g = str4;
            dVar.f29027j = b13;
            if (t3.a.c(str2)) {
                dVar.f29019b = str4;
                str = str3;
            } else {
                dVar.f29019b = str2;
            }
            dVar.f29026i = str;
            dVar.f29023f = e.a(context, map);
            return k2.d.c(this.f6433a, this.f6434b.c()).a(dVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th2);
            return null;
        }
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a10 = i.a(str);
            if (!t3.a.c(a10)) {
                return a10;
            }
            String a11 = g.a(context, str);
            i.a(str, a11);
            return !t3.a.c(a11) ? a11 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i10 = 0; i10 < 5; i10++) {
                String str = strArr[i10];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = (int) (Math.random() * 24.0d * 60.0d * 60.0d);
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                String[] split = strArr[i10].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
