package com.vivo.mobilead.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bj;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.DownloadManager;
import com.vivo.mobilead.manager.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d {
    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = context.getCacheDir() + "/adDownload/" + c(str);
        if (Build.VERSION.SDK_INT >= 24) {
            return str2;
        }
        try {
            return Environment.getExternalStorageDirectory().getPath() + "/VivoAd/adDownload/" + c(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static void b() {
        try {
            List<DownloadInfo> queryDownloads = DownloadManager.getInstance().queryDownloads(null, null, null);
            if (queryDownloads != null) {
                while (queryDownloads.size() > 4) {
                    DownloadInfo remove = queryDownloads.remove(0);
                    DownloadManager.getInstance().cancel(remove.getId());
                    b(remove.getFileName());
                    b(remove.getFileName() + ".temp");
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String c(String str) {
        try {
            String str2 = new String(Base64.encode(str.getBytes(), 2), "UTF-8");
            try {
                return str2 + ".apk";
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return "vivoad.apk";
        }
    }

    public static boolean a(Context context, String str, long j2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(a(context, str));
            long length = file.length() / 1024;
            if (file.exists() && length > j2 - 10 && length < j2 + 10) {
                return true;
            }
        }
        return false;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new File(str).delete();
        } catch (Exception unused) {
        }
    }

    public static void a() {
        try {
            ArrayList arrayList = new ArrayList();
            List<DownloadInfo> queryDownloads = DownloadManager.getInstance().queryDownloads(null, null, null);
            if (queryDownloads != null && queryDownloads.size() > 0) {
                for (DownloadInfo downloadInfo : queryDownloads) {
                    if (System.currentTimeMillis() - downloadInfo.getLastMod() > bj.f5600e) {
                        DownloadManager.getInstance().cancel(downloadInfo.getId());
                        b(downloadInfo.getFileName());
                        b(downloadInfo.getFileName() + ".temp");
                    } else {
                        arrayList.add(downloadInfo.getFileName());
                    }
                }
                while (queryDownloads.size() > 4) {
                    DownloadInfo remove = queryDownloads.remove(0);
                    DownloadManager.getInstance().cancel(remove.getId());
                    b(remove.getFileName());
                    b(remove.getFileName() + ".temp");
                    arrayList.remove(remove.getFileName());
                }
            }
            Context c2 = f.j().c();
            if (c2 != null) {
                File file = new File(c2.getCacheDir() + "/adDownload/");
                if (Build.VERSION.SDK_INT < 24) {
                    try {
                        file = new File(Environment.getExternalStorageDirectory().getPath() + "/VivoAd/adDownload/");
                    } catch (Exception unused) {
                    }
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    if (!arrayList.contains(file2.getPath().replace(".temp", ""))) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static long a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            List<DownloadInfo> queryDownloads = DownloadManager.getInstance().queryDownloads(null, new String[]{str}, null);
            if (queryDownloads != null && queryDownloads.size() > 0) {
                for (DownloadInfo downloadInfo : queryDownloads) {
                    if (!c(str2).equals(downloadInfo.getHint())) {
                        if ((c(str2) + ".temp").equals(downloadInfo.getHint())) {
                        }
                    }
                    return downloadInfo.getId();
                }
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new File(a(f.j().c(), str)).delete();
        } catch (Exception unused) {
        }
    }
}
