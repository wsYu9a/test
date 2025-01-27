package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class PathSegment {

    /* renamed from: a */
    private final PointF f1738a;

    /* renamed from: b */
    private final float f1739b;

    /* renamed from: c */
    private final PointF f1740c;

    /* renamed from: d */
    private final float f1741d;

    public PathSegment(@NonNull PointF pointF, float f2, @NonNull PointF pointF2, float f3) {
        this.f1738a = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.f1739b = f2;
        this.f1740c = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.f1741d = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.f1739b, pathSegment.f1739b) == 0 && Float.compare(this.f1741d, pathSegment.f1741d) == 0 && this.f1738a.equals(pathSegment.f1738a) && this.f1740c.equals(pathSegment.f1740c);
    }

    @NonNull
    public PointF getEnd() {
        return this.f1740c;
    }

    public float getEndFraction() {
        return this.f1741d;
    }

    @NonNull
    public PointF getStart() {
        return this.f1738a;
    }

    public float getStartFraction() {
        return this.f1739b;
    }

    public int hashCode() {
        int hashCode = this.f1738a.hashCode() * 31;
        float f2 = this.f1739b;
        int floatToIntBits = (((hashCode + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f1740c.hashCode()) * 31;
        float f3 = this.f1741d;
        return floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
    }

    public String toString() {
        return "PathSegment{start=" + this.f1738a + ", startFraction=" + this.f1739b + ", end=" + this.f1740c + ", endFraction=" + this.f1741d + '}';
    }
}
