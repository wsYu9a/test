package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class h6 {

    /* renamed from: a */
    public boolean f27485a;

    public synchronized void a() {
        while (!this.f27485a) {
            wait();
        }
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f27485a;
        this.f27485a = false;
        return z;
    }

    public synchronized boolean c() {
        if (this.f27485a) {
            return false;
        }
        this.f27485a = true;
        notifyAll();
        return true;
    }
}
