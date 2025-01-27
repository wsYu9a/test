package com.vivo.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.dm.Downloads;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class z {

    /* renamed from: a */
    private static String[] f31124a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b */
    private static String[] f31125b = {"android.permission.INTERNET", com.kuaishou.weapon.p0.g.f9318c, com.kuaishou.weapon.p0.g.f9317b, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.kuaishou.weapon.p0.g.f9325j, com.kuaishou.weapon.p0.g.f9319d, "android.permission.WAKE_LOCK", com.kuaishou.weapon.p0.g.f9321f, "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.g.f9320e};

    /* renamed from: c */
    private static String[] f31126c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d */
    private static String[] f31127d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e */
    private static String[] f31128e = new String[0];

    /* renamed from: f */
    private static Map<String, Bundle> f31129f = new ConcurrentHashMap();

    public static long a(Context context) {
        String b2 = t.b(context);
        if (!TextUtils.isEmpty(b2)) {
            return a(context, b2);
        }
        p.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.app_id");
        if (a2 != null) {
            return a2.toString();
        }
        Object a3 = a(context, str, "app_id");
        return a3 != null ? a3.toString() : "";
    }

    public static String c(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : f31126c) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (f31128e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            for (String str2 : f31128e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : f31127d) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    public static PublicKey c(Context context) {
        Cursor query = context.getContentResolver().query(com.vivo.push.p.f31044a, null, null, null, null);
        if (query == null) {
            return null;
        }
        while (query.moveToNext()) {
            try {
                try {
                    if ("pushkey".equals(query.getString(query.getColumnIndex("name")))) {
                        String string = query.getString(query.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE));
                        p.d("Utility", "result key : ".concat(String.valueOf(string)));
                        PublicKey a2 = u.a(string);
                        try {
                            query.close();
                        } catch (Exception unused) {
                        }
                        return a2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        try {
            query.close();
        } catch (Exception unused3) {
        }
        return null;
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                p.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        p.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f4, code lost:
    
        r7 = r7 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r15) throws com.vivo.push.util.VivoPushException {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.z.b(android.content.Context):void");
    }

    public static boolean d(Context context) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            p.a("Utility", "close", e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                p.a("Utility", "isSupport", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e4) {
            p.a("Utility", "close", e4);
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        Cursor query = context.getContentResolver().query(com.vivo.push.p.f31045b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"323", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
        if (query == null) {
            p.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (query.moveToFirst() && (query.getInt(query.getColumnIndex("permission")) & 1) != 0) {
            try {
                query.close();
            } catch (Exception e6) {
                p.a("Utility", "close", e6);
            }
            return true;
        }
        query.close();
        return false;
    }

    public static Object a(Context context, String str, String str2) {
        Object obj;
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f31129f;
            Object obj2 = (map == null || map.size() <= 0 || (bundle = f31129f.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                obj = r0 != null ? r0.get(str2) : obj2;
            } catch (Exception e2) {
                e = e2;
                r0 = obj2;
            }
            try {
                if (f31129f.size() > 300) {
                    return obj;
                }
                f31129f.put(str, r0);
                return obj;
            } catch (Exception e3) {
                r0 = obj;
                e = e3;
                p.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                return r0;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f31124a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + intent + " has no services");
        } catch (Exception e2) {
            p.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean b(Context context, String str, String str2) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            p.a("Utility", "close", e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                p.a("Utility", "isOverdue", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e4) {
            p.a("Utility", "close", e4);
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        Cursor query = context.getContentResolver().query(com.vivo.push.p.f31046c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "323"}, null);
        if (query == null) {
            p.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (query.moveToFirst()) {
            boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
            try {
                query.close();
            } catch (Exception e6) {
                p.a("Utility", "close", e6);
            }
            return parseBoolean;
        }
        query.close();
        return false;
    }

    public static void a(Context context, Intent intent) {
        String b2 = t.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            p.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (b2.equals(context.getPackageName())) {
            p.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!b2.equals(stringExtra)) {
            p.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        p.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
    }
}
