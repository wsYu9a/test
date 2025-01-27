package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", "p", "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@k Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return point.x;
    }

    public static final int component2(@k Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return point.y;
    }

    @k
    public static final Point minus(@k Point point, @k Point p10) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        Intrinsics.checkNotNullParameter(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(-p10.x, -p10.y);
        return point2;
    }

    @k
    public static final Point plus(@k Point point, @k Point p10) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        Intrinsics.checkNotNullParameter(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(p10.x, p10.y);
        return point2;
    }

    @k
    public static final Point toPoint(@k PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @k
    public static final PointF toPointF(@k Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return new PointF(point);
    }

    @k
    public static final Point unaryMinus(@k Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@k PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(@k PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        return pointF.y;
    }

    @k
    public static final PointF unaryMinus(@k PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    @k
    public static final PointF minus(@k PointF pointF, @k PointF p10) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        Intrinsics.checkNotNullParameter(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(-p10.x, -p10.y);
        return pointF2;
    }

    @k
    public static final PointF plus(@k PointF pointF, @k PointF p10) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        Intrinsics.checkNotNullParameter(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(p10.x, p10.y);
        return pointF2;
    }

    @k
    public static final Point minus(@k Point point, int i10) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i11 = -i10;
        point2.offset(i11, i11);
        return point2;
    }

    @k
    public static final Point plus(@k Point point, int i10) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i10, i10);
        return point2;
    }

    @k
    public static final PointF minus(@k PointF pointF, float f10) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f11 = -f10;
        pointF2.offset(f11, f11);
        return pointF2;
    }

    @k
    public static final PointF plus(@k PointF pointF, float f10) {
        Intrinsics.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f10, f10);
        return pointF2;
    }
}
