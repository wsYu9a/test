package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GetWithdrawLimitationParams;
import com.martian.mibook.lib.account.response.WithdrawLimitation;

/* loaded from: classes3.dex */
public abstract class u extends com.martian.mibook.lib.account.d.n<GetWithdrawLimitationParams, WithdrawLimitation> {
    public u(j1 activity) {
        super(activity, GetWithdrawLimitationParams.class, WithdrawLimitation.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(WithdrawLimitation withdrawLimitation) {
        if (withdrawLimitation == null) {
            return false;
        }
        return super.onPreDataReceived(withdrawLimitation);
    }
}
