package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.reader.AsyncStreamReader;
import com.ss.android.socialbase.downloader.reader.IStreamReader;
import com.ss.android.socialbase.downloader.reader.SyncStreamReader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class DownloadResponseHandler {
    private static final boolean DEBUG = false;
    public static final int MIN_SYNC_STEP_BYTE = 65536;
    public static final long MIN_SYNC_TIME_MS = 500;
    private static String TAG = "ResponseHandler";
    private final AppStatusManager appStatusManager;
    private final boolean bugfixCancelThenUpdate;
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private long curOffset;
    private IDownloadCache customCache;
    private long debugReadTimeNs;
    private long debugSyncTimeNs;
    private long debugTotalTimeNs;
    private long debugWriteTimeNs;
    private DownloadCache downloadCache;
    private final DownloadChunk downloadChunk;
    private volatile long downloadChunkContentLen;
    private final DownloadInfo downloadInfo;
    private volatile long endOffset;
    private BaseException exception;
    private long handleStartOffset;
    private final boolean hasSyncStrategy;
    private final IDownloadHttpConnection httpConnection;
    private final boolean isMonitorRw;
    private RandomAccessOutputStream outputStream;
    private volatile boolean paused;
    private boolean rwConcurrent;
    private final DownloadSetting setting;
    private ISqlDownloadCache sqlDownloadCache;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private final String url;
    boolean openLimitSpeed = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadResponseHandler.this.httpConnection.end();
            } catch (Throwable unused) {
            }
        }
    }

    public DownloadResponseHandler(DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, DownloadChunk downloadChunk, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.url = str;
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        this.customCache = downloadCache;
        if (downloadCache instanceof DefaultDownloadCache) {
            DefaultDownloadCache defaultDownloadCache = (DefaultDownloadCache) downloadCache;
            this.downloadCache = defaultDownloadCache.getDownloadCache();
            this.sqlDownloadCache = defaultDownloadCache.getSqlDownloadCache();
        }
        this.httpConnection = iDownloadHttpConnection;
        this.downloadChunk = downloadChunk;
        this.callback = iDownloadRunnableCallback;
        long currentOffset = downloadChunk.getCurrentOffset();
        this.curOffset = currentOffset;
        this.handleStartOffset = currentOffset;
        if (downloadChunk.isHostChunk()) {
            this.downloadChunkContentLen = downloadChunk.getContentLength();
        } else {
            this.downloadChunkContentLen = downloadChunk.getRetainLength(false);
        }
        this.endOffset = downloadChunk.getEndOffset();
        this.appStatusManager = AppStatusManager.getInstance();
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        this.setting = obtain;
        boolean z = obtain.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        this.hasSyncStrategy = z;
        if (z) {
            long optInt = obtain.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_FG, 5000);
            long optInt2 = obtain.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000);
            this.syncIntervalMsFg = Math.max(optInt, 500L);
            this.syncIntervalMsBg = Math.max(optInt2, 500L);
        } else {
            this.syncIntervalMsFg = 0L;
            this.syncIntervalMsBg = 0L;
        }
        this.isMonitorRw = obtain.optInt(DownloadSettingKeys.MONITOR_RW) == 1;
        this.bugfixCancelThenUpdate = DownloadExpSwitchCode.isSwitchEnable(65536);
    }

    private boolean canReuseConnection() {
        return this.downloadInfo.isNeedReuseFirstConnection() && this.downloadChunk.isReuseingFirstConnection();
    }

    private void cancelConnection() {
        ExecutorService cPUThreadExecutor;
        if (this.httpConnection == null || (cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor()) == null) {
            return;
        }
        cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DownloadResponseHandler.this.httpConnection.end();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void checkAndSync(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = uptimeMillis - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j2 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                sync();
                this.lastSyncTimestamp = uptimeMillis;
                return;
            }
            return;
        }
        long j3 = this.curOffset - this.lastSyncBytes;
        if (z || isNeedSync(j3, j2)) {
            sync();
            this.lastSyncTimestamp = uptimeMillis;
        }
    }

    private IStreamReader createStreamReader(InputStream inputStream) {
        int writeBufferSize = DownloadComponentManager.getWriteBufferSize();
        if (this.setting.optInt("rw_concurrent", 0) == 1 && this.downloadInfo.getChunkCount() == 1 && this.downloadInfo.getTotalBytes() > 20971520) {
            try {
                AsyncStreamReader asyncStreamReader = new AsyncStreamReader(inputStream, writeBufferSize, this.setting.optInt(DownloadSettingKeys.RW_CONCURRENT_MAX_BUFFER_COUNT, 4));
                this.rwConcurrent = true;
                return asyncStreamReader;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SyncStreamReader syncStreamReader = new SyncStreamReader(inputStream, writeBufferSize);
        this.rwConcurrent = false;
        return syncStreamReader;
    }

    private boolean isNeedSync(long j2, long j3) {
        return j2 > 65536 && j3 > 500;
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void sync() {
        boolean z;
        long nanoTime = this.isMonitorRw ? System.nanoTime() : 0L;
        try {
            this.outputStream.flushAndSync();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.downloadInfo.updateRealDownloadTime(true);
            boolean z2 = this.downloadInfo.getChunkCount() > 1;
            IDownloadProxy iDownloadProxy = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess());
            if (z2) {
                updateDownloadChunk(this.sqlDownloadCache);
                if (iDownloadProxy != null) {
                    iDownloadProxy.updateDownloadInfo(this.downloadInfo);
                } else {
                    this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                }
            } else if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(this.downloadInfo);
            } else {
                this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadChunk.getId(), this.curOffset);
            }
            this.lastSyncBytes = this.curOffset;
        }
        if (this.isMonitorRw) {
            this.debugSyncTimeNs += System.nanoTime() - nanoTime;
        }
    }

    private void updateDownloadChunk(IDownloadCache iDownloadCache) {
        DownloadChunk downloadChunk;
        if (iDownloadCache == null) {
            return;
        }
        IDownloadProxy iDownloadProxy = null;
        boolean z = iDownloadCache instanceof SqlDownloadCache;
        if (z && (iDownloadProxy = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess())) == null) {
            return;
        }
        IDownloadProxy iDownloadProxy2 = iDownloadProxy;
        DownloadChunk firstReuseChunk = this.downloadChunk.isHostChunk() ? this.downloadChunk.getFirstReuseChunk() : this.downloadChunk;
        if (firstReuseChunk == null) {
            if (this.downloadChunk.isHostChunk()) {
                if (!z || iDownloadProxy2 == null) {
                    iDownloadCache.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                } else {
                    iDownloadProxy2.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                }
            }
            return;
        }
        firstReuseChunk.setCurrentOffset(this.curOffset);
        if (!z || iDownloadProxy2 == null) {
            downloadChunk = firstReuseChunk;
            iDownloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
        } else {
            iDownloadProxy2.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
            downloadChunk = firstReuseChunk;
        }
        if (downloadChunk.canRefreshCurOffsetForReuseChunk()) {
            boolean z2 = false;
            if (downloadChunk.hasNoBytesDownload()) {
                long nextChunkCurOffset = downloadChunk.getNextChunkCurOffset();
                if (nextChunkCurOffset > this.curOffset) {
                    if (!z || iDownloadProxy2 == null) {
                        iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                    } else {
                        iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                    }
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            if (!z || iDownloadProxy2 == null) {
                iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
            } else {
                iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
            }
        }
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        synchronized (this.callback) {
            this.canceled = true;
        }
        cancelConnection();
    }

    public long getCurOffset() {
        return this.curOffset;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x047f A[Catch: all -> 0x04db, TRY_LEAVE, TryCatch #26 {all -> 0x04db, blocks: (B:173:0x02e1, B:174:0x02e8, B:205:0x0361, B:207:0x0367, B:209:0x036a, B:241:0x0456, B:242:0x0458, B:130:0x045f, B:132:0x047f, B:166:0x04cf, B:168:0x04d5, B:169:0x04d8, B:170:0x04da), top: B:8:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04d5 A[Catch: all -> 0x04db, TryCatch #26 {all -> 0x04db, blocks: (B:173:0x02e1, B:174:0x02e8, B:205:0x0361, B:207:0x0367, B:209:0x036a, B:241:0x0456, B:242:0x0458, B:130:0x045f, B:132:0x047f, B:166:0x04cf, B:168:0x04d5, B:169:0x04d8, B:170:0x04da), top: B:8:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:173:0x02e1, B:174:0x02e8, B:205:0x0361, B:207:0x0367, B:209:0x036a, B:241:0x0456, B:242:0x0458, B:130:0x045f, B:132:0x047f, B:166:0x04cf, B:168:0x04d5, B:169:0x04d8, B:170:0x04da), top: B:8:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:173:0x02e1, B:174:0x02e8, B:205:0x0361, B:207:0x0367, B:209:0x036a, B:241:0x0456, B:242:0x0458, B:130:0x045f, B:132:0x047f, B:166:0x04cf, B:168:0x04d5, B:169:0x04d8, B:170:0x04da), top: B:8:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03e9  */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.handleResponse():void");
    }

    public void pause() {
        if (this.paused) {
            return;
        }
        this.paused = true;
        cancelConnection();
    }

    public void setChunkOffset(long j2, long j3, long j4) {
        this.curOffset = j2;
        this.handleStartOffset = j2;
        this.endOffset = j3;
        this.downloadChunkContentLen = j4;
    }

    public void setEndOffset(long j2, long j3) {
        this.endOffset = j2;
        this.downloadChunkContentLen = j3;
    }
}
