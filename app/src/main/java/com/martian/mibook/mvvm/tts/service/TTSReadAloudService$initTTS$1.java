package com.martian.mibook.mvvm.tts.service;

import com.martian.mibook.mvvm.tts.TTSController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.TTSReadAloudService$initTTS$1", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TTSReadAloudService$initTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TTSReadAloudService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadAloudService$initTTS$1(TTSReadAloudService tTSReadAloudService, Continuation<? super TTSReadAloudService$initTTS$1> continuation) {
        super(2, continuation);
        this.this$0 = tTSReadAloudService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TTSReadAloudService$initTTS$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        TTSController F0;
        TTSReadAloudService$ttsActionListener$1 tTSReadAloudService$ttsActionListener$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        F0 = this.this$0.F0();
        TTSReadAloudService tTSReadAloudService = this.this$0;
        tTSReadAloudService$ttsActionListener$1 = tTSReadAloudService.ttsActionListener;
        F0.n(tTSReadAloudService, tTSReadAloudService$ttsActionListener$1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((TTSReadAloudService$initTTS$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
