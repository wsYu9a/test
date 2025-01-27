package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import hf.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m5.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static String f24591a = null;

    /* renamed from: b */
    public static String f24592b = "";

    /* renamed from: c */
    private static final String f24593c = "EnvelopeManager";

    /* renamed from: d */
    private static final String f24594d = "debug.umeng.umTaskId";

    /* renamed from: e */
    private static final String f24595e = "debug.umeng.umCaseId";

    /* renamed from: f */
    private static final String f24596f = "empty";

    /* renamed from: g */
    private static String f24597g = "";

    /* renamed from: h */
    private static String f24598h = "";

    /* renamed from: i */
    private static String f24599i;

    /* renamed from: j */
    private static Map<String, String> f24600j;

    /* renamed from: l */
    private static boolean f24601l;

    /* renamed from: k */
    private int f24602k = 0;

    static {
        HashMap hashMap = new HashMap();
        f24600j = hashMap;
        hashMap.put("header", "#h");
        f24600j.put(bt.f23625u, "#sdt");
        f24600j.put(bt.Q, "#ac");
        f24600j.put("device_model", "#dm");
        f24600j.put(bt.f23611g, "#umid");
        f24600j.put(bt.f23628x, bt.f23628x);
        f24600j.put(bt.N, "#lang");
        f24600j.put(bt.f23592ai, "#dt");
        f24600j.put(bt.f23630z, "#rl");
        f24600j.put(bt.H, "#dmf");
        f24600j.put(bt.J, "#dn");
        f24600j.put("platform_version", "#pv");
        f24600j.put("font_size_setting", "#fss");
        f24600j.put(bt.f23629y, "#ov");
        f24600j.put(bt.I, "#did");
        f24600j.put("platform_sdk_version", "#psv");
        f24600j.put(bt.F, "#db");
        f24600j.put("appkey", "#ak");
        f24600j.put(bt.Y, "#itr");
        f24600j.put("id_type", "#it");
        f24600j.put("uuid", "#ud");
        f24600j.put("device_id", "#dd");
        f24600j.put(bt.X, "#imp");
        f24600j.put("sdk_version", "#sv");
        f24600j.put("st", "#st");
        f24600j.put("analytics", "#a");
        f24600j.put("package_name", "#pkg");
        f24600j.put(bt.f23620p, "#sig");
        f24600j.put(bt.f23621q, "#sis1");
        f24600j.put(bt.f23622r, "#sis");
        f24600j.put("app_version", "#av");
        f24600j.put("version_code", "#vc");
        f24600j.put(bt.f23626v, "#imd");
        f24600j.put(bt.B, "#mnc");
        f24600j.put(bt.E, "#boa");
        f24600j.put(bt.G, "#mant");
        f24600j.put(bt.M, "#tz");
        f24600j.put(bt.O, "#ct");
        f24600j.put(bt.P, "#car");
        f24600j.put(bt.f23623s, "#disn");
        f24600j.put(bt.T, "#nt");
        f24600j.put(bt.f23595b, "#cv");
        f24600j.put(bt.f23608d, "#mv");
        f24600j.put(bt.f23607c, "#cot");
        f24600j.put(bt.f23609e, "#mod");
        f24600j.put(bt.f23593aj, "#al");
        f24600j.put("session_id", "#sid");
        f24600j.put(bt.S, "#ip");
        f24600j.put(bt.U, "#sre");
        f24600j.put(bt.V, "#fre");
        f24600j.put(bt.W, "#ret");
        f24600j.put("channel", "#chn");
        f24600j.put("wrapper_type", "#wt");
        f24600j.put("wrapper_version", "#wv");
        f24600j.put(bt.f23597bb, "#tsv");
        f24600j.put(bt.f23598bc, "#rps");
        f24600j.put(bt.f23603bh, "#mov");
        f24600j.put(f.f23901i, "#vt");
        f24600j.put("secret", "#sec");
        f24600j.put(f.an, "#prv");
        f24600j.put(f.f23904l, "#$prv");
        f24600j.put(f.f23905m, "#uda");
        f24600j.put(bt.f23583a, "#tok");
        f24600j.put(bt.aT, "#iv");
        f24600j.put(bt.R, "#ast");
        f24600j.put("backstate", "#bst");
        f24600j.put("zdata_ver", "#zv");
        f24600j.put("zdata_req_ts", "#zrt");
        f24600j.put("app_b_v", "#bv");
        f24600j.put("zdata", "#zta");
        f24600j.put(bt.ap, "#mt");
        f24600j.put(bt.am, "#zsv");
        f24600j.put(bt.ao, "#oos");
    }

    public static String a(String str) {
        return f24600j.containsKey(str) ? f24600j.get(str) : str;
    }

    private static boolean b() {
        f24597g = UMUtils.getSystemProperty(f24594d, "");
        f24598h = UMUtils.getSystemProperty(f24595e, "");
        return (!TextUtils.isEmpty(f24597g) && !f24596f.equals(f24597g)) && (!TextUtils.isEmpty(f24598h) && !f24596f.equals(f24598h));
    }

    public static void a() {
        if (f24599i != null) {
            f24599i = null;
            com.umeng.commonsdk.statistics.idtracking.f.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f24597g);
                    jSONObject.put("umCaseId", f24598h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f24593c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j10 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f24593c, "free size is " + j10);
        }
        return j10;
    }

    private JSONObject a(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i10);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i10);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z10;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f24593c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f24593c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(f.f23906n)) {
                    str4 = str2;
                    z10 = true;
                } else {
                    str4 = str2;
                    z10 = false;
                }
                JSONObject a10 = a(context, str4, z10);
                if (a10 != null && jSONObject != null) {
                    a10 = a(a10, jSONObject);
                }
                JSONObject jSONObject4 = a10;
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject4.put(a(str6), jSONObject2.opt(str6));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str4 = "u";
                }
                String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str8 = str4 + "==" + str7 + "&=";
                    if (TextUtils.isEmpty(str8)) {
                        return a(101, jSONObject4);
                    }
                    if (str8.endsWith("&=")) {
                        str8 = str8.substring(0, str8.length() - 2);
                    }
                    str5 = str8;
                } else {
                    str5 = null;
                }
                if (jSONObject4 != null) {
                    try {
                        com.umeng.commonsdk.statistics.idtracking.f a11 = com.umeng.commonsdk.statistics.idtracking.f.a(context);
                        if (a11 != null) {
                            a11.b();
                            String encodeToString = Base64.encodeToString(new cq().a(a11.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(bt.Y), encodeToString);
                                jSONObject4.put(a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope a12 = a(context, jSONObject4.toString().getBytes());
                    if (a12 == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = a12;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int a13 = a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a13 != 0) {
                    return a(a13, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f24593c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                if (!str5.startsWith(bt.aJ) && !str5.startsWith("i") && !str5.startsWith(bt.aO) && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject4;
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e10) {
                            e = e10;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e11) {
                        e = e11;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e12) {
                        e = e12;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str9 = next2;
                        if (jSONObject2.opt(str9) != null) {
                            try {
                                jSONObject3.put(str9, jSONObject2.opt(str9));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f24494a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f24495b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f24496c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "h==1.2.0", "", str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f24593c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return a(110, new JSONObject());
        }
    }

    private static JSONObject a(Context context, String str, boolean z10) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences2 = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f24599i)) {
                try {
                    jSONObject = new JSONObject(f24599i);
                    sharedPreferences = sharedPreferences2;
                } catch (Exception unused) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(a(bt.f23620p), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a(bt.f23621q), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a(bt.f23622r), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a(bt.f23626v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a(bt.B), mccmnc);
                    f24592b = mccmnc;
                } else {
                    jSONObject2.put(a(bt.B), "");
                }
                if (FieldManager.allow(d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a(bt.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a(bt.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a(bt.f23592ai), deviceType);
                }
                jSONObject2.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject2.put(a(bt.f23625u), "Android");
                jSONObject2.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), Build.MODEL);
                jSONObject2.put(a(bt.E), Build.BOARD);
                jSONObject2.put(a(bt.F), Build.BRAND);
                sharedPreferences = sharedPreferences2;
                jSONObject2.put(a(bt.G), Build.TIME);
                jSONObject2.put(a(bt.H), Build.MANUFACTURER);
                jSONObject2.put(a(bt.I), Build.ID);
                jSONObject2.put(a(bt.J), Build.DEVICE);
                jSONObject2.put(a(bt.f23629y), Build.VERSION.RELEASE);
                jSONObject2.put(a(bt.f23628x), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put(a(bt.f23630z), resolutionArray[1] + h.f28447r + resolutionArray[0]);
                }
                jSONObject2.put(a(bt.A), DeviceConfig.getMac(context));
                jSONObject2.put(a(bt.M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a(bt.O), localeInfo[0]);
                jSONObject2.put(a(bt.N), localeInfo[1]);
                jSONObject2.put(a(bt.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a(bt.f23623s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bt.Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bt.Q), "2G/3G");
                } else {
                    jSONObject2.put(a(bt.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a(bt.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a(bt.ao), "harmony");
                } else {
                    jSONObject2.put(a(bt.ao), "Android");
                }
                jSONObject2.put(a(bt.T), DeviceConfig.getNetworkType(context));
                jSONObject2.put(a(bt.f23595b), "9.7.9");
                jSONObject2.put(a(bt.f23607c), SdkVersion.SDK_TYPE);
                jSONObject2.put(a(bt.f23608d), "1");
                if (!TextUtils.isEmpty(f24591a)) {
                    jSONObject2.put(a(bt.f23609e), f24591a);
                }
                jSONObject2.put(a(bt.f23593aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a(bt.f23589af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put(bt.ar, "1");
                        if (DeviceConfig.hasOpsPermission(context.getApplicationContext())) {
                            jSONObject2.put(bt.as, "1");
                        }
                    }
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(bt.aq, "1");
                    }
                } catch (Throwable unused3) {
                }
                if (DeviceConfig.isHonorDevice()) {
                    try {
                        if (br.c()) {
                            jSONObject2.put(bt.at, 2);
                        }
                        if (br.b()) {
                            jSONObject2.put(bt.at, 3);
                        }
                    } catch (Throwable unused4) {
                    }
                }
                try {
                    jSONObject2.put(bt.au, DeviceConfig.getNotificationStatus(context));
                } catch (Throwable unused5) {
                }
                try {
                    jSONObject2.put(bt.av, DeviceConfig.getRingerMode(context));
                } catch (Throwable unused6) {
                }
                f24599i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(bt.f23594ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused7) {
            }
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put(a(bt.U), sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put(a(bt.V), sharedPreferences3.getInt(bt.V, 0));
                jSONObject.put(a(bt.W), sharedPreferences3.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(bt.al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(bt.am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused8) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(bt.f23583a), deviceToken);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(context, e10);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.f23611g, null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(a(bt.f23611g), imprintProperty);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(context, e11);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.f24588a);
                jSONObject.put(a("wrapper_version"), a.f24589b);
            } catch (Exception unused9) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, g.f11102c);
                jSONObject.put(a(bt.f23597bb), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(a(bt.f23598bc), "yes");
                } else {
                    jSONObject.put(a(bt.f23598bc), "no");
                }
            } catch (Throwable unused10) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f24597g);
                    jSONObject.put("umCaseId", f24598h);
                }
            } catch (Throwable unused11) {
            }
            if ((bt.aO.equals(str) || "a".equals(str)) && z10) {
                try {
                    int[] b10 = b(context);
                    jSONObject.put(a(bt.by), String.valueOf(b10[0]) + String.valueOf(b10[1]) + String.valueOf(b10[2]));
                } catch (Throwable unused12) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(bt.ap), jSONObject3);
                }
            } catch (Throwable unused13) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(bt.bx), realTimeDebugKey);
                }
            } catch (Throwable unused14) {
            }
            try {
                JSONObject moduleVer = UMUtils.getModuleVer();
                if (moduleVer.length() > 0) {
                    jSONObject.put(a(bt.f23603bh), moduleVer);
                }
            } catch (Throwable unused15) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(bt.bw), apmFlag);
                }
            } catch (Throwable unused16) {
            }
            try {
                String str2 = Build.BRAND;
                String a10 = at.a(str2);
                String b11 = at.b(str2);
                jSONObject.put(bt.f23601bf, a10);
                jSONObject.put(bt.f23602bg, b11);
            } catch (Throwable unused17) {
            }
            byte[] a11 = ImprintHandler.getImprintService(context).a();
            if (a11 != null && a11.length > 0) {
                try {
                    jSONObject.put(a(bt.X), Base64.encodeToString(a11, 0));
                } catch (JSONException e12) {
                    UMCrashManager.reportCrash(context, e12);
                }
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put(a("header"), jSONObject);
            }
            return null;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(f.f23901i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f24602k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i10 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i10 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e10) {
            UMCrashManager.reportCrash(context, e10);
        }
        if (i10 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i10 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f24601l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b10 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("&&");
        sb2.append(str2);
        sb2.append(e.f26694a);
        sb2.append(System.currentTimeMillis());
        sb2.append(e.f26694a);
        sb2.append(b10);
        sb2.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb2.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(bt.aJ) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith(bt.aO)) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f24564f, sb2.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb2.toString(), binary);
    }

    public static void a(boolean z10) {
        f24601l = z10;
    }
}
