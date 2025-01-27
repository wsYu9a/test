package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.bc;
import com.shu.priory.config.AdKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MobadsPermissionSettings {
    private static final String PERMISSION_APP_LIST = "permission_app_list";
    private static final String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final String PERMISSION_LOCATION = "permission_location";
    private static final String PERMISSION_OAID = "permission_oaid";
    private static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    public static JSONObject getLimitInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
            jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
            jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
            jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
            jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
            jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
            jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
            jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean handleIntegrationInfo(Bundle bundle) {
        try {
            switchDebugLog(bundle);
            IXAdContainerFactory c10 = aa.a().c();
            if (c10 != null) {
                c10.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    private static void postLimitInfoRemote() {
        IXAdContainerFactory c10 = aa.a().c();
        if (c10 != null) {
            c10.onTaskDistribute(bc.f6857b, getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        IXAdContainerFactory c10 = aa.a().c();
        if (c10 != null) {
            c10.onTaskDistribute(bc.f6856a, getPermissionInfo());
        }
    }

    public static void setLimitPersonalAds(boolean z10) {
        mLimitPrivacyAds = z10;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z10) {
        mAccessAppListGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z10) {
        mAppUpdateGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z10) {
        mDeviceInfoGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z10) {
        mAccessLocationGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z10) {
        mOAIDGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z10) {
        mReadPhoneStateGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z10) {
        mRunningAppGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z10) {
        mExternalStorageGranted = z10;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(Bundle bundle) {
        if (bundle != null && bundle.containsKey(AdKeys.DEBUG_MODE)) {
            if (bundle.getBoolean(AdKeys.DEBUG_MODE)) {
                ay.a(true);
                return;
            } else {
                ay.a();
                return;
            }
        }
        if (bundle == null || !bundle.containsKey(ax.f6807b)) {
            return;
        }
        if (bundle.getBoolean(ax.f6807b)) {
            ay.a((ay.a) new ax());
        } else {
            ay.i(ax.f6807b);
        }
    }

    private static void updateSPLimitTag() {
        aa a10;
        IXAdContainerFactory c10;
        try {
            if (mCheckSPLimit || (a10 = aa.a()) == null || (c10 = a10.c()) == null) {
                return;
            }
            Object remoteParam = c10.getRemoteParam("limitPersonalAds", new Object[0]);
            if (remoteParam instanceof Boolean) {
                mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                mCheckSPLimit = true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
