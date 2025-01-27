package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.List;

/* loaded from: classes.dex */
class ab {
    public static boolean a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f6594a));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.f6595b));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
        ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent2, 1000);
        } else {
            context.startActivity(intent2);
        }
        return true;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f6594a));
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.f6595b));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        context.startService(intent2);
        return true;
    }
}
