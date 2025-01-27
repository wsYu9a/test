package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.CombineKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,112:1\n289#2,5:113\n*E\n"})
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3<R> implements Flow<R> {
    final /* synthetic */ Flow[] $flowArray$inlined;
    final /* synthetic */ Function2 $transform$inlined;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1 */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.this.collect(null, this);
        }
    }

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(Flow[] flowArr, Function2 function2) {
        this.$flowArray$inlined = flowArr;
        this.$transform$inlined = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @l
    public Object collect(@k FlowCollector<? super R> flowCollector, @k Continuation<? super Unit> continuation) {
        Flow[] flowArr = this.$flowArray$inlined;
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.$flowArray$inlined);
        Intrinsics.needClassReification();
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$6$1, new FlowKt__ZipKt$combine$6$2(this.$transform$inlined, null), continuation);
        return combineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? combineInternal : Unit.INSTANCE;
    }

    @l
    public Object collect$$forInline(@k FlowCollector flowCollector, @k Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.1
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation2) {
                super(continuation2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @l
            public final Object invokeSuspend(@k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.this.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        Flow[] flowArr = this.$flowArray$inlined;
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.$flowArray$inlined);
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform$inlined, null);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$6$1, flowKt__ZipKt$combine$6$2, continuation2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
