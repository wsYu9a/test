package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
public final class d implements Handler.Callback {
    private volatile Thread aiE;
    private final a ajR;
    private final int ajS;
    private final int ajT;
    private final int ajU;
    private long ajV;
    private HandlerThread ajW;
    private volatile boolean ajZ;
    private final com.kwad.framework.filedownloader.d.c ajj;
    private Handler handler;
    private volatile boolean ajX = false;
    private volatile long ajD = 0;
    private final AtomicLong ajY = new AtomicLong();
    private boolean aka = true;
    private final com.kwad.framework.filedownloader.b.a aje = b.ww().wy();

    public static class a {
        private boolean akb;
        private Exception akc;
        private int akd;

        public final void bf(boolean z10) {
            this.akb = z10;
        }

        public final void bv(int i10) {
            this.akd = i10;
        }

        public final void f(Exception exc) {
            this.akc = exc;
        }

        public final Exception getException() {
            return this.akc;
        }

        public final int vh() {
            return this.akd;
        }

        public final boolean wY() {
            return this.akb;
        }
    }

    public d(com.kwad.framework.filedownloader.d.c cVar, int i10, int i11, int i12) {
        this.ajj = cVar;
        this.ajT = i11 < 5 ? 5 : i11;
        this.ajU = i12;
        this.ajR = new a();
        this.ajS = i10;
    }

    private boolean Q(long j10) {
        if (!this.aka) {
            return this.ajV != -1 && this.ajY.get() >= this.ajV && j10 - this.ajD >= ((long) this.ajT);
        }
        this.aka = false;
        return true;
    }

    private synchronized void b(Message message) {
        if (!this.ajW.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e10) {
            if (this.ajW.isAlive()) {
                throw e10;
            }
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    private Exception d(Exception exc) {
        long length;
        String wL = this.ajj.wL();
        if ((!this.ajj.isChunked() && !com.kwad.framework.filedownloader.f.e.xV().alz) || !(exc instanceof IOException) || !new File(wL).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(wL);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(wL);
        if (file.exists()) {
            length = file.length();
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception d10 = d(exc);
        if (d10 instanceof SQLiteFullException) {
            a((SQLiteFullException) d10);
            exc2 = d10;
        } else {
            try {
                this.ajj.d((byte) -1);
                this.ajj.bs(exc.toString());
                this.aje.a(this.ajj.getId(), d10, this.ajj.xt());
                exc2 = d10;
            } catch (SQLiteFullException e10) {
                SQLiteFullException sQLiteFullException = e10;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.ajR.f(exc2);
        c((byte) -1);
    }

    private static long h(long j10, long j11) {
        if (j11 <= 0) {
            return -1L;
        }
        if (j10 == -1) {
            return 1L;
        }
        long j12 = j10 / (j11 + 1);
        if (j12 <= 0) {
            return 1L;
        }
        return j12;
    }

    private void wU() {
        String wL = this.ajj.wL();
        String targetFilePath = this.ajj.getTargetFilePath();
        File file = new File(wL);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't rename the  temp downloaded file(%s) to the target file(%s)", wL, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", wL);
        } catch (Throwable th2) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", wL);
            }
            throw th2;
        }
    }

    private void wV() {
        wU();
        this.ajj.d((byte) -3);
        this.aje.c(this.ajj.getId(), this.ajj.getTotal());
        this.aje.bn(this.ajj.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.xV().alA) {
            com.kwad.framework.filedownloader.services.f.f(this.ajj);
        }
    }

    private boolean wW() {
        if (this.ajj.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.ajj;
            cVar.V(cVar.xt());
        } else if (this.ajj.xt() != this.ajj.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("sofar[%d] not equal total[%d]", Long.valueOf(this.ajj.xt()), Long.valueOf(this.ajj.getTotal()))));
            return true;
        }
        return false;
    }

    private void wX() {
        this.ajj.d((byte) -2);
        this.aje.d(this.ajj.getId(), this.ajj.xt());
        c((byte) -2);
    }

    public final void a(boolean z10, long j10, String str, String str2) {
        String xu = this.ajj.xu();
        if (xu != null && !xu.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, xu));
        }
        this.ajR.bf(z10);
        this.ajj.d((byte) 2);
        this.ajj.V(j10);
        this.ajj.br(str);
        this.ajj.bt(str2);
        this.aje.a(this.ajj.getId(), j10, str, str2);
        c((byte) 2);
        this.ajV = h(j10, this.ajU);
        this.ajZ = true;
    }

    public final void c(Exception exc) {
        e(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.ajX = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L19
            r2 = 5
            if (r1 == r2) goto Ld
            goto L20
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L17
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L17
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L17
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L17
            goto L20
        L17:
            r5 = move-exception
            goto L2c
        L19:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L17
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L17
        L20:
            r4.ajX = r3
            java.lang.Thread r5 = r4.aiE
            if (r5 == 0) goto L2b
            java.lang.Thread r5 = r4.aiE
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L2b:
            return r0
        L2c:
            r4.ajX = r3
            java.lang.Thread r0 = r4.aiE
            if (r0 == 0) goto L37
            java.lang.Thread r0 = r4.aiE
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L37:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.ajW;
        return handlerThread != null && handlerThread.isAlive();
    }

    public final void onProgress(long j10) {
        this.ajY.addAndGet(j10);
        this.ajj.U(j10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean Q = Q(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, Q);
        } else if (Q) {
            b(handler.obtainMessage(3));
        }
    }

    public final void wO() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.ajW.quit();
            this.aiE = Thread.currentThread();
            while (this.ajX) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.aiE = null;
        }
    }

    public final void wP() {
        this.ajj.d((byte) 1);
        this.aje.bp(this.ajj.getId());
        c((byte) 1);
    }

    public final void wQ() {
        this.ajj.d((byte) 6);
        c((byte) 6);
        this.aje.bk(this.ajj.getId());
    }

    public final void wR() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.ajW = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.ajW.getLooper(), this);
    }

    public final void wS() {
        wX();
    }

    public final void wT() {
        if (wW()) {
            return;
        }
        wV();
    }

    private void c(byte b10) {
        if (b10 != -2) {
            com.kwad.framework.filedownloader.message.e.xn().s(com.kwad.framework.filedownloader.message.f.a(b10, this.ajj, this.ajR));
        } else if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.ajj.getId()));
        }
    }

    private void b(long j10, boolean z10) {
        if (this.ajj.xt() == this.ajj.getTotal()) {
            this.aje.b(this.ajj.getId(), this.ajj.xt());
            return;
        }
        if (this.ajZ) {
            this.ajZ = false;
            this.ajj.d((byte) 3);
        }
        if (z10) {
            this.ajD = j10;
            c((byte) 3);
            this.ajY.set(0L);
        }
    }

    public final void a(Exception exc, int i10, long j10) {
        this.ajY.set(0L);
        this.ajj.U(-j10);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i10);
        } else {
            b(handler.obtainMessage(5, i10, 0, exc));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id2 = this.ajj.getId();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id2), sQLiteFullException.toString());
        }
        this.ajj.bs(sQLiteFullException.toString());
        this.ajj.d((byte) -1);
        this.aje.bo(id2);
        this.aje.bn(id2);
    }

    private void a(Exception exc, int i10) {
        Exception d10 = d(exc);
        this.ajR.f(d10);
        this.ajR.bv(this.ajS - i10);
        this.ajj.d((byte) 5);
        this.ajj.bs(d10.toString());
        this.aje.a(this.ajj.getId(), d10);
        c((byte) 5);
    }
}
