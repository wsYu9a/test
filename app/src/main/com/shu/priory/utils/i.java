package com.shu.priory.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.request.IFLYBrowser;

/* loaded from: classes3.dex */
public class i {

    /* renamed from: a */
    private static String[] f17311a = {com.kuaishou.weapon.p0.g.f11100a, com.kuaishou.weapon.p0.g.f11101b, com.kuaishou.weapon.p0.g.f11102c, com.kuaishou.weapon.p0.g.f11103d, com.kuaishou.weapon.p0.g.f11107h, com.kuaishou.weapon.p0.g.f11104e, "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.REQUEST_INSTALL_PACKAGES"};

    private static void a(Context context, String[] strArr) {
        for (String str : strArr) {
            if (!a(context, str)) {
                h.d(SDKConstants.TAG, str + " must be enabled in AndroidManifest.xml");
            }
        }
    }

    public static boolean b(Context context, String str) {
        boolean z10 = false;
        try {
            int i10 = context.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT < 23 || i10 < 23) {
                z10 = a(context, str);
            } else if (context.checkCallingOrSelfPermission(str) == 0) {
                z10 = true;
            }
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "checkPermissionGrant:" + e10.getMessage());
        }
        return z10;
    }

    public static boolean a(Context context) {
        a(context, f17311a);
        return a(context, (Class<?>) IFLYBrowser.class);
    }

    public static boolean a(Context context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            return true;
        }
        h.d(SDKConstants.TAG, "Can not found " + cls.toString() + ", please set it in AndroidManifest.xml");
        return false;
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
