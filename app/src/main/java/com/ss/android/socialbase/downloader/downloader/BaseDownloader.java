package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class BaseDownloader {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    BaseDownloader() {
    }

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.MAIN, false);
    }

    public void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.SUB, false);
    }

    public boolean canResume(int i2) {
        return DownloadProcessDispatcher.getInstance().canResume(i2);
    }

    public void cancel(int i2) {
        cancel(i2, true);
    }

    public void clearDownloadData(int i2) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i2, true);
    }

    public void destoryDownloader() {
        DownloadComponentManager.unRegisterDownloadReceiver();
    }

    public void forceDownloadIngoreRecommendSize(int i2) {
        DownloadProcessDispatcher.getInstance().forceDownloadIngoreRecommendSize(i2);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    public long getCurBytes(int i2) {
        return DownloadProcessDispatcher.getInstance().getCurBytes(i2);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        return DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(i2);
    }

    public int getDownloadId(String str, String str2) {
        return DownloadProcessDispatcher.getInstance().getDownloadId(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i2) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(i2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfoList(str);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2) {
        return DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(i2);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getFailedDownloadInfosWithMimeType(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return DownloadComponentManager.getReserveWifiStatusListener();
    }

    public int getStatus(int i2) {
        return DownloadProcessDispatcher.getInstance().getStatus(i2);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    public boolean isDownloadServiceForeground(int i2) {
        return DownloadProcessDispatcher.getInstance().getDownloadHandler(i2).isServiceForeground();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i2) {
        boolean isDownloading;
        if (!DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            return DownloadProcessDispatcher.getInstance().isDownloading(i2);
        }
        synchronized (this) {
            isDownloading = DownloadProcessDispatcher.getInstance().isDownloading(i2);
        }
        return isDownloading;
    }

    public boolean isHttpServiceInit() {
        return DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    public void pause(int i2) {
        DownloadProcessDispatcher.getInstance().pause(i2);
    }

    public void pauseAll() {
        DownloadProcessDispatcher.getInstance().pauseAll();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    public void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, iDownloadListener, ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, iDownloadListener, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i2) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, null, ListenerType.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i2) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, null, ListenerType.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i2) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i2, null, ListenerType.SUB, true);
    }

    public void restart(int i2) {
        DownloadProcessDispatcher.getInstance().restart(i2);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    public void resume(int i2) {
        DownloadProcessDispatcher.getInstance().resume(i2);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            DownloadComponentManager.setDownloadInMultiProcess();
        } else {
            synchronized (this) {
                DownloadComponentManager.setDownloadInMultiProcess();
            }
        }
    }

    public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(i2, iDownloadNotificationEventListener);
    }

    public void setLogLevel(int i2) {
        DownloadProcessDispatcher.getInstance().setLogLevel(i2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        DownloadComponentManager.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @Deprecated
    public void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int i2, long j2) {
        DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(i2, j2);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                if (!z) {
                    return null;
                }
                file.delete();
                file.mkdirs();
            }
            return file;
        } catch (Throwable unused2) {
            file2 = file;
            return file2;
        }
    }

    public void cancel(int i2, boolean z) {
        DownloadProcessDispatcher.getInstance().cancel(i2, z);
    }

    public void clearDownloadData(int i2, boolean z) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i2, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i2, iDownloadListener, ListenerType.MAIN, true, z);
    }
}
