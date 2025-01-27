package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.j.k;
import com.google.android.material.j.o;
import com.google.android.material.j.s;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, s {

    /* renamed from: j */
    private static final int[] f6915j = {R.attr.state_checkable};
    private static final int[] k = {R.attr.state_checked};
    private static final int[] l = {com.google.android.material.R.attr.state_dragged};
    private static final int m = com.google.android.material.R.style.Widget_MaterialComponents_CardView;
    private static final String n = "MaterialCardView";
    private static final String o = "androidx.cardview.widget.CardView";

    @NonNull
    private final com.google.android.material.card.a p;
    private boolean q;
    private boolean r;
    private boolean s;
    private a t;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.p.k().getBounds());
        return rectF;
    }

    private void j() {
        if (Build.VERSION.SDK_INT > 26) {
            this.p.j();
        }
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.p.l();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.p.m();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.p.n();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.p.o();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.p.y().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.p.y().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.p.y().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.p.y().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.p.s();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.p.q();
    }

    public ColorStateList getRippleColor() {
        return this.p.t();
    }

    @Override // com.google.android.material.j.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.p.u();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.p.v();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.p.w();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.p.x();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.r;
    }

    public boolean k() {
        com.google.android.material.card.a aVar = this.p;
        return aVar != null && aVar.B();
    }

    public boolean l() {
        return this.s;
    }

    void m(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.p.k());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (k()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f6915j);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, k);
        }
        if (l()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, l);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(o);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(o);
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.p.D(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.q) {
            if (!this.p.A()) {
                Log.i(n, "Setting a custom background is not supported.");
                this.p.E(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.p.F(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.p.V();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.p.G(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.p.H(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.r != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.p.I(drawable);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.p.I(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.p.J(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        com.google.android.material.card.a aVar = this.p;
        if (aVar != null) {
            aVar.T();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.p.Q(i2, i3, i4, i5);
    }

    public void setDragged(boolean z) {
        if (this.s != z) {
            this.s = z;
            refreshDrawableState();
            j();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.p.X();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
        this.t = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.p.X();
        this.p.U();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.p.L(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.p.K(f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.p.M(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i2) {
        this.p.M(AppCompatResources.getColorStateList(getContext(), i2));
    }

    @Override // com.google.android.material.j.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(oVar.u(getBoundsAsRectF()));
        }
        this.p.N(oVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.p.O(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        this.p.P(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.p.X();
        this.p.U();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (k() && isEnabled()) {
            this.r = !this.r;
            refreshDrawableState();
            j();
            a aVar = this.t;
            if (aVar != null) {
                aVar.a(this, this.r);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.p.F(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.p.O(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.m
            android.content.Context r8 = com.google.android.material.theme.a.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.r = r8
            r7.s = r8
            r0 = 1
            r7.q = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.n.j(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.a r0 = new com.google.android.material.card.a
            r0.<init>(r7, r9, r10, r6)
            r7.p = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.F(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.Q(r9, r10, r1, r2)
            r0.C(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
