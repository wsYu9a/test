package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vb.e;

/* loaded from: classes4.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bt.aT, a.f24469e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", a.f24469e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            i(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        i(context);
    }

    public static JSONObject d(Context context) {
        JSONObject b10;
        JSONArray g10;
        JSONObject a10;
        JSONArray k10;
        JSONArray j10;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.L) && (j10 = j(applicationContext)) != null && j10.length() > 0) {
                    jSONObject2.put("rs", j10);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (k10 = k(applicationContext)) != null && k10.length() > 0) {
                    jSONObject2.put("by", k10);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && (a10 = a()) != null && a10.length() > 0) {
                    jSONObject2.put("build", a10);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(applicationContext, e14);
            }
            try {
                JSONObject e15 = e(applicationContext);
                if (e15 != null && e15.length() > 0) {
                    jSONObject2.put("scr", e15);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(applicationContext, e16);
            }
            try {
                JSONObject f10 = f(applicationContext);
                if (f10 != null && f10.length() > 0) {
                    jSONObject2.put("sinfo", f10);
                }
            } catch (Exception e17) {
                UMCrashManager.reportCrash(applicationContext, e17);
            }
            try {
                if (UMConfigure.shouldCollectApl()) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is on.");
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.f24842ai) && (g10 = g(applicationContext)) != null && g10.length() > 0) {
                        jSONObject2.put("appls", g10);
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is off.");
                }
            } catch (Exception e18) {
                UMCrashManager.reportCrash(applicationContext, e18);
            }
            try {
                JSONObject h10 = h(applicationContext);
                if (h10 != null && h10.length() > 0) {
                    jSONObject2.put("mem", h10);
                }
            } catch (Exception e19) {
                UMCrashManager.reportCrash(applicationContext, e19);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.as) && (b10 = b()) != null && b10.length() > 0) {
                    jSONObject2.put("cpu", b10);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(bt.aA, jSONObject2);
            } catch (JSONException e20) {
                UMCrashManager.reportCrash(applicationContext, e20);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(context, e10);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put(e.f31300g, com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<a.C0673a> f10;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f10 = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null && !f10.isEmpty()) {
            for (a.C0673a c0673a : f10) {
                if (c0673a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0673a.f24515a);
                        jSONObject.put("a_la", c0673a.f24516b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e10) {
                        UMCrashManager.reportCrash(applicationContext, e10);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject h(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo g10;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (g10 = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null) {
            try {
                jSONObject.put(bt.aO, g10.totalMem);
                jSONObject.put("f", g10.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
        }
        return jSONObject;
    }

    private static void i(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, a.f24470f, b.a(context).a(), null, 5000L);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.f24486v, b.a(context).a(), null, 5000L);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    private static JSONArray j(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i10 = 0; i10 < runningServices.size(); i10++) {
                if (runningServices.get(i10) != null && runningServices.get(i10).service != null && runningServices.get(i10).service.getClassName() != null && runningServices.get(i10).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i10).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i10).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th2) {
                th = th2;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static JSONArray k(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a10 = j.a(context);
        if (!TextUtils.isEmpty(a10)) {
            try {
                jSONArray.put(new JSONObject(a10));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a10 = com.umeng.commonsdk.internal.utils.d.a();
            if (a10 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a10.f24529a);
                jSONObject.put("pla", a10.f24530b);
                jSONObject.put("cpus", a10.f24531c);
                jSONObject.put("fea", a10.f24532d);
                jSONObject.put(bd.f23523c, a10.f24533e);
                jSONObject.put("arc", a10.f24534f);
                jSONObject.put("var", a10.f24535g);
                jSONObject.put("par", a10.f24536h);
                jSONObject.put("rev", a10.f24537i);
                jSONObject.put("har", a10.f24538j);
                jSONObject.put("rev", a10.f24539k);
                jSONObject.put("ser", a10.f24540l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, TypedValues.TransitionType.S_TO, packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z10) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z10) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        String str;
        int i10;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            JSONArray jSONArray = new JSONArray();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
                if (i12 >= strArr.length) {
                    break;
                }
                jSONArray.put(strArr[i12]);
                i12++;
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("a_s32", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            int i13 = 0;
            while (true) {
                String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
                if (i13 >= strArr2.length) {
                    break;
                }
                jSONArray2.put(strArr2[i13]);
                i13++;
            }
            if (jSONArray2.length() > 0) {
                jSONObject.put("a_s64", jSONArray2);
            }
            JSONArray jSONArray3 = new JSONArray();
            while (true) {
                String[] strArr3 = Build.SUPPORTED_ABIS;
                if (i11 >= strArr3.length) {
                    break;
                }
                jSONArray3.put(strArr3[i11]);
                i11++;
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put("a_sa", jSONArray3);
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                str = Build.VERSION.BASE_OS;
                jSONObject.put("a_bos", str);
                i10 = Build.VERSION.PREVIEW_SDK_INT;
                jSONObject.put("a_pre", i10);
                str2 = Build.VERSION.SECURITY_PATCH;
                jSONObject.put("a_sp", str2);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a10 = k.a(context);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a10);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f24552d)) {
                    jSONObject.put(k.f24552d, jSONObject2.opt(k.f24552d));
                }
                if (jSONObject2.has(k.f24551c)) {
                    jSONObject.put(k.f24551c, jSONObject2.opt(k.f24551c));
                }
                if (jSONObject2.has(k.f24550b)) {
                    jSONObject.put(k.f24550b, jSONObject2.opt(k.f24550b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
