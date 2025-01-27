package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static String f26279a = null;

    /* renamed from: b */
    public static String f26280b = "";

    /* renamed from: c */
    private static final String f26281c = "EnvelopeManager";

    /* renamed from: d */
    private static final String f26282d = "debug.umeng.umTaskId";

    /* renamed from: e */
    private static final String f26283e = "debug.umeng.umCaseId";

    /* renamed from: f */
    private static final String f26284f = "empty";

    /* renamed from: g */
    private static String f26285g = "";

    /* renamed from: h */
    private static String f26286h = "";

    /* renamed from: i */
    private static String f26287i;

    /* renamed from: j */
    private static Map<String, String> f26288j;
    private static boolean l;
    private int k = 0;

    static {
        HashMap hashMap = new HashMap();
        f26288j = hashMap;
        hashMap.put("header", "#h");
        f26288j.put(am.u, "#sdt");
        f26288j.put(am.Q, "#ac");
        f26288j.put("device_model", "#dm");
        f26288j.put(am.f25657g, "#umid");
        f26288j.put(am.x, am.x);
        f26288j.put(am.N, "#lang");
        f26288j.put(am.ai, "#dt");
        f26288j.put(am.z, "#rl");
        f26288j.put(am.H, "#dmf");
        f26288j.put(am.J, "#dn");
        f26288j.put("platform_version", "#pv");
        f26288j.put("font_size_setting", "#fss");
        f26288j.put(am.y, "#ov");
        f26288j.put(am.I, "#did");
        f26288j.put("platform_sdk_version", "#psv");
        f26288j.put(am.F, "#db");
        f26288j.put("appkey", "#ak");
        f26288j.put(am.Y, "#itr");
        f26288j.put("id_type", "#it");
        f26288j.put("uuid", "#ud");
        f26288j.put("device_id", "#dd");
        f26288j.put(am.X, "#imp");
        f26288j.put("sdk_version", "#sv");
        f26288j.put("st", "#st");
        f26288j.put("analytics", "#a");
        f26288j.put("package_name", "#pkg");
        f26288j.put(am.p, "#sig");
        f26288j.put(am.q, "#sis1");
        f26288j.put(am.r, "#sis");
        f26288j.put("app_version", "#av");
        f26288j.put("version_code", "#vc");
        f26288j.put(am.v, "#imd");
        f26288j.put(am.B, "#mnc");
        f26288j.put(am.E, "#boa");
        f26288j.put(am.G, "#mant");
        f26288j.put(am.M, "#tz");
        f26288j.put(am.O, "#ct");
        f26288j.put(am.P, "#car");
        f26288j.put(am.s, "#disn");
        f26288j.put(am.T, "#nt");
        f26288j.put(am.f25652b, "#cv");
        f26288j.put(am.f25654d, "#mv");
        f26288j.put(am.f25653c, "#cot");
        f26288j.put(am.f25655e, "#mod");
        f26288j.put(am.aj, "#al");
        f26288j.put("session_id", "#sid");
        f26288j.put(am.S, "#ip");
        f26288j.put(am.U, "#sre");
        f26288j.put(am.V, "#fre");
        f26288j.put(am.W, "#ret");
        f26288j.put("channel", "#chn");
        f26288j.put("wrapper_type", "#wt");
        f26288j.put("wrapper_version", "#wv");
        f26288j.put(am.aV, "#tsv");
        f26288j.put(am.aW, "#rps");
        f26288j.put(am.aZ, "#mov");
        f26288j.put(d.f25839i, "#vt");
        f26288j.put("secret", "#sec");
        f26288j.put(d.ah, "#prv");
        f26288j.put(d.l, "#$prv");
        f26288j.put(d.m, "#uda");
        f26288j.put(am.f25650a, "#tok");
        f26288j.put(am.aN, "#iv");
        f26288j.put(am.R, "#ast");
        f26288j.put("backstate", "#bst");
        f26288j.put("zdata_ver", "#zv");
        f26288j.put("zdata_req_ts", "#zrt");
        f26288j.put("app_b_v", "#bv");
        f26288j.put("zdata", "#zta");
        f26288j.put(am.ap, "#mt");
        f26288j.put(am.am, "#zsv");
        f26288j.put(am.ao, "#oos");
    }

    public static String a(String str) {
        return f26288j.containsKey(str) ? f26288j.get(str) : str;
    }

    private static boolean b() {
        f26285g = UMUtils.getSystemProperty(f26282d, "");
        f26286h = UMUtils.getSystemProperty(f26283e, "");
        return (!TextUtils.isEmpty(f26285g) && !f26284f.equals(f26285g)) && (!TextUtils.isEmpty(f26286h) && !f26284f.equals(f26286h));
    }

    public static void a() {
        if (f26287i != null) {
            f26287i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f26285g);
                    jSONObject.put("umCaseId", f26286h);
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
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f26281c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f26281c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f26281c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f26281c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(d.n)) {
                    str4 = str2;
                    z = true;
                } else {
                    str4 = str2;
                    z = false;
                }
                JSONObject a2 = a(context, str4, z);
                if (a2 != null && jSONObject != null) {
                    a2 = a(a2, jSONObject);
                }
                JSONObject jSONObject4 = a2;
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
                        e a3 = e.a(context);
                        if (a3 != null) {
                            a3.b();
                            String encodeToString = Base64.encodeToString(new be().a(a3.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(am.Y), encodeToString);
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
                    Envelope a4 = a(context, jSONObject4.toString().getBytes());
                    if (a4 == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = a4;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int a5 = a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a5 != 0) {
                    return a(a5, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f26281c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                if (!str5.startsWith(am.aD) && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e4) {
                        e = e4;
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
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f26191a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f26192b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f26193c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
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
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "h==1.2.0", "", str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f26281c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:83:0x03ad
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static org.json.JSONObject a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
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
                            if (str.equals(a(d.f25839i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.k = ((Integer) jSONObject2.opt(str)).intValue();
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
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (l) {
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
        String b2 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(am.aD) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith("t")) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f26254f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z) {
        l = z;
    }
}
