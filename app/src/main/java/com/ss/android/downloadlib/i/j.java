package com.ss.android.downloadlib.i;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class j implements IDownloadCompleteHandler {

    /* renamed from: com.ss.android.downloadlib.i.j$1 */
    class AnonymousClass1 implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24273j;

        AnonymousClass1(DownloadInfo downloadInfo) {
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

    private boolean j(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String sb2 = sb.toString();
        File file = new File(sb2);
        String j2 = com.ss.android.socialbase.appdownloader.gv.j.q.j(pa.getContext(), com.ss.android.socialbase.appdownloader.i.j(downloadInfo, file), sb2);
        boolean z = false;
        if (!TextUtils.isEmpty(j2)) {
            String str2 = j2 + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (z) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !j(downloadInfo)) {
            return;
        }
        j(pa.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.lg.q.zx(DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }

    private void j(Context context, DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, ContentUris.withAppendedId(MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL), query.getInt(query.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.i.j.1

                /* renamed from: j */
                final /* synthetic */ DownloadInfo f24273j;

                AnonymousClass1(DownloadInfo downloadInfo2) {
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
