package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public class Q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f22638a;

    /* renamed from: b */
    final /* synthetic */ T f22639b;

    public Q(T t10, Runnable runnable) {
        this.f22639b = t10;
        this.f22638a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        this.f22638a.run();
        obj = this.f22639b.f22652j;
        synchronized (obj) {
            T.b(this.f22639b);
        }
    }
}
