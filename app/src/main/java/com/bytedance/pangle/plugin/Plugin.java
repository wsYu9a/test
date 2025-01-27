package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.martian.mibook.application.MiConfigSingleton;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    /* renamed from: com.bytedance.pangle.plugin.Plugin$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".apk");
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                if (file.exists()) {
                    PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                    return;
                }
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
            }
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$2 */
    final class AnonymousClass2 implements FileFilter {
        AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file != null && file.getName().matches("^version-(\\d+)$");
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$3 */
    final class AnonymousClass3 implements FileFilter {
        AnonymousClass3() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file.getName().matches("^version-(\\d+)$")) {
                l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.Plugin$4 */
    final class AnonymousClass4 implements FileFilter {

        /* renamed from: a */
        final /* synthetic */ String f6184a;

        AnonymousClass4(String str) {
            concat = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file != null && !concat.equals(file.getName()) && !MiConfigSingleton.t0.equals(file.getName())) {
                g.a(file.getAbsolutePath());
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
            }
            return false;
        }
    }

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString(DBDefinition.PACKAGE_NAME);
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString(com.heytap.mcssdk.n.b.Q, "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i2));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i2) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i2 < this.mMinVersionCode || i2 > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i2), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i2 < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i2), Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i2 == this.mVersionCode && l.a().f6339a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i2 + " true");
        return true;
    }

    private boolean checkVersionValid(int i2, int i3, boolean z) {
        int a2 = l.a().a(this.mPkgName);
        boolean z2 = false;
        if (a2 > i3) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a2), Integer.valueOf(i3)))));
            return false;
        }
        boolean z3 = i2 >= 0 && i2 >= this.mMinVersionCode && i2 <= this.mMaxVersionCode;
        if (z3 && i3 != -1) {
            l a3 = l.a();
            String str = this.mPkgName;
            int i4 = a3.f6339a.getInt("API_MIN_" + str + "_" + i2, 0);
            l a4 = l.a();
            String str2 = this.mPkgName;
            int i5 = a4.f6339a.getInt("API_MAX_" + str2 + "_" + i2, Integer.MAX_VALUE);
            int i6 = i5 != 0 ? i5 : Integer.MAX_VALUE;
            if (i3 < i4 || i3 > i6) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6)))));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.d.b.b(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i2)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i2)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f6339a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a2 = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a2.f6339a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            AnonymousClass3() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i2) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4

                /* renamed from: a */
                final /* synthetic */ String f6184a;

                AnonymousClass4(String str) {
                    concat = str;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !MiConfigSingleton.t0.equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        File file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".apk");
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i2) {
        String a2 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(a2) && TextUtils.equals(l.a().b(this.mPkgName), a2)) {
            return i2;
        }
        if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i2);
            return 0;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i2);
        int a3 = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i2)), true, new StringBuilder());
        if (a3 == 100 || a3 == 200) {
            return i2;
        }
        return 0;
    }

    private void setupInternalPlugin() {
        int a2;
        if (l.a().f6339a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(com.bytedance.pangle.g.f6121d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a2 = k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = com.bytedance.pangle.g.f6121d + "/" + str;
                        this.mInternalVersionCode = a2;
                        return;
                    }
                }
            } catch (IOException e2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e2);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a2;
        try {
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a2 = com.bytedance.pangle.servermanager.b.a()) == null || !a2.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a2.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i2) {
        this.mVersionCode = i2;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            AnonymousClass2() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i2 = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i2 && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                    i2 = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
        return i2;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i2 = this.mVersionCode;
        return i2 > 0 ? com.bytedance.pangle.d.c.d(this.mPkgName, i2) : com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                int i2 = 0;
                if (!TextUtils.isEmpty(l.a().f6339a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l a2 = l.a();
                    String str = this.mPkgName;
                    z = !TextUtils.equals(a2.f6339a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a2.f6339a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    i2 = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i2);
                }
                deleteOtherExpiredVer(i2);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a3 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a3.f6339a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a4 = l.a();
                String str3 = this.mPkgName;
                String string = a4.f6339a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a4.f6339a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a5 = l.a();
                String str4 = this.mPkgName;
                String a6 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
                String b2 = a5.b(str4);
                if (!TextUtils.equals(b2, a6)) {
                    SharedPreferences.Editor edit3 = a5.f6339a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), a6);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b2 + " --> " + a6);
                l a7 = l.a();
                String str5 = this.mPkgName;
                int i3 = this.mApiVersionCode;
                int a8 = a7.a(str5);
                if (a8 != i3) {
                    SharedPreferences.Editor edit4 = a7.f6339a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i3);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a8 + " --> " + i3);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = eVar.f6112a;
            int i2 = eVar.f6113b;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean checkValid = checkValid(file, str, i2);
                if (checkValid) {
                    String str2 = com.bytedance.pangle.util.c.a(file)[0];
                    z = b.a(file, str, i2);
                    if (z) {
                        l a2 = l.a();
                        String str3 = this.mPkgName;
                        SharedPreferences.Editor edit = a2.f6339a.edit();
                        edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                        edit.apply();
                        l.a().a(this.mPkgName, i2, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i2 + " identity=" + str2);
                        g.a(file);
                    }
                }
                synchronized (this) {
                    if (!checkValid) {
                        g.a(file);
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i2);
                    } else if (this.mLifeCycle == 3) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i2);
                    } else if (z) {
                        updateToInstalled(i2);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i2);
                    } else {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i2);
                        g.a(file);
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i2);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
        }
        return z;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i2) {
        return l.a().a(this.mPkgName, i2);
    }

    public void setApiCompatVersion(int i2, int i3, int i4) {
        l a2 = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a2.f6339a.edit();
        edit.putInt("API_MIN_" + str + "_" + i2, i3);
        edit.putInt("API_MAX_" + str + "_" + i2, i4);
        edit.apply();
    }

    public void setLifeCycle(int i2) {
        this.mLifeCycle = i2;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
