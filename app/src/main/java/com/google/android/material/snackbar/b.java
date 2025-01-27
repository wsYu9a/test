package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static final int f7792a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f7793b = 1500;

    /* renamed from: c, reason: collision with root package name */
    private static final int f7794c = 2750;

    /* renamed from: d, reason: collision with root package name */
    private static b f7795d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Object f7796e = new Object();

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final Handler f7797f = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private c f7798g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private c f7799h;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    interface InterfaceC0099b {
        void a(int i2);

        void show();
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        final WeakReference<InterfaceC0099b> f7801a;

        /* renamed from: b, reason: collision with root package name */
        int f7802b;

        /* renamed from: c, reason: collision with root package name */
        boolean f7803c;

        c(int i2, InterfaceC0099b interfaceC0099b) {
            this.f7801a = new WeakReference<>(interfaceC0099b);
            this.f7802b = i2;
        }

        boolean a(@Nullable InterfaceC0099b interfaceC0099b) {
            return interfaceC0099b != null && this.f7801a.get() == interfaceC0099b;
        }
    }

    private b() {
    }

    private boolean a(@NonNull c cVar, int i2) {
        InterfaceC0099b interfaceC0099b = cVar.f7801a.get();
        if (interfaceC0099b == null) {
            return false;
        }
        this.f7797f.removeCallbacksAndMessages(cVar);
        interfaceC0099b.a(i2);
        return true;
    }

    static b c() {
        if (f7795d == null) {
            f7795d = new b();
        }
        return f7795d;
    }

    private boolean g(InterfaceC0099b interfaceC0099b) {
        c cVar = this.f7798g;
        return cVar != null && cVar.a(interfaceC0099b);
    }

    private boolean h(InterfaceC0099b interfaceC0099b) {
        c cVar = this.f7799h;
        return cVar != null && cVar.a(interfaceC0099b);
    }

    private void m(@NonNull c cVar) {
        int i2 = cVar.f7802b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : f7794c;
        }
        this.f7797f.removeCallbacksAndMessages(cVar);
        Handler handler = this.f7797f;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    private void o() {
        c cVar = this.f7799h;
        if (cVar != null) {
            this.f7798g = cVar;
            this.f7799h = null;
            InterfaceC0099b interfaceC0099b = cVar.f7801a.get();
            if (interfaceC0099b != null) {
                interfaceC0099b.show();
            } else {
                this.f7798g = null;
            }
        }
    }

    public void b(InterfaceC0099b interfaceC0099b, int i2) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                a(this.f7798g, i2);
            } else if (h(interfaceC0099b)) {
                a(this.f7799h, i2);
            }
        }
    }

    void d(@NonNull c cVar) {
        synchronized (this.f7796e) {
            if (this.f7798g == cVar || this.f7799h == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0099b interfaceC0099b) {
        boolean g2;
        synchronized (this.f7796e) {
            g2 = g(interfaceC0099b);
        }
        return g2;
    }

    public boolean f(InterfaceC0099b interfaceC0099b) {
        boolean z;
        synchronized (this.f7796e) {
            z = g(interfaceC0099b) || h(interfaceC0099b);
        }
        return z;
    }

    public void i(InterfaceC0099b interfaceC0099b) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                this.f7798g = null;
                if (this.f7799h != null) {
                    o();
                }
            }
        }
    }

    public void j(InterfaceC0099b interfaceC0099b) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                m(this.f7798g);
            }
        }
    }

    public void k(InterfaceC0099b interfaceC0099b) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                c cVar = this.f7798g;
                if (!cVar.f7803c) {
                    cVar.f7803c = true;
                    this.f7797f.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void l(InterfaceC0099b interfaceC0099b) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                c cVar = this.f7798g;
                if (cVar.f7803c) {
                    cVar.f7803c = false;
                    m(cVar);
                }
            }
        }
    }

    public void n(int i2, InterfaceC0099b interfaceC0099b) {
        synchronized (this.f7796e) {
            if (g(interfaceC0099b)) {
                c cVar = this.f7798g;
                cVar.f7802b = i2;
                this.f7797f.removeCallbacksAndMessages(cVar);
                m(this.f7798g);
                return;
            }
            if (h(interfaceC0099b)) {
                this.f7799h.f7802b = i2;
            } else {
                this.f7799h = new c(i2, interfaceC0099b);
            }
            c cVar2 = this.f7798g;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f7798g = null;
                o();
            }
        }
    }
}
