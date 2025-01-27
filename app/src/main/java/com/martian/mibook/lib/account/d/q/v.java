package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GrabFreshRedpaperParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;

/* loaded from: classes3.dex */
public abstract class v extends com.martian.mibook.lib.account.d.n<GrabFreshRedpaperParams, ExchangeMoney> {
    public v(j1 activity) {
        super(activity, GrabFreshRedpaperParams.class, ExchangeMoney.class);
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
