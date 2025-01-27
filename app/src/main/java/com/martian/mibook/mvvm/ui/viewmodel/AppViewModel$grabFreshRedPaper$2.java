package com.martian.mibook.mvvm.ui.viewmodel;

import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$grabFreshRedPaper$2", f = "AppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppViewModel$grabFreshRedPaper$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$grabFreshRedPaper$2(AppViewModel appViewModel, Continuation<? super AppViewModel$grabFreshRedPaper$2> continuation) {
        super(2, continuation);
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        AppViewModel$grabFreshRedPaper$2 appViewModel$grabFreshRedPaper$2 = new AppViewModel$grabFreshRedPaper$2(this.this$0, continuation);
        appViewModel$grabFreshRedPaper$2.L$0 = obj;
        return appViewModel$grabFreshRedPaper$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ErrorResult errorResult, @l Continuation<? super Unit> continuation) {
        return ((AppViewModel$grabFreshRedPaper$2) create(errorResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        NonStickyLiveData nonStickyLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ErrorResult errorResult = (ErrorResult) this.L$0;
        nonStickyLiveData = this.this$0._mGrabFreshRedPaperErrorLiveData;
        nonStickyLiveData.postValue(errorResult);
        return Unit.INSTANCE;
    }
}
