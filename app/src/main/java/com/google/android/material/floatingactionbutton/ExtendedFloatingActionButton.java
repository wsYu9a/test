package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int x = 0;
    private static final int y = 1;
    private static final int z = 2;
    private int C;
    private final com.google.android.material.floatingactionbutton.a D;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f E;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f F;
    private final com.google.android.material.floatingactionbutton.f G;
    private final com.google.android.material.floatingactionbutton.f H;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> I;
    private boolean J;
    private static final int w = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> A = new d(Float.class, "width");
    static final Property<View, Float> B = new e(Float.class, "height");

    class a implements j {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getMeasuredWidth();
        }
    }

    class b implements j {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f7148a;

        /* renamed from: b */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f7149b;

        /* renamed from: c */
        final /* synthetic */ h f7150c;

        c(com.google.android.material.floatingactionbutton.f fVar, h hVar) {
            this.f7149b = fVar;
            this.f7150c = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7148a = true;
            this.f7149b.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7149b.i();
            if (this.f7148a) {
                return;
            }
            this.f7149b.m(this.f7150c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f7149b.onAnimationStart(animator);
            this.f7148a = false;
        }
    }

    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    }

    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    }

    class f extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g */
        private final j f7152g;

        /* renamed from: h */
        private final boolean f7153h;

        f(com.google.android.material.floatingactionbutton.a aVar, j jVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f7152g = jVar;
            this.f7153h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.J = this.f7153h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f7152g.a().width;
            layoutParams.height = this.f7152g.a().height;
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return this.f7153h == ExtendedFloatingActionButton.this.J || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R.animator.mtrl_extended_fab_change_size_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f7152g.a().width;
            layoutParams.height = this.f7152g.a().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        @NonNull
        public AnimatorSet k() {
            com.google.android.material.a.h a2 = a();
            if (a2.j("width")) {
                PropertyValuesHolder[] g2 = a2.g("width");
                g2[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f7152g.getWidth());
                a2.l("width", g2);
            }
            if (a2.j("height")) {
                PropertyValuesHolder[] g3 = a2.g("height");
                g3[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f7152g.getHeight());
                a2.l("height", g3);
            }
            return super.n(a2);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@Nullable h hVar) {
            if (hVar == null) {
                return;
            }
            if (this.f7153h) {
                hVar.a(ExtendedFloatingActionButton.this);
            } else {
                hVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.J = this.f7153h;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    class g extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g */
        private boolean f7155g;

        public g(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.C();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void f() {
            super.f();
            this.f7155g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.C = 0;
            if (this.f7155g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@Nullable h hVar) {
            if (hVar != null) {
                hVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f7155g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.C = 1;
        }
    }

    public static abstract class h {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    class i extends com.google.android.material.floatingactionbutton.b {
        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.D();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.C = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@Nullable h hVar) {
            if (hVar != null) {
                hVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.C = 2;
        }
    }

    interface j {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public boolean C() {
        return getVisibility() == 0 ? this.C == 1 : this.C != 2;
    }

    public boolean D() {
        return getVisibility() != 0 ? this.C == 2 : this.C != 1;
    }

    public void E(@NonNull com.google.android.material.floatingactionbutton.f fVar, @Nullable h hVar) {
        if (fVar.d()) {
            return;
        }
        if (!J()) {
            fVar.b();
            fVar.m(hVar);
            return;
        }
        measure(0, 0);
        AnimatorSet k = fVar.k();
        k.addListener(new c(fVar, hVar));
        Iterator<Animator.AnimatorListener> it = fVar.l().iterator();
        while (it.hasNext()) {
            k.addListener(it.next());
        }
        k.start();
    }

    private boolean J() {
        return ViewCompat.isLaidOut(this) && !isInEditMode();
    }

    public void A(@NonNull h hVar) {
        E(this.H, hVar);
    }

    public final boolean B() {
        return this.J;
    }

    public void F(@NonNull Animator.AnimatorListener animatorListener) {
        this.F.e(animatorListener);
    }

    public void G(@NonNull Animator.AnimatorListener animatorListener) {
        this.H.e(animatorListener);
    }

    public void H(@NonNull Animator.AnimatorListener animatorListener) {
        this.G.e(animatorListener);
    }

    public void I(@NonNull Animator.AnimatorListener animatorListener) {
        this.E.e(animatorListener);
    }

    public void K() {
        E(this.G, null);
    }

    public void L(@NonNull h hVar) {
        E(this.G, hVar);
    }

    public void M() {
        E(this.E, null);
    }

    public void N(@NonNull h hVar) {
        E(this.E, hVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.I;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    @Nullable
    public com.google.android.material.a.h getExtendMotionSpec() {
        return this.F.c();
    }

    @Nullable
    public com.google.android.material.a.h getHideMotionSpec() {
        return this.H.c();
    }

    @Nullable
    public com.google.android.material.a.h getShowMotionSpec() {
        return this.G.c();
    }

    @Nullable
    public com.google.android.material.a.h getShrinkMotionSpec() {
        return this.E.c();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.J && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.J = false;
            this.E.b();
        }
    }

    public void setExtendMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.F.j(hVar);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(com.google.android.material.a.h.d(getContext(), i2));
    }

    public void setExtended(boolean z2) {
        if (this.J == z2) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z2 ? this.F : this.E;
        if (fVar.d()) {
            return;
        }
        fVar.b();
    }

    public void setHideMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.H.j(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(com.google.android.material.a.h.d(getContext(), i2));
    }

    public void setShowMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.G.j(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(com.google.android.material.a.h.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.E.j(hVar);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(com.google.android.material.a.h.d(getContext(), i2));
    }

    public void t(@NonNull Animator.AnimatorListener animatorListener) {
        this.F.h(animatorListener);
    }

    public void u(@NonNull Animator.AnimatorListener animatorListener) {
        this.H.h(animatorListener);
    }

    public void v(@NonNull Animator.AnimatorListener animatorListener) {
        this.G.h(animatorListener);
    }

    public void w(@NonNull Animator.AnimatorListener animatorListener) {
        this.E.h(animatorListener);
    }

    public void x() {
        E(this.F, null);
    }

    public void y(@NonNull h hVar) {
        E(this.F, hVar);
    }

    public void z() {
        E(this.H, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a */
        private static final boolean f7139a = false;

        /* renamed from: b */
        private static final boolean f7140b = true;

        /* renamed from: c */
        private Rect f7141c;

        /* renamed from: d */
        @Nullable
        private h f7142d;

        /* renamed from: e */
        @Nullable
        private h f7143e;

        /* renamed from: f */
        private boolean f7144f;

        /* renamed from: g */
        private boolean f7145g;

        public ExtendedFloatingActionButtonBehavior() {
            this.f7144f = false;
            this.f7145g = true;
        }

        private static boolean e(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean l(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f7144f || this.f7145g) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean n(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!l(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f7141c == null) {
                this.f7141c = new Rect();
            }
            Rect rect = this.f7141c;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                m(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        private boolean o(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!l(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                m(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        protected void a(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f7145g;
            extendedFloatingActionButton.E(z ? extendedFloatingActionButton.F : extendedFloatingActionButton.G, z ? this.f7143e : this.f7142d);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean c() {
            return this.f7144f;
        }

        public boolean d() {
            return this.f7145g;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                n(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!e(view)) {
                return false;
            }
            o(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (e(view) && o(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (n(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
            return true;
        }

        public void h(boolean z) {
            this.f7144f = z;
        }

        public void i(boolean z) {
            this.f7145g = z;
        }

        @VisibleForTesting
        void j(@Nullable h hVar) {
            this.f7142d = hVar;
        }

        @VisibleForTesting
        void k(@Nullable h hVar) {
            this.f7143e = hVar;
        }

        protected void m(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f7145g;
            extendedFloatingActionButton.E(z ? extendedFloatingActionButton.E : extendedFloatingActionButton.H, z ? this.f7143e : this.f7142d);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f7144f = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f7145g = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.w
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.a.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.C = r10
            com.google.android.material.floatingactionbutton.a r1 = new com.google.android.material.floatingactionbutton.a
            r1.<init>()
            r0.D = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i
            r11.<init>(r1)
            r0.G = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$g r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$g
            r12.<init>(r1)
            r0.H = r12
            r13 = 1
            r0.J = r13
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.I = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.n.j(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.a.h r2 = com.google.android.material.a.h.c(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.a.h r3 = com.google.android.material.a.h.c(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.a.h r4 = com.google.android.material.a.h.c(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.a.h r5 = com.google.android.material.a.h.c(r14, r1, r5)
            com.google.android.material.floatingactionbutton.a r6 = new com.google.android.material.floatingactionbutton.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.F = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.E = r10
            r11.j(r2)
            r12.j(r3)
            r15.j(r4)
            r10.j(r5)
            r1.recycle()
            com.google.android.material.j.d r1 = com.google.android.material.j.o.f7439a
            r2 = r18
            com.google.android.material.j.o$b r1 = com.google.android.material.j.o.g(r14, r2, r8, r9, r1)
            com.google.android.material.j.o r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
