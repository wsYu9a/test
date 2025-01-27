package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.common.y;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DownloadDnsManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class SegmentDispatcher implements DownloadDnsManager.Callback, ISegmentCallback {
    private static final int READ_WATCH_TIME = 2000;
    private static final String TAG = "SegmentDispatcher";
    private final BufferQueue bufferQueue;
    private long connectTimeout;
    private final boolean debug;
    private final DownloadInfo downloadInfo;
    private BaseException failedException;
    private HttpResponse firstBackupUrlHttpResponse;
    private final IDownloadRunnableCallback hostCallback;
    private volatile boolean isAllContentDownloaded;
    private long lastReconnectTime;
    private HttpResponse mainUrlHttpResponse;
    private float poorSpeedRatio;
    private long readTimeout;
    private int reconnectCount;
    private final DownloadStenographer stenographer;
    private final SegmentStrategy strategy;
    private long totalLength;
    private int urlIndex;
    private final DownloadWatchDog watchDog;
    private final MultiSegmentWriter writer;
    private volatile boolean canceled = false;
    private volatile boolean paused = false;
    private final List<SegmentReader> readers = new ArrayList();
    private final List<UrlRecord> urlRecords = new ArrayList();
    private volatile boolean needWaitDnsResolve = true;
    private final LinkedList<Segment> toDispatchSegments = new LinkedList<>();
    private final List<Segment> dispatchedSegments = new ArrayList();
    private final Object firstConnectionLock = new Object();
    private volatile boolean allReaderFailed = false;
    private final DownloadWatchDog.IWatcher connectWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.1
        private int watchTimes;

        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            if (SegmentDispatcher.this.canceled || SegmentDispatcher.this.paused) {
                return -1L;
            }
            synchronized (SegmentDispatcher.this) {
                try {
                    if (SegmentDispatcher.this.mainUrlHttpResponse == null && SegmentDispatcher.this.firstBackupUrlHttpResponse == null) {
                        long j10 = SegmentDispatcher.this.connectTimeout;
                        if (j10 <= 0) {
                            return -1L;
                        }
                        this.watchTimes++;
                        SegmentReader findEarliestConnectTimeoutReader = SegmentDispatcher.this.findEarliestConnectTimeoutReader(false, System.currentTimeMillis(), j10);
                        if (findEarliestConnectTimeoutReader == null) {
                            return j10;
                        }
                        Log.i(SegmentDispatcher.TAG, "connectWatcher: switchUrl and reconnect");
                        SegmentDispatcher.this.trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
                        findEarliestConnectTimeoutReader.reconnect();
                        return ((this.watchTimes / SegmentDispatcher.this.urlRecords.size()) + 1) * j10;
                    }
                    return -1L;
                } finally {
                }
            }
        }
    };
    private final DownloadWatchDog.IWatcher readWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.2
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            return SegmentDispatcher.this.scheduleWatchRead();
        }
    };

    /* renamed from: com.ss.android.socialbase.downloader.segment.SegmentDispatcher$1 */
    public class AnonymousClass1 implements DownloadWatchDog.IWatcher {
        private int watchTimes;

        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            if (SegmentDispatcher.this.canceled || SegmentDispatcher.this.paused) {
                return -1L;
            }
            synchronized (SegmentDispatcher.this) {
                try {
                    if (SegmentDispatcher.this.mainUrlHttpResponse == null && SegmentDispatcher.this.firstBackupUrlHttpResponse == null) {
                        long j10 = SegmentDispatcher.this.connectTimeout;
                        if (j10 <= 0) {
                            return -1L;
                        }
                        this.watchTimes++;
                        SegmentReader findEarliestConnectTimeoutReader = SegmentDispatcher.this.findEarliestConnectTimeoutReader(false, System.currentTimeMillis(), j10);
                        if (findEarliestConnectTimeoutReader == null) {
                            return j10;
                        }
                        Log.i(SegmentDispatcher.TAG, "connectWatcher: switchUrl and reconnect");
                        SegmentDispatcher.this.trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
                        findEarliestConnectTimeoutReader.reconnect();
                        return ((this.watchTimes / SegmentDispatcher.this.urlRecords.size()) + 1) * j10;
                    }
                    return -1L;
                } finally {
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.segment.SegmentDispatcher$2 */
    public class AnonymousClass2 implements DownloadWatchDog.IWatcher {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            return SegmentDispatcher.this.scheduleWatchRead();
        }
    }

    public SegmentDispatcher(@NonNull DownloadInfo downloadInfo, @NonNull SegmentStrategy segmentStrategy, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.strategy = segmentStrategy;
        BufferQueue bufferQueue = new BufferQueue(segmentStrategy.getBufferCount(), segmentStrategy.getBufferSize());
        this.bufferQueue = bufferQueue;
        this.hostCallback = iDownloadRunnableCallback;
        this.writer = new MultiSegmentWriter(downloadInfo, iDownloadRunnableCallback, bufferQueue);
        this.watchDog = new DownloadWatchDog();
        this.stenographer = new DownloadStenographer();
        this.debug = DownloadSetting.obtain(downloadInfo.getId()).optInt("debug") == 1;
    }

    private void addIpListLocked(String str, List<UrlRecord> list) {
        int indexOfUrl;
        if (this.debug) {
            Iterator<UrlRecord> it = list.iterator();
            while (it.hasNext()) {
                Log.i(TAG, "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int ipStrategy = this.strategy.getIpStrategy();
        if ((ipStrategy == 1 || ipStrategy == 3) && (indexOfUrl = indexOfUrl(str)) >= 0 && indexOfUrl < this.urlRecords.size()) {
            this.urlRecords.addAll(indexOfUrl + 1, list);
        } else {
            this.urlRecords.addAll(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if ((r10.getCurrentOffsetRead() - r25.getCurrentOffsetRead()) < (r13 / 2)) goto L135;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader r24, com.ss.android.socialbase.downloader.segment.Segment r25) throws com.ss.android.socialbase.downloader.segment.SegmentApplyException {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader, com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private void arrangeSegmentLocked(List<Segment> list, Segment segment, boolean z10) {
        long startOffset = segment.getStartOffset();
        int size = list.size();
        int i10 = 0;
        while (i10 < size && startOffset >= list.get(i10).getStartOffset()) {
            i10++;
        }
        list.add(i10, segment);
        if (z10) {
            segment.setIndex(size);
        }
    }

    private List<UrlRecord> assembleIpAddress(String str, List<InetAddress> list) {
        boolean z10;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.debug) {
                            Log.i(TAG, "onDnsResolved: ip = " + hostAddress);
                        }
                        UrlRecord urlRecord = new UrlRecord(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(urlRecord.ipFamily);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(urlRecord.ipFamily, linkedList);
                        }
                        linkedList.add(urlRecord);
                        i10++;
                    }
                }
            }
            if (i10 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z10 = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((UrlRecord) linkedList2.pollFirst());
                            i10--;
                            z10 = true;
                        }
                    }
                    if (i10 <= 0) {
                        break;
                    }
                } while (z10);
                return arrayList;
            }
        }
        return null;
    }

    private void checkDownloadedBytesLocked(List<Segment> list) {
        long downloadedBytes = SegmentUtils.getDownloadedBytes(list);
        Logger.i(TAG, "checkDownloadBytes: getCurBytes = " + this.downloadInfo.getCurBytes() + ", totalBytes = " + this.downloadInfo.getTotalBytes() + ", downloadedBytes = " + downloadedBytes);
        if (downloadedBytes > this.downloadInfo.getTotalBytes() && this.downloadInfo.getTotalBytes() > 0) {
            downloadedBytes = this.downloadInfo.getTotalBytes();
        }
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes() || this.downloadInfo.getCurBytes() == downloadedBytes) {
            return;
        }
        this.downloadInfo.setCurBytes(downloadedBytes);
    }

    private void checkSegmentHttpResponseLocked(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException, RetryThrowable {
        SegmentReader segmentReader2 = segment.owner;
        if (segmentReader2 != null && segmentReader2 != segmentReader) {
            throw new SegmentApplyException(1, "segment already has an owner");
        }
        if (segmentReader.getStartOffsetInConnection() != segment.getCurrentOffsetRead()) {
            throw new SegmentApplyException(5, "applySegment");
        }
        if (!httpResponse.acceptPartial()) {
            if (segment.getCurrentOffsetRead() > 0) {
                throw new DownloadHttpException(1004, httpResponse.responseCode, "1: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
            Logger.e(TAG, "parseHttpResponse: segment.getCurrentOffsetRead = " + segment.getCurrentOffsetRead());
            if (!httpResponse.isResponseDataFromBegin()) {
                throw new DownloadHttpException(1004, httpResponse.responseCode, "2: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
        }
        if (!urlRecord.isMainUrl) {
            validateHttpResponse(httpResponse);
            if (this.firstBackupUrlHttpResponse == null) {
                this.firstBackupUrlHttpResponse = httpResponse;
                if (this.downloadInfo.getTotalBytes() <= 0) {
                    long totalLength = httpResponse.getTotalLength();
                    Logger.i(TAG, "checkSegmentHttpResponse:len=" + totalLength + ",url=" + urlRecord.url);
                    this.downloadInfo.setTotalBytes(totalLength);
                }
                synchronized (this.firstConnectionLock) {
                    this.firstConnectionLock.notify();
                }
                return;
            }
            return;
        }
        if (this.mainUrlHttpResponse == null) {
            this.mainUrlHttpResponse = httpResponse;
            synchronized (this.firstConnectionLock) {
                this.firstConnectionLock.notify();
            }
            IDownloadRunnableCallback iDownloadRunnableCallback = this.hostCallback;
            if (iDownloadRunnableCallback != null) {
                iDownloadRunnableCallback.handleFirstConnection(urlRecord.url, httpResponse.connection, segment.getCurrentOffsetRead());
            }
            long totalLength2 = httpResponse.getTotalLength();
            if (totalLength2 > 0) {
                for (Segment segment2 : this.dispatchedSegments) {
                    if (segment2.getEndOffset() <= 0 || segment2.getEndOffset() > totalLength2 - 1) {
                        segment2.setEndOffset(totalLength2 - 1);
                    }
                }
            }
        }
    }

    private void clearCoveredSegmentLocked() {
        int size;
        if (this.totalLength > 0 && (size = this.dispatchedSegments.size()) > 1) {
            ArrayList<Segment> arrayList = null;
            int i10 = 0;
            for (int i11 = 1; i11 < size; i11++) {
                Segment segment = this.dispatchedSegments.get(i10);
                Segment segment2 = this.dispatchedSegments.get(i11);
                if (segment.getCurrentOffsetRead() > segment2.getStartOffset() && segment2.getDownloadBytes() <= 0 && segment2.owner == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(segment2);
                    if (this.debug) {
                        Log.w(TAG, "clearCovered, covered = " + segment2 + ", prev = " + segment);
                    }
                } else if (segment2.getCurrentOffsetRead() > segment.getCurrentOffsetRead()) {
                    i10++;
                }
            }
            if (arrayList != null) {
                for (Segment segment3 : arrayList) {
                    this.dispatchedSegments.remove(segment3);
                    for (SegmentReader segmentReader : this.readers) {
                        if (segmentReader.curSegment == segment3) {
                            if (this.debug) {
                                Log.w(TAG, "clearCoveredSegmentLocked: reconnect, segment = " + segment3 + ", threadIndex = " + segmentReader.threadIndex);
                            }
                            segmentReader.reconnect(true);
                        }
                    }
                }
            }
        }
    }

    private void dispatchReadThread() {
        int i10;
        if (this.totalLength <= 0 || this.needWaitDnsResolve) {
            i10 = 1;
        } else {
            i10 = this.strategy.getThreadCount();
            int segmentMinInitSize = (int) (this.totalLength / this.strategy.getSegmentMinInitSize());
            if (i10 > segmentMinInitSize) {
                i10 = segmentMinInitSize;
            }
        }
        Logger.i(TAG, "dispatchReadThread: totalLength = " + this.totalLength + ", threadCount = " + i10);
        int i11 = i10 > 0 ? i10 : 1;
        synchronized (this) {
            do {
                try {
                    if (this.readers.size() >= i11) {
                        break;
                    }
                    if (!this.paused && !this.canceled) {
                        dispatchReadThreadOnce(obtainUrl());
                    }
                    return;
                } finally {
                }
            } while (!this.strategy.segmentOneByOne());
        }
    }

    private void dispatchReadThreadOnce(UrlRecord urlRecord) {
        SegmentReader segmentReader = new SegmentReader(this.downloadInfo, this, this.bufferQueue, urlRecord, this.readers.size());
        this.readers.add(segmentReader);
        segmentReader.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(segmentReader));
    }

    public SegmentReader findEarliestConnectTimeoutReader(boolean z10, long j10, long j11) {
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.threadIndex != 0 || z10) {
                if (segmentReader2.connectStartTime > 0 && segmentReader2.connectEndTime <= 0 && j10 - segmentReader2.connectStartTime > j11 && (segmentReader == null || segmentReader2.connectStartTime < segmentReader.connectStartTime)) {
                    segmentReader = segmentReader2;
                }
            }
        }
        return segmentReader;
    }

    private UrlRecord findNextUrlLocked(SegmentReader segmentReader) {
        UrlRecord urlRecord;
        Iterator<UrlRecord> it = this.urlRecords.iterator();
        UrlRecord urlRecord2 = null;
        while (true) {
            if (!it.hasNext()) {
                urlRecord = null;
                break;
            }
            urlRecord = it.next();
            if (urlRecord != segmentReader.urlRecord && !urlRecord.isCurrentFailed()) {
                if (urlRecord2 == null) {
                    urlRecord2 = urlRecord;
                }
                if (urlRecord.getCurrentUsers() <= 0) {
                    break;
                }
            }
        }
        if (this.strategy.urlBalance()) {
            if (urlRecord != null) {
                return urlRecord;
            }
            if (this.strategy.urlBalanceStrictly()) {
                return null;
            }
        }
        return urlRecord2;
    }

    private SegmentReader findPoorReadThread(long j10, long j11, long j12, int i10) {
        long j13 = Long.MAX_VALUE;
        int i11 = 0;
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.readStartTime > 0) {
                int i12 = i11 + 1;
                if (segmentReader2.readStartTime < j10) {
                    long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j10, j11);
                    if (this.debug) {
                        Log.i(TAG, "findPoorReadThread: speed = " + recentDownloadSpeed + ", threadIndex = " + segmentReader2.threadIndex);
                    }
                    if (recentDownloadSpeed >= 0 && recentDownloadSpeed < j13) {
                        j13 = recentDownloadSpeed;
                        segmentReader = segmentReader2;
                    }
                }
                i11 = i12;
            }
        }
        if (segmentReader == null || i11 < i10 || j13 >= j12) {
            return null;
        }
        Logger.i(TAG, "findPoorReadThread: ----------- minSpeed = " + j13 + ", threadIndex = " + segmentReader.threadIndex);
        return segmentReader;
    }

    private boolean findPoorReadThreadAndReconnect(long j10, long j11) {
        long j12 = j10 - j11;
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j12, j10);
        int size = this.readers.size();
        if (size > 0) {
            recentDownloadSpeed /= size;
        }
        SegmentReader findPoorReadThread = findPoorReadThread(j12, j10, (long) Math.max(10.0f, recentDownloadSpeed * this.poorSpeedRatio), size / 2);
        if (findPoorReadThread != null) {
            trySwitchNextUrlForReader(findPoorReadThread);
            Logger.w(TAG, "handlePoorReadThread: reconnect for poor speed, threadIndex = " + findPoorReadThread.threadIndex);
            findPoorReadThread.reconnect();
            return true;
        }
        SegmentReader findEarliestConnectTimeoutReader = findEarliestConnectTimeoutReader(true, j10, j11);
        if (findEarliestConnectTimeoutReader == null) {
            return false;
        }
        trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
        Logger.w(TAG, "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + findEarliestConnectTimeoutReader.threadIndex);
        findEarliestConnectTimeoutReader.reconnect();
        return true;
    }

    private void fixSegmentsLocked(List<Segment> list) {
        Segment segment = list.get(0);
        long startOffset = segment.getStartOffset();
        if (startOffset > 0) {
            Segment segment2 = new Segment(0L, startOffset - 1);
            Log.w(TAG, "fixSegmentsLocked: first = " + segment + ", add new first = " + segment2);
            arrangeSegmentLocked(list, segment2, true);
        }
        Iterator<Segment> it = list.iterator();
        if (it.hasNext()) {
            Segment next = it.next();
            while (it.hasNext()) {
                Segment next2 = it.next();
                if (next.getEndOffset() < next2.getStartOffset() - 1) {
                    Logger.w(TAG, "fixSegment: segment = " + next + ", new end = " + (next2.getStartOffset() - 1));
                    next.setEndOffset(next2.getStartOffset() - 1);
                }
                next = next2;
            }
        }
        Segment segment3 = list.get(list.size() - 1);
        long totalBytes = this.downloadInfo.getTotalBytes();
        if (totalBytes <= 0 || (segment3.getEndOffset() != -1 && segment3.getEndOffset() < totalBytes - 1)) {
            Logger.w(TAG, "fixSegment: last segment = " + segment3 + ", new end=-1");
            segment3.setEndOffset(-1L);
        }
    }

    private float getDownloadRatio(SegmentReader segmentReader, UrlRecord urlRecord) {
        long readBytes = segmentReader.getReadBytes();
        int size = this.readers.size();
        if (size <= 1) {
            size = this.strategy.getThreadCount();
        }
        float f10 = 1.0f;
        if (readBytes <= 0) {
            float mainRatio = this.strategy.getMainRatio();
            if (mainRatio <= 0.0f || mainRatio >= 1.0f) {
                mainRatio = 1.0f / size;
            }
            if (segmentReader.threadIndex == 0) {
                return mainRatio;
            }
            if (size > 1) {
                f10 = 1.0f - mainRatio;
                size--;
            }
        } else {
            long totalReadBytes = getTotalReadBytes();
            if (totalReadBytes > readBytes) {
                return readBytes / totalReadBytes;
            }
        }
        return f10 / size;
    }

    private long getRemainReadBytes(Segment segment) {
        long remainReadBytes = segment.getRemainReadBytes();
        if (remainReadBytes != -1) {
            return remainReadBytes;
        }
        long j10 = this.totalLength;
        return j10 > 0 ? j10 - segment.getCurrentOffsetRead() : remainReadBytes;
    }

    private long getTotalReadBytes() {
        Iterator<SegmentReader> it = this.readers.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().getReadBytes();
        }
        return j10;
    }

    private long getUnconfirmedRemainBytes(int i10, int i11) {
        Segment segment = this.dispatchedSegments.get(i10);
        long remainReadBytes = getRemainReadBytes(segment);
        int i12 = i10 + 1;
        Segment segment2 = i12 < i11 ? this.dispatchedSegments.get(i12) : null;
        if (segment2 == null) {
            return remainReadBytes;
        }
        long startOffset = segment2.getStartOffset() - segment.getCurrentOffsetRead();
        return remainReadBytes == -1 ? startOffset : Math.min(remainReadBytes, startOffset);
    }

    private int indexOfSegmentLocked(long j10) {
        int size = this.dispatchedSegments.size();
        for (int i10 = 0; i10 < size; i10++) {
            Segment segment = this.dispatchedSegments.get(i10);
            if (segment.getStartOffset() == j10) {
                return i10;
            }
            if (segment.getStartOffset() > j10) {
                return -1;
            }
        }
        return -1;
    }

    private int indexOfUrl(String str) {
        int size = this.urlRecords.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (TextUtils.equals(this.urlRecords.get(i10).url, str)) {
                return i10;
            }
        }
        return -1;
    }

    private void initDns() {
        List<String> backUpUrls;
        int ipStrategy = this.strategy.getIpStrategy();
        if (ipStrategy <= 0) {
            this.needWaitDnsResolve = false;
            dispatchReadThread();
            return;
        }
        DownloadDnsManager downloadDnsManager = DownloadDnsManager.getInstance();
        downloadDnsManager.resolveDnsAsync(this.downloadInfo.getUrl(), this, y.f.f18076n);
        if (ipStrategy <= 2 || (backUpUrls = this.downloadInfo.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                downloadDnsManager.resolveDnsAsync(str, this, y.f.f18076n);
            }
        }
    }

    private void initSegments(List<Segment> list) {
        long totalBytes = this.downloadInfo.getTotalBytes();
        this.totalLength = totalBytes;
        if (totalBytes <= 0) {
            this.totalLength = this.downloadInfo.getExpectFileLength();
            Logger.i(TAG, "initSegments: getExpectFileLength = " + this.totalLength);
        }
        synchronized (this) {
            try {
                this.toDispatchSegments.clear();
                if (list != null && !list.isEmpty()) {
                    Iterator<Segment> it = list.iterator();
                    while (it.hasNext()) {
                        arrangeSegmentLocked(this.toDispatchSegments, new Segment(it.next()), false);
                    }
                    fixSegmentsLocked(this.toDispatchSegments);
                    checkDownloadedBytesLocked(this.toDispatchSegments);
                    Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
                }
                arrangeSegmentLocked(this.toDispatchSegments, new Segment(0L, -1L), false);
                Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void initUrlRecords() {
        this.urlRecords.add(new UrlRecord(this.downloadInfo.getUrl(), true));
        List<String> backUpUrls = this.downloadInfo.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.urlRecords.add(new UrlRecord(str, false));
                }
            }
        }
        this.strategy.updateUrlCount(this.urlRecords.size());
    }

    private void initWatchDog() {
        SegmentStrategy segmentStrategy = this.strategy;
        this.connectTimeout = segmentStrategy.getConnectTimeout();
        this.readTimeout = segmentStrategy.getReadTimeout();
        this.poorSpeedRatio = segmentStrategy.getPoorSpeedRatio();
        int i10 = this.reconnectCount;
        if (i10 > 0) {
            this.watchDog.addWatcher(this.connectWatcher, i10);
        }
    }

    private void initWatchDog2() {
        if (this.readTimeout > 0) {
            this.lastReconnectTime = System.currentTimeMillis();
            this.watchDog.addWatcher(this.readWatcher, 0L);
        }
    }

    private boolean isAllContentDownloaded() {
        long j10 = this.totalLength;
        if (j10 <= 0) {
            this.isAllContentDownloaded = false;
            return false;
        }
        synchronized (this) {
            try {
                long firstOffset = SegmentUtils.getFirstOffset(this.dispatchedSegments);
                Logger.i(TAG, "isAllContentDownloaded: firstOffset = " + firstOffset);
                if (firstOffset >= j10) {
                    this.isAllContentDownloaded = true;
                    return true;
                }
                this.isAllContentDownloaded = false;
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean isAllReaderFailedLocked() {
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            if (!it.next().isFailed()) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownloadSpeedPoor(SegmentReader segmentReader, long j10, long j11, long j12, double d10) {
        if (segmentReader.readStartTime <= 0) {
            return false;
        }
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j10, j11);
        int size = this.readers.size();
        long j13 = size > 0 ? recentDownloadSpeed / size : recentDownloadSpeed;
        long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j10, j11);
        if (recentDownloadSpeed2 >= j12 && recentDownloadSpeed2 >= j13 * d10) {
            return false;
        }
        Log.i(TAG, "isDownloadSpeedPoor: totalSpeed = " + recentDownloadSpeed + ", threadAvgSpeed = " + j13 + ", poorSpeed = " + j12 + ", speed = " + recentDownloadSpeed2 + ",threadIndex = " + segmentReader.threadIndex);
        return true;
    }

    private void markProgress(long j10) {
        this.stenographer.markProgress(this.downloadInfo.getCurBytes(), j10);
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            it.next().markProgress(j10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.segment.Segment obtainChildSegmentFromMaxRemain(com.ss.android.socialbase.downloader.segment.SegmentReader r29, com.ss.android.socialbase.downloader.segment.UrlRecord r30) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.obtainChildSegmentFromMaxRemain(com.ss.android.socialbase.downloader.segment.SegmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord):com.ss.android.socialbase.downloader.segment.Segment");
    }

    private Segment obtainLeastCompetitorSegment() {
        int competitor;
        Segment segment = null;
        int i10 = Integer.MAX_VALUE;
        for (Segment segment2 : this.dispatchedSegments) {
            if (getRemainReadBytes(segment2) > 0 && (competitor = segment2.getCompetitor()) < i10) {
                segment = segment2;
                i10 = competitor;
            }
        }
        return segment;
    }

    private Segment obtainSegmentLocked(SegmentReader segmentReader, UrlRecord urlRecord) {
        while (!this.toDispatchSegments.isEmpty()) {
            Segment poll = this.toDispatchSegments.poll();
            if (poll != null) {
                arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                if (getRemainReadBytes(poll) > 0 || this.totalLength <= 0) {
                    return poll;
                }
            }
        }
        clearCoveredSegmentLocked();
        Segment obtainChildSegmentFromMaxRemain = obtainChildSegmentFromMaxRemain(segmentReader, urlRecord);
        if (obtainChildSegmentFromMaxRemain != null && getRemainReadBytes(obtainChildSegmentFromMaxRemain) > 0) {
            arrangeSegmentLocked(this.dispatchedSegments, obtainChildSegmentFromMaxRemain, true);
            return obtainChildSegmentFromMaxRemain;
        }
        Segment obtainSegmentWhenNoNewSegment = obtainSegmentWhenNoNewSegment();
        if (obtainSegmentWhenNoNewSegment != null) {
            return obtainSegmentWhenNoNewSegment;
        }
        return null;
    }

    private Segment obtainSegmentWhenNoNewSegment() {
        int i10 = 0;
        while (true) {
            Segment obtainLeastCompetitorSegment = obtainLeastCompetitorSegment();
            if (obtainLeastCompetitorSegment == null) {
                return null;
            }
            SegmentReader segmentReader = obtainLeastCompetitorSegment.owner;
            if (segmentReader == null) {
                return obtainLeastCompetitorSegment;
            }
            if (obtainLeastCompetitorSegment.getCompetitor() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            markProgress(currentTimeMillis);
            if (currentTimeMillis - segmentReader.readStartTime > y.f.f18076n && isDownloadSpeedPoor(segmentReader, currentTimeMillis - y.f.f18076n, currentTimeMillis, 500L, 1.0d)) {
                if (this.debug) {
                    Log.i(TAG, "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + obtainLeastCompetitorSegment + ", owner.threadIndex = " + segmentReader.threadIndex);
                }
                return obtainLeastCompetitorSegment;
            }
            int i11 = i10 + 1;
            if (i10 > 2) {
                if (this.debug) {
                    Log.i(TAG, "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + obtainLeastCompetitorSegment);
                }
                return obtainLeastCompetitorSegment;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i10 = i11;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private UrlRecord obtainUrl() {
        UrlRecord urlRecord;
        synchronized (this) {
            try {
                int size = this.urlIndex % this.urlRecords.size();
                if (this.strategy.urlBalance()) {
                    this.urlIndex++;
                }
                urlRecord = this.urlRecords.get(size);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return urlRecord;
    }

    private void onComplete() {
        Logger.i(TAG, "onComplete");
        this.bufferQueue.close();
        synchronized (this.firstConnectionLock) {
            this.firstConnectionLock.notify();
        }
    }

    private void onError(BaseException baseException) {
        Logger.e(TAG, "onError, e = " + baseException);
        this.failedException = baseException;
        this.bufferQueue.close();
        synchronized (this) {
            try {
                Iterator<SegmentReader> it = this.readers.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long scheduleWatchRead() {
        if (this.canceled || this.paused) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                markProgress(currentTimeMillis);
                long readTimeout = this.strategy.getReadTimeout();
                if (readTimeout > 0) {
                    long j10 = this.lastReconnectTime;
                    if (j10 > 0 && currentTimeMillis - j10 > readTimeout && findPoorReadThreadAndReconnect(currentTimeMillis, readTimeout)) {
                        this.lastReconnectTime = currentTimeMillis;
                        this.reconnectCount++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return y.f.f18076n;
    }

    private void switchToNextUrl() {
        synchronized (this) {
            this.urlIndex++;
        }
    }

    public boolean trySwitchNextUrlForReader(SegmentReader segmentReader) {
        synchronized (this) {
            try {
                UrlRecord findNextUrlLocked = findNextUrlLocked(segmentReader);
                if (findNextUrlLocked == null) {
                    return false;
                }
                return segmentReader.switchUrlRecord(findNextUrlLocked);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void validateHttpResponse(HttpResponse httpResponse) throws BaseException {
        HttpResponse httpResponse2 = this.mainUrlHttpResponse;
        if (httpResponse2 == null && (httpResponse2 = this.firstBackupUrlHttpResponse) == null) {
            return;
        }
        long totalLength = httpResponse.getTotalLength();
        long totalLength2 = httpResponse2.getTotalLength();
        if (totalLength != totalLength2) {
            String str = "total len not equals,len=" + totalLength + ",sLen=" + totalLength2 + ",code=" + httpResponse.responseCode + ",sCode=" + httpResponse2.responseCode + ",range=" + httpResponse.getContentRange() + ",sRange = " + httpResponse2.getContentRange() + ",url = " + httpResponse.url + ",sUrl=" + httpResponse2.url;
            Logger.e(TAG, str);
            if (totalLength > 0 && totalLength2 > 0) {
                throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, str);
            }
        }
        String etag = httpResponse.getEtag();
        String etag2 = httpResponse2.getEtag();
        if (TextUtils.equals(etag, etag2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + etag + ", mainEtag = " + etag2;
        Logger.e(TAG, str2);
        if (!TextUtils.isEmpty(etag) && !TextUtils.isEmpty(etag2) && !etag.equalsIgnoreCase(etag2)) {
            throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, str2);
        }
    }

    private void waitFirstConnection() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.firstConnectionLock) {
            try {
                if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null) {
                    this.firstConnectionLock.wait();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null && (baseException = this.failedException) != null) {
            throw baseException;
        }
    }

    private void writeSegments() throws BaseException {
        try {
            this.writer.loopAndWrite(this.bufferQueue);
        } catch (StreamClosedException unused) {
        } catch (BaseException e10) {
            Logger.e(TAG, "dispatchSegments: loopAndWrite e = " + e10);
            onError(e10);
            throw e10;
        }
        if (this.paused || this.canceled) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.toDispatchSegments.isEmpty()) {
                    try {
                        Segment poll = this.toDispatchSegments.poll();
                        if (poll != null) {
                            arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                        }
                    } finally {
                    }
                }
                checkDownloadedBytesLocked(this.dispatchedSegments);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (!this.allReaderFailed || this.failedException == null) {
            if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
                DownloadMonitorHelper.monitorSegmentsError(this.downloadInfo, this.dispatchedSegments);
            }
            Logger.i(TAG, "dispatchSegments::download finished");
        } else {
            Logger.e(TAG, "dispatchSegments: loopAndWrite  failedException = " + this.failedException);
            throw this.failedException;
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void applySegment(SegmentReader segmentReader, Segment segment) throws BaseException {
        synchronized (this) {
            applySegmentLocked(segmentReader, segment);
        }
    }

    public void cancel() {
        Logger.i(TAG, "cancel");
        this.canceled = true;
        synchronized (this) {
            try {
                Iterator<SegmentReader> it = this.readers.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.writer.cancel();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public IOutput createOutput(SegmentReader segmentReader, Segment segment) throws BaseException {
        IOutput stub;
        synchronized (this) {
            SegmentOutput segmentOutput = new SegmentOutput(this.downloadInfo, this.bufferQueue, segment);
            this.writer.assignOutput(segmentOutput);
            stub = segmentOutput.getStub();
        }
        return stub;
    }

    public boolean downloadSegments(List<Segment> list) throws BaseException, InterruptedException {
        try {
            initUrlRecords();
            initSegments(list);
            dispatchReadThread();
            initWatchDog();
            initDns();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                waitFirstConnection();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(currentTimeMillis2);
                this.downloadInfo.setFirstSpeedTime(currentTimeMillis2);
                if (!this.paused && !this.canceled) {
                    this.hostCallback.checkSpaceOverflow(this.totalLength);
                    initWatchDog2();
                    writeSegments();
                    return true;
                }
                if (!this.paused && !this.canceled) {
                    Logger.i(TAG, "finally pause");
                    pause();
                }
                this.watchDog.release();
                return true;
            } catch (Throwable th2) {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(currentTimeMillis3);
                this.downloadInfo.setFirstSpeedTime(currentTimeMillis3);
                throw th2;
            }
        } finally {
            if (!this.paused && !this.canceled) {
                Logger.i(TAG, "finally pause");
                pause();
            }
            this.watchDog.release();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public Segment obtainSegment(SegmentReader segmentReader, UrlRecord urlRecord) {
        if (this.canceled || this.paused) {
            return null;
        }
        synchronized (this) {
            try {
                Segment obtainSegmentLocked = obtainSegmentLocked(segmentReader, urlRecord);
                if (obtainSegmentLocked != null) {
                    obtainSegmentLocked.increaseCompetitor();
                    if (obtainSegmentLocked.getCompetitor() > 1) {
                        return new Segment(obtainSegmentLocked);
                    }
                }
                return obtainSegmentLocked;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback
    public void onDnsResolved(String str, List<InetAddress> list) {
        List<UrlRecord> list2;
        if (this.paused || this.canceled) {
            return;
        }
        try {
            list2 = assembleIpAddress(str, list);
        } catch (Throwable th2) {
            th2.printStackTrace();
            list2 = null;
        }
        synchronized (this) {
            if (list2 != null) {
                try {
                    addIpListLocked(str, list2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            this.needWaitDnsResolve = false;
            this.strategy.updateUrlCount(this.urlRecords.size());
            Log.i(TAG, "onDnsResolved: dispatchReadThread");
            dispatchReadThread();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderExit(SegmentReader segmentReader) {
        Logger.i(TAG, "onReaderExit: threadIndex = " + segmentReader.threadIndex);
        synchronized (this) {
            try {
                segmentReader.setExited(true);
                this.readers.remove(segmentReader);
                clearCoveredSegmentLocked();
                if (this.readers.isEmpty()) {
                    onComplete();
                } else if (isAllContentDownloaded()) {
                    Log.i(TAG, "onReaderExit: allContentDownloaded");
                    Iterator<SegmentReader> it = this.readers.iterator();
                    while (it.hasNext()) {
                        it.next().close();
                    }
                    onComplete();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderRun(SegmentReader segmentReader) {
        if (this.debug) {
            Logger.i(TAG, "onReaderRun, threadIndex = " + segmentReader.threadIndex);
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentConnected(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException, RetryThrowable {
        synchronized (this) {
            try {
                if (this.canceled || this.paused) {
                    throw new StreamClosedException("connected");
                }
                checkSegmentHttpResponseLocked(segmentReader, segment, urlRecord, httpResponse);
                segmentReader.setFailed(false);
                if (this.totalLength <= 0) {
                    long totalBytes = this.downloadInfo.getTotalBytes();
                    this.totalLength = totalBytes;
                    if (totalBytes <= 0) {
                        this.totalLength = httpResponse.getTotalLength();
                    }
                    dispatchReadThread();
                } else if (this.strategy.segmentOneByOne()) {
                    dispatchReadThread();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentFailed(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException) {
        synchronized (this) {
            try {
                Logger.e(TAG, "onSegmentFailed: segment = " + segment + ", e = " + baseException);
                segmentReader.setFailed(true);
                if (segmentReader.threadIndex == 0) {
                    this.failedException = baseException;
                }
                if (isAllReaderFailedLocked()) {
                    if (this.failedException == null) {
                        this.failedException = baseException;
                    }
                    this.allReaderFailed = true;
                    onError(this.failedException);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentRetry(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException, int i10, int i11) {
        boolean isResponseCodeError = DownloadUtils.isResponseCodeError(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            isResponseCodeError = true;
        }
        if (isResponseCodeError || i10 >= i11) {
            trySwitchNextUrlForReader(segmentReader);
        }
    }

    public void pause() {
        Logger.i(TAG, "pause1");
        this.paused = true;
        synchronized (this) {
            try {
                Iterator<SegmentReader> it = this.readers.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.writer.pause();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unApplySegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            try {
                if (segment.owner == segmentReader) {
                    Logger.i(TAG, "unApplySegment " + segment);
                    segment.setCurrentOffsetRead(segmentReader.getCurSegmentReadOffset());
                    segment.owner = null;
                    segmentReader.updateReadBytes();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unObtainSegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            segment.decreaseCompetitor();
        }
    }
}
