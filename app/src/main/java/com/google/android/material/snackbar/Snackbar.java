package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] I;
    private static final int[] J;

    @Nullable
    private final AccessibilityManager K;
    private boolean L;

    @Nullable
    private BaseTransientBottomBar.s<Snackbar> M;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.y {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f7781a;

        a(View.OnClickListener onClickListener) {
            this.f7781a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7781a.onClick(view);
            Snackbar.this.u(1);
        }
    }

    public static class b extends BaseTransientBottomBar.s<Snackbar> {

        /* renamed from: f */
        public static final int f7783f = 0;

        /* renamed from: g */
        public static final int f7784g = 1;

        /* renamed from: h */
        public static final int f7785h = 2;

        /* renamed from: i */
        public static final int f7786i = 3;

        /* renamed from: j */
        public static final int f7787j = 4;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s
        /* renamed from: c */
        public void a(Snackbar snackbar, int i2) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s
        /* renamed from: d */
        public void b(Snackbar snackbar) {
        }
    }

    static {
        int i2 = R.attr.snackbarButtonStyle;
        I = new int[]{i2};
        J = new int[]{i2, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.a aVar) {
        super(viewGroup, view, aVar);
        this.K = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup h0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @Deprecated
    protected static boolean i0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(I);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean j0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(J);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar k0(@NonNull View view, @StringRes int i2, int i3) {
        return l0(view, view.getResources().getText(i2), i3);
    }

    @NonNull
    public static Snackbar l0(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        ViewGroup h0 = h0(view);
        if (h0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(h0.getContext()).inflate(j0(h0.getContext()) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, h0, false);
        Snackbar snackbar = new Snackbar(h0, snackbarContentLayout, snackbarContentLayout);
        snackbar.w0(charSequence);
        snackbar.U(i2);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean K() {
        return super.K();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void Z() {
        super.Z();
    }

    @NonNull
    public Snackbar m0(@StringRes int i2, View.OnClickListener onClickListener) {
        return n0(getContext().getText(i2), onClickListener);
    }

    @NonNull
    public Snackbar n0(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.s.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.L = false;
        } else {
            this.L = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        }
        return this;
    }

    @NonNull
    public Snackbar o0(@ColorInt int i2) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).getActionView().setTextColor(i2);
        return this;
    }

    @NonNull
    public Snackbar p0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar q0(@ColorInt int i2) {
        return r0(ColorStateList.valueOf(i2));
    }

    @NonNull
    public Snackbar r0(@Nullable ColorStateList colorStateList) {
        this.s.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar s0(@Nullable PorterDuff.Mode mode) {
        this.s.setBackgroundTintMode(mode);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void t() {
        super.t();
    }

    @NonNull
    @Deprecated
    public Snackbar t0(@Nullable b bVar) {
        BaseTransientBottomBar.s<Snackbar> sVar = this.M;
        if (sVar != null) {
            P(sVar);
        }
        if (bVar != null) {
            p(bVar);
        }
        this.M = bVar;
        return this;
    }

    @NonNull
    public Snackbar u0(@Dimension int i2) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).setMaxInlineActionWidth(i2);
        return this;
    }

    @NonNull
    public Snackbar v0(@StringRes int i2) {
        return w0(getContext().getText(i2));
    }

    @NonNull
    public Snackbar w0(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @NonNull
    public Snackbar x0(@ColorInt int i2) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).getMessageView().setTextColor(i2);
        return this;
    }

    @NonNull
    public Snackbar y0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.s.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int z() {
        int z = super.z();
        if (z == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.K.getRecommendedTimeoutMillis(z, (this.L ? 4 : 0) | 1 | 2);
        }
        if (this.L && this.K.isTouchExplorationEnabled()) {
            return -2;
        }
        return z;
    }
}
