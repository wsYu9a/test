package com.martian.mibook.application;

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
@DebugMetadata(c = "com.martian.mibook.application.ReaderThemeManager$delayCheckVipStatus$1", f = "ReaderThemeManager.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReaderThemeManager$delayCheckVipStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReaderThemeManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderThemeManager$delayCheckVipStatus$1(ReaderThemeManager readerThemeManager, Continuation<? super ReaderThemeManager$delayCheckVipStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = readerThemeManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReaderThemeManager$delayCheckVipStatus$1(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        r6 = r5.this$0.d();
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L26
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
            r5.label = r2
            r3 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r6 != r0) goto L26
            return r0
        L26:
            com.martian.mibook.application.MiConfigSingleton r6 = com.martian.mibook.application.MiConfigSingleton.b2()
            boolean r6 = r6.K2()
            if (r6 != 0) goto L3f
            com.martian.mibook.application.ReaderThemeManager r6 = r5.this$0
            com.martian.mibook.mvvm.ui.viewmodel.AppViewModel r6 = com.martian.mibook.application.ReaderThemeManager.a(r6)
            if (r6 == 0) goto L3f
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r6.D0(r0)
        L3f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.application.ReaderThemeManager$delayCheckVipStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderThemeManager$delayCheckVipStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
