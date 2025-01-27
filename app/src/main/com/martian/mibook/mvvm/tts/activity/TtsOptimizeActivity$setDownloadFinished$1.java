package com.martian.mibook.mvvm.tts.activity;

import com.martian.mibook.R;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.activity.TtsOptimizeActivity$setDownloadFinished$1", f = "TtsOptimizeActivity.kt", i = {}, l = {TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TtsOptimizeActivity$setDownloadFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TtsOptimizeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsOptimizeActivity$setDownloadFinished$1(TtsOptimizeActivity ttsOptimizeActivity, Continuation<? super TtsOptimizeActivity$setDownloadFinished$1> continuation) {
        super(2, continuation);
        this.this$0 = ttsOptimizeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TtsOptimizeActivity$setDownloadFinished$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            TtsOptimizeActivity.K1(this.this$0).downloadStatus.setText(this.this$0.getString(R.string.installing));
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
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
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((TtsOptimizeActivity$setDownloadFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
