package com.sigmob.sdk.downloader.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: y */
    public static final String f19280y = "MultiPointOutputStream";

    /* renamed from: z */
    public static final ExecutorService f19281z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload file io", false));

    /* renamed from: a */
    public final SparseArray<com.sigmob.sdk.downloader.core.file.a> f19282a;

    /* renamed from: b */
    public final SparseArray<AtomicLong> f19283b;

    /* renamed from: c */
    public final AtomicLong f19284c;

    /* renamed from: d */
    public final AtomicLong f19285d;

    /* renamed from: e */
    public boolean f19286e;

    /* renamed from: f */
    public final int f19287f;

    /* renamed from: g */
    public final int f19288g;

    /* renamed from: h */
    public final int f19289h;

    /* renamed from: i */
    public final com.sigmob.sdk.downloader.core.breakpoint.c f19290i;

    /* renamed from: j */
    public final f f19291j;

    /* renamed from: k */
    public final j f19292k;

    /* renamed from: l */
    public final boolean f19293l;

    /* renamed from: m */
    public final boolean f19294m;

    /* renamed from: n */
    public volatile Future f19295n;

    /* renamed from: o */
    public volatile Thread f19296o;

    /* renamed from: p */
    public final SparseArray<Thread> f19297p;

    /* renamed from: q */
    public final Runnable f19298q;

    /* renamed from: r */
    public String f19299r;

    /* renamed from: s */
    public IOException f19300s;

    /* renamed from: t */
    public ArrayList<Integer> f19301t;

    /* renamed from: u */
    public List<Integer> f19302u;

    /* renamed from: v */
    public final c f19303v;

    /* renamed from: w */
    public c f19304w;

    /* renamed from: x */
    public volatile boolean f19305x;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a();
        }
    }

    public static class c {

        /* renamed from: a */
        public boolean f19308a;

        /* renamed from: b */
        public List<Integer> f19309b = new ArrayList();

        /* renamed from: c */
        public List<Integer> f19310c = new ArrayList();

        public boolean a() {
            return this.f19308a || this.f19310c.size() > 0;
        }
    }

    public d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar) {
        this(fVar, cVar, jVar, null);
    }

    public synchronized void a() {
        List<Integer> list = this.f19302u;
        if (list == null) {
            return;
        }
        if (this.f19286e) {
            return;
        }
        this.f19286e = true;
        this.f19301t.addAll(list);
        try {
            if (this.f19284c.get() <= 0) {
                for (Integer num : this.f19302u) {
                    try {
                        b(num.intValue());
                    } catch (IOException e10) {
                        com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream close failed task[" + this.f19291j.b() + "] block[" + num + "]" + e10);
                    }
                }
                this.f19292k.a(this.f19291j.b(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                return;
            }
            if (this.f19295n != null && !this.f19295n.isDone()) {
                g();
                g.j().i().a().b(this.f19299r);
                try {
                    a(true, -1);
                    g.j().i().a().a(this.f19299r);
                } catch (Throwable th2) {
                    g.j().i().a().a(this.f19299r);
                    throw th2;
                }
            }
            for (Integer num2 : this.f19302u) {
                try {
                    b(num2.intValue());
                } catch (IOException e11) {
                    com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream close failed task[" + this.f19291j.b() + "] block[" + num2 + "]" + e11);
                }
            }
            this.f19292k.a(this.f19291j.b(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
            return;
        } finally {
        }
    }

    public void b() {
        f19281z.execute(new b());
    }

    public synchronized void c(int i10) throws IOException {
        StringBuilder sb2;
        this.f19301t.add(Integer.valueOf(i10));
        try {
            IOException iOException = this.f19300s;
            if (iOException != null) {
                throw iOException;
            }
            if (this.f19295n == null || this.f19295n.isDone()) {
                if (this.f19295n == null) {
                    sb2 = new StringBuilder();
                    sb2.append("OutputStream done but no need to ensure sync, because the sync job not run yet. task[");
                    sb2.append(this.f19291j.b());
                    sb2.append("] block[");
                    sb2.append(i10);
                    sb2.append("]");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("OutputStream done but no need to ensure sync, because the syncFuture.isDone[");
                    sb2.append(this.f19295n.isDone());
                    sb2.append("] task[");
                    sb2.append(this.f19291j.b());
                    sb2.append("] block[");
                    sb2.append(i10);
                    sb2.append("]");
                }
                com.sigmob.sdk.downloader.core.c.a(f19280y, sb2.toString());
            } else {
                AtomicLong atomicLong = this.f19283b.get(i10);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.f19303v);
                    a(this.f19303v.f19308a, i10);
                }
            }
            b(i10);
        } catch (Throwable th2) {
            b(i10);
            throw th2;
        }
    }

    public void d() throws IOException {
        long j10;
        synchronized (this.f19283b) {
            int size = this.f19283b.size();
            SparseArray sparseArray = new SparseArray(size);
            int i10 = 0;
            while (true) {
                j10 = 0;
                if (i10 >= size) {
                    break;
                }
                try {
                    int keyAt = this.f19283b.keyAt(i10);
                    long j11 = this.f19283b.get(keyAt).get();
                    if (j11 > 0) {
                        sparseArray.put(keyAt, Long.valueOf(j11));
                        this.f19282a.get(keyAt).a();
                    }
                    i10++;
                } catch (IOException e10) {
                    com.sigmob.sdk.downloader.core.c.c(f19280y, "OutputStream flush and sync data to filesystem failed " + e10);
                }
            }
            int size2 = sparseArray.size();
            for (int i11 = 0; i11 < size2; i11++) {
                int keyAt2 = sparseArray.keyAt(i11);
                long longValue = ((Long) sparseArray.valueAt(i11)).longValue();
                this.f19292k.a(this.f19290i, keyAt2, longValue);
                j10 += longValue;
                this.f19283b.get(keyAt2).addAndGet(-longValue);
                com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream sync success (" + this.f19291j.b() + ") block(" + keyAt2 + ")  syncLength(" + longValue + ") currentOffset(" + this.f19290i.b(keyAt2).c() + ")");
            }
            this.f19284c.addAndGet(-j10);
            this.f19285d.set(SystemClock.uptimeMillis());
        }
    }

    public long e() {
        return this.f19289h - (j() - this.f19285d.get());
    }

    public void f() throws IOException {
        IOException iOException = this.f19300s;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f19295n == null) {
            synchronized (this.f19298q) {
                try {
                    if (this.f19295n == null) {
                        this.f19295n = c();
                    }
                } finally {
                }
            }
        }
    }

    public final void g() {
        if (this.f19299r != null || this.f19291j.z() == null) {
            return;
        }
        this.f19299r = this.f19291j.z().getAbsolutePath();
    }

    public boolean h() {
        return this.f19284c.get() < ((long) this.f19288g);
    }

    public boolean i() {
        return this.f19296o != null;
    }

    public long j() {
        return SystemClock.uptimeMillis();
    }

    public void k() {
        LockSupport.park();
    }

    public void l() throws IOException {
        com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream start flush looper task[" + this.f19291j.b() + "] with syncBufferIntervalMills[" + this.f19289h + "] syncBufferSize[" + this.f19288g + "]");
        this.f19296o = Thread.currentThread();
        long j10 = (long) this.f19289h;
        d();
        while (true) {
            a(j10);
            a(this.f19304w);
            if (this.f19304w.a()) {
                com.sigmob.sdk.downloader.core.c.a(f19280y, "runSync state change isNoMoreStream[" + this.f19304w.f19308a + "] newNoMoreStreamBlockList[" + this.f19304w.f19310c + "]");
                if (this.f19284c.get() > 0) {
                    d();
                }
                for (Integer num : this.f19304w.f19310c) {
                    Thread thread = this.f19297p.get(num.intValue());
                    this.f19297p.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.f19304w.f19308a) {
                    break;
                }
            } else {
                if (!h()) {
                    j10 = e();
                    if (j10 <= 0) {
                        d();
                    }
                }
                j10 = this.f19289h;
            }
        }
        int size = this.f19297p.size();
        for (int i10 = 0; i10 < size; i10++) {
            Thread valueAt = this.f19297p.valueAt(i10);
            if (valueAt != null) {
                a(valueAt);
            }
        }
        this.f19297p.clear();
        com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream stop flush looper task[" + this.f19291j.b() + "]");
    }

    public void m() {
        try {
            l();
        } catch (IOException e10) {
            this.f19300s = e10;
            com.sigmob.sdk.downloader.core.c.c(f19280y, "Sync to breakpoint-store for task[" + this.f19291j.b() + "] failed with cause: " + e10);
        }
    }

    public d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar, Runnable runnable) {
        this.f19282a = new SparseArray<>();
        this.f19283b = new SparseArray<>();
        this.f19284c = new AtomicLong();
        this.f19285d = new AtomicLong();
        this.f19286e = false;
        this.f19297p = new SparseArray<>();
        this.f19303v = new c();
        this.f19304w = new c();
        this.f19305x = true;
        this.f19291j = fVar;
        this.f19287f = fVar.l();
        this.f19288g = fVar.x();
        this.f19289h = fVar.w();
        this.f19290i = cVar;
        this.f19292k = jVar;
        this.f19293l = g.j().h().a();
        this.f19294m = g.j().i().b(fVar);
        this.f19301t = new ArrayList<>();
        if (runnable == null) {
            this.f19298q = new a();
        } else {
            this.f19298q = runnable;
        }
        File z10 = fVar.z();
        if (z10 != null) {
            this.f19299r = z10.getAbsolutePath();
        }
    }

    public void a(int i10) {
        this.f19301t.add(Integer.valueOf(i10));
    }

    public synchronized void b(int i10) throws IOException {
        com.sigmob.sdk.downloader.core.file.a aVar = this.f19282a.get(i10);
        if (aVar != null) {
            aVar.close();
            synchronized (this.f19283b) {
                this.f19282a.remove(i10);
                this.f19283b.remove(i10);
            }
            com.sigmob.sdk.downloader.core.c.a(f19280y, "OutputStream close task[" + this.f19291j.b() + "] block[" + i10 + "]");
        }
    }

    public Future c() {
        return f19281z.submit(this.f19298q);
    }

    public void d(int i10) throws IOException {
        com.sigmob.sdk.downloader.core.breakpoint.a b10 = this.f19290i.b(i10);
        if (b10.b() == -1 || com.sigmob.sdk.downloader.core.c.a(b10.c(), b10.b())) {
            return;
        }
        throw new IOException("The current offset on block-info isn't update correct, " + b10.c() + " != " + b10.b() + " on " + i10);
    }

    public synchronized com.sigmob.sdk.downloader.core.file.a e(int i10) throws IOException {
        com.sigmob.sdk.downloader.core.file.a aVar;
        Uri A;
        try {
            aVar = this.f19282a.get(i10);
            if (aVar == null) {
                boolean d10 = com.sigmob.sdk.downloader.core.c.d(this.f19291j.A());
                if (d10) {
                    File z10 = this.f19291j.z();
                    if (z10 == null) {
                        throw new FileNotFoundException("Filename is not ready!");
                    }
                    File c10 = this.f19291j.c();
                    if (!c10.exists() && !c10.mkdirs()) {
                        throw new IOException("Create parent folder failed!");
                    }
                    if (z10.createNewFile()) {
                        com.sigmob.sdk.downloader.core.c.a(f19280y, "Create new file: " + z10.getName());
                    }
                    A = Uri.fromFile(z10);
                } else {
                    A = this.f19291j.A();
                }
                com.sigmob.sdk.downloader.core.file.a a10 = g.j().h().a(g.j().d(), A, this.f19287f);
                if (this.f19293l) {
                    long d11 = this.f19290i.b(i10).d();
                    if (d11 > 0) {
                        a10.b(d11);
                        com.sigmob.sdk.downloader.core.c.a(f19280y, "Create output stream write from (" + this.f19291j.b() + ") block(" + i10 + ") " + d11);
                    }
                }
                if (this.f19305x) {
                    this.f19292k.c(this.f19291j.b());
                }
                if (!this.f19290i.l() && this.f19305x && this.f19294m) {
                    long i11 = this.f19290i.i();
                    if (d10) {
                        File z11 = this.f19291j.z();
                        long length = i11 - z11.length();
                        if (length > 0) {
                            a(new StatFs(z11.getAbsolutePath()), length);
                        }
                    }
                    a10.a(i11);
                }
                synchronized (this.f19283b) {
                    this.f19282a.put(i10, a10);
                    this.f19283b.put(i10, new AtomicLong());
                }
                this.f19305x = false;
                aVar = a10;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    public void a(boolean z10, int i10) {
        if (this.f19295n == null || this.f19295n.isDone()) {
            return;
        }
        if (!z10) {
            this.f19297p.put(i10, Thread.currentThread());
        }
        if (this.f19296o == null) {
            while (!i()) {
                a(25L);
            }
        }
        a(this.f19296o);
        if (!z10) {
            k();
            return;
        }
        a(this.f19296o);
        try {
            this.f19295n.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void a(StatFs statFs, long j10) throws com.sigmob.sdk.downloader.core.exception.e {
        long a10 = com.sigmob.sdk.downloader.core.c.a(statFs);
        if (a10 < j10) {
            throw new com.sigmob.sdk.downloader.core.exception.e(j10, a10);
        }
    }

    public void a(c cVar) {
        cVar.f19310c.clear();
        int size = new HashSet((List) this.f19301t.clone()).size();
        if (size != this.f19302u.size()) {
            com.sigmob.sdk.downloader.core.c.a(f19280y, "task[" + this.f19291j.b() + "] current need fetching block count " + this.f19302u.size() + " is not equal to no more stream block count " + size);
            cVar.f19308a = false;
        } else {
            com.sigmob.sdk.downloader.core.c.a(f19280y, "task[" + this.f19291j.b() + "] current need fetching block count " + this.f19302u.size() + " is equal to no more stream block count " + size);
            cVar.f19308a = true;
        }
        SparseArray<com.sigmob.sdk.downloader.core.file.a> clone = this.f19282a.clone();
        int size2 = clone.size();
        for (int i10 = 0; i10 < size2; i10++) {
            int keyAt = clone.keyAt(i10);
            if (this.f19301t.contains(Integer.valueOf(keyAt)) && !cVar.f19309b.contains(Integer.valueOf(keyAt))) {
                cVar.f19309b.add(Integer.valueOf(keyAt));
                cVar.f19310c.add(Integer.valueOf(keyAt));
            }
        }
    }

    public void a(long j10) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j10));
    }

    public void a(List<Integer> list) {
        this.f19302u = list;
    }

    public void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public synchronized void a(int i10, byte[] bArr, int i11) throws IOException {
        if (this.f19286e) {
            return;
        }
        e(i10).write(bArr, 0, i11);
        long j10 = i11;
        this.f19284c.addAndGet(j10);
        this.f19283b.get(i10).addAndGet(j10);
        f();
    }
}
