package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class V implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ W f22674a;

    public V(W w10) {
        this.f22674a = w10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        Thread thread = new Thread(runnable);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BuglyThread-");
        atomicInteger = W.f22675a;
        sb2.append(atomicInteger.getAndIncrement());
        thread.setName(sb2.toString());
        return thread;
    }
}
