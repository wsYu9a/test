package com.martian.mibook.mvvm.tts.service;

import com.tencent.bugly.beta.tinker.TinkerReport;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1", f = "TTSReadAloudService.kt", i = {0, 1}, l = {342, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class TTSReadAloudService$startTtsTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TTSReadAloudService this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1$1", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TTSReadAloudService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TTSReadAloudService tTSReadAloudService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = tTSReadAloudService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            int i10;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TTSReadAloudService tTSReadAloudService = this.this$0;
            i10 = tTSReadAloudService.fullSeconds;
            tTSReadAloudService.C0(i10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadAloudService$startTtsTimer$1(TTSReadAloudService tTSReadAloudService, Continuation<? super TTSReadAloudService$startTtsTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = tTSReadAloudService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        TTSReadAloudService$startTtsTimer$1 tTSReadAloudService$startTtsTimer$1 = new TTSReadAloudService$startTtsTimer$1(this.this$0, continuation);
        tTSReadAloudService$startTtsTimer$1.L$0 = obj;
        return tTSReadAloudService$startTtsTimer$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0048 -> B:9:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0054 -> B:6:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0064 -> B:6:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007c -> B:6:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:6:0x009b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9b
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L42
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
        L2e:
            boolean r1 = kotlinx.coroutines.CoroutineScopeKt.isActive(r9)
            if (r1 == 0) goto Lbc
            r8.L$0 = r9
            r8.label = r3
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r8)
            if (r1 != r0) goto L41
            return r0
        L41:
            r1 = r9
        L42:
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a r9 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.INSTANCE
            boolean r9 = r9.e()
            if (r9 != 0) goto Laa
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r9 = r8.this$0
            com.martian.mibook.mvvm.tts.TTSController r9 = com.martian.mibook.mvvm.tts.service.TTSReadAloudService.v0(r9)
            java.lang.Long r9 = r9.l()
            if (r9 == 0) goto L9b
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r9.longValue()
            long r4 = r4 - r6
            r6 = 120000(0x1d4c0, double:5.9288E-319)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L9b
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r9 = r8.this$0
            int r4 = com.martian.mibook.mvvm.tts.service.TTSReadAloudService.w0(r9)
            int r4 = r4 + r3
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService.A0(r9, r4)
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r9 = r8.this$0
            int r9 = com.martian.mibook.mvvm.tts.service.TTSReadAloudService.w0(r9)
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r4 = r8.this$0
            int r4 = com.martian.mibook.mvvm.tts.service.TTSReadAloudService.t0(r4)
            if (r9 < r4) goto L9b
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r9 = r8.this$0
            r4 = 0
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService.A0(r9, r4)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1$1 r4 = new com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1$1
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r5 = r8.this$0
            r6 = 0
            r4.<init>(r5, r6)
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r4, r8)
            if (r9 != r0) goto L9b
            return r0
        L9b:
            com.martian.mibook.mvvm.tts.TtsTimeController r9 = com.martian.mibook.mvvm.tts.TtsTimeController.f15066a
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r9 = r9.h()
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r4 = com.martian.mibook.mvvm.tts.TtsTimeController.TimeMode.MODE_ACCUMULATED_DURATION
            if (r9 != r4) goto Laa
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r9 = r8.this$0
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService.y0(r9)
        Laa:
            r9 = r1
            com.martian.mibook.mvvm.tts.TtsTimeController r1 = com.martian.mibook.mvvm.tts.TtsTimeController.f15066a
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r1 = r1.h()
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r4 = com.martian.mibook.mvvm.tts.TtsTimeController.TimeMode.MODE_NATURAL_TIME
            if (r1 != r4) goto L2e
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService r1 = r8.this$0
            com.martian.mibook.mvvm.tts.service.TTSReadAloudService.z0(r1)
            goto L2e
        Lbc:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.service.TTSReadAloudService$startTtsTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((TTSReadAloudService$startTtsTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
