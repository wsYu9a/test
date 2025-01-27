package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: i */
    public static final int f20661i = 1;

    /* renamed from: a */
    public final u f20662a;

    /* renamed from: b */
    public final c f20663b;

    /* renamed from: f */
    public volatile Thread f20667f;

    /* renamed from: g */
    public volatile boolean f20668g;

    /* renamed from: c */
    public final Object f20664c = new Object();

    /* renamed from: d */
    public final Object f20665d = new Object();

    /* renamed from: h */
    public volatile int f20669h = -1;

    /* renamed from: e */
    public final AtomicInteger f20666e = new AtomicInteger();

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.e();
        }

        public /* synthetic */ b(p pVar, a aVar) {
            this();
        }
    }

    public p(u uVar, c cVar) {
        this.f20662a = (u) o.a(uVar);
        this.f20663b = (c) o.a(cVar);
    }

    public void a(int i10) {
    }

    public final void b() {
        try {
            this.f20662a.close();
        } catch (q e10) {
            b(new q("Error closing source " + this.f20662a, e10));
        }
    }

    public void c(Throwable th2) {
    }

    public final void d() {
        this.f20669h = 100;
        a(this.f20669h);
    }

    public final void e() {
        long j10 = -1;
        long j11 = 0;
        try {
            j11 = this.f20663b.a();
            this.f20662a.a(j11);
            j10 = this.f20662a.d();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.f20662a.read(bArr);
                if (read == -1) {
                    h();
                    d();
                    b();
                    a(j11, j10);
                    synchronized (this.f20664c) {
                        this.f20664c.notifyAll();
                    }
                    return;
                }
                synchronized (this.f20665d) {
                    if (c()) {
                        SigmobLog.d("SourceReaderRunnable停止从服务器下载视频数据");
                        b();
                        a(j11, j10);
                        synchronized (this.f20664c) {
                            this.f20664c.notifyAll();
                        }
                        return;
                    }
                    this.f20663b.a(bArr, read);
                }
                j11 += read;
                a(j11, j10);
            }
        } catch (Throwable th2) {
            try {
                this.f20666e.incrementAndGet();
                b(th2);
                a(th2);
                b();
                a(j11, j10);
                synchronized (this.f20664c) {
                    this.f20664c.notifyAll();
                }
            } catch (Throwable th3) {
                b();
                a(j11, j10);
                synchronized (this.f20664c) {
                    this.f20664c.notifyAll();
                    throw th3;
                }
            }
        }
    }

    public final synchronized void f() throws q {
        try {
            boolean z10 = (this.f20667f == null || this.f20667f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.f20668g && !this.f20663b.b() && !z10) {
                SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
                this.f20667f = new Thread(new b(), "Source reader for " + this.f20662a);
                this.f20667f.start();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void g() {
        synchronized (this.f20665d) {
            try {
                SigmobLog.d("Shutdown proxy for " + this.f20662a);
                try {
                    this.f20668g = true;
                    if (this.f20667f != null) {
                        this.f20667f.interrupt();
                    }
                    this.f20663b.close();
                } catch (q e10) {
                    b(e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h() throws q {
        synchronized (this.f20665d) {
            try {
                if (!c() && this.f20663b.a() == this.f20662a.d()) {
                    this.f20663b.c();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i() throws q {
        synchronized (this.f20664c) {
            try {
                try {
                    this.f20664c.wait(1000L);
                } catch (InterruptedException e10) {
                    throw new q("Waiting source data is interrupted!", e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(long j10, long j11) {
        int i10 = j11 == 0 ? 100 : (int) ((j10 / j11) * 100.0f);
        boolean z10 = i10 != this.f20669h;
        if (j11 >= 0 && z10) {
            a(i10);
        }
        this.f20669h = i10;
    }

    public final boolean c() {
        return Thread.currentThread().isInterrupted() || this.f20668g;
    }

    public final void a() throws q {
        int i10 = this.f20666e.get();
        if (i10 < 1) {
            return;
        }
        this.f20666e.set(0);
        throw new q("Error reading source " + i10 + " times");
    }

    public final void b(Throwable th2) {
        if (th2 instanceof l) {
            SigmobLog.d("ProxyCache is interrupted");
        } else {
            SigmobLog.e("ProxyCache error", th2);
        }
    }

    public final void a(Throwable th2) {
        c(th2);
    }

    public final void a(long j10, long j11) {
        b(j10, j11);
        synchronized (this.f20664c) {
            this.f20664c.notifyAll();
        }
    }

    public int a(byte[] bArr, long j10, int i10) throws q {
        r.a(bArr, j10, i10);
        while (!this.f20663b.b() && this.f20663b.a() < i10 + j10 && !this.f20668g) {
            f();
            i();
            a();
        }
        int a10 = this.f20663b.a(bArr, j10, i10);
        if (this.f20663b.b() && this.f20669h != 100) {
            this.f20669h = 100;
            a(100);
        }
        return a10;
    }
}
