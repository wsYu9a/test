package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.WithdrawCommissionLimitationParams;
import com.martian.mibook.lib.account.response.WithdrawCommissionLimitation;

/* loaded from: classes3.dex */
public abstract class u0 extends com.martian.mibook.lib.account.d.n<WithdrawCommissionLimitationParams, WithdrawCommissionLimitation> {
    public u0(j1 activity) {
        super(activity, WithdrawCommissionLimitationParams.class, WithdrawCommissionLimitation.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(WithdrawCommissionLimitation withdrawLimitation) {
        if (withdrawLimitation == null) {
            return false;
        }
        return super.onPreDataReceived(withdrawLimitation);
    }
}
