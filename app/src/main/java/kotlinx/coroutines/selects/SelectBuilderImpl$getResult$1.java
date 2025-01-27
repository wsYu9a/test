package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1", f = "SelectOld.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SelectBuilderImpl$getResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBuilderImpl$getResult$1(SelectBuilderImpl<R> selectBuilderImpl, Continuation<? super SelectBuilderImpl$getResult$1> continuation) {
        super(2, continuation);
        this.this$0 = selectBuilderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new SelectBuilderImpl$getResult$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                SelectImplementation selectImplementation = this.this$0;
                this.label = 1;
                obj = selectImplementation.doSelect(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            cancellableContinuationImpl2 = ((SelectBuilderImpl) this.this$0).cont;
            SelectOldKt.resumeUndispatched(cancellableContinuationImpl2, obj);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            cancellableContinuationImpl = ((SelectBuilderImpl) this.this$0).cont;
            SelectOldKt.resumeUndispatchedWithException(cancellableContinuationImpl, th2);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((SelectBuilderImpl$getResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
