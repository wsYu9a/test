package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import android.util.Log;
import b.b.a.b.b;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.http.HttpHost;

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

    SegmentReader(DownloadInfo downloadInfo, SegmentDispatcher segmentDispatcher, IBufferPool iBufferPool, UrlRecord urlRecord, int i2) {
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i2;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException baseException) {
        if (!DownloadUtils.isHttpsError(baseException)) {
            return false;
        }
        String str = this.urlRecord.url;
        if (TextUtils.isEmpty(str) || !str.startsWith(b.f4198a) || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
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
                if (this.httpsToHttpRetryUsed && !TextUtils.isEmpty(str) && str.startsWith(b.f4198a)) {
                    str = str.replaceFirst(b.f4198a, HttpHost.DEFAULT_SCHEME_NAME);
                }
                str2 = this.urlRecord.ip;
                Logger.i(TAG, "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                this.curUrl = str;
                this.curHostIp = str2;
                downloadWithConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, str2, addRangeHeader, 0, currentTimeMillis - this.lastConnectStartTime > 3000 && this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0, this.downloadInfo);
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                DownloadUtils.parseException(th, "createConn");
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
        } finally {
            this.connectEndTime = System.currentTimeMillis();
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
                return true;
            } catch (SegmentApplyException e2) {
                this.failedException = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    Logger.e(TAG, "download: e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        return false;
                    }
                    if (this.reconnect) {
                        this.reconnect = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new SegmentApplyException(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                DownloadUtils.parseException(th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !handleFailedAndCheckRetry(segment, e3)) {
                            return false;
                        }
                    }
                } finally {
                    releaseDownload();
                }
            }
        }
        return false;
    }

    private boolean handleFailedAndCheckRetry(Segment segment, BaseException baseException) {
        Logger.e(TAG, "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount);
        int i2 = this.curRetryCount;
        if (i2 < this.retryCount) {
            this.curRetryCount = i2 + 1;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:180:0x015b
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:236:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private Buffer probeFirstBuffer(IBufferPool iBufferPool, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i2;
        Buffer obtain = iBufferPool.obtain();
        try {
            i2 = inputStream.read(obtain.data);
            try {
                if (i2 == -1) {
                    throw new BaseException(DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, "probe");
                }
                obtain.size = i2;
                if (i2 == -1) {
                    iBufferPool.recycle(obtain);
                }
                return obtain;
            } catch (Throwable th) {
                th = th;
                if (i2 == -1) {
                    iBufferPool.recycle(obtain);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = -1;
        }
    }

    private long refreshSegmentEndOffset() {
        long j2 = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        if (j2 <= 0) {
            return Long.MAX_VALUE;
        }
        return j2;
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

    public boolean adjustSegmentEndOffset(long j2) {
        long j3 = this.endOffsetInConnection;
        if (j2 <= 0 && j3 > 0) {
            return false;
        }
        if (j2 > j3 && j3 > 0) {
            return false;
        }
        this.segmentNewEndOffset = j2;
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
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    int getCurRetryCount() {
        return this.curRetryCount;
    }

    long getCurSegmentDownloadSpeed(long j2) {
        long j3 = this.readStartTime;
        if (j3 <= 0) {
            return -1L;
        }
        long j4 = j2 - j3;
        if (j4 <= 0) {
            return -1L;
        }
        long j5 = this.curSegmentReadOffset;
        long j6 = this.startOffsetInConnection;
        if (j6 < 0 || j5 < j6) {
            return 0L;
        }
        return (j5 - j6) / j4;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    BaseException getFailedException() {
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
            long j2 = this.curSegmentReadOffset;
            long j3 = this.startOffsetInConnection;
            if (j3 < 0 || j2 <= j3) {
                return 0L;
            }
            return j2 - j3;
        }
    }

    long getRecentDownloadSpeed(long j2, long j3) {
        DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j2, j3);
    }

    int getRetryCount() {
        return this.retryCount;
    }

    long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    boolean isFailed() {
        return this.failed;
    }

    void markProgress(long j2) {
        long j3 = this.curSegmentReadOffset;
        DownloadStenographer downloadStenographer = this.stenographer;
        if (j3 < 0 || downloadStenographer == null) {
            return;
        }
        Log.i(TAG, "markProgress: curSegmentReadOffset = " + j3 + ", threadIndex = " + this.threadIndex);
        downloadStenographer.markProgress(j3, j2);
    }

    public void reconnect() {
        reconnect(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r6.curSegment = null;
        r2 = r6.host;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.run():void");
    }

    public void setExited(boolean z) {
        this.exited = z;
    }

    void setFailed(boolean z) {
        this.failed = z;
    }

    void setFuture(Future future) {
        this.future = future;
    }

    boolean switchUrlRecord(UrlRecord urlRecord) {
        int i2 = this.switchUrlTimes;
        if (i2 >= 30) {
            return false;
        }
        this.switchUrlTimes = i2 + 1;
        UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    void updateReadBytes() {
        UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                long readingBytes = getReadingBytes();
                if (readingBytes > 0) {
                    this.readBytes += readingBytes;
                    urlRecord.increaseDownloadBytes(readingBytes);
                }
                this.curSegmentReadOffset = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void reconnect(boolean z) {
        Logger.i(TAG, "reconnect: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.changeSegment = z;
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
