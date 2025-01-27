package com.tencent.bugly.proguard;

import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
class S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24991a;

    /* renamed from: b */
    final /* synthetic */ LinkedBlockingQueue f24992b;

    /* renamed from: c */
    final /* synthetic */ T f24993c;

    S(T t, int i2, LinkedBlockingQueue linkedBlockingQueue) {
        this.f24993c = t;
        this.f24991a = i2;
        this.f24992b = linkedBlockingQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        for (int i2 = 0; i2 < this.f24991a && (runnable = (Runnable) this.f24992b.poll()) != null; i2++) {
            runnable.run();
        }
    }
}
