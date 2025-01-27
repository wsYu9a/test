package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.Launcher;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", Launcher.Method.INVOKE_CALLBACK, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$scanReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {1522, 1526}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes5.dex */
final class SequencesKt___SequencesKt$scanReduceIndexed$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ Sequence $this_scanReduceIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private SequenceScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$scanReduceIndexed$1(Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_scanReduceIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final Continuation<Unit> create(@e Object obj, @d Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        SequencesKt___SequencesKt$scanReduceIndexed$1 sequencesKt___SequencesKt$scanReduceIndexed$1 = new SequencesKt___SequencesKt$scanReduceIndexed$1(this.$this_scanReduceIndexed, this.$operation, completion);
        sequencesKt___SequencesKt$scanReduceIndexed$1.p$ = (SequenceScope) obj;
        return sequencesKt___SequencesKt$scanReduceIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$scanReduceIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0063  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @f.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@f.b.a.d java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
            goto L5d
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2a:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5c
        L38:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.sequences.SequenceScope r5 = r10.p$
            kotlin.sequences.Sequence r11 = r10.$this_scanReduceIndexed
            java.util.Iterator r4 = r11.iterator()
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L8c
            java.lang.Object r1 = r4.next()
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r11 = r5.yield(r1, r10)
            if (r11 != r0) goto L5c
            return r0
        L5c:
            r11 = r10
        L5d:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L8c
            kotlin.jvm.functions.Function3 r6 = r11.$operation
            int r7 = r3 + 1
            if (r3 >= 0) goto L6c
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L6c:
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.Object r8 = r4.next()
            java.lang.Object r3 = r6.invoke(r3, r1, r8)
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.I$0 = r7
            r11.label = r2
            java.lang.Object r1 = r5.yield(r3, r11)
            if (r1 != r0) goto L89
            return r0
        L89:
            r1 = r3
            r3 = r7
            goto L5d
        L8c:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$scanReduceIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
