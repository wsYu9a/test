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
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
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

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    private static final i f7709a = i.a();

    /* renamed from: com.bytedance.pangle.plugin.c$1 */
    public class AnonymousClass1 implements a.InterfaceC0226a {

        /* renamed from: a */
        final /* synthetic */ Plugin f7710a;

        /* renamed from: b */
        final /* synthetic */ String f7711b;

        /* renamed from: c */
        final /* synthetic */ File f7712c;

        /* renamed from: d */
        final /* synthetic */ File f7713d;

        /* renamed from: e */
        final /* synthetic */ StringBuilder f7714e;

        public AnonymousClass1(Plugin plugin, String str, File file, File file2, StringBuilder sb2) {
            r2 = plugin;
            r3 = str;
            r4 = file;
            r5 = file2;
            r6 = sb2;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0226a
        public final void a() {
            c.this.a(r2, r3, r4, r5, r6);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$2 */
    public class AnonymousClass2 implements a.InterfaceC0226a {

        /* renamed from: a */
        final /* synthetic */ PackageInfo[] f7716a;

        /* renamed from: b */
        final /* synthetic */ String f7717b;

        /* renamed from: c */
        final /* synthetic */ Plugin f7718c;

        /* renamed from: d */
        final /* synthetic */ StringBuilder f7719d;

        /* renamed from: e */
        final /* synthetic */ String f7720e;

        /* renamed from: f */
        final /* synthetic */ File f7721f;

        public AnonymousClass2(PackageInfo[] packageInfoArr, String str, Plugin plugin, StringBuilder sb2, String str2, File file) {
            r2 = packageInfoArr;
            r3 = str;
            r4 = plugin;
            r5 = sb2;
            r6 = str2;
            r7 = file;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0226a
        public final void a() {
            r2[0] = c.this.a(r3, r4, r5, r6, r7);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.c$3 */
    public class AnonymousClass3 implements ComponentCallbacks {

        /* renamed from: a */
        final /* synthetic */ Plugin f7723a;

        public AnonymousClass3(Plugin plugin) {
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
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Plugin f7725a;

        public AnonymousClass4(Plugin plugin) {
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

    public final boolean a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            try {
                if (!plugin.isInstalled()) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                    return false;
                }
                if (plugin.isLoaded()) {
                    return true;
                }
                i iVar = f7709a;
                iVar.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
                com.bytedance.pangle.log.a a10 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.c.b.f7490i, b.a.D, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
                ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                boolean a11 = a(str, plugin, sb2);
                a10.a("loadPluginInternal:".concat(String.valueOf(a11)));
                if (a11) {
                    plugin.setLifeCycle(3);
                    a(com.bytedance.pangle.c.b.f7491j, b.a.E, plugin.mPkgName, plugin.getVersion(), a10.a(), sb2.toString());
                    ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                    iVar.a(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 0, plugin.mPkgName, plugin.getVersion(), null);
                } else {
                    sb2.append("plugin:");
                    sb2.append(plugin.mPkgName);
                    sb2.append(" versionCode:");
                    sb2.append(plugin.getVersion());
                    sb2.append("load failed;");
                    a(com.bytedance.pangle.c.b.f7491j, b.a.F, plugin.mPkgName, plugin.getVersion(), -1L, sb2.toString());
                    ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                    iVar.a(ZeusPluginEventCallback.EVENT_FINISH_LOAD, -1, plugin.mPkgName, plugin.getVersion(), null);
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (!plugin.isLoaded()) {
                    return false;
                }
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01a7 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:32:0x0183, B:34:0x01a7, B:40:0x01d2, B:42:0x01d8, B:43:0x01db, B:45:0x01e3, B:46:0x0241, B:49:0x0215), top: B:31:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01d2 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:32:0x0183, B:34:0x01a7, B:40:0x01d2, B:42:0x01d8, B:43:0x01db, B:45:0x01e3, B:46:0x0241, B:49:0x0215), top: B:31:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e3 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:32:0x0183, B:34:0x01a7, B:40:0x01d2, B:42:0x01d8, B:43:0x01db, B:45:0x01e3, B:46:0x0241, B:49:0x0215), top: B:31:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0215 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:32:0x0183, B:34:0x01a7, B:40:0x01d2, B:42:0x01d8, B:43:0x01db, B:45:0x01e3, B:46:0x0241, B:49:0x0215), top: B:31:0x0183 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r23, com.bytedance.pangle.plugin.Plugin r24, java.lang.StringBuilder r25) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.c.a(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    private static void a(Plugin plugin, StringBuilder sb2, PackageInfo packageInfo) {
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
        sb2.append("installProvider cost:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        sb2.append(";");
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb2.append("makeApplication cost:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis2);
        sb2.append(";");
    }

    public PackageInfo a(String str, Plugin plugin, StringBuilder sb2, String str2, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
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
            final /* synthetic */ Plugin f7723a;

            public AnonymousClass3(Plugin plugin2) {
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
        sb2.append("makeResources cost:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        sb2.append(";");
        return packageArchiveInfo;
    }

    public void a(Plugin plugin, String str, File file, File file2, StringBuilder sb2) {
        long currentTimeMillis = System.currentTimeMillis();
        a(plugin, str, file, file2);
        sb2.append("classLoader cost:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        sb2.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.c.4

                /* renamed from: a */
                final /* synthetic */ Plugin f7725a;

                public AnonymousClass4(Plugin plugin2) {
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
        } catch (Throwable th2) {
            sb2.append("actStubV1 cost:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis2);
            sb2.append(";");
            throw th2;
        }
        sb2.append("actStubV1 cost:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis2);
        sb2.append(";");
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
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
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
            StringBuilder sb2 = new StringBuilder();
            sb2.append((str3 == null || !str3.contains(p1.b.f29697h)) ? plugin.mPkgName + p1.b.f29697h : "");
            sb2.append((String) hashMap.get(str2));
            ComponentManager.registerActivity(str4, sb2.toString(), str2);
        }
    }

    private static void a(String str, int i10, @NonNull String str2, int i11, long j10, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i10)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i11)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j10))));
            jSONObject2.putOpt(b7.d.f1362o, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static void a(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th2);
                return;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
    }

    private static void a(Plugin plugin, String str, File file, File file2) {
        if (com.bytedance.pangle.util.i.k()) {
            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            a(pluginClassLoader, str);
            return;
        }
        if (com.bytedance.pangle.util.i.b()) {
            String a10 = g.a(plugin.mPkgName, plugin.getVersion());
            String[] split = a10.split(":");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = !com.bytedance.pangle.e.b.a(file2.getAbsolutePath(), split);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - currentTimeMillis) + " " + z10);
            PluginClassLoader pluginClassLoader2 = new PluginClassLoader(z10 ? "" : a10, file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader2;
            if (z10) {
                com.bytedance.pangle.dex.a.a(pluginClassLoader2, plugin.mPkgName, plugin.getVersion());
                return;
            }
            return;
        }
        plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
    }
}
