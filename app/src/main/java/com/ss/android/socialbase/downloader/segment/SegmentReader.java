package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.umeng.analytics.pro.bd;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;
    private final List<Segment> succeedSegments = new ArrayList();
    private volatile long curSegmentReadOffset = -1;

    public SegmentReader(DownloadInfo downloadInfo, SegmentDispatcher segmentDispatcher, IBufferPool iBufferPool, UrlRecord urlRecord, int i10) {
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i10;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException baseException) {
        if (!DownloadUtils.isHttpsError(baseException)) {
            return false;
        }
        String str = this.urlRecord.url;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
            return false;
        }
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            try {
                Logger.i(TAG, "closeConnection: thread = " + this.threadIndex);
                iDownloadHttpConnection.end();
                iDownloadHttpConnection.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    private void createConnection(Segment segment) throws BaseException {
        String str;
        String str2;
        IDownloadHttpConnection downloadWithConnection;
        try {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.connectEndTime = 0L;
                    this.connectStartTime = currentTimeMillis;
                    this.startOffsetInConnection = segment.getCurrentOffsetRead();
                    this.endOffsetInConnection = segment.getEndOffset();
                    if (this.endOffsetInConnection > 0 && this.startOffsetInConnection > this.endOffsetInConnection) {
                        throw new SegmentApplyException(6, "createConn, " + segment);
                    }
                    this.stenographer = new DownloadStenographer();
                    List<HttpHeader> addRangeHeader = DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);
                    addRangeHeader.add(new HttpHeader("Segment-Index", String.valueOf(segment.getIndex())));
                    addRangeHeader.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));
                    DownloadUtils.addThrottleNetSpeed(addRangeHeader, this.downloadInfo);
                    DownloadUtils.addTTNetProtectTimeout(addRangeHeader, this.downloadInfo);
                    str = this.urlRecord.url;
                    if (this.httpsToHttpRetryUsed && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                        str = str.replaceFirst("https", "http");
                    }
                    str2 = this.urlRecord.ip;
                    Logger.i(TAG, "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                    this.curUrl = str;
                    this.curHostIp = str2;
                    downloadWithConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, str2, addRangeHeader, 0, currentTimeMillis - this.lastConnectStartTime > 3000 && this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0, this.downloadInfo);
                } catch (Throwable th2) {
                    DownloadUtils.parseException(th2, "createConn");
                }
                if (downloadWithConnection == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.httpConnection = downloadWithConnection;
                this.httpResponse = new HttpResponse(str, downloadWithConnection);
                if (this.closed) {
                    throw new StreamClosedException("createConn");
                }
                if (downloadWithConnection instanceof AbsDownloadHttpConnection) {
                    this.curHostRealIp = ((AbsDownloadHttpConnection) downloadWithConnection).getHostIp();
                }
                Log.i(TAG, "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex);
                this.connectEndTime = System.currentTimeMillis();
            } catch (BaseException e10) {
                throw e10;
            }
        } catch (Throwable th3) {
            this.connectEndTime = System.currentTimeMillis();
            throw th3;
        }
    }

    private void doConnect(Segment segment) throws BaseException, RetryThrowable {
        createConnection(segment);
        this.host.onSegmentConnected(this, segment, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    private boolean download(Segment segment) throws BaseException {
        initParams();
        while (true) {
            try {
                doConnect(segment);
                loopAndRead(segment);
                releaseDownload();
                return true;
            } catch (SegmentApplyException e10) {
                this.failedException = e10;
                throw e10;
            } catch (Throwable th2) {
                try {
                    Logger.e(TAG, "download: e = " + th2 + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        releaseDownload();
                        return false;
                    }
                    if (this.reconnect) {
                        this.reconnect = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new SegmentApplyException(5, "download");
                        }
                    } else {
                        th2.printStackTrace();
                        if (th2 instanceof BaseException) {
                            e = th2;
                        } else {
                            try {
                                DownloadUtils.parseException(th2, "download");
                                e = null;
                            } catch (BaseException e11) {
                                e = e11;
                            }
                        }
                        if (e == null || !handleFailedAndCheckRetry(segment, e)) {
                            releaseDownload();
                            return false;
                        }
                    }
                    releaseDownload();
                } catch (Throwable th4) {
                    releaseDownload();
                    throw th4;
                }
            }
        }
    }

    private boolean handleFailedAndCheckRetry(Segment segment, BaseException baseException) {
        Logger.e(TAG, "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount);
        int i10 = this.curRetryCount;
        if (i10 < this.retryCount) {
            this.curRetryCount = i10 + 1;
            return true;
        }
        if (checkCanUseHttpsToHttpRetry(baseException)) {
            return true;
        }
        this.host.onSegmentFailed(this, this.urlRecord, segment, baseException);
        return false;
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:206:0x0159
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03ea  */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private Buffer probeFirstBuffer(IBufferPool iBufferPool, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i10;
        Buffer obtain = iBufferPool.obtain();
        try {
            i10 = inputStream.read(obtain.data);
            try {
                if (i10 == -1) {
                    throw new BaseException(DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, bd.f23539s);
                }
                obtain.size = i10;
                if (i10 == -1) {
                    iBufferPool.recycle(obtain);
                }
                return obtain;
            } catch (Throwable th2) {
                th = th2;
                if (i10 == -1) {
                    iBufferPool.recycle(obtain);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            i10 = -1;
        }
    }

    private long refreshSegmentEndOffset() {
        long j10 = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        if (j10 <= 0) {
            return Long.MAX_VALUE;
        }
        return j10;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1L;
        this.connectEndTime = -1L;
        this.readStartTime = -1L;
        this.readEndTime = -1L;
        closeConnection();
    }

    private void resetRetryTimes() {
        this.retryCount = this.urlRecord.isMainUrl ? this.downloadInfo.getRetryCount() : this.downloadInfo.getBackUpUrlRetryCount();
        this.curRetryCount = 0;
    }

    public boolean adjustSegmentEndOffset(long j10) {
        long j11 = this.endOffsetInConnection;
        if (j10 <= 0 && j11 > 0) {
            return false;
        }
        if (j10 > j11 && j11 > 0) {
            return false;
        }
        this.segmentNewEndOffset = j10;
        this.threadDirty = true;
        return true;
    }

    public void close() {
        Logger.i(TAG, "close: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.closed = true;
            this.threadDirty = true;
        }
        closeConnection();
        Future future = this.future;
        if (future != null) {
            this.future = null;
            try {
                future.cancel(true);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public int getCurRetryCount() {
        return this.curRetryCount;
    }

    public long getCurSegmentDownloadSpeed(long j10) {
        long j11 = this.readStartTime;
        if (j11 <= 0) {
            return -1L;
        }
        long j12 = j10 - j11;
        if (j12 <= 0) {
            return -1L;
        }
        long j13 = this.curSegmentReadOffset;
        long j14 = this.startOffsetInConnection;
        if (j14 < 0 || j13 < j14) {
            return 0L;
        }
        return (j13 - j14) / j12;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public long getReadBytes() {
        long readingBytes;
        synchronized (this.host) {
            readingBytes = this.readBytes + getReadingBytes();
        }
        return readingBytes;
    }

    public long getReadingBytes() {
        synchronized (this.host) {
            try {
                long j10 = this.curSegmentReadOffset;
                long j11 = this.startOffsetInConnection;
                if (j11 < 0 || j10 <= j11) {
                    return 0L;
                }
                return j10 - j11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long getRecentDownloadSpeed(long j10, long j11) {
        DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j10, j11);
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    public boolean isFailed() {
        return this.failed;
    }

    public void markProgress(long j10) {
        long j11 = this.curSegmentReadOffset;
        DownloadStenographer downloadStenographer = this.stenographer;
        if (j11 < 0 || downloadStenographer == null) {
            return;
        }
        Log.i(TAG, "markProgress: curSegmentReadOffset = " + j11 + ", threadIndex = " + this.threadIndex);
        downloadStenographer.markProgress(j11, j10);
    }

    public void reconnect() {
        reconnect(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        ISegmentCallback iSegmentCallback;
        Segment obtainSegment;
        ISegmentCallback iSegmentCallback2;
        ISegmentCallback iSegmentCallback3;
        Process.setThreadPriority(10);
        try {
            try {
                this.thread = Thread.currentThread();
                this.host.onReaderRun(this);
                this.urlRecord.recordUse(this);
                while (true) {
                    obtainSegment = this.host.obtainSegment(this, this.urlRecord);
                    if (obtainSegment == null) {
                        Logger.i(TAG, "no more segment, thread_index = " + this.threadIndex);
                        break;
                    }
                    this.curSegment = obtainSegment;
                    try {
                        try {
                        } catch (SegmentApplyException e10) {
                            Logger.e(TAG, "run: SegmentApplyException, e = " + e10);
                            int i10 = this.segmentApplyRetryTimes;
                            if (i10 >= 50) {
                                Logger.e(TAG, "segment apply failed " + this.segmentApplyRetryTimes + "times, thread_index = " + this.threadIndex);
                                this.curSegment = null;
                                iSegmentCallback2 = this.host;
                                break;
                            }
                            this.segmentApplyRetryTimes = i10 + 1;
                            this.curSegment = null;
                            iSegmentCallback3 = this.host;
                        }
                        if (!download(obtainSegment)) {
                            if (!this.closed) {
                                Logger.e(TAG, "download segment failed, segment = " + obtainSegment + ", thread_index = " + this.threadIndex + ", failedException = " + this.failedException);
                                break;
                            }
                            break;
                        }
                        this.succeedSegments.add(obtainSegment);
                        this.curSegment = null;
                        iSegmentCallback3 = this.host;
                        iSegmentCallback3.unObtainSegment(this, obtainSegment);
                    } catch (Throwable th2) {
                        this.curSegment = null;
                        this.host.unObtainSegment(this, obtainSegment);
                        throw th2;
                    }
                }
                this.curSegment = null;
                iSegmentCallback2 = this.host;
                iSegmentCallback2.unObtainSegment(this, obtainSegment);
                this.urlRecord.recordUnUse(this);
                iSegmentCallback = this.host;
            } catch (Throwable th3) {
                try {
                    th3.printStackTrace();
                    this.urlRecord.recordUnUse(this);
                    iSegmentCallback = this.host;
                } catch (Throwable th4) {
                    try {
                        this.urlRecord.recordUnUse(this);
                        this.host.onReaderExit(this);
                    } catch (Throwable unused) {
                    }
                    this.thread = null;
                    throw th4;
                }
            }
            iSegmentCallback.onReaderExit(this);
        } catch (Throwable unused2) {
        }
        this.thread = null;
    }

    public void setExited(boolean z10) {
        this.exited = z10;
    }

    public void setFailed(boolean z10) {
        this.failed = z10;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public boolean switchUrlRecord(UrlRecord urlRecord) {
        int i10 = this.switchUrlTimes;
        if (i10 >= 30) {
            return false;
        }
        this.switchUrlTimes = i10 + 1;
        UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    public void updateReadBytes() {
        UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                try {
                    long readingBytes = getReadingBytes();
                    if (readingBytes > 0) {
                        this.readBytes += readingBytes;
                        urlRecord.increaseDownloadBytes(readingBytes);
                    }
                    this.curSegmentReadOffset = -1L;
                } finally {
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void reconnect(boolean z10) {
        Logger.i(TAG, "reconnect: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.changeSegment = z10;
            this.reconnect = true;
            this.threadDirty = true;
        }
        closeConnection();
        Thread thread = this.thread;
        if (thread != null) {
            try {
                Log.i(TAG, "reconnect: t.interrupt threadIndex = " + this.threadIndex);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }
}
