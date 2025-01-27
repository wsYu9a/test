package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.e.b;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a */
    private static final int f7965a = 0;

    /* renamed from: b */
    private static final int f7966b = 1;

    /* renamed from: c */
    private static final int f7967c = 2;

    /* renamed from: d */
    private int f7968d;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        final /* synthetic */ View f7969a;

        /* renamed from: b */
        final /* synthetic */ int f7970b;

        /* renamed from: c */
        final /* synthetic */ b f7971c;

        a(View view, int i2, b bVar) {
            this.f7969a = view;
            this.f7970b = i2;
            this.f7971c = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f7969a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f7968d == this.f7970b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f7971c;
                expandableBehavior.e((View) bVar, this.f7969a, bVar.b(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f7968d = 0;
    }

    private boolean b(boolean z) {
        if (!z) {
            return this.f7968d == 1;
        }
        int i2 = this.f7968d;
        return i2 == 0 || i2 == 2;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T d(@NonNull View view, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof ExpandableBehavior) {
            return cls.cast(behavior);
        }
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected b c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = dependencies.get(i2);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    protected abstract boolean e(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!b(bVar.b())) {
            return false;
        }
        this.f7968d = bVar.b() ? 1 : 2;
        return e((View) bVar, view, bVar.b(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        b c2;
        if (ViewCompat.isLaidOut(view) || (c2 = c(coordinatorLayout, view)) == null || !b(c2.b())) {
            return false;
        }
        int i3 = c2.b() ? 1 : 2;
        this.f7968d = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, c2));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7968d = 0;
    }
}
