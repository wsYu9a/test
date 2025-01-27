package com.shu.priory.param;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            h.d(SDKConstants.TAG, "get app version error");
            return "";
        }
    }

    private static String b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String string = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            return !TextUtils.isEmpty(string) ? string : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            h.d(SDKConstants.TAG, "get app name error");
            return "";
        }
    }

    private static String c(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            h.d(SDKConstants.TAG, "get pkg error");
            return "";
        }
    }

    public static String a(AdParam adParam, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String a10 = a(context);
            if (!TextUtils.isEmpty(a10)) {
                jSONObject.put(AdKeys.APP_VER, a10);
            } else if (adParam != null) {
                jSONObject.put(AdKeys.APP_VER, adParam.getParameter(AdKeys.APP_VER));
            }
            jSONObject.put("app_name", b(context));
            jSONObject.put(MonitorConstants.PKG_NAME, c(context));
            return jSONObject.toString();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getAppInfo:" + th2.getMessage());
            return "";
        }
    }
}
