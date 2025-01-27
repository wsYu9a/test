package com.martian.alipay.dao;

import com.martian.libsupport.j;

@j.g(name = "alipay_order")
/* loaded from: classes2.dex */
public class AlipayOrder {
    public static final int TRADE_FAIL = -1;
    public static final int TRADE_SUCCESS = 1;
    public static final int TRADE_UNPAY = 0;

    @j.b
    public Long createdOn;

    @j.b
    public String fee_value;

    @j.b
    @j.f
    public String out_trade_no;

    @j.b
    public Integer trade_status;
}
