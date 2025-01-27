package y9;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    @k
    public static final d f33078a = new d();

    public final boolean a(@k View targetView, @l PointF pointF, boolean z10) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (targetView.canScrollHorizontally(1) && targetView.getVisibility() == 0) {
            return false;
        }
        if ((targetView instanceof ViewGroup) && pointF != null && !uf.c.f(targetView)) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (uf.c.g(targetView, childAt, pointF.x, pointF.y, pointF2)) {
                    if (Intrinsics.areEqual("fixed", childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    Intrinsics.checkNotNull(childAt);
                    boolean a10 = a(childAt, pointF, z10);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a10;
                }
            }
        }
        return z10 || targetView.canScrollHorizontally(-1);
    }

    public final boolean b(@k View targetView, @l PointF pointF) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (targetView.canScrollHorizontally(-1) && targetView.getVisibility() == 0) {
            return false;
        }
        if (!(targetView instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) targetView;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (uf.c.g(targetView, childAt, pointF.x, pointF.y, pointF2)) {
                if (Intrinsics.areEqual("fixed", childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                Intrinsics.checkNotNull(childAt);
                boolean b10 = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return b10;
            }
        }
        return true;
    }
}
