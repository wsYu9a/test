package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.r.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int MQ;
    private boolean Nn;
    private a No;
    private float Np;
    private boolean Nq;

    public interface a {
        void d(float f2);

        boolean oR();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Nn = false;
        oL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nn = false;
        oL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Nn = false;
        oL();
    }

    private void oL() {
        this.MQ = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.MQ != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.kwai.a.d((Activity) getContext()) : com.kwad.sdk.c.kwai.a.getScreenHeight(getContext())) - (d.pO() ? com.kwad.sdk.c.kwai.a.getStatusBarHeight(getContext()) : 0)) - this.MQ, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.Nn) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.Np = y;
            this.Nq = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f2 = this.Np;
                float f3 = f2 - y;
                a aVar = this.No;
                if (aVar != null && y <= f2) {
                    this.Nq = true;
                    aVar.d(f3);
                }
                return super.onTouchEvent(obtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        a aVar2 = this.No;
        if (aVar2 == null) {
            return false;
        }
        if ((this.Np - y < 0.0f && !this.Nq) || !aVar2.oR()) {
            return false;
        }
        this.Nn = true;
        return false;
    }

    public void setDisableAnimation(boolean z) {
        this.Nn = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.No = aVar;
    }
}
