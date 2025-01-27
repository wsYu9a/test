package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0004\b\u0004\u0010\b\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u0004\u0010\n\u001aB\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u000b\"\u0018\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\b\u0012\u0004\u0012\u00028\u00000\u0003*\u00028\u00012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0087\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "that", "Lkotlin/ranges/ClosedRange;", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(DD)Lkotlin/ranges/ClosedFloatingPointRange;", "", "(FF)Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "R", "element", "", "contains", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "isPositive", "", "step", "", "checkStepIsPositive", "(ZLjava/lang/Number;)V", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z, @d Number step) {
        Intrinsics.checkParameterIsNotNull(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(@d Iterable contains, Object obj) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return obj != null && ((ClosedRange) contains).contains((Comparable) obj);
    }

    @d
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@d T rangeTo, @d T that) {
        Intrinsics.checkParameterIsNotNull(rangeTo, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(that, "that");
        return new ComparableRange(rangeTo, that);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Double> rangeTo(double d2, double d3) {
        return new ClosedDoubleRange(d2, d3);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Float> rangeTo(float f2, float f3) {
        return new ClosedFloatRange(f2, f3);
    }
}
