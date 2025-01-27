package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.au;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class k {
    private final m aGI;
    private final com.kwad.sdk.core.videocache.a aGJ;
    private volatile Thread aGN;
    private volatile boolean lX;
    private final Object aGK = new Object();
    private final Object aGL = new Object();
    private volatile int aGO = -1;
    private final AtomicInteger aGM = new AtomicInteger();

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Is();
        }

        public /* synthetic */ a(k kVar, byte b10) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aGI = (m) au.checkNotNull(mVar);
        this.aGJ = (com.kwad.sdk.core.videocache.a) au.checkNotNull(aVar);
    }

    private void Ip() {
        int i10 = this.aGM.get();
        if (i10 <= 0) {
            return;
        }
        this.aGM.set(0);
        throw new ProxyCacheException("Error reading source " + i10 + " times");
    }

    private synchronized void Iq() {
        try {
            boolean z10 = (this.aGN == null || this.aGN.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.lX && !this.aGJ.isCompleted() && !z10) {
                this.aGN = new Thread(new a(this, (byte) 0), "Source reader for " + this.aGI);
                this.aGN.start();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void Ir() {
        synchronized (this.aGK) {
            try {
                try {
                    this.aGK.wait(1000L);
                } catch (InterruptedException e10) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Is() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aGJ     // Catch: java.lang.Throwable -> L41
            long r2 = r4.Id()     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aGI     // Catch: java.lang.Throwable -> L41
            r4.aC(r2)     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aGI     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aGI     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.aGL     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.Iu()
            r8.j(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.kwad.sdk.core.videocache.a r7 = r8.aGJ     // Catch: java.lang.Throwable -> L33
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L41
            r8.It()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aGM     // Catch: java.lang.Throwable -> L55
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L55
            onError(r4)     // Catch: java.lang.Throwable -> L55
            goto L2c
        L55:
            r4 = move-exception
            r8.Iu()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.Is():void");
    }

    private void It() {
        this.aGO = 100;
        dv(this.aGO);
    }

    private void Iu() {
        try {
            this.aGI.close();
        } catch (ProxyCacheException e10) {
            onError(new ProxyCacheException("Error closing source " + this.aGI, e10));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.lX;
    }

    private void j(long j10, long j11) {
        k(j10, j11);
        synchronized (this.aGK) {
            this.aGK.notifyAll();
        }
    }

    private void k(long j10, long j11) {
        int i10 = j11 == 0 ? 100 : (int) ((j10 / j11) * 100.0f);
        boolean z10 = i10 != this.aGO;
        if (j11 >= 0 && z10) {
            dv(i10);
        }
        this.aGO = i10;
    }

    private static void onError(Throwable th2) {
        if (th2 instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aGL) {
            try {
                if (!isStopped() && this.aGJ.Id() == this.aGI.length()) {
                    this.aGJ.complete();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void dv(int i10) {
    }

    public final void shutdown() {
        synchronized (this.aGL) {
            try {
                com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.aGI);
                try {
                    this.lX = true;
                    if (this.aGN != null) {
                        this.aGN.interrupt();
                    }
                    this.aGJ.close();
                } catch (ProxyCacheException e10) {
                    onError(e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int a(byte[] bArr, long j10, int i10) {
        l.b(bArr, j10, 1024);
        while (!this.aGJ.isCompleted() && this.aGJ.Id() < 1024 + j10 && !this.lX) {
            Iq();
            Ir();
            Ip();
        }
        int a10 = this.aGJ.a(bArr, j10, 1024);
        if (this.aGJ.isCompleted() && this.aGO != 100) {
            this.aGO = 100;
            dv(100);
        }
        return a10;
    }
}
