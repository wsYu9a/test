package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.constants.RetryDelayStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class DownloadStatusHandler {
    private static final String TAG = "DownloadStatusHandler";
    private final IDownloadCache downloadCache;
    private IDownloadDepend downloadDepend;
    private DownloadInfo downloadInfo;
    private IDownloadMonitorDepend downloadMonitorDepend;
    private DownloadTask downloadTask;
    private final boolean fixStartWithFileExistUpdateError;
    private final Handler mainThreadHandler;
    private SparseArray<IDownloadListener> mainThreadListeners;
    private long minByteIntervalForSyncProgress;
    private int minTimeIntervalForSyncProgress;
    private SparseArray<IDownloadListener> notificationListeners;
    private SparseArray<IDownloadListener> subThreadListeners;
    private boolean forceRefreshProcess = false;
    private volatile long lastSyncProgressTime = 0;
    private final AtomicLong msgPostDataBuffer = new AtomicLong();
    private boolean hasSyncProgressBefore = false;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadStatusHandler.this.downloadCache.OnDownloadTaskPrepare(DownloadStatusHandler.this.downloadInfo.getId());
            DownloadStatusHandler.this.onStatusChanged(1, null);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler$2 */
    class AnonymousClass2 implements ITempFileSaveCompleteCallback {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public void onFailed(BaseException baseException) {
            String str = DownloadStatusHandler.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            Logger.d(str, sb.toString());
            DownloadStatusHandler.this.onError(baseException);
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public void onSuccess() {
            DownloadStatusHandler.this.onSaveTempFileSuccess();
        }
    }

    public DownloadStatusHandler(DownloadTask downloadTask, Handler handler) {
        this.downloadTask = downloadTask;
        checkInit();
        this.mainThreadHandler = handler;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.fixStartWithFileExistUpdateError = DownloadSetting.obtain(downloadInfo.getId()).optBugFix(DownloadSettingKeys.BugFix.BUGFIX_FIX_START_WITH_FILE_EXIST_UPDATE_ERROR);
        } else {
            this.fixStartWithFileExistUpdateError = false;
        }
    }

    private void checkInit() {
        DownloadTask downloadTask = this.downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
            this.mainThreadListeners = this.downloadTask.getDownloadListeners(ListenerType.MAIN);
            this.notificationListeners = this.downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            this.subThreadListeners = this.downloadTask.getDownloadListeners(ListenerType.SUB);
            this.downloadDepend = this.downloadTask.getDepend();
            this.downloadMonitorDepend = this.downloadTask.getMonitorDepend();
        }
    }

    private void downloadCompleteProcess() throws BaseException {
        List<IDownloadCompleteHandler> downloadCompleteHandlers = this.downloadTask.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.downloadInfo;
        onStatusChanged(11, null);
        this.downloadCache.updateDownloadInfo(downloadInfo);
        for (IDownloadCompleteHandler iDownloadCompleteHandler : downloadCompleteHandlers) {
            try {
                if (iDownloadCompleteHandler.needHandle(downloadInfo)) {
                    iDownloadCompleteHandler.handle(downloadInfo);
                    this.downloadCache.updateDownloadInfo(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_COMPLETE_HANDLER, th);
            }
        }
    }

    private void handleError(BaseException baseException) {
        Log.d(TAG, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException == null || baseException.getCause() == null || !(baseException.getCause() instanceof SQLiteFullException)) {
            try {
                try {
                    this.downloadCache.OnDownloadTaskError(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
            }
        } else {
            try {
                this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException reviseFailedException = reviseFailedException(baseException);
        this.downloadInfo.setFailedException(reviseFailedException);
        onStatusChanged(reviseFailedException instanceof DownloadPauseReserveWifiException ? -2 : -1, reviseFailedException);
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0) > 0) {
            RetryScheduler.getInstance().tryStartScheduleRetry(this.downloadInfo);
        }
    }

    private void handlePrepare() {
        ExecutorService cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    DownloadStatusHandler.this.downloadCache.OnDownloadTaskPrepare(DownloadStatusHandler.this.downloadInfo.getId());
                    DownloadStatusHandler.this.onStatusChanged(1, null);
                }
            });
        }
    }

    private boolean handleProgress(long j2, boolean z) {
        boolean z2 = false;
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
            try {
                this.downloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.forceRefreshProcess) {
            this.forceRefreshProcess = false;
            this.downloadInfo.setStatus(4);
        }
        if (this.downloadInfo.isNeedPostProgress() && z) {
            z2 = true;
        }
        onStatusChanged(4, null, z2);
        return z;
    }

    private void handleRetry(BaseException baseException, boolean z) {
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(z ? 7 : 5, baseException);
    }

    private boolean needSyncProgress(long j2) {
        boolean z = true;
        if (!this.hasSyncProgressBefore) {
            this.hasSyncProgressBefore = true;
            return true;
        }
        long j3 = j2 - this.lastSyncProgressTime;
        if (this.msgPostDataBuffer.get() < this.minByteIntervalForSyncProgress && j3 < this.minTimeIntervalForSyncProgress) {
            z = false;
        }
        if (z) {
            this.lastSyncProgressTime = j2;
            this.msgPostDataBuffer.set(0L);
        }
        return z;
    }

    public void onSaveTempFileSuccess() {
        try {
            Logger.d(TAG, "saveFileAsTargetName onSuccess");
            try {
                downloadCompleteProcess();
                this.downloadInfo.setFirstSuccess(false);
                this.downloadInfo.setSuccessByCache(false);
                onStatusChanged(-3, null);
                this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
                this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
                this.downloadCache.removeSegments(this.downloadInfo.getId());
            } catch (BaseException e2) {
                onError(e2);
            }
        } catch (Throwable th) {
            onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, "onCompleted")));
        }
    }

    public void onStatusChanged(int i2, BaseException baseException) {
        onStatusChanged(i2, baseException, true);
    }

    private BaseException reviseFailedException(BaseException baseException) {
        Context appContext;
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FAILED_CHECK_NET, 1) != 1 || !DownloadUtils.isNetworkError(baseException) || (appContext = DownloadComponentManager.getAppContext()) == null || DownloadUtils.isNetworkConnected(appContext)) {
            return baseException;
        }
        return new BaseException(this.downloadInfo.isOnlyWifi() ? 1013 : DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, baseException.getErrorMessage());
    }

    public long getMinByteIntervalForSyncCache() {
        return this.minByteIntervalForSyncProgress / this.downloadInfo.getChunkCount();
    }

    public int getMinTimeIntervalForSyncCache() {
        return this.minTimeIntervalForSyncProgress / this.downloadInfo.getChunkCount();
    }

    public void handleWaitingAsyncHandler() {
        this.downloadInfo.setStatus(8);
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), 8);
        }
    }

    public void onCancel() {
        onStatusChanged(-4, null);
    }

    public void onCompleteForFileExist() throws BaseException {
        if (!this.fixStartWithFileExistUpdateError) {
            downloadCompleteProcess();
            Logger.d(TAG, "onCompleteForFileExist");
            this.downloadInfo.setSuccessByCache(true);
            onStatusChanged(-3, null);
            this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
            this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
            this.downloadCache.removeSegments(this.downloadInfo.getId());
            return;
        }
        downloadCompleteProcess();
        Logger.d(TAG, "onCompleteForFileExist");
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeSegments(this.downloadInfo.getId());
    }

    public void onCompleted() {
        this.downloadInfo.setFirstDownload(false);
        if (!this.downloadInfo.isIgnoreDataVerify() && this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
            Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new DownloadRetryNeedlessException(DownloadErrorCode.ERROR_CUR_NOT_EQUALS_TOTAL, "current bytes is not equals to total bytes, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        if (this.downloadInfo.getCurBytes() <= 0) {
            Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new DownloadRetryNeedlessException(DownloadErrorCode.ERROR_CUR_BYTES_ZERO, "curBytes is 0, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.downloadInfo.isIgnoreDataVerify() && this.downloadInfo.getTotalBytes() <= 0) {
            Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new DownloadRetryNeedlessException(DownloadErrorCode.ERROR_TOTAL_BYTES_ZERO, "TotalBytes is 0, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        Logger.d(TAG, "" + this.downloadInfo.getName() + " onCompleted start save file as target name");
        IDownloadMonitorDepend iDownloadMonitorDepend = this.downloadMonitorDepend;
        DownloadTask downloadTask = this.downloadTask;
        if (downloadTask != null) {
            iDownloadMonitorDepend = downloadTask.getMonitorDepend();
        }
        DownloadUtils.saveFileAsTargetName(this.downloadInfo, iDownloadMonitorDepend, new ITempFileSaveCompleteCallback() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.2
            AnonymousClass2() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
            public void onFailed(BaseException baseException) {
                String str = DownloadStatusHandler.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                Logger.d(str, sb.toString());
                DownloadStatusHandler.this.onError(baseException);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
            public void onSuccess() {
                DownloadStatusHandler.this.onSaveTempFileSuccess();
            }
        });
    }

    public void onError(BaseException baseException) {
        this.downloadInfo.setFirstDownload(false);
        handleError(baseException);
    }

    public void onFirstConnectionSuccessed(long j2, String str, String str2) {
        this.downloadInfo.setTotalBytes(j2);
        this.downloadInfo.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.downloadInfo.getName())) {
            this.downloadInfo.setName(str2);
        }
        try {
            this.downloadCache.OnDownloadTaskConnected(this.downloadInfo.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        onStatusChanged(3, null);
        this.minByteIntervalForSyncProgress = this.downloadInfo.getMinByteIntervalForPostToMainThread(j2);
        this.minTimeIntervalForSyncProgress = this.downloadInfo.getMinProgressTimeMsInterval();
        this.forceRefreshProcess = true;
        RetryScheduler.getInstance().scheduleRetryWhenHasTaskConnected();
    }

    public void onIntercept() {
        this.downloadInfo.setStatus(-7);
        try {
            this.downloadCache.OnDownloadTaskIntercept(this.downloadInfo.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        onStatusChanged(-7, null);
    }

    public void onPause() {
        this.downloadInfo.setStatus(-2);
        try {
            this.downloadCache.OnDownloadTaskPause(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        onStatusChanged(-2, null);
    }

    public void onPrepare() {
        if (this.downloadInfo.canSkipStatusHandler()) {
            return;
        }
        this.downloadInfo.setStatus(1);
        handlePrepare();
    }

    public boolean onProgress(long j2) {
        this.msgPostDataBuffer.addAndGet(j2);
        this.downloadInfo.increaseCurBytes(j2);
        long uptimeMillis = SystemClock.uptimeMillis();
        return handleProgress(uptimeMillis, needSyncProgress(uptimeMillis));
    }

    public void onRetry(BaseException baseException, boolean z) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0L);
        handleRetry(baseException, z);
    }

    public void onSingleChunkRetry(DownloadChunk downloadChunk, BaseException baseException, boolean z) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0L);
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(z ? 10 : 9, baseException, true);
    }

    public void onStart() {
        if (this.downloadInfo.canSkipStatusHandler()) {
            this.downloadInfo.changeSkipStatus();
            return;
        }
        this.downloadCache.onDownloadTaskStart(this.downloadInfo.getId());
        if (this.downloadInfo.isFirstDownload()) {
            onStatusChanged(6, null);
        }
        onStatusChanged(2, null);
    }

    private void onStatusChanged(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.downloadInfo.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        checkInit();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.downloadInfo.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.downloadInfo.updateDownloadTime();
            }
        }
        if (!this.downloadInfo.isAddListenerToSameTask()) {
            DownloadMonitorHelper.monitorSend(this.downloadTask, baseException, i2);
        }
        if (i2 == 6) {
            this.downloadInfo.setStatus(2);
        } else if (i2 == -6) {
            this.downloadInfo.setStatus(-3);
        } else {
            this.downloadInfo.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.downloadInfo.getRetryDelayStatus() == RetryDelayStatus.DELAY_RETRY_DOWNLOADING) {
                this.downloadInfo.setRetryDelayStatus(RetryDelayStatus.DELAY_RETRY_DOWNLOADED);
            }
            if (this.downloadInfo.getAsyncHandleStatus() == AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) {
                this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.downloadInfo.getByteInvalidRetryStatus() == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        DownloadListenerUtils.notifyListener(i2, this.subThreadListeners, true, this.downloadInfo, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.mainThreadHandler != null && (((sparseArray = this.mainThreadListeners) != null && sparseArray.size() > 0) || ((sparseArray2 = this.notificationListeners) != null && sparseArray2.size() > 0 && (this.downloadInfo.canShowNotification() || this.downloadInfo.isAutoInstallWithoutNotification())))) {
            this.mainThreadHandler.obtainMessage(i2, this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), i2);
        }
    }

    public void onCompleteForFileExist(String str) throws BaseException {
        Logger.d(TAG, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.downloadInfo.getName());
        if (this.fixStartWithFileExistUpdateError) {
            DownloadUtils.copyFileFromExistFileWithSameName(this.downloadInfo, str);
            downloadCompleteProcess();
            this.downloadInfo.setSuccessByCache(true);
            onStatusChanged(-3, null);
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
            return;
        }
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        DownloadUtils.copyFileFromExistFileWithSameName(this.downloadInfo, str);
        this.downloadInfo.setSuccessByCache(true);
        downloadCompleteProcess();
        onStatusChanged(-3, null);
    }
}
