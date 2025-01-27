package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes3.dex */
public class SplitScrollWebView extends KsAdWebView {
    private float SA;
    private boolean SB;
    private int Sb;
    private boolean Sy;
    private a Sz;

    public interface a {
        void f(float f10);

        boolean qP();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Sy = false;
        qJ();
    }

    private void qJ() {
        this.Sb = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.Sb != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.g((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (d.sg() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.Sb, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.Sy) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.SA = y10;
            this.SB = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f10 = this.SA;
                float f11 = f10 - y10;
                a aVar = this.Sz;
                if (aVar != null && y10 <= f10) {
                    this.SB = true;
                    aVar.f(f11);
                }
                return super.onTouchEvent(obtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        a aVar2 = this.Sz;
        if (aVar2 == null) {
            return false;
        }
        if ((this.SA - y10 < 0.0f && !this.SB) || !aVar2.qP()) {
            return false;
        }
        this.Sy = true;
        return false;
    }

    public void setDisableAnimation(boolean z10) {
        this.Sy = z10;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Sz = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Sy = false;
        qJ();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Sy = false;
        qJ();
    }
}
