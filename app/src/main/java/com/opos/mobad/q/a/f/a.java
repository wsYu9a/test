package com.opos.mobad.q.a.f;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public class a extends View {

    /* renamed from: a */
    private InterfaceC0476a f23248a;

    /* renamed from: b */
    private boolean f23249b;

    /* renamed from: c */
    private volatile boolean f23250c;

    /* renamed from: com.opos.mobad.q.a.f.a$a */
    public interface InterfaceC0476a {
        void a();

        void a(boolean z);

        void b();
    }

    public a(Context context) {
        super(context);
        this.f23249b = false;
        this.f23250c = false;
    }

    public void a() {
        if (this.f23248a != null) {
            this.f23248a = null;
        }
    }

    public void a(InterfaceC0476a interfaceC0476a) {
        this.f23248a = interfaceC0476a;
        if (!this.f23249b || interfaceC0476a == null) {
            return;
        }
        interfaceC0476a.b();
    }

    protected void a(boolean z) {
        if (this.f23250c == (!z)) {
            this.f23250c = z;
            InterfaceC0476a interfaceC0476a = this.f23248a;
            if (interfaceC0476a != null) {
                interfaceC0476a.a(z);
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f23249b = true;
        InterfaceC0476a interfaceC0476a = this.f23248a;
        if (interfaceC0476a != null) {
            interfaceC0476a.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23249b = false;
        InterfaceC0476a interfaceC0476a = this.f23248a;
        if (interfaceC0476a != null) {
            interfaceC0476a.a();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(i2 == 0);
    }
}
