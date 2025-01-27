package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: q */
    public static final ExecutorService f19234q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Cancel Block", false));

    /* renamed from: r */
    public static final String f19235r = "DownloadChain";

    /* renamed from: a */
    public final int f19236a;

    /* renamed from: b */
    public final com.sigmob.sdk.downloader.f f19237b;

    /* renamed from: c */
    public final com.sigmob.sdk.downloader.core.breakpoint.c f19238c;

    /* renamed from: d */
    public final d f19239d;

    /* renamed from: i */
    public long f19244i;

    /* renamed from: j */
    public volatile com.sigmob.sdk.downloader.core.connection.a f19245j;

    /* renamed from: k */
    public long f19246k;

    /* renamed from: l */
    public volatile Thread f19247l;

    /* renamed from: n */
    public final j f19249n;

    /* renamed from: e */
    public final List<c.a> f19240e = new ArrayList();

    /* renamed from: f */
    public final List<c.b> f19241f = new ArrayList();

    /* renamed from: g */
    public int f19242g = 0;

    /* renamed from: h */
    public int f19243h = 0;

    /* renamed from: o */
    public final AtomicBoolean f19250o = new AtomicBoolean(false);

    /* renamed from: p */
    public final Runnable f19251p = new a();

    /* renamed from: m */
    public final com.sigmob.sdk.downloader.core.dispatcher.a f19248m = com.sigmob.sdk.downloader.g.j().b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.p();
        }
    }

    public f(int i10, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        this.f19236a = i10;
        this.f19237b = fVar;
        this.f19239d = dVar;
        this.f19238c = cVar;
        this.f19249n = jVar;
    }

    public void a() {
        if (this.f19250o.get() || this.f19247l == null) {
            return;
        }
        this.f19247l.interrupt();
    }

    public void b() {
        if (this.f19246k == 0) {
            return;
        }
        this.f19248m.a().b(this.f19237b, this.f19236a, this.f19246k);
        this.f19246k = 0L;
    }

    public int c() {
        return this.f19236a;
    }

    public d d() {
        return this.f19239d;
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a e() {
        return this.f19245j;
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a f() throws IOException {
        try {
            if (this.f19239d.f()) {
                throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
            }
            if (this.f19245j == null) {
                String c10 = this.f19239d.c();
                if (c10 == null) {
                    c10 = this.f19238c.k();
                }
                com.sigmob.sdk.downloader.core.c.a(f19235r, "create connection on url: " + c10);
                this.f19245j = com.sigmob.sdk.downloader.g.j().c().a(c10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f19245j;
    }

    public j g() {
        return this.f19249n;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c h() {
        return this.f19238c;
    }

    public com.sigmob.sdk.downloader.core.file.d i() {
        return this.f19239d.a();
    }

    public long j() {
        return this.f19244i;
    }

    public com.sigmob.sdk.downloader.f k() {
        return this.f19237b;
    }

    public boolean l() {
        return this.f19250o.get();
    }

    public long m() throws IOException {
        if (this.f19243h == this.f19241f.size()) {
            this.f19243h--;
        }
        return o();
    }

    public a.InterfaceC0584a n() throws IOException {
        if (this.f19239d.f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        List<c.a> list = this.f19240e;
        int i10 = this.f19242g;
        this.f19242g = i10 + 1;
        return list.get(i10).b(this);
    }

    public long o() throws IOException {
        if (this.f19239d.f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        List<c.b> list = this.f19241f;
        int i10 = this.f19243h;
        this.f19243h = i10 + 1;
        return list.get(i10).a(this);
    }

    public synchronized void p() {
        try {
            if (this.f19245j != null) {
                this.f19245j.a();
                com.sigmob.sdk.downloader.core.c.a(f19235r, "release connection " + this.f19245j + " task[" + this.f19237b.b() + "] block[" + this.f19236a + "]");
            }
            this.f19245j = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void q() {
        f19234q.execute(this.f19251p);
    }

    public void r() {
        this.f19242g = 1;
        p();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (l()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.f19247l = Thread.currentThread();
        try {
            s();
        } catch (IOException unused) {
        } catch (Throwable th2) {
            this.f19250o.set(true);
            q();
            throw th2;
        }
        this.f19250o.set(true);
        q();
    }

    public void s() throws IOException {
        com.sigmob.sdk.downloader.core.dispatcher.a b10 = com.sigmob.sdk.downloader.g.j().b();
        com.sigmob.sdk.downloader.core.interceptor.d dVar = new com.sigmob.sdk.downloader.core.interceptor.d();
        com.sigmob.sdk.downloader.core.interceptor.a aVar = new com.sigmob.sdk.downloader.core.interceptor.a();
        this.f19240e.add(dVar);
        this.f19240e.add(aVar);
        this.f19240e.add(new com.sigmob.sdk.downloader.core.interceptor.connect.b());
        this.f19240e.add(new com.sigmob.sdk.downloader.core.interceptor.connect.a());
        this.f19242g = 0;
        a.InterfaceC0584a n10 = n();
        if (this.f19239d.f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        b10.a().a(this.f19237b, this.f19236a, j());
        com.sigmob.sdk.downloader.core.interceptor.b bVar = new com.sigmob.sdk.downloader.core.interceptor.b(this.f19236a, n10.c(), i(), this.f19237b);
        this.f19241f.add(dVar);
        this.f19241f.add(aVar);
        this.f19241f.add(bVar);
        this.f19243h = 0;
        b10.a().d(this.f19237b, this.f19236a, o());
    }

    public static f a(int i10, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        return new f(i10, fVar, cVar, dVar, jVar);
    }

    public void b(long j10) {
        this.f19244i = j10;
    }

    public void a(long j10) {
        this.f19246k += j10;
    }

    public synchronized void a(com.sigmob.sdk.downloader.core.connection.a aVar) {
        this.f19245j = aVar;
    }

    public void a(String str) {
        this.f19239d.a(str);
    }
}
