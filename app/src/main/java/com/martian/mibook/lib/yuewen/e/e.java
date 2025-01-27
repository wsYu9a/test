package com.martian.mibook.lib.yuewen.e;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.yuewen.request.YWBuyBookParams;
import com.martian.mibook.lib.yuewen.response.YWBookPrice;

/* loaded from: classes4.dex */
public abstract class e extends com.martian.mibook.lib.account.d.n<YWBuyBookParams, YWBookPrice> {
    public e(j1 activity) {
        super(activity, YWBuyBookParams.class, YWBookPrice.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(YWBookPrice ywBookPrice) {
        if (ywBookPrice == null) {
            return false;
        }
        return super.onPreDataReceived(ywBookPrice);
    }
}
