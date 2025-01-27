package com.opos.cmn.g.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f17414a = "com." + com.opos.cmn.an.a.a.f16359c + ".market";

    private static boolean a(Activity activity, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "marketUrl is empty";
        } else {
            if (activity != null) {
                try {
                    Context applicationContext = activity.getApplicationContext();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    String str3 = f17414a;
                    if (b(applicationContext, str3)) {
                        intent.setPackage(str3);
                    } else {
                        if (!b(applicationContext, af.f6508e)) {
                            com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                            return false;
                        }
                        intent.setPackage(af.f6508e);
                    }
                    activity.startActivityForResult(intent, 100);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPageForActivity", e2);
                }
                return true;
            }
            str2 = "activity is null";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    public static boolean a(Context context, String str) {
        Context applicationContext;
        String str2;
        if (context == null) {
            str2 = "context is null";
        } else {
            if (!TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("MarketDLTool", "market url:" + str);
                try {
                    applicationContext = context.getApplicationContext();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPage", e2);
                }
                if (!b(applicationContext, f17414a) && !b(applicationContext, af.f6508e)) {
                    com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                    return false;
                }
                if (context instanceof Activity) {
                    a((Activity) context, str);
                } else {
                    com.opos.cmn.an.transactivity.api.a.a(context, new com.opos.cmn.g.b.a.a(str));
                }
                return true;
            }
            str2 = "marketUrl is empty";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    private static boolean b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                return false;
            }
            return applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
