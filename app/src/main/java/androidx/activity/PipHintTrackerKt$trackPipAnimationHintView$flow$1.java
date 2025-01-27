package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NOTIFICATION_JUMP_URL}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$1 */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 $attachStateChangeListener;
        final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
            super(0);
            view3 = view;
            onScrollChangedListener = onScrollChangedListener;
            onLayoutChangeListener = onLayoutChangeListener;
            r32 = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            view3.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
            view3.removeOnLayoutChangeListener(onLayoutChangeListener);
            view3.removeOnAttachStateChangeListener(r32);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> continuation) {
        super(2, continuation);
        this.$view = view;
    }

    /* renamed from: invokeSuspend$lambda-0 */
    public static final void m1invokeSuspend$lambda0(ProducerScope producerScope, View v10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Rect trackPipAnimationHintView$positionInWindow;
        if (i10 == i14 && i12 == i16 && i11 == i15 && i13 == i17) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(v10, "v");
        trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(v10);
        producerScope.mo1557trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
    }

    /* renamed from: invokeSuspend$lambda-1 */
    public static final void m2invokeSuspend$lambda1(ProducerScope producerScope, View view) {
        Rect trackPipAnimationHintView$positionInWindow;
        trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view);
        producerScope.mo1557trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, continuation);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Rect trackPipAnimationHintView$positionInWindow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            a aVar = new View.OnLayoutChangeListener() { // from class: androidx.activity.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.m1invokeSuspend$lambda0(ProducerScope.this, view, i11, i12, i13, i14, i15, i16, i17, i18);
                }
            };
            b bVar = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.b

                /* renamed from: b */
                public final /* synthetic */ View f281b;

                public /* synthetic */ b(View view) {
                    view = view;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.m2invokeSuspend$lambda1(ProducerScope.this, view);
                }
            };
            PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new View.OnAttachStateChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1
                final /* synthetic */ ProducerScope<Rect> $$this$callbackFlow;
                final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
                final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
                final /* synthetic */ View $view;

                /* JADX WARN: Multi-variable type inference failed */
                public PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(ProducerScope<? super Rect> producerScope2, View view, ViewTreeObserver.OnScrollChangedListener bVar2, View.OnLayoutChangeListener aVar2) {
                    producerScope = producerScope2;
                    view2 = view;
                    onScrollChangedListener = bVar2;
                    onLayoutChangeListener = aVar2;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@k View v10) {
                    Rect trackPipAnimationHintView$positionInWindow2;
                    Intrinsics.checkNotNullParameter(v10, "v");
                    ProducerScope<Rect> producerScope2 = producerScope;
                    trackPipAnimationHintView$positionInWindow2 = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view2);
                    producerScope2.mo1557trySendJP2dKIU(trackPipAnimationHintView$positionInWindow2);
                    view2.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
                    view2.addOnLayoutChangeListener(onLayoutChangeListener);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@k View v10) {
                    Intrinsics.checkNotNullParameter(v10, "v");
                    v10.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
                    v10.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
            };
            if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view)) {
                trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view);
                producerScope2.mo1557trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
                this.$view.getViewTreeObserver().addOnScrollChangedListener(bVar2);
                this.$view.addOnLayoutChangeListener(aVar2);
            }
            this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1.1
                final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 $attachStateChangeListener;
                final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
                final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
                final /* synthetic */ View $view;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(View view, ViewTreeObserver.OnScrollChangedListener bVar2, View.OnLayoutChangeListener aVar2, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$12) {
                    super(0);
                    view3 = view;
                    onScrollChangedListener = bVar2;
                    onLayoutChangeListener = aVar2;
                    r32 = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$12;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    view3.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
                    view3.removeOnLayoutChangeListener(onLayoutChangeListener);
                    view3.removeOnAttachStateChangeListener(r32);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ProducerScope<? super Rect> producerScope, @l Continuation<? super Unit> continuation) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
