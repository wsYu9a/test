package com.kwad.components.core.g;

import android.os.Handler;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class a implements Runnable {
    private long NE = 1000;
    private boolean NF = true;
    private long NG = 0;
    private InterfaceC0428a NH;

    /* renamed from: hf, reason: collision with root package name */
    @Nullable
    private volatile Handler f11925hf;

    /* renamed from: com.kwad.components.core.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0428a {
        void y(long j10);
    }

    public a(Handler handler) {
        this.f11925hf = handler;
    }

    public final void a(InterfaceC0428a interfaceC0428a) {
        this.NH = interfaceC0428a;
    }

    public final void destroy() {
        stop();
        this.f11925hf = null;
    }

    public final void pause() {
        this.NF = true;
    }

    public final void resume() {
        this.NF = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0428a interfaceC0428a;
        try {
            if (this.f11925hf != null) {
                if (!this.NF && (interfaceC0428a = this.NH) != null) {
                    interfaceC0428a.y(this.NG);
                    this.NG += this.NE;
                }
                if (this.f11925hf != null) {
                    this.f11925hf.postDelayed(this, this.NE);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void start() {
        this.NF = false;
        if (this.f11925hf != null) {
            this.f11925hf.post(this);
        }
    }

    public final void stop() {
        if (this.f11925hf != null) {
            this.f11925hf.removeCallbacks(this);
        }
    }
}
