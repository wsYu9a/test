package com.martian.mibook.mvvm.read.activity;

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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.activity.ReadingNewActivity$onBookMallClick$1", f = "ReadingNewActivity.kt", i = {}, l = {1020}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingNewActivity$onBookMallClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReadingNewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingNewActivity$onBookMallClick$1(ReadingNewActivity readingNewActivity, Continuation<? super ReadingNewActivity$onBookMallClick$1> continuation) {
        super(2, continuation);
        this.this$0 = readingNewActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingNewActivity$onBookMallClick$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
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
        super/*com.martian.mibook.mvvm.base.BaseMVVMActivity*/.finish();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingNewActivity$onBookMallClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
