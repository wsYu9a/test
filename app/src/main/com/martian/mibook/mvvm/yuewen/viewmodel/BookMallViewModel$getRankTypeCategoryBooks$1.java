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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel$getRankTypeCategoryBooks$1", f = "BookMallViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookMallViewModel$getRankTypeCategoryBooks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWBookChannelBooksParams $bookMallParams;
    final /* synthetic */ boolean $isAddEvent;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ BookMallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookMallViewModel$getRankTypeCategoryBooks$1(YWBookChannelBooksParams yWBookChannelBooksParams, BookMallViewModel bookMallViewModel, boolean z10, Continuation<? super BookMallViewModel$getRankTypeCategoryBooks$1> continuation) {
        super(2, continuation);
        this.$bookMallParams = yWBookChannelBooksParams;
        this.this$0 = bookMallViewModel;
        this.$isAddEvent = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookMallViewModel$getRankTypeCategoryBooks$1(this.$bookMallParams, this.this$0, this.$isAddEvent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        BookMallViewModel bookMallViewModel;
        boolean z10;
        MutableLiveData mutableLiveData;
        List<TYBookItem> bookList;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$bookMallParams);
            bookMallViewModel = this.this$0;
            boolean z11 = this.$isAddEvent;
            BookMallRepository f11 = bookMallViewModel.f();
            this.L$0 = bookMallViewModel;
            this.Z$0 = z11;
            this.label = 1;
            obj = f11.f(f10, this);
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
        YWChannelBookList yWChannelBookList = (YWChannelBookList) obj;
        if (yWChannelBookList == null || (bookList = yWChannelBookList.getBookList()) == null || !bookList.isEmpty()) {
            List<TYBookItem> bookList2 = yWChannelBookList != null ? yWChannelBookList.getBookList() : null;
            if (bookList2 == null) {
                bookList2 = new ArrayList<>();
            }
            if (z10) {
                MiConfigSingleton.b2().V1().j(bookList2);
            }
            mutableLiveData = bookMallViewModel._mChannelBooksLiveData;
            mutableLiveData.postValue(bookList2);
        } else {
            mutableLiveData2 = bookMallViewModel._mChannelBooksLiveData;
            mutableLiveData2.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookMallViewModel$getRankTypeCategoryBooks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
