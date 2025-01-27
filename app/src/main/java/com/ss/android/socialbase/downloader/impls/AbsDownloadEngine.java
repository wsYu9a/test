package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.constants.RetryDelayStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DownloadRunnable;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes4.dex */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler {
    private static final String TAG = "AbsDownloadEngine";
    private final SparseArray<DownloadTask> downloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> successDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> failedDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> retryDelayDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> waitingAsyncDownloadTaskMap = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> downloadTaskWithListenerMap = new SparseArray<>();
    private final LruCache<Integer, DownloadTask> pengingTaskCache = new LruCache<>();
    private final SparseArray<Long> lastTaskTryDownloadTime = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> orderedTaskQueue = new LinkedBlockingDeque<>();
    protected final WeakDownloadHandler mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;
        final /* synthetic */ SparseArray val$mainThreadListeners;
        final /* synthetic */ SparseArray val$notificationListeners;

        public AnonymousClass1(SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
            downloadListeners = sparseArray;
            downloadInfo = downloadInfo;
            downloadListeners2 = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray sparseArray;
            SparseArray sparseArray2 = downloadListeners;
            if (sparseArray2 != null) {
                synchronized (sparseArray2) {
                    for (int i10 = 0; i10 < downloadListeners.size(); i10++) {
                        try {
                            IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i10));
                            if (iDownloadListener != null) {
                                iDownloadListener.onCanceled(downloadInfo);
                            }
                        } finally {
                        }
                    }
                }
            }
            DownloadInfo downloadInfo = downloadInfo;
            if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                return;
            }
            synchronized (sparseArray) {
                for (int i11 = 0; i11 < downloadListeners2.size(); i11++) {
                    try {
                        IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i11));
                        if (iDownloadListener2 != null) {
                            iDownloadListener2.onCanceled(downloadInfo);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        public AnonymousClass3(int i10, boolean z10) {
            i10 = i10;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadTask downloadTask;
            if (AbsDownloadEngine.this.doCancel(i10) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i10)) != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                if (downloadListeners != null) {
                    synchronized (downloadListeners) {
                        for (int i10 = 0; i10 < downloadListeners.size(); i10++) {
                            try {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i10));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            } finally {
                            }
                        }
                    }
                }
            }
            AbsDownloadEngine.this.clearDownloadDataInSubThread(i10, z10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass4(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        public AnonymousClass5(int i10, boolean z10) {
            i10 = i10;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsDownloadEngine.this.doCancel(i10);
            AbsDownloadEngine.this.resetDownloadDataInSubThread(i10, z10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;
        final /* synthetic */ IDownloadListener val$listener;

        public AnonymousClass6(IDownloadListener iDownloadListener, DownloadInfo downloadInfo) {
            iDownloadListener = iDownloadListener;
            downloadInfo2 = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (iDownloadListener != null) {
                if (downloadInfo2.getStatus() == -3) {
                    iDownloadListener.onSuccessed(downloadInfo2);
                } else if (downloadInfo2.getStatus() == -1) {
                    iDownloadListener.onFailed(downloadInfo2, new BaseException(1000, "try add listener for failed task"));
                }
            }
        }
    }

    private void cancelAlarm(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() != 7 && downloadInfo.getRetryDelayStatus() == RetryDelayStatus.DELAY_RETRY_NONE) {
                    return;
                }
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(RetryDelayStatus.DELAY_RETRY_NONE);
                Logger.d(TAG, "cancelAlarm");
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public synchronized void clearDownloadDataInSubThread(int i10, boolean z10) {
        Logger.d(TAG, "clearDownloadDataInSubThread::id=" + i10 + " deleteTargetFile=" + z10);
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
            if (downloadInfo != null) {
                if (z10) {
                    DownloadUtils.deleteAllDownloadFiles(downloadInfo);
                } else {
                    DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i10);
            } catch (SQLiteException e10) {
                e10.printStackTrace();
            }
            refreshDownloadTaskMap(i10, 0, -4);
            if (this.failedDownloadTaskMap.get(i10) != null) {
                this.failedDownloadTaskMap.remove(i10);
            }
            if (this.successDownloadTaskMap.get(i10) != null) {
                this.successDownloadTaskMap.remove(i10);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i10));
            DownloadSetting.removeTaskDownloadSetting(i10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void enqueue(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.orderedTaskQueue.isEmpty()) {
                tryDownload(downloadTask, true);
                this.orderedTaskQueue.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.orderedTaskQueue.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                    return;
                }
                pause(first.getDownloadId());
                tryDownload(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.orderedTaskQueue.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.orderedTaskQueue.getFirst().getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.orderedTaskQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.orderedTaskQueue.put(downloadTask);
            new DownloadStatusHandler(downloadTask, this.mainHandler).onPrepare();
        } catch (InterruptedException unused) {
        }
    }

    public DownloadTask getDownloadTask(int i10) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.failedDownloadTaskMap.get(i10);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.successDownloadTaskMap.get(i10);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i10);
        return downloadTask4 == null ? this.waitingAsyncDownloadTaskMap.get(i10) : downloadTask4;
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    private void notifyDownloadTaskStatus(int i10, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            boolean z10 = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            DownloadListenerUtils.notifyListener(i10, downloadListeners, true, downloadInfo, baseException);
            DownloadListenerUtils.notifyListener(i10, downloadListeners2, z10, downloadInfo, baseException);
        }
    }

    private void removeTask(int i10, int i11) {
        Logger.d(TAG, "removeTask id: " + i10 + " listener hasCode: " + i11);
        if (i11 == 0) {
            this.downloadTaskMap.remove(i10);
            this.downloadTaskWithListenerMap.remove(i10);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i10);
        if (sparseArray == null) {
            this.downloadTaskMap.remove(i10);
            return;
        }
        sparseArray.remove(i11);
        Logger.d(TAG, "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
        if (sparseArray.size() == 0) {
            this.downloadTaskMap.remove(i10);
            this.downloadTaskWithListenerMap.remove(i10);
        }
    }

    public void resetDownloadDataInSubThread(int i10, boolean z10) {
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z10);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeAllDownloadChunk(i10);
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e10) {
                e10.printStackTrace();
            }
            if (this.failedDownloadTaskMap.get(i10) != null) {
                this.failedDownloadTaskMap.remove(i10);
            }
            if (this.successDownloadTaskMap.get(i10) != null) {
                this.successDownloadTaskMap.remove(i10);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i10));
            DownloadSetting.removeTaskDownloadSetting(i10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.downloadTaskWithListenerMap.put(downloadTask.getDownloadId(), sparseArray);
        }
        Logger.d(TAG, "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void tryDownload(DownloadTask downloadTask, boolean z10) {
        DownloadInfo downloadInfo;
        int i10;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z11 = false;
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload()) {
            new DownloadStatusHandler(downloadTask, this.mainHandler).onError(new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, "network_not_available"));
            return;
        }
        int id2 = downloadInfo.getId();
        if (z10) {
            cancelAlarm(downloadInfo);
        }
        if (this.failedDownloadTaskMap.get(id2) != null) {
            this.failedDownloadTaskMap.remove(id2);
        }
        if (this.successDownloadTaskMap.get(id2) != null) {
            this.successDownloadTaskMap.remove(id2);
        }
        if (this.retryDelayDownloadTaskMap.get(id2) != null) {
            this.retryDelayDownloadTaskMap.remove(id2);
        }
        if (this.waitingAsyncDownloadTaskMap.get(id2) != null) {
            this.waitingAsyncDownloadTaskMap.remove(id2);
        }
        if (isDownloading(id2) && !downloadInfo.canReStartAsyncTask()) {
            Logger.d(TAG, "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        Logger.d(TAG, "no downloading task :" + id2);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
        }
        if (DownloadExpSwitchCode.isSwitchEnable(32768) && (remove = this.pengingTaskCache.remove(Integer.valueOf(id2))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.downloadTaskMap.get(id2);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i10 = 0;
        } else {
            i10 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i10)) {
                z11 = true;
            }
        }
        Logger.d(TAG, "can add listener " + z11 + " , oldTaskStatus is :" + i10);
        if (z11) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tryCacheSameTaskWithListenerHashCode(downloadTask);
        this.downloadTaskMap.put(id2, downloadTask);
        this.lastTaskTryDownloadTime.put(id2, Long.valueOf(uptimeMillis));
        doDownload(id2, downloadTask);
    }

    private void tryDownloadNextTaskInQueue(int i10) {
        DownloadTask first;
        if (this.orderedTaskQueue.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.orderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i10) {
            this.orderedTaskQueue.poll();
        }
        if (this.orderedTaskQueue.isEmpty() || (first = this.orderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownload(first, true);
    }

    public synchronized void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        addDownloadListener(i10, i11, iDownloadListener, listenerType, z10, true);
    }

    public synchronized boolean cancel(int i10, boolean z10) {
        try {
            DownloadTask downloadTask = this.downloadTaskMap.get(i10);
            if (downloadTask == null && DownloadExpSwitchCode.isSwitchEnable(65536)) {
                downloadTask = getDownloadTask(i10);
            }
            if (downloadTask != null) {
                if (!DownloadSetting.obtain(i10).optBugFix(DownloadSettingKeys.BugFix.FIX_ON_CANCEL_CALL_TWICE, true)) {
                    new DownloadStatusHandler(downloadTask, this.mainHandler).onCancel();
                }
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.1
                    final /* synthetic */ DownloadInfo val$downloadInfo;
                    final /* synthetic */ SparseArray val$mainThreadListeners;
                    final /* synthetic */ SparseArray val$notificationListeners;

                    public AnonymousClass1(SparseArray sparseArray, DownloadInfo downloadInfo2, SparseArray sparseArray2) {
                        downloadListeners = sparseArray;
                        downloadInfo = downloadInfo2;
                        downloadListeners2 = sparseArray2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray sparseArray;
                        SparseArray sparseArray2 = downloadListeners;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                for (int i102 = 0; i102 < downloadListeners.size(); i102++) {
                                    try {
                                        IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i102));
                                        if (iDownloadListener != null) {
                                            iDownloadListener.onCanceled(downloadInfo);
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                        DownloadInfo downloadInfo2 = downloadInfo;
                        if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                            return;
                        }
                        synchronized (sparseArray) {
                            for (int i11 = 0; i11 < downloadListeners2.size(); i11++) {
                                try {
                                    IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i11));
                                    if (iDownloadListener2 != null) {
                                        iDownloadListener2.onCanceled(downloadInfo);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                });
            }
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i10);
            if (DownloadExpSwitchCode.isSwitchEnable(65536)) {
                if (downloadInfo2 != null) {
                    downloadInfo2.setStatus(-4);
                }
            } else if (downloadInfo2 != null && DownloadStatus.isDownloading(downloadInfo2.getStatus())) {
                downloadInfo2.setStatus(-4);
            }
            clearDownloadData(i10, z10);
        } catch (Throwable th2) {
            throw th2;
        }
        return true;
    }

    public void clearDownloadData(int i10, boolean z10) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.2
            final /* synthetic */ int val$id;

            public AnonymousClass2(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i10);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.3
            final /* synthetic */ boolean val$deleteFile;
            final /* synthetic */ int val$id;

            public AnonymousClass3(int i102, boolean z102) {
                i10 = i102;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTask;
                if (AbsDownloadEngine.this.doCancel(i10) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i10)) != null) {
                    DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i102 = 0; i102 < downloadListeners.size(); i102++) {
                                try {
                                    IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i102));
                                    if (iDownloadListener != null) {
                                        iDownloadListener.onCanceled(downloadInfo2);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                AbsDownloadEngine.this.clearDownloadDataInSubThread(i10, z10);
            }
        }, false);
    }

    public abstract DownloadRunnable doCancel(int i10);

    public abstract void doDownload(int i10, DownloadTask downloadTask);

    public abstract void doPause(int i10);

    public abstract void doSetThrottleNetSpeed(int i10, long j10);

    public synchronized void forceDownloadIgnoreRecommendSize(int i10) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            tryDownload(downloadTask);
        }
    }

    public abstract List<Integer> getAllAliveDownloadIds();

    public synchronized IDownloadFileUriProvider getDownloadFileUriProvider(int i10) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i10);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i10);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i10);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i10);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized DownloadInfo getDownloadInfo(int i10) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask;
        downloadInfo = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo == null && (downloadTask = this.downloadTaskMap.get(i10)) != null) {
            downloadInfo = downloadTask.getDownloadInfo();
        }
        return downloadInfo;
    }

    public synchronized List<DownloadInfo> getDownloadInfoList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> downloadInfoList = this.downloadCache.getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            return downloadInfoList;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.downloadTaskMap.size();
        for (int i10 = 0; i10 < size; i10++) {
            DownloadTask valueAt = this.downloadTaskMap.valueAt(i10);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized IDownloadNotificationEventListener getDownloadNotificationEventListener(int i10) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i10);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i10);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i10);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i10);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = getAllAliveDownloadIds().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfo = getDownloadInfo(it.next().intValue());
            if (downloadInfo != null && str.equals(downloadInfo.getMimeType())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public synchronized INotificationClickCallback getNotificationClickCallback(int i10) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i10);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i10);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i10);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i10);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message message) {
        int i10 = message.arg1;
        int i11 = message.arg2;
        Logger.d(TAG, "handleMsg id: " + i10 + " listener hasCode: " + i11);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            try {
                if (i11 == 0) {
                    downloadTask = this.downloadTaskMap.get(i10);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i10);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i11);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                notifyDownloadTaskStatus(message.what, baseException, downloadTask);
                refreshDownloadTaskMap(i10, i11, message.what);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract boolean isDownloading(int i10);

    public synchronized boolean isInDownloadTaskPool(int i10) {
        boolean z10;
        if (i10 != 0) {
            try {
                if (this.downloadTaskMap.get(i10) == null) {
                    if (this.failedDownloadTaskMap.get(i10) != null) {
                    }
                }
                z10 = true;
            } finally {
            }
        }
        z10 = false;
        return z10;
    }

    public synchronized boolean pause(int i10) {
        Logger.d(TAG, "pause id=" + i10);
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo != null && downloadInfo.getStatus() == 11) {
            return false;
        }
        synchronized (this.downloadTaskMap) {
            doPause(i10);
        }
        if (downloadInfo == null) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i10);
            if (downloadTask != null) {
                new DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                return true;
            }
        } else {
            cancelAlarm(downloadInfo);
            if (downloadInfo.getStatus() == 1) {
                DownloadTask downloadTask2 = this.downloadTaskMap.get(i10);
                if (downloadTask2 != null) {
                    new DownloadStatusHandler(downloadTask2, this.mainHandler).onPause();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
                downloadInfo.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized void refreshDownloadTaskMap(int i10, int i11, int i12) {
        try {
            if (i12 != -7) {
                if (i12 == -6) {
                    this.successDownloadTaskMap.put(i10, this.downloadTaskMap.get(i10));
                    removeTask(i10, i11);
                } else if (i12 == -4) {
                    removeTask(i10, i11);
                    tryDownloadNextTaskInQueue(i10);
                } else if (i12 == -3) {
                    this.successDownloadTaskMap.put(i10, this.downloadTaskMap.get(i10));
                    removeTask(i10, i11);
                    tryDownloadNextTaskInQueue(i10);
                } else if (i12 != -1) {
                    if (i12 == 7) {
                        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
                        if (downloadTask != null) {
                            if (this.retryDelayDownloadTaskMap.get(i10) == null) {
                                this.retryDelayDownloadTaskMap.put(i10, downloadTask);
                            }
                            removeTask(i10, i11);
                        }
                        tryDownloadNextTaskInQueue(i10);
                    } else if (i12 == 8) {
                        DownloadTask downloadTask2 = this.downloadTaskMap.get(i10);
                        if (downloadTask2 != null && this.waitingAsyncDownloadTaskMap.get(i10) == null) {
                            this.waitingAsyncDownloadTaskMap.put(i10, downloadTask2);
                        }
                        tryDownloadNextTaskInQueue(i10);
                    }
                }
            }
            DownloadTask downloadTask3 = this.downloadTaskMap.get(i10);
            if (downloadTask3 != null) {
                if (this.failedDownloadTaskMap.get(i10) == null) {
                    this.failedDownloadTaskMap.put(i10, downloadTask3);
                }
                removeTask(i10, i11);
            }
            tryDownloadNextTaskInQueue(i10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void removeDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        try {
            DownloadTask downloadTask = getDownloadTask(i10);
            if (downloadTask == null) {
                downloadTask = this.pengingTaskCache.get(Integer.valueOf(i10));
            }
            if (downloadTask != null) {
                downloadTask.removeDownloadListener(i11, iDownloadListener, listenerType, z10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public abstract void removeDownloadRunnable(DownloadRunnable downloadRunnable);

    public void resetDownloadData(int i10, boolean z10) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.4
            final /* synthetic */ int val$id;

            public AnonymousClass4(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i10);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.5
            final /* synthetic */ boolean val$deleteFile;
            final /* synthetic */ int val$id;

            public AnonymousClass5(int i102, boolean z102) {
                i10 = i102;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbsDownloadEngine.this.doCancel(i10);
                AbsDownloadEngine.this.resetDownloadDataInSubThread(i10, z10);
            }
        }, false);
    }

    public synchronized boolean restart(int i10) {
        try {
            DownloadTask downloadTask = this.failedDownloadTaskMap.get(i10);
            if (downloadTask == null) {
                downloadTask = this.retryDelayDownloadTaskMap.get(i10);
            }
            if (downloadTask == null) {
                return false;
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            tryDownload(downloadTask);
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void restartAllFailedDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            try {
                boolean isWifi = DownloadExpSwitchCode.isSwitchEnable(1048576) ? DownloadUtils.isWifi(DownloadComponentManager.getAppContext()) : true;
                for (int i10 = 0; i10 < this.failedDownloadTaskMap.size(); i10++) {
                    DownloadTask downloadTask = this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(i10));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || isWifi)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext())) {
            for (int i10 = 0; i10 < this.downloadTaskMap.size(); i10++) {
                DownloadTask downloadTask = this.downloadTaskMap.get(this.downloadTaskMap.keyAt(i10));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && isPauseReserveOnWifi(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    tryDownload(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    IReserveWifiStatusListener reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.onStatusChanged(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public synchronized boolean restartAsyncWaitingTask(int i10) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.waitingAsyncDownloadTaskMap.get(i10);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            tryDownload(downloadTask);
        }
        return true;
    }

    public synchronized boolean resume(int i10) {
        try {
            DownloadTask downloadTask = this.downloadTaskMap.get(i10);
            if (downloadTask != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (downloadInfo != null) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                }
                tryDownload(downloadTask);
            } else {
                restart(i10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return true;
    }

    public synchronized boolean retryDelayStart(int i10) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.retryDelayDownloadTaskMap.get(i10);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                tryDownload(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo2 != null && downloadInfo2.canStartRetryDelayTask()) {
            tryDownload(new DownloadTask(downloadInfo2), false);
        }
        return false;
    }

    public synchronized void setDownloadNotificationEventListener(int i10, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i10);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
        }
    }

    public void setThrottleNetSpeed(int i10, long j10) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j10);
        }
        doSetThrottleNetSpeed(i10, j10);
    }

    public void shutDown() {
        List<Integer> allAliveDownloadIds = getAllAliveDownloadIds();
        if (allAliveDownloadIds == null) {
            return;
        }
        Iterator<Integer> it = allAliveDownloadIds.iterator();
        while (it.hasNext()) {
            pause(it.next().intValue());
        }
    }

    public synchronized void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10, boolean z11) {
        DownloadInfo downloadInfo;
        try {
            DownloadTask downloadTask = getDownloadTask(i10);
            if (downloadTask != null) {
                downloadTask.addDownloadListener(i11, iDownloadListener, listenerType, z10);
                DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                if (z11) {
                    if (downloadInfo2 != null) {
                        if (!isDownloading(i10)) {
                            if (listenerType != ListenerType.MAIN) {
                                if (listenerType == ListenerType.NOTIFICATION) {
                                }
                            }
                            if (listenerType != ListenerType.NOTIFICATION || downloadInfo2.canShowNotification()) {
                                this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.6
                                    final /* synthetic */ DownloadInfo val$downloadInfo;
                                    final /* synthetic */ IDownloadListener val$listener;

                                    public AnonymousClass6(IDownloadListener iDownloadListener2, DownloadInfo downloadInfo22) {
                                        iDownloadListener = iDownloadListener2;
                                        downloadInfo2 = downloadInfo22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (iDownloadListener != null) {
                                            if (downloadInfo2.getStatus() == -3) {
                                                iDownloadListener.onSuccessed(downloadInfo2);
                                            } else if (downloadInfo2.getStatus() == -1) {
                                                iDownloadListener.onFailed(downloadInfo2, new BaseException(1000, "try add listener for failed task"));
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } else if (DownloadExpSwitchCode.isSwitchEnable(32768) && (downloadInfo = this.downloadCache.getDownloadInfo(i10)) != null && downloadInfo.getStatus() != -3) {
                DownloadTask downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i10));
                if (downloadTask2 == null) {
                    downloadTask2 = new DownloadTask(downloadInfo);
                    this.pengingTaskCache.put(Integer.valueOf(i10), downloadTask2);
                }
                downloadTask2.addDownloadListener(i11, iDownloadListener2, listenerType, z10);
            }
        } finally {
        }
    }

    public synchronized void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            downloadInfo.setDownloadFromReserveWifi(false);
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
                enqueue(downloadTask);
            } else {
                tryDownload(downloadTask, true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
