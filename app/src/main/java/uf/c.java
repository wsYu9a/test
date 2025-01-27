package uf;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.scwang.smart.refresh.layout.kernel.R;

/* loaded from: classes3.dex */
public class c implements Interpolator {

    /* renamed from: b */
    public static int f31055b = 0;

    /* renamed from: c */
    public static int f31056c = 1;

    /* renamed from: d */
    public static final float f31057d = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: e */
    public static final float f31058e = 8.0f;

    /* renamed from: f */
    public static final float f31059f;

    /* renamed from: g */
    public static final float f31060g;

    /* renamed from: a */
    public final int f31061a;

    static {
        float k10 = 1.0f / k(1.0f);
        f31059f = k10;
        f31060g = 1.0f - (k10 * k(1.0f));
    }

    public c(int i10) {
        this.f31061a = i10;
    }

    public static boolean a(@NonNull View view, PointF pointF, boolean z10) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a10 = a(childAt, pointF, z10);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a10;
                }
            }
        }
        return z10 || view.canScrollVertically(-1);
    }

    public static boolean b(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R.id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean b10 = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return b10;
            }
        }
        return true;
    }

    public static int c(float f10) {
        return (int) ((f10 * f31057d) + 0.5f);
    }

    public static void d(View view, int i10) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i10);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i10);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i10);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i10);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i10);
        }
    }

    public static boolean e(View view) {
        if (view instanceof pf.a) {
            return false;
        }
        return f(view) || (view instanceof ViewPager) || (view instanceof ViewPager2) || (view instanceof NestedScrollingParent);
    }

    public static boolean f(View view) {
        if (view instanceof pf.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static boolean g(@NonNull View view, @NonNull View view2, float f10, float f11, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f10, f11};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f10;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f12 = fArr[0];
        boolean z10 = f12 >= 0.0f && scrollY >= 0.0f && f12 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z10 && pointF != null) {
            pointF.set(fArr[0] - f10, fArr[1] - f11);
        }
        return z10;
    }

    public static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i10 = layoutParams.height;
        view.measure(childMeasureSpec, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float i(int i10) {
        return i10 / f31057d;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static void j(@NonNull AbsListView absListView, int i10) {
        absListView.scrollListBy(i10);
    }

    public static float k(float f10) {
        float f11 = f10 * 8.0f;
        return f11 < 1.0f ? f11 - (1.0f - ((float) Math.exp(-f11))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (this.f31061a == f31056c) {
            float f11 = 1.0f - f10;
            return 1.0f - (f11 * f11);
        }
        float k10 = f31059f * k(f10);
        return k10 > 0.0f ? k10 + f31060g : k10;
    }
}
