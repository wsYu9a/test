package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f6460a = new b();

    /* renamed from: b, reason: collision with root package name */
    public Thread f6461b = null;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<Runnable> f6462c = new LinkedList<>();

    public static b a() {
        return f6460a;
    }

    public static /* synthetic */ Thread b(b bVar) {
        bVar.f6461b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.f6462c.add(runnable);
        if (this.f6461b == null) {
            Thread thread = new Thread(new c(this));
            this.f6461b = thread;
            thread.start();
        }
    }
}
