package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
class Q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f24989a;

    /* renamed from: b */
    final /* synthetic */ T f24990b;

    Q(T t, Runnable runnable) {
        this.f24990b = t;
        this.f24989a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        this.f24989a.run();
        obj = this.f24990b.f25003j;
        synchronized (obj) {
            T.b(this.f24990b);
        }
    }
}
