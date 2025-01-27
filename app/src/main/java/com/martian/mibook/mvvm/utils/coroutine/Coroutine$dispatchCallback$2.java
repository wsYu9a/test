package com.martian.mibook.mvvm.utils.coroutine;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.utils.coroutine.Coroutine$dispatchCallback$2", f = "Coroutine.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coroutine.kt\ncom/martian/mibook/mvvm/utils/coroutine/Coroutine$dispatchCallback$2\n*L\n1#1,249:1\n*E\n"})
/* loaded from: classes3.dex */
public final class Coroutine$dispatchCallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Coroutine<T>.Callback<R> $callback;
    final /* synthetic */ R $value;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Coroutine$dispatchCallback$2(Coroutine<T>.Callback<R> callback, R r10, Continuation<? super Coroutine$dispatchCallback$2> continuation) {
        super(2, continuation);
        this.$callback = callback;
        this.$value = r10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        Coroutine$dispatchCallback$2 coroutine$dispatchCallback$2 = new Coroutine$dispatchCallback$2(this.$callback, this.$value, continuation);
        coroutine$dispatchCallback$2.L$0 = obj;
        return coroutine$dispatchCallback$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Function3 block = this.$callback.getBlock();
            R r10 = this.$value;
            this.label = 1;
            if (block.invoke(coroutineScope, r10, this) == coroutine_suspended) {
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
        return ((Coroutine$dispatchCallback$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
