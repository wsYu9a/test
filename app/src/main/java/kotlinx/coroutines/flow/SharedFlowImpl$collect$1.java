package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {372, 379, 382}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes4.dex */
public final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedFlowImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super SharedFlowImpl$collect$1> continuation) {
        super(continuation);
        this.this$0 = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
    }
}
