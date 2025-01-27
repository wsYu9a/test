package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
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

@TargetApi(14)
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    public static String f24051a;

    /* renamed from: b */
    boolean f24060b;

    /* renamed from: c */
    boolean f24061c;

    /* renamed from: f */
    com.umeng.analytics.vshelper.a f24062f;

    /* renamed from: g */
    Application.ActivityLifecycleCallbacks f24063g;

    /* renamed from: h */
    private final Map<String, Long> f24064h;

    /* renamed from: l */
    private boolean f24065l;

    /* renamed from: m */
    private int f24066m;

    /* renamed from: n */
    private int f24067n;

    /* renamed from: i */
    private static JSONArray f24054i = new JSONArray();

    /* renamed from: j */
    private static Object f24055j = new Object();

    /* renamed from: k */
    private static Application f24056k = null;

    /* renamed from: d */
    static String f24052d = null;

    /* renamed from: e */
    static int f24053e = -1;

    /* renamed from: o */
    private static boolean f24057o = true;

    /* renamed from: p */
    private static Object f24058p = new Object();

    /* renamed from: q */
    private static cd f24059q = new com.umeng.analytics.vshelper.b();

    /* renamed from: com.umeng.analytics.pro.n$1 */
    public class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            n.f24059q.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                synchronized (n.f24058p) {
                    try {
                        if (n.f24057o) {
                            return;
                        }
                    } finally {
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
                n.this.c(activity);
                com.umeng.analytics.b.a().i();
                n.this.f24060b = false;
                n.f24059q.d(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                synchronized (n.f24058p) {
                    try {
                        if (n.f24057o) {
                            boolean unused = n.f24057o = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                n.this.a(activity);
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                n.this.a(activity);
            }
            n.f24059q.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity != null) {
                if (n.this.f24066m <= 0) {
                    if (n.f24052d == null) {
                        n.f24052d = UUID.randomUUID().toString();
                    }
                    if (n.f24053e == -1) {
                        n.f24053e = activity.isTaskRoot() ? 1 : 0;
                    }
                    if (n.f24053e == 0 && UMUtils.isMainProgress(activity)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("activityName", activity.toString());
                        hashMap.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                        if (a10 != null) {
                            a10.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                        }
                        n.f24053e = -2;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, l.ar);
                        }
                    } else if (n.f24053e == 1 || !UMUtils.isMainProgress(activity)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("pairUUID", n.f24052d);
                        hashMap2.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                        hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap2.put("activityName", activity.toString());
                        if (com.umeng.analytics.b.a() != null) {
                            com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                        }
                    }
                }
                if (n.this.f24067n < 0) {
                    n.e(n.this);
                } else {
                    n.f(n.this);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
            MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
            if (activity != null) {
                if (activity.isChangingConfigurations()) {
                    n.a(n.this);
                    return;
                }
                n.b(n.this);
                if (n.this.f24066m <= 0) {
                    if (n.f24053e == 0 && UMUtils.isMainProgress(activity)) {
                        return;
                    }
                    int i10 = n.f24053e;
                    if (i10 == 1 || (i10 == 0 && !UMUtils.isMainProgress(activity))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("pairUUID", n.f24052d);
                        hashMap.put(MediationConstant.KEY_REASON, "Normal");
                        hashMap.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap.put("activityName", activity.toString());
                        com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                        if (a10 != null) {
                            a10.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                        }
                        if (n.f24052d != null) {
                            n.f24052d = null;
                        }
                    }
                }
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private static final n f24069a = new n();

        private a() {
        }
    }

    public /* synthetic */ n(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static /* synthetic */ int a(n nVar) {
        int i10 = nVar.f24067n;
        nVar.f24067n = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int b(n nVar) {
        int i10 = nVar.f24066m;
        nVar.f24066m = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int e(n nVar) {
        int i10 = nVar.f24067n;
        nVar.f24067n = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int f(n nVar) {
        int i10 = nVar.f24066m;
        nVar.f24066m = i10 + 1;
        return i10;
    }

    private void g() {
        if (this.f24065l) {
            return;
        }
        this.f24065l = true;
        if (f24056k != null) {
            f24056k.registerActivityLifecycleCallbacks(this.f24063g);
        }
    }

    private n() {
        this.f24064h = new HashMap();
        this.f24065l = false;
        this.f24060b = false;
        this.f24061c = false;
        this.f24066m = 0;
        this.f24067n = 0;
        this.f24062f = PageNameMonitor.getInstance();
        this.f24063g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.n.1
            public AnonymousClass1() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                n.f24059q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (n.f24058p) {
                        try {
                            if (n.f24057o) {
                                return;
                            }
                        } finally {
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
                    n.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    n.this.f24060b = false;
                    n.f24059q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (n.f24058p) {
                        try {
                            if (n.f24057o) {
                                boolean unused = n.f24057o = false;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    n.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    n.this.a(activity);
                }
                n.f24059q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (n.this.f24066m <= 0) {
                        if (n.f24052d == null) {
                            n.f24052d = UUID.randomUUID().toString();
                        }
                        if (n.f24053e == -1) {
                            n.f24053e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (n.f24053e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                            if (a10 != null) {
                                a10.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            n.f24053e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, l.ar);
                            }
                        } else if (n.f24053e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", n.f24052d);
                            hashMap2.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (n.this.f24067n < 0) {
                        n.e(n.this);
                    } else {
                        n.f(n.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        n.a(n.this);
                        return;
                    }
                    n.b(n.this);
                    if (n.this.f24066m <= 0) {
                        if (n.f24053e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i10 = n.f24053e;
                        if (i10 == 1 || (i10 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", n.f24052d);
                            hashMap.put(MediationConstant.KEY_REASON, "Normal");
                            hashMap.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                            if (a10 != null) {
                                a10.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (n.f24052d != null) {
                                n.f24052d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                if (f24056k != null) {
                    g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f24058p) {
            if (f24057o) {
                f24057o = false;
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
                synchronized (f24055j) {
                    jSONArray = f24054i.toString();
                    f24054i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(g.d.a.f23964c, new JSONArray(jSONArray));
                    k.a(context).a(w.a().c(), jSONObject, k.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f24065l;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            try {
                if (f24056k == null && context != null) {
                    if (context instanceof Activity) {
                        f24056k = ((Activity) context).getApplication();
                    } else if (context instanceof Application) {
                        f24056k = (Application) context;
                    }
                }
                nVar = a.f24069a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return nVar;
    }

    public static void a(Context context, String str) {
        if (f24053e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f24052d);
            hashMap.put(MediationConstant.KEY_REASON, str);
            if (f24052d != null) {
                f24052d = null;
            }
            if (context != null) {
                hashMap.put(ExposeManager.UtArgsNames.pid, Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f24065l = false;
        if (f24056k != null) {
            f24056k.unregisterActivityLifecycleCallbacks(this.f24063g);
            f24056k = null;
        }
    }

    public void c(Activity activity) {
        long j10;
        long j11;
        try {
            synchronized (this.f24064h) {
                try {
                    if (f24051a == null && activity != null) {
                        f24051a = activity.getPackageName() + p1.b.f29697h + activity.getLocalClassName();
                    }
                    if (TextUtils.isEmpty(f24051a) || !this.f24064h.containsKey(f24051a)) {
                        j10 = 0;
                        j11 = 0;
                    } else {
                        j10 = this.f24064h.get(f24051a).longValue();
                        j11 = System.currentTimeMillis() - j10;
                        this.f24064h.remove(f24051a);
                    }
                } finally {
                }
            }
            synchronized (f24055j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(f.f23914v, f24051a);
                    jSONObject.put("duration", j11);
                    jSONObject.put(f.f23916x, j10);
                    jSONObject.put("type", 0);
                    f24054i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f24051a = activity.getPackageName() + p1.b.f29697h + activity.getLocalClassName();
        synchronized (this.f24064h) {
            this.f24064h.put(f24051a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f24058p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + p1.b.f29697h + activity.getLocalClassName();
            this.f24062f.activityResume(str);
            if (this.f24060b) {
                this.f24060b = false;
                if (!TextUtils.isEmpty(f24051a)) {
                    if (f24051a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f24058p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f24051a = str;
                return;
            }
            b(activity);
            synchronized (f24058p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
