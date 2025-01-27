package kotlin.time;

import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007*\u001e\b\u0007\u0010\f\"\u00020\u00022\u00020\u0002B\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nB\u0002\b\u000b¨\u0006\r"}, d2 = {"", Downloads.RequestHeaders.COLUMN_VALUE, "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convertDurationUnit", "(DLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)D", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "DurationUnit", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes5.dex */
class DurationUnitKt__DurationUnitJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void DurationUnit$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double convertDurationUnit(double d2, @d TimeUnit sourceUnit, @d TimeUnit targetUnit) {
        Intrinsics.checkParameterIsNotNull(sourceUnit, "sourceUnit");
        Intrinsics.checkParameterIsNotNull(targetUnit, "targetUnit");
        long convert = targetUnit.convert(1L, sourceUnit);
        if (convert > 0) {
            double d3 = convert;
            Double.isNaN(d3);
            return d2 * d3;
        }
        double convert2 = sourceUnit.convert(1L, targetUnit);
        Double.isNaN(convert2);
        return d2 / convert2;
    }
}
