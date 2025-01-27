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

    public MultiSegmentWriter(DownloadInfo downloadInfo, IDownloadRunnableCallback iDownloadRunnableCallback, IBufferPool iBufferPool) {
        this.downloadInfo = downloadInfo;
        this.callback = iDownloadRunnableCallback;
        this.pool = iBufferPool;
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        this.setting = obtain;
        boolean z10 = obtain.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        this.hasSyncStrategy = z10;
        if (z10) {
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

    private void checkAndSync(long j10, boolean z10) throws IOException {
        long j11 = j10 - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j11 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                flushAndSync();
                this.lastSyncTimestamp = j10;
                return;
            }
            return;
        }
        long curBytes = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
        if (z10 || isNeedSync(curBytes, j11)) {
            flushAndSync();
            this.lastSyncTimestamp = j10;
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
        boolean z10;
        boolean z11 = this.isMonitorRw;
        long nanoTime = z11 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        List<SegmentOutput> list = this.outputs;
        List<SegmentOutput> list2 = this.doneOutputs;
        Map<Long, Segment> segmentMap = iDownloadCache.getSegmentMap(downloadInfo.getId());
        if (segmentMap == null) {
            segmentMap = new HashMap<>(4);
        }
        synchronized (this) {
            try {
                flush(list);
                try {
                    sync(list);
                    z10 = true;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    z10 = false;
                }
                updateSegmentToMap(list, segmentMap);
                if (list2.size() > 0) {
                    close(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z10) {
            downloadInfo.updateRealDownloadTime(true);
            iDownloadCache.updateSegments(downloadInfo.getId(), segmentMap);
            iDownloadCache.updateDownloadInfo(downloadInfo);
            this.lastSyncBytes = downloadInfo.getCurBytes();
        }
        if (z11) {
            this.syncTimeNs += System.nanoTime() - nanoTime;
        }
    }

    private boolean isNeedSync(long j10, long j11) {
        return j10 > 65536 && j11 > 500;
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

    public void assignOutput(SegmentOutput segmentOutput) {
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

    /* JADX WARN: Code restructure failed: missing block: B:113:0x017e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x017f, code lost:
    
        r15 = r22;
        r17 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0183, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02ea, code lost:
    
        if (r9 > 0) goto L964;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02ed, code lost:
    
        r3.onProgress(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02f4, code lost:
    
        if (r27.canceled == false) goto L1060;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0313, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0314, code lost:
    
        monitor-enter(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0315, code lost:
    
        close(r27.outputs);
        r27.outputs.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0320, code lost:
    
        r28 = r2;
        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(r27.setting, r4, r4.getUrl(), null, r27.paused, r27.canceled, r27.exception, r4.getCurBytes() - r5, java.lang.System.nanoTime() - r7, r14, r15, r17, r27.syncTimeNs, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0346, code lost:
    
        if (r28 == null) goto L992;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0355, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(r28, "loopAndWrite_finally");
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x035d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x035e, code lost:
    
        r27.exception = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0360, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02f6, code lost:
    
        flushAndSync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02fa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02fb, code lost:
    
        r2 = r0;
        com.ss.android.socialbase.downloader.logger.Logger.w(com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.TAG, "loopAndWrite: finally sync, e = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x036b, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0177, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0178, code lost:
    
        r15 = r22;
        r17 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x017c, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x01b5, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x01db, code lost:
    
        r3.onProgress(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0203, code lost:
    
        close(r27.outputs);
        r27.outputs.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x020e, code lost:
    
        r28 = r2;
        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(r27.setting, r4, r4.getUrl(), null, r27.paused, r27.canceled, r27.exception, r4.getCurBytes() - r5, java.lang.System.nanoTime() - r7, r14, r15, r17, r27.syncTimeNs, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0234, code lost:
    
        if (r28 == null) goto L915;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0243, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(r28, "loopAndWrite_finally");
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x024b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x024c, code lost:
    
        r27.exception = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x024e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x01e4, code lost:
    
        flushAndSync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x01e8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x01e9, code lost:
    
        r2 = r0;
        com.ss.android.socialbase.downloader.logger.Logger.w(com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.TAG, "loopAndWrite: finally sync, e = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x025a, code lost:
    
        r3.onProgress(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0282, code lost:
    
        close(r27.outputs);
        r27.outputs.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x028d, code lost:
    
        r28 = r2;
        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(r27.setting, r4, r4.getUrl(), null, r27.paused, r27.canceled, r27.exception, r4.getCurBytes() - r5, java.lang.System.nanoTime() - r7, r14, r15, r17, r27.syncTimeNs, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x02b3, code lost:
    
        if (r28 == null) goto L951;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x02c2, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(r28, "loopAndWrite_finally");
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x02ca, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x02cb, code lost:
    
        r27.exception = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x02cd, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0263, code lost:
    
        flushAndSync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0267, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0268, code lost:
    
        r2 = r0;
        com.ss.android.socialbase.downloader.logger.Logger.w(com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.TAG, "loopAndWrite: finally sync, e = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x00bf, code lost:
    
        if (r2 <= 0) goto L813;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x00c2, code lost:
    
        r3.onProgress(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0157, code lost:
    
        checkAndSync(r10, r3.onProgress(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015c, code lost:
    
        if (com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.isWifi != false) goto L1098;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0162, code lost:
    
        if (r4.isOnlyWifi() != false) goto L1095;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0168, code lost:
    
        if (r4.isDownloadFromReserveWifi() == false) goto L1099;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016e, code lost:
    
        if (r4.isPauseReserveOnWifi() != false) goto L1097;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0176, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0192, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0191, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0186, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0187, code lost:
    
        r10 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0189, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e2 A[Catch: all -> 0x01b9, TryCatch #19 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0315 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036b A[Catch: all -> 0x01b9, TryCatch #19 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01a9 A[Catch: all -> 0x01b9, TryCatch #19 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01b5 A[Catch: all -> 0x01b9, TryCatch #19 {all -> 0x01b9, blocks: (B:171:0x01a5, B:173:0x01a9, B:176:0x01af, B:178:0x01b5, B:179:0x01bd, B:181:0x01d3, B:225:0x0254, B:226:0x0256, B:116:0x02d8, B:118:0x02e2, B:120:0x02e6, B:163:0x0365, B:165:0x036b, B:166:0x036e, B:167:0x0386), top: B:6:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0282 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput r28) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput):void");
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}
