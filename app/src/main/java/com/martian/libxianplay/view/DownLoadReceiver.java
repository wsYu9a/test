package com.martian.libxianplay.view;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* loaded from: classes3.dex */
public class DownLoadReceiver extends BroadcastReceiver {
    String apkName = "";
    DownloadManager downloadManager;
    private Context mContext;
    long mTaskId;

    private void checkDownloadStatus(Context context) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(this.mTaskId);
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        this.downloadManager = downloadManager;
        Cursor query2 = downloadManager.query(query);
        if (query2.moveToFirst()) {
            int i2 = query2.getInt(query2.getColumnIndex("status"));
            this.apkName = query2.getString(query2.getColumnIndex("title"));
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 8) {
                            if (i2 != 16) {
                                return;
                            }
                            Log.i("DownLoadService", ">>>下载失败");
                            return;
                        }
                        Log.i("DownLoadService", ">>>下载完成");
                        StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                        String str = File.separator;
                        sb.append(str);
                        sb.append("51xianwan");
                        sb.append(str);
                        sb.append(this.apkName);
                        installAPK(context, new File(sb.toString()));
                        return;
                    }
                    Log.i("DownLoadService", ">>>下载暂停");
                }
                Log.i("DownLoadService", ">>>正在下载");
            }
            Log.i("DownLoadService", ">>>下载延迟");
            Log.i("DownLoadService", ">>>正在下载");
        }
    }

    protected void installAPK(Context context, File file) {
        Uri parse;
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            int i2 = context.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT < 24 || i2 < 24) {
                parse = Uri.parse("file://" + file.toString());
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            } else {
                parse = FileProvider.getUriForFile(context, this.mContext.getApplicationContext().getPackageName() + ".fileProvider", file);
                intent.addFlags(268435457);
            }
            intent.setDataAndType(parse, AdBaseConstants.MIME_APK);
            context.startActivity(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
        SharedPreferences sharedPreferences = context.getSharedPreferences("xw", 0);
        this.mTaskId = sharedPreferences.getLong("taskid", 0L);
        this.apkName = sharedPreferences.getString("apkname", "");
        if (longExtra != -1) {
            this.mTaskId = longExtra;
        }
        if (this.mTaskId == longExtra) {
            checkDownloadStatus(context);
        }
    }
}
