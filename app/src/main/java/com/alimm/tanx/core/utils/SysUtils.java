package com.alimm.tanx.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.orange.OrangeManager;
import com.gyf.immersionbar.b;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SysUtils implements NotConfused {
    private static final String TAG = "SysUtils";

    public static boolean checkUrlSuffixAndValid(String str) {
        String urlSuffix = getUrlSuffix(str);
        if (TextUtils.isEmpty(urlSuffix)) {
            return false;
        }
        return OrangeManager.getInstance().getWebSuffixWhiteSwitch(urlSuffix);
    }

    public static long currentTimeSecs() {
        return System.currentTimeMillis() / 1000;
    }

    public static List<String> getInstallStatus() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Boolean> installSwitch = OrangeManager.getInstance().getInstallSwitch();
        if (OrangeManager.getInstance().getInstallSwitch() != null) {
            for (Map.Entry<String, Boolean> entry : installSwitch.entrySet()) {
                if (entry.getValue() != null && entry.getValue().booleanValue() && !TextUtils.isEmpty(entry.getKey()) && hasPackage(TanxCoreSdk.getApplication(), entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier(b.f10638c, "dimen", "android");
            if (identifier <= 0) {
                identifier = R.dimen.default_status_bar_height;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            Log.v(TAG, "System StatusBar height : " + dimensionPixelSize);
            return dimensionPixelSize;
        } catch (Exception e10) {
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.default_status_bar_height);
            Log.e(TAG, "getStatusBarHeight() failed:", e10);
            return dimensionPixelSize2;
        }
    }

    public static int getStatusBarHeight2WebView(Context context) {
        int statusbarHeight = getStatusbarHeight(context);
        int i10 = statusbarHeight > 0 ? statusbarHeight - 58 : 0;
        if (i10 <= 0) {
            return 0;
        }
        return i10;
    }

    public static int getStatusbarHeight(Context context) {
        int identifier = context.getResources().getIdentifier(b.f10638c, "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getUrlSuffix(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            LogUtils.d("getUrlSuffix", "url为空");
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("#");
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        String[] split2 = str.split("[\\\\/]");
        return (split2 == null || (split = split2[split2.length - 1].split("\\.")) == null || split.length < 1) ? "" : split[split.length - 1];
    }

    private static boolean hasPackage(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        try {
            URI uri = new URI(str.replaceAll("\\\\", "").trim());
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https");
        } catch (Exception e10) {
            LogUtils.e(e10);
            return false;
        }
    }
}
