package com.opos.cmn.an.j.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class a implements ThreadFactory {

    /* renamed from: a */
    private int f16582a;

    /* renamed from: b */
    private String f16583b;

    /* renamed from: c */
    private AtomicInteger f16584c = new AtomicInteger(0);

    public a(String str, int i2) {
        this.f16583b = str;
        this.f16582a = i2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f16583b + "_" + this.f16584c.incrementAndGet());
        thread.setPriority(this.f16582a);
        return thread;
    }
}
