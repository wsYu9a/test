package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
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
public class u implements y.a {

    /* renamed from: a */
    public static final String f26009a = "session_start_time";

    /* renamed from: b */
    public static final String f26010b = "session_end_time";

    /* renamed from: c */
    public static final String f26011c = "session_id";

    /* renamed from: d */
    public static final String f26012d = "pre_session_id";

    /* renamed from: e */
    public static final String f26013e = "a_start_time";

    /* renamed from: f */
    public static final String f26014f = "a_end_time";

    /* renamed from: g */
    public static final String f26015g = "fg_count";

    /* renamed from: h */
    private static String f26016h = null;

    /* renamed from: i */
    private static Context f26017i = null;

    /* renamed from: j */
    private static boolean f26018j = false;
    private static long k = 0;
    private static boolean l = true;
    private static long m;

    private static class a {

        /* renamed from: a */
        private static final u f26019a = new u();

        private a() {
        }
    }

    /* synthetic */ u(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static u a() {
        return a.f26019a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26017i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f26015g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f26015g, j2 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f26015g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f26017i == null && context != null) {
            f26017i = context.getApplicationContext();
        }
        String d2 = y.a().d(f26017i);
        try {
            f(context);
            o.a(f26017i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d2;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f26017i == null && context != null) {
                f26017i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f26013e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f26014f, longValue);
            edit.putLong(f26010b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f26015g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26017i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f26009a, j2);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f26017i == null) {
                f26017i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26017i);
            if (sharedPreferences == null) {
                return;
            }
            k = sharedPreferences.getLong(f26014f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f26017i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f26009a, longValue);
                edit.commit();
                o.a(f26017i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + y.a().c(f26017i));
                f26018j = true;
                a(f26017i, longValue, true);
                return;
            }
            if (y.a().e(f26017i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f26018j = true;
                edit.putLong(f26009a, longValue);
                edit.commit();
                a(f26017i, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f26018j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f26017i == null && context != null) {
                f26017i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26017i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f26017i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (l) {
                    l = false;
                }
                if (f26018j) {
                    f26018j = false;
                    b(f26017i, longValue, true);
                    b(f26017i, longValue);
                    return;
                }
                return;
            }
            if (f26018j) {
                f26018j = false;
                if (l) {
                    l = false;
                }
                f26016h = e(context);
                MLog.d("创建新会话: " + f26016h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f26016h);
                return;
            }
            f26016h = sharedPreferences.getString("session_id", null);
            edit.putLong(f26013e, longValue);
            edit.putLong(f26014f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + f26016h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f26016h);
            if (l) {
                l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    Context context2 = f26017i;
                    UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            o.a(f26017i).a(false);
        } catch (Throwable unused) {
        }
    }

    public String c(Context context) {
        try {
            if (f26016h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f26016h;
    }

    public String c() {
        return c(f26017i);
    }

    public boolean b(Context context, long j2, boolean z) {
        SharedPreferences sharedPreferences;
        String a2;
        long j3;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (a2 = y.a().a(f26017i)) == null) {
            return false;
        }
        long j4 = sharedPreferences.getLong(f26013e, 0L);
        long j5 = sharedPreferences.getLong(f26014f, 0L);
        if (j4 > 0 && j5 == 0) {
            z2 = true;
            if (z) {
                j3 = k;
                if (j3 == 0) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                    j3 = j2;
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + k);
                }
                c(f26017i, Long.valueOf(j3));
            } else {
                c(f26017i, Long.valueOf(j2));
                j3 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(e.d.a.f25890g, j3);
            } else {
                jSONObject.put(e.d.a.f25890g, j2);
            }
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + m);
                jSONObject.put(e.d.a.f25891h, m);
                m = 0L;
            } else {
                jSONObject.put(e.d.a.f25891h, 0L);
            }
            i.a(context).a(a2, jSONObject, i.a.END);
            o.a(f26017i).e();
        }
        return z2;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f26017i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j2, boolean z) {
        String b2 = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(b2, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return b2;
    }

    public String b() {
        return f26016h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j2, long j3, long j4) {
        a(f26017i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f26017i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(f26016h)) {
            f26016h = y.a().a(f26017i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f26016h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f25890g, j3);
            jSONObject.put(e.d.a.f25891h, j4);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(f26016h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                m = j4;
                d(context);
                Context context2 = f26017i;
                UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f26016h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26017i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f26010b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(e.d.a.f25890g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.C, location[0]);
                jSONObject2.put(d.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f25888e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i2 = f26017i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, longValue);
                jSONObject3.put(d.G, longValue2);
                jSONObject.put(e.d.a.f25887d, jSONObject3);
            }
            i.a(f26017i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f26017i);
            l.c(f26017i);
        } catch (Throwable unused) {
        }
    }
}
