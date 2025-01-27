package com.martian.ttbook.b.a.i;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class p extends Thread implements b.d.e.c.a.j.c {

    /* renamed from: a */
    private n f15035a;

    /* renamed from: g */
    private b.d.e.c.a.j.d f15041g;

    /* renamed from: b */
    private AtomicBoolean f15036b = new AtomicBoolean(false);

    /* renamed from: c */
    private int f15037c = 3;

    /* renamed from: d */
    private final AtomicInteger f15038d = new AtomicInteger(0);

    /* renamed from: e */
    private final AtomicBoolean f15039e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicBoolean f15040f = new AtomicBoolean(true);

    /* renamed from: h */
    private long f15042h = 0;

    private p() {
        setName("AdSdk-api-downtask");
    }

    public static p d() {
        p pVar = new p();
        pVar.f15040f.set(true);
        return pVar;
    }

    public static p e(boolean z) {
        p pVar = new p();
        pVar.f15040f.set(z);
        return pVar;
    }

    public void a(n nVar) {
        b.d.e.c.a.d.k("DownloadTask", "startDownload enter , isStarted = " + this.f15036b.get());
        if (this.f15036b.compareAndSet(false, true)) {
            this.f15035a = nVar;
            start();
        }
    }

    @Override // b.d.e.c.a.j.c
    public void a(boolean z) {
        if (this.f15041g == null || !z) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f15042h;
        b.d.e.c.a.d.k("DownloadTask", "ConnectivityMonitor onConnectivityChanged, restart , intervalTime = " + currentTimeMillis + " , startMonitorTime = " + this.f15042h);
        if (this.f15042h != 0 && currentTimeMillis >= TTAdConstant.AD_MAX_EVENT_TIME) {
            this.f15035a.p().c(-1017, "无网络超过10分钟不在重试下载!");
        } else {
            this.f15041g.f();
            e(false).a(this.f15035a);
        }
    }

    public boolean c() {
        return this.f15036b.get();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        i p;
        String message;
        int i2;
        h hVar = null;
        h th = null;
        while (true) {
            if (this.f15038d.get() >= this.f15037c) {
                hVar = th;
                break;
            }
            b.d.e.c.a.d.k("DownloadTask", "currentRetryTimes = " + this.f15038d.get());
            try {
                b.d.e.c.a.d.k("DownloadTask", "download file = " + new j().b(this.f15035a));
                break;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                this.f15038d.incrementAndGet();
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            z = b.d.e.c.a.j.e.g(this.f15035a.j());
        } catch (Exception unused) {
            z = true;
        }
        b.d.e.c.a.d.k("DownloadTask", "download task end , isNetworkAvailable = " + z + " , rerun = " + this.f15039e.get() + " , isSupportNetworkStateMonitor = " + this.f15040f.get() + " , downloadThrowable = " + hVar);
        if (hVar != null) {
            if (this.f15040f.get() && !z && this.f15039e.compareAndSet(false, true)) {
                b.d.e.c.a.d.k("DownloadTask", "start ConnectivityMonitor");
                this.f15042h = System.currentTimeMillis();
                this.f15041g = b.d.e.c.a.j.d.b(this.f15035a.j(), this);
                return;
            }
            if (hVar instanceof h) {
                h hVar2 = hVar;
                p = this.f15035a.p();
                i2 = hVar2.a();
                message = hVar2.getMessage();
            } else {
                p = this.f15035a.p();
                message = hVar.getMessage();
                i2 = -999;
            }
            p.c(i2, message);
        }
    }
}
