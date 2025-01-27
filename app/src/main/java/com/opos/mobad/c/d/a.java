package com.opos.mobad.c.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: d */
    private static Handler f20040d;

    /* renamed from: a */
    private InterfaceC0428a f20041a;

    /* renamed from: b */
    private boolean f20042b;

    /* renamed from: c */
    private boolean f20043c;

    /* renamed from: com.opos.mobad.c.d.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f20044a;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f20041a != null) {
                a.this.f20041a.a(z);
            }
        }
    }

    /* renamed from: com.opos.mobad.c.d.a$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.f20042b || a.this.f20041a == null) {
                return;
            }
            a.this.f20041a.a(a.this.f20043c);
        }
    }

    /* renamed from: com.opos.mobad.c.d.a$a */
    public interface InterfaceC0428a {
        void a(boolean z);
    }

    public a(Context context) {
        super(context);
        this.f20041a = null;
        this.f20042b = false;
        this.f20043c = false;
        f20040d = new Handler(Looper.getMainLooper());
    }

    private void a(int i2) {
        boolean z;
        if (i2 != 0) {
            z = false;
        } else if (getVisibility() != 0 || !isShown()) {
            return;
        } else {
            z = true;
        }
        a(z);
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        this.f20041a = interfaceC0428a;
        if (!this.f20042b || interfaceC0428a == null) {
            return;
        }
        f20040d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f20042b || a.this.f20041a == null) {
                    return;
                }
                a.this.f20041a.a(a.this.f20043c);
            }
        });
    }

    protected void a(boolean z) {
        if (this.f20043c == (!z)) {
            this.f20043c = z;
            if (this.f20041a != null) {
                f20040d.post(new Runnable() { // from class: com.opos.mobad.c.d.a.1

                    /* renamed from: a */
                    final /* synthetic */ boolean f20044a;

                    AnonymousClass1(boolean z2) {
                        z = z2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f20041a != null) {
                            a.this.f20041a.a(z);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20042b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20042b = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        boolean z2;
        super.onWindowFocusChanged(z);
        com.opos.cmn.an.f.a.b("StatusMediaView", "onViewVisibile hasWindowFocus=" + z);
        if (!z) {
            z2 = false;
        } else if (getVisibility() != 0 || !isShown()) {
            return;
        } else {
            z2 = true;
        }
        a(z2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(i2);
    }
}
