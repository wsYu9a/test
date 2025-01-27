package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a */
    public static final String f6594a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";

    /* renamed from: b */
    public static final String f6595b = "b3Bwby9sYXVuY2g=";

    /* renamed from: c */
    public static final String f6596c = "scheme";

    /* renamed from: d */
    public static final String f6597d = "host";

    /* renamed from: e */
    public static final String f6598e = "params";

    /* renamed from: f */
    public static final String f6599f = "gb";

    /* renamed from: g */
    public static final String f6600g = "gamecenter";

    private static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    private static Intent a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.addCategory(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str3)) {
                intent.setData(Uri.parse(str3));
            }
            if (!TextUtils.isEmpty(str4)) {
                intent.setType(str4);
            }
        } else {
            intent.setDataAndType(Uri.parse(str3), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.setPackage(str5);
        }
        return intent;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String str = map.get("scheme");
        String str2 = map.get("host");
        String str3 = map.get("params");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !map.containsKey("params")) {
            return null;
        }
        return str + "://" + str2 + "?params=" + str3 + "&" + f6599f + "=" + (map.containsKey(f6599f) ? a(map.get(f6599f), 0) : 0);
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || !a(str)) {
            return false;
        }
        String a2 = a(b(str));
        PackageManager packageManager = context.getPackageManager();
        Intent a3 = a(a.b(f6594a), null, a2, a.b(f6595b), null);
        if (TextUtils.isEmpty(a2) || packageManager == null || !a(packageManager, a3)) {
            return false;
        }
        return a(context, a3);
    }

    private static boolean a(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 32);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean a(PackageManager packageManager, String str) {
        Bundle bundle;
        String str2 = b(str).get("scheme");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a(a.b(f6594a), null, str2 + "://", a.b(f6595b), null), 160);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                return bundle.getFloat("gcsdk_launcher_version", -1.0f) > 0.0f;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return str.contains("scheme") && str.contains("host") && str.contains("params");
    }

    public static float b(PackageManager packageManager, String str) {
        Bundle bundle;
        String str2 = b(str).get("scheme");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a(a.b(f6594a), null, str2 + "://", a.b(f6595b), null), 160);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return -1.0f;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                return bundle.getFloat("gcsdk_launcher_version", -1.0f);
            }
        }
        return -1.0f;
    }

    private static Map<String, String> b(String str) {
        int i2;
        String substring;
        String[] split;
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            return null;
        }
        String substring2 = str.substring(indexOf + 1);
        HashMap hashMap = new HashMap();
        if (substring2 != null && substring2.length() > 0) {
            int i3 = 0;
            while (true) {
                int indexOf2 = substring2.indexOf("&", i3) + 1;
                if (indexOf2 > 0) {
                    substring = substring2.substring(i3, indexOf2 - 1);
                    i2 = indexOf2;
                } else {
                    i2 = i3;
                    substring = substring2.substring(i3);
                }
                if (substring != null && (split = substring.split("=")) != null && split.length >= 1) {
                    String str2 = split[0];
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    String str3 = split.length == 1 ? "" : split[1];
                    if (str3 != null) {
                        str3 = str3.trim();
                    }
                    hashMap.put(str2, str3);
                }
                if (indexOf2 <= 0) {
                    break;
                }
                i3 = i2;
            }
        }
        return hashMap;
    }
}
