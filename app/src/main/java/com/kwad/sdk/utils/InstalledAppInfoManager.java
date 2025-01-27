package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class InstalledAppInfoManager {

    /* renamed from: com.kwad.sdk.utils.InstalledAppInfoManager$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ com.kwad.sdk.e.a NX;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, com.kwad.sdk.e.a aVar) {
            context = context;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            aVar.accept(InstalledAppInfoManager.e(InstalledAppInfoManager.bM(context)));
        }
    }

    public static class AppPackageInfo implements Serializable {
        private static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null) {
            appPackageInfo.isSystemApp = a(applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && ak.ah(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        t.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        t.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        t.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        t.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        t.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        t.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    public static void a(Context context, com.kwad.sdk.e.a<JSONArray> aVar) {
        g.execute(new aw() { // from class: com.kwad.sdk.utils.InstalledAppInfoManager.1
            final /* synthetic */ com.kwad.sdk.e.a NX;
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2, com.kwad.sdk.e.a aVar2) {
                context = context2;
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                aVar.accept(InstalledAppInfoManager.e(InstalledAppInfoManager.bM(context)));
            }
        });
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    @NonNull
    public static Map<String, AppPackageInfo> bM(Context context) {
        ActivityInfo activityInfo;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (at.Eg()) {
            List<String> Eh = at.Eh();
            if (Eh != null && !Eh.isEmpty()) {
                Iterator it = new ArrayList(Eh).iterator();
                while (it.hasNext()) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo((String) it.next(), 0);
                        if (packageInfo != null) {
                            AppPackageInfo a2 = a(packageInfo, packageManager);
                            a2.reportMethod = 3;
                            hashMap.put(a2.packageName, a2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return hashMap;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null && o.CX()) {
            try {
                List<String> db = bd.db(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (db != null && !db.isEmpty()) {
                            db.remove(str);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a3 = a(packageInfo2, packageManager);
                            a3.reportMethod = 1;
                            hashMap.put(a3.packageName, a3);
                        }
                    }
                }
                if (db != null && !db.isEmpty()) {
                    Iterator<String> it2 = db.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a4 = a(packageInfo3, packageManager);
                                a4.reportMethod = 2;
                                hashMap.put(a4.packageName, a4);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            hashMap.putAll(d(context, fVar.sD()));
        }
        return hashMap;
    }

    @NonNull
    public static JSONArray[] c(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (context == null || list == null || list.isEmpty() || fVar == null || !o.CX()) {
            return jSONArrayArr;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    AppPackageInfo a2 = a(packageInfo, packageManager);
                    hashMap.put(a2.packageName, a2);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    hashMap2.put(str, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                hashMap2.put(str, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = e(hashMap);
        jSONArrayArr[1] = e(hashMap2);
        return jSONArrayArr;
    }

    @NonNull
    private static Map<String, AppPackageInfo> d(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a2 = a(packageInfo, packageManager);
                        hashMap.put(a2.packageName, a2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    @NonNull
    public static JSONArray e(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    t.putValue(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return jSONArray;
    }
}
