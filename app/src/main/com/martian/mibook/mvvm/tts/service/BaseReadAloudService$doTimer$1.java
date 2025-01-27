package com.martian.mibook.mvvm.tts.service;

import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.BaseReadAloudService$doTimer$1", f = "BaseReadAloudService.kt", i = {}, l = {TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BaseReadAloudService$doTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseReadAloudService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseReadAloudService$doTimer$1(BaseReadAloudService baseReadAloudService, Continuation<? super BaseReadAloudService$doTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = baseReadAloudService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BaseReadAloudService$doTimer$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:5:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L19
            if (r1 != r4) goto L11
            kotlin.ResultKt.throwOnFailure(r10)
            goto L31
        L11:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L19:
            kotlin.ResultKt.throwOnFailure(r10)
        L1c:
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a r10 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.INSTANCE
            long r5 = r10.j()
            int r10 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r10 <= 0) goto L69
            r9.label = r4
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
            if (r10 != r0) goto L31
            return r0
        L31:
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a r10 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.INSTANCE
            long r5 = r10.j()
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 <= 0) goto L45
            long r5 = r10.j()
            r7 = -1
            long r5 = r5 + r7
            r10.p(r5)
        L45:
            long r5 = r10.j()
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 != 0) goto L59
            com.martian.mibook.mvvm.tts.ReadAloudBook r1 = com.martian.mibook.mvvm.tts.ReadAloudBook.f15003a
            r5 = 0
            r1.J(r5)
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService r1 = r9.this$0
            r6 = 0
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService.W(r1, r5, r4, r6)
        L59:
            com.martian.mibook.mvvm.tts.NonStickyLiveData r1 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.q()
            long r5 = r10.j()
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r1.postValue(r10)
            goto L1c
        L69:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$doTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BaseReadAloudService$doTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
