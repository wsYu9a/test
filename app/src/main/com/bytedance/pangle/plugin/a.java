package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class a implements Runnable {

    /* renamed from: a */
    private File f7693a;

    /* renamed from: b */
    private final String f7694b;

    public a(String str, File file) {
        this.f7693a = file;
        this.f7694b = str;
    }

    private static File a(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] listFiles = new File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private void b() {
        int i10 = 3;
        while (i10 > 0) {
            i10--;
            try {
                File file = new File(this.f7693a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                g.b(this.f7693a.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.f7693a;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File a10 = a(file2);
                if (a10 != null && a10.exists() && a10.isFile()) {
                    this.f7693a = a10;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i10));
                    return;
                }
            } catch (Exception e10) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e10);
                e10.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }

    private static void a(String str, int i10, @NonNull String str2, long j10, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i10)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a((Object) 0));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j10))));
            jSONObject2.putOpt(b7.d.f1362o, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public final boolean a() {
        if (g.b(this.f7693a)) {
            ZeusLogger.d("Plugin install : start unZip file ~~~~");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b();
            a(com.bytedance.pangle.c.b.f7489h, b.a.G, this.f7694b, SystemClock.elapsedRealtime() - elapsedRealtime, "");
            ZeusLogger.d("Plugin install : start install from unZip ~~~~");
        } else {
            ZeusLogger.d("Plugin install : start install without unZip ~~~~");
        }
        e a10 = com.bytedance.pangle.f.a.d.a(this.f7693a);
        if (a10 == null) {
            ZeusPluginStateListener.postStateChange(this.f7694b, 7, " read local file package info failed !!! pluginPkg = " + this.f7694b + " mApkFile.exists = " + this.f7693a.exists());
            StringBuilder sb2 = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb2.append(this.f7694b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb2.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a10.f7614a);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.f7694b, 7, " plugin == null !!! pluginPkg = " + this.f7694b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a10.f7614a);
            return false;
        }
        boolean install = plugin.install(this.f7693a, a10);
        if (install) {
            ZeusPluginStateListener.postStateChange(a10.f7614a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(a10.f7614a, 7, "Internal error.");
        }
        return install;
    }
}
