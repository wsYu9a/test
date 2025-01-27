package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.text.TextUtils;
import com.vivo.ic.dm.Downloads;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class t {

    /* renamed from: a */
    private static Boolean f31109a;

    /* renamed from: b */
    private static String f31110b;

    public static com.vivo.push.model.b a(Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b f2;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b d2 = d(applicationContext);
        if (d2 != null) {
            p.d("PushPackageUtils", "get system push info :".concat(String.valueOf(d2)));
            return d2;
        }
        List<String> e2 = e(applicationContext);
        com.vivo.push.model.b f3 = f(applicationContext, applicationContext.getPackageName());
        if (e2.size() <= 0) {
            if (f3 != null && f3.d()) {
                d2 = f3;
            }
            p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar2 = null;
            String a2 = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (bVar = f(applicationContext, a2)) == null || !bVar.d()) {
                bVar = null;
            }
            if (f3 == null || !f3.d()) {
                f3 = null;
            }
            if (bVar == null) {
                bVar = null;
            }
            if (f3 == null || (bVar != null && (!f3.c() ? !(bVar.c() || f3.b() > bVar.b()) : !(bVar.c() && f3.b() > bVar.b())))) {
                f3 = bVar;
            }
            HashMap hashMap = new HashMap();
            if (f3 == null) {
                f3 = null;
            } else if (f3.c()) {
                bVar2 = f3;
                f3 = null;
            }
            int size = e2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = e2.get(i2);
                if (!TextUtils.isEmpty(str) && (f2 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f2);
                    if (f2.d()) {
                        if (f2.c()) {
                            if (bVar2 == null || f2.b() > bVar2.b()) {
                                bVar2 = f2;
                            }
                        } else if (f3 == null || f2.b() > f3.b()) {
                            f3 = f2;
                        }
                    }
                }
            }
            if (f3 != null) {
                d2 = f3;
            } else {
                p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                d2 = bVar2;
            }
        }
        if (d2 == null) {
            p.b(applicationContext, "查找最优包为空!");
            p.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (d2.c()) {
            p.a(applicationContext, "查找最优包为:" + d2.a() + "(" + d2.b() + ", Black)");
            p.d("PushPackageUtils", "finSuitablePushPackage" + d2.a() + "(" + d2.b() + ", Black)");
        } else {
            p.a(applicationContext, "查找最优包为:" + d2.a() + "(" + d2.b() + ")");
            p.d("PushPackageUtils", "finSuitablePushPackage" + d2.a() + "(" + d2.b() + ")");
        }
        return d2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0097 -> B:27:0x00af). Please report as a decompilation issue!!! */
    public static String b(Context context) {
        String str;
        Cursor query;
        if (!TextUtils.isEmpty(f31110b)) {
            return f31110b;
        }
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            p.a("PushPackageUtils", "close", e2);
        }
        try {
            try {
                query = context.getContentResolver().query(com.vivo.push.p.f31044a, null, null, null, null);
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            try {
                if (query != null) {
                    boolean z = false;
                    str = null;
                    while (query.moveToNext()) {
                        try {
                            if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                                str = query.getString(query.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE));
                            } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                                z = Boolean.parseBoolean(query.getString(query.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE)));
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    f31110b = str;
                    if (TextUtils.isEmpty(str)) {
                        try {
                            query.close();
                        } catch (Exception e5) {
                            p.a("PushPackageUtils", "close", e5);
                        }
                        return null;
                    }
                    if (z) {
                        query.close();
                        return str;
                    }
                    try {
                        query.close();
                    } catch (Exception e6) {
                        p.a("PushPackageUtils", "close", e6);
                    }
                    return null;
                }
                try {
                    p.a("PushPackageUtils", "cursor is null");
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e7) {
                            p.a("PushPackageUtils", "close", e7);
                        }
                    }
                    return null;
                } catch (Exception e8) {
                    e = e8;
                    str = null;
                }
                cursor = query;
                return str;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e9) {
                        p.a("PushPackageUtils", "close", e9);
                    }
                }
                throw th;
            }
            p.a("PushPackageUtils", "getSystemPush", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    private static com.vivo.push.model.b d(Context context) {
        String b2 = b(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(b2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(z.a(context, b2));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, b2));
            return bVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(z.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (Exception e2) {
                    p.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                p.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    public static boolean c(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f31109a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f31109a = valueOf;
        return valueOf.booleanValue();
    }

    private static List<String> e(Context context) {
        List<ResolveInfo> list;
        g.a("findAllCoreClientPush");
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResolveInfo resolveInfo = list.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            p.d("PushPackageUtils", "get all push packages is null");
        }
        return arrayList;
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static int b(Context context, String str) {
        int i2 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i2;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i2);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
            p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j2) {
        com.vivo.push.cache.d a2 = com.vivo.push.cache.b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j2);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}
