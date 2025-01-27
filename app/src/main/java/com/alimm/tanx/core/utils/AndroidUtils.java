package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;

/* loaded from: classes.dex */
public class AndroidUtils implements NotConfused {
    private static final String TAG = "PackageUtils";
    private static RequestBaseBean.AdDeviceBean deviceBean = null;
    private static volatile String packageName = "";

    public static String getAndroidId() {
        return "";
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return StringUtil.filterNonPrintableCharacters(String.valueOf(packageManager.getApplicationLabel(packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo)));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String getAppVersion(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static String getBrand() {
        return StringUtil.filterNonPrintableCharacters(Build.BRAND);
    }

    public static RequestBaseBean.AdDeviceBean getDeviceBean() {
        getDeviceInfo(true);
        return deviceBean;
    }

    public static String getDeviceInfo(boolean z10) {
        try {
            if (deviceBean == null) {
                RequestBaseBean.AdDeviceBean adDeviceBean = new RequestBaseBean.AdDeviceBean();
                deviceBean = adDeviceBean;
                adDeviceBean.user_agent = getUserAgent();
                deviceBean.android_id = getAndroidId();
                RequestBaseBean.AdDeviceBean adDeviceBean2 = deviceBean;
                adDeviceBean2.device_type = 0;
                adDeviceBean2.brand = getBrand();
                deviceBean.model = getModel();
                RequestBaseBean.AdDeviceBean adDeviceBean3 = deviceBean;
                adDeviceBean3.os = "Android";
                adDeviceBean3.osv = getSystemVersion();
                Point screenSize = getScreenSize(TanxCoreSdk.getApplication());
                RequestBaseBean.AdDeviceBean adDeviceBean4 = deviceBean;
                adDeviceBean4.width = screenSize.x;
                adDeviceBean4.height = screenSize.y;
                adDeviceBean4.pixel_ratio = getDisplayDpi(TanxCoreSdk.getApplication());
            }
            deviceBean.network = NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey();
            return JSON.toJSONString(deviceBean);
        } catch (Exception e10) {
            LogUtils.e(e10);
            e10.printStackTrace();
            if (z10) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "PackageUtils", LogUtils.getStackTraceMessage(e10), "");
            }
            return "";
        }
    }

    public static int getDisplayDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getModel() {
        return StringUtil.filterNonPrintableCharacters(Build.MODEL);
    }

    public static String getPackageName(Context context) {
        if (context != null && TextUtils.isEmpty(packageName)) {
            packageName = StringUtil.filterNonPrintableCharacters(context.getPackageName());
        }
        return packageName;
    }

    public static int getScreenOrientation(Context context) {
        int i10 = context.getResources().getConfiguration().orientation;
        if (i10 == 1) {
            return 1;
        }
        return i10 == 2 ? 2 : 0;
    }

    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getUserAgent() {
        return StringUtil.filterNonPrintableCharacters(System.getProperty("http.agent"));
    }

    public static String getUserAgentSuffix() {
        return " AliApp(TANXSDK/" + SdkConstant.getSdkVersion() + ")";
    }

    public static RequestBaseBean.AdDeviceBean getUtDeviceBean() {
        getDeviceInfo(false);
        return deviceBean;
    }

    public static String mediaNameStr() {
        try {
            TanxConfig config = TanxCoreSdk.getConfig();
            String packageName2 = getPackageName(TanxCoreSdk.getApplication());
            String appVersion = !TextUtils.isEmpty(packageName2) ? getAppVersion(TanxCoreSdk.getApplication(), packageName2) : "";
            return "AppName/" + (config != null ? config.getAppName() : "") + "/" + packageName2 + "/" + appVersion;
        } catch (Exception e10) {
            LogUtils.e(e10);
            return "";
        }
    }
}
