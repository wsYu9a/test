package com.martian.mibook.mvvm.payment.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.mozilla.universalchardet.prober.g;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel", f = "VipPayViewModel.kt", i = {0}, l = {g.f29297x}, m = "createWxPrepayOrder", n = {"this"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class VipPayViewModel$createWxPrepayOrder$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VipPayViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPayViewModel$createWxPrepayOrder$1(VipPayViewModel vipPayViewModel, Continuation<? super VipPayViewModel$createWxPrepayOrder$1> continuation) {
        super(continuation);
        this.this$0 = vipPayViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object B;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(this);
        return B;
    }
}
