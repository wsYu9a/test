package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;

/* loaded from: classes2.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aop;
    private float aoq;
    private boolean aor;
    private boolean aos;
    private ViewTreeObserver.OnScrollChangedListener aot;
    private ViewTreeObserver aou;
    private bk aov;
    private j cK;
    private int mA;

    /* renamed from: com.kwad.sdk.core.view.AdBasePvFrameLayout$1 */
    final class AnonymousClass1 implements ViewTreeObserver.OnScrollChangedListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (AdBasePvFrameLayout.this.yQ()) {
                AdBasePvFrameLayout.this.yP();
            }
        }
    }

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    private void init() {
        this.aov = new bk(this);
        this.mA = k.getScreenHeight(getContext());
        this.aos = true;
    }

    private void yN() {
        if (this.aos) {
            yO();
        }
    }

    private void yO() {
        if (yQ()) {
            yP();
        } else {
            yR();
        }
    }

    public boolean yQ() {
        if (!this.aov.Fa() || Math.abs(this.aov.aBy.height() - getHeight()) > getHeight() * (1.0f - this.aoq) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.aov.aBy;
        return rect.bottom > 0 && rect.top < this.mA;
    }

    private void yR() {
        if (this.aot == null) {
            this.aot = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.yQ()) {
                        AdBasePvFrameLayout.this.yP();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aou = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aot);
            }
        }
    }

    private void yS() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aot != null && (viewTreeObserver = this.aou) != null && viewTreeObserver.isAlive()) {
                this.aou.removeOnScrollChangedListener(this.aot);
            }
            this.aot = null;
        } catch (Exception e2) {
            b.printStackTrace(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        yR();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        yS();
        this.aor = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.aor || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.aor = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            yN();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        this.aoq = f2;
    }

    public void setVisibleListener(j jVar) {
        this.cK = jVar;
    }

    protected final void yP() {
        yS();
        j jVar = this.cK;
        if (jVar != null) {
            jVar.aw();
        }
    }
}
