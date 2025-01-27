package com.martian.mibook.mvvm.read.viewmodel;

import android.app.Activity;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$onPageSlide$1", f = "ReadingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$onPageSlide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$onPageSlide$1(ReadingViewModel readingViewModel, Activity activity, Continuation<? super ReadingViewModel$onPageSlide$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$onPageSlide$1(this.this$0, this.$activity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        long j10;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        long currentTimeMillis = System.currentTimeMillis();
        j10 = this.this$0.lastScrollTime;
        int coerceIn = RangesKt.coerceIn(((int) (currentTimeMillis - j10)) / 1000, 0, 25);
        this.this$0.lastScrollTime = System.currentTimeMillis();
        if (coerceIn <= 0) {
            return Unit.INSTANCE;
        }
        EventManager V1 = MiConfigSingleton.b2().V1();
        String sourceName = this.this$0.getSourceName();
        String sourceId = this.this$0.getSourceId();
        String recommendId = this.this$0.getRecommendId();
        int i10 = this.this$0.getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
        MiReadingRecord record = this.this$0.getRecord();
        V1.h(6, sourceName, sourceId, recommendId, "", "", coerceIn, i10, "", record != null && record.isFirstRead());
        ReadingViewModel readingViewModel = this.this$0;
        readingViewModel.y3(readingViewModel.getProcessSeconds() + coerceIn);
        ReadingViewModel readingViewModel2 = this.this$0;
        readingViewModel2.p3(readingViewModel2.getTotalSeconds() + coerceIn);
        MiConfigSingleton.b2().G1().e(this.$activity, this.this$0.getTotalSeconds());
        ReadingInstance.z().W(this.this$0.getTotalSeconds());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$onPageSlide$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
