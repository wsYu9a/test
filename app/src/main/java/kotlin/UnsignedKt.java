package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import r3.c;
import xi.k;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", c.f30241d, c.f30242e, "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "UnsignedKt")
/* loaded from: classes4.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d10) {
        if (Double.isNaN(d10) || d10 <= uintToDouble(0)) {
            return 0;
        }
        if (d10 >= uintToDouble(-1)) {
            return -1;
        }
        return d10 <= 2.147483647E9d ? UInt.m153constructorimpl((int) d10) : UInt.m153constructorimpl(UInt.m153constructorimpl((int) (d10 - Integer.MAX_VALUE)) + UInt.m153constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double d10) {
        if (Double.isNaN(d10) || d10 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d10 >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d10 < 9.223372036854776E18d ? ULong.m232constructorimpl((long) d10) : ULong.m232constructorimpl(ULong.m232constructorimpl((long) (d10 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i10, int i11) {
        return Intrinsics.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU */
    public static final int m409uintDivideJ1ME1BU(int i10, int i11) {
        return UInt.m153constructorimpl((int) ((i10 & 4294967295L) / (i11 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU */
    public static final int m410uintRemainderJ1ME1BU(int i10, int i11) {
        return UInt.m153constructorimpl((int) ((i10 & 4294967295L) % (i11 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i10) {
        return (Integer.MAX_VALUE & i10) + (((i10 >>> 31) << 30) * 2);
    }

    @PublishedApi
    public static final int ulongCompare(long j10, long j11) {
        return Intrinsics.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI */
    public static final long m411ulongDivideeb3DHEI(long j10, long j11) {
        int compare;
        int compare2;
        if (j11 < 0) {
            compare2 = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            return compare2 < 0 ? ULong.m232constructorimpl(0L) : ULong.m232constructorimpl(1L);
        }
        if (j10 >= 0) {
            return ULong.m232constructorimpl(j10 / j11);
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        compare = Long.compare(ULong.m232constructorimpl(j10 - (j12 * j11)) ^ Long.MIN_VALUE, ULong.m232constructorimpl(j11) ^ Long.MIN_VALUE);
        return ULong.m232constructorimpl(j12 + (compare < 0 ? 0 : 1));
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI */
    public static final long m412ulongRemaindereb3DHEI(long j10, long j11) {
        int compare;
        int compare2;
        if (j11 < 0) {
            compare2 = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            return compare2 < 0 ? j10 : ULong.m232constructorimpl(j10 - j11);
        }
        if (j10 >= 0) {
            return ULong.m232constructorimpl(j10 % j11);
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        compare = Long.compare(ULong.m232constructorimpl(j12) ^ Long.MIN_VALUE, ULong.m232constructorimpl(j11) ^ Long.MIN_VALUE);
        if (compare < 0) {
            j11 = 0;
        }
        return ULong.m232constructorimpl(j12 - j11);
    }

    @PublishedApi
    public static final double ulongToDouble(long j10) {
        return ((j10 >>> 11) * 2048) + (j10 & 2047);
    }

    @k
    public static final String ulongToString(long j10) {
        return ulongToString(j10, 10);
    }

    @k
    public static final String ulongToString(long j10, int i10) {
        if (j10 >= 0) {
            String l10 = Long.toString(j10, CharsKt.checkRadix(i10));
            Intrinsics.checkNotNullExpressionValue(l10, "toString(...)");
            return l10;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String l11 = Long.toString(j12, CharsKt.checkRadix(i10));
        Intrinsics.checkNotNullExpressionValue(l11, "toString(...)");
        sb2.append(l11);
        String l12 = Long.toString(j13, CharsKt.checkRadix(i10));
        Intrinsics.checkNotNullExpressionValue(l12, "toString(...)");
        sb2.append(l12);
        return sb2.toString();
    }
}
