package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class w implements aa.a {

    /* renamed from: a */
    public static final String f24158a = "session_start_time";

    /* renamed from: b */
    public static final String f24159b = "session_end_time";

    /* renamed from: c */
    public static final String f24160c = "session_id";

    /* renamed from: d */
    public static final String f24161d = "pre_session_id";

    /* renamed from: e */
    public static final String f24162e = "a_start_time";

    /* renamed from: f */
    public static final String f24163f = "a_end_time";

    /* renamed from: g */
    public static final String f24164g = "fg_count";

    /* renamed from: h */
    private static String f24165h = null;

    /* renamed from: i */
    private static Context f24166i = null;

    /* renamed from: j */
    private static boolean f24167j = false;

    /* renamed from: k */
    private static long f24168k = 0;

    /* renamed from: l */
    private static boolean f24169l = true;

    /* renamed from: m */
    private static long f24170m;

    public static class a {

        /* renamed from: a */
        private static final w f24171a = new w();

        private a() {
        }
    }

    public /* synthetic */ w(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static w a() {
        return a.f24171a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24166i);
        if (sharedPreferences != null) {
            long j10 = sharedPreferences.getLong(f24164g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f24164g, j10 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f24164g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f24166i == null && context != null) {
            f24166i = context.getApplicationContext();
        }
        String d10 = aa.a().d(f24166i);
        try {
            f(context);
            q.a(f24166i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d10;
    }

    private void f(Context context) {
        q.a(context).b(context);
        q.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f24166i == null && context != null) {
                f24166i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f24162e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f24163f, longValue);
            edit.putLong(f24159b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private w() {
        aa.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f24164g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j10) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24166i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f24158a, j10);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f24166i == null) {
                f24166i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24166i);
            if (sharedPreferences == null) {
                return;
            }
            f24168k = sharedPreferences.getLong(f24163f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f24168k);
            String string = sharedPreferences.getString(f.aF, "");
            String appVersionName = UMUtils.getAppVersionName(f24166i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f24158a, longValue);
                edit.commit();
                q.a(f24166i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + aa.a().c(f24166i));
                f24167j = true;
                a(f24166i, longValue, true);
                return;
            }
            if (aa.a().e(f24166i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f24167j = true;
                edit.putLong(f24158a, longValue);
                edit.commit();
                a(f24166i, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f24167j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f24166i == null && context != null) {
                f24166i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24166i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(f.aF, "");
            String appVersionName = UMUtils.getAppVersionName(f24166i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(f.aF, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i10 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(f.aF, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(f.aF, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i10);
                edit.putString("vers_name", string);
                edit.commit();
                if (f24169l) {
                    f24169l = false;
                }
                if (f24167j) {
                    f24167j = false;
                    b(f24166i, longValue, true);
                    b(f24166i, longValue);
                    return;
                }
                return;
            }
            if (f24167j) {
                f24167j = false;
                if (f24169l) {
                    f24169l = false;
                }
                f24165h = e(context);
                MLog.d("创建新会话: " + f24165h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f24165h);
                return;
            }
            f24165h = sharedPreferences.getString("session_id", null);
            edit.putLong(f24162e, longValue);
            edit.putLong(f24163f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + f24165h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f24165h);
            if (f24169l) {
                f24169l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    Context context2 = f24166i;
                    UMWorkDispatch.sendEventEx(context2, q.a.E, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            q.a(f24166i).a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f24165h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f24165h;
    }

    @Deprecated
    public String c() {
        return c(f24166i);
    }

    public boolean b(Context context, long j10, boolean z10) {
        String a10;
        long j11;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (a10 = aa.a().a(f24166i)) == null) {
                return false;
            }
            long j12 = sharedPreferences.getLong(f24162e, 0L);
            long j13 = sharedPreferences.getLong(f24163f, 0L);
            if (j12 <= 0 || j13 != 0) {
                return false;
            }
            try {
                if (z10) {
                    j11 = f24168k;
                    if (j11 == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j10);
                        j11 = j10;
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f24168k);
                    }
                    c(f24166i, Long.valueOf(j11));
                } else {
                    c(f24166i, Long.valueOf(j10));
                    j11 = j10;
                }
                JSONObject jSONObject = new JSONObject();
                if (z10) {
                    jSONObject.put(g.d.a.f23968g, j11);
                } else {
                    jSONObject.put(g.d.a.f23968g, j10);
                }
                JSONObject b10 = com.umeng.analytics.b.a().b();
                if (b10 != null && b10.length() > 0) {
                    jSONObject.put("__sp", b10);
                }
                JSONObject c10 = com.umeng.analytics.b.a().c();
                if (c10 != null && c10.length() > 0) {
                    jSONObject.put("__pp", c10);
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f24170m);
                    jSONObject.put(g.d.a.f23969h, f24170m);
                    f24170m = 0L;
                } else {
                    jSONObject.put(g.d.a.f23969h, 0L);
                }
                k.a(context).a(a10, jSONObject, k.a.END);
                q.a(f24166i).e();
            } catch (Throwable unused) {
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public String a(Context context, long j10, boolean z10) {
        String b10 = aa.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b10);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j10);
            JSONObject b11 = com.umeng.analytics.b.a().b();
            if (b11 != null && b11.length() > 0) {
                jSONObject.put("__sp", b11);
            }
            JSONObject c10 = com.umeng.analytics.b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            k.a(context).a(b10, jSONObject, k.a.INSTANTSESSIONBEGIN);
            q.a(context).a(jSONObject, z10);
        } catch (Throwable unused) {
        }
        return b10;
    }

    public void b(Context context, long j10) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            q.a(f24166i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String b() {
        return f24165h;
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(String str, String str2, long j10, long j11, long j12) {
        a(f24166i, str2, j10, j11, j12);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f24166i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j10);
    }

    private void a(Context context, String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(f24165h)) {
            f24165h = aa.a().a(f24166i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f24165h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.d.a.f23968g, j11);
            jSONObject.put(g.d.a.f23969h, j12);
            JSONObject b10 = com.umeng.analytics.b.a().b();
            if (b10 != null && b10.length() > 0) {
                jSONObject.put("__sp", b10);
            }
            JSONObject c10 = com.umeng.analytics.b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            k.a(context).a(f24165h, jSONObject, k.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j10);
            k.a(context).a(str, jSONObject2, k.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f24170m = j12;
                d(context);
                Context context2 = f24166i;
                UMWorkDispatch.sendEventEx(context2, q.a.E, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f24165h = str;
    }

    private void a(String str, long j10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24166i);
        if (sharedPreferences == null) {
            return;
        }
        long j11 = sharedPreferences.getLong(f24159b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j10);
            jSONObject.put(g.d.a.f23968g, j11);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(f.C, location[0]);
                jSONObject2.put(f.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(g.d.a.f23966e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i10 = f24166i.getApplicationInfo().uid;
            if (i10 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i10))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i10))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(f.H, longValue);
                jSONObject3.put(f.G, longValue2);
                jSONObject.put(g.d.a.f23965d, jSONObject3);
            }
            k.a(f24166i).a(str, jSONObject, k.a.NEWSESSION);
            x.a(f24166i);
            n.c(f24166i);
        } catch (Throwable unused) {
        }
    }
}
