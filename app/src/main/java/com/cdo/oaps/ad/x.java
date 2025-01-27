package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class x {
    public static float a(Context context) {
        Object obj;
        float f2 = -1.0f;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.nearme.gamecenter", 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.containsKey("oaps_version") && (obj = applicationInfo.metaData.get("oaps_version")) != null) {
                f2 = obj instanceof Number ? ((Number) obj).floatValue() : Float.valueOf(obj.toString()).floatValue();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f2 > 0.0f ? f2 : w.b(context);
    }
}
