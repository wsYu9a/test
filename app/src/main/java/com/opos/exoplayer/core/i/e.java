package com.opos.exoplayer.core.i;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    private boolean f19016a;

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = true;
            if (this.f19016a) {
                z = false;
            } else {
                this.f19016a = true;
                notifyAll();
            }
        }
        return z;
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f19016a;
            this.f19016a = false;
        }
        return z;
    }

    public void c() {
        synchronized (this) {
            while (!this.f19016a) {
                wait();
            }
        }
    }
}
