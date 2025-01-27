package com.martian.mibook.mvvm.category.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.mvvm.category.repository.CategoryRepository;
import java.util.List;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.category.viewmodel.CategoryViewModel$getCategoryTagList$1", f = "CategoryViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CategoryViewModel$getCategoryTagList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $freeType;
    int label;
    final /* synthetic */ CategoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel$getCategoryTagList$1(CategoryViewModel categoryViewModel, int i10, Continuation<? super CategoryViewModel$getCategoryTagList$1> continuation) {
        super(2, continuation);
        this.this$0 = categoryViewModel;
        this.$freeType = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new CategoryViewModel$getCategoryTagList$1(this.this$0, this.$freeType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            CategoryRepository f10 = this.this$0.f();
            int i11 = this.$freeType;
            this.label = 1;
            obj = f10.f(i11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = this.this$0._mCategoryTagListLiveData;
        mutableLiveData.postValue((List) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((CategoryViewModel$getCategoryTagList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
