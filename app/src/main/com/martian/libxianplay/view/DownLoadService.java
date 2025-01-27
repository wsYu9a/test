package com.martian.libxianplay.view;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import ba.b;
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

    private void downloadAPK(String str) {
        if (!XianWanSystemUtil.hasSD()) {
            Toast.makeText(getApplicationContext(), "您还没有没有内存卡哦!", 0).show();
            return;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        this.apkName = substring;
        if (!substring.contains(".apk")) {
            if (this.apkName.length() > 10) {
                String str2 = this.apkName;
                this.apkName = str2.substring(str2.length() - 10);
            }
            this.apkName += ".apk";
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setAllowedOverRoaming(false);
        request.setAllowedNetworkTypes(3);
        request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
        request.setNotificationVisibility(0);
        request.setVisibleInDownloadsUi(true);
        if (TextUtils.isEmpty(this.apkName)) {
            return;
        }
        request.setDestinationUri(Uri.fromFile(new File(b.i(), this.apkName)));
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        this.downloadManager = downloadManager;
        this.mTaskId = downloadManager.enqueue(request);
        SharedPreferences sharedPreferences = getSharedPreferences("xw", 0);
        sharedPreferences.edit().putLong("taskid", this.mTaskId).commit();
        sharedPreferences.edit().putString("apkname", this.apkName).commit();
    }

    private void handleActionFoo(String str) {
        downloadAPK(str);
    }

    public static void startActionFoo(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) DownLoadService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, str);
        context.startService(intent);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null || !ACTION_FOO.equals(intent.getAction())) {
            return;
        }
        handleActionFoo(intent.getStringExtra(EXTRA_PARAM1));
    }
}
