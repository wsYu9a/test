package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private WeakDownloadHandler.IHandler IHandler = new WeakDownloadHandler.IHandler() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1

        /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$1$1 */
        class RunnableC05111 implements Runnable {
            RunnableC05111() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultDownloadCache.this.resumeUnCompleteTask();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message.what == 1) {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1.1
                    RunnableC05111() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DefaultDownloadCache.this.resumeUnCompleteTask();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final DownloadCache downloadCache = new DownloadCache();
    private volatile boolean hasInitSqlDownloadCache;
    private ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$1 */
    class AnonymousClass1 implements WeakDownloadHandler.IHandler {

        /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$1$1 */
        class RunnableC05111 implements Runnable {
            RunnableC05111() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultDownloadCache.this.resumeUnCompleteTask();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message.what == 1) {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1.1
                    RunnableC05111() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DefaultDownloadCache.this.resumeUnCompleteTask();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$2 */
    class AnonymousClass2 implements DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener
        public void onRebindError() {
            DefaultDownloadCache.this.sqlDownloadCache = new SqlDownloadCache();
            Log.e(DefaultDownloadCache.TAG, "rebind error,use backup sqlDownloadCache");
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$3 */
    class AnonymousClass3 implements SqlCacheLoadCompleteCallback {
        final /* synthetic */ SparseArray val$copyDownloadChunkMap;
        final /* synthetic */ SparseArray val$copyDownloadInfoMap;

        AnonymousClass3(SparseArray sparseArray, SparseArray sparseArray2) {
            sparseArray = sparseArray;
            sparseArray2 = sparseArray2;
        }

        @Override // com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback
        public void callback() {
            synchronized (DefaultDownloadCache.this.downloadCache) {
                SparseArray<DownloadInfo> downloadInfoMap = DefaultDownloadCache.this.downloadCache.getDownloadInfoMap();
                if (sparseArray != null) {
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        int keyAt = sparseArray.keyAt(i2);
                        if (keyAt != 0) {
                            downloadInfoMap.put(keyAt, (DownloadInfo) sparseArray.get(keyAt));
                        }
                    }
                }
                SparseArray<List<DownloadChunk>> chunkListMap = DefaultDownloadCache.this.downloadCache.getChunkListMap();
                if (sparseArray2 != null) {
                    for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                        int keyAt2 = sparseArray2.keyAt(i3);
                        if (keyAt2 != 0) {
                            chunkListMap.put(keyAt2, (List) sparseArray2.get(keyAt2));
                        }
                    }
                }
            }
            DefaultDownloadCache.this.onDownloadCacheSyncSuccess();
            DefaultDownloadCache.this.resumeUnCompleteTaskMayDelayed();
            DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
        }
    }

    public DefaultDownloadCache() {
        this.weakHandler = null;
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB)) {
            this.sqlDownloadCache = new SqlDownloadCache();
        } else if (DownloadUtils.isMainProcess() || !DownloadComponentManager.supportMultiProc()) {
            this.sqlDownloadCache = new SqlDownloadCache();
        } else {
            this.sqlDownloadCache = DownloadComponentManager.getIndependentHolderCreator().createCache(new DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.2
                AnonymousClass2() {
                }

                @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener
                public void onRebindError() {
                    DefaultDownloadCache.this.sqlDownloadCache = new SqlDownloadCache();
                    Log.e(DefaultDownloadCache.TAG, "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        init();
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void onDownloadCacheSyncSuccess() {
        synchronized (this) {
            this.hasInitSqlDownloadCache = true;
            notifyAll();
        }
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo) {
        updateDownloadInfoInDB(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i2, long j2) {
        DownloadInfo OnDownloadTaskCancel = this.downloadCache.OnDownloadTaskCancel(i2, j2);
        syncDownloadInfoFromOtherCache(i2, null);
        return OnDownloadTaskCancel;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i2, long j2) {
        DownloadInfo OnDownloadTaskCompleted = this.downloadCache.OnDownloadTaskCompleted(i2, j2);
        syncDownloadInfoFromOtherCache(i2, null);
        return OnDownloadTaskCompleted;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i2, long j2, String str, String str2) {
        DownloadInfo OnDownloadTaskConnected = this.downloadCache.OnDownloadTaskConnected(i2, j2, str, str2);
        updateDownloadInfoInDB(OnDownloadTaskConnected);
        return OnDownloadTaskConnected;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i2, long j2) {
        DownloadInfo OnDownloadTaskError = this.downloadCache.OnDownloadTaskError(i2, j2);
        syncDownloadInfoFromOtherCache(i2, null);
        return OnDownloadTaskError;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i2) {
        DownloadInfo OnDownloadTaskIntercept = this.downloadCache.OnDownloadTaskIntercept(i2);
        updateDownloadInfoInDB(OnDownloadTaskIntercept);
        return OnDownloadTaskIntercept;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i2, long j2) {
        DownloadInfo OnDownloadTaskPause = this.downloadCache.OnDownloadTaskPause(i2, j2);
        syncDownloadInfoFromOtherCache(i2, null);
        return OnDownloadTaskPause;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i2) {
        DownloadInfo OnDownloadTaskPrepare = this.downloadCache.OnDownloadTaskPrepare(i2);
        updateDownloadInfoInDB(OnDownloadTaskPrepare);
        return OnDownloadTaskPrepare;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i2, long j2) {
        DownloadInfo OnDownloadTaskProgress = this.downloadCache.OnDownloadTaskProgress(i2, j2);
        updateDownloadInfoInDB(OnDownloadTaskProgress, false);
        return OnDownloadTaskProgress;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i2) {
        DownloadInfo OnDownloadTaskRetry = this.downloadCache.OnDownloadTaskRetry(i2);
        updateDownloadInfoInDB(OnDownloadTaskRetry);
        return OnDownloadTaskRetry;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        synchronized (this.downloadCache) {
            this.downloadCache.addDownloadChunk(downloadChunk);
        }
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.addDownloadChunk(downloadChunk);
        } else {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.addDownloadChunk(downloadChunk);
        } else {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i2) {
        return getDownloadInfo(i2) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            this.downloadCache.clearData();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.clearData();
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.clearData();
        } else {
            this.sqlDownloadCache.clearData();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache) {
            return true;
        }
        synchronized (this) {
            if (!this.hasInitSqlDownloadCache) {
                Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i2) {
        return this.downloadCache.getDownloadChunk(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i2) {
        return this.downloadCache.getDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        return this.downloadCache.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i2) {
        Map<Long, Segment> segmentMap = this.downloadCache.getSegmentMap(i2);
        if (segmentMap != null && !segmentMap.isEmpty()) {
            return segmentMap;
        }
        Map<Long, Segment> segmentMap2 = this.sqlDownloadCache.getSegmentMap(i2);
        this.downloadCache.updateSegments(i2, segmentMap2);
        return segmentMap2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i2) {
        List<Segment> segments = this.downloadCache.getSegments(i2);
        return (segments == null || segments.size() == 0) ? this.sqlDownloadCache.getSegments(i2) : segments;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        List<DownloadChunk> list;
        DownloadInfo downloadInfo;
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        SparseArray<List<DownloadChunk>> sparseArray2 = new SparseArray<>();
        synchronized (this.downloadCache) {
            SparseArray<DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
            for (int i2 = 0; i2 < downloadInfoMap.size(); i2++) {
                int keyAt = downloadInfoMap.keyAt(i2);
                if (keyAt != 0 && (downloadInfo = downloadInfoMap.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<DownloadChunk>> chunkListMap = this.downloadCache.getChunkListMap();
            for (int i3 = 0; i3 < chunkListMap.size(); i3++) {
                int keyAt2 = chunkListMap.keyAt(i3);
                if (keyAt2 != 0 && (list = chunkListMap.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.sqlDownloadCache.init(sparseArray, sparseArray2, new SqlCacheLoadCompleteCallback() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.3
            final /* synthetic */ SparseArray val$copyDownloadChunkMap;
            final /* synthetic */ SparseArray val$copyDownloadInfoMap;

            AnonymousClass3(SparseArray sparseArray3, SparseArray sparseArray22) {
                sparseArray = sparseArray3;
                sparseArray2 = sparseArray22;
            }

            @Override // com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback
            public void callback() {
                synchronized (DefaultDownloadCache.this.downloadCache) {
                    SparseArray<DownloadInfo> downloadInfoMap2 = DefaultDownloadCache.this.downloadCache.getDownloadInfoMap();
                    if (sparseArray != null) {
                        for (int i22 = 0; i22 < sparseArray.size(); i22++) {
                            int keyAt3 = sparseArray.keyAt(i22);
                            if (keyAt3 != 0) {
                                downloadInfoMap2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<DownloadChunk>> chunkListMap2 = DefaultDownloadCache.this.downloadCache.getChunkListMap();
                    if (sparseArray2 != null) {
                        for (int i32 = 0; i32 < sparseArray2.size(); i32++) {
                            int keyAt22 = sparseArray2.keyAt(i32);
                            if (keyAt22 != 0) {
                                chunkListMap2.put(keyAt22, (List) sparseArray2.get(keyAt22));
                            }
                        }
                    }
                }
                DefaultDownloadCache.this.onDownloadCacheSyncSuccess();
                DefaultDownloadCache.this.resumeUnCompleteTaskMayDelayed();
                DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i2) {
        DownloadInfo onDownloadTaskStart = this.downloadCache.onDownloadTaskStart(i2);
        updateDownloadInfoInDB(onDownloadTaskStart);
        return onDownloadTaskStart;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i2) {
        this.downloadCache.removeAllDownloadChunk(i2);
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.removeAllDownloadChunk(i2);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.removeAllDownloadChunk(i2);
        } else {
            this.sqlDownloadCache.removeAllDownloadChunk(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i2) {
        try {
            if (DownloadUtils.needNotifyDownloaderProcess()) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.removeDownloadInfo(i2);
                } else {
                    this.sqlDownloadCache.removeDownloadInfo(i2);
                }
            } else {
                this.sqlDownloadCache.removeDownloadInfo(i2);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.downloadCache.removeDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i2) {
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.removeDownloadTaskData(i2);
            } else {
                this.sqlDownloadCache.removeDownloadTaskData(i2);
            }
        } else {
            this.sqlDownloadCache.removeDownloadTaskData(i2);
        }
        return this.downloadCache.removeDownloadTaskData(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i2) {
        this.downloadCache.removeSegments(i2);
        this.sqlDownloadCache.removeSegments(i2);
    }

    public void resumeUnCompleteTask() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.hasInitSqlDownloadCache) {
            if (this.unCompleteTaskResumed) {
                Logger.d(TAG, "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.unCompleteTaskResumed = true;
            if (DownloadUtils.isMainProcess()) {
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    list = downloadLaunchHandler.getResumeMimeTypes();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
                    for (int i2 = 0; i2 < downloadInfoMap.size(); i2++) {
                        int keyAt = downloadInfoMap.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo2 = downloadInfoMap.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int keyAt2 = sparseArray.keyAt(i3);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (downloadLaunchHandler == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                downloadLaunchHandler.onLaunchResume(arrayList, 1);
            }
        }
    }

    public void resumeUnCompleteTaskMayDelayed() {
        this.weakHandler.sendMessageDelayed(this.weakHandler.obtainMessage(1), DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_TASK_RESUME_DELAY) ? 4000L : Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.downloadCache.syncDownloadChunks(i2, list);
        if (DownloadUtils.isDownloaderProcess()) {
            this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        try {
            updateDownloadInfo(this.downloadCache.getDownloadInfo(i2));
            if (list == null) {
                list = this.downloadCache.getDownloadChunk(i2);
            }
            if (!DownloadUtils.needNotifyDownloaderProcess()) {
                this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i2, list);
                return;
            }
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.syncDownloadInfoFromOtherCache(i2, list);
            } else {
                this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i2, list);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i2, int i3) {
        DownloadInfo updateChunkCount = this.downloadCache.updateChunkCount(i2, i3);
        updateDownloadInfoInDB(updateChunkCount);
        return updateChunkCount;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i2, int i3, long j2) {
        this.downloadCache.updateDownloadChunk(i2, i3, j2);
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateDownloadChunk(i2, i3, j2);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateDownloadChunk(i2, i3, j2);
        } else {
            this.sqlDownloadCache.updateDownloadChunk(i2, i3, j2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean updateDownloadInfo = this.downloadCache.updateDownloadInfo(downloadInfo);
        updateDownloadInfoInDB(downloadInfo);
        return updateDownloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i2, Map<Long, Segment> map) {
        this.downloadCache.updateSegments(i2, map);
        this.sqlDownloadCache.updateSegments(i2, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateSubDownloadChunk(i2, i3, i4, j2);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateSubDownloadChunk(i2, i3, i4, j2);
        } else {
            this.sqlDownloadCache.updateSubDownloadChunk(i2, i3, i4, j2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateSubDownloadChunkIndex(i2, i3, i4, i5);
            return;
        }
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateSubDownloadChunkIndex(i2, i3, i4, i5);
        } else {
            this.sqlDownloadCache.updateSubDownloadChunkIndex(i2, i3, i4, i5);
        }
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            return;
        }
        if (z) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(downloadInfo);
            } else {
                this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            }
        }
    }
}
