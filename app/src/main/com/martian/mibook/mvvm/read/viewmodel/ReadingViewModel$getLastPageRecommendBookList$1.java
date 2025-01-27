package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.RecommendBooksParams;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Map;
import java.util.Random;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$getLastPageRecommendBookList$1", f = "ReadingViewModel.kt", i = {}, l = {DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$getLastPageRecommendBookList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$getLastPageRecommendBookList$1(int i10, int i11, ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$getLastPageRecommendBookList$1> continuation) {
        super(2, continuation);
        this.$pageIndex = i10;
        this.$pageSize = i11;
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$getLastPageRecommendBookList$1(this.$pageIndex, this.$pageSize, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Unit unit;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            RecommendBooksParams recommendBooksParams = new RecommendBooksParams(null, null, null, null, null, null, null, 127, null);
            recommendBooksParams.setPage(Boxing.boxInt(this.$pageIndex));
            recommendBooksParams.setPageSize(Boxing.boxInt(this.$pageSize));
            recommendBooksParams.setSearchType(Boxing.boxInt(6));
            recommendBooksParams.setSourceName(this.this$0.getSourceName());
            recommendBooksParams.setSourceId(this.this$0.getSourceId());
            recommendBooksParams.setKeywords(this.this$0.e0());
            recommendBooksParams.setSeed(Boxing.boxInt(new Random().nextInt(10000)));
            Map<String, String> f10 = ExtKt.f(recommendBooksParams);
            ReadingRepository f11 = this.this$0.f();
            this.label = 1;
            obj = f11.n(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TYSearchBookList tYSearchBookList = (TYSearchBookList) obj;
        if (tYSearchBookList != null) {
            ReadingViewModel readingViewModel = this.this$0;
            readingViewModel.I2(tYSearchBookList.getBookItemList());
            mutableLiveData2 = readingViewModel._mLastPageRecommendBookListLiveData;
            mutableLiveData2.postValue(tYSearchBookList.getBookItemList());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            mutableLiveData = this.this$0._mLastPageRecommendBookListLiveData;
            mutableLiveData.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$getLastPageRecommendBookList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
