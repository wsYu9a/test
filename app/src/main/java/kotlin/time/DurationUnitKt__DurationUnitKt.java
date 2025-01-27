package kotlin.time;

import f.b.a.d;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnitKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "", "shortName", "(Ljava/util/concurrent/TimeUnit;)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes5.dex */
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final String shortName(@d TimeUnit shortName) {
        Intrinsics.checkParameterIsNotNull(shortName, "$this$shortName");
        switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[shortName.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
