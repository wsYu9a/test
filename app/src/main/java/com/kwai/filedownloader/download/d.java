package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.sdk.crash.utils.h;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes2.dex */
public final class d implements Handler.Callback {
    private volatile Thread aGB;
    private final a aHN;
    private final int aHO;
    private final int aHP;
    private final int aHQ;
    private long aHR;
    private HandlerThread aHS;
    private volatile boolean aHV;
    private final com.kwai.filedownloader.c.c aHf;
    private Handler handler;
    private volatile boolean aHT = false;
    private volatile long aHz = 0;
    private final AtomicLong aHU = new AtomicLong();
    private boolean aHW = true;
    private final com.kwai.filedownloader.a.a aHa = b.HF().HH();

    public static class a {
        private boolean aHX;
        private Exception aHY;
        private int aHZ;

        public final int Gu() {
            return this.aHZ;
        }

        public final boolean Ig() {
            return this.aHX;
        }

        final void bT(boolean z) {
            this.aHX = z;
        }

        final void cS(int i2) {
            this.aHZ = i2;
        }

        final void g(Exception exc) {
            this.aHY = exc;
        }

        public final Exception getException() {
            return this.aHY;
        }
    }

    d(com.kwai.filedownloader.c.c cVar, int i2, int i3, int i4) {
        this.aHf = cVar;
        this.aHP = i3 < 5 ? 5 : i3;
        this.aHQ = i4;
        this.aHN = new a();
        this.aHO = i2;
    }

