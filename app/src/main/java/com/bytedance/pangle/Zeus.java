package com.bytedance.pangle;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h a2 = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.f6164c) {
                a2.f6164c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.a a2 = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (!GlobalParam.getInstance().autoFetch()) {
                com.bytedance.pangle.download.b.a();
                return;
            }
            final com.bytedance.pangle.download.b a3 = com.bytedance.pangle.download.b.a();
            Runnable runnable = a3.f6051c.get(str);
            if (runnable != null) {
                a3.f6050b.removeCallbacks(runnable);
            }
            Runnable anonymousClass1 = new Runnable() { // from class: com.bytedance.pangle.download.b.1

                /* renamed from: a */
                final /* synthetic */ String f6053a;

                public AnonymousClass1(final String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List<ActivityManager.RunningTaskInfo> runningTasks;
                    ComponentName componentName;
                    Application appApplication = Zeus.getAppApplication();
                    String packageName = appApplication.getPackageName();
                    if ((TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) appApplication.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true) {
                        b.this.f6050b.postDelayed(this, 1800000L);
                    }
                }
            };
            a3.f6051c.put(str2, anonymousClass1);
            a3.f6050b.postDelayed(anonymousClass1, 1800000L);
            com.bytedance.pangle.download.b.a();
            if (a2.f6046a.contains(str2)) {
                return;
            }
            a2.f6046a.add(str2);
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        String did = GlobalParam.getInstance().getDid();
        return !TextUtils.isEmpty(did) ? did : ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return h.a().f6162a;
    }

    public static void init(Application application, boolean z) {
        h.a().a(application, z);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        synchronized (Zeus.class) {
            if (onPrivacyAgreed) {
                return;
            }
            ApmUtils.getApmInstance().init();
            onPrivacyAgreed = true;
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        h.a().f6163b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h a2 = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.f6164c) {
                a2.f6164c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i2, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i2, z);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        c a2 = com.bytedance.pangle.servermanager.b.a();
        if (a2 == null) {
            return false;
        }
        try {
            return a2.a(str, str2);
        } catch (RemoteException e2) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e2);
            return false;
        }
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = h.a().f6163b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i2) {
        if (h.a().f6162a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!h.a().f6162a) {
                try {
                    if (i2 == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i2);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return h.a().f6162a;
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }
}
