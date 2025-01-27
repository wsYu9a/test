package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
final class bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f5593a;

    bh(Runnable runnable) {
        this.f5593a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5593a.run();
    }
}
