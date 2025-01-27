package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.k;

/* loaded from: classes2.dex */
public final class g {
    private final i aDp;
    private boolean aDr;
    private boolean aDs;
    private ViewTreeObserver.OnScrollChangedListener aDu;
    private final bk aov;
    private final int mA;
    private final View mView;
    private float aDq = 0.1f;
    private boolean aDt = true;

    /* renamed from: com.kwad.sdk.widget.g$1 */
    final class AnonymousClass1 implements ViewTreeObserver.OnScrollChangedListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (g.this.FD()) {
                g.this.aw();
            }
        }
    }

    public g(View view, i iVar) {
        this.mView = view;
        this.aDp = iVar;
        this.aov = new bk(view);
        this.mA = k.getScreenHeight(view.getContext());
    }

    private void FC() {
        if (FD()) {
            aw();
        } else {
            yS();
            yR();
        }
    }

    public boolean FD() {
        if (this.aov.Fa() && Math.abs(this.aov.aBy.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aDq) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aov.aBy;
            if (rect.bottom > 0 && rect.top < this.mA) {
                return true;
            }
        }
        return false;
    }

    public void aw() {
        yS();
        i iVar = this.aDp;
        if (iVar != null) {
            iVar.onFirstVisible(this.mView);
        }
    }

    private void yN() {
        if (this.aDt) {
            FC();
        }
    }

    private void yR() {
        if (this.aDu == null) {
            this.aDu = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.FD()) {
                        g.this.aw();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aDu);
            }
        }
    }

    private void yS() {
        if (this.aDu == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aDu);
            }
            this.aDu = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public final void FB() {
        if (this.aDs) {
            yN();
        }
    }

    public final void b(int i2, int i3, int i4, int i5) {
        this.aDs = false;
        if (this.aDr || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.aDs = true;
        this.aDr = true;
    }

    public final void bJ(boolean z) {
        this.aDt = z;
    }

    public final float getVisiblePercent() {
        return this.aDq;
    }

    public final void onAttachedToWindow() {
        yR();
    }

    public final void onDetachedFromWindow() {
        yS();
        this.aDr = false;
    }

    public final void resetPvAfterDataChange() {
        FC();
    }

    public final void setVisiblePercent(float f2) {
        this.aDq = f2;
    }
}
