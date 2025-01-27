package kotlin.random;

import com.cdo.oaps.ad.OapsKey;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0019\u001a\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u0017\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"", "seed", "Lkotlin/random/Random;", "Random", "(I)Lkotlin/random/Random;", "", "(J)Lkotlin/random/Random;", "Lkotlin/ranges/IntRange;", "range", "nextInt", "(Lkotlin/random/Random;Lkotlin/ranges/IntRange;)I", "Lkotlin/ranges/LongRange;", "nextLong", "(Lkotlin/random/Random;Lkotlin/ranges/LongRange;)J", Downloads.RequestHeaders.COLUMN_VALUE, "fastLog2", "(I)I", "bitCount", "takeUpperBits", "(II)I", OapsKey.KEY_FROM, "until", "", "checkRangeBounds", "(II)V", "(JJ)V", "", "(DD)V", "", "", "boundsErrorMessage", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class RandomKt {
    @d
    @SinceKotlin(version = "1.3")
    public static final Random Random(int i2) {
        return new XorWowRandom(i2, i2 >> 31);
    }

    @d
    public static final String boundsErrorMessage(@d Object from, @d Object until) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        Intrinsics.checkParameterIsNotNull(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void checkRangeBounds(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final int fastLog2(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.3")
    public static final int nextInt(@d Random nextInt, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(nextInt, "$this$nextInt");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (!range.isEmpty()) {
            return range.getLast() < Integer.MAX_VALUE ? nextInt.nextInt(range.getFirst(), range.getLast() + 1) : range.getFirst() > Integer.MIN_VALUE ? nextInt.nextInt(range.getFirst() - 1, range.getLast()) + 1 : nextInt.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    public static final long nextLong(@d Random nextLong, @d LongRange range) {
        Intrinsics.checkParameterIsNotNull(nextLong, "$this$nextLong");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (!range.isEmpty()) {
            return range.getLast() < Long.MAX_VALUE ? nextLong.nextLong(range.getFirst(), range.getLast() + 1) : range.getFirst() > Long.MIN_VALUE ? nextLong.nextLong(range.getFirst() - 1, range.getLast()) + 1 : nextLong.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int takeUpperBits(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final Random Random(long j2) {
        return new XorWowRandom((int) j2, (int) (j2 >> 32));
    }

    public static final void checkRangeBounds(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final void checkRangeBounds(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }
}
