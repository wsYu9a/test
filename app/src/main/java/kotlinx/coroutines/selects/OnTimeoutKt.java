package kotlinx.coroutines.selects;

import com.sigmob.sdk.downloader.core.breakpoint.e;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import xi.k;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"onTimeout", "", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "timeMillis", "", e.f19025e, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "timeout", "Lkotlin/time/Duration;", "onTimeout-8Mi8wO0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnTimeoutKt {
    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout(@k SelectBuilder<? super R> selectBuilder, long j10, @k Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.invoke(new OnTimeout(j10).getSelectClause(), (Function1<? super Continuation<? super Object>, ? extends Object>) function1);
    }

    @ExperimentalCoroutinesApi
    /* renamed from: onTimeout-8Mi8wO0 */
    public static final <R> void m1624onTimeout8Mi8wO0(@k SelectBuilder<? super R> selectBuilder, long j10, @k Function1<? super Continuation<? super R>, ? extends Object> function1) {
        onTimeout(selectBuilder, DelayKt.m1547toDelayMillisLRDsOJo(j10), function1);
    }
}
