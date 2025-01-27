package kotlin.random;

import com.cdo.oaps.ad.OapsKey;
import f.b.a.d;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\f\u001a\u0016\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001e\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001d\u001a2\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\"\u0010%\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010(\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/random/Random;", "Lkotlin/UInt;", "nextUInt", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", OapsKey.KEY_FROM, "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "Lkotlin/ULong;", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "nextUBytes", "", OapsKey.KEY_SIZE, "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkUIntRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "checkULongRangeBounds", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class URandomKt {
    @ExperimentalUnsignedTypes
    /* renamed from: checkUIntRangeBounds-J1ME1BU */
    public static final void m994checkUIntRangeBoundsJ1ME1BU(int i2, int i3) {
        if (!(UnsignedKt.uintCompare(i3, i2) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m162boximpl(i2), UInt.m162boximpl(i3)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: checkULongRangeBounds-eb3DHEI */
    public static final void m995checkULongRangeBoundseb3DHEI(long j2, long j3) {
        if (!(UnsignedKt.ulongCompare(j3, j2) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m231boximpl(j2), ULong.m231boximpl(j3)).toString());
        }
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(@d Random nextUBytes, int i2) {
        Intrinsics.checkParameterIsNotNull(nextUBytes, "$this$nextUBytes");
        return UByteArray.m145constructorimpl(nextUBytes.nextBytes(i2));
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-EVgfTAA */
    public static final byte[] m996nextUBytesEVgfTAA(@d Random nextUBytes, @d byte[] array) {
        Intrinsics.checkParameterIsNotNull(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkParameterIsNotNull(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-Wvrt4B4 */
    public static final byte[] m997nextUBytesWvrt4B4(@d Random nextUBytes, @d byte[] array, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkParameterIsNotNull(array, "array");
        nextUBytes.nextBytes(array, i2, i3);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default */
    public static /* synthetic */ byte[] m998nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UByteArray.m151getSizeimpl(bArr);
        }
        return m997nextUBytesWvrt4B4(random, bArr, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(@d Random nextUInt) {
        Intrinsics.checkParameterIsNotNull(nextUInt, "$this$nextUInt");
        return UInt.m168constructorimpl(nextUInt.nextInt());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-a8DCA5k */
    public static final int m999nextUInta8DCA5k(@d Random nextUInt, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(nextUInt, "$this$nextUInt");
        m994checkUIntRangeBoundsJ1ME1BU(i2, i3);
        return UInt.m168constructorimpl(nextUInt.nextInt(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-qCasIEU */
    public static final int m1000nextUIntqCasIEU(@d Random nextUInt, int i2) {
        Intrinsics.checkParameterIsNotNull(nextUInt, "$this$nextUInt");
        return m999nextUInta8DCA5k(nextUInt, 0, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(@d Random nextULong) {
        Intrinsics.checkParameterIsNotNull(nextULong, "$this$nextULong");
        return ULong.m237constructorimpl(nextULong.nextLong());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-V1Xi4fY */
    public static final long m1001nextULongV1Xi4fY(@d Random nextULong, long j2) {
        Intrinsics.checkParameterIsNotNull(nextULong, "$this$nextULong");
        return m1002nextULongjmpaWc(nextULong, 0L, j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-jmpaW-c */
    public static final long m1002nextULongjmpaWc(@d Random nextULong, long j2, long j3) {
        Intrinsics.checkParameterIsNotNull(nextULong, "$this$nextULong");
        m995checkULongRangeBoundseb3DHEI(j2, j3);
        return ULong.m237constructorimpl(nextULong.nextLong(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(@d Random nextUInt, @d UIntRange range) {
        Intrinsics.checkParameterIsNotNull(nextUInt, "$this$nextUInt");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(range.getLast(), -1) < 0 ? m999nextUInta8DCA5k(nextUInt, range.getFirst(), UInt.m168constructorimpl(range.getLast() + 1)) : UnsignedKt.uintCompare(range.getFirst(), 0) > 0 ? UInt.m168constructorimpl(m999nextUInta8DCA5k(nextUInt, UInt.m168constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(nextUInt);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(@d Random nextULong, @d ULongRange range) {
        Intrinsics.checkParameterIsNotNull(nextULong, "$this$nextULong");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (UnsignedKt.ulongCompare(range.getLast(), -1L) < 0) {
            return m1002nextULongjmpaWc(nextULong, range.getFirst(), ULong.m237constructorimpl(range.getLast() + ULong.m237constructorimpl(4294967295L & 1)));
        }
        if (UnsignedKt.ulongCompare(range.getFirst(), 0L) <= 0) {
            return nextULong(nextULong);
        }
        long j2 = 4294967295L & 1;
        return ULong.m237constructorimpl(m1002nextULongjmpaWc(nextULong, ULong.m237constructorimpl(range.getFirst() - ULong.m237constructorimpl(j2)), range.getLast()) + ULong.m237constructorimpl(j2));
    }
}
