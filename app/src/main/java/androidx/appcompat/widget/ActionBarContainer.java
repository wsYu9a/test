package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    private boolean f603a;

    /* renamed from: b */
    private View f604b;

    /* renamed from: c */
    private View f605c;

    /* renamed from: d */
    private View f606d;

    /* renamed from: e */
    Drawable f607e;

    /* renamed from: f */
    Drawable f608f;

    /* renamed from: g */
    Drawable f609g;

    /* renamed from: h */
    boolean f610h;

    /* renamed from: i */
    boolean f611i;

    /* renamed from: j */
    private int f612j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f607e;
        if (drawable != null && drawable.isStateful()) {
            this.f607e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f608f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f608f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f609g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f609g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f604b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f607e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f608f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f609g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f605c = findViewById(R.id.action_bar);
        this.f606d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f603a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f604b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f610h) {
            Drawable drawable2 = this.f609g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f607e != null) {
                if (this.f605c.getVisibility() == 0) {
                    this.f607e.setBounds(this.f605c.getLeft(), this.f605c.getTop(), this.f605c.getRight(), this.f605c.getBottom());
                } else {
                    View view2 = this.f606d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f607e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f607e.setBounds(this.f606d.getLeft(), this.f606d.getTop(), this.f606d.getRight(), this.f606d.getBottom());
                    }
                }
                z3 = true;
            }
            this.f611i = z4;
            if (!z4 || (drawable = this.f608f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.f605c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f612j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f605c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f604b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f605c) ? a(this.f605c) : !b(this.f606d) ? a(this.f606d) : 0) + a(this.f604b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f607e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f607e);
        }
        this.f607e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f605c;
            if (view != null) {
                this.f607e.setBounds(view.getLeft(), this.f605c.getTop(), this.f605c.getRight(), this.f605c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f610h ? this.f607e != null || this.f608f != null : this.f609g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f609g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f609g);
        }
        this.f609g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f610h && (drawable2 = this.f609g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f610h ? !(this.f607e != null || this.f608f != null) : this.f609g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f608f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f608f);
        }
        this.f608f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f611i && (drawable2 = this.f608f) != null) {
                drawable2.setBounds(this.f604b.getLeft(), this.f604b.getTop(), this.f604b.getRight(), this.f604b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f610h ? this.f607e != null || this.f608f != null : this.f609g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f604b;
        if (view != null) {
            removeView(view);
        }
        this.f604b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f603a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f607e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f608f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f609g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f607e && !this.f610h) || (drawable == this.f608f && this.f611i) || ((drawable == this.f609g && this.f610h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f607e = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f608f = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f612j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.f610h = true;
            this.f609g = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f610h ? this.f607e != null || this.f608f != null : this.f609g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
