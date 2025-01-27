package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.Launcher;
import f.b.a.d;
import f.b.a.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", Launcher.Method.INVOKE_CALLBACK, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$scanReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {1492, 1495}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class SequencesKt___SequencesKt$scanReduce$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $operation;
    final /* synthetic */ Sequence $this_scanReduce;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private SequenceScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$scanReduce$1(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_scanReduce = sequence;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final Continuation<Unit> create(@e Object obj, @d Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        SequencesKt___SequencesKt$scanReduce$1 sequencesKt___SequencesKt$scanReduce$1 = new SequencesKt___SequencesKt$scanReduce$1(this.$this_scanReduce, this.$operation, completion);
        sequencesKt___SequencesKt$scanReduce$1.p$ = (SequenceScope) obj;
        return sequencesKt___SequencesKt$scanReduce$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$scanReduce$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object coroutine_suspended;
        SequenceScope sequenceScope;
        Object next;
        Iterator it;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = this.p$;
            Iterator it2 = this.$this_scanReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = sequenceScope;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (sequenceScope.yield(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = it2;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        next = this.L$2;
        it = (Iterator) this.L$1;
        sequenceScope = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        while (it.hasNext()) {
            next = this.$operation.invoke(next, it.next());
            this.L$0 = sequenceScope;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (sequenceScope.yield(next, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
