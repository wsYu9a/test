package com.martian.libxianplay.view;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.martian.libxianplay.util.XianWanSystemUtil;
import java.io.File;

/* loaded from: classes3.dex */
public class DownLoadService extends IntentService {
    private static final String ACTION_FOO = "com.xw.xianwan.action.FOO";
    private static final String EXTRA_PARAM1 = "com.xw.xianwan.extra.PARAM1";
    String apkName;
    DownloadManager downloadManager;
    long mTaskId;

    public DownLoadService() {
        super("DownLoadService");
        this.apkName = "";
    }

    private void downloadAPK(String versionUrl) {
        if (!XianWanSystemUtil.hasSD()) {
            Toast.makeText(getApplicationContext(), "您还没有没有内存卡哦!", 0).show();
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/51xianwan");
        if (!file.exists()) {
            file.mkdir();
        }
        String substring = versionUrl.substring(versionUrl.lastIndexOf("/") + 1);
        this.apkName = substring;
        if (!substring.contains(".apk")) {
            if (this.apkName.length() > 10) {
                String str = this.apkName;
                this.apkName = str.substring(str.length() - 10);
            }
            this.apkName += ".apk";
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(versionUrl));
        request.setAllowedOverRoaming(false);
        request.setAllowedNetworkTypes(3);
        request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(versionUrl)));
        request.setNotificationVisibility(0);
        request.setVisibleInDownloadsUi(true);
        request.setDestinationInExternalPublicDir("/51xianwan/", this.apkName);
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        this.downloadManager = downloadManager;
        this.mTaskId = downloadManager.enqueue(request);
        SharedPreferences sharedPreferences = getSharedPreferences("xw", 0);
        sharedPreferences.edit().putLong("taskid", this.mTaskId).commit();
        sharedPreferences.edit().putString("apkname", this.apkName).commit();
    }

    private void handleActionFoo(String param1) {
        downloadAPK(param1);
    }

    public static void startActionFoo(Context context, String param1) {
        Intent intent = new Intent(context, (Class<?>) DownLoadService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent == null || !ACTION_FOO.equals(intent.getAction())) {
            return;
        }
        handleActionFoo(intent.getStringExtra(EXTRA_PARAM1));
    }
}
