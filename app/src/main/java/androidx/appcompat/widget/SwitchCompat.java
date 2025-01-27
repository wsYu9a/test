package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: a */
    private static final int f951a = 250;

    /* renamed from: b */
    private static final int f952b = 0;

    /* renamed from: c */
    private static final int f953c = 1;

    /* renamed from: d */
    private static final int f954d = 2;

    /* renamed from: e */
    private static final String f955e = "android.widget.Switch";

    /* renamed from: f */
    private static final int f956f = 1;

    /* renamed from: g */
    private static final int f957g = 2;

    /* renamed from: h */
    private static final int f958h = 3;

    /* renamed from: i */
    private static final Property<SwitchCompat, Float> f959i = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.H);
        }

        @Override // android.util.Property
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };

    /* renamed from: j */
    private static final int[] f960j = {R.attr.state_checked};
    private boolean A;
    private int B;
    private int C;
    private float D;
    private float E;
    private VelocityTracker F;
    private int G;
    float H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private final TextPaint P;
    private ColorStateList Q;
    private Layout R;
    private Layout S;
    private TransformationMethod T;
    ObjectAnimator U;
    private final AppCompatTextHelper V;
    private final Rect W;
    private Drawable k;
    private ColorStateList l;
    private PorterDuff.Mode m;
    private boolean n;
    private boolean o;
    private Drawable p;
    private ColorStateList q;
    private PorterDuff.Mode r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private CharSequence y;
    private CharSequence z;

    /* renamed from: androidx.appcompat.widget.SwitchCompat$1 */
    static class AnonymousClass1 extends Property<SwitchCompat, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.H);
        }

        @Override // android.util.Property
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private void a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f959i, z ? 1.0f : 0.0f);
        this.U = ofFloat;
        ofFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.U.setAutoCancel(true);
        }
        this.U.start();
    }

    private void b() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.n || this.o) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.k = mutate;
                if (this.n) {
                    DrawableCompat.setTintList(mutate, this.l);
                }
                if (this.o) {
                    DrawableCompat.setTintMode(this.k, this.m);
                }
                if (this.k.isStateful()) {
                    this.k.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.p;
        if (drawable != null) {
            if (this.s || this.t) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.p = mutate;
                if (this.s) {
                    DrawableCompat.setTintList(mutate, this.q);
                }
                if (this.t) {
                    DrawableCompat.setTintMode(this.p, this.r);
                }
                if (this.p.isStateful()) {
                    this.p.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private boolean g(float f2, float f3) {
        if (this.k == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.k.getPadding(this.W);
        int i2 = this.M;
        int i3 = this.C;
        int i4 = i2 - i3;
        int i5 = (this.L + thumbOffset) - i3;
        int i6 = this.K + i5;
        Rect rect = this.W;
        return f2 > ((float) i5) && f2 < ((float) (((i6 + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.O + i3));
    }

    private boolean getTargetCheckedState() {
        return this.H > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((ViewUtils.isLayoutRtl(this) ? 1.0f - this.H : this.H) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.p;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.W;
        drawable.getPadding(rect);
        Drawable drawable2 = this.k;
        Rect opticalBounds = drawable2 != null ? DrawableUtils.getOpticalBounds(drawable2) : DrawableUtils.INSETS_NONE;
        return ((((this.I - this.K) - rect.left) - rect.right) - opticalBounds.left) - opticalBounds.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.T;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.P, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void i(int i2, int i3) {
        setSwitchTypeface(i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i3);
    }

    private void j(MotionEvent motionEvent) {
        this.B = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.F.computeCurrentVelocity(1000);
            float xVelocity = this.F.getXVelocity();
            if (Math.abs(xVelocity) <= this.G) {
                z = getTargetCheckedState();
            } else if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        e(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.W;
        int i4 = this.L;
        int i5 = this.M;
        int i6 = this.N;
        int i7 = this.O;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.k;
        Rect opticalBounds = drawable != null ? DrawableUtils.getOpticalBounds(drawable) : DrawableUtils.INSETS_NONE;
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (opticalBounds != null) {
                int i9 = opticalBounds.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = opticalBounds.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = opticalBounds.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = opticalBounds.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.p.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.p.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.K + rect.right;
            this.k.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.k;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f2, f3);
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.k;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.w : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.w : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.A;
    }

    public boolean getSplitTrack() {
        return this.x;
    }

    public int getSwitchMinWidth() {
        return this.v;
    }

    public int getSwitchPadding() {
        return this.w;
    }

    public CharSequence getTextOff() {
        return this.z;
    }

    public CharSequence getTextOn() {
        return this.y;
    }

    public Drawable getThumbDrawable() {
        return this.k;
    }

    public int getThumbTextPadding() {
        return this.u;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.l;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.m;
    }

    public Drawable getTrackDrawable() {
        return this.p;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.q;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.r;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.U.end();
        this.U = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f960j);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.W;
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.M;
        int i3 = this.O;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.k;
        if (drawable != null) {
            if (!this.x || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.R : this.S;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.Q;
            if (colorStateList != null) {
                this.P.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.P.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f955e);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f955e);
        CharSequence charSequence = isChecked() ? this.y : this.z;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i2, i3, i4, i5);
        int i11 = 0;
        if (this.k != null) {
            Rect rect = this.W;
            Drawable drawable = this.p;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.k);
            i6 = Math.max(0, opticalBounds.left - rect.left);
            i11 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i6 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.I + i7) - i6) - i11;
        } else {
            width = (getWidth() - getPaddingRight()) - i11;
            i7 = (width - this.I) + i6 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i8 = this.J;
            i9 = paddingTop - (i8 / 2);
        } else {
            if (gravity == 80) {
                i10 = getHeight() - getPaddingBottom();
                i9 = i10 - this.J;
                this.L = i7;
                this.M = i9;
                this.O = i10;
                this.N = width;
            }
            i9 = getPaddingTop();
            i8 = this.J;
        }
        i10 = i8 + i9;
        this.L = i7;
        this.M = i9;
        this.O = i10;
        this.N = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.A) {
            if (this.R == null) {
                this.R = h(this.y);
            }
            if (this.S == null) {
                this.S = h(this.z);
            }
        }
        Rect rect = this.W;
        Drawable drawable = this.k;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.k.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.k.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        this.K = Math.max(this.A ? Math.max(this.R.getWidth(), this.S.getWidth()) + (this.u * 2) : 0, i4);
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.p.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i7 = Math.max(i7, opticalBounds.left);
            i8 = Math.max(i8, opticalBounds.right);
        }
        int max = Math.max(this.v, (this.K * 2) + i7 + i8);
        int max2 = Math.max(i6, i5);
        this.I = max;
        this.J = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.y : this.z;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L90;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.F
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.B
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.D
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.H
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.H
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.D = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.D
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.C
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.E
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.C
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.B = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.D = r0
            r6.E = r3
            return r1
        L8b:
            int r0 = r6.B
            if (r0 != r2) goto L96
            r6.j(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.B = r0
            android.view.VelocityTracker r0 = r6.F
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.g(r0, r2)
            if (r3 == 0) goto Lb9
            r6.B = r1
            r6.D = r0
            r6.E = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            a(isChecked);
        } else {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.A != z) {
            this.A = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.x = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.v = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.w = i2;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i2) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i2, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.Q = colorStateList;
        } else {
            this.Q = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f2 = dimensionPixelSize;
            if (f2 != this.P.getTextSize()) {
                this.P.setTextSize(f2);
                requestLayout();
            }
        }
        i(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.T = new AllCapsTransformationMethod(getContext());
        } else {
            this.T = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i2) {
        if (i2 <= 0) {
            this.P.setFakeBoldText(false);
            this.P.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ (-1)) & i2;
            this.P.setFakeBoldText((style & 1) != 0);
            this.P.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.z = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.y = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f2) {
        this.H = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.u = i2;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.l = colorStateList;
        this.n = true;
        b();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.p = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.q = colorStateList;
        this.s = true;
        c();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.r = mode;
        this.t = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.k || drawable == this.p;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = false;
        this.F = VelocityTracker.obtain();
        this.W = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.P = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.SwitchCompat, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.p = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.y = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.z = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.A = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.u = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.v = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.w = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.x = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.l = colorStateList;
            this.n = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.m != parseTintMode) {
            this.m = parseTintMode;
            this.o = true;
        }
        if (this.n || this.o) {
            b();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.q = colorStateList2;
            this.s = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.r != parseTintMode2) {
            this.r = parseTintMode2;
            this.t = true;
        }
        if (this.s || this.t) {
            c();
        }
        int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.V = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.C = viewConfiguration.getScaledTouchSlop();
        this.G = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.P.getTypeface() == null || this.P.getTypeface().equals(typeface)) && (this.P.getTypeface() != null || typeface == null)) {
            return;
        }
        this.P.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
