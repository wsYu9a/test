package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int Q = R.style.Widget_MaterialComponents_BottomAppBar;
    private static final long R = 300;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 0;
    public static final int V = 1;
    private final int W;
    private final com.google.android.material.j.j a0;

    @Nullable
    private Animator b0;

    @Nullable
    private Animator c0;
    private int d0;
    private int e0;
    private boolean f0;
    private final boolean g0;
    private final boolean h0;
    private final boolean i0;
    private int j0;
    private ArrayList<i> k0;
    private boolean l0;
    private Behavior m0;
    private int n0;
    private int o0;
    private int p0;

    @NonNull
    AnimatorListenerAdapter q0;

    @NonNull
    com.google.android.material.a.k<FloatingActionButton> r0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.r0(bottomAppBar.d0, BottomAppBar.this.l0);
        }
    }

    class b implements com.google.android.material.a.k<FloatingActionButton> {
        b() {
        }

        @Override // com.google.android.material.a.k
        /* renamed from: c */
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar.this.a0.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.a.k
        /* renamed from: d */
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().h() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().m(translationX);
                BottomAppBar.this.a0.invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().d() != max) {
                BottomAppBar.this.getTopEdgeTreatment().i(max);
                BottomAppBar.this.a0.invalidateSelf();
            }
            BottomAppBar.this.a0.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    class c implements u.e {
        c() {
        }

        @Override // com.google.android.material.internal.u.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull u.f fVar) {
            boolean z;
            if (BottomAppBar.this.g0) {
                BottomAppBar.this.n0 = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z2 = false;
            if (BottomAppBar.this.h0) {
                z = BottomAppBar.this.p0 != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.p0 = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            if (BottomAppBar.this.i0) {
                boolean z3 = BottomAppBar.this.o0 != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.o0 = windowInsetsCompat.getSystemWindowInsetRight();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.g0();
                BottomAppBar.this.y0();
                BottomAppBar.this.x0();
            }
            return windowInsetsCompat;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.k0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.l0();
        }
    }

    class e extends FloatingActionButton.b {

        /* renamed from: a */
        final /* synthetic */ int f6767a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.k0();
            }
        }

        e(int i2) {
            this.f6767a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.p0(this.f6767a));
            floatingActionButton.A(new a());
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.k0();
            BottomAppBar.this.c0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.l0();
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f6771a;

        /* renamed from: b */
        final /* synthetic */ ActionMenuView f6772b;

        /* renamed from: c */
        final /* synthetic */ int f6773c;

        /* renamed from: d */
        final /* synthetic */ boolean f6774d;

        g(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f6772b = actionMenuView;
            this.f6773c = i2;
            this.f6774d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6771a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f6771a) {
                return;
            }
            BottomAppBar.this.A0(this.f6772b, this.f6773c, this.f6774d);
        }
    }

    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.q0.onAnimationStart(animator);
            FloatingActionButton m0 = BottomAppBar.this.m0();
            if (m0 != null) {
                m0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface i {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    static class l extends AbsSavedState {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: b */
        int f6777b;

        /* renamed from: c */
        boolean f6778c;

        static class a implements Parcelable.ClassLoaderCreator<l> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public l createFromParcel(@NonNull Parcel parcel) {
                return new l(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public l createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new l(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public l[] newArray(int i2) {
                return new l[i2];
            }
        }

        public l(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6777b);
            parcel.writeInt(this.f6778c ? 1 : 0);
        }

        public l(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6777b = parcel.readInt();
            this.f6778c = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    public void A0(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        actionMenuView.setTranslationX(o0(actionMenuView, i2, z));
    }

    public void f0(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.f(this.q0);
        floatingActionButton.g(new h());
        floatingActionButton.h(this.r0);
    }

    public void g0() {
        Animator animator = this.c0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.b0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public int getBottomInset() {
        return this.n0;
    }

    public float getFabTranslationX() {
        return p0(this.d0);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().d();
    }

    public int getLeftInset() {
        return this.p0;
    }

    public int getRightInset() {
        return this.o0;
    }

    @NonNull
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.a0.getShapeAppearanceModel().p();
    }

    private void i0(int i2, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m0(), "translationX", p0(i2));
        ofFloat.setDuration(R);
        list.add(ofFloat);
    }

    private void j0(int i2, boolean z, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - o0(actionMenuView, i2, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new g(actionMenuView, i2, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    public void k0() {
        ArrayList<i> arrayList;
        int i2 = this.j0 - 1;
        this.j0 = i2;
        if (i2 != 0 || (arrayList = this.k0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public void l0() {
        ArrayList<i> arrayList;
        int i2 = this.j0;
        this.j0 = i2 + 1;
        if (i2 != 0 || (arrayList = this.k0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    @Nullable
    public FloatingActionButton m0() {
        View n0 = n0();
        if (n0 instanceof FloatingActionButton) {
            return (FloatingActionButton) n0;
        }
        return null;
    }

    @Nullable
    public View n0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public float p0(int i2) {
        boolean i3 = u.i(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.W + (i3 ? this.p0 : this.o0))) * (i3 ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean q0() {
        FloatingActionButton m0 = m0();
        return m0 != null && m0.r();
    }

    public void r0(int i2, boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            Animator animator = this.c0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!q0()) {
                i2 = 0;
                z = false;
            }
            j0(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.c0 = animatorSet;
            animatorSet.addListener(new f());
            this.c0.start();
        }
    }

    private void s0(int i2) {
        if (this.d0 == i2 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.b0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.e0 == 1) {
            i0(i2, arrayList);
        } else {
            h0(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.b0 = animatorSet;
        animatorSet.addListener(new d());
        this.b0.start();
    }

    public void x0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (q0()) {
                A0(actionMenuView, this.d0, this.l0);
            } else {
                A0(actionMenuView, 0, false);
            }
        }
    }

    public void y0() {
        getTopEdgeTreatment().m(getFabTranslationX());
        View n0 = n0();
        this.a0.o0((this.l0 && q0()) ? 1.0f : 0.0f);
        if (n0 != null) {
            n0.setTranslationY(getFabTranslationY());
            n0.setTranslationX(getFabTranslationX());
        }
    }

    void e0(@NonNull i iVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList<>();
        }
        this.k0.add(iVar);
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.a0.Q();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d();
    }

    public int getFabAlignmentMode() {
        return this.d0;
    }

    public int getFabAnimationMode() {
        return this.e0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f0;
    }

    protected void h0(int i2, List<Animator> list) {
        FloatingActionButton m0 = m0();
        if (m0 == null || m0.q()) {
            return;
        }
        l0();
        m0.o(new e(i2));
    }

    protected int o0(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean i3 = u.i(this);
        int measuredWidth = i3 ? getMeasuredWidth() : 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                measuredWidth = i3 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((i3 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (i3 ? this.o0 : -this.p0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.j.k.f(this, this.a0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            g0();
            y0();
        }
        x0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.getSuperState());
        this.d0 = lVar.f6777b;
        this.l0 = lVar.f6778c;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        lVar.f6777b = this.d0;
        lVar.f6778c = this.l0;
        return lVar;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.a0, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f2);
            this.a0.invalidateSelf();
            y0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.a0.m0(f2);
        getBehavior().c(this, this.a0.J() - this.a0.I());
    }

    public void setFabAlignmentMode(int i2) {
        s0(i2);
        r0(i2, this.l0);
        this.d0 = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.e0 = i2;
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().j(f2);
            this.a0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().k(f2);
            this.a0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.f0 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void t0() {
        getBehavior().d(this);
    }

    public void u0() {
        getBehavior().e(this);
    }

    void v0(@NonNull i iVar) {
        ArrayList<i> arrayList = this.k0;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    public void w0(@MenuRes int i2) {
        getMenu().clear();
        inflateMenu(i2);
    }

    boolean z0(@Px int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().g()) {
            return false;
        }
        getTopEdgeTreatment().l(f2);
        this.a0.invalidateSelf();
        return true;
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.m0 == null) {
            this.m0 = new Behavior();
        }
        return this.m0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: i */
        @NonNull
        private final Rect f6760i;

        /* renamed from: j */
        private WeakReference<BottomAppBar> f6761j;
        private int k;
        private final View.OnLayoutChangeListener l;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f6761j.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.l(Behavior.this.f6760i);
                int height = Behavior.this.f6760i.height();
                bottomAppBar.z0(height);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.k == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (u.i(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.W;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.W;
                    }
                }
            }
        }

        public Behavior() {
            this.l = new a();
            this.f6760i = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: i */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            this.f6761j = new WeakReference<>(bottomAppBar);
            View n0 = bottomAppBar.n0();
            if (n0 != null && !ViewCompat.isLaidOut(n0)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) n0.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.k = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (n0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) n0;
                    floatingActionButton.addOnLayoutChangeListener(this.l);
                    bottomAppBar.f0(floatingActionButton);
                }
                bottomAppBar.y0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.l = new a();
            this.f6760i = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.bottomappbar.BottomAppBar.Q
            android.content.Context r11 = com.google.android.material.theme.a.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            com.google.android.material.j.j r11 = new com.google.android.material.j.j
            r11.<init>()
            r10.a0 = r11
            r7 = 0
            r10.j0 = r7
            r0 = 1
            r10.l0 = r0
            com.google.android.material.bottomappbar.BottomAppBar$a r0 = new com.google.android.material.bottomappbar.BottomAppBar$a
            r0.<init>()
            r10.q0 = r0
            com.google.android.material.bottomappbar.BottomAppBar$b r0 = new com.google.android.material.bottomappbar.BottomAppBar$b
            r0.<init>()
            r10.r0 = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.n.j(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = com.google.android.material.g.c.a(r8, r0, r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.d0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.e0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.g0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.h0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.i0 = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.W = r0
            com.google.android.material.bottomappbar.a r0 = new com.google.android.material.bottomappbar.a
            r0.<init>(r3, r4, r5)
            com.google.android.material.j.o$b r3 = com.google.android.material.j.o.a()
            com.google.android.material.j.o$b r0 = r3.G(r0)
            com.google.android.material.j.o r0 = r0.m()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.w0(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.q0(r0)
            r11.Y(r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r1)
            androidx.core.view.ViewCompat.setBackground(r10, r11)
            com.google.android.material.bottomappbar.BottomAppBar$c r11 = new com.google.android.material.bottomappbar.BottomAppBar$c
            r11.<init>()
            com.google.android.material.internal.u.b(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
