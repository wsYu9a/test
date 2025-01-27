package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class KSFrameLayout extends FrameLayout implements e, i {
    private static final String TAG = "KSFrameLayout";
    private final AtomicBoolean mIsViewDetached;
    private View mPvView;
    private float mRatio;
    private final ac.a mTouchCoords;
    private g mViewPvHelper;
    private h mViewRCHelper;
    private i mViewVisibleListener;
    private boolean widthBasedRatio;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, null);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, View view) {
        super(context);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        this.mPvView = view;
        init(context, null);
    }

    private View getPvView() {
        View view = this.mPvView;
        return view == null ? this : view;
    }

    private float[] getRadius(float f2, float f3, float f4, float f5) {
        return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i2 = R.attr.ksad_ratio;
            int[] iArr = {i2};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i2), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(getPvView(), this);
        this.mViewPvHelper = gVar;
        gVar.bJ(enableFirstVisible());
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void viewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i(TAG, "onViewAttached");
            onViewAttached();
        }
    }

    private void viewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i(TAG, "onViewDetached");
        onViewDetached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchCoords.u(getWidth(), getHeight());
            this.mTouchCoords.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.mTouchCoords.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    protected boolean enableFirstVisible() {
        return true;
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ac.a getTouchCoords() {
        return this.mTouchCoords;
    }

    public float getVisiblePercent() {
        return this.mViewPvHelper.getVisiblePercent();
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        viewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        viewDetached();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        viewAttached();
    }

    @CallSuper
    public void onFirstVisible(View view) {
        i iVar = this.mViewVisibleListener;
        if (iVar != null) {
            iVar.onFirstVisible(view);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * this.mRatio), 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.mViewPvHelper.b(i2, i3, i4, i5);
        super.onSizeChanged(i2, i3, i4, i5);
        this.mViewPvHelper.FB();
        this.mViewRCHelper.onSizeChanged(i2, i3);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        viewDetached();
    }

    @CallSuper
    protected void onViewAttached() {
        this.mViewPvHelper.onAttachedToWindow();
    }

    @CallSuper
    protected void onViewDetached() {
        this.mViewPvHelper.onDetachedFromWindow();
    }

    public void resetPvAfterDataChange() {
        this.mViewPvHelper.resetPvAfterDataChange();
    }

    public void setAllCorner(boolean z) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z);
    }

    public void setRadius(float f2) {
        this.mViewRCHelper.setRadius(f2);
        postInvalidate();
    }

    public void setRadius(float f2, float f3, float f4, float f5) {
        this.mViewRCHelper.setRadius(getRadius(f2, f3, f4, f5));
        postInvalidate();
    }

    public void setRatio(float f2) {
        this.mRatio = f2;
    }

    public void setViewVisibleListener(i iVar) {
        this.mViewVisibleListener = iVar;
    }

    public void setVisiblePercent(float f2) {
        this.mViewPvHelper.setVisiblePercent(f2);
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }
}
