package cn.vlion.ad.inland.base;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;

/* loaded from: classes.dex */
public final class s extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        DownloadApkData downloadApkData;
        try {
            String action = intent.getAction();
            LogVlion.e("DownLoadManagerReceiver action=" + action);
            if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(action)) {
                LogVlion.e("DownLoadManagerReceiver 用户点击了通知");
                return;
            }
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                LogVlion.e("DownLoadManagerReceiver 下载完成");
                try {
                    DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                    if (downloadManager == null) {
                        LogVlion.e("DownLoadManagerReceiver null == manager");
                        return;
                    }
                    DownloadManager.Query query = new DownloadManager.Query();
                    long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, 0L);
                    LogVlion.e("DownLoadManagerReceiver 下载完成 downloadId=" + longExtra);
                    try {
                        downloadApkData = s0.f3359a.get(Long.valueOf(longExtra));
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                        downloadApkData = null;
                    }
                    if (downloadApkData == null) {
                        LogVlion.e("DownLoadManagerReceiver null==downloadApkData");
                        return;
                    }
                    query.setFilterByStatus(8);
                    query.setFilterById(longExtra);
                    Cursor query2 = downloadManager.query(query);
                    if (!query2.moveToFirst()) {
                        LogVlion.e("DownLoadManagerReceiver !cursor.moveToFirst()");
                        return;
                    }
                    int columnIndex = query2.getColumnIndex(Build.VERSION.SDK_INT >= 24 ? "local_uri" : "local_filename");
                    LogVlion.e("DownLoadManagerReceiver path=" + columnIndex);
                    if (columnIndex < 0) {
                        return;
                    }
                    String string = query2.getString(columnIndex);
                    LogVlion.e("DownLoadManagerReceiver filename=" + string);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    downloadApkData.submitInstallStart(string, true);
                    LogVlion.e("DownLoadManagerReceiver installApp");
                    i5.a(context, string);
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }
}
