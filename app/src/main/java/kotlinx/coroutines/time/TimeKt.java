package kotlinx.coroutines.time;

import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aU\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\r\u001aJ\u0010\u000e\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0003H\u0002\u001a&\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0012\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0007\u001aD\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0012\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0003H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"delay", "", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", ExifInterface.GPS_DIRECTION_TRUE, e.f19025e, "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "coerceToMillis", "", "debounce", "Lkotlinx/coroutines/flow/Flow;", "timeout", "onTimeout", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/Function1;", "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "sample", "period", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TimeKt {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r0 < 807000000) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final long coerceToMillis(java.time.Duration r5) {
        /*
            java.time.Duration r0 = ji.a.a()
            int r0 = ji.b.a(r5, r0)
            if (r0 > 0) goto Ld
            r0 = 0
            return r0
        Ld:
            java.time.temporal.ChronoUnit r0 = ji.c.a()
            java.time.Duration r0 = ji.d.a(r0)
            int r0 = ji.b.a(r5, r0)
            if (r0 > 0) goto L1e
            r0 = 1
            return r0
        L1e:
            long r0 = di.a.a(r5)
            r2 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L43
            long r0 = di.a.a(r5)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L3d
            int r0 = di.b.a(r5)
            r1 = 807000000(0x3019d7c0, float:5.5967675E-10)
            if (r0 >= r1) goto L3d
            goto L43
        L3d:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L47
        L43:
            long r0 = ji.e.a(r5)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.time.TimeKt.coerceToMillis(java.time.Duration):long");
    }

    @FlowPreview
    @k
    public static final <T> Flow<T> debounce(@k Flow<? extends T> flow, @k Duration duration) {
        return FlowKt.debounce(flow, coerceToMillis(duration));
    }

    @l
    public static final Object delay(@k Duration duration, @k Continuation<? super Unit> continuation) {
        Object delay = DelayKt.delay(coerceToMillis(duration), continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    public static final <R> void onTimeout(@k SelectBuilder<? super R> selectBuilder, @k Duration duration, @k Function1<? super Continuation<? super R>, ? extends Object> function1) {
        OnTimeoutKt.onTimeout(selectBuilder, coerceToMillis(duration), function1);
    }

    @FlowPreview
    @k
    public static final <T> Flow<T> sample(@k Flow<? extends T> flow, @k Duration duration) {
        return FlowKt.sample(flow, coerceToMillis(duration));
    }

    @l
    public static final <T> Object withTimeout(@k Duration duration, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @k Continuation<? super T> continuation) {
        return TimeoutKt.withTimeout(coerceToMillis(duration), function2, continuation);
    }

    @l
    public static final <T> Object withTimeoutOrNull(@k Duration duration, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @k Continuation<? super T> continuation) {
        return TimeoutKt.withTimeoutOrNull(coerceToMillis(duration), function2, continuation);
    }
}
