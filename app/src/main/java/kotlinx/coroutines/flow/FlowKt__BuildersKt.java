package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.alimm.tanx.core.constant.TanxAdType;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.channels.ProducerScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001aK\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001aK\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0013\"\u0002H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0016\u001a!\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u0018\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001a\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001b\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001c\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u001d\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001e\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001f\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0 ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"callbackFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, e.f19025e, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", TanxAdType.FEED_STRING, "Lkotlinx/coroutines/flow/FlowCollector;", "flowOf", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "asFlow", "Lkotlin/Function0;", "", "", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n106#2:355\n106#2:356\n106#2:357\n106#2:358\n106#2:359\n106#2:360\n106#2:361\n106#2:362\n106#2:363\n106#2:364\n106#2:365\n106#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
/* loaded from: classes4.dex */
final /* synthetic */ class FlowKt__BuildersKt {
    @k
    public static final <T> Flow<T> asFlow(@k Function0<? extends T> function0) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1
            public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1() {
            }

            @Override // kotlinx.coroutines.flow.Flow
            @l
            public Object collect(@k FlowCollector<? super T> flowCollector, @k Continuation<? super Unit> continuation) {
                Object emit = flowCollector.emit((Object) Function0.this.invoke(), continuation);
                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
            }
        };
    }

    @k
    public static final <T> Flow<T> callbackFlow(@k @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new CallbackFlowBuilder(function2, null, 0, null, 14, null);
    }

    @k
    public static final <T> Flow<T> channelFlow(@k @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new ChannelFlowBuilder(function2, null, 0, null, 14, null);
    }

    @k
    public static final <T> Flow<T> emptyFlow() {
        return EmptyFlow.INSTANCE;
    }

    @k
    public static final <T> Flow<T> flow(@k @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SafeFlow(function2);
    }

    @k
    public static final <T> Flow<T> flowOf(@k T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    @k
    public static final <T> Flow<T> asFlow(@k Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    @k
    public static final <T> Flow<T> flowOf(T t10) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            final /* synthetic */ Object $value$inlined;

            public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(Object t102) {
                t10 = t102;
            }

            @Override // kotlinx.coroutines.flow.Flow
            @l
            public Object collect(@k FlowCollector<? super T> flowCollector, @k Continuation<? super Unit> continuation) {
                Object emit = flowCollector.emit((Object) t10, continuation);
                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
            }
        };
    }

    @k
    public static final <T> Flow<T> asFlow(@k Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @k
    public static final <T> Flow<T> asFlow(@k Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @k
    public static final <T> Flow<T> asFlow(@k Sequence<? extends T> sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    @k
    public static final <T> Flow<T> asFlow(@k T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @k
    public static final Flow<Integer> asFlow(@k int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @k
    public static final Flow<Long> asFlow(@k long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @k
    public static final Flow<Integer> asFlow(@k IntRange intRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(intRange);
    }

    @k
    public static final Flow<Long> asFlow(@k LongRange longRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(longRange);
    }
}
