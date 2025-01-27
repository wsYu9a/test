package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class IndependentProcessDownloadHandler implements IDownloadProxy, IDownloadServiceConnectionListener {
    private static final String TAG = "IndependentProcessDownloadHandler";
    private volatile IDownloadAidlService aidlService;
    private IDownloadProxy downloadProxy = new ProcessDownloadHandler();
    private IDownloadServiceHandler<IndependentProcessDownloadService> downloadServiceHandler;

    /* renamed from: com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler$1 */
    class AnonymousClass1 implements ProcessCallback {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
        public void callback(int i2, int i3) {
            if (i3 != 1) {
                if (i3 == 2) {
                    Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i2);
                }
            } else {
                Downloader.getInstance(DownloadComponentManager.getAppContext()).pause(i2);
                List<DownloadChunk> downloadChunk = DownloadProxy.get(false).getDownloadChunk(i2);
                if (downloadChunk != null) {
                    DownloadProxy.get(true).syncDownloadChunks(i2, DownloadUtils.parseHostChunkList(downloadChunk));
                }
            }
        }
    }

    public IndependentProcessDownloadHandler() {
        IDownloadServiceHandler<IndependentProcessDownloadService> independentDownloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setServiceConnectionListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        if (this.aidlService == null) {
            this.downloadProxy.addDownloadChunk(downloadChunk);
            return;
        }
        try {
            this.aidlService.addDownloadChunk(downloadChunk);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener(i2, i3, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        if (this.aidlService != null) {
            try {
                this.aidlService.addProcessCallback(IPCUtils.convertProcessCallbackToAidl(processCallback));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i2) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.canResume(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i2, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.cancel(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        if (this.aidlService == null) {
            this.downloadProxy.clearData();
            return;
        }
        try {
            this.aidlService.clearData();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i2, boolean z) {
        if (this.aidlService == null) {
            this.downloadProxy.clearDownloadData(i2, z);
            return;
        }
        try {
            this.aidlService.clearDownloadData(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i2, int i3) {
        if (this.aidlService != null) {
            try {
                this.aidlService.dispatchProcessCallback(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i2) {
        if (this.aidlService == null) {
            this.downloadProxy.forceDownloadIngoreRecommendSize(i2);
            return;
        }
        try {
            this.aidlService.forceDownloadIngoreRecommendSize(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        if (this.aidlService == null) {
            return this.downloadProxy.getAllDownloadInfo();
        }
        try {
            return this.aidlService.getAllDownloadInfo();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i2) {
        if (this.aidlService == null) {
            return 0L;
        }
        try {
            return this.aidlService.getCurBytes(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadChunk> getDownloadChunk(int i2) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadChunk(i2);
        }
        try {
            return this.aidlService.getDownloadChunk(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertFileProviderFromAidl(this.aidlService.getDownloadFileUriProvider(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i2) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfo(i2);
        }
        try {
            return this.aidlService.getDownloadInfo(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfoList(str);
        }
        try {
            return this.aidlService.getDownloadInfoList(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertDownloadNotificationEventListenerFromAidl(this.aidlService.getDownloadNotificationEventListener(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i2) {
        if (this.aidlService == null) {
            return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i2);
        }
        try {
            return this.aidlService.getDownloadWithIndependentProcessStatus(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return this.aidlService.getDownloadingDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getFailedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getFailedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i2) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertNotificationClickCallbackFromAidl(this.aidlService.getNotificationClickCallback(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i2) {
        if (this.aidlService == null) {
            return 0;
        }
        try {
            return this.aidlService.getStatus(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getSuccessedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getSuccessedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getUnCompletedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadCacheSyncSuccess();
        }
        try {
            return this.aidlService.isDownloadCacheSyncSuccess();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
        }
        try {
            this.aidlService.isDownloadSuccessAndFileNotExist(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i2) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.isDownloading(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        return this.aidlService != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        if (this.aidlService == null) {
            Logger.w(TAG, "isServiceForeground, aidlService is null");
            return false;
        }
        Logger.i(TAG, "aidlService.isServiceForeground");
        try {
            return this.aidlService.isServiceForeground();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceConnection(IBinder iBinder) {
        this.aidlService = IDownloadAidlService.Stub.asInterface(iBinder);
        if (DownloadUtils.isMainProcess()) {
            addProcessCallback(new ProcessCallback() { // from class: com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler.1
                AnonymousClass1() {
                }

                @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
                public void callback(int i2, int i3) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i2);
                        }
                    } else {
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).pause(i2);
                        List<DownloadChunk> downloadChunk = DownloadProxy.get(false).getDownloadChunk(i2);
                        if (downloadChunk != null) {
                            DownloadProxy.get(true).syncDownloadChunks(i2, DownloadUtils.parseHostChunkList(downloadChunk));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceDisConnection() {
        this.aidlService = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pause(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pauseAll();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i2) {
        if (this.aidlService == null) {
            this.downloadProxy.removeAllDownloadChunk(i2);
            return;
        }
        try {
            this.aidlService.removeAllDownloadChunk(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i2) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadInfo(i2);
        }
        try {
            return this.aidlService.removeDownloadInfo(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.removeDownloadListener(i2, i3, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i2) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadTaskData(i2);
        }
        try {
            return this.aidlService.removeDownloadTaskData(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i2, boolean z) {
        if (this.aidlService == null) {
            this.downloadProxy.resetDownloadData(i2, z);
            return;
        }
        try {
            this.aidlService.resetDownloadData(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.restart(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllFailedDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllFailedDownloadTasks(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllPauseReserveOnWifiDownloadTasks(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.resume(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i2) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.retryDelayStart(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (this.aidlService != null) {
            try {
                this.aidlService.setDownloadNotificationEventListener(i2, IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadNotificationEventListener));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i2, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setDownloadWithIndependentProcessStatus(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i2) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.setLogLevel(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i2, long j2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setThrottleNetSpeed(i2, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i2, Notification notification) {
        if (this.aidlService == null) {
            Logger.w(TAG, "startForeground, aidlService is null");
            return;
        }
        Logger.i(TAG, "aidlService.startForeground, id = " + i2);
        try {
            this.aidlService.startForeground(i2, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z, boolean z2) {
        if (this.aidlService == null) {
            Logger.w(TAG, "stopForeground, aidlService is null");
            return;
        }
        Logger.i(TAG, "aidlService.stopForeground");
        try {
            this.aidlService.stopForeground(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.syncDownloadChunks(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        if (this.aidlService == null) {
            this.downloadProxy.syncDownloadInfoFromOtherCache(i2, list);
            return;
        }
        try {
            this.aidlService.syncDownloadInfoFromOtherCache(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i2, int i3, long j2) {
        if (this.aidlService == null) {
            this.downloadProxy.updateDownloadChunk(i2, i3, j2);
            return;
        }
        try {
            this.aidlService.updateDownloadChunk(i2, i3, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.updateDownloadInfo(downloadInfo);
        }
        try {
            return this.aidlService.updateDownloadInfo(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunk(i2, i3, i4, j2);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunk(i2, i3, i4, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunkIndex(i2, i3, i4, i5);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunkIndex(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i2, int i3, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener1(i2, i3, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(getDownloadId(str, str2));
    }
}
