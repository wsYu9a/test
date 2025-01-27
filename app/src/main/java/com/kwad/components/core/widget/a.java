package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class a extends KSFrameLayout implements bm.a {
    private final View Ru;
    private InterfaceC0197a VJ;
    private boolean VK;
    private boolean VL;
    private int VM;
    private boolean VN;
    private long VO;
    private boolean VP;
    private final float VQ;
    private final int VR;
    private final bm gK;

    /* renamed from: com.kwad.components.core.widget.a$a */
    public interface InterfaceC0197a {
        void eM();

        void k(View view);

        void onViewAttached();

        void onViewDetached();
    }

    public a(Context context, View view) {
        super(context, view);
        this.gK = new bm(this);
        this.VM = 5;
        this.Ru = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float uF = com.kwad.sdk.core.config.d.uF();
        this.VQ = uF;
        setVisiblePercent(uF);
        float uG = com.kwad.sdk.core.config.d.uG();
        this.VR = (int) ((uG < 0.0f ? 1.0f : uG) * 1000.0f);
    }

    private void rq() {
        InterfaceC0197a interfaceC0197a;
        if (this.VR == 0 && (interfaceC0197a = this.VJ) != null) {
            interfaceC0197a.k(this.Ru);
            return;
        }
        Message obtainMessage = this.gK.obtainMessage();
        obtainMessage.what = 2;
        this.gK.sendMessageDelayed(obtainMessage, this.VR);
    }

    private void rr() {
        this.gK.removeCallbacksAndMessages(null);
        this.VL = false;
    }

    private void rs() {
        if (this.VL) {
            return;
        }
        this.VL = true;
        this.gK.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (this.VK) {
            return;
        }
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bl.a(this.Ru, (int) (this.VQ * 100.0f), false)) {
                this.VM = 5;
                this.gK.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0197a interfaceC0197a = this.VJ;
                if (interfaceC0197a != null) {
                    interfaceC0197a.k(this.Ru);
                    return;
                }
                return;
            }
        }
        com.kwad.sdk.core.d.b.d("AdExposureView", "handleMsg MSG_CHECKING");
        if (!bl.a(this.Ru, (int) (this.VQ * 100.0f), false)) {
            InterfaceC0197a interfaceC0197a2 = this.VJ;
            if (interfaceC0197a2 != null && !this.VP) {
                interfaceC0197a2.eM();
            }
            this.VP = true;
            bm bmVar = this.gK;
            int i3 = this.VM;
            this.VM = i3 - 1;
            bmVar.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
            return;
        }
        rr();
        if (this.VN) {
            InterfaceC0197a interfaceC0197a3 = this.VJ;
            if (interfaceC0197a3 != null) {
                interfaceC0197a3.k(this.Ru);
            }
        } else {
            this.VN = true;
            this.VO = System.currentTimeMillis();
            rq();
        }
        this.VP = false;
        bm bmVar2 = this.gK;
        int i4 = this.VM;
        this.VM = i4 - 1;
        bmVar2.sendEmptyMessageDelayed(1, i4 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void onFirstVisible(View view) {
        InterfaceC0197a interfaceC0197a;
        InterfaceC0197a interfaceC0197a2;
        super.onFirstVisible(view);
        if (this.VR == 0 && (interfaceC0197a2 = this.VJ) != null) {
            interfaceC0197a2.k(view);
            return;
        }
        if (!this.VN) {
            this.VN = true;
            this.VO = System.currentTimeMillis();
            rr();
            rq();
            return;
        }
        if (System.currentTimeMillis() - this.VO <= this.VR || (interfaceC0197a = this.VJ) == null) {
            return;
        }
        interfaceC0197a.k(view);
        rr();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.VM = 5;
        this.VK = false;
        this.VN = false;
        rs();
        InterfaceC0197a interfaceC0197a = this.VJ;
        if (interfaceC0197a != null) {
            interfaceC0197a.onViewAttached();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        rr();
        this.VM = 0;
        this.VO = 0L;
        this.VK = true;
        InterfaceC0197a interfaceC0197a = this.VJ;
        if (interfaceC0197a != null) {
            interfaceC0197a.onViewDetached();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.b.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    public final void rt() {
        rs();
    }

    public final void setViewCallback(InterfaceC0197a interfaceC0197a) {
        this.VJ = interfaceC0197a;
    }
}
