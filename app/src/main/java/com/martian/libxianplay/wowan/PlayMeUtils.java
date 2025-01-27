package com.martian.libxianplay.wowan;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class PlayMeUtils {
    public static String encrypt(String plaintext) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = plaintext.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b2 : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int[] getBytesAndStatus(long downloadId, DownloadManager downloadManager) {
        int[] iArr = {-1, -1, 0};
        if (downloadManager == null) {
            return iArr;
        }
        Cursor query = downloadManager.query(new DownloadManager.Query().setFilterById(downloadId));
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    iArr[0] = query.getInt(query.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = query.getInt(query.getColumnIndexOrThrow("total_size"));
                    iArr[2] = query.getInt(query.getColumnIndex("status"));
                }
            } finally {
            }
        }
        if (query != null) {
        }
        return iArr;
    }

    public static void installThroughUri(Activity activity, File apkFile) {
        if (apkFile == null || !apkFile.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z = com.martian.libsupport.e.z(activity, apkFile);
        if (z == null) {
            return;
        }
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        int i2 = activity.getApplicationInfo().targetSdkVersion;
        if (com.martian.libsupport.l.u() && i2 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z, AdBaseConstants.MIME_APK);
        activity.startActivity(intent);
    }

    public static void openAdDetail(Activity activity, String url) {
        if (TextUtils.isEmpty(url) || activity == null) {
            return;
        }
        WowanDetailActivity.startWebViewActivity(activity, url);
    }
}
