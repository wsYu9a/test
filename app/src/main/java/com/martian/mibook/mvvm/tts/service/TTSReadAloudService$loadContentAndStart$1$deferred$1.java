package com.martian.mibook.mvvm.tts.service;

import com.martian.mibook.mvvm.tts.ReadAloudBook;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.TTSReadAloudService$loadContentAndStart$1$deferred$1", f = "TTSReadAloudService.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TTSReadAloudService$loadContentAndStart$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $contentPos;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadAloudService$loadContentAndStart$1$deferred$1(int i10, Continuation<? super TTSReadAloudService$loadContentAndStart$1$deferred$1> continuation) {
        super(2, continuation);
        this.$contentPos = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TTSReadAloudService$loadContentAndStart$1$deferred$1(this.$contentPos, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            int i11 = this.$contentPos;
            this.label = 1;
            obj = readAloudBook.v(i11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Boolean> continuation) {
        return ((TTSReadAloudService$loadContentAndStart$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
