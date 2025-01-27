package com.opos.cmn.biz.web.a.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class b implements ThreadFactory {

    /* renamed from: a */
    private AtomicInteger f16841a = new AtomicInteger(0);

    /* renamed from: b */
    private String f16842b;

    public b(String str) {
        this.f16842b = str + "_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f16842b + this.f16841a.incrementAndGet());
        thread.setUncaughtExceptionHandler(a.a());
        thread.setPriority(5);
        return thread;
    }
}
