package kotlin.time;

import f.b.a.d;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b(\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\u00072\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\t2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\n\u001a\u001f\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0087\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"#\u0010\u0015\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"#\u0010\u001a\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"#\u0010\u001d\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001b\u0010\u0012\"#\u0010\"\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\"#\u0010\"\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u0014\u001a\u0004\b\u001e\u0010\u0012\"#\u0010\u0015\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u0011\u0010\u0017\"#\u0010%\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b$\u0010\u0019\u001a\u0004\b#\u0010\u0017\"#\u0010\"\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u0017\"#\u0010(\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010\u0019\u001a\u0004\b&\u0010\u0017\"#\u0010+\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b*\u0010\u0019\u001a\u0004\b)\u0010\u0017\"#\u0010%\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b$\u0010\u0014\u001a\u0004\b#\u0010\u0012\"#\u0010(\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010!\u001a\u0004\b&\u0010\u001f\"#\u0010\u0015\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0013\u0010!\u001a\u0004\b\u0011\u0010\u001f\"#\u0010\u001d\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010!\u001a\u0004\b\u001b\u0010\u001f\"#\u0010%\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001f\"#\u0010+\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b*\u0010!\u001a\u0004\b)\u0010\u001f\"#\u0010(\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010\u0014\u001a\u0004\b&\u0010\u0012\"#\u0010\u001a\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010!\u001a\u0004\b\u0016\u0010\u001f\"#\u0010+\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b*\u0010\u0014\u001a\u0004\b)\u0010\u0012\"#\u0010\u001a\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012\"\u001d\u00100\u001a\u00020\u00018Â\u0002@\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-\"#\u0010\u001d\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILjava/util/concurrent/TimeUnit;)D", "", "(JLjava/util/concurrent/TimeUnit;)D", "", "(DLjava/util/concurrent/TimeUnit;)D", "duration", "times-mvk6XK0", "(ID)D", "times", "times-kIfJnKk", "(DD)D", "getMilliseconds", "(I)D", "milliseconds$annotations", "(I)V", "milliseconds", "getSeconds", "(J)D", "seconds$annotations", "(J)V", "seconds", "getMinutes", "minutes$annotations", "minutes", "getMicroseconds", "(D)D", "microseconds$annotations", "(D)V", "microseconds", "getHours", "hours$annotations", "hours", "getDays", "days$annotations", "days", "getNanoseconds", "nanoseconds$annotations", "nanoseconds", "getStorageUnit", "()Ljava/util/concurrent/TimeUnit;", "storageUnit$annotations", "()V", "storageUnit", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class DurationKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void days$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void days$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void days$annotations(long j2) {
    }

    public static final double getDays(int i2) {
        return toDuration(i2, TimeUnit.DAYS);
    }

    public static final double getHours(int i2) {
        return toDuration(i2, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(int i2) {
        return toDuration(i2, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(int i2) {
        return toDuration(i2, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(int i2) {
        return toDuration(i2, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(int i2) {
        return toDuration(i2, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(int i2) {
        return toDuration(i2, TimeUnit.SECONDS);
    }

    public static final TimeUnit getStorageUnit() {
        return TimeUnit.NANOSECONDS;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void hours$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void hours$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void hours$annotations(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void microseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void microseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void microseconds$annotations(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void milliseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void milliseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void milliseconds$annotations(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void minutes$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void minutes$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void minutes$annotations(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void nanoseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void nanoseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void nanoseconds$annotations(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void seconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void seconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void seconds$annotations(long j2) {
    }

    private static /* synthetic */ void storageUnit$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-kIfJnKk */
    private static final double m1092timeskIfJnKk(double d2, double d3) {
        return Duration.m1074timesimpl(d3, d2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-mvk6XK0 */
    private static final double m1093timesmvk6XK0(int i2, double d2) {
        return Duration.m1075timesimpl(d2, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(int i2, @d TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return toDuration(i2, unit);
    }

    public static final double getDays(long j2) {
        return toDuration(j2, TimeUnit.DAYS);
    }

    public static final double getHours(long j2) {
        return toDuration(j2, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(long j2) {
        return toDuration(j2, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(long j2) {
        return toDuration(j2, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(long j2) {
        return toDuration(j2, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(long j2) {
        return toDuration(j2, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(long j2) {
        return toDuration(j2, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(long j2, @d TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return toDuration(j2, unit);
    }

    public static final double getDays(double d2) {
        return toDuration(d2, TimeUnit.DAYS);
    }

    public static final double getHours(double d2) {
        return toDuration(d2, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(double d2) {
        return toDuration(d2, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(double d2) {
        return toDuration(d2, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(double d2) {
        return toDuration(d2, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(double d2) {
        return toDuration(d2, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(double d2) {
        return toDuration(d2, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(double d2, @d TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return Duration.m1048constructorimpl(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, unit, TimeUnit.NANOSECONDS));
    }
}
