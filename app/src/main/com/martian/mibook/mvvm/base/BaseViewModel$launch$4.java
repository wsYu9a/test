package com.martian.mibook.mvvm.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.mvvm.net.ErrorResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import uc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/martian/mibook/mvvm/base/BaseRepository;", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.base.BaseViewModel$launch$4", f = "BaseViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NAME}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BaseViewModel$launch$4 extends SuspendLambda implements Function3<CoroutineScope, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $error;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseViewModel<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseViewModel$launch$4(BaseViewModel<? extends T> baseViewModel, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super BaseViewModel$launch$4> continuation) {
        super(3, continuation);
        this.this$0 = baseViewModel;
        this.$error = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        ErrorResult e10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            e10 = this.this$0.e((Throwable) this.L$0);
            ErrorResult a10 = b.f30976a.a(e10);
            Function2<ErrorResult, Continuation<? super Unit>, Object> function2 = this.$error;
            this.L$0 = a10;
            this.label = 1;
            if (function2.invoke(a10, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @k Throwable th2, @l Continuation<? super Unit> continuation) {
        BaseViewModel$launch$4 baseViewModel$launch$4 = new BaseViewModel$launch$4(this.this$0, this.$error, continuation);
        baseViewModel$launch$4.L$0 = th2;
        return baseViewModel$launch$4.invokeSuspend(Unit.INSTANCE);
    }
}
