package com.martian.mibook.mvvm.read.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$videoBonusComplete$1", f = "ReadingViewModel.kt", i = {}, l = {673}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$videoBonusComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chapterId;
    final /* synthetic */ String $chapterName;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$videoBonusComplete$1(ReadingViewModel readingViewModel, String str, String str2, Continuation<? super ReadingViewModel$videoBonusComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
        this.$chapterId = str;
        this.$chapterName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$videoBonusComplete$1(this.this$0, this.$chapterId, this.$chapterName, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sourceName", this.this$0.getSourceName());
            linkedHashMap.put("sourceId", this.this$0.getSourceId());
            linkedHashMap.put("chapterId", this.$chapterId);
            linkedHashMap.put("bookName", this.this$0.e0());
            if (!TextUtils.isEmpty(this.$chapterName)) {
                linkedHashMap.put("chapterName", this.$chapterName);
            }
            ReadingRepository f10 = this.this$0.f();
            this.label = 1;
            obj = f10.q(linkedHashMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = this.this$0._mVideoBonusCompleteLiveData;
        mutableLiveData.postValue((ChapterPrice) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$videoBonusComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
