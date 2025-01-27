package com.sigmob.sdk.downloader.core;

/* loaded from: classes4.dex */
public abstract class b implements Runnable {

    /* renamed from: a */
    public final String f18997a;

    public b(String str) {
        this.f18997a = str;
    }

    public abstract void a() throws InterruptedException;

    public abstract void a(InterruptedException interruptedException);

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f18997a);
        try {
            try {
                a();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                a(e10);
            }
        } finally {
            Thread.currentThread().setName(name);
            b();
        }
    }
}
