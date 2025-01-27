package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";

    /* renamed from: a */
    private static volatile Integer f24044a = null;

    /* renamed from: b */
    private static volatile boolean f24045b = false;

    /* renamed from: c */
    private static volatile boolean f24046c = true;

    /* renamed from: d */
    private static volatile Integer f24047d;

    /* renamed from: e */
    private static volatile Boolean f24048e;

    /* renamed from: f */
    private static volatile Boolean f24049f;

    /* renamed from: g */
    private static volatile Boolean f24050g;

    /* renamed from: h */
    private static volatile Map<String, String> f24051h = new HashMap();

    /* renamed from: i */
    private static volatile Map<String, String> f24052i = new HashMap();

    /* renamed from: j */
    private static final Map<String, String> f24053j = new HashMap();
    private static final JSONObject k = new JSONObject();
    private static volatile String l = null;
    private static volatile String m = null;
    private static volatile String n = null;
    private static volatile String o = null;
    private static volatile String p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f24050g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f24049f;
    }

    public static Integer getChannel() {
        return f24044a;
    }

    public static String getCustomADActivityClassName() {
        return l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return o;
    }

    public static String getCustomPortraitActivityClassName() {
        return m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f24051h);
    }

    public static Integer getPersonalizedState() {
        return f24047d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f24053j;
    }

    public static JSONObject getSettings() {
        return k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f24048e == null || f24048e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f24050g == null) {
            return true;
        }
        return f24050g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f24049f == null) {
            return true;
        }
        return f24049f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f24045b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f24046c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f24048e == null) {
            f24048e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        f24050g = Boolean.valueOf(z);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f24049f = Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        if (f24044a == null) {
            f24044a = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            k.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        f24045b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f24046c = z;
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
        f24051h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            f24052i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f24052i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            k.putOpt("media_ext", new JSONObject(f24052i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        f24047d = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f24053j.putAll(map);
    }
}
