package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.c;
import com.sigmob.sdk.downloader.core.download.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import com.sigmob.sdk.downloader.l;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: j */
    public static final String f19181j = "DownloadDispatcher";

    /* renamed from: a */
    public int f19182a;

    /* renamed from: b */
    public final List<e> f19183b;

    /* renamed from: c */
    public final List<e> f19184c;

    /* renamed from: d */
    public final List<e> f19185d;

    /* renamed from: e */
    public final List<e> f19186e;

    /* renamed from: f */
    public final AtomicInteger f19187f;

    /* renamed from: g */
    public volatile ExecutorService f19188g;

    /* renamed from: h */
    public final AtomicInteger f19189h;

    /* renamed from: i */
    public j f19190i;

    public b() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    public void a(com.sigmob.sdk.downloader.core.a[] aVarArr) {
        this.f19189h.incrementAndGet();
        b(aVarArr);
        this.f19189h.decrementAndGet();
        c();
    }

    public final synchronized void b(com.sigmob.sdk.downloader.core.a[] aVarArr) {
        long uptimeMillis = SystemClock.uptimeMillis();
        c.a(f19181j, "start cancel bunch task manually: " + aVarArr.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (com.sigmob.sdk.downloader.core.a aVar : aVarArr) {
                a(aVar, arrayList, arrayList2);
            }
        } finally {
            a(arrayList, arrayList2);
            c.a(f19181j, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        }
    }

    public final synchronized void c(f fVar) {
        c.a(f19181j, "enqueueLocked for single task: " + fVar);
        if (f(fVar)) {
            return;
        }
        if (g(fVar)) {
            return;
        }
        int size = this.f19183b.size();
        b(fVar);
        if (size != this.f19183b.size()) {
            Collections.sort(this.f19183b);
        }
    }

    public void d(f fVar) {
        c.a(f19181j, "execute: " + fVar);
        synchronized (this) {
            try {
                if (f(fVar)) {
                    return;
                }
                if (g(fVar)) {
                    return;
                }
                e a10 = e.a(fVar, false, this.f19190i);
                this.f19185d.add(a10);
                c(a10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized f e(f fVar) {
        c.a(f19181j, "findSameTask: " + fVar.b());
        for (e eVar : this.f19183b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return eVar.f19226b;
            }
        }
        for (e eVar2 : this.f19184c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return eVar2.f19226b;
            }
        }
        for (e eVar3 : this.f19185d) {
            if (!eVar3.g() && eVar3.a(fVar)) {
                return eVar3.f19226b;
            }
        }
        return null;
    }

    public boolean f(f fVar) {
        return a(fVar, (Collection<f>) null);
    }

    public final boolean g(f fVar) {
        return a(fVar, (Collection<f>) null, (Collection<f>) null);
    }

    public synchronized boolean h(f fVar) {
        c.a(f19181j, "isCanceled: " + fVar.b());
        for (e eVar : this.f19185d) {
            if (eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.f19184c) {
            if (eVar2.g() && eVar2.a(fVar)) {
                return true;
            }
        }
        for (e eVar3 : this.f19183b) {
            if (eVar3.g() && eVar3.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean i(f fVar) {
        f fVar2;
        File z10;
        f fVar3;
        File z11;
        c.a(f19181j, "is file conflict after run: " + fVar.b());
        File z12 = fVar.z();
        if (z12 == null) {
            return false;
        }
        for (e eVar : this.f19185d) {
            if (!eVar.g() && (fVar3 = eVar.f19226b) != fVar && (z11 = fVar3.z()) != null && z12.equals(z11)) {
                return true;
            }
        }
        for (e eVar2 : this.f19184c) {
            if (!eVar2.g() && (fVar2 = eVar2.f19226b) != fVar && (z10 = fVar2.z()) != null && z12.equals(z10)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean j(f fVar) {
        c.a(f19181j, "isPending: " + fVar.b());
        for (e eVar : this.f19183b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean k(f fVar) {
        c.a(f19181j, "isRunning: " + fVar.b());
        for (e eVar : this.f19185d) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.f19184c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public b(List<e> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f19182a = 5;
        this.f19187f = new AtomicInteger();
        this.f19189h = new AtomicInteger();
        this.f19183b = list;
        this.f19184c = list2;
        this.f19185d = list3;
        this.f19186e = list4;
    }

    public boolean a(int i10) {
        this.f19189h.incrementAndGet();
        boolean b10 = b(f.c(i10));
        this.f19189h.decrementAndGet();
        c();
        return b10;
    }

    public synchronized boolean b(com.sigmob.sdk.downloader.core.a aVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        c.a(f19181j, "cancel manually: " + aVar.b());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        try {
            a(aVar, arrayList, arrayList2);
            a(arrayList, arrayList2);
        } catch (Throwable th2) {
            a(arrayList, arrayList2);
            throw th2;
        }
        return arrayList.size() > 0 || arrayList2.size() > 0;
    }

    public final synchronized void c() {
        try {
            if (this.f19189h.get() > 0) {
                return;
            }
            if (d() >= this.f19182a) {
                return;
            }
            if (this.f19183b.isEmpty()) {
                return;
            }
            Iterator<e> it = this.f19183b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                it.remove();
                f fVar = next.f19226b;
                if (i(fVar)) {
                    g.j().b().a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                } else {
                    this.f19184c.add(next);
                    b().execute(next);
                    if (d() >= this.f19182a) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final int d() {
        return this.f19184c.size() - this.f19187f.get();
    }

    public boolean a(com.sigmob.sdk.downloader.core.a aVar) {
        this.f19189h.incrementAndGet();
        boolean b10 = b(aVar);
        this.f19189h.decrementAndGet();
        c();
        return b10;
    }

    public final synchronized void b(f fVar) {
        try {
            e a10 = e.a(fVar, true, this.f19190i);
            if (d() < this.f19182a) {
                this.f19184c.add(a10);
                b().execute(a10);
            } else {
                this.f19183b.add(a10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void c(e eVar) {
        eVar.run();
    }

    public void a() {
        this.f19189h.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.f19183b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f19226b);
        }
        Iterator<e> it2 = this.f19184c.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().f19226b);
        }
        Iterator<e> it3 = this.f19185d.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().f19226b);
        }
        if (!arrayList.isEmpty()) {
            b((com.sigmob.sdk.downloader.core.a[]) arrayList.toArray(new f[arrayList.size()]));
        }
        this.f19189h.decrementAndGet();
    }

    public final synchronized void b(f[] fVarArr) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            c.a(f19181j, "start enqueueLocked for bunch task: " + fVarArr.length);
            ArrayList<f> arrayList = new ArrayList();
            Collections.addAll(arrayList, fVarArr);
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            int size = this.f19183b.size();
            try {
                g.j().f().a();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (f fVar : arrayList) {
                    if (!a(fVar, arrayList2) && !a(fVar, (Collection<f>) arrayList3, (Collection<f>) arrayList4)) {
                        b(fVar);
                    }
                }
                g.j().b().a(arrayList2, arrayList3, arrayList4);
            } catch (UnknownHostException e10) {
                g.j().b().a(new ArrayList(arrayList), e10);
            }
            if (size != this.f19183b.size()) {
                Collections.sort(this.f19183b);
            }
            c.a(f19181j, "end enqueueLocked for bunch task: " + fVarArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(f fVar) {
        this.f19189h.incrementAndGet();
        c(fVar);
        this.f19189h.decrementAndGet();
    }

    public synchronized void b(e eVar) {
        c.a(f19181j, "flying canceled: " + eVar.f19226b.b());
        if (eVar.f19227c) {
            this.f19187f.incrementAndGet();
        }
    }

    public void a(f[] fVarArr) {
        this.f19189h.incrementAndGet();
        b(fVarArr);
        this.f19189h.decrementAndGet();
    }

    public synchronized ExecutorService b() {
        try {
            if (this.f19188g == null) {
                this.f19188g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("FileDownload Download", false));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f19188g;
    }

    public static void b(int i10) {
        b e10 = g.j().e();
        if (e10.getClass() == b.class) {
            e10.f19182a = Math.max(1, i10);
            return;
        }
        throw new IllegalStateException("The current dispatcher is " + e10 + " not DownloadDispatcher exactly!");
    }

    public final synchronized void a(com.sigmob.sdk.downloader.core.a aVar, List<e> list, List<e> list2) {
        try {
            Iterator<e> it = this.f19183b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                f fVar = next.f19226b;
                if (fVar != aVar && fVar.b() != aVar.b()) {
                }
                if (!next.g() && !next.h()) {
                    it.remove();
                    list.add(next);
                }
            }
            for (e eVar : this.f19184c) {
                f fVar2 = eVar.f19226b;
                if (fVar2 == aVar || fVar2.b() == aVar.b()) {
                    list.add(eVar);
                    list2.add(eVar);
                }
            }
            for (e eVar2 : this.f19185d) {
                f fVar3 = eVar2.f19226b;
                if (fVar3 == aVar || fVar3.b() == aVar.b()) {
                    list.add(eVar2);
                    list2.add(eVar2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(e eVar) {
        try {
            boolean z10 = eVar.f19227c;
            if (!(this.f19186e.contains(eVar) ? this.f19186e : z10 ? this.f19184c : this.f19185d).remove(eVar)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z10 && eVar.g()) {
                this.f19187f.decrementAndGet();
            }
            if (z10) {
                c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void a(List<e> list, List<e> list2) {
        try {
            c.a(f19181j, "handle cancel calls, cancel calls: " + list2.size());
            if (!list2.isEmpty()) {
                for (e eVar : list2) {
                    if (!eVar.c()) {
                        list.remove(eVar);
                    }
                }
            }
            c.a(f19181j, "handle cancel calls, callback cancel event: " + list.size());
            if (!list.isEmpty()) {
                if (list.size() <= 1) {
                    g.j().b().a().a(list.get(0).f19226b, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().f19226b);
                    }
                    g.j().b().a(arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean a(f fVar, Collection<f> collection) {
        if (!fVar.D() || !l.c(fVar)) {
            return false;
        }
        if (fVar.a() == null && !g.j().f().b(fVar)) {
            return false;
        }
        g.j().f().a(fVar, this.f19190i);
        if (collection != null) {
            collection.add(fVar);
            return true;
        }
        g.j().b().a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
        return true;
    }

    public final boolean a(f fVar, Collection<f> collection, Collection<f> collection2) {
        return a(fVar, this.f19183b, collection, collection2) || a(fVar, this.f19184c, collection, collection2) || a(fVar, this.f19185d, collection, collection2);
    }

    public boolean a(f fVar, Collection<e> collection, Collection<f> collection2, Collection<f> collection3) {
        a b10 = g.j().b();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!next.g()) {
                if (next.a(fVar)) {
                    if (!next.h()) {
                        if (collection2 != null) {
                            collection2.add(fVar);
                        } else {
                            b10.a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                        }
                        return true;
                    }
                    c.a(f19181j, "task: " + fVar.b() + " is finishing, move it to finishing list");
                    this.f19186e.add(next);
                    it.remove();
                    return false;
                }
                File d10 = next.d();
                File z10 = fVar.z();
                if (d10 != null && z10 != null && d10.equals(z10)) {
                    if (collection3 != null) {
                        collection3.add(fVar);
                    } else {
                        b10.a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void a(j jVar) {
        this.f19190i = jVar;
    }
}
