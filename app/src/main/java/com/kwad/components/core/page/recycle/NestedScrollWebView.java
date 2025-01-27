package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes3.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int RR;
    private int RS;
    private final int[] RT;
    private final int[] RU;
    private int RV;
    private boolean RW;
    private int RX;
    private int RY;
    private NestedScrollingChildHelper RZ;
    private VelocityTracker Sa;
    private int Sb;

    public NestedScrollWebView(Context context) {
        super(context);
        this.RT = new int[2];
        this.RU = new int[2];
        qJ();
    }

    private void qJ() {
        this.Sb = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.RZ = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.RY = viewConfiguration.getScaledMaximumFlingVelocity();
        this.RX = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.RZ.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.RZ.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.RZ.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.RZ.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.RZ.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.RZ.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.Sb != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.g((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (com.kwad.components.core.s.d.sg() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.Sb, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z10 = false;
        if (actionMasked == 0) {
            this.RV = 0;
        }
        if (this.Sa == null) {
            this.Sa = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y10 = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.RV);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i10 = this.RR - y10;
                    if (dispatchNestedPreScroll(0, i10, this.RU, this.RT)) {
                        i10 -= this.RU[1];
                        obtain.offsetLocation(0.0f, this.RT[1]);
                        this.RV += this.RT[1];
                    }
                    int scrollY = getScrollY();
                    this.RR = y10 - this.RT[1];
                    int max = Math.max(0, scrollY + i10);
                    int i11 = i10 - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i11, 0, i11, this.RT)) {
                        int i12 = this.RR;
                        int i13 = this.RT[1];
                        this.RR = i12 - i13;
                        obtain.offsetLocation(0.0f, i13);
                        this.RV += this.RT[1];
                    }
                    if (Math.abs(this.RU[1]) >= 5 || Math.abs(this.RT[1]) >= 5) {
                        if (!this.RW) {
                            this.RW = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.RW) {
                            this.RW = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        stopNestedScroll();
                        onTouchEvent = super.onTouchEvent(motionEvent);
                    }
                    onTouchEvent = false;
                }
            }
            this.Sa.addMovement(motionEvent);
            this.Sa.computeCurrentVelocity(1000, this.RY);
            float f10 = -VelocityTrackerCompat.getYVelocity(this.Sa, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f10) > this.RX && !dispatchNestedPreFling(0.0f, f10) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f10, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.RR) < 10.0f) {
                Math.abs(motionEvent.getX() - this.RS);
            }
            onTouchEvent = onTouchEvent2;
            z10 = true;
        } else {
            this.RR = y10;
            this.RS = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.RU;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.RT;
            iArr2[0] = 0;
            iArr2[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.RW = false;
        }
        if (!z10) {
            this.Sa.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.RZ.setNestedScrollingEnabled(z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i10) {
        return this.RZ.startNestedScroll(i10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.RZ.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RT = new int[2];
        this.RU = new int[2];
        qJ();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.RT = new int[2];
        this.RU = new int[2];
        qJ();
    }
}
