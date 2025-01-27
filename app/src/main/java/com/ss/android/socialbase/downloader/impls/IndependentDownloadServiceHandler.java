package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    private static final String TAG = IndependentDownloadServiceHandler.class.getSimpleName();
    private IDownloadAidlService aidlService;
    private IDownloadServiceConnectionListener connectionListener;
    private int logLevel = -1;

    private void resumePendingTaskForIndependent() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.pendingTasks) {
                clone = this.pendingTasks.clone();
                this.pendingTasks.clear();
            }
            if (clone == null || clone.size() <= 0 || DownloadComponentManager.getDownloadEngine() == null) {
                return;
            }
            for (int i2 = 0; i2 < clone.size(); i2++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i2));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(it.next()));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e(TAG, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        if (intent != null && intent.getBooleanExtra(DownloadConstants.KEY_FIX_DOWNLOADER_DB_SIGBUS, false)) {
            Log.w(TAG, "downloader process sync database on main process!");
            DownloadSetting.setGlobalBugFix(DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB, true);
        }
        Logger.d(TAG, "onBind IndependentDownloadBinder");
        return new IndependentDownloadBinder();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.aidlService = null;
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = TAG;
        Logger.d(str, "onServiceConnected ");
        this.aidlService = IDownloadAidlService.Stub.asInterface(iBinder);
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceConnection(iBinder);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.aidlService != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.pendingTasks.size());
        Logger.d(str, sb.toString());
        if (this.aidlService != null) {
            DownloadProcessDispatcher.getInstance().dispatchDownloaderProcessConnectedEvent();
            this.isServiceAlive = true;
            this.isInvokeStartService = false;
            int i2 = this.logLevel;
            if (i2 != -1) {
                try {
                    this.aidlService.setLogLevel(i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.aidlService != null) {
                resumePendingTaskForIndependent();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Logger.d(TAG, "onServiceDisconnected ");
        this.aidlService = null;
        this.isServiceAlive = false;
        IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i2) {
        IDownloadAidlService iDownloadAidlService = this.aidlService;
        if (iDownloadAidlService == null) {
            this.logLevel = i2;
            return;
        }
        try {
            iDownloadAidlService.setLogLevel(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
        this.connectionListener = iDownloadServiceConnectionListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            Logger.d(TAG, "bindService");
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (DownloadUtils.isMainProcess()) {
                intent.putExtra(DownloadConstants.KEY_FIX_DOWNLOADER_DB_SIGBUS, DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context context, ServiceConnection serviceConnection) {
        Logger.d(TAG, "stopService");
        this.isServiceAlive = false;
        Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.aidlService == null);
        Logger.d(str, sb.toString());
        if (this.aidlService == null) {
            pendDownloadTask(downloadTask);
            startService(DownloadComponentManager.getAppContext(), this);
            return;
        }
        resumePendingTaskForIndependent();
        try {
            this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(downloadTask.getDownloadId(), true);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.tryDownload(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.aidlService == null) {
            startService(DownloadComponentManager.getAppContext(), this);
        }
    }
}
