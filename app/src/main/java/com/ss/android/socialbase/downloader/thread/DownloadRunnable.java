package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.RetryDelayTimeParamCalculator;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool;
import com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.segment.SegmentStrategy;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadSettingsUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DownloadRunnable implements IDownloadRunnableCallback, Runnable {
    private static final int MAX_RESET_RETAIN_RETRY_TIMES_COUNT = 3;
    private static final String TAG = DownloadRunnable.class.getSimpleName();
    private boolean acceptPartial;
    private boolean canResumeFromCache;
    private long curBytesNeedCheckSpaceOverFlow;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private final IDownloadCache downloadCache;
    private DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private volatile BaseException errorException;
    private String existTargetFileName;
    private IDownloadHttpConnection firstGetConnection;
    private IDownloadHeadHttpConnection firstHeadConnection;
    private volatile DownloadResponseHandler firstHttpResponseHandler;
    private IDownloadForbiddenHandler forbiddenHandler;
    private final IChunkAdjustCalculator globalChunkAdjustCalculator;
    private final IChunkCntCalculator globalChunkCalculator;
    private final AtomicBoolean isAlive;
    private boolean isChunked;
    private boolean isResponseFromBegin;
    private boolean isSingleChunk;
    private Future mFuture;
    private long prepareDownloadTime;
    private AtomicInteger retainRetryTimes;
    private IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private final DownloadSetting setting;
    private final DownloadStatusHandler statusHandler;
    private IChunkAdjustCalculator taskChunkAdjustCalculator;
    private IChunkCntCalculator taskChunkCalculator;
    private volatile boolean isTriedFixRangeNotSatisfiable = false;
    private final ArrayList<DownloadChunkRunnable> downloadChunkRunnableList = new ArrayList<>();
    private volatile RunStatus runStatus = RunStatus.RUN_STATUS_NONE;
    private volatile int bytesRetryCount = 5;
    private boolean needJumpToStart = false;
    private boolean firstHeadConnectionFailed = false;
    private boolean needCheckIfModified = false;
    private int resetRetainRetryTimesCount = 0;
    private volatile SegmentDispatcher segmentDispatcher = null;

    /* renamed from: com.ss.android.socialbase.downloader.thread.DownloadRunnable$1 */
    class AnonymousClass1 extends AbsDownloadForbiddenCallback {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback, com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public void onCallback(List<String> list) {
            super.onCallback(list);
            DownloadRunnable.this.handleForbiddenCallback(list);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.thread.DownloadRunnable$2 */
    class AnonymousClass2 implements IDownloadDiskSpaceCallback {
        final /* synthetic */ AtomicBoolean val$diskCleaned;

        AnonymousClass2(AtomicBoolean atomicBoolean) {
            atomicBoolean = atomicBoolean;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
        public void onDiskCleaned() {
            synchronized (DownloadRunnable.this) {
                atomicBoolean.set(true);
                DownloadRunnable.this.handleDiskSpaceCallback();
            }
        }
    }

    public DownloadRunnable(DownloadTask downloadTask, Handler handler) {
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
            this.taskChunkCalculator = downloadTask.getChunkStrategy();
            this.taskChunkAdjustCalculator = downloadTask.getChunkAdjustCalculator();
            this.forbiddenHandler = downloadTask.getForbiddenHandler();
            this.diskSpaceHandler = downloadTask.getDiskSpaceHandler();
            this.retryDelayTimeCalculator = getRetryDelayTimeCalculator(downloadTask);
            this.setting = DownloadSetting.obtain(this.downloadInfo.getId());
        } else {
            this.setting = DownloadSetting.obtainGlobal();
        }
        updateRetainRetryTimes();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.globalChunkCalculator = DownloadComponentManager.getChunkCntCalculator();
        this.globalChunkAdjustCalculator = DownloadComponentManager.getChunkAdjustCalculator();
        this.statusHandler = new DownloadStatusHandler(downloadTask, handler);
        this.isAlive = new AtomicBoolean(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
    
        if (r9 <= 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int calculateChunkCount(long r7, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> r9) {
        /*
            r6 = this;
            boolean r0 = r6.isMultiChunkDownloadAvailable()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.canResumeFromCache
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.downloadInfo
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator r9 = r6.taskChunkCalculator
            if (r9 == 0) goto L23
            int r9 = r9.calculateChunkCount(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator r9 = r6.globalChunkCalculator
            int r9 = r9.calculateChunkCount(r7)
        L29:
            com.ss.android.socialbase.downloader.network.NetTrafficManager r0 = com.ss.android.socialbase.downloader.network.NetTrafficManager.getInstance()
            com.ss.android.socialbase.downloader.network.NetworkQuality r0 = r0.getCurrentNetworkQuality()
            java.lang.String r3 = com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.logger.Logger.d(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.downloadInfo
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator r3 = r6.taskChunkAdjustCalculator
            if (r3 == 0) goto L56
            int r9 = r3.calculateChunkCount(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator r3 = r6.globalChunkAdjustCalculator
            int r9 = r3.calculateChunkCount(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.logger.Logger.debug()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.downloadInfo
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.logger.Logger.d(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.calculateChunkCount(long, java.util.List):int");
    }

    private void cancelAllChunkRunnable() {
        try {
            Iterator it = ((ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable downloadChunkRunnable = (DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.cancel();
                }
            }
        } catch (Throwable th) {
            Logger.i(TAG, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean checkCompletedByteValid() {
        if (this.downloadInfo.isChunked()) {
            DownloadInfo downloadInfo = this.downloadInfo;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        Logger.i(TAG, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.downloadInfo.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.downloadInfo.getTotalBytes());
        if (this.downloadInfo.getCurBytes() > 0) {
            if (this.downloadInfo.isIgnoreDataVerify()) {
                return true;
            }
            if (this.downloadInfo.getTotalBytes() > 0 && this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
                return true;
            }
        }
        this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.downloadInfo.reset();
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        return false;
    }

    private void checkHasAnotherSameTask() throws RetryThrowable, BaseException {
        AbsDownloadEngine downloadEngine;
        int id = this.downloadInfo.getId();
        int downloadId = DownloadComponentManager.getDownloadId(this.downloadInfo);
        if (this.downloadInfo.isDownloaded() && !this.downloadInfo.isExpiredRedownload() && !this.needCheckIfModified) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(downloadId);
        if (downloadInfo == null || (downloadEngine = DownloadComponentManager.getDownloadEngine()) == null || downloadInfo.getId() == id || !downloadInfo.equalsTask(this.downloadInfo)) {
            return;
        }
        if (downloadEngine.isDownloading(downloadInfo.getId())) {
            this.downloadCache.removeDownloadTaskData(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(downloadId);
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.downloadCache.removeDownloadTaskData(downloadId);
        if (downloadInfo.isBreakpointAvailable()) {
            this.downloadInfo.copyFromCacheData(downloadInfo, false);
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
            if (downloadChunk != null) {
                for (DownloadChunk downloadChunk2 : downloadChunk) {
                    downloadChunk2.setId(id);
                    this.downloadCache.addDownloadChunk(downloadChunk2);
                }
            }
            throw new RetryThrowable("retry task because id generator changed");
        }
    }

    private boolean checkIsStoppedByUser() {
        if (!isStoppedStatus() && this.downloadInfo.getStatus() != -2) {
            return false;
        }
        if (isStoppedStatus()) {
            return true;
        }
        if (this.downloadInfo.getStatus() == -2) {
            this.runStatus = RunStatus.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.downloadInfo.getStatus() != -4) {
            return true;
        }
        this.runStatus = RunStatus.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean checkNeedRetryDelay() {
        return false;
    }

    private void checkSavePathValid() throws BaseException {
        if (TextUtils.isEmpty(this.downloadInfo.getSavePath())) {
            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_EMPTY, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.downloadInfo.getName())) {
            throw new BaseException(DownloadErrorCode.ERROR_FILE_NAME_EMPTY, "download name can not be empty");
        }
        File file = new File(this.downloadInfo.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!DownloadSettingsUtils.isOptimizeSavePath(this.downloadInfo)) {
                throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not a directory:" + this.downloadInfo.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + this.downloadInfo.getSavePath());
        }
        boolean mkdirs = file.mkdirs();
        if (mkdirs || file.exists()) {
            return;
        }
        int i2 = 0;
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        while (!mkdirs) {
            int i3 = i2 + 1;
            if (i2 >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                mkdirs = file.mkdirs();
                i2 = i3;
            } catch (InterruptedException unused) {
            }
        }
        if (mkdirs || file.exists()) {
            return;
        }
        if (DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getSavePath()) < 16384) {
            throw new BaseException(1006, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
    }

    private void checkSpaceOverflowInProgress() throws BaseException {
        long j2;
        int optInt;
        try {
            j2 = DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getTempPath());
        } catch (BaseException unused) {
            j2 = 0;
        }
        String str = TAG;
        Logger.i(str, "checkSpaceOverflowInProgress: available = " + DownloadUtils.byteToMb(j2) + "MB");
        if (j2 > 0) {
            long totalBytes = this.downloadInfo.getTotalBytes() - this.downloadInfo.getCurBytes();
            if (j2 < totalBytes && (optInt = DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100)) > 0) {
                long j3 = j2 - (optInt * 1048576);
                Logger.i(str, "checkSpaceOverflowInProgress: minKeep  = " + optInt + "MB, canDownload = " + DownloadUtils.byteToMb(j3) + "MB");
                if (j3 > 0) {
                    this.curBytesNeedCheckSpaceOverFlow = this.downloadInfo.getCurBytes() + j3 + 1048576;
                    return;
                } else {
                    this.curBytesNeedCheckSpaceOverFlow = 0L;
                    throw new DownloadOutOfSpaceException(j2, totalBytes);
                }
            }
        }
        this.curBytesNeedCheckSpaceOverFlow = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f3, code lost:
    
        if (r9.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO) != false) goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x00e8, TryCatch #5 {all -> 0x00e8, blocks: (B:34:0x00a7, B:36:0x00ab, B:38:0x00af, B:60:0x00e7), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkTaskCache() throws com.ss.android.socialbase.downloader.exception.DownloadFileExistException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.checkTaskCache():void");
    }

    private void checkTaskCanResume() {
        long curByte = DownloadUtils.getCurByte(this.downloadInfo);
        long curBytes = this.downloadInfo.getCurBytes();
        if (curByte != curBytes) {
            Logger.w(TAG, "checkTaskCanResume: offset = " + curByte + ", curBytes = " + curBytes);
        }
        this.downloadInfo.setCurBytes(curByte);
        boolean z = curByte > 0;
        this.canResumeFromCache = z;
        if (z || this.needCheckIfModified) {
            return;
        }
        Logger.i(TAG, "checkTaskCanResume: deleteAllDownloadFiles");
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
    }

    private boolean checkTaskStatusValid() {
        int status = this.downloadInfo.getStatus();
        if (status == 1 || this.downloadInfo.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        onError(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private void checkWifiTaskValid() throws DownloadRetryNeedlessException {
        if (this.downloadInfo.isOnlyWifi() && !DownloadUtils.checkPermission(DownloadComponentManager.getAppContext(), g.f9317b)) {
            throw new DownloadRetryNeedlessException(1019, String.format("download task need permission:%s", g.f9317b));
        }
        if (!this.downloadInfo.isDownloadWithWifiValid()) {
            throw new DownloadOnlyWifiException();
        }
        if (!this.downloadInfo.isPauseReserveWithWifiValid()) {
            throw new DownloadPauseReserveWifiException();
        }
    }

    private void clearCurrentDownloadData() {
        Logger.w(TAG, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
            this.downloadCache.removeSegments(this.downloadInfo.getId());
            DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
            this.canResumeFromCache = false;
            this.downloadInfo.resetDataForEtagEndure("");
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void closeConnection() {
        closeFirstHeadConnection();
        closeFirstConnection();
    }

    private void closeFirstConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.firstGetConnection = null;
        }
    }

    private void closeFirstHeadConnection() {
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            iDownloadHeadHttpConnection.cancel();
            this.firstHeadConnection = null;
        }
    }

    public static DownloadChunk createFirstDownloadChunk(DownloadInfo downloadInfo, long j2) {
        return new DownloadChunk.Builder(downloadInfo.getId()).chunkIndex(-1).startOffset(0L).oldOffset(j2).currentOffset(j2).endOffset(0L).contentLength(downloadInfo.getTotalBytes() - j2).build();
    }

    private void createFirstGetConnection(String str, List<HttpHeader> list) throws BaseException, RetryThrowable {
        IDownloadHttpConnection iDownloadHttpConnection;
        if (this.firstGetConnection != null) {
            return;
        }
        FakeDownloadHttpConnection cachedDownloadConnection = this.downloadInfo.getChunkCount() == 1 ? DownloadConnectionPool.getInstance().getCachedDownloadConnection(str, list) : null;
        try {
            if (cachedDownloadConnection != null) {
                setHttpResponseStatus(this.firstGetConnection);
                this.downloadInfo.setPreconnectLevel(2);
                this.firstGetConnection = cachedDownloadConnection;
            } else {
                try {
                    iDownloadHttpConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, null, list, this.setting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) > 0, this.downloadInfo);
                    this.firstGetConnection = iDownloadHttpConnection;
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (this.downloadInfo.isExpiredRedownload() && DownloadUtils.isResponseCode304Error(th) && DownloadUtils.hasDownloadCacheHeader(list)) {
                        Logger.d(TAG, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.downloadInfo.getCacheControl());
                        long parserMaxAge = DownloadUtils.parserMaxAge(this.downloadInfo.getCacheControl());
                        if (parserMaxAge <= 0) {
                            parserMaxAge = DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.DEFAULT_304_MAX_AGE, 300);
                        }
                        this.downloadInfo.setCacheExpiredTime(System.currentTimeMillis() + (parserMaxAge * 1000));
                        throw new DownloadFileExistException(this.existTargetFileName);
                    }
                    if (DownloadUtils.isResponseCode416Error(th)) {
                        handleResponseCodeError("", "http code 416");
                    } else if (DownloadUtils.isResponseCode412Error(th)) {
                        handleResponseCodeError("", "http code 412");
                    } else {
                        DownloadUtils.parseException(th, "CreateFirstConnection");
                    }
                    iDownloadHttpConnection = this.firstGetConnection;
                }
                setHttpResponseStatus(iDownloadHttpConnection);
            }
            if (this.firstGetConnection == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            setHttpResponseStatus(this.firstGetConnection);
            throw th2;
        }
    }

    private void createFirstHeadConnection(String str, List<HttpHeader> list, long j2) throws BaseException, RetryThrowable {
        FakeDownloadHeadHttpConnection cachedHeadConnection;
        boolean z = true;
        if (this.downloadInfo.getChunkCount() == 1 && (cachedHeadConnection = DownloadConnectionPool.getInstance().getCachedHeadConnection(str, list)) != null) {
            this.firstHeadConnection = cachedHeadConnection;
            this.downloadInfo.setPreconnectLevel(1);
        }
        if (this.firstHeadConnection == null && !this.firstHeadConnectionFailed && this.downloadInfo.isHeadConnectionAvailable()) {
            try {
                int optInt = this.setting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY);
                if (this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) <= 0) {
                    z = false;
                }
                this.firstHeadConnection = DownloadComponentManager.downloadWithHeadConnection(str, list, optInt, z, this.downloadInfo);
            } catch (Throwable th) {
                this.downloadInfo.setHeadConnectionException(DownloadUtils.getThrowableMsg(th));
            }
        }
    }

    private void doFirstConnect(String str, List<HttpHeader> list, long j2) throws BaseException, RetryThrowable {
        createFirstHeadConnection(str, list, j2);
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            try {
                handleFirstConnection(str, iDownloadHeadHttpConnection, j2);
            } catch (Throwable unused) {
                this.firstHeadConnectionFailed = true;
            }
        }
        if (this.firstHeadConnection == null || this.firstHeadConnectionFailed) {
            createFirstGetConnection(str, list);
            handleFirstConnection(str, this.firstGetConnection, j2);
        }
    }

    private boolean doTaskStatusHandle() {
        if (this.runStatus == RunStatus.RUN_STATUS_ERROR) {
            this.statusHandler.onError(this.errorException);
        } else if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
            this.statusHandler.onCancel();
        } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
            this.statusHandler.onPause();
        } else if (this.runStatus == RunStatus.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.statusHandler.onCompleteForFileExist();
            } catch (BaseException e2) {
                this.statusHandler.onError(e2);
            }
        } else if (this.runStatus == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.statusHandler.onCompleteForFileExist(this.existTargetFileName);
            } catch (BaseException e3) {
                this.statusHandler.onError(e3);
            }
        } else {
            if (this.runStatus == RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.statusHandler.onRetry(this.errorException, false);
                return false;
            }
            if (this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            RunStatus runStatus = this.runStatus;
            RunStatus runStatus2 = RunStatus.RUN_STATUS_RETRY_DELAY;
            if (runStatus == runStatus2 && !isAllChunkDownloadComplete()) {
                Logger.d(TAG, "doTaskStatusHandle retryDelay");
                startRetryDelayAlarm();
                return this.runStatus == runStatus2;
            }
            try {
                if (!checkCompletedByteValid()) {
                    return false;
                }
                this.statusHandler.onCompleted();
                RetryScheduler.getInstance().scheduleRetryWhenHasTaskSucceed();
            } catch (Throwable th) {
                onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private void downloadInner() {
        boolean z;
        List<DownloadChunk> downloadChunk;
        try {
            this.runStatus = RunStatus.RUN_STATUS_NONE;
            this.downloadInfo.updateStartDownloadTime();
            this.downloadInfo.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.downloadInfo.setFirstSpeedTime(-1L);
            try {
                checkTaskCache();
                z = false;
            } catch (DownloadFileExistException e2) {
                Logger.d(TAG, "file exist " + e2.getExistTargetFileName());
                this.existTargetFileName = e2.getExistTargetFileName();
                z = true;
            }
            if (!this.needJumpToStart) {
                this.statusHandler.onStart();
            }
            this.needJumpToStart = false;
            if (checkIsStoppedByUser()) {
                return;
            }
            if (!TextUtils.isEmpty(this.existTargetFileName) && z) {
                if (this.downloadInfo.isExpiredRedownload()) {
                    this.needCheckIfModified = DownloadUtils.cacheExpired(this.downloadInfo);
                }
                if (!this.needCheckIfModified) {
                    finishWithFileExist();
                    return;
                }
            }
            while (!checkIsStoppedByUser()) {
                try {
                    try {
                        try {
                            try {
                                checkSavePathValid();
                                checkHasAnotherSameTask();
                                checkWifiTaskValid();
                                downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
                                checkTaskCanResume();
                            } catch (RetryThrowable e3) {
                                try {
                                    Logger.w(TAG, "downloadInner: retry throwable for " + e3.getErrorMsg());
                                    if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                                        AtomicInteger atomicInteger = this.retainRetryTimes;
                                        if (atomicInteger != null && atomicInteger.get() > 0) {
                                            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
                                            this.downloadInfo.setStatus(5);
                                        } else if (this.retainRetryTimes == null) {
                                            onError(new BaseException(DownloadErrorCode.ERROR_RETAIN_RETRY_TIME_IS_NULL, "retry for Throwable, but retain retry time is NULL, last error is" + e3.getErrorMsg()));
                                        } else if (this.downloadInfo.trySwitchToNextBackupUrl()) {
                                            this.downloadInfo.setStatus(5);
                                            this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
                                            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
                                        } else {
                                            onError(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.downloadInfo.getRetryCount()), e3.getErrorMsg())));
                                        }
                                        closeConnection();
                                    }
                                } catch (Throwable th) {
                                    closeConnection();
                                    throw th;
                                }
                            }
                        } catch (BaseException e4) {
                            Logger.w(TAG, "downloadInner: baseException = " + e4);
                            if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                                if (e4.getErrorCode() != 1025 && e4.getErrorCode() != 1009) {
                                    if (canRetry(e4)) {
                                        if (DownloadUtils.isHttpDataDirtyError(e4)) {
                                            clearCurrentDownloadData();
                                        }
                                        if (onRetry(e4, 0L) == RetryCheckStatus.RETURN) {
                                            closeConnection();
                                            return;
                                        }
                                        closeConnection();
                                    } else {
                                        onError(e4);
                                    }
                                }
                                this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
                                closeConnection();
                                return;
                            }
                        }
                    } catch (DownloadFileExistException unused) {
                        finishWithFileExist();
                    }
                } catch (Throwable th2) {
                    Logger.w(TAG, "downloadInner: throwable =  " + th2);
                    if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                        onError(new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_RUNNABLE_UNKNOWN, th2));
                    }
                }
                if (downloadSegments()) {
                    Logger.i(TAG, "downloadSegments return");
                    closeConnection();
                    return;
                }
                String connectionUrl = this.downloadInfo.getConnectionUrl();
                if (checkIsStoppedByUser()) {
                    closeConnection();
                    return;
                }
                long firstOffset = this.canResumeFromCache ? DownloadUtils.getFirstOffset(this.downloadInfo) : 0L;
                DownloadChunk createFirstDownloadChunk = createFirstDownloadChunk(this.downloadInfo, firstOffset);
                List<HttpHeader> extraHeaders = getExtraHeaders(createFirstDownloadChunk);
                DownloadUtils.addThrottleNetSpeed(extraHeaders, this.downloadInfo);
                DownloadUtils.addTTNetProtectTimeout(extraHeaders, this.downloadInfo);
                this.downloadInfo.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    doFirstConnect(connectionUrl, extraHeaders, firstOffset);
                    this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        return;
                    }
                    long totalBytes = this.downloadInfo.getTotalBytes();
                    checkSpaceOverflow(totalBytes);
                    int calculateChunkCount = calculateChunkCount(totalBytes, downloadChunk);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        return;
                    }
                    if (calculateChunkCount <= 0) {
                        throw new BaseException(DownloadErrorCode.ERROR_CHUNK_COUNT_ERROR, "chunkCount is 0");
                    }
                    boolean z2 = calculateChunkCount == 1;
                    this.isSingleChunk = z2;
                    if (z2) {
                        if (this.firstGetConnection == null) {
                            try {
                                currentTimeMillis2 = System.currentTimeMillis();
                                createFirstGetConnection(connectionUrl, extraHeaders);
                                this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                            } finally {
                            }
                        }
                        if (checkIsStoppedByUser()) {
                            closeConnection();
                            return;
                        } else {
                            this.downloadInfo.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            resetRetainRetryTimes();
                            handleResponseWithSingleChunk(createFirstDownloadChunk, connectionUrl, this.firstGetConnection);
                        }
                    } else {
                        if (!this.downloadInfo.isNeedReuseFirstConnection()) {
                            closeFirstConnection();
                        }
                        if (checkIsStoppedByUser()) {
                            closeConnection();
                            return;
                        }
                        resetRetainRetryTimes();
                        this.downloadInfo.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                        if (this.canResumeFromCache) {
                            handleResponseWithMultiChunkFromResume(calculateChunkCount, downloadChunk);
                        } else {
                            handleResponseMultiChunkFromBegin(totalBytes, calculateChunkCount);
                        }
                    }
                    closeConnection();
                    return;
                } finally {
                }
            }
        } finally {
            endDownloadRunnable();
        }
    }

    private boolean downloadSegments() throws BaseException, InterruptedException {
        if (this.downloadInfo.isExpiredRedownload() || this.downloadInfo.getChunkCount() != 1 || this.downloadInfo.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject optJSONObject = DownloadSetting.obtain(this.downloadInfo.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
        List<Segment> segments = this.downloadCache.getSegments(this.downloadInfo.getId());
        if (this.downloadInfo.getCurBytes() > 0) {
            if (segments == null || segments.isEmpty()) {
                return false;
            }
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
        }
        if (optJSONObject == null) {
            return false;
        }
        this.segmentDispatcher = new SegmentDispatcher(this.downloadInfo, SegmentStrategy.from(optJSONObject), this);
        if (!checkIsStoppedByUser()) {
            return this.segmentDispatcher.downloadSegments(segments);
        }
        Logger.i(TAG, "downloadSegments: is stopped by user");
        if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
            this.segmentDispatcher.cancel();
        } else {
            this.segmentDispatcher.pause();
        }
        return true;
    }

    private void endDownloadRunnable() {
        boolean z;
        boolean z2;
        Logger.d(TAG, "endDownloadRunnable::runStatus=" + this.runStatus);
        boolean z3 = (this.runStatus == RunStatus.RUN_STATUS_PAUSE || this.runStatus == RunStatus.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = doTaskStatusHandle();
            z2 = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.statusHandler.onError((BaseException) e2);
            } else {
                this.statusHandler.onError(new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FINALLY_UNKNOWN, e2));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.needJumpToStart = true;
            Logger.d(TAG, "jump to restart");
            return;
        }
        this.isAlive.set(false);
        if (z3) {
            try {
                AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
                if (downloadEngine != null) {
                    downloadEngine.removeDownloadRunnable(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                IDownloadMonitorDepend monitorDepend = this.downloadTask.getMonitorDepend();
                DownloadInfo downloadInfo = this.downloadInfo;
                BaseException baseException = new BaseException(1014, DownloadUtils.getErrorMsgWithTagPrefix(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.downloadInfo;
                DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void finishWithFileExist() {
        Logger.d(TAG, "finishWithFileExist");
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_END_FOR_FILE_EXIST_ERROR, true)) {
            if (this.existTargetFileName.equals(this.downloadInfo.getName())) {
                this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.runStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.existTargetFileName.equals(this.downloadInfo.getTargetFilePath())) {
            this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.runStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private long getDelayTime() {
        return this.retryDelayTimeCalculator.calculateRetryDelayTime(this.downloadInfo.getCurRetryTimeInTotal(), this.downloadInfo.getTotalRetryCount());
    }

    private List<HttpHeader> getExtraHeaders(DownloadChunk downloadChunk) {
        List<HttpHeader> addRangeHeader = DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), downloadChunk);
        if (this.downloadInfo.isExpiredRedownload() && this.needCheckIfModified && this.downloadInfo.getLastModified() != null) {
            addRangeHeader.add(new HttpHeader(DownloadUtils.IF_MODIFIED_SINCE, this.downloadInfo.getLastModified()));
            addRangeHeader.add(new HttpHeader(DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE, DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE));
            Logger.d(TAG, "dcache::add head IF_MODIFIED_SINCE=" + this.downloadInfo.getLastModified());
        }
        return addRangeHeader;
    }

    private IRetryDelayTimeCalculator getRetryDelayTimeCalculator(DownloadTask downloadTask) {
        IRetryDelayTimeCalculator retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new RetryDelayTimeParamCalculator(retryDelayTimeArray);
            }
        }
        return DownloadComponentManager.getRetryDelayTimeCalculator();
    }

    public void handleDiskSpaceCallback() {
        AbsDownloadEngine downloadEngine;
        if (checkIsStoppedByUser() || (downloadEngine = DownloadComponentManager.getDownloadEngine()) == null) {
            return;
        }
        downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
    }

    private void handleFirstResponse() throws BaseException {
        if (this.firstHttpResponseHandler != null) {
            if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                this.downloadInfo.setStatus(-4);
                this.firstHttpResponseHandler.cancel();
            } else if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                this.firstHttpResponseHandler.handleResponse();
            } else {
                this.downloadInfo.setStatus(-2);
                this.firstHttpResponseHandler.pause();
            }
        }
    }

    public void handleForbiddenCallback(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.downloadInfo.setForbiddenBackupUrls(list, this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
        }
    }

    private void handleResponseCodeError(String str, String str2) throws RetryThrowable {
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.canResumeFromCache = false;
        this.downloadInfo.resetDataForEtagEndure(str);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        throw new RetryThrowable(str2);
    }

    private void handleResponseMultiChunkFromBegin(long j2, int i2) throws BaseException {
        long j3 = j2 / i2;
        int id = this.downloadInfo.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            DownloadChunk build = new DownloadChunk.Builder(id).chunkIndex(i3).startOffset(j4).oldOffset(j4).currentOffset(j4).endOffset(i3 == i2 + (-1) ? 0L : (j4 + j3) - 1).build();
            arrayList.add(build);
            this.downloadCache.addDownloadChunk(build);
            j4 += j3;
            i3++;
        }
        this.downloadInfo.setChunkCount(i2);
        this.downloadCache.updateChunkCount(id, i2);
        handleResponseWithMultiChunk(arrayList, j2);
    }

    private void handleResponseWithMultiChunk(List<DownloadChunk> list, long j2) throws BaseException {
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                long currentOffset = downloadChunk.getEndOffset() == 0 ? j2 - downloadChunk.getCurrentOffset() : (downloadChunk.getEndOffset() - downloadChunk.getCurrentOffset()) + 1;
                if (currentOffset > 0) {
                    downloadChunk.setContentLength(currentOffset);
                    if (!this.downloadInfo.isNeedReuseFirstConnection() || this.firstGetConnection == null || (this.downloadInfo.isHeadConnectionAvailable() && !this.firstHeadConnectionFailed)) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    } else if (downloadChunk.getChunkIndex() == 0) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this.firstGetConnection, this));
                    } else if (downloadChunk.getChunkIndex() > 0) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    }
                }
            }
        }
        if (!DownloadExpSwitchCode.isSwitchEnable(64)) {
            ArrayList arrayList = new ArrayList(this.downloadChunkRunnableList.size());
            Iterator<DownloadChunkRunnable> it = this.downloadChunkRunnableList.iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable next = it.next();
                if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                    next.cancel();
                } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
                    next.pause();
                } else {
                    arrayList.add(Executors.callable(next));
                }
            }
            if (checkIsStoppedByUser()) {
                return;
            }
            try {
                DefaultDownloadEngine.invokeFutureTasks(arrayList);
                return;
            } catch (InterruptedException e2) {
                throw new BaseException(1020, e2);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.downloadChunkRunnableList.size());
        Iterator<DownloadChunkRunnable> it2 = this.downloadChunkRunnableList.iterator();
        while (it2.hasNext()) {
            DownloadChunkRunnable next2 = it2.next();
            if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                next2.cancel();
            } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
                next2.pause();
            } else {
                arrayList2.add(next2);
            }
        }
        try {
            List<Future> executeFutureTasks = DefaultDownloadEngine.executeFutureTasks(arrayList2);
            for (Runnable runnable = (Runnable) arrayList2.remove(0); runnable != null; runnable = DefaultDownloadEngine.getUnstartedTask(executeFutureTasks)) {
                if (checkIsStoppedByUser()) {
                    return;
                }
                try {
                    runnable.run();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (executeFutureTasks == null || executeFutureTasks.isEmpty()) {
                return;
            }
            for (Future future : executeFutureTasks) {
                if (future != null && !future.isDone()) {
                    try {
                        future.get();
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void handleResponseWithMultiChunkFromResume(int i2, List<DownloadChunk> list) throws BaseException {
        if (list.size() != i2) {
            throw new BaseException(DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, new IllegalArgumentException());
        }
        handleResponseWithMultiChunk(list, this.downloadInfo.getTotalBytes());
    }

    private void handleResponseWithSingleChunk(DownloadChunk downloadChunk, String str, IDownloadHttpConnection iDownloadHttpConnection) throws BaseException {
        downloadChunk.setContentLength(this.downloadInfo.getTotalBytes() - downloadChunk.getCurrentOffset());
        this.downloadInfo.setChunkCount(1);
        this.downloadCache.updateChunkCount(this.downloadInfo.getId(), 1);
        this.firstHttpResponseHandler = new DownloadResponseHandler(this.downloadInfo, str, iDownloadHttpConnection, downloadChunk, this);
        handleFirstResponse();
    }

    private boolean handleRetryTime(BaseException baseException) {
        AtomicInteger atomicInteger = this.retainRetryTimes;
        boolean z = true;
        if (atomicInteger == null) {
            onError(new BaseException(DownloadErrorCode.ERROR_RETAIN_RETRY_TIME_IS_NULL, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.downloadInfo.trySwitchToNextBackupUrl()) {
                this.retainRetryTimes.set(this.downloadInfo.getBackUpUrlRetryCount());
                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.downloadInfo.canReplaceHttpForRetry())) {
                    onError(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.retainRetryTimes), String.valueOf(this.downloadInfo.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
                this.downloadInfo.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.runStatus != RunStatus.RUN_STATUS_RETRY_DELAY && z) {
            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
        }
        return false;
    }

    private boolean isAllChunkDownloadComplete() {
        if (this.downloadInfo.getChunkCount() <= 1) {
            return this.downloadInfo.getCurBytes() > 0 && this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes();
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
        if (downloadChunk == null || downloadChunk.size() <= 1) {
            return false;
        }
        for (DownloadChunk downloadChunk2 : downloadChunk) {
            if (downloadChunk2 == null || !downloadChunk2.hasNoBytesDownload()) {
                return false;
            }
        }
        return true;
    }

    private boolean isMultiChunkDownloadAvailable() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.canResumeFromCache || this.downloadInfo.getChunkCount() > 1) && !this.downloadInfo.isChunkDowngradeRetryUsed() && this.acceptPartial && !this.isChunked;
    }

    private boolean isResponseCodeError(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.isResponseFromBegin || this.acceptPartial)) {
            return (i2 == 201 || i2 == 416) && this.downloadInfo.getCurBytes() > 0;
        }
        return true;
    }

    private boolean isStoppedStatus() {
        return this.runStatus == RunStatus.RUN_STATUS_CANCELED || this.runStatus == RunStatus.RUN_STATUS_PAUSE;
    }

    private void resetRetainRetryTimes() {
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RESET_RETAIN_RETRY_TIMES, 0) != 1 || this.resetRetainRetryTimesCount >= 3) {
            return;
        }
        this.retainRetryTimes.set(this.downloadInfo.isBackUpUrlUsed() ? this.downloadInfo.getBackUpUrlRetryCount() : this.downloadInfo.getRetryCount());
        this.resetRetainRetryTimesCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[LOOP:0: B:26:0x0058->B:41:0x0058, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void runInner() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.runInner():void");
    }

    private void startRetryDelayAlarm() {
        this.runStatus = RunStatus.RUN_STATUS_NONE;
    }

    private void updateRetainRetryTimes() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.downloadInfo.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.retainRetryTimes;
        if (atomicInteger == null) {
            this.retainRetryTimes = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean canRetry(BaseException baseException) {
        if (this.segmentDispatcher != null && DownloadUtils.isNetworkError(baseException) && this.retainRetryTimes.get() < this.downloadInfo.getRetryCount()) {
            return false;
        }
        if (DownloadUtils.isResponseCodeError(baseException)) {
            if (this.isSingleChunk && !this.isTriedFixRangeNotSatisfiable) {
                DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
                this.isTriedFixRangeNotSatisfiable = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.retainRetryTimes;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.downloadInfo.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.downloadInfo.canReplaceHttpForRetry()) {
                return false;
            }
        }
        return !(baseException instanceof DownloadRetryNeedlessException);
    }

    public void cancel() {
        RunStatus runStatus = RunStatus.RUN_STATUS_CANCELED;
        this.runStatus = runStatus;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.cancel();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.cancel();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = runStatus;
            endDownloadRunnable();
        }
        cancelAllChunkRunnable();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(4:10|(1:12)|13|(2:15|(4:17|(2:19|(1:21)(2:56|57))(1:58)|22|(8:24|(1:26)|27|28|29|30|31|32))(2:59|(6:61|28|29|30|31|32)(4:62|(1:64)(1:67)|65|66))))(2:69|(4:71|(1:73)(1:76)|74|75)(2:77|(2:79|80)))|68|27|28|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0176, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0178, code lost:
    
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019a, code lost:
    
        if (r5 >= r24) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a6, code lost:
    
        r7.setLength(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01aa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01ac, code lost:
    
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c8, code lost:
    
        if (r4 == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01d0, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01d1, code lost:
    
        if (r4 != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01e2, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO, r0);
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkSpaceOverflow(long r24) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.checkSpaceOverflow(long):void");
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public DownloadTask getDownloadTask() {
        return this.downloadTask;
    }

    public Future getFuture() {
        return this.mFuture;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public synchronized DownloadChunk getUnCompletedSubChunk(int i2) {
        DownloadChunk unCompletedSubChunk;
        if (this.downloadInfo.getChunkCount() < 2) {
            return null;
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
        if (downloadChunk != null && !downloadChunk.isEmpty()) {
            for (int i3 = 0; i3 < downloadChunk.size(); i3++) {
                DownloadChunk downloadChunk2 = downloadChunk.get(i3);
                if (downloadChunk2 != null && (unCompletedSubChunk = getUnCompletedSubChunk(downloadChunk2, i2)) != null) {
                    return unCompletedSubChunk;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0274, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x027e, code lost:
    
        if (r19.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_GET_TOTAL_BYTES, true) == false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0280, code lost:
    
        r7 = com.ss.android.socialbase.downloader.utils.DownloadUtils.parseContentRangeOfInstanceLength(r2);
        com.ss.android.socialbase.downloader.logger.Logger.i(r14, "firstConnection: 1 totalLength = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0299, code lost:
    
        r7 = r22 + r12;
        com.ss.android.socialbase.downloader.logger.Logger.e(r14, "firstConnection: 2 totalLength = " + r7 + ", contentLength = " + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x013b, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(r19.downloadInfo);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0256, code lost:
    
        r2 = com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(r10, "Content-Range");
        com.ss.android.socialbase.downloader.logger.Logger.i(r14, "firstConnection: contentRange = " + r2);
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleFirstConnection(java.lang.String r20, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r21, long r22) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        /*
            Method dump skipped, instructions count: 805
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.handleFirstConnection(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, long):void");
    }

    public boolean isAlive() {
        return this.isAlive.get();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onAllChunkRetryWithReset(BaseException baseException, boolean z) {
        Logger.d(TAG, "onAllChunkRetryWithReset");
        this.runStatus = RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.errorException = baseException;
        cancelAllChunkRunnable();
        if (z ? handleRetryTime(baseException) : false) {
            return;
        }
        clearCurrentDownloadData();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onChunkDowngradeRetry(BaseException baseException) {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        onAllChunkRetryWithReset(baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onCompleted(DownloadChunkRunnable downloadChunkRunnable) {
        if (this.isSingleChunk) {
            return;
        }
        synchronized (this) {
            this.downloadChunkRunnableList.remove(downloadChunkRunnable);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onError(BaseException baseException) {
        Logger.d(TAG, "onError:" + baseException.getMessage());
        this.runStatus = RunStatus.RUN_STATUS_ERROR;
        this.errorException = baseException;
        cancelAllChunkRunnable();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long j2) throws BaseException {
        if (this.curBytesNeedCheckSpaceOverFlow > 0 && this.downloadInfo.getCurBytes() > this.curBytesNeedCheckSpaceOverFlow) {
            checkSpaceOverflowInProgress();
        }
        return this.statusHandler.onProgress(j2);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public RetryCheckStatus onRetry(BaseException baseException, long j2) {
        long totalBytes;
        long j3;
        boolean z;
        this.errorException = baseException;
        this.downloadInfo.increaseCurBytes(-j2);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (isStoppedStatus()) {
            return RetryCheckStatus.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.forbiddenHandler != null && !this.downloadInfo.isForbiddenRetryed()) {
                AnonymousClass1 anonymousClass1 = new AbsDownloadForbiddenCallback() { // from class: com.ss.android.socialbase.downloader.thread.DownloadRunnable.1
                    AnonymousClass1() {
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback, com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
                    public void onCallback(List<String> list) {
                        super.onCallback(list);
                        DownloadRunnable.this.handleForbiddenCallback(list);
                    }
                };
                boolean onForbidden = this.forbiddenHandler.onForbidden(anonymousClass1);
                this.downloadInfo.setForbiddenRetryed();
                if (onForbidden) {
                    if (!anonymousClass1.hasCallback()) {
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                        this.runStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return RetryCheckStatus.RETURN;
                    }
                    z = true;
                }
            } else if (handleRetryTime(baseException)) {
                return RetryCheckStatus.RETURN;
            }
            z = false;
        } else if (!DownloadUtils.isInsufficientSpaceError(baseException)) {
            if (handleRetryTime(baseException)) {
                return RetryCheckStatus.RETURN;
            }
            z = false;
        } else {
            if (this.diskSpaceHandler == null) {
                onError(baseException);
                return RetryCheckStatus.RETURN;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            AnonymousClass2 anonymousClass2 = new IDownloadDiskSpaceCallback() { // from class: com.ss.android.socialbase.downloader.thread.DownloadRunnable.2
                final /* synthetic */ AtomicBoolean val$diskCleaned;

                AnonymousClass2(AtomicBoolean atomicBoolean2) {
                    atomicBoolean = atomicBoolean2;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
                public void onDiskCleaned() {
                    synchronized (DownloadRunnable.this) {
                        atomicBoolean.set(true);
                        DownloadRunnable.this.handleDiskSpaceCallback();
                    }
                }
            };
            if (baseException instanceof DownloadOutOfSpaceException) {
                DownloadOutOfSpaceException downloadOutOfSpaceException = (DownloadOutOfSpaceException) baseException;
                j3 = downloadOutOfSpaceException.getAvaliableSpaceBytes();
                totalBytes = downloadOutOfSpaceException.getRequiredSpaceBytes();
            } else {
                totalBytes = this.downloadInfo.getTotalBytes();
                j3 = -1;
            }
            synchronized (this) {
                if (!this.diskSpaceHandler.cleanUpDisk(j3, totalBytes, anonymousClass2)) {
                    if (this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return RetryCheckStatus.RETURN;
                    }
                    onError(baseException);
                    return RetryCheckStatus.RETURN;
                }
                if (!DownloadSetting.obtain(this.downloadInfo.getId()).optBugFix(DownloadSettingKeys.BugFix.NOT_DELETE_WHEN_CLEAN_SPACE, false)) {
                    checkCompletedByteValid();
                }
                if (!atomicBoolean2.get()) {
                    RunStatus runStatus = this.runStatus;
                    RunStatus runStatus2 = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                    if (runStatus != runStatus2) {
                        this.runStatus = runStatus2;
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                    }
                    return RetryCheckStatus.RETURN;
                }
                if (handleRetryTime(baseException)) {
                    return RetryCheckStatus.RETURN;
                }
                z = true;
            }
        }
        if (!z && checkNeedRetryDelay()) {
            cancelAllChunkRunnable();
        }
        DownloadStatusHandler downloadStatusHandler = this.statusHandler;
        RunStatus runStatus3 = this.runStatus;
        RunStatus runStatus4 = RunStatus.RUN_STATUS_RETRY_DELAY;
        downloadStatusHandler.onRetry(baseException, runStatus3 == runStatus4);
        return this.runStatus == runStatus4 ? RetryCheckStatus.RETURN : RetryCheckStatus.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public RetryCheckStatus onSingleChunkRetry(DownloadChunk downloadChunk, BaseException baseException, long j2) {
        if (isStoppedStatus()) {
            return RetryCheckStatus.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || DownloadUtils.isInsufficientSpaceError(baseException))) {
            return onRetry(baseException, j2);
        }
        this.errorException = baseException;
        this.downloadInfo.increaseCurBytes(-j2);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (handleRetryTime(baseException)) {
            return RetryCheckStatus.RETURN;
        }
        DownloadStatusHandler downloadStatusHandler = this.statusHandler;
        RunStatus runStatus = this.runStatus;
        RunStatus runStatus2 = RunStatus.RUN_STATUS_RETRY_DELAY;
        downloadStatusHandler.onSingleChunkRetry(downloadChunk, baseException, runStatus == runStatus2);
        if (this.runStatus != runStatus2 && this.downloadInfo.isNeedRetryDelay()) {
            long delayTime = getDelayTime();
            if (delayTime > 0) {
                Logger.i(TAG, "onSingleChunkRetry with delay time " + delayTime);
                try {
                    Thread.sleep(delayTime);
                } catch (Throwable th) {
                    Logger.w(TAG, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return RetryCheckStatus.CONTINUE;
    }

    public void pause() {
        RunStatus runStatus = RunStatus.RUN_STATUS_PAUSE;
        this.runStatus = runStatus;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.pause();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.pause();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = runStatus;
            endDownloadRunnable();
        }
        try {
            Iterator it = ((ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable downloadChunkRunnable = (DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.pause();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void prepareDownload() {
        this.prepareDownloadTime = System.currentTimeMillis();
        this.statusHandler.onPrepare();
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadComponentManager.onDownloadTaskStart(this.downloadTask, 3);
        try {
            DeviceBandwidthSampler.getInstance().startSampling();
            runInner();
            DeviceBandwidthSampler.getInstance().stopSampling();
            DownloadComponentManager.onDownloadTaskFinish(this.downloadTask, 3);
        } catch (Throwable th) {
            DeviceBandwidthSampler.getInstance().stopSampling();
            throw th;
        }
    }

    public void setFuture(Future future) {
        this.mFuture = future;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1a
            int r2 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.downloadInfo     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusCode(r2)     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.downloadInfo     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = com.ss.android.socialbase.downloader.utils.DownloadHttpUtils.httpCodeToMessage(r2)     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusMessage(r2)     // Catch: java.lang.Throwable -> L16
            r2 = 1
            goto L1b
        L16:
            r2 = move-exception
            r2.printStackTrace()
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L2a
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.downloadInfo
            r0 = -1
            r2.setHttpStatusCode(r0)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.downloadInfo
            java.lang.String r0 = ""
            r2.setHttpStatusMessage(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection):void");
    }

    public void setThrottleNetSpeed(long j2) {
        IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null && (iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
            try {
                ((AbsDownloadHttpConnection) iDownloadHttpConnection).setThrottleNetSpeedWhenRunning(j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x006c, code lost:
    
        if (r9.hasChunkDivided() != false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.DownloadChunk getUnCompletedSubChunk(com.ss.android.socialbase.downloader.model.DownloadChunk r9, int r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.getUnCompletedSubChunk(com.ss.android.socialbase.downloader.model.DownloadChunk, int):com.ss.android.socialbase.downloader.model.DownloadChunk");
    }
}
