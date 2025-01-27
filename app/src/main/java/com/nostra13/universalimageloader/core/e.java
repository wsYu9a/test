package com.nostra13.universalimageloader.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
class e {

    /* renamed from: a */
    final ImageLoaderConfiguration f15982a;

    /* renamed from: b */
    private Executor f15983b;

    /* renamed from: c */
    private Executor f15984c;

    /* renamed from: e */
    private final Map<Integer, String> f15986e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f */
    private final Map<String, ReentrantLock> f15987f = new WeakHashMap();

    /* renamed from: g */
    private final AtomicBoolean f15988g = new AtomicBoolean(false);

    /* renamed from: h */
    private final AtomicBoolean f15989h = new AtomicBoolean(false);

    /* renamed from: i */
    private final AtomicBoolean f15990i = new AtomicBoolean(false);

    /* renamed from: j */
    private final Object f15991j = new Object();

    /* renamed from: d */
    private Executor f15985d = com.nostra13.universalimageloader.core.a.i();

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LoadAndDisplayImageTask f15992a;

        a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.f15992a = loadAndDisplayImageTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = e.this.f15982a.o.get(this.f15992a.n());
            boolean z = file != null && file.exists();
            e.this.m();
            if (z) {
                e.this.f15984c.execute(this.f15992a);
            } else {
                e.this.f15983b.execute(this.f15992a);
            }
        }
    }

    e(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.f15982a = imageLoaderConfiguration;
        this.f15983b = imageLoaderConfiguration.f15873g;
        this.f15984c = imageLoaderConfiguration.f15874h;
    }

    private Executor e() {
        ImageLoaderConfiguration imageLoaderConfiguration = this.f15982a;
        return com.nostra13.universalimageloader.core.a.c(imageLoaderConfiguration.k, imageLoaderConfiguration.l, imageLoaderConfiguration.m);
    }

    public void m() {
        if (!this.f15982a.f15875i && ((ExecutorService) this.f15983b).isShutdown()) {
            this.f15983b = e();
        }
        if (this.f15982a.f15876j || !((ExecutorService) this.f15984c).isShutdown()) {
            return;
        }
        this.f15984c = e();
    }

    void d(com.nostra13.universalimageloader.core.j.a aVar) {
        this.f15986e.remove(Integer.valueOf(aVar.getId()));
    }

    void f(boolean z) {
        this.f15989h.set(z);
    }

    void g(Runnable runnable) {
        this.f15985d.execute(runnable);
    }

    String h(com.nostra13.universalimageloader.core.j.a aVar) {
        return this.f15986e.get(Integer.valueOf(aVar.getId()));
    }

    ReentrantLock i(String str) {
        ReentrantLock reentrantLock = this.f15987f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f15987f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    AtomicBoolean j() {
        return this.f15988g;
    }

    Object k() {
        return this.f15991j;
    }

    void l(boolean z) {
        this.f15990i.set(z);
    }

    boolean n() {
        return this.f15989h.get();
    }

    boolean o() {
        return this.f15990i.get();
    }

    void p() {
        this.f15988g.set(true);
    }

    void q(com.nostra13.universalimageloader.core.j.a aVar, String str) {
        this.f15986e.put(Integer.valueOf(aVar.getId()), str);
    }

    void r() {
        this.f15988g.set(false);
        synchronized (this.f15991j) {
            this.f15991j.notifyAll();
        }
    }

    void s() {
        if (!this.f15982a.f15875i) {
            ((ExecutorService) this.f15983b).shutdownNow();
        }
        if (!this.f15982a.f15876j) {
            ((ExecutorService) this.f15984c).shutdownNow();
        }
        this.f15986e.clear();
        this.f15987f.clear();
    }

    void t(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f15985d.execute(new a(loadAndDisplayImageTask));
    }

    void u(g gVar) {
        m();
        this.f15984c.execute(gVar);
    }
}
