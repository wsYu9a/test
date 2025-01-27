package com.bytedance.pangle.f.a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public final class d {
    public static e a(File file) {
        ZipFile zipFile;
        a aVar;
        int b10;
        int i10;
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
                        aVar.f7598b = new b(inputStream);
                    }
                    do {
                        b10 = aVar.b();
                        if (b10 == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (Throwable unused) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (b10 != 2);
                    int length = aVar.f7597a != 2 ? -1 : aVar.f7599c.length / 5;
                    String str = null;
                    String str2 = null;
                    for (int i11 = 0; i11 != length; i11++) {
                        if ("versionCode".equals(aVar.a(i11))) {
                            str = a(aVar, i11);
                        } else if ("package".equals(aVar.a(i11))) {
                            str2 = a(aVar, i11);
                        }
                    }
                    try {
                        i10 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i10 = -1;
                    }
                    if (i10 == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            aVar.a();
                        } catch (Throwable unused3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i10);
                    try {
                        aVar.a();
                    } catch (Throwable unused4) {
                    }
                    g.a(zipFile2);
                    return eVar;
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    zipFile = zipFile2;
                    th = th3;
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
            } catch (Throwable th4) {
                th = th4;
                aVar = null;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
            aVar = null;
        }
    }

    private static String a(int i10) {
        if ((i10 >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String a(a aVar, int i10) {
        int b10 = aVar.b(i10);
        int c10 = aVar.c(i10);
        if (b10 == 3) {
            return aVar.d(i10);
        }
        return b10 == 2 ? String.format("?%s%08X", a(c10), Integer.valueOf(c10)) : (b10 < 16 || b10 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c10), Integer.valueOf(b10)) : String.valueOf(c10);
    }
}
