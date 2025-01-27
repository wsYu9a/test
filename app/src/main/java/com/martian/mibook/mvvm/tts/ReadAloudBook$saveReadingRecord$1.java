package com.martian.mibook.mvvm.tts;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.ReadAloudBook$saveReadingRecord$1", f = "ReadAloudBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadAloudBook$saveReadingRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReadAloudBook this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadAloudBook$saveReadingRecord$1(ReadAloudBook readAloudBook, Continuation<? super ReadAloudBook$saveReadingRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = readAloudBook;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadAloudBook$saveReadingRecord$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        if (a10 == null) {
            return null;
        }
        ReadAloudBook readAloudBook2 = this.this$0;
        if (readAloudBook.m() == null) {
            readAloudBook.I(MiConfigSingleton.b2().M1().J(a10.getSourceString()));
        }
        MiReadingRecord m10 = readAloudBook.m();
        if (m10 == null) {
            return null;
        }
        m10.setChapterTitle(readAloudBook2.e());
        m10.setChapterIndex(Boxing.boxInt(RangesKt.coerceAtLeast(readAloudBook2.c(), 0)));
        Integer boxInt = Boxing.boxInt(readAloudBook2.f());
        Integer boxInt2 = Boxing.boxInt(0);
        ChapterContent i10 = readAloudBook.i();
        m10.setContentPos((Integer) RangesKt.coerceIn(boxInt, boxInt2, i10 != null ? Boxing.boxInt(i10.getContentLength()) : null));
        m10.setAudiobook(Boxing.boxInt(1));
        MiConfigSingleton.b2().M1().C0(a10, m10);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadAloudBook$saveReadingRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
