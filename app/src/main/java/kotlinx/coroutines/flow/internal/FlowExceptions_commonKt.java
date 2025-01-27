package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.flow.FlowCollector;
import xi.k;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000¨\u0006\b"}, d2 = {"checkIndexOverflow", "", "index", "checkOwnership", "", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowExceptions_commonKt {
    @PublishedApi
    public static final int checkIndexOverflow(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void checkOwnership(@k AbortFlowException abortFlowException, @k FlowCollector<?> flowCollector) {
        if (abortFlowException.owner != flowCollector) {
            throw abortFlowException;
        }
    }
}
