package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
    final /* synthetic */ Flow<T> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$1 */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
        final /* synthetic */ Ref.ObjectRef<MutableStateFlow<T>> $state;

        public AnonymousClass1(Ref.ObjectRef<MutableStateFlow<T>> objectRef, CoroutineScope coroutineScope, CompletableDeferred<StateFlow<T>> completableDeferred) {
            objectRef = objectRef;
            coroutineScope = coroutineScope;
            completableDeferred = completableDeferred;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @l
        public final Object emit(T t10, @k Continuation<? super Unit> continuation) {
            Unit unit;
            MutableStateFlow<T> mutableStateFlow = objectRef.element;
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t10);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                CoroutineScope coroutineScope = coroutineScope;
                Ref.ObjectRef<MutableStateFlow<T>> objectRef = objectRef;
                CompletableDeferred<StateFlow<T>> completableDeferred = completableDeferred;
                ?? r42 = (T) StateFlowKt.MutableStateFlow(t10);
                completableDeferred.complete(new ReadonlyStateFlow(r42, JobKt.getJob(coroutineScope.getCoroutineContext())));
                objectRef.element = r42;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = flow;
        this.$result = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Flow<T> flow = this.$upstream;
                AnonymousClass1 anonymousClass1 = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1.1
                    final /* synthetic */ CoroutineScope $$this$launch;
                    final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
                    final /* synthetic */ Ref.ObjectRef<MutableStateFlow<T>> $state;

                    public AnonymousClass1(Ref.ObjectRef<MutableStateFlow<T>> objectRef2, CoroutineScope coroutineScope2, CompletableDeferred<StateFlow<T>> completableDeferred) {
                        objectRef = objectRef2;
                        coroutineScope = coroutineScope2;
                        completableDeferred = completableDeferred;
                    }

                    /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @l
                    public final Object emit(T t10, @k Continuation<? super Unit> continuation) {
                        Unit unit;
                        MutableStateFlow<T> mutableStateFlow = objectRef.element;
                        if (mutableStateFlow != null) {
                            mutableStateFlow.setValue(t10);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            CoroutineScope coroutineScope2 = coroutineScope;
                            Ref.ObjectRef<MutableStateFlow<T>> objectRef2 = objectRef;
                            CompletableDeferred<StateFlow<T>> completableDeferred = completableDeferred;
                            ?? r42 = (T) StateFlowKt.MutableStateFlow(t10);
                            completableDeferred.complete(new ReadonlyStateFlow(r42, JobKt.getJob(coroutineScope2.getCoroutineContext())));
                            objectRef2.element = r42;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            this.$result.completeExceptionally(th2);
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
