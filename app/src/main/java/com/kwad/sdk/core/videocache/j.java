package com.kwad.sdk.core.videocache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.utils.ao;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
class j {
    private final l anZ;
    private final com.kwad.sdk.core.videocache.a aoa;
    private volatile Thread aoe;
    private volatile boolean li;
    private final Object aob = new Object();
    private final Object aoc = new Object();
    private volatile int aof = -1;
    private final AtomicInteger aod = new AtomicInteger();

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(j jVar, byte b2) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.yJ();
        }
    }

    public j(l lVar, com.kwad.sdk.core.videocache.a aVar) {
        this.anZ = (l) ao.checkNotNull(lVar);
        this.aoa = (com.kwad.sdk.core.videocache.a) ao.checkNotNull(aVar);
    }

    private void e(long j2, long j3) {
        f(j2, j3);
        synchronized (this.aob) {
            this.aob.notifyAll();
        }
    }

    private void f(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j2 / j3) * 100.0f);
        boolean z = i2 != this.aof;
        if ((j3 >= 0) && z) {
            bC(i2);
        }
        this.aof = i2;
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.li;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.b.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aoc) {
            if (!isStopped() && this.aoa.yw() == this.anZ.length()) {
                this.aoa.complete();
            }
        }
    }

    private void yG() {
        int i2 = this.aod.get();
        if (i2 <= 0) {
            return;
        }
        this.aod.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private synchronized void yH() {
        boolean z = (this.aoe == null || this.aoe.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.li && !this.aoa.isCompleted() && !z) {
            this.aoe = new Thread(new a(this, (byte) 0), "Source reader for " + this.anZ);
            this.aoe.start();
        }
    }

    private void yI() {
        synchronized (this.aob) {
            try {
                try {
                    this.aob.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void yJ() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aoa     // Catch: java.lang.Throwable -> L49
            long r2 = r4.yw()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.l r4 = r8.anZ     // Catch: java.lang.Throwable -> L49
            r4.V(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.l r4 = r8.anZ     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.l r5 = r8.anZ     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.aoc     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.yL()
            r8.e(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.aoa     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.e(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.yK()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aod     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.yL()
            r8.e(r2, r0)
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.j.yJ():void");
    }

    private void yK() {
        this.aof = 100;
        bC(this.aof);
    }

    private void yL() {
        try {
            this.anZ.close();
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + this.anZ, e2));
        }
    }

    public final int a(byte[] bArr, long j2, int i2) {
        k.b(bArr, j2, 8192);
        while (!this.aoa.isCompleted() && this.aoa.yw() < PlaybackStateCompat.ACTION_PLAY_FROM_URI + j2 && !this.li) {
            yH();
            yI();
            yG();
        }
        int a2 = this.aoa.a(bArr, j2, 8192);
        if (this.aoa.isCompleted() && this.aof != 100) {
            this.aof = 100;
            bC(100);
        }
        return a2;
    }

    protected void bC(int i2) {
    }

    public final void shutdown() {
        synchronized (this.aoc) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "Shutdown proxy for " + this.anZ);
            try {
                this.li = true;
                if (this.aoe != null) {
                    this.aoe.interrupt();
                }
                this.aoa.close();
            } catch (ProxyCacheException e2) {
                onError(e2);
            }
        }
    }
}
