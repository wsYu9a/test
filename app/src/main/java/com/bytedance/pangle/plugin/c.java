package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final h f6202a = h.a();

    /* renamed from: com.bytedance.pangle.plugin.c$1 */
    final class AnonymousClass1 implements a.InterfaceC0067a {

        /* renamed from: a */
        final /* synthetic */ Plugin f6203a;

        /* renamed from: b */
        final /* synthetic */ String f6204b;

        /* renamed from: c */
        final /* synthetic */ File f6205c;

        /* renamed from: d */
        final /* synthetic */ File f6206d;

        /* renamed from: e */
        final /* synthetic */ StringBuilder f6207e;

        AnonymousClass1(Plugin plugin, String str, File file, File file2, StringBuilder sb) {
            r2 = plugin;
            r3 = str;
            r4 = file;
            r5 = file2;
            r6 = sb;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0067a
        public final void a() {
            c.this.a(r2, r3, r4, r5, r6);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$2 */
    final class AnonymousClass2 implements a.InterfaceC0067a {

        /* renamed from: a */
        final /* synthetic */ PackageInfo[] f6209a;

        /* renamed from: b */
        final /* synthetic */ String f6210b;

        /* renamed from: c */
        final /* synthetic */ Plugin f6211c;

        /* renamed from: d */
        final /* synthetic */ StringBuilder f6212d;

        /* renamed from: e */
        final /* synthetic */ String f6213e;

        /* renamed from: f */
        final /* synthetic */ File f6214f;

        AnonymousClass2(PackageInfo[] packageInfoArr, String str, Plugin plugin, StringBuilder sb, String str2, File file) {
            r2 = packageInfoArr;
            r3 = str;
            r4 = plugin;
            r5 = sb;
            r6 = str2;
            r7 = file;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0067a
        public final void a() {
            r2[0] = c.this.a(r3, r4, r5, r6, r7);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$3 */
    final class AnonymousClass3 implements ComponentCallbacks {

        /* renamed from: a */
        final /* synthetic */ Plugin f6216a;

        AnonymousClass3(Plugin plugin) {
            plugin = plugin;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
            plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$4 */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Plugin f6218a;

        AnonymousClass4(Plugin plugin) {
            plugin = plugin;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                PluginClassLoader pluginClassLoader = plugin.mClassLoader;
                pluginClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
            } catch (Throwable unused) {
            }
        }
    }

    c() {
    }

    final boolean a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            if (!plugin.isInstalled()) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                return false;
            }
            if (plugin.isLoaded()) {
                return true;
            }
            h hVar = f6202a;
            hVar.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f6011g, b.a.D, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean a3 = a(str, plugin, sb);
            a2.a("loadPluginInternal:".concat(String.valueOf(a3)));
            if (a3) {
                plugin.setLifeCycle(3);
                a(com.bytedance.pangle.c.b.f6012h, b.a.E, plugin.mPkgName, plugin.getVersion(), a2.a(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                hVar.a(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                sb.append("plugin:");
                sb.append(plugin.mPkgName);
                sb.append(" versionCode:");
                sb.append(plugin.getVersion());
                sb.append("load failed;");
                a(com.bytedance.pangle.c.b.f6012h, b.a.F, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                hVar.a(ZeusPluginEventCallback.EVENT_FINISH_LOAD, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0182 A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:29:0x015e, B:31:0x0182, B:37:0x01aa, B:39:0x01b0, B:40:0x01b3, B:42:0x01bb, B:43:0x0214, B:46:0x01f1), top: B:28:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01aa A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:29:0x015e, B:31:0x0182, B:37:0x01aa, B:39:0x01b0, B:40:0x01b3, B:42:0x01bb, B:43:0x0214, B:46:0x01f1), top: B:28:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01bb A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:29:0x015e, B:31:0x0182, B:37:0x01aa, B:39:0x01b0, B:40:0x01b3, B:42:0x01bb, B:43:0x0214, B:46:0x01f1), top: B:28:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f1 A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:29:0x015e, B:31:0x0182, B:37:0x01aa, B:39:0x01b0, B:40:0x01b3, B:42:0x01bb, B:43:0x0214, B:46:0x01f1), top: B:28:0x015e }] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r22, com.bytedance.pangle.plugin.Plugin r23, java.lang.StringBuilder r24) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.c.a(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    private static void a(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(":")) {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                } else {
                    activityInfo.processName = "main";
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                } else {
                    serviceInfo.processName = "main";
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                } else {
                    activityInfo2.processName = "main";
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                } else {
                    providerInfo.processName = "main";
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, ProviderInfo> hashMap = plugin.pluginProvider;
        if (hashMap != null && hashMap.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    public PackageInfo a(String str, Plugin plugin, StringBuilder sb, String str2, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, org.mozilla.universalchardet.prober.n.a.q);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.c.3

            /* renamed from: a */
            final /* synthetic */ Plugin f6216a;

            AnonymousClass3(Plugin plugin2) {
                plugin = plugin2;
            }

            @Override // android.content.ComponentCallbacks
            public final void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }

            @Override // android.content.ComponentCallbacks
            public final void onLowMemory() {
            }
        });
        sb.append("makeResources cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        return packageArchiveInfo;
    }

    public void a(Plugin plugin, String str, File file, File file2, StringBuilder sb) {
        long currentTimeMillis = System.currentTimeMillis();
        a(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.c.4

                /* renamed from: a */
                final /* synthetic */ Plugin f6218a;

                AnonymousClass4(Plugin plugin2) {
                    plugin = plugin2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        PluginClassLoader pluginClassLoader = plugin.mClassLoader;
                        pluginClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin2.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                a(plugin2, str2);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            sb.append("actStubV1 cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis2);
            sb.append(";");
            throw th;
        }
        sb.append("actStubV1 cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    private static void a(Plugin plugin, String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap hashMap = new HashMap();
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject2.getString(next));
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("forceMappings");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("minApi", 0);
                int optInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= optInt2 && apiVersionCode >= optInt && (optJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : hashMap.keySet()) {
            String str3 = (String) hashMap.get(str2);
            String str4 = plugin.mPkgName;
            StringBuilder sb = new StringBuilder();
            sb.append((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "");
            sb.append((String) hashMap.get(str2));
            ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j2))));
            jSONObject2.putOpt(com.heytap.mcssdk.n.d.l, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static void a(Object obj, String str) {
        try {
            MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
        }
    }

    private static void a(Plugin plugin, String str, File file, File file2) {
        if (i.k()) {
            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            a(pluginClassLoader, str);
            return;
        }
        if (i.b()) {
            String a2 = g.a(plugin.mPkgName, plugin.getVersion());
            String[] split = a2.split(":");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = !com.bytedance.pangle.e.b.a(file2.getAbsolutePath(), split);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - currentTimeMillis) + " " + z);
            PluginClassLoader pluginClassLoader2 = new PluginClassLoader(z ? "" : a2, file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader2;
            if (z) {
                com.bytedance.pangle.dex.a.a(pluginClassLoader2, plugin.mPkgName, plugin.getVersion());
                return;
            }
            return;
        }
        plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
    }
}
