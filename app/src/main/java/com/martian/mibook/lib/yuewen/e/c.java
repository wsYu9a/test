package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWBookDiscountParams;
import com.martian.mibook.lib.yuewen.response.TYDiscountList;

/* loaded from: classes4.dex */
public abstract class c extends com.martian.mibook.lib.account.d.f<YWBookDiscountParams, TYDiscountList> {
    public c() {
        super(YWBookDiscountParams.class, TYDiscountList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYDiscountList tyDiscountList) {
        if (tyDiscountList == null || tyDiscountList.getDiscountList() == null) {
            return false;
        }
        return super.onPreDataReceived(tyDiscountList);
    }
}
