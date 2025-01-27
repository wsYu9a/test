package com.martian.mibook.mvvm.tts;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1", f = "TTSReadManager.kt", i = {0, 1}, l = {42, 52, 53}, m = "invokeSuspend", n = {"$this$async", "deferredResult"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class TTSReadManager$doStartService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $bookSource;
    final /* synthetic */ int $chapterIndex;
    final /* synthetic */ int $contentPos;
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadManager$doStartService$1(Context context, String str, int i10, int i11, Continuation<? super TTSReadManager$doStartService$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$bookSource = str;
        this.$chapterIndex = i10;
        this.$contentPos = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        TTSReadManager$doStartService$1 tTSReadManager$doStartService$1 = new TTSReadManager$doStartService$1(this.$context, this.$bookSource, this.$chapterIndex, this.$contentPos, continuation);
        tTSReadManager$doStartService$1.L$0 = obj;
        return tTSReadManager$doStartService$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ab A[PHI: r15
  0x00ab: PHI (r15v13 java.lang.Object) = (r15v12 java.lang.Object), (r15v0 java.lang.Object) binds: [B:13:0x00a8, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L30
            if (r1 == r5) goto L28
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lab
        L17:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1f:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto La0
        L28:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L52
        L30:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r1 = r15
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a r15 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.INSTANCE
            boolean r15 = r15.m()
            if (r15 == 0) goto L52
            android.content.Context r15 = r14.$context
            com.martian.mibook.mvvm.tts.TTSReadManager.l(r15)
            r14.L$0 = r1
            r14.label = r5
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r15 = kotlinx.coroutines.DelayKt.delay(r5, r14)
            if (r15 != r0) goto L52
            return r0
        L52:
            android.content.Context r15 = r14.$context
            android.content.Context r15 = r15.getApplicationContext()
            java.lang.String r5 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)
            com.martian.mibook.mvvm.tts.TtsTimeController.q(r15)
            com.martian.mibook.application.MiConfigSingleton r15 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.MiBookManager r15 = r15.M1()
            java.lang.String r5 = r14.$bookSource
            com.martian.mibook.lib.model.data.abs.Book r15 = r15.H(r5)
            com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1$deferredBitmap$1 r8 = new com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1$deferredBitmap$1
            android.content.Context r5 = r14.$context
            r8.<init>(r5, r15, r2)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            r5 = r1
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
            com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1$deferredResult$1 r13 = new com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1$deferredResult$1
            java.lang.String r8 = r14.$bookSource
            int r9 = r14.$chapterIndex
            int r10 = r14.$contentPos
            r11 = 0
            r6 = r13
            r7 = r15
            r6.<init>(r7, r8, r9, r10, r11)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            r8 = r13
            kotlinx.coroutines.Deferred r1 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
            r14.L$0 = r1
            r14.label = r4
            java.lang.Object r15 = r12.await(r14)
            if (r15 != r0) goto La0
            return r0
        La0:
            r14.L$0 = r2
            r14.label = r3
            java.lang.Object r15 = r1.await(r14)
            if (r15 != r0) goto Lab
            return r0
        Lab:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Boolean> continuation) {
        return ((TTSReadManager$doStartService$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
