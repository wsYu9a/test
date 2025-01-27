package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private final boolean bugFixServiceAlive;
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;

    public ProcessDownloadHandler() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        this.downloadCache.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i2, i3, iDownloadListener, listenerType, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        DownloadComponentManager.addProcessCallback(processCallback);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isInDownloadTaskPool(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i2, boolean z) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.cancel(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i2, boolean z) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.clearDownloadData(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i2, int i3) {
        if (DownloadComponentManager.getProcessCallbacks() != null) {
            for (ProcessCallback processCallback : DownloadComponentManager.getProcessCallbacks()) {
                if (processCallback != null) {
                    processCallback.callback(i3, i2);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.forceDownloadIgnoreRecommendSize(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getAllDownloadInfo();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i2) {
        DownloadInfo downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || (downloadInfo = iDownloadCache.getDownloadInfo(i2)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfo.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfo.getCurBytes();
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(i2);
        if (downloadChunk == null || downloadChunk.size() != chunkCount) {
            return 0L;
        }
        return DownloadUtils.getTotalOffset(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadChunk> getDownloadChunk(int i2) {
        return this.downloadCache.getDownloadChunk(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadFileUriProvider(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfo(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfoList(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadNotificationEventListener(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i2) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadingDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getFailedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        INotificationClickCallback notificationClickCallback = absDownloadEngine != null ? absDownloadEngine.getNotificationClickCallback(i2) : null;
        return notificationClickCallback == null ? DownloadComponentManager.getNotificationClickCallback() : notificationClickCallback;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i2) {
        DownloadInfo downloadInfo;
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine == null || (downloadInfo = absDownloadEngine.getDownloadInfo(i2)) == null) {
            return 0;
        }
        return downloadInfo.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getSuccessedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getUnCompletedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean isDownloadSuccessAndFileNotExist = DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (isDownloadSuccessAndFileNotExist) {
            if (DownloadExpSwitchCode.isSwitchEnable(33554432)) {
                clearDownloadData(downloadInfo.getId(), true);
            } else {
                resetDownloadData(downloadInfo.getId(), true);
            }
        }
        return isDownloadSuccessAndFileNotExist;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isDownloading(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler iDownloadServiceHandler;
        return this.bugFixServiceAlive && (iDownloadServiceHandler = this.downloadServiceHandler) != null && iDownloadServiceHandler.isServiceAlive();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.isServiceForeground();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.pause(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.shutDown();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i2) {
        this.downloadCache.removeAllDownloadChunk(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i2) {
        return this.downloadCache.removeDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.removeDownloadListener(i2, i3, iDownloadListener, listenerType, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i2) {
        return this.downloadCache.removeDownloadTaskData(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i2, boolean z) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resetDownloadData(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restart(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> list) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllFailedDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resume(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.retryDelayStart(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setDownloadNotificationEventListener(i2, iDownloadNotificationEventListener);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i2, boolean z) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i2) {
        Logger.setLogLevel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i2, long j2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setThrottleNetSpeed(i2, j2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i2, Notification notification) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startForeground(i2, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z, boolean z2) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.stopForeground(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
        this.downloadCache.syncDownloadChunks(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        this.downloadCache.syncDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        this.downloadCache.syncDownloadInfoFromOtherCache(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask downloadTask) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownload(downloadTask);
        } else if (downloadTask != null) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i2, int i3, long j2) {
        this.downloadCache.updateDownloadChunk(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        return this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        this.downloadCache.updateSubDownloadChunk(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        this.downloadCache.updateSubDownloadChunkIndex(i2, i3, i4, i5);
    }

    public ProcessDownloadHandler(boolean z) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (z) {
            this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        } else {
            this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
        }
        this.bugFixServiceAlive = DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.SERVICE_ALIVE, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i2, i3, iDownloadListener, listenerType, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(str, str2));
    }
}
