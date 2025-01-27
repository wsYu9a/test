package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String CUSTOM_INFO_KEY = "custom_info";
    public static final String DARK_MODE_KEY = "dark_mode_info";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String NATIVE_EXPRESS_AD = "4";
    public static final String NATIVE_UNIFIED_AD = "6";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String REWARD_VIDEO_AD = "5";
    public static final String SPLASH_AD = "3";
    public static final String TT_SDK_WRAPPER = "TT";
    public static final String UNIFIED_BANNER_AD = "7";
    public static final String UNIFIED_INTERSTITIAL_FS_AD = "9";
    public static final String UNIFIED_INTERSTITIAL_HS_AD = "8";

    /* renamed from: a */
    private static volatile Integer f16606a = null;

    /* renamed from: b */
    private static volatile boolean f16607b = false;

    /* renamed from: c */
    private static volatile boolean f16608c = true;

    /* renamed from: d */
    private static volatile Integer f16609d;

    /* renamed from: e */
    private static volatile Boolean f16610e;

    /* renamed from: f */
    private static volatile Boolean f16611f;

    /* renamed from: g */
    private static volatile Boolean f16612g;

    /* renamed from: h */
    private static volatile Map<String, String> f16613h = new HashMap();

    /* renamed from: i */
    private static volatile Map<String, String> f16614i = new HashMap();

    /* renamed from: j */
    private static final Map<String, String> f16615j = new HashMap();

    /* renamed from: k */
    private static final JSONObject f16616k = new JSONObject();

    /* renamed from: l */
    private static volatile String f16617l = null;

    /* renamed from: m */
    private static volatile String f16618m = null;

    /* renamed from: n */
    private static volatile String f16619n = null;

    /* renamed from: o */
    private static volatile String f16620o = null;

    /* renamed from: p */
    private static volatile String f16621p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f16612g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f16611f;
    }

    public static Integer getChannel() {
        return f16606a;
    }

    public static String getCustomADActivityClassName() {
        return f16617l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f16620o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f16618m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f16621p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f16619n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f16613h);
    }

    public static Integer getPersonalizedState() {
        return f16609d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f16615j;
    }

    public static JSONObject getSettings() {
        return f16616k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f16610e == null || f16610e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f16612g == null) {
            return true;
        }
        return f16612g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f16611f == null) {
            return true;
        }
        return f16611f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f16607b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f16608c;
    }

    public static void setAgreePrivacyStrategy(boolean z10) {
        if (f16610e == null) {
            f16610e = Boolean.valueOf(z10);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z10) {
        f16612g = Boolean.valueOf(z10);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z10) {
        f16611f = Boolean.valueOf(z10);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f16616k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e10) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e10.toString());
        }
    }

    public static void setChannel(int i10) {
        if (f16606a == null) {
            f16606a = Integer.valueOf(i10);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f16616k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e10) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e10.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f16617l = str;
    }

    public static void setCustomInfo(Map<String, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            f16616k.putOpt(CUSTOM_INFO_KEY, new JSONObject(map));
        } catch (Exception e10) {
            GDTLogger.e("setCustomInfo：" + e10);
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f16620o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f16618m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f16621p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f16619n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z10) {
        try {
            f16616k.putOpt("ecais", Boolean.valueOf(z10));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z10) {
        f16607b = z10;
    }

    public static void setEnableVideoDownloadingCache(boolean z10) {
        f16608c = z10;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f16613h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z10) {
        if (map == null) {
            return;
        }
        if (z10) {
            f16614i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f16614i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f16616k.putOpt("media_ext", new JSONObject(f16614i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i10) {
        f16609d = Integer.valueOf(i10);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f16615j.putAll(map);
    }
}
