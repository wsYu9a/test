package kotlin.random;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import xi.k;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", TypedValues.TransitionType.S_FROM, "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
/* loaded from: classes4.dex */
public final class URandomKt {
    /* renamed from: checkUIntRangeBounds-J1ME1BU */
    public static final void m1271checkUIntRangeBoundsJ1ME1BU(int i10, int i11) {
        int compare;
        compare = Integer.compare(i11 ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m147boximpl(i10), UInt.m147boximpl(i11)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI */
    public static final void m1272checkULongRangeBoundseb3DHEI(long j10, long j11) {
        int compare;
        compare = Long.compare(j11 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m226boximpl(j10), ULong.m226boximpl(j11)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(@k Random random, int i10) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m129constructorimpl(random.nextBytes(i10));
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-EVgfTAA */
    public static final byte[] m1273nextUBytesEVgfTAA(@k Random nextUBytes, @k byte[] array) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-Wvrt4B4 */
    public static final byte[] m1274nextUBytesWvrt4B4(@k Random nextUBytes, @k byte[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i10, i11);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default */
    public static /* synthetic */ byte[] m1275nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = UByteArray.m135getSizeimpl(bArr);
        }
        return m1274nextUBytesWvrt4B4(random, bArr, i10, i11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@k Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m153constructorimpl(random.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-a8DCA5k */
    public static final int m1276nextUInta8DCA5k(@k Random nextUInt, int i10, int i11) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m1271checkUIntRangeBoundsJ1ME1BU(i10, i11);
        return UInt.m153constructorimpl(nextUInt.nextInt(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-qCasIEU */
    public static final int m1277nextUIntqCasIEU(@k Random nextUInt, int i10) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m1276nextUInta8DCA5k(nextUInt, 0, i10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@k Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.m232constructorimpl(random.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-V1Xi4fY */
    public static final long m1278nextULongV1Xi4fY(@k Random nextULong, long j10) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m1279nextULongjmpaWc(nextULong, 0L, j10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-jmpaW-c */
    public static final long m1279nextULongjmpaWc(@k Random nextULong, long j10, long j11) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m1272checkULongRangeBoundseb3DHEI(j10, j11);
        return ULong.m232constructorimpl(nextULong.nextLong(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@k Random random, @k UIntRange range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Integer.compare(range.getLast() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return m1276nextUInta8DCA5k(random, range.getFirst(), UInt.m153constructorimpl(range.getLast() + 1));
        }
        compare2 = Integer.compare(range.getFirst() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare2 > 0 ? UInt.m153constructorimpl(m1276nextUInta8DCA5k(random, UInt.m153constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(random);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@k Random random, @k ULongRange range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Long.compare(range.getLast() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE);
        if (compare < 0) {
            return m1279nextULongjmpaWc(random, range.getFirst(), ULong.m232constructorimpl(range.getLast() + ULong.m232constructorimpl(1 & 4294967295L)));
        }
        compare2 = Long.compare(range.getFirst() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        if (compare2 <= 0) {
            return nextULong(random);
        }
        long j10 = 1 & 4294967295L;
        return ULong.m232constructorimpl(m1279nextULongjmpaWc(random, ULong.m232constructorimpl(range.getFirst() - ULong.m232constructorimpl(j10)), range.getLast()) + ULong.m232constructorimpl(j10));
    }
}
