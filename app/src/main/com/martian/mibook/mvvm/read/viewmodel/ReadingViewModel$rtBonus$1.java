package com.martian.mibook.mvvm.read.viewmodel;

import ba.d;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.response.Bonus;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.base.SingleLiveEvent;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.RtParams;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import hf.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$rtBonus$1", f = "ReadingViewModel.kt", i = {}, l = {797}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$rtBonus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chapterId;
    final /* synthetic */ int $duration;
    final /* synthetic */ Boolean $isVipChapter;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$rtBonus$1(ReadingViewModel readingViewModel, int i10, Boolean bool, String str, Continuation<? super ReadingViewModel$rtBonus$1> continuation) {
        super(2, continuation);
        this.this$0 = readingViewModel;
        this.$duration = i10;
        this.$isVipChapter = bool;
        this.$chapterId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$rtBonus$1(this.this$0, this.$duration, this.$isVipChapter, this.$chapterId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        boolean z10;
        String str;
        long j10;
        Object p10;
        SingleLiveEvent singleLiveEvent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            z10 = this.this$0.rTing;
            if (z10) {
                return Unit.INSTANCE;
            }
            this.this$0.rTing = true;
            RtParams rtParams = new RtParams(null, null, null, null, null, null, null, null, 255, null);
            int i11 = this.$duration;
            ReadingViewModel readingViewModel = this.this$0;
            Boolean bool = this.$isVipChapter;
            String str2 = this.$chapterId;
            rtParams.setD(Boxing.boxInt(i11));
            rtParams.setS(readingViewModel.getSourceString());
            try {
                str = d.a(i11 + e.f26694a + readingViewModel.getSourceString(), ConfigSingleton.D().V());
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            rtParams.setC(str);
            ChapterList chapterList = readingViewModel.getChapterList();
            rtParams.setCs(chapterList != null ? Boxing.boxInt(chapterList.getCount()) : null);
            MiReadingRecord record = readingViewModel.getRecord();
            rtParams.setCi(record != null ? Boxing.boxInt(record.getChapterIndex()) : null);
            if (bool != null) {
                rtParams.setV(bool.booleanValue() ? Boxing.boxInt(1) : Boxing.boxInt(0));
            }
            if (str2 != null) {
                Boxing.boxBoolean(Intrinsics.areEqual(rtParams.getCcid(), str2));
            }
            j10 = readingViewModel.timeStamp;
            rtParams.setSeq(Boxing.boxInt((int) (j10 / 1000)));
            Map<String, String> f10 = ExtKt.f(rtParams);
            ReadingRepository f11 = this.this$0.f();
            this.label = 1;
            p10 = f11.p(f10, this);
            if (p10 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            p10 = obj;
        }
        singleLiveEvent = this.this$0._mRtBonusLiveData;
        singleLiveEvent.postValue((Bonus) p10);
        this.this$0.rTing = false;
        this.this$0.y3(0);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$rtBonus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
