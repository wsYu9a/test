package com.baidu.mobads.sdk.internal;

/* loaded from: classes2.dex */
final class bk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f6893a;

    public bk(Runnable runnable) {
        this.f6893a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6893a.run();
    }
}