    private void Ic() {
        String HT = this.aHf.HT();
        String targetFilePath = this.aHf.getTargetFilePath();
        File file = new File(HT);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwai.filedownloader.e.f.j("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwai.filedownloader.e.d.h(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwai.filedownloader.e.f.j("Can't rename the  temp downloaded file(%s) to the target file(%s)", HT, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", HT);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", HT);
            }
            throw th;
        }
    }

    private void Id() {
        Ic();
        this.aHf.e((byte) -3);
        this.aHa.f(this.aHf.getId(), this.aHf.getTotal());
        this.aHa.cK(this.aHf.getId());
        d((byte) -3);
        if (com.kwai.filedownloader.e.e.Jb().aJx) {
            com.kwai.filedownloader.services.f.f(this.aHf);
        }
    }

    private boolean Ie() {
        if (this.aHf.isChunked()) {
            com.kwai.filedownloader.c.c cVar = this.aHf;
            cVar.aq(cVar.IB());
        } else if (this.aHf.IB() != this.aHf.getTotal()) {
            d(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("sofar[%d] not equal total[%d]", Long.valueOf(this.aHf.IB()), Long.valueOf(this.aHf.getTotal()))));
            return true;
        }
        return false;
    }

    private void If() {
        this.aHf.e((byte) -2);
        this.aHa.g(this.aHf.getId(), this.aHf.IB());
        d((byte) -2);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.aHf.getId();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.aHf.fw(sQLiteFullException.toString());
        this.aHf.e((byte) -1);
        this.aHa.cL(id);
        this.aHa.cK(id);
    }

    private void a(Exception exc, int i2) {
        Exception e2 = e(exc);
        this.aHN.g(e2);
        this.aHN.cS(this.aHO - i2);
        this.aHf.e((byte) 5);
        this.aHf.fw(e2.toString());
        this.aHa.a(this.aHf.getId(), e2);
        d((byte) 5);
    }

    private boolean al(long j2) {
        if (!this.aHW) {
            return this.aHR != -1 && this.aHU.get() >= this.aHR && j2 - this.aHz >= ((long) this.aHP);
        }
        this.aHW = false;
        return true;
    }

    private void b(long j2, boolean z) {
        if (this.aHf.IB() == this.aHf.getTotal()) {
            this.aHa.e(this.aHf.getId(), this.aHf.IB());
            return;
        }
        if (this.aHV) {
            this.aHV = false;
            this.aHf.e((byte) 3);
        }
        if (z) {
            this.aHz = j2;
            d((byte) 3);
            this.aHU.set(0L);
        }
    }

    private synchronized void c(Message message) {
        if (!this.aHS.isAlive()) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (this.aHS.isAlive()) {
                throw e2;
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    private void d(byte b2) {
        if (b2 != -2) {
            com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(b2, this.aHf, this.aHN));
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aHf.getId()));
        }
    }

    private Exception e(Exception exc) {
        long length;
        String HT = this.aHf.HT();
        if ((!this.aHf.isChunked() && !com.kwai.filedownloader.e.e.Jb().aJw) || !(exc instanceof IOException) || !new File(HT).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(HT);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(HT);
        if (file.exists()) {
            length = file.length();
        } else {
            com.kwai.filedownloader.e.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc) : new FileDownloadOutOfSpaceException(availableBytes, 4096L, length);
    }

    private void f(Exception exc) {
        Exception exc2;
        Exception e2 = e(exc);
        if (e2 instanceof SQLiteFullException) {
            a((SQLiteFullException) e2);
            exc2 = e2;
        } else {
            try {
                this.aHf.e((byte) -1);
                this.aHf.fw(exc.toString());
                this.aHa.a(this.aHf.getId(), e2, this.aHf.IB());
                exc2 = e2;
            } catch (SQLiteFullException e3) {
                SQLiteFullException sQLiteFullException = e3;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.aHN.g(exc2);
        d((byte) -1);
    }

    private static long g(long j2, long j3) {
        if (j3 <= 0) {
            return -1L;
        }
        if (j2 == -1) {
            return 1L;
        }
        long j4 = j2 / (j3 + 1);
        if (j4 <= 0) {
            return 1L;
        }
        return j4;
    }

    final void HW() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aHS.quit();
            this.aGB = Thread.currentThread();
            while (this.aHT) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.aGB = null;
        }
    }

    public final void HX() {
        this.aHf.e((byte) 1);
        this.aHa.cM(this.aHf.getId());
        d((byte) 1);
    }

    final void HY() {
        this.aHf.e((byte) 6);
        d((byte) 6);
        this.aHa.cH(this.aHf.getId());
    }

    final void HZ() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.aHS = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.aHS.getLooper(), this);
    }

    final void Ia() {
        If();
    }

    final void Ib() {
        if (Ie()) {
            return;
        }
        Id();
    }

    final void a(Exception exc, int i2, long j2) {
        this.aHU.set(0L);
        this.aHf.ap(-j2);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i2);
        } else {
            c(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    final void a(boolean z, long j2, String str, String str2) {
        String IC = this.aHf.IC();
        if (IC != null && !IC.equals(str)) {
            throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, IC));
        }
        this.aHN.bT(z);
        this.aHf.e((byte) 2);
        this.aHf.aq(j2);
        this.aHf.fv(str);
        this.aHf.fx(str2);
        this.aHa.a(this.aHf.getId(), j2, str, str2);
        d((byte) 2);
        this.aHR = g(j2, this.aHQ);
        this.aHV = true;
    }

    final void d(Exception exc) {
        f(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.aHT = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1e
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L2a
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L2a
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L2a
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L1e
        L17:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2a
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L2a
        L1e:
            r4.aHT = r3
            java.lang.Thread r5 = r4.aGB
            if (r5 == 0) goto L29
            java.lang.Thread r5 = r4.aGB
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L29:
            return r0
        L2a:
            r5 = move-exception
            r4.aHT = r3
            java.lang.Thread r0 = r4.aGB
            if (r0 == 0) goto L36
            java.lang.Thread r0 = r4.aGB
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L36:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aHS;
        return handlerThread != null && handlerThread.isAlive();
    }

    final void onProgress(long j2) {
        this.aHU.addAndGet(j2);
        this.aHf.ap(j2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean al = al(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, al);
        } else if (al) {
            c(handler.obtainMessage(3));
        }
    }
}
