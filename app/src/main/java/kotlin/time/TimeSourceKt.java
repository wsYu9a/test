package kotlin.time;

import com.heytap.mcssdk.n.d;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001f\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0007*P\b\u0007\u0010\u0016\"\u00020\b2\u00020\bB\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB0\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015*P\b\u0007\u0010\u001a\"\u00020\u00002\u00020\u0000B\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB0\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u0018\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlin/time/TimeMark;", AdnName.OTHER, "Lkotlin/time/Duration;", "minus", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)D", "", "compareTo", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)I", "Lkotlin/time/TimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", d.l, "Use TimeSource interface instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.TimeSource", "expression", "TimeSource", "Clock", "Use TimeMark class instead.", "kotlin.time.TimeMark", "TimeMark", "ClockMark", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TimeSourceKt {
    @Deprecated(message = "Use TimeSource interface instead.", replaceWith = @ReplaceWith(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void Clock$annotations() {
    }

    @Deprecated(message = "Use TimeMark class instead.", replaceWith = @ReplaceWith(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void ClockMark$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    private static final int compareTo(@f.b.a.d TimeMark compareTo, TimeMark timeMark) {
        Intrinsics.checkParameterIsNotNull(compareTo, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    private static final double minus(@f.b.a.d TimeMark minus, TimeMark timeMark) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        throw new Error("Operation is disallowed.");
    }
}
