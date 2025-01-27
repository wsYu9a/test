package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.BooksUpdateInfo;
import com.martian.mibook.mvvm.yuewen.repository.BookShelfRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel$getBooksUpdateInfo$1", f = "BookShelfViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookShelfViewModel$getBooksUpdateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sourceStrings;
    int label;
    final /* synthetic */ BookShelfViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookShelfViewModel$getBooksUpdateInfo$1(BookShelfViewModel bookShelfViewModel, String str, Continuation<? super BookShelfViewModel$getBooksUpdateInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = bookShelfViewModel;
        this.$sourceStrings = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookShelfViewModel$getBooksUpdateInfo$1(this.this$0, this.$sourceStrings, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            BookShelfRepository f10 = this.this$0.f();
            String str = this.$sourceStrings;
            this.label = 1;
            obj = f10.f(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<BooksUpdateInfo> list = (List) obj;
        List<BooksUpdateInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            mutableLiveData = this.this$0._mBooksUpdateInfo;
            mutableLiveData.postValue(Boxing.boxInt(0));
        } else {
            MiBookManager M1 = MiConfigSingleton.b2().M1();
            Integer boxInt = M1 != null ? Boxing.boxInt(M1.S2(list)) : null;
            mutableLiveData2 = this.this$0._mBooksUpdateInfo;
            mutableLiveData2.postValue(Boxing.boxInt(boxInt != null ? boxInt.intValue() : 0));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookShelfViewModel$getBooksUpdateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
