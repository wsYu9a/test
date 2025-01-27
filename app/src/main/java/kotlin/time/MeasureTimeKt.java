package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0007\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/Function0;", "", "block", "Lkotlin/time/Duration;", "measureTime", "(Lkotlin/jvm/functions/Function0;)D", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/time/TimedValue;", "measureTimedValue", "(Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(@d Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        block.invoke();
        return markNow.elapsedNow();
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(@d Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new TimedValue<>(block.invoke(), TimeSource.Monotonic.INSTANCE.markNow().elapsedNow(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(@d TimeSource measureTime, @d Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(measureTime, "$this$measureTime");
        Intrinsics.checkParameterIsNotNull(block, "block");
        TimeMark markNow = measureTime.markNow();
        block.invoke();
        return markNow.elapsedNow();
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(@d TimeSource measureTimedValue, @d Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(measureTimedValue, "$this$measureTimedValue");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new TimedValue<>(block.invoke(), measureTimedValue.markNow().elapsedNow(), null);
    }
}
