package com.tencent.bugly.proguard;

import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public class S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f22640a;

    /* renamed from: b */
    final /* synthetic */ LinkedBlockingQueue f22641b;

    /* renamed from: c */
    final /* synthetic */ T f22642c;

    public S(T t10, int i10, LinkedBlockingQueue linkedBlockingQueue) {
        this.f22642c = t10;
        this.f22640a = i10;
        this.f22641b = linkedBlockingQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        for (int i10 = 0; i10 < this.f22640a && (runnable = (Runnable) this.f22641b.poll()) != null; i10++) {
            runnable.run();
        }
    }
}
