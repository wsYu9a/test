package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class u {

    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f7387a;

        a(View view) {
            this.f7387a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f7387a.getContext().getSystemService("input_method")).showSoftInput(this.f7387a, 1);
        }
    }

    static class b implements e {

        /* renamed from: a */
        final /* synthetic */ boolean f7388a;

        /* renamed from: b */
        final /* synthetic */ boolean f7389b;

        /* renamed from: c */
        final /* synthetic */ boolean f7390c;

        /* renamed from: d */
        final /* synthetic */ e f7391d;

        b(boolean z, boolean z2, boolean z3, e eVar) {
            this.f7388a = z;
            this.f7389b = z2;
            this.f7390c = z3;
            this.f7391d = eVar;
        }

        @Override // com.google.android.material.internal.u.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            if (this.f7388a) {
                fVar.f7397d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean i2 = u.i(view);
            if (this.f7389b) {
                if (i2) {
                    fVar.f7396c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    fVar.f7394a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f7390c) {
                if (i2) {
                    fVar.f7394a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    fVar.f7396c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            fVar.a(view);
            e eVar = this.f7391d;
            return eVar != null ? eVar.a(view, windowInsetsCompat, fVar) : windowInsetsCompat;
        }
    }

    static class c implements OnApplyWindowInsetsListener {

        /* renamed from: a */
        final /* synthetic */ e f7392a;

        /* renamed from: b */
        final /* synthetic */ f f7393b;

        c(e eVar, f fVar) {
            this.f7392a = eVar;
            this.f7393b = fVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f7392a.a(view, windowInsetsCompat, new f(this.f7393b));
        }
    }

    static class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface e {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f fVar);
    }

    private u() {
    }

    public static void a(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3) {
        b(view, attributeSet, i2, i3, null);
    }

    public static void b(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable e eVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        c(view, new b(z, z2, z3, eVar));
    }

    public static void c(@NonNull View view, @NonNull e eVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(eVar, new f(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        k(view);
    }

    public static float d(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static ViewGroup e(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static t f(@NonNull View view) {
        return g(e(view));
    }

    @Nullable
    public static t g(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 18 ? new s(view) : r.a(view);
    }

    public static float h(@NonNull View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ViewCompat.getElevation((View) parent);
        }
        return f2;
    }

    public static boolean i(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode j(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void k(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void l(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class f {

        /* renamed from: a */
        public int f7394a;

        /* renamed from: b */
        public int f7395b;

        /* renamed from: c */
        public int f7396c;

        /* renamed from: d */
        public int f7397d;

        public f(int i2, int i3, int i4, int i5) {
            this.f7394a = i2;
            this.f7395b = i3;
            this.f7396c = i4;
            this.f7397d = i5;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.f7394a, this.f7395b, this.f7396c, this.f7397d);
        }

        public f(@NonNull f fVar) {
            this.f7394a = fVar.f7394a;
            this.f7395b = fVar.f7395b;
            this.f7396c = fVar.f7396c;
            this.f7397d = fVar.f7397d;
        }
    }
}
