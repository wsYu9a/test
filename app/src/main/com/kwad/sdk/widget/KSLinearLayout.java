package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class KSLinearLayout extends LinearLayout implements i {
    private final ag.a aHa;
    private g aXj;
    private i aXk;
    private final AtomicBoolean bP;
    private float mRatio;
    private h mViewRCHelper;

    public KSLinearLayout(@NonNull Context context) {
        super(context);
        this.bP = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aHa = new ag.a();
        init(context, null);
    }

    @CallSuper
    private void Z() {
        this.aXj.onAttachedToWindow();
    }

    @CallSuper
    private void aa() {
        this.aXj.onDetachedFromWindow();
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i10 = R.attr.ksad_ratio;
            int[] iArr = {i10};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i10), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.aXj = gVar;
        gVar.ch(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void ut() {
        if (this.bP.getAndSet(false)) {
            Z();
        }
    }

    private void uu() {
        if (this.bP.getAndSet(true)) {
            return;
        }
        aa();
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void C(View view) {
        i iVar = this.aXk;
        if (iVar != null) {
            iVar.C(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aHa.z(getWidth(), getHeight());
            this.aHa.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aHa.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @MainThread
    public ag.a getTouchCoords() {
        return this.aHa;
    }

    public float getVisiblePercent() {
        return this.aXj.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ut();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uu();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ut();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mRatio != 0.0f) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.mRatio), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.aXj.b(i10, i11, i12, i13);
        super.onSizeChanged(i10, i11, i12, i13);
        this.aXj.PR();
        this.mViewRCHelper.onSizeChanged(i10, i11);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        uu();
    }

    public void setRadius(float f10) {
        this.mViewRCHelper.setRadius(f10);
        postInvalidate();
    }

    public void setRatio(float f10) {
        this.mRatio = f10;
    }

    public void setViewVisibleListener(i iVar) {
        this.aXk = iVar;
    }

    public void setVisiblePercent(float f10) {
        this.aXj.setVisiblePercent(f10);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bP = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aHa = new ag.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.bP = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aHa = new ag.a();
        init(context, attributeSet);
    }
}
