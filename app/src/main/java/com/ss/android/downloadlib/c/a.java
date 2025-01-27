package com.ss.android.downloadlib.c;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class a implements IDownloadCompleteHandler {

    /* renamed from: com.ss.android.downloadlib.c.a$1 */
    public class AnonymousClass1 implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21564a;

        public AnonymousClass1(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            if (uri != null) {
                downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, uri.toString());
                DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
            }
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append(downloadInfo.getName());
        String sb3 = sb2.toString();
        File file = new File(sb3);
        String a10 = com.ss.android.socialbase.appdownloader.f.a.e.a(k.a(), com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file), sb3);
        boolean z10 = false;
        if (!TextUtils.isEmpty(a10)) {
            String str2 = a10 + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z10 = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (z10) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return z10;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !a(downloadInfo)) {
            return;
        }
        a(k.a(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.g.e.b(DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }

    private void a(Context context, DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.c.a.1

                /* renamed from: a */
                final /* synthetic */ DownloadInfo f21564a;

                public AnonymousClass1(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, uri.toString());
                        DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
                    }
                }
            });
        }
        DownloadUtils.safeClose(query);
    }
}
