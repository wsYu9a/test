package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.SharingStarted;
import xi.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"WhileSubscribed", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/SharingStarted$Companion;", "stopTimeout", "Lkotlin/time/Duration;", "replayExpiration", "WhileSubscribed-5qebJ5I", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SharingStartedKt {
    @k
    /* renamed from: WhileSubscribed-5qebJ5I */
    public static final SharingStarted m1599WhileSubscribed5qebJ5I(@k SharingStarted.Companion companion, long j10, long j11) {
        return new StartedWhileSubscribed(Duration.m1400getInWholeMillisecondsimpl(j10), Duration.m1400getInWholeMillisecondsimpl(j11));
    }

    /* renamed from: WhileSubscribed-5qebJ5I$default */
    public static /* synthetic */ SharingStarted m1600WhileSubscribed5qebJ5I$default(SharingStarted.Companion companion, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Duration.INSTANCE.m1485getZEROUwyO8pc();
        }
        if ((i10 & 2) != 0) {
            j11 = Duration.INSTANCE.m1483getINFINITEUwyO8pc();
        }
        return m1599WhileSubscribed5qebJ5I(companion, j10, j11);
    }
}
