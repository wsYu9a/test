package com.sigmob.sdk.downloader.core.download;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class e extends com.sigmob.sdk.downloader.core.b implements Comparable<e> {

    /* renamed from: j */
    public static final ExecutorService f19223j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Block", false));

    /* renamed from: k */
    public static final String f19224k = "DownloadCall";

    /* renamed from: l */
    public static final int f19225l = 3;

    /* renamed from: b */
    public final com.sigmob.sdk.downloader.f f19226b;

    /* renamed from: c */
    public final boolean f19227c;

    /* renamed from: d */
    public final ArrayList<f> f19228d;

    /* renamed from: e */
    public volatile d f19229e;

    /* renamed from: f */
    public volatile boolean f19230f;

    /* renamed from: g */
    public volatile boolean f19231g;

    /* renamed from: h */
    public volatile Thread f19232h;

    /* renamed from: i */
    public final j f19233i;

    public e(com.sigmob.sdk.downloader.f fVar, boolean z10, j jVar) {
        this(fVar, z10, new ArrayList(), jVar);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    public void a(InterruptedException interruptedException) {
    }

    public b b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(this.f19226b, cVar);
    }

    public boolean c() {
        synchronized (this) {
            try {
                if (this.f19230f) {
                    return true;
                }
                if (this.f19231g) {
                    return false;
                }
                this.f19230f = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                com.sigmob.sdk.downloader.g.j().e().b(this);
                d dVar = this.f19229e;
                if (dVar != null) {
                    dVar.m();
                }
                Object[] array = this.f19228d.toArray();
                if (array != null && array.length != 0) {
                    for (Object obj : array) {
                        if (obj instanceof f) {
                            ((f) obj).a();
                        }
                    }
                } else if (this.f19232h != null) {
                    com.sigmob.sdk.downloader.core.c.a(f19224k, "interrupt thread with cancel operation because of chains are not running " + this.f19226b.b());
                    this.f19232h.interrupt();
                }
                if (dVar != null) {
                    dVar.a().b();
                }
                com.sigmob.sdk.downloader.core.c.a(f19224k, "cancel task " + this.f19226b.b() + " consume: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public File d() {
        return this.f19226b.z();
    }

    public int e() {
        return this.f19226b.r();
    }

    public final void f() {
        this.f19233i.b(this.f19226b.b());
        com.sigmob.sdk.downloader.g.j().b().a().a(this.f19226b);
    }

    public boolean g() {
        return this.f19230f;
    }

    public boolean h() {
        return this.f19231g;
    }

    public e(com.sigmob.sdk.downloader.f fVar, boolean z10, ArrayList<f> arrayList, j jVar) {
        super("download call: " + fVar.b());
        this.f19226b = fVar;
        this.f19227c = z10;
        this.f19228d = arrayList;
        this.f19233i = jVar;
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, b bVar, com.sigmob.sdk.downloader.core.cause.b bVar2) {
        com.sigmob.sdk.downloader.core.c.a(this.f19226b, cVar, bVar.e(), bVar.f());
        com.sigmob.sdk.downloader.g.j().b().a().a(this.f19226b, cVar, bVar2);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    public void b() {
        com.sigmob.sdk.downloader.g.j().e().a(this);
        com.sigmob.sdk.downloader.core.c.a(f19224k, "call is finished " + this.f19226b.b());
    }

    public void c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        f.c.a(this.f19226b, cVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        return eVar.e() - e();
    }

    public static e a(com.sigmob.sdk.downloader.f fVar, boolean z10, j jVar) {
        return new e(fVar, z10, jVar);
    }

    public d a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new d(com.sigmob.sdk.downloader.g.j().i().a(this.f19226b, cVar, this.f19233i));
    }

    public a a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j10) {
        return new a(this.f19226b, cVar, j10);
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        return this.f19226b.equals(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0166 A[EDGE_INSN: B:36:0x0166->B:37:0x0166 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[LOOP:0: B:2:0x0013->B:60:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0166 A[EDGE_INSN: B:64:0x0166->B:37:0x0166 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    @Override // com.sigmob.sdk.downloader.core.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.download.e.a():void");
    }

    public final void a(d dVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            try {
                if (this.f19230f) {
                    return;
                }
                this.f19231g = true;
                this.f19233i.a(this.f19226b.b(), aVar, exc);
                if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
                    this.f19233i.e(this.f19226b.b());
                    com.sigmob.sdk.downloader.g.j().i().a(dVar.a(), this.f19226b);
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(this.f19226b, aVar, exc);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(d dVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) throws InterruptedException {
        int b10 = cVar.b();
        ArrayList arrayList = new ArrayList(cVar.b());
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < b10; i10++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b11 = cVar.b(i10);
            if (!com.sigmob.sdk.downloader.core.c.a(b11.c(), b11.b())) {
                com.sigmob.sdk.downloader.core.c.a(b11);
                f a10 = f.a(i10, this.f19226b, cVar, dVar, this.f19233i);
                arrayList.add(a10);
                arrayList2.add(Integer.valueOf(a10.c()));
            }
        }
        if (this.f19230f) {
            return;
        }
        dVar.a().a(arrayList2);
        a(arrayList);
    }

    public void a(List<f> list) throws InterruptedException {
        ArrayList arrayList = new ArrayList(list.size());
        try {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.f19228d.addAll(list);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Future future = (Future) it2.next();
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
            this.f19228d.removeAll(list);
        } catch (Throwable th2) {
            try {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((Future) it3.next()).cancel(true);
                }
                throw th2;
            } finally {
                this.f19228d.removeAll(list);
            }
        }
    }

    public Future<?> a(f fVar) {
        return f19223j.submit(fVar);
    }
}
