package com.cdo.oaps.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
class q {
    public static boolean a(Context context) {
        Intent launchIntentForPackage;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(a.b(a.f6499a))) != null) {
                launchIntentForPackage.setFlags(270532608);
                context.startActivity(launchIntentForPackage);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean a(Context context, long j2, boolean z, boolean z2, int i2) {
        try {
            Uri parse = Uri.parse(a.c() + "market://ProductDetail?pid=" + j2);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setPackage(a.b(a.f6499a));
            intent.putExtra("out_intent_from", i2);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2, int i2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a.c() + "market://detail_search?keyword=" + str + "&packagename=" + str2));
            intent.addFlags(335544320);
            intent.setPackage(a.b(a.f6499a));
            intent.putExtra("out_intent_from", i2);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z, boolean z2, int i2) {
        try {
            Uri parse = Uri.parse(a.c() + "market://details?packagename=" + str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setPackage(a.b(a.f6499a));
            intent.putExtra("out_intent_from", i2);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
