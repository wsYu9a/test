package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.listener.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class e extends com.sigmob.sdk.downloader.core.listener.b implements Runnable {

    /* renamed from: g */
    public static final Executor f19349g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload DynamicSerial", false));

    /* renamed from: h */
    public static final int f19350h = 0;

    /* renamed from: i */
    public static final String f19351i = "DownloadSerialQueue";

    /* renamed from: a */
    public volatile boolean f19352a;

    /* renamed from: b */
    public volatile boolean f19353b;

    /* renamed from: c */
    public volatile boolean f19354c;

    /* renamed from: d */
    public volatile f f19355d;

    /* renamed from: e */
    public final ArrayList<f> f19356e;

    /* renamed from: f */
    public com.sigmob.sdk.downloader.core.listener.f f19357f;

    public e() {
        this(null);
    }

    public int a() {
        return this.f19356e.size();
    }

    public synchronized void b(f fVar) {
        this.f19356e.add(fVar);
        Collections.sort(this.f19356e);
        if (!this.f19354c && !this.f19353b) {
            this.f19353b = true;
            f();
        }
    }

    public synchronized void c() {
        if (this.f19354c) {
            com.sigmob.sdk.downloader.core.c.c(f19351i, "require pause this queue(remain " + this.f19356e.size() + "), butit has already been paused");
            return;
        }
        this.f19354c = true;
        if (this.f19355d != null) {
            this.f19355d.f();
            this.f19356e.add(0, this.f19355d);
            this.f19355d = null;
        }
    }

    public synchronized void d() {
        if (this.f19354c) {
            this.f19354c = false;
            if (!this.f19356e.isEmpty() && !this.f19353b) {
                this.f19353b = true;
                f();
            }
            return;
        }
        com.sigmob.sdk.downloader.core.c.c(f19351i, "require resume this queue(remain " + this.f19356e.size() + "), but it is still running");
    }

    public synchronized f[] e() {
        f[] fVarArr;
        try {
            this.f19352a = true;
            if (this.f19355d != null) {
                this.f19355d.f();
            }
            fVarArr = new f[this.f19356e.size()];
            this.f19356e.toArray(fVarArr);
            this.f19356e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
        return fVarArr;
    }

    public void f() {
        f19349g.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f remove;
        while (!this.f19352a) {
            synchronized (this) {
                if (!this.f19356e.isEmpty() && !this.f19354c) {
                    remove = this.f19356e.remove(0);
                }
                this.f19355d = null;
                this.f19353b = false;
                return;
            }
            remove.b(this.f19357f);
        }
    }

    public e(c cVar) {
        this(cVar, new ArrayList());
    }

    public void a(c cVar) {
        this.f19357f = new f.a().a(this).a(cVar).a();
    }

    public int b() {
        if (this.f19355d != null) {
            return this.f19355d.b();
        }
        return 0;
    }

    public e(c cVar, ArrayList<f> arrayList) {
        this.f19352a = false;
        this.f19353b = false;
        this.f19354c = false;
        this.f19357f = new f.a().a(this).a(cVar).a();
        this.f19356e = arrayList;
    }

    @Override // com.sigmob.sdk.downloader.c
    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar != com.sigmob.sdk.downloader.core.cause.a.CANCELED && fVar == this.f19355d) {
            this.f19355d = null;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(f fVar) {
        this.f19355d = fVar;
    }
}
