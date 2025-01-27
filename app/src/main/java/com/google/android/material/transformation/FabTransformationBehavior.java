package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: f */
    private final Rect f7975f;

    /* renamed from: g */
    private final RectF f7976g;

    /* renamed from: h */
    private final RectF f7977h;

    /* renamed from: i */
    private final int[] f7978i;

    /* renamed from: j */
    private float f7979j;
    private float k;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f7980a;

        /* renamed from: b */
        final /* synthetic */ View f7981b;

        /* renamed from: c */
        final /* synthetic */ View f7982c;

        a(boolean z, View view, View view2) {
            this.f7980a = z;
            this.f7981b = view;
            this.f7982c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7980a) {
                return;
            }
            this.f7981b.setVisibility(4);
            this.f7982c.setAlpha(1.0f);
            this.f7982c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f7980a) {
                this.f7981b.setVisibility(0);
                this.f7982c.setAlpha(0.0f);
                this.f7982c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f7984a;

        b(View view) {
            this.f7984a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7984a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ com.google.android.material.circularreveal.c f7986a;

        /* renamed from: b */
        final /* synthetic */ Drawable f7987b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f7986a = cVar;
            this.f7987b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7986a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f7986a.setCircularRevealOverlayDrawable(this.f7987b);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ com.google.android.material.circularreveal.c f7989a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.f7989a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f7989a.getRevealInfo();
            revealInfo.f6971d = Float.MAX_VALUE;
            this.f7989a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        /* renamed from: a */
        @Nullable
        public h f7991a;

        /* renamed from: b */
        public j f7992b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f7975f = new Rect();
        this.f7976g = new RectF();
        this.f7977h = new RectF();
        this.f7978i = new int[2];
    }

    private int A(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup C(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup h(@NonNull View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        return findViewById != null ? C(findViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? C(((ViewGroup) view).getChildAt(0)) : C(view);
    }

    private void i(@NonNull View view, @NonNull e eVar, @NonNull i iVar, @NonNull i iVar2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        float p = p(eVar, iVar, f2, f4);
        float p2 = p(eVar, iVar2, f3, f5);
        Rect rect = this.f7975f;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f7976g;
        rectF2.set(rect);
        RectF rectF3 = this.f7977h;
        q(view, rectF3);
        rectF3.offset(p, p2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void j(@NonNull View view, @NonNull RectF rectF) {
        q(view, rectF);
        rectF.offset(this.f7979j, this.k);
    }

    @NonNull
    private Pair<i, i> k(float f2, float f3, boolean z, @NonNull e eVar) {
        i h2;
        i h3;
        if (f2 == 0.0f || f3 == 0.0f) {
            h2 = eVar.f7991a.h("translationXLinear");
            h3 = eVar.f7991a.h("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || f3 <= 0.0f)) {
            h2 = eVar.f7991a.h("translationXCurveDownwards");
            h3 = eVar.f7991a.h("translationYCurveDownwards");
        } else {
            h2 = eVar.f7991a.h("translationXCurveUpwards");
            h3 = eVar.f7991a.h("translationYCurveUpwards");
        }
        return new Pair<>(h2, h3);
    }

    private float l(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f7976g;
        RectF rectF2 = this.f7977h;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(-n(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float m(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f7976g;
        RectF rectF2 = this.f7977h;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(0.0f, -o(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float n(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f7976g;
        RectF rectF2 = this.f7977h;
        j(view, rectF);
        q(view2, rectF2);
        int i2 = jVar.f6628a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i2 != 5) {
                f2 = 0.0f;
                return f2 + jVar.f6629b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.f6629b;
    }

    private float o(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f7976g;
        RectF rectF2 = this.f7977h;
        j(view, rectF);
        q(view2, rectF2);
        int i2 = jVar.f6628a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i2 != 80) {
                f2 = 0.0f;
                return f2 + jVar.f6630c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f6630c;
    }

    private float p(@NonNull e eVar, @NonNull i iVar, float f2, float f3) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i h2 = eVar.f7991a.h("expansion");
        return com.google.android.material.a.a.a(f2, f3, iVar.e().getInterpolation((((h2.c() + h2.d()) + 17) - c2) / d2));
    }

    private void q(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f7978i);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void r(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup h2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f6958e == 0) || (h2 = h(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.a.d.f6613a.set(h2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(h2, com.google.android.material.a.d.f6613a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(h2, com.google.android.material.a.d.f6613a, 0.0f);
            }
            eVar.f7991a.h("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int A = A(view);
            int i2 = 16777215 & A;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(A);
                }
                ofInt = ObjectAnimator.ofInt(cVar, c.d.f6967a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(cVar, c.d.f6967a, A);
            }
            ofInt.setEvaluator(com.google.android.material.a.c.b());
            eVar.f7991a.h("color").a(ofInt);
            list.add(ofInt);
        }
    }

    private void t(@NonNull View view, @NonNull View view2, boolean z, @NonNull e eVar, @NonNull List<Animator> list) {
        float n = n(view, view2, eVar.f7992b);
        float o = o(view, view2, eVar.f7992b);
        Pair<i, i> k = k(n, o, z, eVar);
        i iVar = (i) k.first;
        i iVar2 = (i) k.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            n = this.f7979j;
        }
        fArr[0] = n;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            o = this.k;
        }
        fArr2[0] = o;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void u(View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f7991a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float l = l(view, view2, eVar.f7992b);
            float m = m(view, view2, eVar.f7992b);
            ((FloatingActionButton) view).k(this.f7975f);
            float width = this.f7975f.width() / 2.0f;
            i h2 = eVar.f7991a.h("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new c.e(l, m, width));
                }
                if (z2) {
                    width = cVar.getRevealInfo().f6971d;
                }
                animator = com.google.android.material.circularreveal.a.a(cVar, l, m, com.google.android.material.f.a.b(l, m, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(cVar));
                y(view2, h2.c(), (int) l, (int) m, width, list);
            } else {
                float f4 = cVar.getRevealInfo().f6971d;
                Animator a2 = com.google.android.material.circularreveal.a.a(cVar, l, m, width);
                int i2 = (int) l;
                int i3 = (int) m;
                y(view2, h2.c(), i2, i3, f4, list);
                x(view2, h2.c(), h2.d(), eVar.f7991a.i(), i2, i3, width, list);
                animator = a2;
            }
            h2.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.a.c(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f6614a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f6614a, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f7991a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void x(View view, long j2, long j3, long j4, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void y(View view, long j2, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j2);
        list.add(createCircularReveal);
    }

    private void z(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float n = n(view, view2, eVar.f7992b);
        float o = o(view, view2, eVar.f7992b);
        Pair<i, i> k = k(n, o, z, eVar);
        i iVar = (i) k.first;
        i iVar2 = (i) k.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-n);
                view2.setTranslationY(-o);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            i(view2, eVar, iVar, iVar2, -n, -o, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -n);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -o);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    protected abstract e B(Context context, boolean z);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet g(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        e B = B(view2.getContext(), z);
        if (z) {
            this.f7979j = view.getTranslationX();
            this.k = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            u(view, view2, z, z2, B, arrayList, arrayList2);
        }
        RectF rectF = this.f7976g;
        z(view, view2, z, z2, B, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        t(view, view2, z, B, arrayList);
        w(view, view2, z, z2, B, arrayList, arrayList2);
        v(view, view2, z, z2, B, width, height, arrayList, arrayList2);
        s(view, view2, z, z2, B, arrayList, arrayList2);
        r(view, view2, z, z2, B, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7975f = new Rect();
        this.f7976g = new RectF();
        this.f7977h = new RectF();
        this.f7978i = new int[2];
    }
}
