package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    public static String f25941a;

    /* renamed from: b */
    boolean f25946b;

    /* renamed from: c */
    boolean f25947c;

    /* renamed from: f */
    com.umeng.analytics.vshelper.a f25948f;

    /* renamed from: g */
    Application.ActivityLifecycleCallbacks f25949g;

    /* renamed from: h */
    private final Map<String, Long> f25950h;
    private boolean l;
    private int m;
    private int n;

    /* renamed from: i */
    private static JSONArray f25944i = new JSONArray();

    /* renamed from: j */
    private static Object f25945j = new Object();
    private static Application k = null;

    /* renamed from: d */
    static String f25942d = null;

    /* renamed from: e */
    static int f25943e = -1;
    private static boolean o = true;
    private static Object p = new Object();
    private static ar q = new com.umeng.analytics.vshelper.b();

    /* renamed from: com.umeng.analytics.pro.l$1 */
    class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            l.q.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                synchronized (l.p) {
                    if (l.o) {
                        return;
                    }
                }
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            } else {
                l.this.c(activity);
                com.umeng.analytics.b.a().i();
                l.this.f25946b = false;
                l.q.d(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                synchronized (l.p) {
                    if (l.o) {
                        boolean unused = l.o = false;
                    }
                }
                l.this.a(activity);
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                l.this.a(activity);
            }
            l.q.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity != null) {
                if (l.this.m <= 0) {
                    if (l.f25942d == null) {
                        l.f25942d = UUID.randomUUID().toString();
                    }
                    if (l.f25943e == -1) {
                        l.f25943e = activity.isTaskRoot() ? 1 : 0;
                    }
                    if (l.f25943e == 0 && UMUtils.isMainProgress(activity)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("activityName", activity.toString());
                        hashMap.put("pid", Integer.valueOf(Process.myPid()));
                        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                        if (a2 != null) {
                            a2.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                        }
                        l.f25943e = -2;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, j.ar);
                        }
                    } else if (l.f25943e == 1 || !UMUtils.isMainProgress(activity)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("pairUUID", l.f25942d);
                        hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                        hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap2.put("activityName", activity.toString());
                        if (com.umeng.analytics.b.a() != null) {
                            com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                        }
                    }
                }
                if (l.this.n < 0) {
                    l.e(l.this);
                } else {
                    l.f(l.this);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
            MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
            if (activity != null) {
                if (activity.isChangingConfigurations()) {
                    l.a(l.this);
                    return;
                }
                l.b(l.this);
                if (l.this.m <= 0) {
                    if (l.f25943e == 0 && UMUtils.isMainProgress(activity)) {
                        return;
                    }
                    int i2 = l.f25943e;
                    if (i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("pairUUID", l.f25942d);
                        hashMap.put("reason", "Normal");
                        hashMap.put("pid", Integer.valueOf(Process.myPid()));
                        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap.put("activityName", activity.toString());
                        com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                        if (a2 != null) {
                            a2.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                        }
                        if (l.f25942d != null) {
                            l.f25942d = null;
                        }
                    }
                }
            }
        }
    }

    private static class a {

        /* renamed from: a */
        private static final l f25952a = new l();

        private a() {
        }
    }

    /* synthetic */ l(AnonymousClass1 anonymousClass1) {
        this();
    }

    static /* synthetic */ int a(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int e(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.l) {
            return;
        }
        this.l = true;
        if (k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        k.registerActivityLifecycleCallbacks(this.f25949g);
    }

    private l() {
        this.f25950h = new HashMap();
        this.l = false;
        this.f25946b = false;
        this.f25947c = false;
        this.m = 0;
        this.n = 0;
        this.f25948f = PageNameMonitor.getInstance();
        this.f25949g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            AnonymousClass1() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.f25946b = false;
                    l.q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            boolean unused = l.o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.m <= 0) {
                        if (l.f25942d == null) {
                            l.f25942d = UUID.randomUUID().toString();
                        }
                        if (l.f25943e == -1) {
                            l.f25943e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f25943e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            l.f25943e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.f25943e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", l.f25942d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (l.this.n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.m <= 0) {
                        if (l.f25943e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = l.f25943e;
                        if (i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", l.f25942d);
                            hashMap.put("reason", "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (l.f25942d != null) {
                                l.f25942d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (p) {
            if (o) {
                o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f25945j) {
                    jSONArray = f25944i.toString();
                    f25944i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(e.d.a.f25886c, new JSONArray(jSONArray));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.l;
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (k == null && context != null) {
                if (context instanceof Activity) {
                    k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    k = (Application) context;
                }
            }
            lVar = a.f25952a;
        }
        return lVar;
    }

    public static void a(Context context, String str) {
        if (f25943e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f25942d);
            hashMap.put("reason", str);
            if (f25942d != null) {
                f25942d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.l = false;
        if (k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                k.unregisterActivityLifecycleCallbacks(this.f25949g);
            }
            k = null;
        }
    }

    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f25950h) {
                if (f25941a == null && activity != null) {
                    f25941a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(f25941a) || !this.f25950h.containsKey(f25941a)) {
                    j3 = 0;
                } else {
                    long longValue = this.f25950h.get(f25941a).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    this.f25950h.remove(f25941a);
                    j2 = currentTimeMillis;
                    j3 = longValue;
                }
            }
            synchronized (f25945j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, f25941a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(d.x, j3);
                    jSONObject.put("type", 0);
                    f25944i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f25941a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f25950h) {
            this.f25950h.put(f25941a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f25948f.activityResume(str);
            if (this.f25946b) {
                this.f25946b = false;
                if (!TextUtils.isEmpty(f25941a)) {
                    if (f25941a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f25941a = str;
                return;
            }
            b(activity);
            synchronized (p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
