package com.opos.cmn.j;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public class a extends View {

    /* renamed from: a */
    private InterfaceC0396a f17438a;

    /* renamed from: b */
    private boolean f17439b;

    /* renamed from: com.opos.cmn.j.a$a */
    public interface InterfaceC0396a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.f17439b = false;
    }

    public void a(InterfaceC0396a interfaceC0396a) {
        this.f17438a = interfaceC0396a;
        if (!this.f17439b || interfaceC0396a == null) {
            return;
        }
        interfaceC0396a.b();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17439b = true;
        InterfaceC0396a interfaceC0396a = this.f17438a;
        if (interfaceC0396a != null) {
            interfaceC0396a.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17439b = false;
        InterfaceC0396a interfaceC0396a = this.f17438a;
        if (interfaceC0396a != null) {
            interfaceC0396a.a();
        }
    }
}
