package kotlin;

import f.b.a.d;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0004\u001a\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"", "v1", "v2", "uintCompare", "(II)I", "", "ulongCompare", "(JJ)I", "Lkotlin/UInt;", "uintDivide-J1ME1BU", "uintDivide", "uintRemainder-J1ME1BU", "uintRemainder", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongDivide", "ulongRemainder-eb3DHEI", "ulongRemainder", "", "v", "doubleToUInt", "(D)I", "doubleToULong", "(D)J", "uintToDouble", "(I)D", "ulongToDouble", "(J)D", "", "ulongToString", "(J)Ljava/lang/String;", "base", "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "UnsignedKt")
/* loaded from: classes5.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d2) {
        if (Double.isNaN(d2) || d2 <= uintToDouble(0)) {
            return 0;
        }
        if (d2 >= uintToDouble(-1)) {
            return -1;
        }
        double d3 = Integer.MAX_VALUE;
        if (d2 <= d3) {
            return UInt.m168constructorimpl((int) d2);
        }
        Double.isNaN(d3);
        return UInt.m168constructorimpl(UInt.m168constructorimpl((int) (d2 - d3)) + UInt.m168constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double d2) {
        if (Double.isNaN(d2) || d2 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d2 >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d2 < ((double) Long.MAX_VALUE) ? ULong.m237constructorimpl((long) d2) : ULong.m237constructorimpl(ULong.m237constructorimpl((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i2, int i3) {
        return Intrinsics.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU */
    public static final int m394uintDivideJ1ME1BU(int i2, int i3) {
        return UInt.m168constructorimpl((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU */
    public static final int m395uintRemainderJ1ME1BU(int i2, int i3) {
        return UInt.m168constructorimpl((int) ((i2 & 4294967295L) % (i3 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i2) {
        double d2 = Integer.MAX_VALUE & i2;
        double d3 = (i2 >>> 31) << 30;
        double d4 = 2;
        Double.isNaN(d3);
        Double.isNaN(d4);
        Double.isNaN(d2);
        return d2 + (d3 * d4);
    }

    @PublishedApi
    public static final int ulongCompare(long j2, long j3) {
        return ((j2 ^ Long.MIN_VALUE) > (j3 ^ Long.MIN_VALUE) ? 1 : ((j2 ^ Long.MIN_VALUE) == (j3 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI */
    public static final long m396ulongDivideeb3DHEI(long j2, long j3) {
        if (j3 < 0) {
            return ulongCompare(j2, j3) < 0 ? ULong.m237constructorimpl(0L) : ULong.m237constructorimpl(1L);
        }
        if (j2 >= 0) {
            return ULong.m237constructorimpl(j2 / j3);
        }
        long j4 = ((j2 >>> 1) / j3) << 1;
        return ULong.m237constructorimpl(j4 + (ulongCompare(ULong.m237constructorimpl(j2 - (j4 * j3)), ULong.m237constructorimpl(j3)) < 0 ? 0 : 1));
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI */
    public static final long m397ulongRemaindereb3DHEI(long j2, long j3) {
        if (j3 < 0) {
            return ulongCompare(j2, j3) < 0 ? j2 : ULong.m237constructorimpl(j2 - j3);
        }
        if (j2 >= 0) {
            return ULong.m237constructorimpl(j2 % j3);
        }
        long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
        if (ulongCompare(ULong.m237constructorimpl(j4), ULong.m237constructorimpl(j3)) < 0) {
            j3 = 0;
        }
        return ULong.m237constructorimpl(j4 - j3);
    }

    @PublishedApi
    public static final double ulongToDouble(long j2) {
        double d2 = j2 >>> 11;
        double d3 = 2048;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = j2 & 2047;
        Double.isNaN(d4);
        return (d2 * d3) + d4;
    }

    @d
    public static final String ulongToString(long j2) {
        return ulongToString(j2, 10);
    }

    @d
    public static final String ulongToString(long j2, int i2) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j2 >= 0) {
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(i2);
            String l = Long.toString(j2, checkRadix3);
            Intrinsics.checkExpressionValueIsNotNull(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        String l2 = Long.toString(j4, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(i2);
        String l3 = Long.toString(j5, checkRadix2);
        Intrinsics.checkExpressionValueIsNotNull(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
