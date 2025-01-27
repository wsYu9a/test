package com.kwad.components.ad.h;

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
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.x;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.h.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;
        final /* synthetic */ com.kwad.sdk.f.a oM;

        public AnonymousClass1(Context context, com.kwad.sdk.f.a aVar) {
            context = context;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            aVar.accept(a.c(a.M(context)));
        }
    }

    @NonNull
    public static Map<String, AppPackageInfo> M(Context context) {
        ActivityInfo activityInfo;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (az.Om()) {
            try {
                List<String> On = az.On();
                if (On != null && !On.isEmpty()) {
                    Iterator it = new ArrayList(On).iterator();
                    while (it.hasNext()) {
                        try {
                            PackageInfo packageInfo = ao.getPackageInfo(context, (String) it.next(), 0);
                            if (packageInfo != null) {
                                AppPackageInfo a10 = a(packageInfo, packageManager);
                                a10.reportMethod = 3;
                                hashMap.put(a10.packageName, a10);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return hashMap;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && q.MZ()) {
            try {
                List<String> dB = bo.dB(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (dB != null && !dB.isEmpty()) {
                            dB.remove(str);
                        }
                        PackageInfo packageInfo2 = ao.getPackageInfo(context, str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a11 = a(packageInfo2, packageManager);
                            a11.reportMethod = 1;
                            hashMap.put(a11.packageName, a11);
                        }
                    }
                }
                if (dB != null && !dB.isEmpty()) {
                    Iterator<String> it2 = dB.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = ao.getPackageInfo(context, it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a12 = a(packageInfo3, packageManager);
                                a12.reportMethod = 2;
                                hashMap.put(a12.packageName, a12);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            hashMap.putAll(c(context, hVar.zS()));
        }
        return hashMap;
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
        if (packageManager != null && packageInfo.applicationInfo != null && ap.an(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th2) {
                c.printStackTraceOnly(th2);
            }
        }
        return appPackageInfo;
    }

    @NonNull
    public static JSONArray[] b(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        h hVar = (h) ServiceProvider.get(h.class);
        if (context == null || list == null || list.isEmpty() || hVar == null || !q.MZ()) {
            return jSONArrayArr;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = ao.getPackageInfo(context, str, 0);
                if (packageInfo != null) {
                    AppPackageInfo a10 = a(packageInfo, packageManager);
                    hashMap.put(a10.packageName, a10);
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
        jSONArrayArr[0] = c(hashMap);
        jSONArrayArr[1] = c(hashMap2);
        return jSONArrayArr;
    }

    @NonNull
    private static Map<String, AppPackageInfo> c(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = ao.getPackageInfo(context, str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a10 = a(packageInfo, packageManager);
                        hashMap.put(a10.packageName, a10);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    @NonNull
    public static JSONArray c(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    x.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
        return jSONArray;
    }

    public static void a(Context context, com.kwad.sdk.f.a<JSONArray> aVar) {
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.ad.h.a.1
            final /* synthetic */ Context hB;
            final /* synthetic */ com.kwad.sdk.f.a oM;

            public AnonymousClass1(Context context2, com.kwad.sdk.f.a aVar2) {
                context = context2;
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                aVar.accept(a.c(a.M(context)));
            }
        });
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, PushClientConstants.TAG_PKG_NAME, appPackageInfo.packageName);
        x.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        x.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        x.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        x.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        x.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        x.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
