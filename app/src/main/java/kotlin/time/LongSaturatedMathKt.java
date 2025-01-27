package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import m5.c;
import xi.k;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", c.a.f28370d, "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
/* loaded from: classes4.dex */
public final class LongSaturatedMathKt {
    /* renamed from: checkInfiniteSumDefined-PjuGub4 */
    private static final long m1510checkInfiniteSumDefinedPjuGub4(long j10, long j11, long j12) {
        if (!Duration.m1414isInfiniteimpl(j11) || (j10 ^ j12) >= 0) {
            return j10;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long j10) {
        Duration.Companion companion = Duration.INSTANCE;
        return j10 < 0 ? companion.m1484getNEG_INFINITEUwyO8pc$kotlin_stdlib() : companion.m1483getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long j10) {
        return ((j10 - 1) | 1) == Long.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-NuflL3o */
    public static final long m1511saturatingAddNuflL3o(long j10, @k DurationUnit unit, long j11) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long m1428toLongimpl = Duration.m1428toLongimpl(j11, unit);
        if (((j10 - 1) | 1) == Long.MAX_VALUE) {
            return m1510checkInfiniteSumDefinedPjuGub4(j10, j11, m1428toLongimpl);
        }
        if ((1 | (m1428toLongimpl - 1)) == Long.MAX_VALUE) {
            return m1512saturatingAddInHalvesNuflL3o(j10, unit, j11);
        }
        long j12 = j10 + m1428toLongimpl;
        return ((j10 ^ j12) & (m1428toLongimpl ^ j12)) < 0 ? j10 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j12;
    }

    /* renamed from: saturatingAddInHalves-NuflL3o */
    private static final long m1512saturatingAddInHalvesNuflL3o(long j10, DurationUnit durationUnit, long j11) {
        long m1385divUwyO8pc = Duration.m1385divUwyO8pc(j11, 2);
        long m1428toLongimpl = Duration.m1428toLongimpl(m1385divUwyO8pc, durationUnit);
        return (1 | (m1428toLongimpl - 1)) == Long.MAX_VALUE ? m1428toLongimpl : m1511saturatingAddNuflL3o(m1511saturatingAddNuflL3o(j10, durationUnit, m1385divUwyO8pc), durationUnit, Duration.m1417minusLRDsOJo(j11, m1385divUwyO8pc));
    }

    public static final long saturatingDiff(long j10, long j11, @k DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (1 | (j11 - 1)) == Long.MAX_VALUE ? Duration.m1435unaryMinusUwyO8pc(infinityOfSign(j11)) : saturatingFiniteDiff(j10, j11, unit);
    }

    private static final long saturatingFiniteDiff(long j10, long j11, DurationUnit durationUnit) {
        long j12 = j10 - j11;
        if (((j12 ^ j10) & (~(j12 ^ j11))) >= 0) {
            return DurationKt.toDuration(j12, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.m1435unaryMinusUwyO8pc(infinityOfSign(j12));
        }
        long convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
        long j13 = (j10 / convertDurationUnit) - (j11 / convertDurationUnit);
        long j14 = (j10 % convertDurationUnit) - (j11 % convertDurationUnit);
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m1418plusLRDsOJo(DurationKt.toDuration(j13, durationUnit2), DurationKt.toDuration(j14, durationUnit));
    }

    public static final long saturatingOriginsDiff(long j10, long j11, @k DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return ((j11 - 1) | 1) == Long.MAX_VALUE ? j10 == j11 ? Duration.INSTANCE.m1485getZEROUwyO8pc() : Duration.m1435unaryMinusUwyO8pc(infinityOfSign(j11)) : (1 | (j10 - 1)) == Long.MAX_VALUE ? infinityOfSign(j10) : saturatingFiniteDiff(j10, j11, unit);
    }
}
