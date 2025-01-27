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

/* loaded from: classes2.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int MG;
    private int MH;
    private final int[] MI;
    private final int[] MJ;
    private int MK;
    private boolean ML;
    private int MM;
    private int MN;
    private NestedScrollingChildHelper MO;
    private VelocityTracker MP;
    private int MQ;

    public NestedScrollWebView(Context context) {
        super(context);
        this.MI = new int[2];
        this.MJ = new int[2];
        oL();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MI = new int[2];
        this.MJ = new int[2];
        oL();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MI = new int[2];
        this.MJ = new int[2];
        oL();
    }

    private void oL() {
        this.MQ = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.MO = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.MN = viewConfiguration.getScaledMaximumFlingVelocity();
        this.MM = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.MO.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.MO.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.MO.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.MO.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.MO.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.MO.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.MQ != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.kwai.a.d((Activity) getContext()) : com.kwad.sdk.c.kwai.a.getScreenHeight(getContext())) - (com.kwad.components.core.r.d.pO() ? com.kwad.sdk.c.kwai.a.getStatusBarHeight(getContext()) : 0)) - this.MQ, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.MK = 0;
        }
        if (this.MP == null) {
            this.MP = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.MK);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.MG - y;
                    if (dispatchNestedPreScroll(0, i2, this.MJ, this.MI)) {
                        i2 -= this.MJ[1];
                        obtain.offsetLocation(0.0f, this.MI[1]);
                        this.MK += this.MI[1];
                    }
                    int scrollY = getScrollY();
                    this.MG = y - this.MI[1];
                    int max = Math.max(0, scrollY + i2);
                    int i3 = i2 - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i3, 0, i3, this.MI)) {
                        this.MG = this.MG - this.MI[1];
                        obtain.offsetLocation(0.0f, r1[1]);
                        this.MK += this.MI[1];
                    }
                    if (Math.abs(this.MJ[1]) >= 5 || Math.abs(this.MI[1]) >= 5) {
                        if (!this.ML) {
                            this.ML = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.ML) {
                            this.ML = false;
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
            this.MP.addMovement(motionEvent);
            this.MP.computeCurrentVelocity(1000, this.MN);
            float f2 = -VelocityTrackerCompat.getYVelocity(this.MP, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f2) > this.MM && !dispatchNestedPreFling(0.0f, f2) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f2, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.MG) < 10.0f) {
                Math.abs(motionEvent.getX() - this.MH);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.MG = y;
            this.MH = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.MJ;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.MI;
            iArr2[0] = 0;
            iArr2[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.ML = false;
        }
        if (!z) {
            this.MP.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.MO.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.MO.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.MO.stopNestedScroll();
    }
}
