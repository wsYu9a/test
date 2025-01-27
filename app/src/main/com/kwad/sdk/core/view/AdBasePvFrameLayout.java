package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.j;

/* loaded from: classes3.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aHb;
    private float aHc;
    private boolean aHd;
    private boolean aHe;
    private ViewTreeObserver.OnScrollChangedListener aHf;
    private ViewTreeObserver aHg;
    private bv aHh;
    private j dQ;
    private int nu;

    /* renamed from: com.kwad.sdk.core.view.AdBasePvFrameLayout$1 */
    public class AnonymousClass1 implements ViewTreeObserver.OnScrollChangedListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (AdBasePvFrameLayout.this.Iy()) {
                AdBasePvFrameLayout.this.Ix();
            }
        }
    }

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aHb = 500L;
        this.aHc = 0.1f;
        this.aHe = true;
        init();
    }

    private void IA() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aHf != null && (viewTreeObserver = this.aHg) != null && viewTreeObserver.isAlive()) {
                this.aHg.removeOnScrollChangedListener(this.aHf);
            }
            this.aHf = null;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    private void Iw() {
        if (Iy()) {
            Ix();
        } else {
            Iz();
        }
    }

    public boolean Iy() {
        if (!this.aHh.Pq() || Math.abs(this.aHh.aVI.height() - getHeight()) > getHeight() * (1.0f - this.aHc) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.aHh.aVI;
        return rect.bottom > 0 && rect.top < this.nu;
    }

    private void Iz() {
        if (this.aHf == null) {
            this.aHf = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                public AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.Iy()) {
                        AdBasePvFrameLayout.this.Ix();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aHg = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aHf);
            }
        }
    }

    private void init() {
        this.aHh = new bv(this);
        this.nu = l.getScreenHeight(getContext());
        this.aHe = true;
    }

    private void ps() {
        if (this.aHe) {
            Iw();
        }
    }

    public final void Ix() {
        IA();
        j jVar = this.dQ;
        if (jVar != null) {
            jVar.aN();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iz();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IA();
        this.aHd = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        boolean z10;
        if (this.aHd || (i12 | i13) != 0 || (i10 | i11) == 0) {
            z10 = false;
        } else {
            z10 = true;
            this.aHd = true;
        }
        super.onSizeChanged(i10, i11, i12, i13);
        if (z10) {
            ps();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f10) {
        this.aHc = f10;
    }

    public void setVisibleListener(j jVar) {
        this.dQ = jVar;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHb = 500L;
        this.aHc = 0.1f;
        this.aHe = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aHb = 500L;
        this.aHc = 0.1f;
        this.aHe = true;
        init();
    }
}
