package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.download.b;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
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
        i a10 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a10.f7671c) {
                a10.f7671c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(String str) {
        com.bytedance.pangle.download.a a10 = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (!GlobalParam.getInstance().autoFetch()) {
                com.bytedance.pangle.download.b.a();
                return;
            }
            com.bytedance.pangle.download.b a11 = com.bytedance.pangle.download.b.a();
            Runnable runnable = a11.f7546c.get(str);
            if (runnable != null) {
                a11.f7545b.removeCallbacks(runnable);
            }
            b.AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.bytedance.pangle.download.b.1

                /* renamed from: a */
                final /* synthetic */ String f7548a;

                public AnonymousClass1(String str2) {
                    str = str2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
                
                    r0 = r0.get(0).topActivity;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r3 = this;
                        android.app.Application r0 = com.bytedance.pangle.Zeus.getAppApplication()
                        java.lang.String r1 = r0.getPackageName()
                        boolean r2 = android.text.TextUtils.isEmpty(r1)
                        if (r2 != 0) goto L46
                        java.lang.String r2 = "activity"
                        java.lang.Object r0 = r0.getSystemService(r2)
                        android.app.ActivityManager r0 = (android.app.ActivityManager) r0
                        r2 = 1
                        java.util.List r0 = r0.getRunningTasks(r2)
                        if (r0 == 0) goto L46
                        boolean r2 = r0.isEmpty()
                        if (r2 != 0) goto L46
                        r2 = 0
                        java.lang.Object r0 = r0.get(r2)
                        android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0
                        android.content.ComponentName r0 = g4.a.a(r0)
                        if (r0 == 0) goto L46
                        java.lang.String r0 = r0.getPackageName()
                        boolean r0 = r1.equals(r0)
                        if (r0 == 0) goto L46
                        com.bytedance.pangle.download.b r0 = com.bytedance.pangle.download.b.this
                        android.os.Handler r0 = com.bytedance.pangle.download.b.a(r0)
                        r1 = 1800000(0x1b7740, double:8.89318E-318)
                        r0.postDelayed(r3, r1)
                    L46:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.download.b.AnonymousClass1.run():void");
                }
            };
            a11.f7546c.put(str2, anonymousClass1);
            a11.f7545b.postDelayed(anonymousClass1, 1800000L);
            com.bytedance.pangle.download.b.a();
            if (a10.f7541a.contains(str2)) {
                return;
            }
            a10.f7541a.add(str2);
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
        return i.a().f7669a;
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.bytedance.pangle.receiver.b.a(application);
    }

    public static void init(Application application, boolean z10) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start init");
        i.a().a(application, z10);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.a.a b10 = com.bytedance.pangle.service.a.a.b();
        for (Runnable runnable : b10.f7798b) {
            if (runnable != null) {
                b10.f7797a.post(runnable);
            }
        }
        b10.f7798b.clear();
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

    public static void registerPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            c a10 = com.bytedance.pangle.servermanager.b.a();
            if (a10 != null) {
                a10.a(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.f.b(zeusPluginInstallListener));
            }
        } catch (RemoteException e10) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e10);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        i.a().f7670b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        i a10 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a10.f7671c) {
                a10.f7671c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i10, boolean z10) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i10, z10);
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
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start");
        c a10 = com.bytedance.pangle.servermanager.b.a();
        if (a10 == null) {
            return false;
        }
        try {
            return a10.a(str, str2);
        } catch (RemoteException e10) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e10);
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
        List<ZeusPluginStateListener> list = i.a().f7670b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i10) {
        if (i.a().f7669a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            try {
                if (!i.a().f7669a) {
                    try {
                        if (i10 == -1) {
                            obj.wait();
                        } else {
                            obj.wait(i10);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i.a().f7669a;
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            c a10 = com.bytedance.pangle.servermanager.b.a();
            if (a10 != null) {
                a10.a(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e10) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e10);
        }
    }

    public static Plugin getPlugin(String str, boolean z10) {
        return PluginManager.getInstance().getPlugin(str, z10);
    }
}
