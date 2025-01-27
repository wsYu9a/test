package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;

/* loaded from: classes4.dex */
public class DownloadChunkRunnable implements Runnable {
    private static final String TAG = "DownloadChunkRunnable";
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private DownloadChunk curDownloadChunk;
    private IDownloadCache downloadCache;
    private DownloadChunk downloadChunk;
    private DownloadInfo downloadInfo;
    private DownloadResponseHandler downloadResponseHandler;
    private final DownloadTask downloadTask;
    private IDownloadHttpConnection httpConnection;
    private boolean isHttpConnectionInject;
    private volatile boolean paused;

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.isHttpConnectionInject = false;
        this.downloadChunk = downloadChunk;
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
        }
        this.callback = iDownloadRunnableCallback;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.downloadChunk.setChunkRunnable(this);
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.httpConnection = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x022b, code lost:
    
        if (r2 < 0) goto L629;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x019c A[Catch: all -> 0x00d7, BaseException -> 0x0172, TRY_LEAVE, TryCatch #0 {BaseException -> 0x0172, blocks: (B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:147:0x0182, B:148:0x0190, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:29:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[Catch: all -> 0x00d7, BaseException -> 0x0172, SYNTHETIC, TRY_LEAVE, TryCatch #0 {BaseException -> 0x0172, blocks: (B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:147:0x0182, B:148:0x0190, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:29:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108 A[Catch: all -> 0x00d7, BaseException -> 0x00da, TRY_ENTER, TryCatch #11 {all -> 0x00d7, blocks: (B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:21:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc A[Catch: all -> 0x01c5, TRY_ENTER, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x024d A[Catch: all -> 0x01c5, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0262 A[Catch: all -> 0x01c5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0254 A[Catch: all -> 0x01c5, TryCatch #2 {all -> 0x01c5, blocks: (B:70:0x01d2, B:72:0x01dc, B:125:0x01e2, B:74:0x01eb, B:76:0x01f3, B:106:0x01f9, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:85:0x0221, B:87:0x0247, B:89:0x024d, B:90:0x025a, B:92:0x0262, B:97:0x0254, B:99:0x0230, B:101:0x023c, B:110:0x026d, B:112:0x0275, B:114:0x027d, B:116:0x0285, B:118:0x028d, B:121:0x0296, B:201:0x01b5, B:206:0x01bf, B:211:0x01c9, B:22:0x004f, B:24:0x0059, B:27:0x0064, B:33:0x00ba, B:35:0x00be, B:44:0x00d3, B:45:0x00fe, B:47:0x0108, B:49:0x010c, B:51:0x013c, B:53:0x0149, B:55:0x0150, B:59:0x015c, B:60:0x0162, B:62:0x0175, B:144:0x0135, B:140:0x013b, B:147:0x0182, B:148:0x0190, B:182:0x00e4, B:184:0x00e8, B:162:0x0198, B:164:0x019c, B:175:0x01b1, B:176:0x01b4), top: B:69:0x01d2, inners: #3, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk r25) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk):boolean");
    }

    private String getUrl() {
        return this.downloadInfo.getConnectionUrl();
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void revertDownloadChunk(DownloadChunk downloadChunk, long j10) {
        DownloadChunk firstReuseChunk = downloadChunk.isHostChunk() ? downloadChunk.getFirstReuseChunk() : downloadChunk;
        if (firstReuseChunk == null) {
            if (downloadChunk.isHostChunk()) {
                this.downloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getChunkIndex(), j10);
            }
        } else {
            if (firstReuseChunk.canRefreshCurOffsetForReuseChunk()) {
                this.downloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), j10);
            }
            firstReuseChunk.setCurrentOffset(j10);
            this.downloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), j10);
        }
    }

    public void cancel() {
        this.canceled = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.cancel();
        }
    }

    public int getChunkIndex() {
        return this.downloadChunk.getChunkIndex();
    }

    public void pause() {
        this.paused = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.pause();
        }
    }

    public void refreshResponseHandleOffset(long j10, long j11) {
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler == null) {
            return;
        }
        downloadResponseHandler.setEndOffset(j10, j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0017, code lost:
    
        r3.curDownloadChunk.setDownloading(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r3.downloadChunk
            r3.curDownloadChunk = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            r1.setChunkRunnable(r3)     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.downloadChunkInner(r1)     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            r1.setDownloading(r0)     // Catch: java.lang.Throwable -> L1d
            goto L4f
        L1d:
            r1 = move-exception
            goto L5f
        L1f:
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            r1.setDownloading(r0)     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.isStoppedStatus()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L2b
            goto L4f
        L2b:
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r1 = r3.callback     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.DownloadChunk r2 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.getChunkIndex()     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r1.getUnCompletedSubChunk(r2)     // Catch: java.lang.Throwable -> L1d
            r3.curDownloadChunk = r1     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.isStoppedStatus()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4f
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L44
            goto L4f
        L44:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L4a
            goto L9
        L4a:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1d
            goto L9
        L4f:
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk
            if (r1 == 0) goto L56
            r1.setDownloading(r0)
        L56:
            r3.closeConnection()
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r3.callback
            r0.onCompleted(r3)
            return
        L5f:
            com.ss.android.socialbase.downloader.model.DownloadChunk r2 = r3.curDownloadChunk
            if (r2 == 0) goto L66
            r2.setDownloading(r0)
        L66:
            r3.closeConnection()
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r3.callback
            r0.onCompleted(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.run():void");
    }

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadHttpConnection iDownloadHttpConnection, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this(downloadChunk, downloadTask, iDownloadRunnableCallback);
        this.httpConnection = iDownloadHttpConnection;
    }
}
