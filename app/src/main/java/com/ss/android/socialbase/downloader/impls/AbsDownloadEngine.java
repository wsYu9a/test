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
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;
        final /* synthetic */ SparseArray val$mainThreadListeners;
        final /* synthetic */ SparseArray val$notificationListeners;

        AnonymousClass1(SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
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
                    for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                        IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                        if (iDownloadListener != null) {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    }
                }
            }
            DownloadInfo downloadInfo = downloadInfo;
            if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                return;
            }
            synchronized (sparseArray) {
                for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                    IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                    if (iDownloadListener2 != null) {
                        iDownloadListener2.onCanceled(downloadInfo);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$id;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        AnonymousClass3(int i2, boolean z) {
            i2 = i2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadTask downloadTask;
            if (AbsDownloadEngine.this.doCancel(i2) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i2)) != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                if (downloadListeners != null) {
                    synchronized (downloadListeners) {
                        for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                            IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                            if (iDownloadListener != null) {
                                iDownloadListener.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            }
            AbsDownloadEngine.this.clearDownloadDataInSubThread(i2, z);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int val$id;

        AnonymousClass4(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        AnonymousClass5(int i2, boolean z) {
            i2 = i2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsDownloadEngine.this.doCancel(i2);
            AbsDownloadEngine.this.resetDownloadDataInSubThread(i2, z);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;
        final /* synthetic */ IDownloadListener val$listener;

        AnonymousClass6(IDownloadListener iDownloadListener, DownloadInfo downloadInfo) {
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

    protected AbsDownloadEngine() {
    }

    private void cancelAlarm(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != RetryDelayStatus.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(RetryDelayStatus.DELAY_RETRY_NONE);
                    Logger.d(TAG, "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void clearDownloadDataInSubThread(int i2, boolean z) {
        Logger.d(TAG, "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
            if (downloadInfo != null) {
                if (z) {
                    DownloadUtils.deleteAllDownloadFiles(downloadInfo);
                } else {
                    DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            refreshDownloadTaskMap(i2, 0, -4);
            if (this.failedDownloadTaskMap.get(i2) != null) {
                this.failedDownloadTaskMap.remove(i2);
            }
            if (this.successDownloadTaskMap.get(i2) != null) {
                this.successDownloadTaskMap.remove(i2);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i2));
            DownloadSetting.removeTaskDownloadSetting(i2);
        } catch (Throwable th) {
            th.printStackTrace();
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

    public DownloadTask getDownloadTask(int i2) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.failedDownloadTaskMap.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.successDownloadTaskMap.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i2);
        return downloadTask4 == null ? this.waitingAsyncDownloadTaskMap.get(i2) : downloadTask4;
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    private void notifyDownloadTaskStatus(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            DownloadListenerUtils.notifyListener(i2, downloadListeners, true, downloadInfo, baseException);
            DownloadListenerUtils.notifyListener(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void removeTask(int i2, int i3) {
        Logger.d(TAG, "removeTask id: " + i2 + " listener hasCode: " + i3);
        if (i3 == 0) {
            this.downloadTaskMap.remove(i2);
            this.downloadTaskWithListenerMap.remove(i2);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i2);
        if (sparseArray == null) {
            this.downloadTaskMap.remove(i2);
            return;
        }
        sparseArray.remove(i3);
        Logger.d(TAG, "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
        if (sparseArray.size() == 0) {
            this.downloadTaskMap.remove(i2);
            this.downloadTaskWithListenerMap.remove(i2);
        }
    }

    public void resetDownloadDataInSubThread(int i2, boolean z) {
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeAllDownloadChunk(i2);
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.failedDownloadTaskMap.get(i2) != null) {
                this.failedDownloadTaskMap.remove(i2);
            }
            if (this.successDownloadTaskMap.get(i2) != null) {
                this.successDownloadTaskMap.remove(i2);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i2));
            DownloadSetting.removeTaskDownloadSetting(i2);
        } catch (Throwable th) {
            th.printStackTrace();
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

    private void tryDownload(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i2;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload()) {
            new DownloadStatusHandler(downloadTask, this.mainHandler).onError(new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            cancelAlarm(downloadInfo);
        }
        if (this.failedDownloadTaskMap.get(id) != null) {
            this.failedDownloadTaskMap.remove(id);
        }
        if (this.successDownloadTaskMap.get(id) != null) {
            this.successDownloadTaskMap.remove(id);
        }
        if (this.retryDelayDownloadTaskMap.get(id) != null) {
            this.retryDelayDownloadTaskMap.remove(id);
        }
        if (this.waitingAsyncDownloadTaskMap.get(id) != null) {
            this.waitingAsyncDownloadTaskMap.remove(id);
        }
        if (isDownloading(id) && !downloadInfo.canReStartAsyncTask()) {
            Logger.d(TAG, "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        Logger.d(TAG, "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
        }
        if (DownloadExpSwitchCode.isSwitchEnable(32768) && (remove = this.pengingTaskCache.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.downloadTaskMap.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i2 = 0;
        } else {
            i2 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i2)) {
                z2 = true;
            }
        }
        Logger.d(TAG, "can add listener " + z2 + " , oldTaskStatus is :" + i2);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tryCacheSameTaskWithListenerHashCode(downloadTask);
        this.downloadTaskMap.put(id, downloadTask);
        this.lastTaskTryDownloadTime.put(id, Long.valueOf(uptimeMillis));
        doDownload(id, downloadTask);
    }

    private void tryDownloadNextTaskInQueue(int i2) {
        DownloadTask first;
        if (this.orderedTaskQueue.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.orderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.orderedTaskQueue.poll();
        }
        if (this.orderedTaskQueue.isEmpty() || (first = this.orderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownload(first, true);
    }

    public synchronized void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        addDownloadListener(i2, i3, iDownloadListener, listenerType, z, true);
    }

    public synchronized boolean cancel(int i2, boolean z) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask == null && DownloadExpSwitchCode.isSwitchEnable(65536)) {
            downloadTask = getDownloadTask(i2);
        }
        if (downloadTask != null) {
            if (!DownloadSetting.obtain(i2).optBugFix(DownloadSettingKeys.BugFix.FIX_ON_CANCEL_CALL_TWICE, true)) {
                new DownloadStatusHandler(downloadTask, this.mainHandler).onCancel();
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.1
                final /* synthetic */ DownloadInfo val$downloadInfo;
                final /* synthetic */ SparseArray val$mainThreadListeners;
                final /* synthetic */ SparseArray val$notificationListeners;

                AnonymousClass1(SparseArray sparseArray, DownloadInfo downloadInfo2, SparseArray sparseArray2) {
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
                            for (int i22 = 0; i22 < downloadListeners.size(); i22++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i22));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i2);
        if (DownloadExpSwitchCode.isSwitchEnable(65536)) {
            if (downloadInfo2 != null) {
                downloadInfo2.setStatus(-4);
            }
        } else if (downloadInfo2 != null && DownloadStatus.isDownloading(downloadInfo2.getStatus())) {
            downloadInfo2.setStatus(-4);
        }
        clearDownloadData(i2, z);
        return true;
    }

    public void clearDownloadData(int i2, boolean z) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.2
            final /* synthetic */ int val$id;

            AnonymousClass2(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i2);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.3
            final /* synthetic */ boolean val$deleteFile;
            final /* synthetic */ int val$id;

            AnonymousClass3(int i22, boolean z2) {
                i2 = i22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTask;
                if (AbsDownloadEngine.this.doCancel(i2) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i2)) != null) {
                    DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i22 = 0; i22 < downloadListeners.size(); i22++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i22));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo2);
                                }
                            }
                        }
                    }
                }
                AbsDownloadEngine.this.clearDownloadDataInSubThread(i2, z);
            }
        }, false);
    }

    protected abstract DownloadRunnable doCancel(int i2);

    protected abstract void doDownload(int i2, DownloadTask downloadTask);

    protected abstract void doPause(int i2);

    public abstract void doSetThrottleNetSpeed(int i2, long j2);

    public synchronized void forceDownloadIgnoreRecommendSize(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            tryDownload(downloadTask);
        }
    }

    protected abstract List<Integer> getAllAliveDownloadIds();

    public synchronized IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized DownloadInfo getDownloadInfo(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask;
        downloadInfo = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo == null && (downloadTask = this.downloadTaskMap.get(i2)) != null) {
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
        for (int i2 = 0; i2 < size; i2++) {
            DownloadTask valueAt = this.downloadTaskMap.valueAt(i2);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i2);
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

    public synchronized INotificationClickCallback getNotificationClickCallback(int i2) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        Logger.d(TAG, "handleMsg id: " + i2 + " listener hasCode: " + i3);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i3 == 0) {
                downloadTask = this.downloadTaskMap.get(i2);
            } else {
                SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i2);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i3);
                }
            }
            if (downloadTask == null) {
                return;
            }
            notifyDownloadTaskStatus(message.what, baseException, downloadTask);
            refreshDownloadTaskMap(i2, i3, message.what);
        }
    }

    public abstract boolean isDownloading(int i2);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
    
        if (r1.failedDownloadTaskMap.get(r2) != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isInDownloadTaskPool(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.downloadTaskMap     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.failedDownloadTaskMap     // Catch: java.lang.Throwable -> L15
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L18
        L13:
            r2 = 1
            goto L19
        L15:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L18:
            r2 = 0
        L19:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.isInDownloadTaskPool(int):boolean");
    }

    public synchronized boolean pause(int i2) {
        Logger.d(TAG, "pause id=" + i2);
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo != null && downloadInfo.getStatus() == 11) {
            return false;
        }
        synchronized (this.downloadTaskMap) {
            doPause(i2);
        }
        if (downloadInfo == null) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i2);
            if (downloadTask != null) {
                new DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                return true;
            }
        } else {
            cancelAlarm(downloadInfo);
            if (downloadInfo.getStatus() == 1) {
                DownloadTask downloadTask2 = this.downloadTaskMap.get(i2);
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

    public synchronized void refreshDownloadTaskMap(int i2, int i3, int i4) {
        if (i4 != -7) {
            if (i4 == -6) {
                this.successDownloadTaskMap.put(i2, this.downloadTaskMap.get(i2));
                removeTask(i2, i3);
            } else if (i4 == -4) {
                removeTask(i2, i3);
                tryDownloadNextTaskInQueue(i2);
            } else if (i4 == -3) {
                this.successDownloadTaskMap.put(i2, this.downloadTaskMap.get(i2));
                removeTask(i2, i3);
                tryDownloadNextTaskInQueue(i2);
            } else if (i4 != -1) {
                if (i4 == 7) {
                    DownloadTask downloadTask = this.downloadTaskMap.get(i2);
                    if (downloadTask != null) {
                        if (this.retryDelayDownloadTaskMap.get(i2) == null) {
                            this.retryDelayDownloadTaskMap.put(i2, downloadTask);
                        }
                        removeTask(i2, i3);
                    }
                    tryDownloadNextTaskInQueue(i2);
                } else if (i4 == 8) {
                    DownloadTask downloadTask2 = this.downloadTaskMap.get(i2);
                    if (downloadTask2 != null && this.waitingAsyncDownloadTaskMap.get(i2) == null) {
                        this.waitingAsyncDownloadTaskMap.put(i2, downloadTask2);
                    }
                    tryDownloadNextTaskInQueue(i2);
                }
            }
        }
        DownloadTask downloadTask3 = this.downloadTaskMap.get(i2);
        if (downloadTask3 != null) {
            if (this.failedDownloadTaskMap.get(i2) == null) {
                this.failedDownloadTaskMap.put(i2, downloadTask3);
            }
            removeTask(i2, i3);
        }
        tryDownloadNextTaskInQueue(i2);
    }

    public synchronized void removeDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        DownloadTask downloadTask = getDownloadTask(i2);
        if (downloadTask == null) {
            downloadTask = this.pengingTaskCache.get(Integer.valueOf(i2));
        }
        if (downloadTask != null) {
            downloadTask.removeDownloadListener(i3, iDownloadListener, listenerType, z);
        }
    }

    public abstract void removeDownloadRunnable(DownloadRunnable downloadRunnable);

    public void resetDownloadData(int i2, boolean z) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.4
            final /* synthetic */ int val$id;

            AnonymousClass4(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i2);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.5
            final /* synthetic */ boolean val$deleteFile;
            final /* synthetic */ int val$id;

            AnonymousClass5(int i22, boolean z2) {
                i2 = i22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbsDownloadEngine.this.doCancel(i2);
                AbsDownloadEngine.this.resetDownloadDataInSubThread(i2, z);
            }
        }, false);
    }

    public synchronized boolean restart(int i2) {
        DownloadTask downloadTask = this.failedDownloadTaskMap.get(i2);
        if (downloadTask == null) {
            downloadTask = this.retryDelayDownloadTaskMap.get(i2);
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
    }

    public synchronized void restartAllFailedDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean isWifi = DownloadExpSwitchCode.isSwitchEnable(1048576) ? DownloadUtils.isWifi(DownloadComponentManager.getAppContext()) : true;
            for (int i2 = 0; i2 < this.failedDownloadTaskMap.size(); i2++) {
                DownloadTask downloadTask = this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || isWifi)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    tryDownload(downloadTask);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext())) {
            for (int i2 = 0; i2 < this.downloadTaskMap.size(); i2++) {
                DownloadTask downloadTask = this.downloadTaskMap.get(this.downloadTaskMap.keyAt(i2));
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

    public synchronized boolean restartAsyncWaitingTask(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.waitingAsyncDownloadTaskMap.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            tryDownload(downloadTask);
        }
        return true;
    }

    public synchronized boolean resume(int i2) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            tryDownload(downloadTask);
        } else {
            restart(i2);
        }
        return true;
    }

    public synchronized boolean retryDelayStart(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.retryDelayDownloadTaskMap.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                tryDownload(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo2 != null && downloadInfo2.canStartRetryDelayTask()) {
            tryDownload(new DownloadTask(downloadInfo2), false);
        }
        return false;
    }

    public synchronized void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i2);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
        }
    }

    public void setThrottleNetSpeed(int i2, long j2) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i2);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j2);
        }
        doSetThrottleNetSpeed(i2, j2);
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

    public synchronized void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = getDownloadTask(i2);
        if (downloadTask != null) {
            downloadTask.addDownloadListener(i3, iDownloadListener, listenerType, z);
            DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
            if (z2 && downloadInfo2 != null && !isDownloading(i2) && (listenerType == ListenerType.MAIN || listenerType == ListenerType.NOTIFICATION)) {
                boolean z3 = true;
                if (listenerType == ListenerType.NOTIFICATION && !downloadInfo2.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.6
                        final /* synthetic */ DownloadInfo val$downloadInfo;
                        final /* synthetic */ IDownloadListener val$listener;

                        AnonymousClass6(IDownloadListener iDownloadListener2, DownloadInfo downloadInfo22) {
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
        } else if (DownloadExpSwitchCode.isSwitchEnable(32768) && (downloadInfo = this.downloadCache.getDownloadInfo(i2)) != null && downloadInfo.getStatus() != -3) {
            DownloadTask downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i2));
            if (downloadTask2 == null) {
                downloadTask2 = new DownloadTask(downloadInfo);
                this.pengingTaskCache.put(Integer.valueOf(i2), downloadTask2);
            }
            downloadTask2.addDownloadListener(i3, iDownloadListener2, listenerType, z);
        }
    }

    public synchronized void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
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
    }
}
