package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: classes4.dex */
public interface IDownloadProxy {
    void addDownloadChunk(DownloadChunk downloadChunk);

    void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2);

    void addProcessCallback(ProcessCallback processCallback);

    boolean canResume(int i2);

    void cancel(int i2, boolean z);

    void clearData();

    void clearDownloadData(int i2, boolean z);

    void dispatchProcessCallback(int i2, int i3);

    void forceDownloadIngoreRecommendSize(int i2);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int i2);

    List<DownloadChunk> getDownloadChunk(int i2);

    IDownloadFileUriProvider getDownloadFileUriProvider(int i2);

    int getDownloadId(String str, String str2);

    DownloadInfo getDownloadInfo(int i2);

    DownloadInfo getDownloadInfo(String str, String str2);

    List<DownloadInfo> getDownloadInfoList(String str);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2);

    int getDownloadWithIndependentProcessStatus(int i2);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str);

    INotificationClickCallback getNotificationClickCallback(int i2);

    int getStatus(int i2);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo);

    boolean isDownloading(int i2);

    boolean isHttpServiceInit();

    boolean isServiceAlive();

    boolean isServiceForeground();

    void pause(int i2);

    void pauseAll();

    void removeAllDownloadChunk(int i2);

    boolean removeDownloadInfo(int i2);

    void removeDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    boolean removeDownloadTaskData(int i2);

    void resetDownloadData(int i2, boolean z);

    void restart(int i2);

    void restartAllFailedDownloadTasks(List<String> list);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list);

    void resume(int i2);

    boolean retryDelayStart(int i2);

    void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener);

    void setDownloadWithIndependentProcessStatus(int i2, boolean z);

    void setLogLevel(int i2);

    void setThrottleNetSpeed(int i2, long j2);

    void startForeground(int i2, Notification notification);

    void startService();

    void stopForeground(boolean z, boolean z2);

    void syncDownloadChunks(int i2, List<DownloadChunk> list);

    void syncDownloadInfo(DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list);

    void tryDownload(DownloadTask downloadTask);

    void tryDownloadWithEngine(DownloadTask downloadTask);

    void updateDownloadChunk(int i2, int i3, long j2);

    boolean updateDownloadInfo(DownloadInfo downloadInfo);

    void updateSubDownloadChunk(int i2, int i3, int i4, long j2);

    void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5);
}
