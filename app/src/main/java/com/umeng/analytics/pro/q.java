package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: a */
    private static Context f24078a = null;

    /* renamed from: l */
    private static final String f24079l = "first_activate_time";

    /* renamed from: m */
    private static final String f24080m = "ana_is_f";

    /* renamed from: n */
    private static final String f24081n = "thtstart";

    /* renamed from: o */
    private static final String f24082o = "dstk_last_time";

    /* renamed from: p */
    private static final String f24083p = "dstk_cnt";

    /* renamed from: q */
    private static final String f24084q = "gkvc";

    /* renamed from: r */
    private static final String f24085r = "ekvc";

    /* renamed from: t */
    private static final String f24086t = "-1";

    /* renamed from: x */
    private static final String f24087x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y */
    private static Class<?> f24088y;

    /* renamed from: z */
    private static Method f24089z;

    /* renamed from: b */
    private c f24090b;

    /* renamed from: c */
    private SharedPreferences f24091c;

    /* renamed from: d */
    private String f24092d;

    /* renamed from: e */
    private String f24093e;

    /* renamed from: f */
    private int f24094f;

    /* renamed from: g */
    private JSONArray f24095g;

    /* renamed from: h */
    private final int f24096h;

    /* renamed from: i */
    private int f24097i;

    /* renamed from: j */
    private int f24098j;

    /* renamed from: k */
    private long f24099k;

    /* renamed from: s */
    private final long f24100s;

    /* renamed from: u */
    private boolean f24101u;

    /* renamed from: v */
    private boolean f24102v;

    /* renamed from: w */
    private Object f24103w;

    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;

        /* renamed from: a */
        public static final int f24104a = 4097;

        /* renamed from: b */
        public static final int f24105b = 4098;

        /* renamed from: c */
        public static final int f24106c = 4099;

        /* renamed from: d */
        public static final int f24107d = 4100;

        /* renamed from: e */
        public static final int f24108e = 4101;

        /* renamed from: f */
        public static final int f24109f = 4102;

        /* renamed from: g */
        public static final int f24110g = 4103;

        /* renamed from: h */
        public static final int f24111h = 4104;

        /* renamed from: i */
        public static final int f24112i = 4105;

        /* renamed from: j */
        public static final int f24113j = 4106;

        /* renamed from: k */
        public static final int f24114k = 4352;

        /* renamed from: l */
        public static final int f24115l = 4353;

        /* renamed from: m */
        public static final int f24116m = 4354;

        /* renamed from: n */
        public static final int f24117n = 4355;

        /* renamed from: o */
        public static final int f24118o = 4356;

        /* renamed from: p */
        public static final int f24119p = 4357;

        /* renamed from: q */
        public static final int f24120q = 4358;

        /* renamed from: r */
        public static final int f24121r = 8193;

        /* renamed from: s */
        public static final int f24122s = 8194;

        /* renamed from: t */
        public static final int f24123t = 8195;

        /* renamed from: u */
        public static final int f24124u = 8196;

        /* renamed from: v */
        public static final int f24125v = 8197;

        /* renamed from: w */
        public static final int f24126w = 8199;

        /* renamed from: x */
        public static final int f24127x = 8200;

        /* renamed from: y */
        public static final int f24128y = 8201;

        /* renamed from: z */
        public static final int f24129z = 8208;
    }

    public static class b {

        /* renamed from: a */
        private static final q f24130a = new q();

        private b() {
        }
    }

    static {
        h();
    }

    public /* synthetic */ q(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static q a(Context context) {
        if (f24078a == null && context != null) {
            f24078a = context.getApplicationContext();
        }
        return b.f24130a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f24099k, this.f24097i)) {
                    return;
                } else {
                    this.f24097i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f24099k, this.f24098j)) {
                    return;
                } else {
                    this.f24098j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f24095g == null) {
                    this.f24095g = new JSONArray();
                }
                this.f24095g.put(jSONObject);
                k.a(f24078a).a(this.f24095g);
                this.f24095g = new JSONArray();
                return;
            }
            if (this.f24095g.length() >= this.f24094f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                k.a(f24078a).a(this.f24095g);
                this.f24095g = new JSONArray();
            }
            if (this.f24099k == 0) {
                this.f24099k = System.currentTimeMillis();
            }
            this.f24095g.put(jSONObject);
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(f.f23906n)) {
                    k.a(f24078a).a(true, false);
                }
                k.a(f24078a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(f.f23906n) && (optJSONObject2 = jSONObject2.getJSONArray(f.f23906n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        k.a(f24078a).b(optString);
                    }
                }
            }
            k.a(f24078a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = f24078a;
            UMWorkDispatch.sendEvent(context, a.f24115l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(f24087x);
            f24088y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f24089z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject b10 = b(UMEnvelopeBuild.maxDataSpace(f24078a));
        if (b10 == null || b10.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b10.opt("header");
        JSONObject jSONObject2 = (JSONObject) b10.opt("content");
        if (f24078a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f24078a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a10 = a(UMEnvelopeBuild.maxDataSpace(f24078a));
        if (a10 == null || a10.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a10.opt("header");
        JSONObject jSONObject2 = (JSONObject) a10.opt("content");
        Context context = f24078a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject l10 = l();
        if (l10 != null) {
            try {
                l10.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l10;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f24078a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f23901i), verticalType);
            String str = "9.7.9";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f24078a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.7.9");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f24078a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f24078a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24078a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f24078a, f.at, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f24078a, f.au, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.an), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f24080m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f23904l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f23905m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f23904l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f23905m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f24078a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str = "0";
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f24078a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f24092d)) {
                return this.f24092d;
            }
            if (this.f24091c == null) {
                this.f24091c = PreferenceWrapper.getDefault(f24078a);
            }
            String string = this.f24091c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f24078a);
            if (TextUtils.isEmpty(string)) {
                this.f24091c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
            } else {
                str = this.f24091c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f24091c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f24092d = str;
            return str;
        }
        str = str2;
        this.f24092d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f24078a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f24093e)) {
                    return this.f24093e;
                }
                if (this.f24091c == null) {
                    this.f24091c = PreferenceWrapper.getDefault(f24078a);
                }
                String string = this.f24091c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f24091c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f24091c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f24093e = str;
        return str;
    }

    private void o() {
        try {
            this.f24097i = 0;
            this.f24098j = 0;
            this.f24099k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f24078a).edit().putLong(f24082o, System.currentTimeMillis()).putInt(f24083p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(w.a().b())) {
                b(f24078a);
            }
            if (this.f24095g.length() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < this.f24095g.length(); i10++) {
                JSONObject optJSONObject = this.f24095g.optJSONObject(i10);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || f24086t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f24095g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < this.f24095g.length(); i10++) {
                try {
                    JSONObject jSONObject = this.f24095g.getJSONObject(i10);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        boolean isEmpty = TextUtils.isEmpty(optString);
                        String str = f24086t;
                        if (isEmpty || f24086t.equals(optString)) {
                            String b10 = w.a().b();
                            if (!TextUtils.isEmpty(b10)) {
                                str = b10;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f24095g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = f24078a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f24079l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f24079l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f24078a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f24080m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f24078a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f24095g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                k.a(f24078a).a(this.f24095g);
                this.f24095g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f24078a).edit().putLong(f24081n, this.f24099k).putInt(f24084q, this.f24097i).putInt(f24085r, this.f24098j).commit();
        } catch (Throwable unused) {
        }
    }

    private q() {
        this.f24090b = null;
        this.f24091c = null;
        this.f24092d = null;
        this.f24093e = null;
        this.f24094f = 10;
        this.f24095g = new JSONArray();
        this.f24096h = 5000;
        this.f24097i = 0;
        this.f24098j = 0;
        this.f24099k = 0L;
        this.f24100s = 28800000L;
        this.f24101u = false;
        this.f24102v = false;
        this.f24103w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24078a);
            this.f24099k = sharedPreferences.getLong(f24081n, 0L);
            this.f24097i = sharedPreferences.getInt(f24084q, 0);
            this.f24098j = sharedPreferences.getInt(f24085r, 0);
            this.f24090b = new c();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f10;
        if (k.a(UMGlobalContext.getAppContext(f24078a)).c() || (f10 = k.a(UMGlobalContext.getAppContext(f24078a)).f()) == null) {
            return;
        }
        String optString = f10.optString("__av");
        String optString2 = f10.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f24078a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f24078a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(f.f23906n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    k.a(f24078a).i();
                    k.a(f24078a).h();
                    k.a(f24078a).b(true, false);
                    k.a(f24078a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(f.f23906n)) {
                    k.a(f24078a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(f.Z)) {
                    k.a(f24078a).h();
                }
                if (optJSONObject.has("error")) {
                    k.a(f24078a).i();
                }
            }
            k.a(f24078a).a();
        } catch (Exception unused) {
        }
    }

    public static class c {

        /* renamed from: a */
        private ReportPolicy.ReportStrategy f24131a = null;

        /* renamed from: b */
        private int f24132b = -1;

        /* renamed from: c */
        private int f24133c = -1;

        /* renamed from: d */
        private int f24134d = -1;

        /* renamed from: e */
        private int f24135e = -1;

        /* renamed from: f */
        private ABTest f24136f;

        public c() {
            this.f24136f = null;
            this.f24136f = ABTest.getService(q.f24078a);
        }

        public void a() {
            try {
                int[] a10 = a(-1, -1);
                this.f24132b = a10[0];
                this.f24133c = a10[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            Defcon service = Defcon.getService(q.f24078a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f24131a;
                this.f24131a = ((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid()) ? this.f24131a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(q.f24078a), service);
            } else {
                int i10 = 0;
                boolean z10 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f24078a, "integrated_test", q.f24086t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z10 && !MLog.DEBUG) {
                    UMLog.mutlInfo(l.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z10) {
                    this.f24131a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(q.f24078a));
                } else if (this.f24136f.isInTest() && "RPT".equals(this.f24136f.getTestName())) {
                    if (this.f24136f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f24078a, "test_report_interval", q.f24086t)).intValue() != -1) {
                            i10 = a(90000);
                        } else {
                            i10 = this.f24133c;
                            if (i10 <= 0) {
                                i10 = this.f24135e;
                            }
                        }
                    }
                    this.f24131a = b(this.f24136f.getTestPolicy(), i10);
                } else {
                    int i11 = this.f24134d;
                    int i12 = this.f24135e;
                    int i13 = this.f24132b;
                    if (i13 != -1) {
                        i12 = this.f24133c;
                        i11 = i13;
                    }
                    this.f24131a = b(i11, i12);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f24131a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(l.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(l.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(l.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(l.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z11 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f24131a;
        }

        public int[] a(int i10, int i11) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f24078a, "report_policy", q.f24086t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f24078a, "report_interval", q.f24086t)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i10, i11};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            if (11 == intValue) {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            return new int[]{i10, i11};
        }

        public int a(int i10) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f24078a, "test_report_interval", q.f24086t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i10 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i10, int i11) {
            if (i10 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f24131a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i10 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f24131a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i10 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f24131a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(q.f24078a));
            }
            if (i10 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f24131a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(q.f24078a);
            }
            if (i10 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f24131a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i11);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(q.f24078a), i11);
            }
            if (i10 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f24131a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(q.f24078a));
            }
            if (i10 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f24131a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f24131a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i11);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i11);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!k.a(f24078a).e()) {
                JSONObject g10 = k.a(f24078a).g();
                if (g10 != null) {
                    String optString = g10.optString("__av");
                    String optString2 = g10.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f24078a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f24078a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f24078a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f24078a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f24078a != null) {
            synchronized (this.f24103w) {
                try {
                    if (this.f24101u) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                        Context context = f24078a;
                        UMWorkDispatch.sendEvent(context, a.f24115l, CoreProtocol.getInstance(context), null);
                    }
                } finally {
                }
            }
            synchronized (this.f24103w) {
                try {
                    if (this.f24102v) {
                        Context context2 = f24078a;
                        UMWorkDispatch.sendEvent(context2, a.f24116m, CoreProtocol.getInstance(context2), null);
                    }
                } finally {
                }
            }
        }
    }

    public static class d {

        /* renamed from: a */
        private Map<String, Object> f24137a;

        /* renamed from: b */
        private String f24138b;

        /* renamed from: c */
        private String f24139c;

        /* renamed from: d */
        private long f24140d;

        private d() {
            this.f24137a = null;
            this.f24138b = null;
            this.f24139c = null;
            this.f24140d = 0L;
        }

        public Map<String, Object> a() {
            return this.f24137a;
        }

        public String b() {
            return this.f24139c;
        }

        public String c() {
            return this.f24138b;
        }

        public long d() {
            return this.f24140d;
        }

        public d(String str, Map<String, Object> map, String str2, long j10) {
            this.f24137a = map;
            this.f24138b = str;
            this.f24140d = j10;
            this.f24139c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            k.a(f24078a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.Z)) {
                    jSONObject3.put(f.Z, jSONObject4.getJSONArray(f.Z));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.f23906n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.f23906n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(f.f23913u)) {
                                jSONObject5.remove(f.f23913u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.f23906n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.I)) {
                    jSONObject3.put(f.I, jSONObject4.getJSONObject(f.I));
                }
                if (jSONObject4.has(f.L)) {
                    jSONObject3.put(f.L, jSONObject4.getJSONObject(f.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    public JSONObject b(long j10) {
        if (TextUtils.isEmpty(aa.a().d(UMGlobalContext.getAppContext(f24078a)))) {
            return null;
        }
        JSONObject b10 = k.a(UMGlobalContext.getAppContext(f24078a)).b(false);
        String[] a10 = com.umeng.analytics.c.a(f24078a);
        if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f.M, a10[0]);
                jSONObject.put(f.N, a10[1]);
                if (jSONObject.length() > 0) {
                    b10.put(f.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a11 = t.a().a(f24078a);
        if (b10.length() == 1 && b10.optJSONObject(f.L) != null && a11 != 3) {
            return null;
        }
        t.a().b(b10, f24078a);
        if (b10.length() <= 0 && a11 != 3) {
            return null;
        }
        JSONObject k10 = k();
        if (k10 != null) {
            b(k10);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (a11 == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (b10.length() > 0) {
                jSONObject3.put("analytics", b10);
            }
            if (k10 != null && k10.length() > 0) {
                jSONObject2.put("header", k10);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j10);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z10) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f24090b == null) {
            this.f24090b = new c();
        }
        this.f24090b.a();
        ReportPolicy.ReportStrategy c10 = this.f24090b.c();
        boolean shouldSendMessage = c10.shouldSendMessage(z10);
        if (shouldSendMessage) {
            if (((c10 instanceof ReportPolicy.ReportByInterval) || (c10 instanceof ReportPolicy.DebugPolicy) || (c10 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c10 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c10.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f24088y;
        if (cls == null || (method = f24089z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(f.f23906n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.f23906n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.f23906n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.L)) {
                    jSONObject3.put(f.L, jSONObject4.getJSONObject(f.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    public void a(Object obj, int i10) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i10 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                j.a(f24078a);
                com.umeng.commonsdk.utils.c.c(f24078a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i10 != 4358) {
                    switch (i10) {
                        case 4097:
                            if (UMUtils.isMainProgress(f24078a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if (f24086t.equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(f24078a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f24078a), new JSONArray().put(obj));
                            return;
                        case 4098:
                            if (obj != null) {
                                e(obj);
                            }
                            if (f24086t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case 4099:
                            x.a(f24078a);
                            return;
                        case 4100:
                            n.c(f24078a);
                            return;
                        case 4101:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case 4102:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case 4103:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            w.a().a(f24078a, obj);
                            synchronized (this.f24103w) {
                                this.f24102v = true;
                            }
                            return;
                        case a.f24111h /* 4104 */:
                            w.a().c(f24078a, obj);
                            return;
                        case 4105:
                            d();
                            return;
                        case 4106:
                            h(obj);
                            return;
                        default:
                            switch (i10) {
                                case a.f24114k /* 4352 */:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    w.a().b(f24078a, obj);
                                    synchronized (this.f24103w) {
                                        this.f24101u = true;
                                    }
                                    return;
                                case a.f24115l /* 4353 */:
                                    a(obj, true);
                                    return;
                                case a.f24116m /* 4354 */:
                                    c();
                                    return;
                                case a.f24117n /* 4355 */:
                                    if (!UMUtils.isMainProgress(f24078a)) {
                                        UMProcessDBHelper.getInstance(f24078a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f24078a), new JSONArray().put(obj));
                                        return;
                                    } else {
                                        if (obj != null) {
                                            e(obj);
                                            d();
                                            return;
                                        }
                                        return;
                                    }
                                case a.f24118o /* 4356 */:
                                    if (obj == null || f24088y == null || f24089z == null) {
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has(f.M)) {
                                            str = jSONObject.getString(f.M);
                                            str2 = jSONObject.getString("uid");
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i10) {
                                        case a.f24123t /* 8195 */:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case a.f24124u /* 8196 */:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case 8197:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i10) {
                                                case a.f24126w /* 8199 */:
                                                case a.f24127x /* 8200 */:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case a.f24128y /* 8201 */:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i10) {
                                                        case a.f24129z /* 8208 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = f24078a;
                                                            UMWorkDispatch.sendEvent(context, a.A, CoreProtocol.getInstance(context), null);
                                                            Context context2 = f24078a;
                                                            UMWorkDispatch.sendEvent(context2, a.f24116m, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case a.A /* 8209 */:
                                                            a(obj, false);
                                                            return;
                                                        case a.B /* 8210 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (!UMUtils.isMainProgress(f24078a) || (this.f24090b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                return;
                                                            }
                                                            a(true);
                                                            return;
                                                        default:
                                                            switch (i10) {
                                                                case a.E /* 8213 */:
                                                                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                        if (DeviceConfig.getGlobleActivity(f24078a) != null) {
                                                                            w.b(f24078a);
                                                                        }
                                                                        Context context3 = f24078a;
                                                                        UMWorkDispatch.sendEventEx(context3, a.E, CoreProtocol.getInstance(context3), null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.F /* 8214 */:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                        String optString2 = ((JSONObject) obj).optString("period");
                                                                        String optString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = f24078a;
                                                                        String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                        com.umeng.common.b.a(context4, str3, AnalyticsConfig.RTD_START_TIME, optString);
                                                                        com.umeng.common.b.a(f24078a, str3, "period", optString2);
                                                                        com.umeng.common.b.a(f24078a, str3, AnalyticsConfig.DEBUG_KEY, optString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.G /* 8215 */:
                                                                    com.umeng.common.b.a(f24078a, AnalyticsConfig.RTD_SP_FILE);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                if (obj != null && (obj instanceof JSONObject)) {
                    String optString4 = ((JSONObject) obj).optString(f.S);
                    Object opt = ((JSONObject) obj).opt(f.T);
                    if (TextUtils.isEmpty(optString4)) {
                        return;
                    }
                    String[] a10 = com.umeng.analytics.c.a(f24078a);
                    if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
                        if (f.O.equals(optString4)) {
                            com.umeng.analytics.c.a((String) opt);
                            return;
                        } else if (f.P.equals(optString4)) {
                            com.umeng.analytics.c.b((String) opt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(optString4, opt);
                            return;
                        }
                    }
                    MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f24078a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(f.M);
                String string2 = jSONObject.getString("uid");
                long j10 = jSONObject.getLong("ts");
                String[] a10 = com.umeng.analytics.c.a(f24078a);
                if (a10 != null && string.equals(a10[0]) && string2.equals(a10[1])) {
                    return;
                }
                w.a().a(f24078a, j10);
                String c10 = aa.a().c(f24078a);
                boolean b10 = w.a().b(f24078a, j10, false);
                com.umeng.analytics.c.a(f24078a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c10);
                w.a().a(f24078a, j10, true);
                if (b10) {
                    w.a().b(f24078a, j10);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j10 = 0;
        try {
            Context context = f24078a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j11 = sharedPreferences.getLong(f24079l, 0L);
            if (j11 == 0) {
                try {
                    j10 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f24079l, j10).commit();
                    return j10;
                } catch (Throwable unused) {
                }
            }
            return j11;
        } catch (Throwable unused2) {
            return j10;
        }
    }

    public void c(Object obj) {
        b(f24078a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j10 = jSONObject.getLong("ts");
                b(f24078a);
                d();
                String[] a10 = com.umeng.analytics.c.a(f24078a);
                if (a10 == null || TextUtils.isEmpty(a10[0]) || TextUtils.isEmpty(a10[1])) {
                    return;
                }
                w.a().a(f24078a, j10);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + aa.a().c(f24078a));
                boolean b10 = w.a().b(f24078a, j10, false);
                com.umeng.analytics.c.b(f24078a);
                w.a().a(f24078a, j10, true);
                if (b10) {
                    w.a().b(f24078a, j10);
                }
            }
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th2);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            jSONObject = null;
            k.a(f24078a).a(true, false);
            k.a(f24078a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z10) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = k.a(f24078a).a(z10);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(f.f23906n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(f.f23906n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i10 = 0;
                        while (i10 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i10);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(f.f23912t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(f.f23913u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(f.f23912t, optJSONArray2);
                                jSONObject2.remove(f.f23913u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i11));
                                }
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i12));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(f.f23916x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(f.f23912t, jSONArray5);
                                jSONObject2.remove(f.f23913u);
                            }
                            if (jSONObject2.has(f.f23912t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(f.f23912t);
                                int i13 = 0;
                                while (i13 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i13);
                                    if (jSONObject3.has(f.f23916x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(f.f23916x));
                                        jSONObject3.remove(f.f23916x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i13++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(f.f23912t, optJSONArray3);
                                jSONObject2.put(f.f23918z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(f.f23918z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i10++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(f.f23906n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e10) {
                    MLog.e("merge pages error");
                    e10.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24078a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a10 = com.umeng.analytics.c.a(f24078a);
            if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(f.M, a10[0]);
                jSONObject4.put(f.N, a10[1]);
                if (jSONObject4.length() > 0) {
                    JSONObject jSONObject5 = new JSONObject();
                    String a11 = com.umeng.analytics.c.a();
                    if (a11 != null) {
                        jSONObject5.put(f.O, a11);
                    }
                    String b10 = com.umeng.analytics.c.b();
                    if (b10 != null) {
                        jSONObject5.put(f.P, b10);
                    }
                    Map<String, Object> c10 = com.umeng.analytics.c.c(f24078a);
                    if (c10 != null && c10.size() > 0) {
                        for (String str : c10.keySet()) {
                            jSONObject5.put(str, c10.get(str));
                        }
                    }
                    if (jSONObject5.length() > 0) {
                        jSONObject4.put(f.R, jSONObject5);
                    }
                    jSONObject.put(f.L, jSONObject4);
                }
            }
            if (ABTest.getService(f24078a).isInTest()) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(ABTest.getService(f24078a).getTestName(), ABTest.getService(f24078a).getGroupInfo());
                jSONObject.put(f.K, jSONObject6);
            }
            t.a().a(jSONObject, f24078a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z10) {
        if (this.f24090b == null) {
            this.f24090b = new c();
        }
        ReportPolicy.ReportStrategy c10 = this.f24090b.c();
        if (!(c10 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z10) {
            return ((ReportPolicy.DefconPolicy) c10).shouldSendMessageByInstant();
        }
        return c10.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            f(jSONObject);
                        }
                    } else {
                        f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            k.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z10) {
        if (c(z10)) {
            if (!(this.f24090b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f24078a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z10) {
                if (UMEnvelopeBuild.isOnline(f24078a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f24078a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i10++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    public JSONObject a(long j10) {
        if (TextUtils.isEmpty(aa.a().d(f24078a))) {
            return null;
        }
        JSONObject b10 = b(false);
        int a10 = t.a().a(f24078a);
        if (b10.length() > 0) {
            if (b10.length() == 1) {
                if (b10.optJSONObject(f.L) != null && a10 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                    return null;
                }
            } else if (b10.length() == 2 && b10.optJSONObject(f.L) != null && !TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                return null;
            }
            String optString = b10.optString(f.f23906n);
            String optString2 = b10.optString(f.Z);
            String optString3 = b10.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b10)) {
                return null;
            }
        } else if (a10 != 3) {
            return null;
        }
        JSONObject l10 = l();
        if (l10 != null) {
            c(l10);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a10 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b10.length() > 0) {
                jSONObject2.put("analytics", b10);
            }
            if (l10 != null && l10.length() > 0) {
                jSONObject.put("header", l10);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j10);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(f.aH, s.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return s.a(f24078a, j10, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j10, int i10) {
        if (j10 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j10 <= 28800000) {
            return i10 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            g(jSONObject);
                        }
                    } else {
                        g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z10) {
        if (z10) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f24078a) && d(true)) {
            i();
        }
    }
}
