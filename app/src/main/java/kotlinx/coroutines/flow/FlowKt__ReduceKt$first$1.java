package kotlinx.coroutines.flow;

import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p3.i;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {TinkerReport.KEY_APPLIED_LIB_EXTRACT}, m = "first", n = {i.f29758c, "collector$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class FlowKt__ReduceKt$first$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public FlowKt__ReduceKt$first$1(Continuation<? super FlowKt__ReduceKt$first$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt.first(null, this);
    }
}
