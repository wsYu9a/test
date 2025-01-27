package kotlin.ranges;

import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\b\u001a\u001e\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\f\u001a \u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\r\u001a \u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a!\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u0010*\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0017\u001a\u00020 H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u0013\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0017\u001a\u00020 H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010)\u001a\u00020&*\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010)\u001a\u00020&*\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010)\u001a\u00020,*\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010)\u001a\u00020&*\u00020 2\u0006\u0010%\u001a\u00020 H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0013\u00101\u001a\u00020&*\u00020&H\u0007¢\u0006\u0004\b1\u00102\u001a\u0013\u00101\u001a\u00020,*\u00020,H\u0007¢\u0006\u0004\b1\u00103\u001a\u001c\u00105\u001a\u00020&*\u00020&2\u0006\u00105\u001a\u000204H\u0087\u0004¢\u0006\u0004\b5\u00106\u001a\u001c\u00105\u001a\u00020,*\u00020,2\u0006\u00105\u001a\u000207H\u0087\u0004¢\u0006\u0004\b5\u00108\u001a\u001f\u0010;\u001a\u00020\u0000*\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u001f\u0010;\u001a\u00020\u0000*\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u0010;\u001a\u00020\u0004*\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001f\u0010;\u001a\u00020\u0000*\u00020 2\u0006\u0010%\u001a\u00020 H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001e\u0010E\u001a\u00020\u0001*\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u001e\u0010E\u001a\u00020\u0005*\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u001e\u0010E\u001a\u00020\u0016*\u00020\u00162\u0006\u0010B\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a\u001e\u0010E\u001a\u00020 *\u00020 2\u0006\u0010B\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a\u001e\u0010N\u001a\u00020\u0001*\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010D\u001a\u001e\u0010N\u001a\u00020\u0005*\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010G\u001a\u001e\u0010N\u001a\u00020\u0016*\u00020\u00162\u0006\u0010L\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010I\u001a\u001e\u0010N\u001a\u00020 *\u00020 2\u0006\u0010L\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\bQ\u0010K\u001a&\u0010T\u001a\u00020\u0001*\u00020\u00012\u0006\u0010B\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a&\u0010T\u001a\u00020\u0005*\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a&\u0010T\u001a\u00020\u0016*\u00020\u00162\u0006\u0010B\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a&\u0010T\u001a\u00020 *\u00020 2\u0006\u0010B\u001a\u00020 2\u0006\u0010L\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a$\u0010T\u001a\u00020\u0001*\u00020\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010[H\u0007ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a$\u0010T\u001a\u00020\u0005*\u00020\u00052\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050[H\u0007ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006a"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/UInt;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/ranges/ULongRange;", "Lkotlin/ULong;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "(Lkotlin/ranges/UIntRange;)Lkotlin/UInt;", "(Lkotlin/ranges/ULongRange;)Lkotlin/ULong;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)Lkotlin/UInt;", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)Lkotlin/ULong;", "element", "", "contains-biwQdVI", "(Lkotlin/ranges/UIntRange;Lkotlin/UInt;)Z", "contains", "contains-GYNo2lE", "(Lkotlin/ranges/ULongRange;Lkotlin/ULong;)Z", "Lkotlin/UByte;", Downloads.RequestHeaders.COLUMN_VALUE, "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "to", "Lkotlin/ranges/UIntProgression;", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "(Lkotlin/ranges/UIntProgression;)Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ranges/ULongProgression;", "", "step", "(Lkotlin/ranges/UIntProgression;I)Lkotlin/ranges/UIntProgression;", "", "(Lkotlin/ranges/ULongProgression;J)Lkotlin/ranges/ULongProgression;", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn-WZ9TVnA", "(III)I", "coerceIn", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "Lkotlin/ranges/ClosedRange;", "range", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes5.dex */
class URangesKt___URangesKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-5PvTz6A */
    public static final short m1007coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-J1ME1BU */
    public static final int m1008coerceAtLeastJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) < 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-Kr8caGY */
    public static final byte m1009coerceAtLeastKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) < 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-eb3DHEI */
    public static final long m1010coerceAtLeasteb3DHEI(long j2, long j3) {
        return UnsignedKt.ulongCompare(j2, j3) < 0 ? j3 : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-5PvTz6A */
    public static final short m1011coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-J1ME1BU */
    public static final int m1012coerceAtMostJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) > 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-Kr8caGY */
    public static final byte m1013coerceAtMostKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) > 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-eb3DHEI */
    public static final long m1014coerceAtMosteb3DHEI(long j2, long j3) {
        return UnsignedKt.ulongCompare(j2, j3) > 0 ? j3 : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-JPwROB0 */
    public static final long m1015coerceInJPwROB0(long j2, @d ClosedRange<ULong> range) {
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m231boximpl(j2), (ClosedFloatingPointRange<ULong>) range)).getData();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.ulongCompare(j2, range.getStart().getData()) < 0 ? range.getStart().getData() : UnsignedKt.ulongCompare(j2, range.getEndInclusive().getData()) > 0 ? range.getEndInclusive().getData() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-VKSA0NQ */
    public static final short m1016coerceInVKSA0NQ(short s, short s2, short s3) {
        int i2 = s2 & UShort.MAX_VALUE;
        int i3 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i2, i3) <= 0) {
            int i4 = 65535 & s;
            return Intrinsics.compare(i4, i2) < 0 ? s2 : Intrinsics.compare(i4, i3) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m369toStringimpl(s3) + " is less than minimum " + UShort.m369toStringimpl(s2) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-WZ9TVnA */
    public static final int m1017coerceInWZ9TVnA(int i2, int i3, int i4) {
        if (UnsignedKt.uintCompare(i3, i4) <= 0) {
            return UnsignedKt.uintCompare(i2, i3) < 0 ? i3 : UnsignedKt.uintCompare(i2, i4) > 0 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m205toStringimpl(i4) + " is less than minimum " + UInt.m205toStringimpl(i3) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-b33U2AM */
    public static final byte m1018coerceInb33U2AM(byte b2, byte b3, byte b4) {
        int i2 = b3 & 255;
        int i3 = b4 & 255;
        if (Intrinsics.compare(i2, i3) <= 0) {
            int i4 = b2 & 255;
            return Intrinsics.compare(i4, i2) < 0 ? b3 : Intrinsics.compare(i4, i3) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m136toStringimpl(b4) + " is less than minimum " + UByte.m136toStringimpl(b3) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-sambcqE */
    public static final long m1019coerceInsambcqE(long j2, long j3, long j4) {
        if (UnsignedKt.ulongCompare(j3, j4) <= 0) {
            return UnsignedKt.ulongCompare(j2, j3) < 0 ? j3 : UnsignedKt.ulongCompare(j2, j4) > 0 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m274toStringimpl(j4) + " is less than minimum " + ULong.m274toStringimpl(j3) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-wuiCnnA */
    public static final int m1020coerceInwuiCnnA(int i2, @d ClosedRange<UInt> range) {
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m162boximpl(i2), (ClosedFloatingPointRange<UInt>) range)).getData();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(i2, range.getStart().getData()) < 0 ? range.getStart().getData() : UnsignedKt.uintCompare(i2, range.getEndInclusive().getData()) > 0 ? range.getEndInclusive().getData() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-68kG9v0 */
    public static final boolean m1021contains68kG9v0(@d UIntRange contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.m1004containsWZ4Q5Ns(UInt.m168constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-GYNo2lE */
    private static final boolean m1022containsGYNo2lE(@d ULongRange contains, ULong uLong) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return uLong != null && contains.m1006containsVKZWuLQ(uLong.getData());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-Gab390E */
    public static final boolean m1023containsGab390E(@d ULongRange contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.m1006containsVKZWuLQ(ULong.m237constructorimpl(i2 & 4294967295L));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ULb-yJY */
    public static final boolean m1024containsULbyJY(@d ULongRange contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.m1006containsVKZWuLQ(ULong.m237constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ZsK3CEQ */
    public static final boolean m1025containsZsK3CEQ(@d UIntRange contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.m1004containsWZ4Q5Ns(UInt.m168constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-biwQdVI */
    private static final boolean m1026containsbiwQdVI(@d UIntRange contains, UInt uInt) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return uInt != null && contains.m1004containsWZ4Q5Ns(uInt.getData());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-fz5IDCE */
    public static final boolean m1027containsfz5IDCE(@d UIntRange contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return ULong.m237constructorimpl(j2 >>> 32) == 0 && contains.m1004containsWZ4Q5Ns(UInt.m168constructorimpl((int) j2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-uhHAxoY */
    public static final boolean m1028containsuhHAxoY(@d ULongRange contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.m1006containsVKZWuLQ(ULong.m237constructorimpl(s & 65535));
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-5PvTz6A */
    public static final UIntProgression m1029downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m1003fromClosedRangeNkh28Cs(UInt.m168constructorimpl(s & UShort.MAX_VALUE), UInt.m168constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-J1ME1BU */
    public static final UIntProgression m1030downToJ1ME1BU(int i2, int i3) {
        return UIntProgression.INSTANCE.m1003fromClosedRangeNkh28Cs(i2, i3, -1);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-Kr8caGY */
    public static final UIntProgression m1031downToKr8caGY(byte b2, byte b3) {
        return UIntProgression.INSTANCE.m1003fromClosedRangeNkh28Cs(UInt.m168constructorimpl(b2 & 255), UInt.m168constructorimpl(b3 & 255), -1);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-eb3DHEI */
    public static final ULongProgression m1032downToeb3DHEI(long j2, long j3) {
        return ULongProgression.INSTANCE.m1005fromClosedRange7ftBX0g(j2, j3, -1L);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int random(@d UIntRange uIntRange) {
        return random(uIntRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final UInt randomOrNull(@d UIntRange uIntRange) {
        return randomOrNull(uIntRange, Random.INSTANCE);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression reversed(@d UIntProgression reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        return UIntProgression.INSTANCE.m1003fromClosedRangeNkh28Cs(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression step(@d UIntProgression step, int i2) {
        Intrinsics.checkParameterIsNotNull(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = step.getFirst();
        int last = step.getLast();
        if (step.getStep() <= 0) {
            i2 = -i2;
        }
        return companion.m1003fromClosedRangeNkh28Cs(first, last, i2);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-5PvTz6A */
    public static final UIntRange m1033until5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s2 & UShort.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m168constructorimpl(s & UShort.MAX_VALUE), UInt.m168constructorimpl(UInt.m168constructorimpl(r3) - 1), null);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-J1ME1BU */
    public static final UIntRange m1034untilJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i3, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(i2, UInt.m168constructorimpl(i3 - 1), null);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-Kr8caGY */
    public static final UIntRange m1035untilKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b3 & 255, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m168constructorimpl(b2 & 255), UInt.m168constructorimpl(UInt.m168constructorimpl(r3) - 1), null);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-eb3DHEI */
    public static final ULongRange m1036untileb3DHEI(long j2, long j3) {
        return UnsignedKt.ulongCompare(j3, 0L) <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange(j2, ULong.m237constructorimpl(j3 - ULong.m237constructorimpl(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long random(@d ULongRange uLongRange) {
        return random(uLongRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final ULong randomOrNull(@d ULongRange uLongRange) {
        return randomOrNull(uLongRange, Random.INSTANCE);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression reversed(@d ULongProgression reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        return ULongProgression.INSTANCE.m1005fromClosedRange7ftBX0g(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int random(@d UIntRange random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        try {
            return URandomKt.nextUInt(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @e
    public static final UInt randomOrNull(@d UIntRange randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m162boximpl(URandomKt.nextUInt(random, randomOrNull));
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression step(@d ULongProgression step, long j2) {
        Intrinsics.checkParameterIsNotNull(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(j2 > 0, Long.valueOf(j2));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = step.getFirst();
        long last = step.getLast();
        if (step.getStep() <= 0) {
            j2 = -j2;
        }
        return companion.m1005fromClosedRange7ftBX0g(first, last, j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long random(@d ULongRange random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        try {
            return URandomKt.nextULong(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @e
    public static final ULong randomOrNull(@d ULongRange randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m231boximpl(URandomKt.nextULong(random, randomOrNull));
    }
}
