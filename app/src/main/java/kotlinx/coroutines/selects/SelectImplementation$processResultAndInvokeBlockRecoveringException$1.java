package kotlinx.coroutines.selects;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {TypedValues.TransitionType.TYPE_STAGGERED}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<R> selectImplementation, Continuation<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> continuation) {
        super(continuation);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object processResultAndInvokeBlockRecoveringException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processResultAndInvokeBlockRecoveringException = this.this$0.processResultAndInvokeBlockRecoveringException(null, null, this);
        return processResultAndInvokeBlockRecoveringException;
    }
}
