package com.google.android.material.m;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.google.android.material.j.o;

/* loaded from: classes.dex */
class u {

    /* renamed from: a */
    private static final RectF f7582a = new RectF();

    static class a implements o.c {

        /* renamed from: a */
        final /* synthetic */ RectF f7583a;

        a(RectF rectF) {
            this.f7583a = rectF;
        }

        @Override // com.google.android.material.j.o.c
        @NonNull
        public com.google.android.material.j.d a(@NonNull com.google.android.material.j.d dVar) {
            return dVar instanceof com.google.android.material.j.m ? dVar : new com.google.android.material.j.m(dVar.a(this.f7583a) / this.f7583a.height());
        }
    }

    static class b implements d {

        /* renamed from: a */
        final /* synthetic */ RectF f7584a;

        /* renamed from: b */
        final /* synthetic */ RectF f7585b;

        /* renamed from: c */
        final /* synthetic */ float f7586c;

        /* renamed from: d */
        final /* synthetic */ float f7587d;

        /* renamed from: e */
        final /* synthetic */ float f7588e;

        b(RectF rectF, RectF rectF2, float f2, float f3, float f4) {
            this.f7584a = rectF;
            this.f7585b = rectF2;
            this.f7586c = f2;
            this.f7587d = f3;
            this.f7588e = f4;
        }

        @Override // com.google.android.material.m.u.d
        @NonNull
        public com.google.android.material.j.d a(@NonNull com.google.android.material.j.d dVar, @NonNull com.google.android.material.j.d dVar2) {
            return new com.google.android.material.j.a(u.l(dVar.a(this.f7584a), dVar2.a(this.f7585b), this.f7586c, this.f7587d, this.f7588e));
        }
    }

    interface c {
        void a(Canvas canvas);
    }

    interface d {
        @NonNull
        com.google.android.material.j.d a(@NonNull com.google.android.material.j.d dVar, @NonNull com.google.android.material.j.d dVar2);
    }

    private u() {
    }

    static float a(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static com.google.android.material.j.o b(com.google.android.material.j.o oVar, RectF rectF) {
        return oVar.y(new a(rectF));
    }

    static Shader c(@ColorInt int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i2, i2, Shader.TileMode.CLAMP);
    }

    @NonNull
    static <T> T d(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    static View e(View view, @IdRes int i2) {
        String resourceName = view.getResources().getResourceName(i2);
        while (view != null) {
            if (view.getId() != i2) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View f(View view, @IdRes int i2) {
        View findViewById = view.findViewById(i2);
        return findViewById != null ? findViewById : e(view, i2);
    }

    static RectF g(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static RectF h(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect i(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean j(com.google.android.material.j.o oVar, RectF rectF) {
        return (oVar.r().a(rectF) == 0.0f && oVar.t().a(rectF) == 0.0f && oVar.l().a(rectF) == 0.0f && oVar.j().a(rectF) == 0.0f) ? false : true;
    }

    static float k(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    static float l(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : k(f2, f3, (f6 - f4) / (f5 - f4));
    }

    static int m(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f4 < f2 ? i2 : f4 > f3 ? i3 : (int) k(i2, i3, (f4 - f2) / (f3 - f2));
    }

    static com.google.android.material.j.o n(com.google.android.material.j.o oVar, com.google.android.material.j.o oVar2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f4 < f2 ? oVar : f4 > f3 ? oVar2 : s(oVar, oVar2, rectF, new b(rectF, rectF2, f2, f3, f4));
    }

    static void o(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void p(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    private static int q(Canvas canvas, Rect rect, int i2) {
        RectF rectF = f7582a;
        rectF.set(rect);
        return Build.VERSION.SDK_INT >= 21 ? canvas.saveLayerAlpha(rectF, i2) : canvas.saveLayerAlpha(rectF.left, rectF.top, rectF.right, rectF.bottom, i2, 31);
    }

    static void r(Canvas canvas, Rect rect, float f2, float f3, float f4, int i2, c cVar) {
        if (i2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f4, f4);
        if (i2 < 255) {
            q(canvas, rect, i2);
        }
        cVar.a(canvas);
        canvas.restoreToCount(save);
    }

    static com.google.android.material.j.o s(com.google.android.material.j.o oVar, com.google.android.material.j.o oVar2, RectF rectF, d dVar) {
        return (j(oVar, rectF) ? oVar : oVar2).v().L(dVar.a(oVar.r(), oVar2.r())).Q(dVar.a(oVar.t(), oVar2.t())).y(dVar.a(oVar.j(), oVar2.j())).D(dVar.a(oVar.l(), oVar2.l())).m();
    }
}
