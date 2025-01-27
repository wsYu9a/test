package com.bytedance.pangle.f.a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class d {
    public static e a(File file) {
        ZipFile zipFile;
        a aVar;
        int b2;
        int i2;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                g.a((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    g.a(zipFile2);
                    return null;
                }
                aVar = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.a();
                    if (inputStream != null) {
                        aVar.f6096b = new b(inputStream);
                    }
                    do {
                        b2 = aVar.b();
                        if (b2 == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (Throwable unused) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (b2 != 2);
                    int length = aVar.f6095a != 2 ? -1 : aVar.f6097c.length / 5;
                    String str = null;
                    String str2 = null;
                    for (int i3 = 0; i3 != length; i3++) {
                        if ("versionCode".equals(aVar.a(i3))) {
                            str = a(aVar, i3);
                        } else if ("package".equals(aVar.a(i3))) {
                            str2 = a(aVar, i3);
                        }
                    }
                    try {
                        i2 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i2 = -1;
                    }
                    if (i2 == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            aVar.a();
                        } catch (Throwable unused3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i2);
                    try {
                        aVar.a();
                    } catch (Throwable unused4) {
                    }
                    g.a(zipFile2);
                    return eVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused5) {
                            }
                        }
                        g.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused6) {
                            }
                        }
                        g.a(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            aVar = null;
        }
    }

    private static String a(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    private static String a(a aVar, int i2) {
        int b2 = aVar.b(i2);
        int c2 = aVar.c(i2);
        if (b2 == 3) {
            return aVar.d(i2);
        }
        return b2 == 2 ? String.format("?%s%08X", a(c2), Integer.valueOf(c2)) : (b2 < 16 || b2 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c2), Integer.valueOf(b2)) : String.valueOf(c2);
    }
}
