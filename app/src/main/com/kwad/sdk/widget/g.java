package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.l;

/* loaded from: classes3.dex */
public final class g {
    private final bv aHh;
    private final i aXC;
    private boolean aXE;
    private boolean aXF;
    private ViewTreeObserver.OnScrollChangedListener aXH;
    private final View mView;
    private final int nu;
    private float aXD = 0.1f;
    private boolean aXG = true;

    /* renamed from: com.kwad.sdk.widget.g$1 */
    public class AnonymousClass1 implements ViewTreeObserver.OnScrollChangedListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (g.this.PT()) {
                g.this.aN();
            }
        }
    }

    public g(View view, i iVar) {
        this.mView = view;
        this.aXC = iVar;
        this.aHh = new bv(view);
        this.nu = l.getScreenHeight(view.getContext());
    }

    private void IA() {
        if (this.aXH == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aXH);
            }
            this.aXH = null;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    private void Iz() {
        if (this.aXH == null) {
            this.aXH = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                public AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.PT()) {
                        g.this.aN();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aXH);
            }
        }
    }

    private void PS() {
        if (PT()) {
            aN();
        } else {
            IA();
            Iz();
        }
    }

    public boolean PT() {
        if (this.aHh.Pq() && Math.abs(this.aHh.aVI.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aXD) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aHh.aVI;
            if (rect.bottom > 0 && rect.top < this.nu) {
                return true;
            }
        }
        return false;
    }

    public void aN() {
        try {
            IA();
            i iVar = this.aXC;
            if (iVar != null) {
                iVar.C(this.mView);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private void ps() {
        if (this.aXG) {
            PS();
        }
    }

    public final void PR() {
        if (this.aXF) {
            ps();
        }
    }

    public final void ch(boolean z10) {
        this.aXG = z10;
    }

    public final float getVisiblePercent() {
        return this.aXD;
    }

    public final void onAttachedToWindow() {
        Iz();
    }

    public final void onDetachedFromWindow() {
        IA();
        this.aXE = false;
    }

    public final void setVisiblePercent(float f10) {
        this.aXD = f10;
    }

    public final void b(int i10, int i11, int i12, int i13) {
        this.aXF = false;
        if (this.aXE || (i12 | i13) != 0 || (i10 | i11) == 0) {
            return;
        }
        this.aXF = true;
        this.aXE = true;
    }
}
