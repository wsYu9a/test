package com.bytedance.pangle.plugin;

import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a */
    private final File f6186a;

    /* renamed from: b */
    private final String f6187b;

    a(String str, File file) {
        this.f6186a = file;
        this.f6187b = str;
    }

    final boolean a() {
        e a2 = com.bytedance.pangle.f.a.d.a(this.f6186a);
        if (a2 == null) {
            ZeusPluginStateListener.postStateChange(this.f6187b, 7, " read local file package info failed !!! pluginPkg = " + this.f6187b + " mApkFile.exists = " + this.f6186a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.f6187b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a2.f6112a);
        if (plugin != null) {
            boolean install = plugin.install(this.f6186a, a2);
            if (install) {
                ZeusPluginStateListener.postStateChange(a2.f6112a, 6, new Object[0]);
            } else {
                ZeusPluginStateListener.postStateChange(a2.f6112a, 7, "Internal error.");
            }
            return install;
        }
        ZeusPluginStateListener.postStateChange(this.f6187b, 7, " plugin == null !!! pluginPkg = " + this.f6187b);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a2.f6112a);
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
