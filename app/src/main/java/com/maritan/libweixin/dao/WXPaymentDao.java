package com.maritan.libweixin.dao;

import android.content.Context;
import com.martian.libsupport.j;

/* loaded from: classes2.dex */
public class WXPaymentDao extends j<a> {
    public WXPaymentDao(Context context) {
        super(context, "wxpayments", 2, a.class);
    }

    public a a() {
        a aVar = new a();
        aVar.f9567f = 0;
        if (load((WXPaymentDao) aVar)) {
            return aVar;
        }
        return null;
    }

    public boolean insert(String out_trade_no, String fee_value) {
        a aVar = new a();
        aVar.f9565d = fee_value;
        aVar.f9566e = out_trade_no;
        aVar.f9567f = 0;
        aVar.f9568g = Long.valueOf(System.currentTimeMillis());
        return insert((WXPaymentDao) aVar);
    }

    public boolean updatePaymentFail(String out_trade_no) {
        a aVar = new a();
        aVar.f9566e = out_trade_no;
        aVar.f9567f = -1;
        return update(aVar);
    }

    public boolean updatePaymentSuccess(String out_trade_no) {
        a aVar = new a();
        aVar.f9566e = out_trade_no;
        aVar.f9567f = 1;
        return update(aVar);
    }
}
