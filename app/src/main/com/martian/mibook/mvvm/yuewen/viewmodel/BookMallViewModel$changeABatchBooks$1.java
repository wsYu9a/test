package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.repository.BookMallRepository;
import java.util.ArrayList;
import java.util.List;
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
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel$changeABatchBooks$1", f = "BookMallViewModel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookMallViewModel$changeABatchBooks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWBookChannelBooksParams $bookMallParams;
    Object L$0;
    int label;
    final /* synthetic */ BookMallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookMallViewModel$changeABatchBooks$1(YWBookChannelBooksParams yWBookChannelBooksParams, BookMallViewModel bookMallViewModel, Continuation<? super BookMallViewModel$changeABatchBooks$1> continuation) {
        super(2, continuation);
        this.$bookMallParams = yWBookChannelBooksParams;
        this.this$0 = bookMallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookMallViewModel$changeABatchBooks$1(this.$bookMallParams, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        BookMallViewModel bookMallViewModel;
        MutableLiveData mutableLiveData;
        List<TYBookItem> bookList;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$bookMallParams);
            BookMallViewModel bookMallViewModel2 = this.this$0;
            BookMallRepository f11 = bookMallViewModel2.f();
            this.L$0 = bookMallViewModel2;
            this.label = 1;
            obj = f11.f(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            bookMallViewModel = bookMallViewModel2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bookMallViewModel = (BookMallViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        YWChannelBookList yWChannelBookList = (YWChannelBookList) obj;
        if (yWChannelBookList == null || (bookList = yWChannelBookList.getBookList()) == null || !bookList.isEmpty()) {
            List<TYBookItem> bookList2 = yWChannelBookList != null ? yWChannelBookList.getBookList() : null;
            if (bookList2 == null) {
                bookList2 = new ArrayList<>();
            }
            MiConfigSingleton.b2().V1().j(bookList2);
            mutableLiveData = bookMallViewModel._mChangeABatchBooksLiveData;
            mutableLiveData.postValue(bookList2);
        } else {
            mutableLiveData2 = bookMallViewModel._mChangeABatchBooksLiveData;
            mutableLiveData2.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookMallViewModel$changeABatchBooks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
