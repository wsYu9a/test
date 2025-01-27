package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
class MultiSegmentWriter {
    private static final boolean DEBUG = false;
    private static final int MIN_CACHE_BYTES = 65536;
    private static final int MIN_CACHE_TIME_MS = 100;
    private static final int MIN_SYNC_STEP_BYTE = 65536;
    private static final long MIN_SYNC_TIME_MS = 500;
    private static final String TAG = "MultiSegmentWriter";
    private final IDownloadRunnableCallback callback;
    private final DownloadInfo downloadInfo;
    private BaseException exception;
    private final boolean hasSyncStrategy;
    private final boolean isMonitorRw;
    private final IBufferPool pool;
    private final DownloadSetting setting;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private long syncTimeNs;
    private final List<SegmentOutput> outputs = new LinkedList();
    private final List<SegmentOutput> doneOutputs = new ArrayList();
    private volatile boolean threadDirty = false;
    private volatile boolean paused = false;
    private volatile boolean canceled = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
    private final AppStatusManager appStatusManager = AppStatusManager.getInstance();

    MultiSegmentWriter(DownloadInfo downloadInfo, IDownloadRunnableCallback iDownloadRunnableCallback, IBufferPool iBufferPool) {
        this.downloadInfo = downloadInfo;
        this.callback = iDownloadRunnableCallback;
        this.pool = iBufferPool;
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
    }

    private void checkAndSync(long j2, boolean z) throws IOException {
        long j3 = j2 - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j3 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                flushAndSync();
                this.lastSyncTimestamp = j2;
                return;
            }
            return;
        }
        long curBytes = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
        if (z || isNeedSync(curBytes, j3)) {
            flushAndSync();
            this.lastSyncTimestamp = j2;
        }
    }

    private void close(List<SegmentOutput> list) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    private void flush(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    private void flushAndSync() throws IOException {
        boolean z = this.isMonitorRw;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        List<SegmentOutput> list = this.outputs;
        List<SegmentOutput> list2 = this.doneOutputs;
        Map<Long, Segment> segmentMap = iDownloadCache.getSegmentMap(downloadInfo.getId());
        if (segmentMap == null) {
            segmentMap = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            flush(list);
            try {
                sync(list);
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            updateSegmentToMap(list, segmentMap);
            if (list2.size() > 0) {
                close(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            iDownloadCache.updateSegments(downloadInfo.getId(), segmentMap);
            iDownloadCache.updateDownloadInfo(downloadInfo);
            this.lastSyncBytes = downloadInfo.getCurBytes();
        }
        if (z) {
            this.syncTimeNs += System.nanoTime() - nanoTime;
        }
    }

    private boolean isNeedSync(long j2, long j3) {
        return j2 > 65536 && j3 > 500;
    }

    private void outputDone(IOutput iOutput) {
        synchronized (this) {
            this.doneOutputs.add((SegmentOutput) iOutput);
        }
    }

    private void sync(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().sync();
        }
    }

    private void updateSegmentToMap(List<SegmentOutput> list, Map<Long, Segment> map) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            Segment segment = it.next().getSegment();
            Segment segment2 = map.get(Long.valueOf(segment.getStartOffset()));
            if (segment2 == null) {
                map.put(Long.valueOf(segment.getStartOffset()), new Segment(segment));
            } else {
                segment2.setCurrentOffset(segment.getCurrentOffset());
                segment2.setEndOffset(segment.getEndOffset());
            }
        }
    }

    void assignOutput(SegmentOutput segmentOutput) {
        synchronized (this) {
            this.outputs.add(segmentOutput);
        }
    }

    public void cancel() {
        this.canceled = true;
        this.threadDirty = true;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:183:0x02a4, code lost:
    
        r3.onProgress(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x00b8, code lost:
    
        if (r13 <= 0) goto L483;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x00bb, code lost:
    
        r3.onProgress(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03bf A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:124:0x01f0, B:126:0x01f4, B:129:0x01fa, B:131:0x0200, B:132:0x0203, B:134:0x0219, B:178:0x029e, B:179:0x02a0, B:68:0x0328, B:70:0x0332, B:72:0x0336, B:115:0x03b9, B:117:0x03bf, B:118:0x03c2, B:119:0x03da), top: B:6:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f4 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:124:0x01f0, B:126:0x01f4, B:129:0x01fa, B:131:0x0200, B:132:0x0203, B:134:0x0219, B:178:0x029e, B:179:0x02a0, B:68:0x0328, B:70:0x0332, B:72:0x0336, B:115:0x03b9, B:117:0x03bf, B:118:0x03c2, B:119:0x03da), top: B:6:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0200 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:124:0x01f0, B:126:0x01f4, B:129:0x01fa, B:131:0x0200, B:132:0x0203, B:134:0x0219, B:178:0x029e, B:179:0x02a0, B:68:0x0328, B:70:0x0332, B:72:0x0336, B:115:0x03b9, B:117:0x03bf, B:118:0x03c2, B:119:0x03da), top: B:6:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0249 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0419 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0332 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:124:0x01f0, B:126:0x01f4, B:129:0x01fa, B:131:0x0200, B:132:0x0203, B:134:0x0219, B:178:0x029e, B:179:0x02a0, B:68:0x0328, B:70:0x0332, B:72:0x0336, B:115:0x03b9, B:117:0x03bf, B:118:0x03c2, B:119:0x03da), top: B:6:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0365 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput):void");
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}
