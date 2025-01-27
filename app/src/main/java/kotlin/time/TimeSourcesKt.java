package kotlin.time;

import com.heytap.mcssdk.n.d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*P\b\u0007\u0010\u000e\"\u00020\u00002\u00020\u0000B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B0\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u000b\u0012\b\b\f\u0012\u0004\b\b(\r*P\b\u0007\u0010\u0013\"\u00020\u000f2\u00020\u000fB\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B0\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0010\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u0011\u0012\b\b\f\u0012\u0004\b\b(\u0012*P\b\u0007\u0010\u0018\"\u00020\u00142\u00020\u0014B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B0\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u0016\u0012\b\b\f\u0012\u0004\b\b(\u0017*P\b\u0007\u0010\u001d\"\u00020\u00192\u00020\u0019B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B0\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u001b\u0012\b\b\f\u0012\u0004\b\b(\u001c¨\u0006\u001e"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", d.l, "Use AbstractDoubleTimeSource instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.AbstractDoubleTimeSource", "expression", "AbstractDoubleTimeSource", "AbstractDoubleClock", "Lkotlin/time/AbstractLongTimeSource;", "Use AbstractLongTimeSource instead.", "kotlin.time.AbstractLongTimeSource", "AbstractLongTimeSource", "AbstractLongClock", "Lkotlin/time/TimeSource$Monotonic;", "Use TimeSource.Monotonic instead.", "kotlin.time.TimeSource", "TimeSource.Monotonic", "MonoClock", "Lkotlin/time/TestTimeSource;", "Use TestTimeSource instead.", "kotlin.time.TestTimeSource", "TestTimeSource", "TestClock", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TimeSourcesKt {
    @Deprecated(message = "Use AbstractDoubleTimeSource instead.", replaceWith = @ReplaceWith(expression = "AbstractDoubleTimeSource", imports = {"kotlin.time.AbstractDoubleTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void AbstractDoubleClock$annotations() {
    }

    @Deprecated(message = "Use AbstractLongTimeSource instead.", replaceWith = @ReplaceWith(expression = "AbstractLongTimeSource", imports = {"kotlin.time.AbstractLongTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void AbstractLongClock$annotations() {
    }

    @Deprecated(message = "Use TimeSource.Monotonic instead.", replaceWith = @ReplaceWith(expression = "TimeSource.Monotonic", imports = {"kotlin.time.TimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void MonoClock$annotations() {
    }

    @Deprecated(message = "Use TestTimeSource instead.", replaceWith = @ReplaceWith(expression = "TestTimeSource", imports = {"kotlin.time.TestTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void TestClock$annotations() {
    }
}
