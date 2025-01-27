package y9;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.AbsListView;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class b extends vf.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // vf.a, pf.b
    @l
    public ValueAnimator.AnimatorUpdateListener f(int i10) {
        View view = this.f31531d;
        if (view == null || i10 == 0) {
            return null;
        }
        if ((i10 >= 0 || !view.canScrollHorizontally(1)) && (i10 <= 0 || !this.f31531d.canScrollHorizontally(-1))) {
            return null;
        }
        this.f31534g = i10;
        return this;
    }

    @Override // vf.a, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@k ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        try {
            View view = this.f31531d;
            if (view instanceof AbsListView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.AbsListView");
                uf.c.j((AbsListView) view, intValue - this.f31534g);
            } else {
                view.scrollBy(intValue - this.f31534g, 0);
            }
        } catch (Throwable unused) {
        }
        this.f31534g = intValue;
    }
}
