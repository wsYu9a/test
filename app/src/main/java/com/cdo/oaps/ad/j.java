package com.cdo.oaps.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.base.launcher.OapsLog;
import com.cdo.oaps.ad.wrapper.VerifyWrapper;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class j implements l {

    /* renamed from: a */
    private static final String f6545a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";

    /* renamed from: b */
    private static final String f6546b = "b3Bwby9sYXVuY2g=";

    /* renamed from: c */
    private static final String f6547c = "com.nearme.gamecenter";

    /* renamed from: d */
    private static final String f6548d = "com.heytap.market";

    private static String a(Context context, OapsWrapper oapsWrapper) {
        String host = oapsWrapper.getHost();
        if (Launcher.Host.GC.equals(host)) {
            return f6547c;
        }
        if ("mk".equals(host)) {
            return p.b(context, "com.heytap.market") ? "com.heytap.market" : a.b();
        }
        if (Launcher.Host.MK_OP.equals(host)) {
            return a.a();
        }
        return null;
    }

    public static String a(String str, String str2) {
        return i.a(str + str2);
    }

    public static boolean a(Context context, Uri uri, String str) {
        Intent intent;
        List<ResolveInfo> queryIntentServices;
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            queryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str2 = resolveInfo.serviceInfo.packageName;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        ComponentName componentName = new ComponentName(str2, resolveInfo.serviceInfo.name);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        context.startService(intent2);
                        return true;
                    }
                } else if (!f6547c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName2 = new ComponentName(str2, resolveInfo.serviceInfo.name);
                    Intent intent22 = new Intent(intent);
                    intent22.setComponent(componentName2);
                    context.startService(intent22);
                    return true;
                }
                th.printStackTrace();
            }
        }
        return false;
    }

    private static boolean a(Context context, String str) {
        if ("com.heytap.market".equalsIgnoreCase(str) || a.b().equalsIgnoreCase(str)) {
            if (p.a(context, str) < 7200) {
                return false;
            }
        } else {
            if (!f6547c.equalsIgnoreCase(str)) {
                a.a().equalsIgnoreCase(str);
                return false;
            }
            if (p.a(context, str) < 8300) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Context context, Uri uri, String str) {
        Intent intent;
        List<ResolveInfo> queryIntentActivities;
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str2 = resolveInfo.activityInfo.packageName;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        ComponentName componentName = new ComponentName(str2, resolveInfo.activityInfo.name);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        context.startActivity(intent2);
                        return true;
                    }
                } else if (!f6547c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName2 = new ComponentName(str2, resolveInfo.activityInfo.name);
                    Intent intent22 = new Intent(intent);
                    intent22.setComponent(componentName2);
                    context.startActivity(intent22);
                    return true;
                }
                th.printStackTrace();
            }
        }
        return false;
    }

    public static Map<String, Object> c(Context context, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        VerifyWrapper wrapper = VerifyWrapper.wrapper((Map<String, Object>) new HashMap());
        wrapper.setId(context.getPackageName());
        wrapper.setTimestamp(String.valueOf(currentTimeMillis));
        OapsWrapper wrapper2 = OapsWrapper.wrapper(map);
        wrapper.setChecksum(a(wrapper.getId(), wrapper.getTimestamp()));
        for (Map.Entry<String, Object> entry : wrapper.getParams().entrySet()) {
            wrapper2.set(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private static boolean c(Context context, Uri uri, String str) {
        if (OapsLog.isDebugable()) {
            OapsLog.i("simple dp, Uri = " + uri);
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setData(uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        String a2 = a(context, wrapper);
        if ("oaps".equals(wrapper.getScheme())) {
            map = c(context, map);
        }
        return b(context, Uri.parse(OapsParser.encode(map)), a2);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        if ("oaps".equals(wrapper.getScheme())) {
            map = c(context, map);
        }
        return a(context, Uri.parse(OapsParser.encode(map)), a(context, wrapper));
    }
}
