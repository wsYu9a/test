package com.opos.cmn.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class b extends FrameLayout {

    /* renamed from: d */
    private static Handler f17440d;

    /* renamed from: a */
    private a f17441a;

    /* renamed from: b */
    private boolean f17442b;

    /* renamed from: c */
    private boolean f17443c;

    /* renamed from: com.opos.cmn.j.b$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f17444a;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f17441a != null) {
                b.this.f17441a.a(z);
            }
        }
    }

    /* renamed from: com.opos.cmn.j.b$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.f17442b || b.this.f17441a == null) {
                return;
            }
            b.this.f17441a.a(b.this.f17443c);
        }
    }

    public interface a {
        void a(boolean z);
    }

    public b(Context context) {
        super(context);
        this.f17441a = null;
        this.f17442b = false;
        this.f17443c = false;
        f17440d = new Handler(Looper.getMainLooper());
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

    public void a(a aVar) {
        this.f17441a = aVar;
        if (!this.f17442b || aVar == null) {
            return;
        }
        f17440d.post(new Runnable() { // from class: com.opos.cmn.j.b.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.f17442b || b.this.f17441a == null) {
                    return;
                }
                b.this.f17441a.a(b.this.f17443c);
            }
        });
    }

    protected void a(boolean z) {
        if (this.f17443c == (!z)) {
            this.f17443c = z;
            if (this.f17441a != null) {
                f17440d.post(new Runnable() { // from class: com.opos.cmn.j.b.1

                    /* renamed from: a */
                    final /* synthetic */ boolean f17444a;

                    AnonymousClass1(boolean z2) {
                        z = z2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f17441a != null) {
                            b.this.f17441a.a(z);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17442b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17442b = false;
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
