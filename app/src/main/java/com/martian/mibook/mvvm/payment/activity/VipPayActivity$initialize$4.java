package com.martian.mibook.mvvm.payment.activity;

import com.martian.mibook.mvvm.extensions.ExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l9.i0;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VipPayActivity$initialize$4 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ VipPayActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPayActivity$initialize$4(VipPayActivity vipPayActivity) {
        super(1);
        this.this$0 = vipPayActivity;
    }

    public static final void invoke$lambda$0(VipPayActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VipPayActivity.i2(this$0, false, 1, null);
    }

    public static final void invoke$lambda$1(VipPayActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2(@l Unit unit) {
        VipPayActivity vipPayActivity = this.this$0;
        vipPayActivity.payStatusDialog = i0.x0(vipPayActivity, ExtKt.c("温馨提示"), ExtKt.c("您是否已完成支付?"), ExtKt.c("未支付"), ExtKt.c("支付成功"), false, new i0.l() { // from class: com.martian.mibook.mvvm.payment.activity.a
            public /* synthetic */ a() {
            }

            @Override // l9.i0.l
            public final void a() {
                VipPayActivity$initialize$4.invoke$lambda$0(VipPayActivity.this);
            }
        }, new i0.k() { // from class: com.martian.mibook.mvvm.payment.activity.b
            public /* synthetic */ b() {
            }

            @Override // l9.i0.k
            public final void a() {
                VipPayActivity$initialize$4.invoke$lambda$1(VipPayActivity.this);
            }
        });
    }
}
