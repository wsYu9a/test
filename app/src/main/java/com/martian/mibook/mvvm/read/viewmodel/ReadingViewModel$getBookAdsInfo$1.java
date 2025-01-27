package com.martian.mibook.mvvm.read.viewmodel;

import com.martian.mibook.lib.account.response.BookAdsInfo;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$getBookAdsInfo$1", f = "ReadingViewModel.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$getBookAdsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$getBookAdsInfo$1(ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$getBookAdsInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$getBookAdsInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingRepository f10 = this.this$0.f();
            String sourceName = this.this$0.getSourceName();
            Intrinsics.checkNotNull(sourceName);
            String sourceId = this.this$0.getSourceId();
            Intrinsics.checkNotNull(sourceId);
            this.label = 1;
            obj = f10.f(sourceName, sourceId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BookAdsInfo bookAdsInfo = (BookAdsInfo) obj;
        if (bookAdsInfo != null) {
            ReadingViewModel readingViewModel = this.this$0;
            readingViewModel.H2(bookAdsInfo.getInterstitial());
            readingViewModel.r3(bookAdsInfo.getVideoUnlock());
            if (bookAdsInfo.getInterstitialIntervalMinutes() != null) {
                Integer interstitialIntervalMinutes = bookAdsInfo.getInterstitialIntervalMinutes();
                Intrinsics.checkNotNullExpressionValue(interstitialIntervalMinutes, "getInterstitialIntervalMinutes(...)");
                if (interstitialIntervalMinutes.intValue() > 0) {
                    Integer interstitialIntervalMinutes2 = bookAdsInfo.getInterstitialIntervalMinutes();
                    Intrinsics.checkNotNullExpressionValue(interstitialIntervalMinutes2, "getInterstitialIntervalMinutes(...)");
                    readingViewModel.interstitialMinutes = interstitialIntervalMinutes2.intValue();
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$getBookAdsInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
