package com.martian.libxianplay.view;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import ba.b;
import ba.m;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
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
            int i10 = query2.getInt(Math.max(0, query2.getColumnIndex("status")));
            this.apkName = query2.getString(Math.max(0, query2.getColumnIndex("title")));
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 4) {
                        if (i10 != 8) {
                            if (i10 != 16) {
                                return;
                            }
                            Log.i("DownLoadService", ">>>下载失败");
                            return;
                        } else {
                            Log.i("DownLoadService", ">>>下载完成");
                            File i11 = b.i();
                            if (i11 == null || TextUtils.isEmpty(this.apkName)) {
                                return;
                            }
                            installAPK(context, new File(i11, this.apkName));
                            return;
                        }
                    }
                    Log.i("DownLoadService", ">>>下载暂停");
                }
                Log.i("DownLoadService", ">>>正在下载");
            }
            Log.i("DownLoadService", ">>>下载延迟");
            Log.i("DownLoadService", ">>>正在下载");
        }
    }

    public void installAPK(Context context, File file) {
        Uri parse;
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            int i10 = context.getApplicationInfo().targetSdkVersion;
            if (!m.o() || i10 < 24) {
                parse = Uri.parse("file://" + file);
                intent.setFlags(268435456);
            } else {
                parse = FileProvider.getUriForFile(context, this.mContext.getApplicationContext().getPackageName() + ".fileProvider", file);
                intent.addFlags(268435457);
            }
            intent.setDataAndType(parse, "application/vnd.android.package-archive");
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
