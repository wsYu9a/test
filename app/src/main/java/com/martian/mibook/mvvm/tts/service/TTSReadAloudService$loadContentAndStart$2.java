package com.martian.mibook.mvvm.tts.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.TTSReadAloudService$loadContentAndStart$2", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TTSReadAloudService$loadContentAndStart$2 extends SuspendLambda implements Function3<CoroutineScope, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TTSReadAloudService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadAloudService$loadContentAndStart$2(TTSReadAloudService tTSReadAloudService, Continuation<? super TTSReadAloudService$loadContentAndStart$2> continuation) {
        super(3, continuation);
        this.this$0 = tTSReadAloudService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual((Boolean) this.L$0, Boxing.boxBoolean(true))) {
            this.this$0.X();
        } else {
            BaseReadAloudService.W(this.this$0, false, 1, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Boolean bool, @l Continuation<? super Unit> continuation) {
        TTSReadAloudService$loadContentAndStart$2 tTSReadAloudService$loadContentAndStart$2 = new TTSReadAloudService$loadContentAndStart$2(this.this$0, continuation);
        tTSReadAloudService$loadContentAndStart$2.L$0 = bool;
        return tTSReadAloudService$loadContentAndStart$2.invokeSuspend(Unit.INSTANCE);
    }
}
