package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class a extends KSFrameLayout implements bx.a {
    private InterfaceC0457a aei;
    private boolean aej;
    private boolean aek;
    private int ael;
    private boolean aem;
    private long aen;
    private boolean aeo;
    private final float aep;
    private final int aeq;
    private final View bN;
    private final bx bO;

    /* renamed from: com.kwad.components.core.widget.a$a */
    public interface InterfaceC0457a {
        void Z();

        void aa();

        void ax();

        void c(View view);

        void onWindowFocusChanged(boolean z10);
    }

    public a(Context context, View view) {
        super(context, view);
        this.bO = new bx(this);
        this.ael = 5;
        this.bN = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float DL = com.kwad.sdk.core.config.d.DL();
        this.aep = DL;
        setVisiblePercent(DL);
        float DM = com.kwad.sdk.core.config.d.DM();
        this.aeq = (int) ((DM < 0.0f ? 1.0f : DM) * 1000.0f);
    }

    private void um() {
        InterfaceC0457a interfaceC0457a;
        if (this.aeq == 0 && (interfaceC0457a = this.aei) != null) {
            interfaceC0457a.c(this.bN);
            return;
        }
        Message obtainMessage = this.bO.obtainMessage();
        obtainMessage.what = 2;
        this.bO.sendMessageDelayed(obtainMessage, this.aeq);
    }

    private void un() {
        this.bO.removeCallbacksAndMessages(null);
        this.aek = false;
    }

    private void uo() {
        if (this.aek) {
            return;
        }
        this.aek = true;
        this.bO.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void C(View view) {
        InterfaceC0457a interfaceC0457a;
        InterfaceC0457a interfaceC0457a2;
        super.C(view);
        if (this.aeq == 0 && (interfaceC0457a2 = this.aei) != null) {
            interfaceC0457a2.c(view);
            return;
        }
        if (!this.aem) {
            this.aem = true;
            this.aen = System.currentTimeMillis();
            un();
            um();
            return;
        }
        if (System.currentTimeMillis() - this.aen <= this.aeq || (interfaceC0457a = this.aei) == null) {
            return;
        }
        interfaceC0457a.c(view);
        un();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        this.ael = 5;
        this.aej = false;
        this.aem = false;
        uo();
        InterfaceC0457a interfaceC0457a = this.aei;
        if (interfaceC0457a != null) {
            interfaceC0457a.Z();
        }
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (this.aej) {
            return;
        }
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            if (!bw.a(this.bN, (int) (this.aep * 100.0f), false)) {
                this.ael = 5;
                this.bO.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0457a interfaceC0457a = this.aei;
                if (interfaceC0457a != null) {
                    interfaceC0457a.c(this.bN);
                    return;
                }
                return;
            }
        }
        if (!bw.a(this.bN, (int) (this.aep * 100.0f), false)) {
            InterfaceC0457a interfaceC0457a2 = this.aei;
            if (interfaceC0457a2 != null && !this.aeo) {
                interfaceC0457a2.ax();
            }
            this.aeo = true;
            bx bxVar = this.bO;
            int i11 = this.ael;
            this.ael = i11 - 1;
            bxVar.sendEmptyMessageDelayed(1, i11 > 0 ? 100L : 500L);
            return;
        }
        un();
        if (this.aem) {
            InterfaceC0457a interfaceC0457a3 = this.aei;
            if (interfaceC0457a3 != null) {
                interfaceC0457a3.c(this.bN);
            }
        } else {
            this.aem = true;
            this.aen = System.currentTimeMillis();
            um();
        }
        this.aeo = false;
        bx bxVar2 = this.bO;
        int i12 = this.ael;
        this.ael = i12 - 1;
        bxVar2.sendEmptyMessageDelayed(1, i12 > 0 ? 100L : 500L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        un();
        this.ael = 0;
        this.aen = 0L;
        this.aej = true;
        InterfaceC0457a interfaceC0457a = this.aei;
        if (interfaceC0457a != null) {
            interfaceC0457a.aa();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z10);
        InterfaceC0457a interfaceC0457a = this.aei;
        if (interfaceC0457a != null) {
            interfaceC0457a.onWindowFocusChanged(z10);
        }
    }

    public final void setViewCallback(InterfaceC0457a interfaceC0457a) {
        this.aei = interfaceC0457a;
    }

    public final void up() {
        uo();
    }
}
