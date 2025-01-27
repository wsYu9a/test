package vf;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.scwang.smart.refresh.layout.kernel.R;
import java.util.LinkedList;
import pf.e;
import sf.j;

/* loaded from: classes3.dex */
public class a implements pf.b, sf.a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b */
    public View f31529b;

    /* renamed from: c */
    public View f31530c;

    /* renamed from: d */
    public View f31531d;

    /* renamed from: e */
    public View f31532e;

    /* renamed from: f */
    public View f31533f;

    /* renamed from: g */
    public int f31534g = 0;

    /* renamed from: h */
    public boolean f31535h = true;

    /* renamed from: i */
    public boolean f31536i = true;

    /* renamed from: j */
    public tf.a f31537j = new tf.a();

    public a(@NonNull View view) {
        this.f31531d = view;
        this.f31530c = view;
        this.f31529b = view;
    }

    @Override // pf.b
    public boolean a() {
        return this.f31535h && this.f31537j.a(this.f31529b);
    }

    @Override // pf.b
    public void b(boolean z10) {
        this.f31537j.f30864c = z10;
    }

    @Override // pf.b
    public void c(j jVar) {
        if (jVar instanceof tf.a) {
            this.f31537j = (tf.a) jVar;
        } else {
            this.f31537j.f30863b = jVar;
        }
    }

    @Override // pf.b
    public void d(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f31529b.getLeft(), -this.f31529b.getTop());
        View view = this.f31531d;
        View view2 = this.f31529b;
        if (view != view2) {
            this.f31531d = l(view2, pointF, view);
        }
        if (this.f31531d == this.f31529b) {
            this.f31537j.f30862a = null;
        } else {
            this.f31537j.f30862a = pointF;
        }
    }

    @Override // pf.b
    public void e(e eVar, View view, View view2) {
        k(this.f31529b, eVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f31532e = view;
        this.f31533f = view2;
        FrameLayout frameLayout = new FrameLayout(this.f31529b.getContext());
        int indexOfChild = eVar.l().getLayout().indexOfChild(this.f31529b);
        eVar.l().getLayout().removeView(this.f31529b);
        frameLayout.addView(this.f31529b, 0, new ViewGroup.LayoutParams(-1, -1));
        eVar.l().getLayout().addView(frameLayout, indexOfChild, this.f31529b.getLayoutParams());
        this.f31529b = frameLayout;
        if (view != null) {
            view.setTag(R.id.srl_tag, "fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = uf.c.h(view);
            viewGroup.addView(new Space(this.f31529b.getContext()), indexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag(R.id.srl_tag, "fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = uf.c.h(view2);
            viewGroup2.addView(new Space(this.f31529b.getContext()), indexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // pf.b
    public ValueAnimator.AnimatorUpdateListener f(int i10) {
        View view = this.f31531d;
        if (view == null || i10 == 0) {
            return null;
        }
        if ((i10 >= 0 || !view.canScrollVertically(1)) && (i10 <= 0 || !this.f31531d.canScrollVertically(-1))) {
            return null;
        }
        this.f31534g = i10;
        return this;
    }

    @Override // pf.b
    @NonNull
    public View g() {
        return this.f31531d;
    }

    @Override // pf.b
    @NonNull
    public View getView() {
        return this.f31529b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    @Override // pf.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = -1
            if (r7 == r3) goto L21
            android.view.View r4 = r5.f31530c
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L21
            if (r6 <= 0) goto L16
            float r4 = (float) r6
            r7.setTranslationY(r4)
            r7 = 1
            goto L22
        L16:
            float r4 = r7.getTranslationY()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L21
            r7.setTranslationY(r1)
        L21:
            r7 = 0
        L22:
            if (r8 == r3) goto L3e
            android.view.View r3 = r5.f31530c
            android.view.View r8 = r3.findViewById(r8)
            if (r8 == 0) goto L3e
            if (r6 >= 0) goto L33
            float r7 = (float) r6
            r8.setTranslationY(r7)
            goto L3f
        L33:
            float r0 = r8.getTranslationY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3e
            r8.setTranslationY(r1)
        L3e:
            r0 = r7
        L3f:
            if (r0 != 0) goto L48
            android.view.View r7 = r5.f31530c
            float r8 = (float) r6
            r7.setTranslationY(r8)
            goto L4d
        L48:
            android.view.View r7 = r5.f31530c
            r7.setTranslationY(r1)
        L4d:
            android.view.View r7 = r5.f31532e
            if (r7 == 0) goto L59
            int r8 = java.lang.Math.max(r2, r6)
            float r8 = (float) r8
            r7.setTranslationY(r8)
        L59:
            android.view.View r7 = r5.f31533f
            if (r7 == 0) goto L65
            int r6 = java.lang.Math.min(r2, r6)
            float r6 = (float) r6
            r7.setTranslationY(r6)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vf.a.h(int, int, int):void");
    }

    @Override // pf.b
    public boolean i() {
        return this.f31536i && this.f31537j.b(this.f31529b);
    }

    @Override // sf.a
    public void j(boolean z10, boolean z11) {
        this.f31535h = z10;
        this.f31536i = z11;
    }

    public void k(View view, e eVar) {
        boolean isInEditMode = this.f31529b.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                uf.b.b(view, eVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f31531d = view2;
        }
    }

    public View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (uf.c.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && !(childAt instanceof ViewPager2) && uf.c.e(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View l10 = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return l10;
                }
            }
        }
        return view2;
    }

    public View m(View view, boolean z10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z10 || view3 != view) && uf.c.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        linkedList.add(viewGroup.getChildAt(i10));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f31534g) * this.f31531d.getScaleY();
            View view = this.f31531d;
            if (view instanceof AbsListView) {
                uf.c.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f31534g = intValue;
    }
}
