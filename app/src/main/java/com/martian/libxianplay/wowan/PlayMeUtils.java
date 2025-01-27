package com.martian.libxianplay.wowan;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import ba.g;
import ba.m;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class PlayMeUtils {
    public static String encrypt(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i10 = 0;
            for (byte b10 : digest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 += 2;
                cArr2[i11] = cArr[b10 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int[] getBytesAndStatus(long j10, DownloadManager downloadManager) {
        int[] iArr = {-1, -1, 0};
        if (downloadManager == null) {
            return iArr;
        }
        Cursor query = downloadManager.query(new DownloadManager.Query().setFilterById(j10));
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    iArr[0] = query.getInt(query.getColumnIndexOrThrow("bytes_so_far"));
                    iArr[1] = query.getInt(query.getColumnIndexOrThrow("total_size"));
                    iArr[2] = query.getInt(Math.max(0, query.getColumnIndex("status")));
                }
            } catch (Throwable th2) {
                try {
                    query.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (query != null) {
            query.close();
        }
        return iArr;
    }

    public static void installThroughUri(Activity activity, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z10 = g.z(activity, file);
        if (z10 == null) {
            return;
        }
        intent.setFlags(268435456);
        int i10 = activity.getApplicationInfo().targetSdkVersion;
        if (m.o() && i10 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z10, "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }

    public static void openAdDetail(Activity activity, String str) {
        if (TextUtils.isEmpty(str) || activity == null) {
            return;
        }
        WowanDetailActivity.startWebViewActivity(activity, str);
    }
}
