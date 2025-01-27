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
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class t {

    /* renamed from: a */
    private static Boolean f25145a;

    /* renamed from: b */
    private static String f25146b;

    public static com.vivo.push.model.b a(Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b f10;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b d10 = d(applicationContext);
        if (d10 != null) {
            p.d("PushPackageUtils", "get system push info :".concat(String.valueOf(d10)));
            return d10;
        }
        List<String> e10 = e(applicationContext);
        com.vivo.push.model.b f11 = f(applicationContext, applicationContext.getPackageName());
        if (e10.size() <= 0) {
            if (f11 != null && f11.d()) {
                d10 = f11;
            }
            p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar2 = null;
            String a10 = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a10) || !a(applicationContext, a10, "com.vivo.pushservice.action.METHOD") || (bVar = f(applicationContext, a10)) == null || !bVar.d()) {
                bVar = null;
            }
            if (f11 == null || !f11.d()) {
                f11 = null;
            }
            if (bVar == null) {
                bVar = null;
            }
            if (f11 == null || (bVar != null && (!f11.c() ? !(bVar.c() || f11.b() > bVar.b()) : !(bVar.c() && f11.b() > bVar.b())))) {
                f11 = bVar;
            }
            HashMap hashMap = new HashMap();
            if (f11 == null) {
                f11 = null;
            } else if (f11.c()) {
                bVar2 = f11;
                f11 = null;
            }
            int size = e10.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = e10.get(i10);
                if (!TextUtils.isEmpty(str) && (f10 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f10);
                    if (f10.d()) {
                        if (f10.c()) {
                            if (bVar2 == null || f10.b() > bVar2.b()) {
                                bVar2 = f10;
                            }
                        } else if (f11 == null || f10.b() > f11.b()) {
                            f11 = f10;
                        }
                    }
                }
            }
            if (f11 != null) {
                d10 = f11;
            } else {
                p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                d10 = bVar2;
            }
        }
        if (d10 == null) {
            p.b(applicationContext, "查找最优包为空!");
            p.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (d10.c()) {
            p.a(applicationContext, "查找最优包为:" + d10.a() + "(" + d10.b() + ", Black)");
            p.d("PushPackageUtils", "finSuitablePushPackage" + d10.a() + "(" + d10.b() + ", Black)");
        } else {
            p.a(applicationContext, "查找最优包为:" + d10.a() + "(" + d10.b() + ")");
            p.d("PushPackageUtils", "finSuitablePushPackage" + d10.a() + "(" + d10.b() + ")");
        }
        return d10;
    }

    public static String b(Context context) {
        String str;
        Cursor query;
        if (!TextUtils.isEmpty(f25146b)) {
            return f25146b;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    query = context.getContentResolver().query(com.vivo.push.p.f25080a, null, null, null, null);
                } catch (Exception e10) {
                    e = e10;
                    str = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            p.a("PushPackageUtils", "close", e11);
        }
        try {
            if (query != null) {
                boolean z10 = false;
                str = null;
                while (query.moveToNext()) {
                    try {
                        if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                            str = query.getString(query.getColumnIndex("value"));
                        } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                            z10 = Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                }
                f25146b = str;
                if (TextUtils.isEmpty(str)) {
                    try {
                        query.close();
                    } catch (Exception e13) {
                        p.a("PushPackageUtils", "close", e13);
                    }
                    return null;
                }
                if (z10) {
                    query.close();
                    return str;
                }
                try {
                    query.close();
                } catch (Exception e14) {
                    p.a("PushPackageUtils", "close", e14);
                }
                return null;
            }
            try {
                p.a("PushPackageUtils", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e15) {
                        p.a("PushPackageUtils", "close", e15);
                    }
                }
                return null;
            } catch (Exception e16) {
                e = e16;
                str = null;
            }
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            cursor = query;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e17) {
                    p.a("PushPackageUtils", "close", e17);
                }
            }
            throw th;
        }
        p.a("PushPackageUtils", "getSystemPush", e);
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    private static com.vivo.push.model.b d(Context context) {
        String b10 = b(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(b10);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b10, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(z.a(context, b10));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, b10));
            return bVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e10);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str) && (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE"))) {
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
            } catch (Exception e10) {
                p.a("PushPackageUtils", "getPushPackageInfo exception: ", e10);
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
                for (byte b10 : digest) {
                    String upperCase = Integer.toHexString(b10 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e10) {
                p.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e10)));
            }
        }
        return null;
    }

    public static boolean c(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f25145a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        boolean equals = "BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str));
        f25145a = Boolean.valueOf(equals);
        return equals;
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
            for (int i10 = 0; i10 < size; i10++) {
                ResolveInfo resolveInfo = list.get(i10);
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
        int i10 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i10;
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
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i10);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z11 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z11) {
                            boolean z12 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z10 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z12);
                        }
                    }
                }
                return z10;
            }
            p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j10) {
        com.vivo.push.cache.d a10 = com.vivo.push.cache.b.a().a(context);
        if (a10 != null) {
            return a10.isInBlackList(j10);
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
