package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, String.format("onFailed on %s because of : %s", downloadInfo.getName(), baseException != null ? baseException.getErrorMessage() : "unkown"));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onFirstSuccess -- " + downloadInfo.getName());
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onIntercept -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        Logger.d(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, String.format("onRetry on %s because of : %s", downloadInfo.getName(), baseException != null ? baseException.getErrorMessage() : "unkown"));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, String.format("onRetryDelay on %s because of : %s", downloadInfo.getName(), baseException != null ? baseException.getErrorMessage() : "unkown"));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }
}
