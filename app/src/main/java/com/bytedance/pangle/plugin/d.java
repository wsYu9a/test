package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes2.dex */
final class d implements Runnable {

    /* renamed from: com.bytedance.pangle.plugin.d$1 */
    public class AnonymousClass1 implements FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file == null) {
                return false;
            }
            if (file.getName().endsWith(".apk") || g.b(file) || file.getName().endsWith(".7z.zip") || file.getName().endsWith(".jar")) {
                PluginManager.getInstance().asyncInstall(null, file);
                return true;
            }
            if ((file.getAbsolutePath().endsWith(".temp") || file.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file.lastModified() < 259200000) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file)));
            } else {
                g.a(file);
                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file)));
            }
            return false;
        }
    }

    private void a(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.d.1
            public AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (file2.getName().endsWith(".apk") || g.b(file2) || file2.getName().endsWith(".7z.zip") || file2.getName().endsWith(".jar")) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                }
                if ((file2.getAbsolutePath().endsWith(".temp") || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                } else {
                    g.a(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                }
                return false;
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        a(new File(com.bytedance.pangle.d.c.a()));
        String c10 = com.bytedance.pangle.d.c.c();
        if (TextUtils.isEmpty(c10)) {
            return;
        }
        a(new File(c10));
    }
}
