package com.sigmob.sdk.downloader.core.file;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c */
    public static final String f19276c = "FileLock";

    /* renamed from: d */
    public static final long f19277d = TimeUnit.MILLISECONDS.toNanos(100);

    /* renamed from: a */
    public final Map<String, AtomicInteger> f19278a;

    /* renamed from: b */
    public final Map<String, Thread> f19279b;

    public c() {
        this(new HashMap(), new HashMap());
    }

    public void a(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.f19278a) {
            atomicInteger = this.f19278a.get(str);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.a(f19276c, "decreaseLock decrease lock-count to 0 " + str);
        synchronized (this.f19279b) {
            try {
                thread = this.f19279b.get(str);
                if (thread != null) {
                    this.f19279b.remove(str);
                }
            } finally {
            }
        }
        if (thread != null) {
            com.sigmob.sdk.downloader.core.c.a(f19276c, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.f19278a) {
            this.f19278a.remove(str);
        }
    }

    public void b(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f19278a) {
            atomicInteger = this.f19278a.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.f19278a) {
                this.f19278a.put(str, atomicInteger);
            }
        }
        com.sigmob.sdk.downloader.core.c.a(f19276c, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
    }

    public void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f19278a) {
            atomicInteger = this.f19278a.get(str);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.f19279b) {
            this.f19279b.put(str, Thread.currentThread());
        }
        com.sigmob.sdk.downloader.core.c.a(f19276c, "waitForRelease start " + str);
        while (!a(atomicInteger)) {
            a();
        }
        com.sigmob.sdk.downloader.core.c.a(f19276c, "waitForRelease finish " + str);
    }

    public c(Map<String, AtomicInteger> map, Map<String, Thread> map2) {
        this.f19278a = map;
        this.f19279b = map2;
    }

    public boolean a(AtomicInteger atomicInteger) {
        return atomicInteger.get() <= 0;
    }

    public void a() {
        LockSupport.park(Long.valueOf(f19277d));
    }

    public void a(Thread thread) {
        LockSupport.unpark(thread);
    }
}
