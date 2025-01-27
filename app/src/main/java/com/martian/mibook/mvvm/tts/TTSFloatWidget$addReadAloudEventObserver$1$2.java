package com.martian.mibook.mvvm.tts;

import kc.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.TTSFloatWidget$addReadAloudEventObserver$1$2", f = "TTSFloatWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TTSFloatWidget$addReadAloudEventObserver$1$2 extends SuspendLambda implements Function3<CoroutineScope, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ TTSFloatWidget this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSFloatWidget$addReadAloudEventObserver$1$2(TTSFloatWidget tTSFloatWidget, Continuation<? super TTSFloatWidget$addReadAloudEventObserver$1$2> continuation) {
        super(3, continuation);
        this.this$0 = tTSFloatWidget;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.Z$0) {
            this.this$0.v();
            b.f(null, 0, 0, false, null, 31, null);
        }
        return Unit.INSTANCE;
    }

    @l
    public final Object invoke(@k CoroutineScope coroutineScope, boolean z10, @l Continuation<? super Unit> continuation) {
        TTSFloatWidget$addReadAloudEventObserver$1$2 tTSFloatWidget$addReadAloudEventObserver$1$2 = new TTSFloatWidget$addReadAloudEventObserver$1$2(this.this$0, continuation);
        tTSFloatWidget$addReadAloudEventObserver$1$2.Z$0 = z10;
        return tTSFloatWidget$addReadAloudEventObserver$1$2.invokeSuspend(Unit.INSTANCE);
    }
}
