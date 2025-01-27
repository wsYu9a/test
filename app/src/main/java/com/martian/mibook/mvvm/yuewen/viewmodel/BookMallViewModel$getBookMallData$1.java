package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookMallParams;
import com.martian.mibook.mvvm.yuewen.repository.BookMallRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uc.d;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel$getBookMallData$1", f = "BookMallViewModel.kt", i = {}, l = {TTDownloadField.CALL_EVENT_CONFIG_GET_CLICK_BUTTON_TAG}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookMallViewModel$getBookMallData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWBookMallParams $bookMallParams;
    final /* synthetic */ boolean $isLoadMore;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ BookMallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookMallViewModel$getBookMallData$1(YWBookMallParams yWBookMallParams, BookMallViewModel bookMallViewModel, boolean z10, Continuation<? super BookMallViewModel$getBookMallData$1> continuation) {
        super(2, continuation);
        this.$bookMallParams = yWBookMallParams;
        this.this$0 = bookMallViewModel;
        this.$isLoadMore = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookMallViewModel$getBookMallData$1(this.$bookMallParams, this.this$0, this.$isLoadMore, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        BookMallViewModel bookMallViewModel;
        boolean z10;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$bookMallParams);
            bookMallViewModel = this.this$0;
            boolean z11 = this.$isLoadMore;
            BookMallRepository f11 = bookMallViewModel.f();
            this.L$0 = bookMallViewModel;
            this.Z$0 = z11;
            this.label = 1;
            obj = f11.g(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            z10 = z11;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z10 = this.Z$0;
            bookMallViewModel = (BookMallViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        d dVar = (d) obj;
        if (!dVar.k() && dVar.h() != -1) {
            throw new ErrorResult(dVar.h(), dVar.i(), null, 4, null);
        }
        YWBookMall yWBookMall = (YWBookMall) dVar.g();
        if (!z10) {
            MiConfigSingleton.b2().M1().v2(yWBookMall, bookMallViewModel.getTid());
        }
        mutableLiveData = bookMallViewModel._mYWBookMallLiveData;
        mutableLiveData.postValue(yWBookMall);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookMallViewModel$getBookMallData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
