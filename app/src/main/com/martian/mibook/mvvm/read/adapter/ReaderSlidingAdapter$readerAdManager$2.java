package com.martian.mibook.mvvm.read.adapter;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.b;
import com.martian.mibook.application.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xi.k;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/martian/mibook/application/d;", "invoke", "()Lcom/martian/mibook/application/d;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderSlidingAdapter$readerAdManager$2 extends Lambda implements Function0<d> {
    final /* synthetic */ ReaderSlidingAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderSlidingAdapter$readerAdManager$2(ReaderSlidingAdapter readerSlidingAdapter) {
        super(0);
        this.this$0 = readerSlidingAdapter;
    }

    public static final void invoke$lambda$1$lambda$0(ReaderSlidingAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a a12 = this$0.a1();
        if (a12 != null) {
            a12.R0();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @k
    public final d invoke() {
        d dVar = new d(this.this$0.getActivity(), this.this$0.T0().getSourceString(), MiConfigSingleton.b2().M1().z1(this.this$0.getActivity(), this.this$0.T0().getBook()), this.this$0.T0().getEnableBaeAdInfo());
        dVar.h0(new b.c() { // from class: com.martian.mibook.mvvm.read.adapter.a
            public /* synthetic */ a() {
            }

            @Override // com.martian.mibook.application.b.c
            public final void a() {
                ReaderSlidingAdapter$readerAdManager$2.invoke$lambda$1$lambda$0(ReaderSlidingAdapter.this);
            }
        });
        return dVar;
    }
}
