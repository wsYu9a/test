package aa;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes3.dex */
public abstract class a implements f {

    /* renamed from: b */
    public static final int f90b = 0;

    /* renamed from: c */
    public static final int f91c = 1;

    /* renamed from: d */
    public static final int f92d = 2;

    /* renamed from: e */
    public static final int f93e = 4;

    /* renamed from: f */
    public static final int f94f = 0;

    /* renamed from: g */
    public static final int f95g = 1;

    /* renamed from: a */
    public SlidingLayout f96a;

    @Override // aa.f
    public boolean b(Canvas canvas) {
        return false;
    }

    @Override // aa.f
    public boolean c(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = m().getChildCount();
        View childAt = m().getChildAt(childCount - 1);
        if (childAt == null) {
            return true;
        }
        childAt.layout(i10, i11, i12, i13);
        for (int i14 = childCount - 2; i14 >= 0; i14--) {
            m().getChildAt(i14).layout(i10 - n(), i11, i12 - n(), i13);
        }
        return true;
    }

    @Override // aa.f
    public void g(SlidingLayout slidingLayout) {
        this.f96a = slidingLayout;
    }

    @Override // aa.f
    public boolean j(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    public z9.d k() {
        return m().getAdapter();
    }

    public int l() {
        int measuredHeight = m().getMeasuredHeight();
        return measuredHeight == 0 ? m().getContext().getResources().getDisplayMetrics().heightPixels : measuredHeight;
    }

    public SlidingLayout m() {
        return this.f96a;
    }

    public int n() {
        int measuredWidth = m().getMeasuredWidth();
        return measuredWidth == 0 ? m().getContext().getResources().getDisplayMetrics().widthPixels : measuredWidth;
    }

    public void o() {
        m().invalidate();
    }

    public void p() {
        m().postInvalidate();
    }
}
