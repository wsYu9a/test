package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d {
    private static final Map<String, String> ayQ;

    static {
        HashMap hashMap = new HashMap();
        ayQ = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        hashMap.put("OPPO", "com.oppo.market");
        hashMap.put("vivo", "com.bbk.appstore");
        hashMap.put("xiaomi", "com.xiaomi.market");
        hashMap.put("OnePlus", "com.oppo.market");
        hashMap.put("Meizu", "com.meizu.mstore");
        hashMap.put("samsung", "com.sec.android.app.samsungapps");
        hashMap.put(com.martian.mipush.d.f14905f, "com.smartisanos.appstore");
        hashMap.put("Realme", "com.oppo.market");
        hashMap.put("HONOR", "com.huawei.appmarket");
    }

    private static boolean C(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (!as.DR() || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.adStyle == 4 || com.kwad.sdk.core.download.kwai.b.g(context, str) != 1) {
            return false;
        }
        adTemplate.mXiaomiAppStoreDetailViewOpen = true;
        return true;
    }

    private static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }

    private static boolean et(String str) {
        return "OPPO".equals(Build.BRAND) && com.cdo.oaps.ad.af.f6508e.equals(str);
    }

    public static boolean f(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = Build.BRAND;
        if ("samsung".equals(str3)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str4 = ayQ.get(str3);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (!a(resolveInfo)) {
                    String str5 = resolveInfo.activityInfo.packageName;
                    if (str5.equals(str4) || et(str5)) {
                        intent.setComponent(new ComponentName(str5, resolveInfo.activityInfo.name));
                        context.startActivity(intent);
                        return true;
                    }
                }
            }
            return C(context, str);
        } catch (Exception unused) {
            return C(context, str);
        }
    }
}
