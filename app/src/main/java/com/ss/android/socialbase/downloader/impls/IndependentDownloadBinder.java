package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class IndependentDownloadBinder extends IDownloadAidlService.Stub {
    private static final String TAG = IndependentDownloadBinder.class.getSimpleName();
    private final IDownloadProxy downloadProxy = new ProcessDownloadHandler(true);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadChunk(DownloadChunk downloadChunk) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i2, i3, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadUtils.convertListenerType(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener1(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z, boolean z2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i2, i3, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadUtils.convertListenerType(i4), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addProcessCallback(IPCUtils.convertProcessAidlCallbackFromAidl(processAidlCallback));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean canResume(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.canResume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void cancel(int i2, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.cancel(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearData() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearDownloadData(int i2, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void dispatchProcessCallback(int i2, int i3) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.dispatchProcessCallback(i2, i3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void forceDownloadIngoreRecommendSize(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.forceDownloadIngoreRecommendSize(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public long getCurBytes(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0L;
        }
        return iDownloadProxy.getCurBytes(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadChunk> getDownloadChunk(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadChunk(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadAidlFileProvider getDownloadFileUriProvider(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertFileProviderToAidl(iDownloadProxy.getDownloadFileUriProvider(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadId(String str, String str2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfo(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadProxy.getDownloadNotificationEventListener(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadWithIndependentProcessStatus(int i2) throws RemoteException {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public INotificationClickAidlCallback getNotificationClickCallback(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return IPCUtils.convertNotificationClickCallbackToAidl(iDownloadProxy.getNotificationClickCallback(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getStatus(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getStatus(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadCacheSyncSuccess() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloading(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloading(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isHttpServiceInit() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isServiceForeground() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isServiceForeground();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pause(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pause(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pauseAll() throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeAllDownloadChunk(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.removeAllDownloadChunk(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadInfo(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.removeDownloadListener(i2, i3, IPCUtils.convertListenerFromAidl(iDownloadAidlListener), DownloadUtils.convertListenerType(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadTaskData(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadTaskData(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resetDownloadData(int i2, boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restart(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restart(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resume(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.resume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean retryDelayStart(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.retryDelayStart(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setDownloadNotificationEventListener(i2, IPCUtils.convertDownloadNotificationEventListenerFromAidl(iDownloadNotificationEventAidlListener));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadWithIndependentProcessStatus(int i2, boolean z) throws RemoteException {
        DownloadProcessDispatcher.getInstance().setDownloadIndependentProcessStatus(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setLogLevel(int i2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setLogLevel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setThrottleNetSpeed(int i2, long j2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setThrottleNetSpeed(i2, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void startForeground(int i2, Notification notification) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.startForeground(i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void stopForeground(boolean z) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.stopForeground(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.syncDownloadChunks(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.syncDownloadInfoFromOtherCache(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.tryDownloadWithEngine(IPCUtils.convertDownloadTaskFromAidl(downloadAidlTask));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateDownloadChunk(int i2, int i3, long j2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateDownloadChunk(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateSubDownloadChunk(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) throws RemoteException {
        IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateSubDownloadChunkIndex(i2, i3, i4, i5);
    }
}
