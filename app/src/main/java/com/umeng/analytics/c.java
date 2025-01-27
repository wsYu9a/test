package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final int f23352a = 20;

    /* renamed from: b */
    private static final String f23353b = "umeng_pcp";

    /* renamed from: c */
    private static final String f23354c = "mob";

    /* renamed from: d */
    private static final String f23355d = "em";

    /* renamed from: e */
    private static final String f23356e = "cp";

    /* renamed from: f */
    private static final String f23357f = "pk";

    /* renamed from: g */
    private static final String f23358g = "pv";

    /* renamed from: h */
    private static String[] f23359h = new String[2];

    /* renamed from: i */
    private static Object f23360i = new Object();

    /* renamed from: j */
    private static Map<String, Object> f23361j = new HashMap();

    public static void a(Context context, String str, String str2) {
        String[] strArr = f23359h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f23359h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static Map<String, Object> c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f23353b, 0);
        String string = sharedPreferences.getString("cp", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String str = new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            if (str.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                }
                sharedPreferences.edit().putString("cp", "").apply();
                return hashMap;
            } catch (Throwable unused) {
                return hashMap;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String[] a(Context context) {
        String[] a10;
        if (!TextUtils.isEmpty(f23359h[0]) && !TextUtils.isEmpty(f23359h[1])) {
            return f23359h;
        }
        if (context == null || (a10 = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f23359h;
        strArr[0] = a10[0];
        strArr[1] = a10[1];
        return strArr;
    }

    public static void b(String str) {
        String encodeToString;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f23353b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a10.length == 0) {
                    encodeToString = f.Q;
                } else {
                    encodeToString = Base64.encodeToString(a10, 0);
                }
                sharedPreferences.edit().putString(f23355d, encodeToString).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        String encodeToString;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f23353b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a10.length == 0) {
                    encodeToString = f.Q;
                } else {
                    encodeToString = Base64.encodeToString(a10, 0);
                }
                sharedPreferences.edit().putString(f23354c, encodeToString).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f23353b, 0);
            String string = sharedPreferences.getString(f23355d, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f23355d, "").apply();
                return "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(f23355d, "").apply();
            return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f23353b, 0);
            String string = sharedPreferences.getString(f23354c, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f23354c, "").apply();
                return "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(f23354c, "").apply();
            return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f23360i) {
                    try {
                        jSONStringer.array();
                        for (String str : map.keySet()) {
                            jSONStringer.object();
                            jSONStringer.key("pk");
                            jSONStringer.value(str);
                            jSONStringer.key("pv");
                            jSONStringer.value(map.get(str));
                            jSONStringer.endObject();
                        }
                        jSONStringer.endArray();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(f23353b, 0);
                sharedPreferences.edit().putString("cp", Base64.encodeToString(ax.a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, Object obj) {
        synchronized (f23360i) {
            try {
                if (f23361j.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "更新账号自定义KV: key=" + str + "; val=" + obj);
                    f23361j.put(str, obj);
                    a(UMGlobalContext.getAppContext(), f23361j);
                } else {
                    if (f23361j.size() >= 20) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: 已经设置20个KV键值对，忽略设置请求。");
                        MLog.e("userProfile: Only 20 user-defined key-value pairs can be configured, please check!");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: key=" + str + "; val=" + obj);
                    f23361j.put(str, obj);
                    a(UMGlobalContext.getAppContext(), f23361j);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
