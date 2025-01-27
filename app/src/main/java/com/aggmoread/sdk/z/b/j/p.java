package com.aggmoread.sdk.z.b.j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class p extends Thread implements com.aggmoread.sdk.z.b.p.c {

    /* renamed from: b */
    private n f4644b;

    /* renamed from: h */
    private com.aggmoread.sdk.z.b.p.d f4650h;

    /* renamed from: c */
    private AtomicBoolean f4645c = new AtomicBoolean(false);

    /* renamed from: d */
    private int f4646d = 3;

    /* renamed from: e */
    private final AtomicInteger f4647e = new AtomicInteger(0);

    /* renamed from: f */
    private final AtomicBoolean f4648f = new AtomicBoolean(false);

    /* renamed from: g */
    private final AtomicBoolean f4649g = new AtomicBoolean(true);

    /* renamed from: i */
    private long f4651i = 0;

    private p() {
        setName("AdSdk-api-downtask");
    }

    public static p b() {
        p pVar = new p();
        pVar.f4649g.set(true);
        return pVar;
    }

    public void a(n nVar) {
        com.aggmoread.sdk.z.b.d.c("DownloadTask", "startDownload enter , isStarted = " + this.f4645c.get());
        if (this.f4645c.compareAndSet(false, true)) {
            this.f4644b = nVar;
            start();
        }
    }

    public void c() {
        this.f4645c.set(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z10;
        i e10;
        String message;
        int i10;
        h hVar = null;
        h th2 = null;
        while (true) {
            if (this.f4647e.get() >= this.f4646d) {
                hVar = th2;
                break;
            }
            com.aggmoread.sdk.z.b.d.c("DownloadTask", "currentRetryTimes = " + this.f4647e.get());
            try {
                com.aggmoread.sdk.z.b.d.c("DownloadTask", "download file = " + new j().a(this.f4644b));
                break;
            } catch (Throwable th3) {
                th2 = th3;
                th2.printStackTrace();
                this.f4647e.incrementAndGet();
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                }
            }
        }
        try {
            z10 = com.aggmoread.sdk.z.b.p.e.f(this.f4644b.c());
        } catch (Exception unused) {
            z10 = true;
        }
        com.aggmoread.sdk.z.b.d.c("DownloadTask", "download task end , isNetworkAvailable = " + z10 + " , rerun = " + this.f4648f.get() + " , isSupportNetworkStateMonitor = " + this.f4649g.get() + " , downloadThrowable = " + hVar);
        if (hVar != null) {
            if (this.f4649g.get() && !z10 && this.f4648f.compareAndSet(false, true)) {
                com.aggmoread.sdk.z.b.d.c("DownloadTask", "start ConnectivityMonitor");
                this.f4651i = System.currentTimeMillis();
                this.f4650h = com.aggmoread.sdk.z.b.p.d.a(this.f4644b.c(), this);
                return;
            }
            if (hVar instanceof h) {
                h hVar2 = hVar;
                e10 = this.f4644b.e();
                i10 = hVar2.a();
                message = hVar2.getMessage();
            } else {
                e10 = this.f4644b.e();
                message = hVar.getMessage();
                i10 = -999;
            }
            e10.a(i10, message);
        }
    }

    public static p b(boolean z10) {
        p pVar = new p();
        pVar.f4649g.set(z10);
        return pVar;
    }

    @Override // com.aggmoread.sdk.z.b.p.c
    public void a(boolean z10) {
        if (this.f4650h == null || !z10) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f4651i;
        com.aggmoread.sdk.z.b.d.c("DownloadTask", "ConnectivityMonitor onConnectivityChanged, restart , intervalTime = " + currentTimeMillis + " , startMonitorTime = " + this.f4651i);
        if (this.f4651i != 0 && currentTimeMillis >= 600000) {
            this.f4644b.e().a(-1017, "无网络超过10分钟不在重试下载!");
        } else {
            this.f4650h.c();
            b(false).a(this.f4644b);
        }
    }

    public boolean a() {
        return this.f4645c.get();
    }
}
