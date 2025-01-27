package com.opos.cmn.an.i;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c implements ThreadFactory {

    /* renamed from: a */
    private AtomicInteger f16544a = new AtomicInteger(0);

    /* renamed from: b */
    private String f16545b;

    public c(String str) {
        this.f16545b = str + "_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f16545b + this.f16544a.incrementAndGet());
        thread.setUncaughtExceptionHandler(b.a());
        thread.setPriority(5);
        return thread;
    }
}
