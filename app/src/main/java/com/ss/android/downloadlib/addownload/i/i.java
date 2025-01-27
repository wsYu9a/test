package com.ss.android.downloadlib.addownload.i;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class i {
    public static void j() {
        List<DownloadInfo> j2 = com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext());
        if (j2 == null || j2.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < j2.size(); i2++) {
            DownloadInfo downloadInfo = j2.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long optInt = DownloadSetting.obtain(downloadInfo.getId()).optInt("download_file_expire_hours", 0) * 3600000;
            if (optInt <= 0) {
                optInt = bj.f5599d;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= optInt) {
                j(file);
                Downloader.getInstance(pa.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void zx() {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(pa.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < successedDownloadInfosWithMimeType.size(); i2++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i2);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long optInt = DownloadSetting.obtain(downloadInfo.getId()).optInt("download_complete_file_expire_hours", 0) * 3600000;
                    if (optInt <= 0) {
                        optInt = bj.f5599d;
                    }
                    boolean z = true;
                    if (currentTimeMillis < optInt && !nt.q(pa.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        j(file);
                    }
                }
            }
        }
    }

    public static void j(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            j(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            goto L28
        L13:
            r0 = move-exception
            goto L1b
        L15:
            r3 = move-exception
            goto L2e
        L17:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r3.delete()
            return
        L2c:
            r3 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.i.i.j(java.io.File):void");
    }

    private static void j(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    File file2 = new File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        j(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
