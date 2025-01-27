package com.ss.android.socialbase.appdownloader.q;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.AbsNotificationListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* loaded from: classes4.dex */
public class zx extends AbsNotificationListener {

    /* renamed from: g */
    private String f24491g;
    private String gv;

    /* renamed from: i */
    private String f24492i;

    /* renamed from: j */
    private Context f24493j;
    private AbsNotificationItem lg;
    private String q;
    private int zx;

    public zx(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f24493j = context.getApplicationContext();
        } else {
            this.f24493j = DownloadComponentManager.getAppContext();
        }
        this.zx = i2;
        this.f24492i = str;
        this.f24491g = str2;
        this.q = str3;
        this.gv = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener
    public AbsNotificationItem createNotificationItem() {
        Context context;
        AbsNotificationItem absNotificationItem = this.lg;
        return (absNotificationItem != null || (context = this.f24493j) == null) ? absNotificationItem : new j(context, this.zx, this.f24492i, this.f24491g, this.q, this.gv);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f24493j == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f24493j == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.gv.zx.j(downloadInfo);
        }
    }

    public zx(AbsNotificationItem absNotificationItem) {
        this.f24493j = DownloadComponentManager.getAppContext();
        this.lg = absNotificationItem;
    }
}
