package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class c extends View implements bx.a {
    private a aeD;
    private boolean aeE;
    private final int aeF;
    private boolean aej;
    private boolean aek;
    private View bN;
    private final bx bO;
    private final AtomicBoolean bP;

    public interface a {
        void eK();
    }

    public c(Context context, View view) {
        super(context);
        this.bO = new bx(this);
        this.bP = new AtomicBoolean(true);
        this.aeF = (int) (com.kwad.sdk.core.config.d.DL() * 100.0f);
        this.bN = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void un() {
        if (this.aek) {
            this.bO.removeCallbacksAndMessages(null);
            this.aek = false;
        }
    }

    private void uo() {
        if (!this.aeE || this.aek) {
            return;
        }
        this.aek = true;
        this.bO.sendEmptyMessage(1);
    }

    private void ut() {
        this.bP.getAndSet(false);
    }

    private void uu() {
        this.bP.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        a aVar;
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            if (!bw.a(this.bN, this.aeF, false)) {
                if (this.aej) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.aeD) != null) {
                    aVar.eK();
                }
                this.bO.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.aek) {
            if (!bw.a(this.bN, this.aeF, false)) {
                this.bO.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            un();
            Message obtainMessage = this.bO.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.bO.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onAttachedToWindow:" + this);
        uo();
        this.aej = false;
        ut();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onDetachedFromWindow" + this);
        un();
        this.aej = true;
        uu();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onFinishTemporaryDetach:" + this.bN.getParent());
        ut();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onStartTemporaryDetach:" + this.bN.getParent());
        uu();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i10);
    }

    public final void setNeedCheckingShow(boolean z10) {
        this.aeE = z10;
        if (!z10 && this.aek) {
            un();
        } else {
            if (!z10 || this.aek) {
                return;
            }
            uo();
        }
    }

    public final void setViewCallback(a aVar) {
        this.aeD = aVar;
    }
}
