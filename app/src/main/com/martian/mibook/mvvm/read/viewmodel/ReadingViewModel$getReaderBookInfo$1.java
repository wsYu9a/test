package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$getReaderBookInfo$1", f = "ReadingViewModel.kt", i = {}, l = {730}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$getReaderBookInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$getReaderBookInfo$1(ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$getReaderBookInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$getReaderBookInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        ReadingViewModel readingViewModel;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingViewModel readingViewModel2 = this.this$0;
            ReadingRepository f10 = readingViewModel2.f();
            String sourceName = this.this$0.getSourceName();
            Intrinsics.checkNotNull(sourceName);
            String sourceId = this.this$0.getSourceId();
            Intrinsics.checkNotNull(sourceId);
            this.L$0 = readingViewModel2;
            this.label = 1;
            Object k10 = f10.k(sourceName, sourceId, this);
            if (k10 == coroutine_suspended) {
                return coroutine_suspended;
            }
            readingViewModel = readingViewModel2;
            obj = k10;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            readingViewModel = (ReadingViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        readingViewModel.W2((ReadingInfo) obj);
        mutableLiveData = this.this$0._mReadingInfoLiveData;
        mutableLiveData.postValue(this.this$0.getReadingInfo());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$getReaderBookInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
