package com.vivo.ic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.vivo.ic.imei.ImeiUtil;
import com.vivo.ic.systemaccount.VivoSystemAccount;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class CookieHelper {
    private static final String COOKIES_PACKAGE_NAME = "vvc_pn";
    public static final String COOKIE_KEY_ANDROID_NAME = "vvc_an";
    public static final String COOKIE_KEY_ANDROID_VER = "vvc_av";
    public static final String COOKIE_KEY_APP_VERSION_CODE = "vvc_app_version";
    public static final String COOKIE_KEY_ELAPSED_TIME = "vvc_elapsedtime";
    public static final String COOKIE_KEY_HAS_UUID = "vvc_has";
    public static final String COOKIE_KEY_IMEI = "vvc_imei";
    public static final String COOKIE_KEY_MODEL = "vvc_model";
    public static final String COOKIE_KEY_OPENID = "vvc_openid";
    public static final String COOKIE_KEY_POINT_CHANNEL = "vvc_point_channel";
    public static final String COOKIE_KEY_REQUEST_SOURCE = "vvc_cs";
    public static final String COOKIE_KEY_SPECIAL_KEY = "vvc_k";
    public static final String COOKIE_KEY_STATUS = "vvc_status";
    public static final String COOKIE_KEY_TOKEN = "vvc_r";
    public static final String COOKIE_KEY_U = "vvc_u";
    public static final String COOKIE_KEY_USER = "vvc_p";
    public static final String COOKIE_KEY_USER_INFO_VSIGN = "vvc_s";
    public static final String COOKIE_KEY_UUID = "vvc_q";
    private static final String COOKIE_NO = "0";
    private static final String COOKIE_YES = "1";
    public static final String TAG = "CookieHelper";
    private static List<String> sSecretKeys;

    public interface CookieHelperInterface {
        String getValueForCookies(Context context, HashMap<String, String> hashMap);

        String getWaveEnd(String str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        sSecretKeys = arrayList;
        arrayList.add(COOKIE_KEY_MODEL);
        sSecretKeys.add(COOKIE_KEY_U);
        sSecretKeys.add(COOKIE_KEY_IMEI);
        sSecretKeys.add(COOKIE_KEY_OPENID);
        sSecretKeys.add(COOKIE_KEY_TOKEN);
        sSecretKeys.add(COOKIE_KEY_ELAPSED_TIME);
    }

    static String encodeUTF(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            VLog.e(TAG, "encodeUTF error " + e2, e2);
            return "";
        }
    }

    static String getAppVersionCode(Context context, String str) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return String.valueOf(packageInfo.versionCode);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void setCookies(Context context, String str, String str2, HashMap<String, String> hashMap, CookieHelperInterface cookieHelperInterface) {
        if (TextUtils.isEmpty(str)) {
            VLog.w(TAG, "url is null,set cookies fail");
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        hashMap2.put(COOKIE_KEY_IMEI, encodeUTF(ImeiUtil.getImei(context)));
        hashMap2.put(COOKIE_KEY_MODEL, encodeUTF(Build.MODEL));
        hashMap2.put(COOKIE_KEY_ELAPSED_TIME, encodeUTF(String.valueOf(SystemClock.elapsedRealtime())));
        String str3 = "0";
        hashMap2.put(COOKIE_KEY_REQUEST_SOURCE, encodeUTF("0"));
        hashMap2.put(COOKIE_KEY_U, encodeUTF(ImeiUtil.getUsfid(context)));
        hashMap2.put(COOKIE_KEY_APP_VERSION_CODE, encodeUTF(getAppVersionCode(context, context.getPackageName())));
        hashMap2.put(COOKIE_KEY_ANDROID_VER, String.valueOf(Build.VERSION.SDK_INT));
        hashMap2.put(COOKIE_KEY_ANDROID_NAME, Build.VERSION.RELEASE);
        hashMap2.put(COOKIE_KEY_POINT_CHANNEL, encodeUTF(str2));
        hashMap2.put(COOKIES_PACKAGE_NAME, context.getPackageName());
        boolean isLogin = VivoSystemAccount.isLogin(context);
        hashMap2.put(COOKIE_KEY_STATUS, isLogin ? "1" : "0");
        if (isLogin) {
            String userName = VivoSystemAccount.getUserName(context);
            if (TextUtils.isEmpty(userName)) {
                userName = VivoSystemAccount.getEmail(context);
            }
            if (TextUtils.isEmpty(userName)) {
                userName = VivoSystemAccount.getPhonenum(context);
            }
            hashMap2.put(COOKIE_KEY_USER, encodeUTF(userName));
            String uuid = VivoSystemAccount.getUuid(context);
            if (TextUtils.isEmpty(uuid)) {
                uuid = userName;
            } else {
                str3 = "1";
            }
            String openid = VivoSystemAccount.getOpenid(context);
            String authToken = VivoSystemAccount.getAuthToken(context);
            hashMap2.put(COOKIE_KEY_HAS_UUID, encodeUTF(str3));
            hashMap2.put(COOKIE_KEY_UUID, encodeUTF(uuid));
            hashMap2.put(COOKIE_KEY_OPENID, encodeUTF(openid));
            hashMap2.put(COOKIE_KEY_TOKEN, encodeUTF(authToken));
            hashMap2.put(COOKIE_KEY_SPECIAL_KEY, cookieHelperInterface.getWaveEnd(userName + uuid));
            HashMap<String, String> hashMap3 = new HashMap<>();
            for (String str4 : sSecretKeys) {
                String str5 = (String) hashMap2.get(str4);
                if (str5 != null) {
                    hashMap3.put(str4, str5);
                }
            }
            hashMap2.put(COOKIE_KEY_USER_INFO_VSIGN, cookieHelperInterface.getValueForCookies(context, hashMap3));
        } else {
            hashMap2.put(COOKIE_KEY_USER, null);
            hashMap2.put(COOKIE_KEY_HAS_UUID, null);
            hashMap2.put(COOKIE_KEY_UUID, null);
            hashMap2.put(COOKIE_KEY_OPENID, null);
            hashMap2.put(COOKIE_KEY_TOKEN, null);
            hashMap2.put(COOKIE_KEY_SPECIAL_KEY, null);
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            cookieManager.setCookie(str, ((String) entry.getKey()) + "=" + ((String) entry.getValue()) + ";path=/;");
        }
        CookieSyncManager.getInstance().sync();
    }
}
