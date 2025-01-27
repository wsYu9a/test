package com.vivo.mobilead.util.f1;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a implements ThreadFactory {

    /* renamed from: d */
    private static final AtomicInteger f30622d = new AtomicInteger(1);

    /* renamed from: a */
    private final ThreadGroup f30623a;

    /* renamed from: b */
    private final AtomicInteger f30624b = new AtomicInteger(1);

    /* renamed from: c */
    private final String f30625c;

    public a(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f30623a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f30625c = str + f30622d.getAndIncrement();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f30623a, runnable, this.f30625c + this.f30624b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
