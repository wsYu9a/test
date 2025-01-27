package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.gv;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class lg implements TTInitializer {

    /* renamed from: i */
    private static final Map<String, Bundle> f6434i = new ConcurrentHashMap();

    /* renamed from: j */
    public static ScheduledExecutorService f6435j = Executors.newSingleThreadScheduledExecutor(new zx());
    private volatile TTInitializer zx;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.lg$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ TTAdSdk.InitCallback f6436g;

        /* renamed from: i */
        final /* synthetic */ Context f6437i;

        /* renamed from: j */
        final /* synthetic */ q f6438j;
        final /* synthetic */ AdConfig zx;

        AnonymousClass1(q qVar, AdConfig adConfig, Context context, TTAdSdk.InitCallback initCallback) {
            qVar = qVar;
            adConfig = adConfig;
            context = context;
            initCallback = initCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            qVar.zx("wait_asyn_cost");
            TTInitializer j2 = lg.this.j(adConfig, qVar);
            if (j2 == null) {
                initCallback.fail(4201, "No initializer");
                return;
            }
            com.bytedance.sdk.openadsdk.api.plugin.j.f6388j.j(j2.getAdManager());
            j2.init(context, adConfig, initCallback);
            j2.getAdManager().register(com.bytedance.sdk.openadsdk.j.zx.j());
        }
    }

    private static class j implements TTAdSdk.InitCallback {

        /* renamed from: j */
        private TTAdSdk.InitCallback f6439j;

        public j(TTAdSdk.InitCallback initCallback) {
            this.f6439j = initCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            TTAdSdk.InitCallback initCallback = this.f6439j;
            if (initCallback != null) {
                initCallback.fail(i2, str);
                g.zx(i2, str, 0L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            TTAdSdk.InitCallback initCallback = this.f6439j;
            if (initCallback != null) {
                initCallback.success();
            }
            g.j();
        }
    }

    private static TTInitializer zx(AdConfig adConfig, q qVar) {
        gv j2;
        BaseDexClassLoader j3;
        try {
            qVar.zx("call_create_initializer");
            j2 = gv.j(TTAppContextHolder.getContext());
            j3 = j2.j(qVar);
        } catch (Throwable th) {
            if (th instanceof i) {
                i iVar = th;
                g.j(iVar.j(), iVar.getMessage(), 0L);
            } else {
                g.j(6, th.getMessage(), 0L);
            }
            com.bytedance.sdk.openadsdk.api.j.q("TTPluginManager", "Create initializer failed: " + th);
        }
        if (j3 == null) {
            g.j(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.j.q("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> loadClass = j3.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        qVar.zx("get_init_class_cost");
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new gv.zx());
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new gv.i());
        Bundle j4 = j(f6434i);
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, j4);
        qVar.zx("create_bundle_cost");
        bundle.putSerializable(PluginConstants.KEY_LIVE_SDK, com.bytedance.sdk.openadsdk.live.zx.j());
        Bundle j5 = com.bytedance.sdk.openadsdk.live.j.j(j2, adConfig.getAppId());
        com.bytedance.sdk.openadsdk.live.zx.j().j(j2, j5);
        if (j5 != null) {
            j4.putBundle("com.byted.live.lite", j5);
        }
        qVar.zx("live_init_cost");
        Method declaredMethod = loadClass.getDeclaredMethod("getInstance", Bundle.class);
        qVar.zx("get_init_method_cost");
        TTInitializer tTInitializer = (TTInitializer) declaredMethod.invoke(null, bundle);
        qVar.zx("get_init_instance_cost");
        com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.j.f6388j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        gv.j(context).j();
        if (this.zx != null) {
            this.zx.init(context, adConfig, new j(initCallback));
        } else {
            j(context, adConfig, new j(initCallback), q.j("duration"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.zx != null) {
            return this.zx.isInitSuccess();
        }
        return false;
    }

    public static void j(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        f6434i.put(str, bundle);
    }

    public static class zx implements ThreadFactory {

        /* renamed from: i */
        private final String f6440i;

        /* renamed from: j */
        private final ThreadGroup f6441j;
        private final AtomicInteger zx;

        zx() {
            this.zx = new AtomicInteger(1);
            this.f6441j = new ThreadGroup("csj_g_pl_init");
            this.f6440i = "csj_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f6441j, runnable, this.f6440i + this.zx.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        zx(String str) {
            this.zx = new AtomicInteger(1);
            this.f6441j = new ThreadGroup("csj_g_pl_init");
            this.f6440i = str;
        }
    }

    private void j(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback, q qVar) {
        f6435j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.lg.1

            /* renamed from: g */
            final /* synthetic */ TTAdSdk.InitCallback f6436g;

            /* renamed from: i */
            final /* synthetic */ Context f6437i;

            /* renamed from: j */
            final /* synthetic */ q f6438j;
            final /* synthetic */ AdConfig zx;

            AnonymousClass1(q qVar2, AdConfig adConfig2, Context context2, TTAdSdk.InitCallback initCallback2) {
                qVar = qVar2;
                adConfig = adConfig2;
                context = context2;
                initCallback = initCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                qVar.zx("wait_asyn_cost");
                TTInitializer j2 = lg.this.j(adConfig, qVar);
                if (j2 == null) {
                    initCallback.fail(4201, "No initializer");
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.j.f6388j.j(j2.getAdManager());
                j2.init(context, adConfig, initCallback);
                j2.getAdManager().register(com.bytedance.sdk.openadsdk.j.zx.j());
            }
        });
    }

    public TTInitializer j(AdConfig adConfig, q qVar) {
        if (this.zx == null) {
            synchronized (this) {
                if (this.zx == null) {
                    g.j(adConfig);
                    com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", "Create initializer");
                    this.zx = zx(adConfig, qVar);
                    qVar.j();
                    JSONObject jSONObject = new JSONObject();
                    qVar.j(jSONObject, 20L);
                    try {
                        jSONObject.put("zeus", gv.j(TTAppContextHolder.getContext()).zx());
                    } catch (JSONException unused) {
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.zx;
    }

    private static final Bundle j(Map<String, Bundle> map) {
        if (map != null && map.size() != 0) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, Bundle> entry : map.entrySet()) {
                String key = entry.getKey();
                Bundle value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    bundle.putBundle(key, value);
                }
            }
            return bundle;
        }
        return new Bundle();
    }
}
