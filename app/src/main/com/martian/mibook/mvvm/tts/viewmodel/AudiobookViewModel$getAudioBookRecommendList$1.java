package com.martian.mibook.mvvm.tts.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.RecommendBooksParams;
import com.martian.mibook.mvvm.tts.repository.AudiobookRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.viewmodel.AudiobookViewModel$getAudioBookRecommendList$1", f = "AudiobookViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookViewModel$getAudioBookRecommendList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudiobookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookViewModel$getAudioBookRecommendList$1(AudiobookViewModel audiobookViewModel, Continuation<? super AudiobookViewModel$getAudioBookRecommendList$1> continuation) {
        super(2, continuation);
        this.this$0 = audiobookViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new AudiobookViewModel$getAudioBookRecommendList$1(this.this$0, continuation);
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
            recommendBooksParams.setPage(Boxing.boxInt(0));
            recommendBooksParams.setPageSize(Boxing.boxInt(8));
            recommendBooksParams.setSearchType(Boxing.boxInt(3));
            Book book = this.this$0.getBook();
            recommendBooksParams.setSourceName(book != null ? book.getSourceName() : null);
            Book book2 = this.this$0.getBook();
            recommendBooksParams.setSourceId(book2 != null ? book2.getSourceId() : null);
            Book book3 = this.this$0.getBook();
            recommendBooksParams.setKeywords(book3 != null ? book3.getBookName() : null);
            recommendBooksParams.setSeed(Boxing.boxInt(new Random().nextInt(10000)));
            Map<String, String> f10 = ExtKt.f(recommendBooksParams);
            AudiobookRepository f11 = this.this$0.f();
            this.label = 1;
            obj = f11.f(f10, this);
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
            mutableLiveData2 = this.this$0._mRecommendBookListLiveData;
            mutableLiveData2.postValue(tYSearchBookList.getBookItemList());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            mutableLiveData = this.this$0._mRecommendBookListLiveData;
            mutableLiveData.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((AudiobookViewModel$getAudioBookRecommendList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
