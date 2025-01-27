package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class V implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ W f25014a;

    V(W w) {
        this.f25014a = w;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder();
        sb.append("BuglyThread-");
        atomicInteger = W.f25015a;
        sb.append(atomicInteger.getAndIncrement());
        thread.setName(sb.toString());
        return thread;
    }
}
