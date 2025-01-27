package com.martian.apptask.e;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.martian.apptask.g.g;
import com.martian.libsupport.k;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;

/* loaded from: classes2.dex */
public class a extends BroadcastReceiver {
    protected void a(Context context, String filepath) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getPackage() == null || !intent.getPackage().equals(context.getPackageName())) {
            return;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(extras.getLong(DownloadConstants.EXTRA_DOWNLOAD_ID));
            Cursor query2 = downloadManager.query(query);
            if (query2.moveToFirst() && query2.getInt(query2.getColumnIndex("status")) == 8) {
                String string = query2.getString(query2.getColumnIndex("local_uri"));
                if (!k.p(string)) {
                    File file = new File(Uri.parse(string).getPath());
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        absolutePath.substring(absolutePath.lastIndexOf("/") + 1);
                        a(context, absolutePath);
                        if (absolutePath.endsWith(".apk")) {
                            g.e(context, file);
                        }
                    }
                }
            }
            query2.close();
        } catch (Exception unused) {
        }
    }
}
