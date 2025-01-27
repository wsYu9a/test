package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.yuewen.repository.TagBookListRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.TagBookListViewModel$getCategoryBookList$1", f = "TagBookListViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TagBookListViewModel$getCategoryBookList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWCategoryBookListParams $bookListParams;
    Object L$0;
    int label;
    final /* synthetic */ TagBookListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagBookListViewModel$getCategoryBookList$1(YWCategoryBookListParams yWCategoryBookListParams, TagBookListViewModel tagBookListViewModel, Continuation<? super TagBookListViewModel$getCategoryBookList$1> continuation) {
        super(2, continuation);
        this.$bookListParams = yWCategoryBookListParams;
        this.this$0 = tagBookListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TagBookListViewModel$getCategoryBookList$1(this.$bookListParams, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        TagBookListViewModel tagBookListViewModel;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$bookListParams);
            TagBookListViewModel tagBookListViewModel2 = this.this$0;
            TagBookListRepository f11 = tagBookListViewModel2.f();
            this.L$0 = tagBookListViewModel2;
            this.label = 1;
            obj = f11.f(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            tagBookListViewModel = tagBookListViewModel2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            tagBookListViewModel = (TagBookListViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = tagBookListViewModel._mCategoryBookListLiveData;
        mutableLiveData.postValue((YWCategoryBookList) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((TagBookListViewModel$getCategoryBookList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
