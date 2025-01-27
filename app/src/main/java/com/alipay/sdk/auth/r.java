package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a */
    private static final String f5372a = "com.eg.android.AlipayGphone";

    /* renamed from: b */
    private static final int f5373b = 65;

    private static void a(Activity activity, a aVar) {
        if (c(activity)) {
            b(activity, "alipayauth://platformapi/startapp?appId=20000122&approveType=005&scope=kuaijie&productId=" + aVar.c() + "&thirdpartyId=" + aVar.a() + "&redirectUri=" + aVar.d());
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) AuthActivity.class);
        intent.putExtra("params", "app_id=" + aVar.a() + "&partner=" + aVar.b() + "&scope=kuaijie&login_goal=auth&redirect_url=" + aVar.d() + "&view=wap&prod_code=" + aVar.c());
        intent.putExtra("redirectUri", aVar.d());
        activity.startActivity(intent);
    }

    public static void b(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    static boolean c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f5372a, 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 65;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static void d(Activity activity, a aVar) {
        b(activity, "alipayauth://platformapi/startapp?appId=20000122&approveType=005&scope=kuaijie&productId=" + aVar.c() + "&thirdpartyId=" + aVar.a() + "&redirectUri=" + aVar.d());
    }

    private static void e(Activity activity, a aVar) {
        Intent intent = new Intent(activity, (Class<?>) AuthActivity.class);
        intent.putExtra("params", "app_id=" + aVar.a() + "&partner=" + aVar.b() + "&scope=kuaijie&login_goal=auth&redirect_url=" + aVar.d() + "&view=wap&prod_code=" + aVar.c());
        intent.putExtra("redirectUri", aVar.d());
        activity.startActivity(intent);
    }
}
