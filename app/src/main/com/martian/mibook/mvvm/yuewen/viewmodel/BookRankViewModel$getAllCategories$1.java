package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import com.martian.mibook.mvvm.yuewen.repository.BookRankRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel$getAllCategories$1", f = "BookRankViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookRankViewModel$getAllCategories$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BookRankViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookRankViewModel$getAllCategories$1(BookRankViewModel bookRankViewModel, Continuation<? super BookRankViewModel$getAllCategories$1> continuation) {
        super(2, continuation);
        this.this$0 = bookRankViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookRankViewModel$getAllCategories$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Unit unit;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            YWFreeType F1 = MiConfigSingleton.b2().M1().F1(this.this$0.getCType());
            if (F1 != null) {
                mutableLiveData = this.this$0._mCategoryListLiveData;
                mutableLiveData.postValue(F1);
                return Unit.INSTANCE;
            }
            BookRankRepository f10 = this.this$0.f();
            this.label = 1;
            obj = f10.g(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        YWFreeTypeList yWFreeTypeList = (YWFreeTypeList) obj;
        List<YWFreeType> freeTypeList = yWFreeTypeList != null ? yWFreeTypeList.getFreeTypeList() : null;
        if (freeTypeList == null || freeTypeList.isEmpty()) {
            mutableLiveData2 = this.this$0._mCategoryListLiveData;
            mutableLiveData2.postValue(null);
            return Unit.INSTANCE;
        }
        List<YWFreeType> freeTypeList2 = yWFreeTypeList != null ? yWFreeTypeList.getFreeTypeList() : null;
        MiConfigSingleton.b2().M1().I2(yWFreeTypeList != null ? yWFreeTypeList.getTyTagList() : null);
        MiConfigSingleton.b2().M1().H2(freeTypeList2);
        if (freeTypeList2 != null) {
            BookRankViewModel bookRankViewModel = this.this$0;
            if (bookRankViewModel.getCType() == 1) {
                mutableLiveData6 = bookRankViewModel._mCategoryListLiveData;
                mutableLiveData6.postValue(freeTypeList2.get(0));
            } else if (freeTypeList2.size() > 1) {
                mutableLiveData5 = bookRankViewModel._mCategoryListLiveData;
                mutableLiveData5.postValue(freeTypeList2.get(1));
            } else {
                mutableLiveData4 = bookRankViewModel._mCategoryListLiveData;
                mutableLiveData4.postValue(null);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            mutableLiveData3 = this.this$0._mCategoryListLiveData;
            mutableLiveData3.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookRankViewModel$getAllCategories$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
