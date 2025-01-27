package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.ExchangeDurationParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;

/* loaded from: classes3.dex */
public abstract class k extends com.martian.mibook.lib.account.d.n<ExchangeDurationParams, ExchangeMoney> {
    public k(j1 activity) {
        super(activity, ExchangeDurationParams.class, ExchangeMoney.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ExchangeMoney exchangeMoney) {
        if (exchangeMoney == null) {
            return false;
        }
        return super.onPreDataReceived(exchangeMoney);
    }
}
